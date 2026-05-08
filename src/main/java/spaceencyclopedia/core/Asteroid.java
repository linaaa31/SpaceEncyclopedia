package spaceencyclopedia.core;
import spaceencyclopedia.exception.InvalidSpaceObjectException;

import java.util.ArrayList;

public class Asteroid extends SpaceObject {

    private double diameter;
    private double distanceFromSun;

    public Asteroid(String name, String type, String description,
                    double diameter, double distanceFromSun)
            throws InvalidSpaceObjectException {

        super(name, type, description);

        if (diameter <= 0) {
            throw new InvalidSpaceObjectException("Asteroid diameter must be positive.");
        }

        if (distanceFromSun < 0) {
            throw new InvalidSpaceObjectException("Distance from Sun cannot be negative.");
        }

        this.diameter = diameter;
        this.distanceFromSun = distanceFromSun;
    }

    public double getDiameter() {
        return diameter;
    }

    public double getDistanceFromSun() {
        return distanceFromSun;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nDiameter: " + diameter +
                "\nDistance from Sun: " + distanceFromSun;
    }

    @Override
    public boolean equals(Object otherObject) {

        if (otherObject == null) {
            return false;
        }

        if (getClass() != otherObject.getClass()) {
            return false;
        }

        Asteroid other = (Asteroid) otherObject;

        return super.equals(otherObject)
                && this.diameter == other.diameter
                && this.distanceFromSun == other.distanceFromSun;
    }

}