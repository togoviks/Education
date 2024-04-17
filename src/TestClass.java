import java.util.Random;

public class TestClass {
    private int[][] array = new int[10][10];

    public void fillArray() {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                array[i][j] = random.nextInt(100);
            }
        }
    }

    public void printArray() {
        for (int[] line : array) {
            for (int number : line) {
                System.out.printf("%-2d ", number);
            }
            System.out.println();
        }
    }

    public int getAverage() {
        int sum = 0;
        for (int[] line : array) {
            for (int number : line) {
                sum += number;
            }
        }
        return (sum / (array.length + array[0].length));
    }

    public int getFactorial(int number) {
        if (number == 0) {
            return 1;
        }
        return number * getFactorial(number - 1);
    }

    public int getFibonacciNumber(int index) {
        if (index <= 1) {
            return index;
        }
        return getFibonacciNumber(index - 1) + getFibonacciNumber(index - 2);
    }
}