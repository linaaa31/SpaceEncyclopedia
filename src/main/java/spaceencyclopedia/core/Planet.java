package spaceencyclopedia.core;

public class Planet extends SpaceObject{
    private double radius;
    private double mass;
    private double distanceFromSun;
    private boolean hasRings;
    private int numberOfMoons;
    public Planet(String name, String type, String description, double radius, double mass,
                  double distanceFromSun, boolean hasRings, int numberOfMoons) {
        super(name, type, description);
        this.radius = radius;
        this.mass = mass;
        this.distanceFromSun = distanceFromSun;
        this.hasRings = hasRings;
        this.numberOfMoons = numberOfMoons;
    }
    public Planet(Planet other){
        super(name, type, discription);
        this.radius = other.radius;
        this.mass = other.mass;
        this.mass = other.mass;
        this.distanceFromSun = other.distanceFromSun;
        this.hasRings = other.hasRings;
        this.numberOfMoons = other.numberOfMoons;
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
    public int getNumberOfMoons() {
        return numberOfMoons;
    }

}
