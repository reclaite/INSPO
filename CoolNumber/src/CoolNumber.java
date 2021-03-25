import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

public class CoolNumber {

    private ArrayList<String> numbers = new ArrayList<>();
    private HashSet<String> hashNumbers = new HashSet<>();
    private TreeSet<String> treeNumbers = new TreeSet<>();

    public void generateCoolNumbers() {
        String[] alphabet = {"А", "В", "Е", "К", "М", "Н", "О", "Р", "С", "Т", "У", "Х"};
        Date startDate = new Date();

        for (int l = 1; l < 2; l++) {

            for (String s : alphabet) {
                //первые 2 нуля
                for (int j = 1; j <= 10; j++) {
                    System.out.println(new Formatter().format("%s%03d%s%02d\n", s, j, s + s, l).toString().trim());
                    numbers.add(new Formatter().format("%s%03d%s%02d\n", s, j, s + s, l).toString().trim());
                }

                //буквы и цифры
                for (int j = 111; j <= 999; j += 111) {
                    System.out.println(new Formatter().format("%s%03d%s%02d\n", s, j, s + s, l).toString().trim());
                    numbers.add(new Formatter().format("%s%03d%s%02d\n", s, j, s + s, l).toString().trim());
                }

                //одинаковые цифры
                for (int i = 111; i <= 999; i += 111) {
                    for (String value : alphabet) {
                        for (String item : alphabet) {
                            for (String element : alphabet) {
                                System.out.println(new Formatter().format("%s%03d%s%02d\n", value, i, item + element, l).toString().trim());
                                numbers.add(new Formatter().format("%s%03d%s%02d\n", value, i, item + element, l).toString().trim());
                            }
                        }
                    }
                }
            }

        }
        hashNumbers.addAll(numbers);
        treeNumbers.addAll(numbers);

        Date completeDate = new Date();
        System.out.println("Все номера сгенерированы!");
        System.out.println("Процесс занял " + (completeDate.getTime() - startDate.getTime()) + " мс");
        System.out.println("Зарегистрировано " + numbers.size() + " комбинаций номеров");
    }

    public void bruteForce(String sign) {
        Date startDate = new Date();
        boolean isFound = numbers.stream().anyMatch(number -> number.equals(sign));
        Date completeDate = new Date();
        System.out.println("Поиск перебором: номер " + (isFound ? "" : "не ") + "найден, поиск занял " + (completeDate.getTime() - startDate.getTime()) + " мс");
    }

    public void hashSetSearch(String sign) {
        Date startDate = new Date();
        boolean isFound = hashNumbers.stream().anyMatch(number -> number.equals(sign));
        Date completeDate = new Date();
        System.out.println("Поиск в HashSet: номер " + (isFound ? "" : "не ") + "найден, поиск занял " + (completeDate.getTime() - startDate.getTime()) + " мс");
    }

    public void treeSetSearch(String sign) {
        Date startDate = new Date();
        boolean isFound = treeNumbers.stream().anyMatch(number -> number.equals(sign));
        Date completeDate = new Date();
        System.out.println("Поиск в TreeSet: номер " + (isFound ? "" : "не ") + "найден, поиск занял " + (completeDate.getTime() - startDate.getTime()) + " мс");
    }
}
