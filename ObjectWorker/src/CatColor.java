import java.util.Random;

public enum CatColor {

    RED("Красный"),
    ORANGE("Оранжевый"),
    BLACK("Черный"),
    WHITE("Белый"),
    BROWN("Коричневый"),
    GRAY("Серый");

    String name;

    CatColor(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static <T extends Enum<?>> T getRandomColor(){
        Random random = new Random();
        Class<CatColor> cc = CatColor.class;
        int x = random.nextInt(cc.getEnumConstants().length);
        return (T) cc.getEnumConstants()[x];
    }
}
