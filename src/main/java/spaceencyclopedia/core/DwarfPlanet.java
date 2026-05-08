package spaceencyclopedia.core;

import spaceencyclopedia.exception.InvalidSpaceObjectException;

public class DwarfPlanet extends Planet {

    public enum Region {
        KUIPER_BELT,
        ASTEROID_BELT,
        OUTER_SOLAR_SYSTEM
    }
    private Region region;

    public DwarfPlanet(String name, String type, String description, double radius, double mass, double distanceFromSun,
                       boolean hasRings, int numberOfMoons, Region region) throws InvalidSpaceObjectException {
        super(name, type, description, radius, mass, distanceFromSun, hasRings, numberOfMoons);
        if (region == null) {
            throw new InvalidSpaceObjectException("Region cannot be null.");
        }
        this.region = region;
    }

    public DwarfPlanet(DwarfPlanet other) throws InvalidSpaceObjectException {
        super(other);
        this.region = other.region;
    }

    public Region getRegion() {
        return region;
    }

    public String toString() {
        return super.toString() +
                "\nRegion: " + region;
    }
}