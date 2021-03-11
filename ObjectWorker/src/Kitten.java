public class Kitten extends Cat {

    public Kitten() {
        super();
    }

    public Kitten(String name) {
        super(name);
        setWeights();
    }

    public Kitten(String name, int weight) {
        super(name, weight);
    }

    private void setWeights() {
        super.minWeight = 400;
        super.maxWeight = 3000;
    }

    public void bringVomit() {
        int difference = random.randomInRange(300, 500);
        setWeight(getWeight() - difference);
        System.out.println("Котёнок " + getName() + " обрыгался. Текущий вес кота - " + getWeight() + " (-" + difference + ")");
    }

    public void feedCat() {
        if (!super.isAlive()) return;
        int difference = random.randomInRange(75, 150);
        setWeight(getWeight() + difference);
        System.out.println("Кот " + getName() + " покормлен! Текущий вес кота - " + getWeight() + " (+" + difference + ")");
    }

    public void milkFeed() {
        int difference = random.randomInRange(50, 150);
        setWeight(getWeight() + difference);
        System.out.println("Котёнок " + getName() + " покормлен молоком. Текущий вес кота - " + getWeight() + " (+" + difference + ")");
    }

    public String getKittenColor() {
        return super.getCatColor();
    }

}
