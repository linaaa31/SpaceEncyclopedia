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
    /**
     * Returns the radius of the satellite.
     */
    public double getRadius() {
        return radius;
    }
    /**
     * Returns the distance from the parent planet.
     */
    public double getDistanceFromPlanet() {
        return distanceFromPlanet;
    }
    /**
     * Returns true if the satellite is natural.
     */
    public boolean isNatural() {
        return natural;
    }
    /**
     * Returns the parent planet of the satellite.
     */
    public String getParentPlanet() {
        return parentPlanet;
    }
    /**
     * Returns the overview of the satellite.
     */
    public String getOverview() {
        return overview;
    }
    /**
     * Returns discovery information about the satellite.
     */
    public String getDiscovery() {
        return discovery;
    }

    /**
     * Returns exploration information about the satellite.
     */
    public String getExploration() {
        return exploration;
    }
    /**
     * Returns interesting facts about the satellite.
     */
    public String getInterestingFacts() {
        return interestingFacts;
    }
    /**
     * Returns satellite information as a string.
     */
    public String toString() {
        return getName() + " (" + getType() + ")\n" + "Description: " + getDescription() + "\n" + "Parent Planet: " + parentPlanet + "\n" + "Radius: " + radius + " km\n" +
                "Distance from planet: " + distanceFromPlanet + " km\n" + "Natural satellite: " + natural + "\n" + "Overview: " + overview + "\n" +
                "Discovery: " + discovery + "\n" + "Exploration: " + exploration + "\n" + "Interesting Facts: " + interestingFacts;
    }
}