package spaceencyclopedia.manager;
import spaceencyclopedia.core.SpaceObject;

import java.util.ArrayList;

public class FavoritesManager {
    private ArrayList<SpaceObject> favorites;

    public FavoritesManager() {
        favorites = new ArrayList<>();
    }

    public void addFavorite(SpaceObject object) {
        if (!favorites.contains(object)) {
            favorites.add(object);
        }
    }

    public void removeFavorite(SpaceObject object) {
        favorites.remove(object);
    }

    public void printFavorites() {
        for (SpaceObject object : favorites) {
            System.out.println(object);
            System.out.println("-----------");
        }
    }
}
