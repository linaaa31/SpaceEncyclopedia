package spaceencyclopedia.core;

import spaceencyclopedia.exception.InvalidSpaceObjectException;

import java.util.ArrayList;

public class Planet extends SpaceObject{
    private double radius;
    private double mass;
    private double distanceFromSun;
    private boolean hasRings;
    private int numberOfSatellites;
    private ArrayList<Satellite> satellites;
    public Planet(String name, String type, String description, double radius, double mass,
                  double distanceFromSun, boolean hasRings, int numberOfSatellites) throws InvalidSpaceObjectException {
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
            throw new InvalidSpaceObjectException("Number of moons cannot be negative.");
        }
        this.radius = radius;
        this.mass = mass;
        this.distanceFromSun = distanceFromSun;
        this.hasRings = hasRings;
        this.numberOfSatellites = numberOfSatellites;
        this.satellites = new ArrayList<>();
    }
    public Planet(Planet other) throws InvalidSpaceObjectException{
        super(other.getName(), other.getType(), other.getDescription());
        this.radius = other.radius;
        this.mass = other.mass;
        this.distanceFromSun = other.distanceFromSun;
        this.hasRings = other.hasRings;
        this.numberOfSatellites = other.numberOfSatellites;
        this.satellites = new ArrayList<>(other.satellites);
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
    public double getMass(){
        return mass;
    }
    public double getDistanceFromSun(){
        return distanceFromSun;
    }
    public boolean getHasRings() {
        return hasRings;
    }
    public int getNumberOfSatellites() {
        return numberOfSatellites;
    }


    public String toString() {
        return super.toString() +
                "\nRadius: " + radius +
                "\nMass: " + mass +
                "\nDistance from Sun: " + distanceFromSun
                + "\nHas rings: " + hasRings
                + "\nNumber of moons: " + numberOfSatellites
                + "\nSatellites: " + satellites;
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
                && this.numberOfSatellites == other.numberOfSatellites
                && this.satellites.equals(other.satellites);

    }
}
