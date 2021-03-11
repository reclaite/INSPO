import java.util.Random;

public class Cat {
    private String name;
    private int weight;
    private boolean isAlive = true;
    private CatDeathCause cause;
    private CatColor color;
    int minWeight = 600;
    int maxWeight = 5000;
    CustomRandom random = new CustomRandom();

    public Cat() {
        weight = 1000 + new Random().nextInt(1501);
        color = CatColor.getRandomColor();
        announceCatBorn();
    }

    public Cat(String name) {
        this.name = name;
        color = CatColor.getRandomColor();
        weight = 1000 + new Random().nextInt(1501);
        announceCatBorn();
    }

    public Cat(String name, int weight) {
        this.name = name;
        this.weight = weight;
        color = CatColor.getRandomColor();
        announceCatBorn();
    }

    private void announceCatBorn() {
        System.out.println("Кот " + name + " родился! Его вес составляет " + weight);
        System.out.println("Цвет кота >> " + color.getName());
    }

    String getCatColor() {
        return color.getName();
    }

    public void feedCat() {
        if (!isAlive) return;
        int difference = random.randomInRange(75, 150);
        weight += difference;
        System.out.println("Кот " + name + " покормлен! Текущий вес кота - " + weight + " (+" + difference + ")");
        if (weight >= maxWeight)
            blowCat();
    }

    public void poopCat() {
        if (!isAlive) return;
        int difference = random.randomInRange(75, 150);
        weight -= difference;
        System.out.println("Кот " + name + " сходил в туалет! Текущий вес кота - " + weight + " (-" + difference + ")");
        if (weight <= minWeight)
            hungerCat();
    }

    public void meowCat() {
        if (!isAlive) return;
        weight--;
        System.out.println("Кот " + name + " мяукнул! Текущий вес кота - " + weight + " (-1)");
        if (weight <= minWeight)
            soMeowCat();
    }

    public void blowCat() {
        isAlive = false;
        setCause(CatDeathCause.OVERWEIGHT);
        announceDeathCause();
    }

    public void hungerCat() {
        isAlive = false;
        setCause(CatDeathCause.HUNGER);
        announceDeathCause();
    }

    public void soMeowCat() {
        isAlive = false;
        setCause(CatDeathCause.MEOWPOCALYPSE);
        announceDeathCause();
    }

    public void announceDeathCause() {
        System.out.println("К сожалению, кот " + name + " умер...\nПричина смерти - " + cause.getName());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public CatDeathCause getCause() {
        return cause;
    }

    public void setCause(CatDeathCause cause) {
        this.cause = cause;
    }

    boolean isAlive() {
        return isAlive;
    }
}
