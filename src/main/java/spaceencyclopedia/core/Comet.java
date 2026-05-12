package spaceencyclopedia.core;

import spaceencyclopedia.exception.InvalidSpaceObjectException;

public class Comet extends SpaceObject {

    private String overview;

    private String originInfo;

    private String tailInfo;

    private String scientificImportance;

    private String interestingFacts;

    private double orbitalPeriod;

    private boolean visibleFromEarth;
    private String imagePath;

    public Comet(String name, String type, String description, String overview, String originInfo, String tailInfo, String scientificImportance,
                 String interestingFacts, double orbitalPeriod, boolean visibleFromEarth, String imagePath) throws InvalidSpaceObjectException {
        super(name, type, description);

        if (orbitalPeriod <= 0) {
            throw new InvalidSpaceObjectException("Orbital period must be positive.");
        }

        this.overview = overview;
        this.originInfo = originInfo;
        this.tailInfo = tailInfo;
        this.scientificImportance = scientificImportance;
        this.interestingFacts = interestingFacts;
        this.orbitalPeriod = orbitalPeriod;
        this.visibleFromEarth = visibleFromEarth;
        this.imagePath = imagePath;
    }
    /**
     * Returns the overview of the comet.
     */
    public String getOverview() {
        return overview;
    }
    /**
     * Returns the origin information of the comet.
     */
    public String getOriginInfo() {
        return originInfo;
    }
    /**
     * Returns information about the comet’s tail.
     */
    public String getTailInfo() {
        return tailInfo;
    }
    /**
     * Returns the scientific importance of the comet.
     */
    public String getScientificImportance() {
        return scientificImportance;
    }

    /**
     * Returns interesting facts about the comet.
     */
    public String getInterestingFacts() {
        return interestingFacts;
    }
    /**
     * Returns the orbital period of the comet.
     */
    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }
    /**
     * Returns true if the comet is visible from Earth.
     */
    public boolean isVisibleFromEarth() {
        return visibleFromEarth;
    }
    /**
     * Returns the image path of the comet.
     */
    public String getImagePath() {
        return imagePath;
    }
}