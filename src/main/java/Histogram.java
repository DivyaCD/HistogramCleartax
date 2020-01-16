import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Histogram {

    static int noOfBuckets = 0;
    static List<Integer> numbers = new ArrayList<>();

    public static void main(String[] args) {

        readInputFile();
        sortInputNumbers(numbers);
//        Collections.sort(numbers);
        printOutput();
    }

    public static void sortInputNumbers(List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {

            for (int j = numbers.size() - 1; j > i; j--) {
                if (numbers.get(i) > numbers.get(j)) {

                    int tmp = numbers.get(i);
                    numbers.set(i,numbers.get(j)) ;
                    numbers.set(j,tmp);

                }
            }
        }
    }

    private static void printOutput() {
        int currentBucketCounter = 1;
        int currentBucket = 1;
        int maxValue = numbers.get(numbers.size() - 1);
        int counter = 0;
        int count = 0;
        int sum = 0;

        while (currentBucketCounter * noOfBuckets < maxValue) {

            while (counter < numbers.size() && numbers.get(counter) <= currentBucketCounter * noOfBuckets)
                counter++;
            System.out.println(currentBucket + " to " + currentBucketCounter * noOfBuckets + ": " + (counter - count));
            count = counter;
            currentBucket=currentBucketCounter* noOfBuckets+1;
            currentBucketCounter++;
            sum += count;
        }


        if (sum != numbers.size()) {
            while (counter < numbers.size() && numbers.get(counter) <= currentBucketCounter * noOfBuckets)
                counter++;
            System.out.println(currentBucket + " to " + currentBucketCounter * noOfBuckets + ": " + (counter - count));
        }
    }

    private static void readInputFile() {
        String fileName = "input.txt";
        ClassLoader classLoader = new Histogram().getClass().getClassLoader();

        try (Scanner scanner = new Scanner(new File(classLoader.getResource(fileName).getFile()))) {

            while (scanner.hasNext()) {
                if (numbers.isEmpty()) {
                    String[] nos = scanner.nextLine().split(",");
                    for (int i = 0; i < nos.length; i++)
                        numbers.add(Integer.valueOf(nos[i].trim()));
                } else {
                    noOfBuckets = Integer.valueOf(scanner.nextLine());
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
