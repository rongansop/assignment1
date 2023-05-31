// This file contains material supporting section 2.9 of the textbook:
// "Object Oriented Software Engineering" and is issued under the open-source
// license found at http://www.site.uottawa.ca/school/research/lloseng/

import java.io.*;
import design2.PointCP2;

/**
 * This class prompts the user for a set of coordinates, and then 
 * converts them from polar to cartesian or vice-versa.
 *
 * @author Fran&ccedil;ois B&eacute;langer
 * @author Dr Timothy C. Lethbridge
 * @author Paul Holden
 * @version July 2000
 */
public class PointCPTest
{
	public static void main(String[] args) {
        PointCP2 point;

        System.out.println("Cartesian-Polar Coordinates Conversion Program");

        try {
            point = new PointCP2(Double.valueOf(args[0]).doubleValue(),
                    Double.valueOf(args[1]).doubleValue());
        } catch (Exception e) {

            if (args.length != 0)
                System.out.println("Invalid arguments on command line");

            try {
                point = getInput();
            } catch (IOException ex) {
                System.out.println("Error getting input. Ending program.");
                return;
            }
        }
        System.out.println("\nYou entered:\n" + point);
        point.convertStorageToCartesian();
        System.out.println("\nAfter asking to store as Cartesian:\n" + point);
        point.convertStorageToPolar();
        System.out.println("\nAfter asking to store as Polar:\n" + point);
    }

    private static PointCP2 getInput() throws IOException {
        byte[] buffer = new byte[1024]; // Buffer to hold byte input
        boolean isOK = false; // Flag set if input correct
        String theInput = ""; // Input information

        double rho = 0.0;
        double theta = 0.0;

        for (int i = 0; i < 2; i++) {
            while (!(isOK)) {
                isOK = true; // flag set to true assuming input will be valid

                // Prompt the user
                System.out.print("Enter the value of " + (i == 0 ? "Rho " : "Theta ") + "using a decimal point(.): ");

                for (int k = 0; k < 1024; k++)
                    buffer[k] = '\u0020';

                System.in.read(buffer);
                theInput = new String(buffer).trim();

                // Verify the user's input
                try {
                    if (i == 0) // First argument
                    {
                        rho = Double.valueOf(theInput).doubleValue();
                    } else // Second argument
                    {
                        theta = Double.valueOf(theInput).doubleValue();
                    }
                } catch (Exception e) {
                    System.out.println("Incorrect input");
                    isOK = false; // Reset flag as so not to end while loop
                }
            }

            // Reset flag so while loop will prompt for other arguments
            isOK = false;
        }
        // Return a new PointCP2 object
        return (new PointCP2(rho, theta));
    }
}
