package design5;

public class PolarPointCP5 extends PointCP5 {

private double rho;
private double theta;

public PolarPointCP5(double rho, double theta) {
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
double x = getX();
double y = getY();
CartesianPointCP5 cartesianPoint = new CartesianPointCP5(x, y);
cartesianPoint.convertStorageToCartesian();
this.rho = cartesianPoint.getRho();
this.theta = cartesianPoint.getTheta();
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