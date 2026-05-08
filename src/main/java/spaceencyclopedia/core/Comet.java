package spaceencyclopedia.core;

import spaceencyclopedia.exception.InvalidSpaceObjectException;

public class Comet extends SpaceObject {

    private double orbitalPeriod;
    private boolean visibleFromEarth;

    public Comet(String name, String type, String description,
                 double orbitalPeriod, boolean visibleFromEarth)
            throws InvalidSpaceObjectException {

        super(name, type, description);

        if (orbitalPeriod <= 0) {
            throw new InvalidSpaceObjectException("Orbital period must be positive.");
        }

        this.orbitalPeriod = orbitalPeriod;
        this.visibleFromEarth = visibleFromEarth;
    }

    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public boolean isVisibleFromEarth() {
        return visibleFromEarth;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nOrbital Period: " + orbitalPeriod +
                "\nVisible From Earth: " + visibleFromEarth;
    }

    @Override
    public boolean equals(Object otherObject) {

        if (otherObject == null) {
            return false;
        }

        if (getClass() != otherObject.getClass()) {
            return false;
        }

        Comet other = (Comet) otherObject;

        return super.equals(otherObject)
                && this.orbitalPeriod == other.orbitalPeriod
                && this.visibleFromEarth == other.visibleFromEarth;
    }
}