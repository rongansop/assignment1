import design1.*;
import design2.*;
import design3.*;
import design5.*;

public class PointCPPerformanceTest {

    private static final int ITERATIONS = 10000000;

    public static void main(String[] args) {

        // PointCP Performance Test
        long start = System.currentTimeMillis();
        for (int i = 0; i < ITERATIONS; i++) {
            PointCP point = new PointCP('C', i, i);
            point.getX();
            point.getY();
            point.getRho();
            point.getTheta();
            point.rotatePoint(i);
        }
        long end = System.currentTimeMillis();
        System.out.println("PointCP performance: " + (end - start) + " ms");

        // PointCP2 Performance Test
        start = System.currentTimeMillis();
        for (int i = 0; i < ITERATIONS; i++) {
            PointCP2 point = new PointCP2(i, i);
            point.getX();
            point.getY();
            point.getRho();
            point.getTheta();
            point.rotatePoint(i);
        }
        end = System.currentTimeMillis();
        System.out.println("PointCP2 performance: " + (end - start) + " ms");

        // PointCP3 Performance Test
        start = System.currentTimeMillis();
        for (int i = 0; i < ITERATIONS; i++) {
            PointCP3 point = new PointCP3(i, i);
            point.getX();
            point.getY();
            point.getRho();
            point.getTheta();
            point.rotatePoint(i);
        }
        end = System.currentTimeMillis();
        System.out.println("PointCP3 performance: " + (end - start) + " ms");

        // PointCP5 Performance Test
        start = System.currentTimeMillis();
        for (int i = 0; i < ITERATIONS; i++) {
            PointCP5 point2 = new PointCP5.PointCP2(i, i);
            point2.getX();
            point2.getY();
            point2.getRho();
            point2.getTheta();
            point2.rotatePoint(i);

            PointCP5 point3 = new PointCP5.PointCP3(i, i);
            point3.getX();
            point3.getY();
            point3.getRho();
            point3.getTheta();
            point3.rotatePoint(i);
        }
        end = System.currentTimeMillis();
        System.out.println("PointCP5 performance: " + (end - start) + " ms");
    }
}
