package spaceencyclopedia.core;

import spaceencyclopedia.exception.InvalidSpaceObjectException;

public class Planet extends SpaceObject{
    private double radius;
    private double mass;
    private double distanceFromSun;
    private boolean hasRings;
    private int numberOfMoons;
    public Planet(String name, String type, String description, double radius, double mass,
                  double distanceFromSun, boolean hasRings, int numberOfMoons) throws InvalidSpaceObjectException {
        super(name, type, description);
        if (radius <= 0) {
            throw new InvalidSpaceObjectException("Planet radius must be positive.");
        }
        if (mass <= 0) {
            throw new InvalidSpaceObjectException("Planet mass must be positive.");
        }
        if (distanceFromSun < 0) {
            throw new InvalidSpaceObjectException("Distance from Sun cannot be negative.");
        }
        if (numberOfMoons < 0) {
            throw new InvalidSpaceObjectException("Number of moons cannot be negative.");
        }
        this.radius = radius;
        this.mass = mass;
        this.distanceFromSun = distanceFromSun;
        this.hasRings = hasRings;
        this.numberOfMoons = numberOfMoons;
    }
    public Planet(Planet other) throws InvalidSpaceObjectException{
        super(other.getName(), other.getType(), other.getDescription());
        this.radius = other.radius;
        this.mass = other.mass;
        this.mass = other.mass;
        this.distanceFromSun = other.distanceFromSun;
        this.hasRings = other.hasRings;
        this.numberOfMoons = other.numberOfMoons;
    }
    public double getRadius() {
        return radius;
    }
    public double getMass(){
        return mass;
    }
    public double getDistanceFromSun(){
        return distanceFromSun;
    }
    public boolean getHasRings() {
        return hasRings;
    }
    public int getNumberOfMoons() {
        return numberOfMoons;
    }

    public String toString() {
        return super.toString() +
                "\nRadius: " + radius + "\nMass: " + mass + "\nDistance from Sun: " + distanceFromSun + "\nHas rings: " + hasRings + "\nNumber of moons: " + numberOfMoons;
    }
    public boolean equals(Object otherObject){
        if(otherObject == null) return false;
        if(getClass() != otherObject.getClass()) {
            return false;
        }
        Planet other = (Planet) otherObject;
        return super.equals(otherObject) &&
                this.radius == other.radius
                && this.mass == other.mass
                && this.distanceFromSun == other.distanceFromSun
                && this.hasRings == other.hasRings
                && this.numberOfMoons == other.numberOfMoons;

    }
}
