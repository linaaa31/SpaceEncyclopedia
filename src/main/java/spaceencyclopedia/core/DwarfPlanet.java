package spaceencyclopedia.core;

import spaceencyclopedia.exception.InvalidSpaceObjectException;

public class DwarfPlanet extends Planet {

    public enum Region {
        KUIPER_BELT,
        ASTEROID_BELT,
        OUTER_SOLAR_SYSTEM
    }
    private Region region;
    /**
     * Creates a dwarf planet object.
     */
    public DwarfPlanet(String name, String type, String description, String overview, String formation, String exploration, String interestingFacts,
                       double radius, double mass, double distanceFromSun, boolean hasRings, int numberOfSatellites, Region region)
            throws InvalidSpaceObjectException {
        super(name, type, description, overview, formation, exploration, interestingFacts, radius, mass, distanceFromSun, hasRings, numberOfSatellites);
        if (region == null) {
            throw new InvalidSpaceObjectException("Region cannot be null.");
        }
        this.region = region;
    }
    /**
     * Copy constructor.
     */
    public DwarfPlanet(DwarfPlanet other) throws InvalidSpaceObjectException {
        super(other);
        this.region = other.region;
    }
    /**
     * Returns the region of the dwarf planet.
     */
    public Region getRegion() {
        return region;
    }
    /**
     * Returns dwarf planet information as a string.
     */
    public String toString() {
        return super.toString() + "\nRegion: " + region;
    }
}