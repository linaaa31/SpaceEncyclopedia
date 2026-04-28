package spaceencyclopedia.core;

import spaceencyclopedia.exception.InvalidSpaceObjectException;

public class Galaxy extends SpaceObject {
    private int numberOfStars;
    private String galaxyType;


    public Galaxy(String name, String type, String description,
                  int numberOfStars, String galaxyType) throws InvalidSpaceObjectException {
        super(name, type, description);
        if (numberOfStars <= 0) {
            throw new InvalidSpaceObjectException("Galaxy's number of stars must be positive.");
        }

        this.numberOfStars = numberOfStars;
        this.galaxyType = galaxyType;

    }

    public int getNumberOfStars() {
        return numberOfStars;
    }

    public String getGalaxyType() {
        return galaxyType;
    }



    public String toString() {
        return super.toString() +
                "\nNumber of stars: " + numberOfStars + "\nGalaxy type: " + galaxyType ;
    }
    public boolean equals(Object otherObject){
        if(otherObject == null) return false;
        if(getClass() != otherObject.getClass()) {
            return false;
        }
        Galaxy other = (Galaxy) otherObject;
        return super.equals(otherObject) &&
                this.numberOfStars == other.numberOfStars

                && this.galaxyType.equals(other.galaxyType);
    }
}