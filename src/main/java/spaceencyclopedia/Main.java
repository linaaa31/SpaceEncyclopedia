package spaceencyclopedia;

import spaceencyclopedia.core.Galaxy;
import spaceencyclopedia.core.Planet;
import spaceencyclopedia.core.SpaceObject;
import spaceencyclopedia.core.Star;
import spaceencyclopedia.exception.InvalidSpaceObjectException;
import spaceencyclopedia.gui.StartPage;
import spaceencyclopedia.manager.EncyclopediaManager;

public class Main {
    public static void main(String[] args) {
        EncyclopediaManager manager = new EncyclopediaManager();
        manager.loadSampleData();
        new StartPage(manager).setVisible(true);
    }
}