package spaceencyclopedia.core;

import spaceencyclopedia.exception.InvalidSpaceObjectException;

public class Satellite extends SpaceObject {
    private double radius;
    private double distanceFromPlanet;
    private boolean natural;

    public Satellite(String name, String type, String description,
                     double radius, double distanceFromPlanet, boolean natural)
            throws InvalidSpaceObjectException {

        super(name, type, description);

        if (radius <= 0) {
            throw new InvalidSpaceObjectException("Satellite radius must be positive.");
        }

        if (distanceFromPlanet < 0) {
            throw new InvalidSpaceObjectException("Distance from planet cannot be negative.");
        }

        this.radius = radius;
        this.distanceFromPlanet = distanceFromPlanet;
        this.natural = natural;
    }
    public double getRadius() {
        return radius;
    }
    public double getDistanceFromPlanet() {
        return distanceFromPlanet;
    }

    public boolean isNatural() {
        return natural;
    }
    @Override
    public String toString() {
        return getName() + " (" + getType() + ")\n" +
                "Description: " + getDescription() + "\n" +
                "Radius: " + radius + " km\n" +
                "Distance from planet: " + distanceFromPlanet + " km\n" +
                "Natural satellite: " + natural;
    }
}


