package spaceencyclopedia.manager;
import spaceencyclopedia.core.Galaxy;
import spaceencyclopedia.core.Planet;
import spaceencyclopedia.core.SpaceObject;
import spaceencyclopedia.core.Star;

import java.util.ArrayList;

public class EncyclopediaManager {
    private ArrayList<SpaceObject> objects;
//    public void loadSampleData() {
//        addObject(new Planet("Earth", "Planet", "The planet we live on.", 6371, 5.97, 149.6, false, 1));
//        addObject(new Planet("Saturn", "Planet", "A gas giant with rings.", 58232, 568, 1434, true, 146));
//        addObject(new Star("Sun", "Star", "The center of our Solar System.", 1.0, 0, 5778));
//        addObject(new Galaxy("Milky Way", "Galaxy", "Our galaxy.", 1000000000, "Spiral", 0));
//    }
    public EncyclopediaManager() {
        objects = new ArrayList<>();
    }

    public void addObject(SpaceObject object) {
        objects.add(object);
    }

    public SpaceObject searchByName(String name) {
        for (SpaceObject object : objects) {
            if (object.getName().equalsIgnoreCase(name)) {
                return object;
            }
        }
        return null;
    }

    public ArrayList<SpaceObject> searchByType(String type) {
        ArrayList<SpaceObject> result = new ArrayList<>();

        for (SpaceObject object : objects) {
            if (object.getType().equalsIgnoreCase(type)) {
                result.add(object);
            }
        }

        return result;
    }

    public ArrayList<Planet> getPlanets() {
        ArrayList<Planet> planets = new ArrayList<>();

        for (SpaceObject object : objects) {
            if (object instanceof Planet) {
                planets.add((Planet) object);
            }
        }

        return planets;
    }

    public ArrayList<Star> getStars() {
        ArrayList<Star> stars = new ArrayList<>();

        for (SpaceObject object : objects) {
            if (object instanceof Star) {
                stars.add((Star) object);
            }
        }

        return stars;
    }

    public ArrayList<Galaxy> getGalaxies() {
        ArrayList<Galaxy> galaxies = new ArrayList<>();

        for (SpaceObject object : objects) {
            if (object instanceof Galaxy) {
                galaxies.add((Galaxy) object);
            }
        }

        return galaxies;
    }

    public void printAllObjects() {
        for (SpaceObject object : objects) {
            System.out.println(object);
            System.out.println("---------");
        }
    }
}