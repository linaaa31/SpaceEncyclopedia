package spaceencyclopedia.core;

import spaceencyclopedia.exception.InvalidSpaceObjectException;

public class Nebula extends SpaceObject {

    private double distanceFromEarth;
    private String nebulaType;
    private boolean starFormingRegion;

    public Nebula(String name, String type, String description, double distanceFromEarth, String nebulaType, boolean starFormingRegion)
            throws InvalidSpaceObjectException {
        super(name, type, description);
        if (distanceFromEarth < 0) {
            throw new InvalidSpaceObjectException(
                    "Distance from Earth cannot be negative."
            );
        }
        if (nebulaType == null || nebulaType.trim().isEmpty()) {
            throw new InvalidSpaceObjectException(
                    "Nebula type cannot be empty."
            );
        }
        this.distanceFromEarth = distanceFromEarth;
        this.nebulaType = nebulaType;
        this.starFormingRegion = starFormingRegion;
    }

    public Nebula(Nebula other)
            throws InvalidSpaceObjectException {
        super(other.getName(), other.getType(), other.getDescription());

        this.distanceFromEarth = other.distanceFromEarth;
        this.nebulaType = other.nebulaType;
        this.starFormingRegion = other.starFormingRegion;
    }

    public double getDistanceFromEarth() {
        return distanceFromEarth;
    }

    public String getNebulaType() {
        return nebulaType;
    }

    public boolean isStarFormingRegion() {
        return starFormingRegion;
    }

    public String toString() {
        return super.toString() +
                "\nDistance from Earth: " + distanceFromEarth +
                "\nNebula Type: " + nebulaType +
                "\nStar Forming Region: " + starFormingRegion;
    }
}