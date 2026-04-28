package spaceencyclopedia.core;

import spaceencyclopedia.exception.InvalidSpaceObjectException;

public class Star extends SpaceObject {
    private double luminosity;
    private double distanceFromEarth;
    private double temperature;

    public Star(String name, String type, String description,
                double luminosity, double distanceFromEarth, double temperature) throws InvalidSpaceObjectException {
        super(name, type, description);
        if (luminosity <= 0) {
            throw new InvalidSpaceObjectException("Star luminosity must be positive.");
        }
        if (distanceFromEarth <= 0) {
            throw new InvalidSpaceObjectException("Star's distanceFromEarth mass must be positive.");
        }
        this.luminosity = luminosity;
        this.distanceFromEarth = distanceFromEarth;
        this.temperature = temperature;
    }

    public double getLuminosity() {
        return luminosity;
    }

    public double getDistanceFromEarth() {
        return distanceFromEarth;
    }

    public double getTemperature() {
        return temperature;
    }

    public String toString() {
        return super.toString() +
                "\nLuminosity: " + luminosity +
                "\nDistance from Earth: " + distanceFromEarth +
                "\nTemperature: " + temperature;
    }
    public boolean equals(Object otherObject){
        if(otherObject == null) return false;
        if(getClass() != otherObject.getClass()) {
            return false;
        }
        Star other = (Star) otherObject;
        return super.equals(otherObject) &&
                this.luminosity == other.luminosity
                && this.distanceFromEarth == other.distanceFromEarth
                && this.temperature == other.temperature;
    }
}