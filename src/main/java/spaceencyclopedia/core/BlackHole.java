package spaceencyclopedia.core;

import spaceencyclopedia.exception.InvalidSpaceObjectException;

public class BlackHole extends SpaceObject{
    private double mass;
    private double distanceFromEarth;
    private boolean supermassive;
    public BlackHole(String name, String type, String description,
                     double mass, double distanceFromEarth,
                     boolean supermassive)
            throws InvalidSpaceObjectException {

        super(name, type, description);

        if (mass <= 0) {
            throw new InvalidSpaceObjectException("Mass must be positive.");
        }

        if (distanceFromEarth < 0) {
            throw new InvalidSpaceObjectException("Distance cannot be negative.");
        }

        this.mass = mass;
        this.distanceFromEarth = distanceFromEarth;
        this.supermassive = supermassive;
    }
    public BlackHole(BlackHole other) throws InvalidSpaceObjectException {
        super(other.getName(), other.getType(), other.getDescription());

        this.mass = other.mass;
        this.distanceFromEarth = other.distanceFromEarth;
        this.supermassive = other.supermassive;
    }
    public double getMass() {
        return mass;
    }

    public double getDistanceFromEarth() {
        return distanceFromEarth;
    }

    public boolean isSupermassive() {
        return supermassive;
    }
    @Override
    public String toString() {
        return super.toString() +
                "\nMass: " + mass +
                "\nDistance from Earth: " + distanceFromEarth +
                "\nSupermassive: " + supermassive;
    }

    @Override
    public boolean equals(Object otherObject) {

        if (otherObject == null) return false;

        if (getClass() != otherObject.getClass()) {
            return false;
        }
        BlackHole other = (BlackHole) otherObject;
        return super.equals(otherObject)
                && this.mass == other.mass
                && this.distanceFromEarth == other.distanceFromEarth
                && this.supermassive == other.supermassive;
    }
}