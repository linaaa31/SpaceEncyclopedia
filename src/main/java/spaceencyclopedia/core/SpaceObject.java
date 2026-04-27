package spaceencyclopedia.core;

import spaceencyclopedia.exception.InvalidSpaceObjectException;

public class SpaceObject {
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
    public SpaceObject(SpaceObject other) {
        this.name = other.name;
        this.type = other.type;
        this.description = other.description;
    }
    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }
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
    public String toString() {
        return "Name: " + name +
                "\nType: " + type +
                "\nDescription: " + description;
    }
}