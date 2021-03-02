package ru.kubsu.main.util;

public class CustomVector {
    private int x;
    private int y;
    private int z;
    private boolean isThreeMetric;

    public CustomVector(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
        isThreeMetric = true;
    }

    public CustomVector(int x, int y) {
        this.x = x;
        this.y = y;
        isThreeMetric = false;
    }

    public boolean isThreeMetric() {
        return isThreeMetric;
    }

    public Integer getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }

    public Integer getZ() {
        return z;
    }

    public double getLength() {
        if (!isThreeMetric) {
            return Math.sqrt(x * x + y * y);
        } else {
            return Math.sqrt(x * x + y * y + z * z);
        }
    }

    public static Integer scalarProduct(CustomVector vector1, CustomVector vector2) {

        int x1 = vector1.getX();
        int y1 = vector1.getY();
        int z1 = 0;

        int x2 = vector2.getX();
        int y2 = vector2.getY();
        int z2 = 0;

        if (vector1.isThreeMetric() != vector2.isThreeMetric()) {
            typeError();
            return 0;
        }

        if (vector1.isThreeMetric()) {
            z1 = vector1.getZ();
            z2 = vector2.getZ();
        }
        return x1 * x2 + y1 * y2 + z1 * z2;
    }

    public static int[] vectorProduct(CustomVector vector1, CustomVector vector2) {
        if(!vector1.isThreeMetric() || !vector2.isThreeMetric()) {
            typeError();
            return new int[]{};
        }
        Integer[] a = {0, vector1.getX(), vector1.getY(), vector1.getZ()};
        Integer[] b = {0, vector2.getX(), vector2.getY(), vector2.getZ()};

        int i = a[2] * b[3] - a[3] * b[2];
        int j = a[3] * b[1] - a[1] * b[3];
        int k = a[1] * b[2] - a[2] * b[1];
        return new int[]{i, j, k};
    }

    public static int mixedProduct(CustomVector vector1, CustomVector vector2, CustomVector vector3) {
        Integer[] a = {0, vector1.getX(), vector1.getY(), vector1.getZ()};
        Integer[] b = {0, vector2.getX(), vector2.getY(), vector2.getZ()};
        Integer[] c = {0, vector3.getX(), vector3.getY(), vector3.getZ()};
        return a[1] * b[2] * c[3] + a[2] * b[3] * c[1] + b[1] * c[2] * a[3] -
                c[1] * b[2] * a[3] - b[1] * a[2] * c[3] - c[2] * b[3] * a[1];
    }

    private static void typeError() {
        System.out.println("ОШИБКА: неприменимая операция");
    }

}
