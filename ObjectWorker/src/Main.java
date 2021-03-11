public class Main {

    public static void main(String[] args) {
        Kitten kitten = new Kitten("Пушок");
        while(kitten.getWeight() <= kitten.maxWeight) {
            kitten.feedCat();
        }
    }
}
