package design5;

public abstract class PointCP5 {
    public abstract double getX();

    public abstract double getY();

    public abstract double getRho();

    public abstract double getTheta();

    public abstract void convertStorageToCartesian();

    public abstract void convertStorageToPolar();

    public double getDistance(PointCP5 point) {
        double deltaX = getX() - point.getX();
        double deltaY = getY() - point.getY();

        return Math.sqrt((Math.pow(deltaX, 2) + Math.pow(deltaY, 2)));
    }

    public PointCP5 rotatePoint(double rotation) {
        double radRotation = Math.toRadians(rotation);
        double newX = (Math.cos(radRotation) * getX()) - (Math.sin(radRotation) * getY());
        double newY = (Math.sin(radRotation) * getX()) + (Math.cos(radRotation) * getY());

        return createPoint(newX, newY);
    }

    public abstract String toString();

    protected abstract PointCP5 createPoint(double x, double y);

    public static class PointCP2 extends PointCP5 {
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
            // No action needed as the coordinates are already in Cartesian form
        }

        public void convertStorageToPolar() {
            // No action needed as the coordinates are already in Polar form
        }

        public String toString() {
            return "Polar [" + getRho() + "," + getTheta() + "]";
        }

        protected PointCP5 createPoint(double x, double y) {
            double rho = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
            double theta = Math.toDegrees(Math.atan2(y, x));
            return new PointCP2(rho, theta);
        }
    }

    public static class PointCP3 extends PointCP5 {
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
            // No action needed as the coordinates are already in Cartesian form
        }

        public void convertStorageToPolar() {
            // No action needed as the coordinates are already in Polar form
        }

        public String toString() {
            return "Cartesian (" + getX() + "," + getY() + ")";
        }

        protected PointCP5 createPoint(double x, double y) {
            return new PointCP3(x, y);
        }
    }
}
