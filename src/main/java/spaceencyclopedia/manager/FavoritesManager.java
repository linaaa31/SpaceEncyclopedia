package spaceencyclopedia.manager;
import spaceencyclopedia.core.SpaceObject;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class FavoritesManager {
    private ArrayList<SpaceObject> favorites;
    private static final String FILE_NAME = "data/favorites.txt";
    public FavoritesManager() {
        favorites = new ArrayList<>();
    }
    public void addFavorite(SpaceObject object) {
        if (!favorites.contains(object)) {
            favorites.add(object);
            saveFavoritesToFile();
        }
    }

    public void removeFavorite(SpaceObject object) {
        favorites.remove(object);
        saveFavoritesToFile();
    }
    private void saveFavoritesToFile() {
        try {
            PrintWriter writer = new PrintWriter(new FileOutputStream(FILE_NAME));
            for (SpaceObject object : favorites) {
                writer.println(object.getName());
            }
            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println("Could not save favorites.");
        }
    }
    public void loadFavoritesFromFile(EncyclopediaManager manager) {
        try {
            Scanner scanner = new Scanner(new FileInputStream(FILE_NAME));
            while (scanner.hasNextLine()) {
                String name = scanner.nextLine();
                SpaceObject object = manager.searchByName(name);
                if (object != null && !favorites.contains(object)) {
                    favorites.add(object);
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Favorites file not found");
        }
    }

    public void printFavorites() {
        for (SpaceObject object : favorites) {
            System.out.println(object);
            System.out.println("-----------");
        }
    }
    public boolean isFavorite(SpaceObject object) {
        return favorites.contains(object);
    }
    public ArrayList<SpaceObject> getFavorites() {
        return favorites;
    }

}
