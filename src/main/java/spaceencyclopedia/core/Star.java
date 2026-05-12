package spaceencyclopedia.core;

import spaceencyclopedia.exception.InvalidSpaceObjectException;

public class Star extends SpaceObject {
    private double radius;
    private double mass;
    private double distanceFromEarth;
    private double temperature;
    private String overview;
    private String composition;
    private String distanceInfo;
    private String galaxyInfo;
    private String structure;
    private String interestingFacts;


    public Star(String name, String type, String description,
                String overview, String composition, String distanceInfo,
                String galaxyInfo, String structure, String interestingFacts,
                double radius, double mass, double temperature,
                double distanceFromEarth)
            throws InvalidSpaceObjectException {
        super(name, type, description);

        if (radius <= 0) {
            throw new InvalidSpaceObjectException("Star radius must be positive.");
        }
        if (mass <= 0) {
            throw new InvalidSpaceObjectException("Star mass must be positive.");
        }
        if (temperature <= 0) {
            throw new InvalidSpaceObjectException("Temperature must be positive.");
        }
        if (distanceFromEarth < 0){
            throw new InvalidSpaceObjectException("Distance from Earth cannot be negative.");
        }

        this.overview = overview;
        this.composition = composition;
        this.distanceInfo = distanceInfo;
        this.galaxyInfo = galaxyInfo;
        this.structure = structure;
        this.interestingFacts = interestingFacts;
        this.radius = radius;
        this.mass = mass;
        this.temperature = temperature;
        this.distanceFromEarth = distanceFromEarth;
    }
    /**
     * Returns the radius of the star.
     */
    public double getRadius() {return radius;}
    /**
     * Returns the mass of the star.
     */
    public double getMass() {return mass;}
    /**
     * Returns the distance from Earth.
     */
    public double getDistanceFromEarth() {
        return distanceFromEarth;
    }
    /**
     * Returns the temperature of the star.
     */
    public double getTemperature() {
        return temperature;
    }

    /**
     * Returns the overview of the star.
     */
    public String getOverview() {return overview;}

    /**
     * Returns information about the star’s composition.
     */
    public String getComposition() {return composition;}
    /**
     * Returns distance information about the star.
     */
    public String getDistanceInfo() {return distanceInfo;}
    /**
     * Returns galaxy information about the star.
     */
    public String getGalaxyInfo() {
        return galaxyInfo;
    }

    /**
     * Returns structure information about the star.
     */
    public String getStructure() {return structure;}
    /**
     * Returns interesting facts about the star.
     */
    public String getInterestingFacts() {return interestingFacts;}
    /**
     * Returns star information as a string.
     */
    public String toString() {
        return super.toString() +
                "\nRadius: " + radius +
                "\nMass: " + mass +
                "\nTemperature: " + temperature +
                "\nDistance from Earth: " + distanceFromEarth;
    }
}