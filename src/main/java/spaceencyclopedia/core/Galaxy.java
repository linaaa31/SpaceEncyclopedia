package spaceencyclopedia.core;

import spaceencyclopedia.exception.InvalidSpaceObjectException;

public class Galaxy extends SpaceObject {
    private int numberOfStars;
    private String galaxyType;
    private double distanceFromEarth;

    public Galaxy(String name, String type, String description,
                  int numberOfStars, String galaxyType, double distanceFromEarth) throws InvalidSpaceObjectException {
        super(name, type, description);
        if (numberOfStars <= 0) {
            throw new InvalidSpaceObjectException("Galaxy's number of stars must be positive.");
        }
        if (distanceFromEarth <= 0) {
            throw new InvalidSpaceObjectException("Galaxy's distanceFromEarth of stars must be positive.");
        }
        this.numberOfStars = numberOfStars;
        this.galaxyType = galaxyType;
        this.distanceFromEarth = distanceFromEarth;
    }

    public int getNumberOfStars() {
        return numberOfStars;
    }

    public String getGalaxyType() {
        return galaxyType;
    }

    public double getDistanceFromEarth() {
        return distanceFromEarth;
    }

    public String toString() {
        return super.toString() +
                "\nNumber of stars: " + numberOfStars + "\nGalaxy type: " + galaxyType + "\nDistance from Earth: " + distanceFromEarth;
    }
}