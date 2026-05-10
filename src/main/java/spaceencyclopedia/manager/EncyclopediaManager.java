package spaceencyclopedia.manager;
import spaceencyclopedia.core.Galaxy;
import spaceencyclopedia.core.Planet;
import spaceencyclopedia.core.SpaceObject;
import spaceencyclopedia.core.Star;
import spaceencyclopedia.core.Asteroid;
import spaceencyclopedia.core.Comet;
import spaceencyclopedia.exception.InvalidSpaceObjectException;

import java.util.ArrayList;

public class EncyclopediaManager {
    private ArrayList<SpaceObject> objects;
    public void loadSampleData() {
try {
    addObject(new Planet("Earth", "Planet",
            "The third planet from the Sun and the only known planet that supports life.",
            "Earth is the third planet from the Sun and the only known world that supports life. " +
                    "Its surface contains oceans, mountains, deserts, forests, rivers, and polar ice caps. " +
                    "About 71 percent of Earth’s surface is covered by water, which is why the planet often " +
                    "appears blue when viewed from space. Earth's atmosphere is mainly composed of nitrogen " +
                    "and oxygen and plays a critical role in protecting life from harmful solar radiation.\n\n" +
                    "Earth rotates on its axis once every 24 hours, creating day and night, and it orbits " +
                    "the Sun once every 365 days. Because Earth's axis is tilted, different parts of the planet " +
                    "receive varying amounts of sunlight during the year, causing the seasons. " +
                    "The planet has one natural satellite, the Moon, which influences ocean tides and helps " +
                    "stabilize Earth's rotation.\n\n" +
                    "Earth is home to millions of species of plants, animals, and microorganisms. " +
                    "Scientists believe life developed in Earth’s oceans billions of years ago and gradually evolved " +
                    "into the diverse ecosystems seen today. Earth is currently the only planet where liquid water, " +
                    "stable temperatures, and a breathable atmosphere exist together in conditions suitable for life.",
            "Earth formed approximately 4.5 billion years ago from clouds of gas and dust left over " +
                    "after the formation of the Sun. During its early history, the young planet experienced intense " +
                    "volcanic activity, asteroid impacts, and extremely high temperatures. Over millions of years, " +
                    "the surface cooled, allowing oceans to form.\n\n" +
                    "Scientists think the Moon formed after a massive collision between the early Earth and a Mars-sized object. " +
                    "This impact released enormous amounts of material into space, which later combined to create the Moon. " +
                    "The development of Earth's atmosphere and magnetic field eventually helped protect the planet " +
                    "and allowed life to appear and evolve.\n\n" +
                    "As Earth continued cooling, continents formed and oceans became stable enough for life to develop. " +
                    "Simple microorganisms eventually evolved into more complex organisms over billions of years. " +
                    "Today Earth remains scientifically important because it is the only known planet with large ecosystems and intelligent life.",
            "Earth is constantly studied using satellites, telescopes, weather stations, deep-sea exploration, " +
                    "and space missions. Thousands of artificial satellites orbit Earth today and are used for communication, " +
                    "navigation, climate monitoring, and scientific research.\n\n" +
                    "Space agencies such as NASA, ESA, and others observe Earth to better understand climate change, " +
                    "natural disasters, oceans, forests, and atmospheric conditions. Earth has also been photographed " +
                    "and studied from the Moon, the International Space Station, and deep-space missions.\n\n" +
                    "Modern exploration technologies allow scientists to map Earth’s oceans, monitor weather systems, " +
                    "study earthquakes and volcanoes, and track changes in polar ice. Space exploration has also provided " +
                    "famous images of Earth from space, including the well-known 'Blue Marble' photograph taken during the Apollo missions.",
            "Earth is the densest planet in the Solar System. " +
                    "It is the only known planet with active plate tectonics and large amounts of liquid water on its surface. " +
                    "Earth’s magnetic field protects the planet from dangerous charged particles coming from the Sun.\n\n" +
                    "The highest point on Earth is Mount Everest, while the deepest known location is the Mariana Trench " +
                    "in the Pacific Ocean. Earth is sometimes called the Blue Planet because water dominates its appearance from space.\n\n" +
                    "A day on Earth is gradually becoming slightly longer over time because of the Moon’s gravitational effects. " +
                    "Earth is also the only planet not named after a Roman or Greek god.",
            6371, 5.97, 149.6, false, 1));

    addObject(new Planet("Mercury", "Planet",
            "The smallest and closest planet to the Sun.",
            "Mercury is the closest planet to the Sun and the smallest planet in the Solar System. " +
                    "Because of its proximity to the Sun, temperatures on Mercury can become extremely hot during the day " +
                    "and extremely cold at night. The planet has a rocky surface filled with craters caused by asteroid impacts.\n\n" +
                    "Mercury has an extremely thin exosphere, so it cannot trap heat like planets with thick atmospheres. " +
                    "Its surface resembles Earth’s Moon because both worlds experienced heavy bombardment early in Solar System history.\n\n" +
                    "A year on Mercury lasts only 88 Earth days, making it the fastest planet to orbit the Sun.",
            "Mercury formed around 4.5 billion years ago from gas and dust surrounding the young Sun. " +
                    "Scientists believe much of its outer material may have been stripped away by enormous collisions early in its history.\n\n" +
                    "Its large metallic core makes Mercury unusually dense for its size. " +
                    "The planet likely formed closer to the Sun where heavier materials were more common.",
            "Mercury has been visited by spacecraft such as Mariner 10 and MESSENGER. " +
                    "These missions mapped the planet’s surface and studied its magnetic field and geology.\n\n" +
                    "Scientists continue studying Mercury to better understand how rocky planets form near stars.",
            "Mercury has the shortest year in the Solar System. " +
                    "Despite being closest to the Sun, it is not the hottest planet — Venus is hotter because of its thick atmosphere.\n\n" +
                    "Mercury also has a weak magnetic field and large cliffs caused by the planet shrinking over time.",
            2439, 0.330, 57.9, false, 0));

    addObject(new Planet("Venus", "Planet",
            "The hottest planet in the Solar System.",
            "Venus is the second planet from the Sun and is often called Earth’s sister planet because of its similar size. " +
                    "However, Venus has an extremely thick atmosphere made mostly of carbon dioxide, creating a powerful greenhouse effect.\n\n" +
                    "Surface temperatures on Venus are hot enough to melt lead, making it the hottest planet in the Solar System. " +
                    "The atmosphere is also filled with clouds of sulfuric acid.\n\n" +
                    "Venus rotates very slowly and in the opposite direction compared to most planets.",
            "Venus formed billions of years ago from material left over after the Sun formed. " +
                    "Scientists think Venus may once have had oceans before its greenhouse effect became uncontrollable.\n\n" +
                    "Over time, rising temperatures caused water to disappear and transformed Venus into a hostile world.",
            "Many Soviet Venera spacecraft successfully landed on Venus and sent back photographs before being destroyed by the heat and pressure.\n\n" +
                    "Modern missions continue studying Venus to understand climate change and atmospheric evolution.",
            "A day on Venus is longer than a year on Venus. " +
                    "The planet spins backward compared to most planets in the Solar System.\n\n" +
                    "Venus is one of the brightest natural objects visible in Earth’s sky and is often called the Morning Star or Evening Star.",
            6051, 4.87, 108.2, false, 0));

    addObject(new Planet("Mars", "Planet",
            "The Red Planet known for its dusty surface and giant volcanoes.",
            "Mars is the fourth planet from the Sun and is commonly called the Red Planet because of iron oxide on its surface. " +
                    "It has deserts, polar ice caps, canyons, and extinct volcanoes.\n\n" +
                    "Mars contains Olympus Mons, the largest volcano in the Solar System, and Valles Marineris, a canyon system thousands of kilometers long.\n\n" +
                    "Scientists believe ancient Mars once had rivers, lakes, and possibly oceans of liquid water.",
            "Mars formed approximately 4.6 billion years ago along with the rest of the Solar System. " +
                    "Over time, the planet lost much of its atmosphere, causing water on the surface to disappear.\n\n" +
                    "Today Mars is cold and dry, though frozen water still exists at the poles and underground.",
            "Mars has been explored by many robotic missions including Spirit, Opportunity, Curiosity, and Perseverance.\n\n" +
                    "Scientists study Mars to search for signs of ancient microbial life and to prepare for possible future human missions.",
            "A Martian day is very similar to an Earth day, lasting about 24.6 hours. " +
                    "Mars has two small moons named Phobos and Deimos.\n\n" +
                    "Dust storms on Mars can sometimes cover the entire planet for weeks.",
            3389, 0.642, 227.9, false, 2));

    addObject(new Planet("Jupiter", "Planet",
            "The largest planet in the Solar System.",
            "Jupiter is the fifth planet from the Sun and the largest planet in the Solar System. " +
                    "It is a gas giant made mostly of hydrogen and helium and does not have a solid surface like Earth.\n\n" +
                    "Jupiter is famous for its Great Red Spot, a gigantic storm larger than Earth that has existed for centuries. " +
                    "The planet also has faint rings and an extremely powerful magnetic field.\n\n" +
                    "Jupiter has over 100 confirmed moons, including Ganymede, the largest moon in the Solar System.",
            "Jupiter formed around 4.5 billion years ago from gas and dust left over after the Sun formed. " +
                    "Because of its enormous gravity, Jupiter played a major role in shaping the Solar System.\n\n" +
                    "Scientists believe Jupiter may have helped protect inner planets by attracting or deflecting many asteroids and comets.",
            "Jupiter has been explored by spacecraft such as Pioneer, Voyager, Galileo, Juno, and others. " +
                    "The Juno mission continues studying Jupiter’s atmosphere, gravity, and magnetic field.\n\n" +
                    "Scientists are especially interested in Jupiter’s icy moons because some may contain underground oceans.",
            "Jupiter is so massive that more than 1,300 Earths could fit inside it. " +
                    "Its magnetic field is the strongest of any planet in the Solar System.\n\n" +
                    "A day on Jupiter lasts only about 10 hours, making it the fastest rotating planet.",
            69911, 1898, 778.5, true, 101));

    addObject(new Planet("Saturn", "Planet",
            "The famous ringed planet of the Solar System.",
            "Saturn is the sixth planet from the Sun and is best known for its spectacular ring system. " +
                    "The rings are made mostly of ice and rocky particles of different sizes.\n\n" +
                    "Like Jupiter, Saturn is a gas giant composed mainly of hydrogen and helium. " +
                    "It is the second largest planet in the Solar System.\n\n" +
                    "Saturn has many moons, including Titan, which possesses a thick atmosphere and lakes of liquid methane.",
            "Saturn formed billions of years ago from the same cloud of gas and dust that created the Solar System. " +
                    "Its rings may have formed from broken moons, comets, or leftover material trapped by Saturn’s gravity.\n\n" +
                    "Scientists continue studying how Saturn and its rings evolved over time.",
            "Saturn has been explored by Pioneer, Voyager, and especially the Cassini spacecraft. " +
                    "Cassini studied Saturn and its moons for more than 13 years.\n\n" +
                    "The mission provided detailed images of the rings and discovered important information about Titan and Enceladus.",
            "Saturn is the least dense planet in the Solar System and could theoretically float in water if there were an ocean large enough.\n\n" +
                    "Its ring system stretches hundreds of thousands of kilometers but is surprisingly thin.",
            58232, 568, 1434, true, 285));

    addObject(new Planet("Uranus", "Planet",
            "An ice giant that rotates on its side.",
            "Uranus is the seventh planet from the Sun and is classified as an ice giant. " +
                    "Its atmosphere contains hydrogen, helium, and methane, which gives the planet its blue-green color.\n\n" +
                    "Unlike most planets, Uranus rotates almost completely on its side. " +
                    "Scientists believe a massive collision long ago may have caused this unusual tilt.\n\n" +
                    "Uranus has faint rings and many moons orbiting around it.",
            "Uranus formed around 4.5 billion years ago in the outer Solar System. " +
                    "Its composition includes icy materials such as water, ammonia, and methane.\n\n" +
                    "The extreme tilt of Uranus may have dramatically affected the planet’s seasons and atmosphere.",
            "The only spacecraft to visit Uranus so far was Voyager 2 in 1986. " +
                    "The mission captured important images and measurements of the planet and its moons.\n\n" +
                    "Scientists hope future missions will explore Uranus in much greater detail.",
            "A season on Uranus lasts about 21 Earth years because of its unusual rotation. " +
                    "The planet is one of the coldest worlds in the Solar System.\n\n" +
                    "Uranus was the first planet discovered using a telescope.",
            25362, 86.8, 2871, true, 29));

    addObject(new Planet("Neptune", "Planet",
            "The farthest major planet from the Sun.",
            "Neptune is the eighth and farthest known planet from the Sun. " +
                    "It is an ice giant with a deep blue atmosphere caused by methane gas.\n\n" +
                    "Neptune experiences extremely powerful winds, some of the fastest in the Solar System. " +
                    "Dark storm systems occasionally appear in its atmosphere.\n\n" +
                    "The planet has rings and many moons, including Triton, which orbits Neptune in the opposite direction of the planet’s rotation.",
            "Neptune formed billions of years ago in the cold outer regions of the Solar System. " +
                    "Its structure is believed to contain icy materials and a dense core.\n\n" +
                    "Scientists think Neptune may have migrated farther away from the Sun during the Solar System’s early history.",
            "Voyager 2 became the first spacecraft to visit Neptune in 1989. " +
                    "The mission revealed detailed images of the planet, its rings, and Triton.\n\n" +
                    "Modern telescopes continue studying Neptune’s changing atmosphere and weather systems.",
            "Neptune has the strongest winds of any planet in the Solar System. " +
                    "A year on Neptune lasts about 165 Earth years.\n\n" +
                    "Triton is one of the coldest known objects in the Solar System and may contain underground oceans.",
            24622, 102, 4495, true, 16));
    addObject(new Star("Sun", "Star",
            "The star at the center of the Solar System.",
            "The Sun is the star at the center of the Solar System. It provides the light and " +
                    "heat that make life on Earth possible.\n\n" +
                    "The Sun contains most of the mass of the Solar System and controls the motion " +
                    "of planets, dwarf planets, asteroids, comets, and other objects through gravity.",
            "The Sun is mainly made of hydrogen and helium. Hydrogen is used in nuclear fusion " +
                    "inside the core, where it is changed into helium. This process releases a huge amount of energy.\n\n" +
                    "Only a small part of the Sun is made of heavier elements such as oxygen, carbon, neon, and iron.",
            "The average distance from Earth to the Sun is about 149.6 million kilometers. " +
                    "This distance is also called one astronomical unit, or 1 AU.\n\n" +
                    "Light from the Sun takes about 8 minutes to reach Earth.",
            "The Sun is located in the Milky Way galaxy. It is not at the center of the galaxy, " +
                    "but in one of its spiral arms. Compared \n with many stars, the Sun is an average-sized star, " +
                    "but it is extremely important for our Solar System.",
            "PHOTOSPHERE\n\n" +
                    "The photosphere is a thin outermost layer of the Sun. " +
                    "Below the photosphere, the Sun becomes opaque. However, " +
                    "the photosphere itself is only slightly less opaque than the air on Earth.\n\n\n" +
                    "CONVECTIVE ZONE\n\n" +
                    "The convective zone carries hot material toward the surface of the Sun. " +
                    "Once the material cools, it sinks back toward the hotter layers below. " +
                    "This continuous movement transfers energy outward.\n\n\n" +
                    "RADIATIVE ZONE\n\n" +
                    "The radiative zone carries the intense heat of the core outward as thermal radiation. " +
                    "Energy moves slowly through this region before reaching the outer layers of the Sun.\n\n\n" +
                    "CORE\n\n" +
                    "The core is the hottest and densest part of the Sun. " +
                    "Nuclear fusion happens here, where hydrogen atoms combine to form helium. " +
                    "This process releases enormous amounts of energy.\n\n\n" +
                    "CORONA\n\n" +
                    "The corona is the outer atmosphere of the Sun. " +
                    "It extends millions of kilometers into space and becomes visible during a solar eclipse. " +
                    "The corona is much hotter than the visible surface of the Sun.",
            "The Sun contains more than 99% of the mass of the Solar System. " +
                    "Light from the Sun takes about 8 minutes to reach Earth.",
            696340, 1.989E30, 5778, 149.6));
    }  catch (InvalidSpaceObjectException e) {
        System.out.println("Error loading sample data: " + e.getMessage());
    }
    }
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
    public ArrayList<Asteroid> getAsteroids() {

        ArrayList<Asteroid> asteroids = new ArrayList<>();

        for (SpaceObject object : objects) {

            if (object instanceof Asteroid) {
                asteroids.add((Asteroid) object);
            }
        }

        return asteroids;
    }
    public ArrayList<Comet> getComets() {

        ArrayList<Comet> comets = new ArrayList<>();

        for (SpaceObject object : objects) {

            if (object instanceof Comet) {
                comets.add((Comet) object);
            }
        }
        return comets;
    }
}