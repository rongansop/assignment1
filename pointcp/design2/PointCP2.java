package design2;

public class PointCP2 {

private double rho;
private double theta;

public PointCP2(double rho, double theta) {
this.rho = rho;
this.theta = theta;
}

public double getX() {
return (Math.cos(Math.toRadians(theta)) * rho);
}

public double getY() {
return (Math.sin(Math.toRadians(theta)) * rho);
}

public double getRho() {
return rho;
}

public double getTheta() {
return theta;
}

public void convertStorageToCartesian() {
// No action required, already in Cartesian coordinates
}

public void convertStorageToPolar() {
// No action required, already in Polar coordinates
}

public double getDistance(PointCP2 pointB) {
double deltaX = getX() - pointB.getX();
double deltaY = getY() - pointB.getY();
return Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2));
}

public PointCP2 rotatePoint(double rotation) {
double radRotation = Math.toRadians(rotation);
double newX = (Math.cos(radRotation) * getX()) - (Math.sin(radRotation) * getY());
double newY = (Math.sin(radRotation) * getX()) + (Math.cos(radRotation) * getY());
return new PointCP2(Math.sqrt(Math.pow(newX, 2) + Math.pow(newY, 2)), Math.toDegrees(Math.atan2(newY, newX)));
}

public String toString() {
return "Stored as Polar [" + getRho() + "," + getTheta() + "]\n";
}
}