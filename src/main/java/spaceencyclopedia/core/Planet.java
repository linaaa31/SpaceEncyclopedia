package spaceencyclopedia.core;

import spaceencyclopedia.exception.InvalidSpaceObjectException;

import java.util.ArrayList;

public class Planet extends SpaceObject {

    private double radius;
    private double mass;
    private double distanceFromSun;
    private boolean hasRings;
    private int numberOfSatellites;
    private String overview;
    private String formation;
    private String exploration;
    private String interestingFacts;

    private ArrayList<Satellite> satellites;

    public Planet(String name, String type, String description, String overview, String formation, String exploration, String interestingFacts,
            double radius, double mass, double distanceFromSun, boolean hasRings, int numberOfSatellites
    ) throws InvalidSpaceObjectException {
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
        if (numberOfSatellites < 0) {
            throw new InvalidSpaceObjectException("Number of satellites cannot be negative.");
        }
        this.overview = overview;
        this.formation = formation;
        this.exploration = exploration;
        this.interestingFacts = interestingFacts;
        this.radius = radius;
        this.mass = mass;
        this.distanceFromSun = distanceFromSun;
        this.hasRings = hasRings;
        this.numberOfSatellites = numberOfSatellites;
        this.satellites = new ArrayList<>();
    }
    /**
     * Copy constructor
     */
    public Planet(Planet other)
            throws InvalidSpaceObjectException {
        super(other.getName(), other.getType(), other.getDescription());
        this.overview = other.overview;
        this.formation = other.formation;
        this.exploration = other.exploration;
        this.interestingFacts = other.interestingFacts;
        this.radius = other.radius;
        this.mass = other.mass;
        this.distanceFromSun = other.distanceFromSun;
        this.hasRings = other.hasRings;
        this.numberOfSatellites = other.numberOfSatellites;
        this.satellites =
                new ArrayList<>(other.satellites);
    }
    /**
     * Adds a satellite to the planet.
     */
    public void addSatellite(Satellite satellite) {
        satellites.add(satellite);
    }
    /**
     * Returns the satellites of the planet.
     */
    public ArrayList<Satellite> getSatellites() {
        return satellites;
    }
    /**
     * Returns the radius of the planet.
     */
    public double getRadius() {
        return radius;
    }

    /**
     * Returns the mass of the planet.
     */
    public double getMass() {
        return mass;
    }
    /**
     * Returns the distance from the Sun.
     */
    public double getDistanceFromSun() {
        return distanceFromSun;
    }
    /**
     * Returns true if the planet has rings.
     */
    public boolean getHasRings() {
        return hasRings;
    }
    /**
     * Returns the number of satellites.
     */
    public int getNumberOfSatellites() {
        return numberOfSatellites;
    }
    /**
     * Returns the overview of the planet.
     */
    public String getOverview() {
        return overview;
    }
    /**
     * Returns information about planet formation.
     */
    public String getFormation() {
        return formation;
    }
    /**
     * Returns information about planet exploration.
     */
    public String getExploration() {
        return exploration;
    }
    /**
     * Returns interesting facts about the planet.
     */
    public String getInterestingFacts() {
        return interestingFacts;
    }
    /**
     * Returns planet information as a string.
     */
    public String toString() {
        return super.toString()
                + "\nOverview: " + overview + "\nFormation: " + formation + "\nExploration: " + exploration
                + "\nInteresting Facts: " + interestingFacts + "\nRadius: " + radius
                + "\nMass: " + mass + "\nDistance from Sun: " + distanceFromSun + "\nHas Rings: " + hasRings
                + "\nNumber of Satellites: " + numberOfSatellites
                + "\nSatellites: " + satellites;
    }

    /**
     * Compares two planet objects for equality.
     */
    public boolean equals(Object otherObject) {
        if (otherObject == null) {
            return false;
        }
        if (getClass() != otherObject.getClass()) {
            return false;
        }
        Planet other = (Planet) otherObject;
        return super.equals(otherObject) && this.overview.equals(other.overview) && this.formation.equals(other.formation)
                && this.exploration.equals(other.exploration) && this.interestingFacts.equals(other.interestingFacts)
                && this.radius == other.radius && this.mass == other.mass && this.distanceFromSun == other.distanceFromSun
                && this.hasRings == other.hasRings && this.numberOfSatellites == other.numberOfSatellites
                && this.satellites.equals(other.satellites);
    }
}