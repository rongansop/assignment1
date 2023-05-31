package design5;

public abstract class PointCP5 {

public abstract double getX();
public abstract double getY();
public abstract double getRho();
public abstract double getTheta();
public abstract void convertStorageToCartesian();
public abstract void convertStorageToPolar();
public abstract double getDistance(PointCP5 pointB);
public abstract PointCP5 rotatePoint(double rotation);

public String toString() {
if (this instanceof CartesianPointCP5) {
CartesianPointCP5 cartesianPoint = (CartesianPointCP5) this;
return "Stored as Cartesian (" + cartesianPoint.getX() + "," + cartesianPoint.getY() + ")\n";
} else if (this instanceof PolarPointCP5) {
PolarPointCP5 polarPoint = (PolarPointCP5) this;
return "Stored as Polar [" + polarPoint.getRho() + "," + polarPoint.getTheta() + "]\n";
} else {
return "Invalid point type.\n";
}
}
}


