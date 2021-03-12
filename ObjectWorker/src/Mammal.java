public interface Mammal {

    default void breatheAnimal() {
        System.out.println("Животное сделало вдох и выдох...");
    }

    void sneezeAnimal();
}
