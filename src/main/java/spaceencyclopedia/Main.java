package spaceencyclopedia;

import spaceencyclopedia.core.Galaxy;
import spaceencyclopedia.core.Planet;
import spaceencyclopedia.core.SpaceObject;
import spaceencyclopedia.core.Star;
import spaceencyclopedia.exception.InvalidSpaceObjectException;
import spaceencyclopedia.manager.EncyclopediaManager;

public class Main {
    public static void main(String[] args) {
        EncyclopediaManager manager = new EncyclopediaManager();

        Planet earth = null;
        Star sun = null;
        Galaxy milkyWay = null;
        try {
             earth = new Planet(
                    "Earth", "Planet", "The planet we live on.", 6371,
                    5.97, 149.6, false, 1);
             sun = new Star(
                     "Sun", "Star", "The star at the center of the Solar System.", 1.0,
                     0, 5778);
            milkyWay = new Galaxy("Milky Way", "Galaxy", "The galaxy that contains our Solar System.",
                    1000000000, "Spiral", 0);
        } catch (InvalidSpaceObjectException e) {
            System.out.println(e.getMessage());
        }

        manager.addObject(earth);
        manager.addObject(sun);
        manager.addObject(milkyWay);

        manager.printAllObjects();

        SpaceObject found = manager.searchByName("Earth");

        if (found != null) {
            System.out.println("Found object:");
            System.out.println(found);
        } else {
            System.out.println("Object not found.");
        }
    }
}