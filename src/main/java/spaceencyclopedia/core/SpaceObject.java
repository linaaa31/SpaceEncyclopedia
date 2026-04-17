package spaceencyclopedia.core;

public class SpaceObject {
    private String name;
    private String type;
    private String description;

    public SpaceObject(String name, String type, String description) {
        this.name = name;
        this.type = type;
        this.description = description;
    }
    public SpaceObject(SpaceObject other){
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
}
