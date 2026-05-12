package spaceencyclopedia.core;

import spaceencyclopedia.exception.InvalidSpaceObjectException;

public abstract class SpaceObject {
    private String name;
    private String type;
    private String description;

    public SpaceObject(String name, String type, String description) throws InvalidSpaceObjectException{
        if (name == null || name.isEmpty()) {
            throw new InvalidSpaceObjectException("Name cannot be empty.");
        }

        if (type == null || type.isEmpty()) {
            throw new InvalidSpaceObjectException("Type cannot be empty.");
        }

        if (description == null || description.isEmpty()) {
            throw new InvalidSpaceObjectException("Description cannot be empty.");
        }
        this.name = name;
        this.type = type;
        this.description = description;
    }
    /**
     * Copy constructor
     */
    public SpaceObject(SpaceObject other) {
        this.name = other.name;
        this.type = other.type;
        this.description = other.description;
    }
    /**
     * Returns the name of the space object.
     */
    public String getName() {
        return name;
    }
    /**
     * Returns the type of the space object.
     */
    public String getType() {
        return type;
    }
    /**
     * Returns the description of the space object.
     */
    public String getDescription() {
        return description;
    }
    /**
     * Compares two space objects for equality.
     */
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        SpaceObject other = (SpaceObject) obj;
        return this.name.equalsIgnoreCase(other.name)
                && this.type.equalsIgnoreCase(other.type);
    }
    /**
     * Returns space object information as a string.
     */
    public String toString() {
        return "Name: " + name +
                "\nType: " + type +
                "\nDescription: " + description;
    }
}