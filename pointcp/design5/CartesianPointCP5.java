package design5;

public class CartesianPointCP5 extends PointCP5 {

private double x;
private double y;

public CartesianPointCP5(double x, double y) {
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
double rho = getRho();
double theta = getTheta();
PolarPointCP5 polarPoint = new PolarPointCP5(rho, theta);
polarPoint.convertStorageToPolar();
this.x = polarPoint.getX();
this.y = polarPoint.getY();
}

public double getDistance(PointCP5 pointB) {
double deltaX = getX() - pointB.getX();
double deltaY = getY() - pointB.getY();
return Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2));
}

public PointCP5 rotatePoint(double rotation) {
double radRotation = Math.toRadians(rotation);
double newX = (Math.cos(radRotation) * getX()) - (Math.sin(radRotation) * getY());
double newY = (Math.sin(radRotation) * getX()) + (Math.cos(radRotation) * getY());
return new CartesianPointCP5(newX, newY);
}
}