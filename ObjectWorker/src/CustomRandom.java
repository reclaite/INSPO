import java.util.Random;

public class CustomRandom {

    public int randomInRange(int min, int max) {
        Random random = new Random();
        int randomInt = random.nextInt(max);
        while (randomInt > min) {
            randomInt = random.nextInt(max);
        }
        return randomInt;
    }
}
