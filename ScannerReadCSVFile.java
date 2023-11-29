import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class ScannerReadCSVFile {
    public void run() {
        // Mr. Jaffe's code to read data from a file
        // Instantiate a File object
        File dataFile = new File("TestScoresByClass.csv");

        // Continue while there's still data in the file to be read
        try (Scanner scanner = new Scanner(dataFile)) {
            // Skip the header
            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }

            // Continue while there's still data in the file to be read
            while (scanner.hasNextLine()) {
                // Read the next line of the file
                String line = scanner.nextLine();

                // line now contains a line of comma-separated numbers
                // representing 10 test scores for each class.
                //
                // Your job is to parse the numbers into individual test scores using
                // another Scanner variable using a comma as the delimiter.
                //
                // Read the ten test scores and average them together.  The first
                // number is the class number and the next 10 numbers are the
                // test scores.
                //
                // You need to compute the average and print for each class the class
                // number, then the average score.  The first few lines should look
                // like this:
                //
                // Class: Avg score
                // 2125:  55
                // 1628:  47
                //
                // Pay attention to the spacing on your output
                //
                // Write your code in the space below!

                // Use another scanner to parse the line with commas as the delimiter
                Scanner lineScanner = new Scanner(line);
                lineScanner.useDelimiter(",");

                // Extract class number
                int classNumber = lineScanner.nextInt();

                // Calculate average of the test scores
                int sum = 0;
                int numberOfScores = 0;
                while (lineScanner.hasNextInt()) {
                    sum += lineScanner.nextInt();
                    numberOfScores++;
                }

                // Calculate and print the average score
                int averageScore = numberOfScores > 0 ? sum / numberOfScores : 0;
                System.out.println("Class: " + classNumber + ": " + averageScore);

                // Close the lineScanner to avoid resource leaks
                lineScanner.close();
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (Exception e) {
            System.out.println("An error occurred. Try using the debugger to find it!");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ScannerReadCSVFile srCsv = new ScannerReadCSVFile();
        srCsv.run();
    }
}


