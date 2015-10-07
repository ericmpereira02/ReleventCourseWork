import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class test {

    public static void main (String[] args) throws FileNotFoundException {
        final File file = new File(args[0]);
        final Scanner fileInput = new Scanner(file);
        fileInput.nextLine();
        while (fileInput.hasNextDouble()) {
            fileInput.nextLine();
           double var = fileInput.nextDouble();
               double x = ((17.312 * Math.log(0.0022727 * var)) + 6.2832);
            System.out.printf("%.0f %s%n",x, .25);
        }
    }
}
