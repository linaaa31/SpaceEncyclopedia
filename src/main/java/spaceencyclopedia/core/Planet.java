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

    public void addSatellite(Satellite satellite) {
        satellites.add(satellite);
        numberOfSatellites = satellites.size();
    }

    public ArrayList<Satellite> getSatellites() {
        return satellites;
    }

    public double getRadius() {
        return radius;
    }

    public double getMass() {
        return mass;
    }

    public double getDistanceFromSun() {
        return distanceFromSun;
    }

    public boolean getHasRings() {
        return hasRings;
    }

    public int getNumberOfSatellites() {
        return numberOfSatellites;
    }

    public String getOverview() {
        return overview;
    }

    public String getFormation() {
        return formation;
    }

    public String getExploration() {
        return exploration;
    }

    public String getInterestingFacts() {
        return interestingFacts;
    }

    public String toString() {
        return super.toString()
                + "\nOverview: " + overview + "\nFormation: " + formation + "\nExploration: " + exploration
                + "\nInteresting Facts: " + interestingFacts + "\nRadius: " + radius
                + "\nMass: " + mass + "\nDistance from Sun: " + distanceFromSun + "\nHas Rings: " + hasRings
                + "\nNumber of Satellites: " + numberOfSatellites
                + "\nSatellites: " + satellites;
    }

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