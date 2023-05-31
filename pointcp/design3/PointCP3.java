package design3;

public class PointCP3 {

private double x;
private double y;

public PointCP3(double x, double y) {
this.x = x;
this.y = y;
}

public double getX() {
return x;
}

public double getY() {
return y;
}

public double getRho() {
return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
}

public double getTheta() {
return Math.toDegrees(Math.atan2(y, x));
}

public void convertStorageToCartesian() {
// No action required, already in Cartesian coordinates
}

public void convertStorageToPolar() {
	double temp = getRho();
    double yOrTheta = getTheta();
    double xOrRho = temp;
    System.out.println("Polar coordinates: (" + xOrRho + ", " + yOrTheta + ")");
}

public double getDistance(PointCP3 pointB) {
double deltaX = getX() - pointB.getX();
double deltaY = getY() - pointB.getY();
return Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2));
}

public PointCP3 rotatePoint(double rotation) {
double radRotation = Math.toRadians(rotation);
double newX = (Math.cos(radRotation) * getX()) - (Math.sin(radRotation) * getY());
double newY = (Math.sin(radRotation) * getX()) + (Math.cos(radRotation) * getY());
return new PointCP3(newX, newY);
}

public String toString() {
return "Stored as Cartesian (" + getX() + "," + getY() + ")\n";
}
}