import java.util.ArrayList;
import java.util.Random;

public class RemoveOddNumbers {
    public static void main(String[] args) {

        ArrayList<Integer> numbers = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            numbers.add(random.nextInt(50) + 1);
        }

        System.out.println("Исходный список: " + numbers);

        for (int i = numbers.size() - 1; i >= 0; i--) {
            if (numbers.get(i) % 2 != 0) {
                numbers.remove(i);
            }
        }

        System.out.println("После удаления нечётных: " + numbers);
    }
}