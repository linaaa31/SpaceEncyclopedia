package spaceencyclopedia.core;

import spaceencyclopedia.exception.InvalidSpaceObjectException;

public class Satellite extends SpaceObject {

    private double radius;
    private double distanceFromPlanet;
    private boolean natural;

    private String parentPlanet;
    private String overview;
    private String discovery;
    private String exploration;
    private String interestingFacts;

    public Satellite(String name, String type, String description, String parentPlanet, String overview, String discovery,
                     String exploration, String interestingFacts, double radius, double distanceFromPlanet, boolean natural) throws InvalidSpaceObjectException {
        super(name, type, description);
        if (radius <= 0) {
            throw new InvalidSpaceObjectException("Satellite radius must be positive.");
        }

        if (distanceFromPlanet < 0) {
            throw new InvalidSpaceObjectException("Distance from planet cannot be negative.");
        }
        this.parentPlanet = parentPlanet;
        this.overview = overview;
        this.discovery = discovery;
        this.exploration = exploration;
        this.interestingFacts = interestingFacts;
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

    public String getParentPlanet() {
        return parentPlanet;
    }

    public String getOverview() {
        return overview;
    }

    public String getDiscovery() {
        return discovery;
    }

    public String getExploration() {
        return exploration;
    }

    public String getInterestingFacts() {
        return interestingFacts;
    }
    public String toString() {
        return getName() + " (" + getType() + ")\n" + "Description: " + getDescription() + "\n" + "Parent Planet: " + parentPlanet + "\n" + "Radius: " + radius + " km\n" +
                "Distance from planet: " + distanceFromPlanet + " km\n" + "Natural satellite: " + natural + "\n" + "Overview: " + overview + "\n" +
                "Discovery: " + discovery + "\n" + "Exploration: " + exploration + "\n" + "Interesting Facts: " + interestingFacts;
    }
}