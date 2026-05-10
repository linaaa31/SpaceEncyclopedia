package spaceencyclopedia.core;

import spaceencyclopedia.exception.InvalidSpaceObjectException;

public class Nebula extends SpaceObject {

    private double distanceFromEarth;
    private String nebulaType;
    private boolean starFormingRegion;
    private String overview;
    private String formation;
    private String importance;
    private String interestingFacts;

    public Nebula(String name, String type, String description,
                  String overview, String formation, String importance,
                  String interestingFacts,
                  double distanceFromEarth, String nebulaType,
                  boolean starFormingRegion)  throws InvalidSpaceObjectException {
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
        this.overview = overview;
        this.formation = formation;
        this.importance = importance;
        this.interestingFacts = interestingFacts;
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

    public String getOverview() {
        return overview;
    }

    public String getFormation() {
        return formation;
    }

    public String getImportance() {
        return importance;
    }

    public String getInterestingFacts() {
        return interestingFacts;
    }

    public String toString() {
        return super.toString() +
                "\nDistance from Earth: " + distanceFromEarth +
                "\nNebula Type: " + nebulaType +
                "\nStar Forming Region: " + starFormingRegion;
    }
}