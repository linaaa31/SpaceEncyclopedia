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

    public Comet(String name,
                 String type,
                 String description,
                 String overview,
                 String originInfo,
                 String tailInfo,
                 String scientificImportance,
                 String interestingFacts,
                 double orbitalPeriod,
                 boolean visibleFromEarth,
                 String imagePath
                 )

            throws InvalidSpaceObjectException {

        super(name, type, description);

        if (orbitalPeriod <= 0) {

            throw new InvalidSpaceObjectException(
                    "Orbital period must be positive."
            );
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

    public String getOverview() {
        return overview;
    }

    public String getOriginInfo() {
        return originInfo;
    }

    public String getTailInfo() {
        return tailInfo;
    }

    public String getScientificImportance() {
        return scientificImportance;
    }

    public String getInterestingFacts() {
        return interestingFacts;
    }

    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public boolean isVisibleFromEarth() {
        return visibleFromEarth;
    }
    public String getImagePath() {
        return imagePath;
    }
}