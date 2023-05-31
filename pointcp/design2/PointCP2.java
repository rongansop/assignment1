package design2;

public class PointCP2 {

//private char typeCoord;
private double xOrRho;
private double yOrTheta;

public PointCP2(double rho, double theta) {
	this.xOrRho = rho;
    this.yOrTheta = theta;
}

public double getX() {
	 return (Math.cos(Math.toRadians(yOrTheta)) * xOrRho);
}

public double getY() {
	return (Math.sin(Math.toRadians(yOrTheta)) * xOrRho);
}

public double getRho() {
return xOrRho;
}

public double getTheta() {
return yOrTheta;
}

public void convertStorageToCartesian() {
	double temp = getX();
    yOrTheta = getY();
    xOrRho = temp;
 
	  System.out.println("Cartesian coordinates: (" + xOrRho + ", " + yOrTheta + ")");
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