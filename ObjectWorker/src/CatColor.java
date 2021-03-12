import java.util.Random;

public enum CatColor {

    RED("Красный"),
    ORANGE("Оранжевый"),
    BLACK("Черный"),
    WHITE("Белый"),
    BROWN("Коричневый"),
    GRAY("Серый"),
    PINK("Розовый");

    String name;

    CatColor(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static CatColor getRandomColor() {
        Random random = new Random();
        return values()[random.nextInt(values().length)];
    }
}
