// This file contains material supporting section 2.9 of the textbook:
// "Object Oriented Software Engineering" and is issued under the open-source
// license found at http://www.site.uottawa.ca/school/research/lloseng/

import java.io.*;
import java.util.Locale;
import java.util.Scanner;
import design2.PointCP2;
import design3.PointCP3;
/**
 * This class prompts the user for a set of coordinates, and then 
 * converts them from polar to cartesian or vice-versa.
 *
 * @author Fran&ccedil;ois B&eacute;langer
 * @author Dr Timothy C. Lethbridge
 * @author Paul Holden
 * @version July 2000
 */
public class PointCPTest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);
        String designChoice = "";

        System.out.println("Cartesian-Polar Coordinates Conversion Program");

        while (!designChoice.equalsIgnoreCase("design2") && !designChoice.equalsIgnoreCase("design3")) {
            System.out.print("Enter the design you want to test (Design2 / Design3): ");
            designChoice = scanner.nextLine();
        }

        if (designChoice.equalsIgnoreCase("design2")) {
            testDesign2();
        } else {
            testDesign3();
        }

        scanner.close();
    }

    private static void testDesign2() {
        PointCP2 point2 = getInputForDesign2();

        System.out.println("\nTesting Design 2 (PointCP2):");
        System.out.println("\nYou entered:\n" + point2);
        point2.convertStorageToPolar();
        System.out.println("\nAfter asking to store as Polar:\n" + point2);
        point2.convertStorageToCartesian();
        System.out.println("\nThis is the point as Cartesian:\n" + point2);
    }

    private static void testDesign3() {
        PointCP3 point3 = getInputForDesign3();

        System.out.println("\nTesting Design 3 (PointCP3):");
        System.out.println("\nYou entered:\n" + point3);
        point3.convertStorageToCartesian();
        System.out.println("\nAfter asking to store as Cartesian:\n" + point3);
        point3.convertStorageToPolar();
        System.out.println("\nThis is the point as Polar:\n" + point3);
    }

    private static PointCP2 getInputForDesign2() {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);

        System.out.print("\nEnter the value of Rho using a decimal point(.): ");
        double rho = scanner.nextDouble();

        System.out.print("Enter the value of Theta using a decimal point(.): ");
        double theta = scanner.nextDouble();

        scanner.close();

        return new PointCP2(rho, theta);
    }

    private static PointCP3 getInputForDesign3() {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);

        System.out.print("\nEnter the value of X using a decimal point(.): ");
        double x = scanner.nextDouble();

        System.out.print("Enter the value of Y using a decimal point(.): ");
        double y = scanner.nextDouble();

        scanner.close();

        return new PointCP3(x, y);
    }
}