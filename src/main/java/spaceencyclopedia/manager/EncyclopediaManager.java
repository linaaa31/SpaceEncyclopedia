package spaceencyclopedia.manager;
import spaceencyclopedia.core.*;
import spaceencyclopedia.exception.InvalidSpaceObjectException;
import spaceencyclopedia.core.Nebula;
import java.util.ArrayList;

public class EncyclopediaManager {
    private ArrayList<SpaceObject> objects;
    public void loadSampleData() {
try {
    Planet earth = new Planet("Earth", "Planet",
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
            6371, 5.97, 149.6, false, 1);
    Satellite moon = new Satellite("Moon", "Satellite",
            "Earth's only natural satellite.",
            "Earth",
            "The Moon is Earth's only natural satellite and the brightest object in the night sky after the Sun. " +
                    "It has a strong influence on Earth, especially because its gravity affects ocean tides. " +
                    "Although the Moon looks bright from Earth, its surface is actually quite dark and reflects only a small part of the sunlight that reaches it.\n\n" +
                    "The Moon is large compared to Earth. It is the largest natural satellite relative to the size of its planet, " +
                    "with about 27 percent of Earth's diameter. Its surface is covered with craters, plains, mountains, dust, and broken rock.",
            "The most accepted explanation for the Moon's origin is the giant impact hypothesis. " +
                    "According to this idea, a Mars-sized body collided with the young Earth. " +
                    "Material thrown into space from this impact later came together and formed the Moon about 4.53 billion years ago.",
            "The Moon has been studied by telescopes, robotic spacecraft, and human missions. " +
                    "NASA's Apollo missions brought astronauts to the lunar surface and returned rock samples to Earth. " +
                    "Modern missions continue studying the Moon's surface, interior, water ice, and possible resources for future exploration.",
            "The Moon's surface is covered by a layer of loose dust and broken rock called regolith. " +
                    "Moonquakes can occur inside the Moon, partly because of tidal forces caused by Earth's gravity. " +
                    "The Moon is also slowly moving away from Earth over time.",
            1737,
            384400,
            true);
    earth.addSatellite(moon);
    addObject(earth);
    addObject(moon);
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


    Planet mars = new Planet("Mars", "Planet",
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
            3389, 0.642, 227.9, false, 2);
    Satellite phobos = new Satellite("Phobos", "Satellite",
            "The larger and closer moon of Mars.",
            "Mars",
            "Phobos is the larger and closer of the two natural satellites of Mars. " +
                    "It is a small irregularly shaped moon with a dark surface covered in craters, dust, and grooves. " +
                    "Phobos orbits extremely close to Mars and moves around the planet faster than Mars rotates.\n\n" +
                    "Because of this unusual orbit, Phobos rises in the west and sets in the east when viewed from the Martian surface. " +
                    "Its surface contains many impact craters, the largest of which is called Stickney Crater.\n\n" +
                    "Scientists believe Phobos may either be a captured asteroid or material left over from the early formation of Mars.",
            "Phobos was discovered in 1877 by the American astronomer Asaph Hall shortly after the discovery of Deimos. " +
                    "The moon was named after Phobos, the Greek god of fear and panic, who accompanied the war god Ares in mythology.\n\n" +
                    "Scientists think Phobos formed billions of years ago. " +
                    "Its origin is still debated because its composition resembles some types of asteroids.",
            "Phobos has been photographed and studied by many spacecraft orbiting Mars, including Viking, Mars Express, MAVEN, and others. " +
                    "These missions helped scientists map its surface and study its internal structure.\n\n" +
                    "Future missions may land on Phobos and return samples to Earth because the moon could provide important information " +
                    "about Mars and the early Solar System.",
            "Phobos is slowly moving closer to Mars because of gravitational forces. " +
                    "Scientists predict that in tens of millions of years it may either crash into Mars or break apart and form a ring system.\n\n" +
                    "Phobos completes one orbit around Mars in only about 7 hours and 39 minutes, making it one of the fastest-orbiting moons in the Solar System.",
            11.3, 9377, true);
    mars.addSatellite(phobos);
    addObject(phobos);
    Satellite deimos = new Satellite("Deimos", "Satellite",
            "The smaller and more distant moon of Mars.",
            "Mars",
            "Deimos is the smaller and outer of the two natural satellites of Mars. " +
                    "It is a small, irregularly shaped moon with a dark surface that looks similar to some asteroids. " +
                    "Unlike Phobos, Deimos orbits farther away from Mars and moves more slowly around the planet.\n\n" +
                    "Deimos has a smoother appearance than Phobos because some of its craters are partly filled with loose surface material. " +
                    "It is much smaller than Earth’s Moon and would appear almost like a bright star from the surface of Mars.\n\n" +
                    "Because Deimos is small and distant, it was difficult to discover and study. " +
                    "Scientists continue to investigate whether it is a captured asteroid or material connected to Mars’s early history.",
            "Deimos was discovered in 1877 by the American astronomer Asaph Hall. " +
                    "He discovered both Martian moons during the same year while observing Mars. " +
                    "The moon was named after Deimos, a figure from Greek mythology associated with dread and terror.\n\n" +
                    "Its origin is still debated. Some scientists think Deimos may have been captured from the asteroid belt, " +
                    "while others suggest that it may have formed from debris after a large impact involving Mars.",
            "Deimos has been photographed and studied by spacecraft that explored Mars, including orbiters and missions that observed the Martian moons. " +
                    "These observations helped scientists understand its shape, surface, orbit, and relationship with Mars.\n\n" +
                    "Future missions, such as Japan’s Martian Moons eXploration mission, are expected to study Phobos and Deimos in more detail. " +
                    "These missions may help explain how the Martian moons formed and what they can reveal about the early Solar System.",
            "Deimos orbits Mars about every 30 hours. " +
                    "Unlike Phobos, which is slowly moving closer to Mars, Deimos is slowly moving farther away from the planet.\n\n" +
                    "Deimos is very small, with a mean radius of about 6.2 kilometers. " +
                    "Its average distance from the center of Mars is about 23,460 kilometers.", 6.2, 23460, true);
    mars.addSatellite(deimos);
    addObject(deimos);
    addObject(mars);
    Planet jupiter = new Planet("Jupiter", "Planet",
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
            69911, 1898, 778.5, true, 101);
    Satellite callisto = new Satellite("Callisto", "Satellite",
            "One of Jupiter's four large Galilean moons.",
            "Jupiter",
            "Callisto is the second largest moon of Jupiter and one of the four Galilean moons discovered by Galileo Galilei. " +
                    "It is heavily covered with craters and is considered one of the oldest surfaces in the Solar System. " +
                    "Unlike some other large moons, Callisto shows little evidence of volcanic or tectonic activity.\n\n" +
                    "Its surface is made mostly of ice and rock, and scientists believe a salty ocean may exist deep beneath its crust. " +
                    "Because Callisto receives less radiation from Jupiter than moons like Europa or Io, it is considered one of the safer locations " +
                    "for possible future exploration in the Jovian system.\n\n" +
                    "Callisto is the third largest moon in the Solar System and is only slightly smaller than the planet Mercury.",
            "Callisto was discovered in 1610 by the Italian astronomer Galileo Galilei together with Io, Europa, and Ganymede. " +
                    "The moon was named after Callisto, a figure from Greek mythology associated with the god Zeus.\n\n" +
                    "Scientists believe Callisto formed from material surrounding Jupiter during the early formation of the Solar System. " +
                    "Its ancient surface preserved the marks of impacts over billions of years because little geological activity has changed it.",
            "Callisto has been studied by spacecraft including Pioneer, Voyager, Galileo, and Juno. " +
                    "These missions provided detailed images of its heavily cratered surface and measurements of its magnetic and internal properties.\n\n" +
                    "The Galileo spacecraft discovered evidence suggesting that Callisto may contain a subsurface ocean beneath its icy crust. " +
                    "Scientists continue studying Callisto because it may help explain the formation of icy moons and giant planets.",
            "Callisto has the most heavily cratered surface of any large moon in the Solar System. " +
                    "One of its largest impact structures is called Valhalla, a huge ring-shaped basin extending thousands of kilometers.\n\n" +
                    "Unlike many other moons, Callisto has almost no major mountains or volcanoes. " +
                    "Its average distance from Jupiter is about 1,882,700 kilometers.",
            2410, 1882700, true);
    jupiter.addSatellite(callisto);
    addObject(callisto);
    Satellite europa = new Satellite("Europa", "Satellite",
            "An icy Galilean moon of Jupiter that may have a subsurface ocean.",
            "Jupiter",
            "Europa is one of Jupiter's four large Galilean moons and is one of the most interesting moons in the Solar System. " +
                    "It is slightly smaller than Earth's Moon and has a bright icy surface covered with long cracks, ridges, and dark streaks. " +
                    "Europa's surface has relatively few large craters, which suggests that it is geologically young compared to many other moons.\n\n" +
                    "Scientists believe Europa may have a deep ocean of salty liquid water beneath its icy crust. " +
                    "Because liquid water is one of the key conditions for life, Europa is considered one of the most important places to study " +
                    "when searching for potentially habitable environments beyond Earth.\n\n" +
                    "Europa is strongly affected by Jupiter's gravity. Tidal forces stretch and squeeze the moon, creating heat inside it. " +
                    "This internal heating may help keep Europa's hidden ocean liquid beneath the frozen surface.",
            "Europa was discovered in 1610 by Galileo Galilei, along with Io, Ganymede, and Callisto. " +
                    "These four moons are called the Galilean moons because Galileo was the first person to observe them with a telescope.\n\n" +
                    "Europa likely formed from material surrounding Jupiter during the early history of the Solar System. " +
                    "Over billions of years, interactions with Jupiter and the other Galilean moons helped shape Europa's orbit, surface, and interior.",
            "Europa has been studied by spacecraft such as Voyager, Galileo, Juno, and telescopes observing from Earth and space. " +
                    "The Galileo spacecraft provided important evidence that Europa may contain a subsurface ocean beneath its icy shell.\n\n" +
                    "NASA's Europa Clipper mission is designed to study Europa in detail during many flybys of Jupiter's moon. " +
                    "The mission will investigate Europa's ice shell, ocean, surface composition, and possible habitability.",
            "Europa has one of the smoothest surfaces of any solid object in the Solar System. " +
                    "Its average distance from Jupiter is about 671,000 kilometers, and it takes about 3.5 Earth days to orbit Jupiter.\n\n" +
                    "Europa is tidally locked to Jupiter, which means the same side of Europa always faces the planet. " +
                    "Although Europa is very cold on the surface, its hidden ocean makes it one of the most exciting worlds for future exploration.",
            1561, 671000, true);
    jupiter.addSatellite(europa);
    addObject(europa);
    Satellite ganymede = new Satellite("Ganymede", "Satellite",
            "The largest moon in the Solar System and one of Jupiter's Galilean moons.",
            "Jupiter",
            "Ganymede is the largest moon in the Solar System and one of the four Galilean moons of Jupiter. " +
                    "It is even larger than the planet Mercury and is the only moon known to have its own magnetic field. " +
                    "Ganymede's surface contains two main types of terrain: dark heavily cratered regions and lighter grooved regions " +
                    "formed by geological activity.\n\n" +
                    "Scientists believe that beneath Ganymede's icy crust there may be several layers of underground salty oceans. " +
                    "Because of its size, internal structure, and magnetic field, Ganymede is considered one of the most scientifically important moons in the Solar System.\n\n" +
                    "The moon is made mostly of rock and water ice. Its surface temperatures are extremely cold, and thin oxygen is present in its very weak atmosphere.",
            "Ganymede was discovered in 1610 by Galileo Galilei together with Io, Europa, and Callisto. " +
                    "The moon was named after Ganymede, a figure from Greek mythology associated with Zeus.\n\n" +
                    "Scientists believe Ganymede formed from material orbiting Jupiter during the early formation of the Solar System. " +
                    "Over time, gravitational interactions and internal heating shaped its interior and surface features.",
            "Ganymede has been explored by spacecraft such as Pioneer, Voyager, Galileo, Juno, and the Hubble Space Telescope. " +
                    "These missions provided detailed images and evidence of subsurface oceans and magnetic activity.\n\n" +
                    "The European Space Agency's JUICE mission was launched to study Jupiter and its icy moons, especially Ganymede. " +
                    "Scientists hope this mission will reveal more about its hidden oceans and potential habitability.",
            "Ganymede is the only moon in the Solar System known to generate its own magnetic field. " +
                    "It has a diameter of about 5,268 kilometers, making it larger than Mercury.\n\n" +
                    "Ganymede orbits Jupiter at an average distance of about 1,070,000 kilometers and takes about seven Earth days to complete one orbit.",
            2634, 1070000, true);
    jupiter.addSatellite(ganymede);
    addObject(ganymede);
    Satellite io = new Satellite("Io", "Satellite",
            "The most volcanically active moon in the Solar System.",
            "Jupiter",
            "Io is the innermost of Jupiter's four large Galilean moons and is the most volcanically active world in the Solar System. " +
                    "Hundreds of volcanoes cover its surface, and some eruptions send lava and volcanic material hundreds of kilometers into space. " +
                    "Its colorful surface is covered with sulfur compounds, lava flows, volcanic plains, and mountains.\n\n" +
                    "Io's extreme volcanic activity is caused by powerful tidal forces from Jupiter and neighboring moons. " +
                    "These forces constantly stretch and squeeze Io, creating enormous internal heat inside the moon. " +
                    "Because of this heating, Io remains geologically active even after billions of years.\n\n" +
                    "Unlike Europa or Ganymede, Io has very little water ice. " +
                    "Instead, it is mostly made of rock and molten material beneath its surface.",
            "Io was discovered in 1610 by Galileo Galilei together with Europa, Ganymede, and Callisto. " +
                    "The moon was named after Io, a figure from Greek mythology associated with Zeus.\n\n" +
                    "Scientists believe Io formed from material orbiting Jupiter during the early formation of the Solar System. " +
                    "Its volcanic activity developed because of strong gravitational interactions with Jupiter and the other Galilean moons.",
            "Io has been explored by spacecraft such as Pioneer, Voyager, Galileo, New Horizons, and Juno. " +
                    "These missions revealed active volcanoes, lava lakes, giant plumes, and rapidly changing surface features.\n\n" +
                    "NASA's Galileo spacecraft provided some of the most detailed observations of Io's volcanoes and surface composition. " +
                    "More recently, the Juno spacecraft performed close flybys that helped scientists study Io's interior and volcanic systems.",
            "Io has more active volcanoes than any other known world in the Solar System. " +
                    "Some lava fountains rise dozens of kilometers above the surface.\n\n" +
                    "Io orbits Jupiter at an average distance of about 421,700 kilometers and completes one orbit in about 1.77 Earth days. " +
                    "Because of tidal locking, the same side of Io always faces Jupiter.",
            1821, 421700, true);
    jupiter.addSatellite(io);
    addObject(io);
    addObject(jupiter);
    Planet saturn = new Planet("Saturn", "Planet",
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
            58232, 568, 1434, true, 285);
    Satellite dione = new Satellite("Dione", "Satellite",
            "An icy moon of Saturn known for its bright cliffs and cratered surface.", "Saturn",
            "Dione is one of Saturn's major icy moons and the fifteenth largest moon in the Solar System. " +
                    "Its surface is covered with impact craters, cliffs, valleys, and bright icy streaks that were once called 'wispy terrain'. " +
                    "Scientists later discovered that these bright features are actually large ice cliffs and fractures in the surface.\n\n" +
                    "Dione is made mostly of water ice with a rocky interior. " +
                    "The moon has both heavily cratered ancient regions and smoother areas that formed later, showing that geological activity once reshaped parts of its surface.\n\n" +
                    "Some evidence suggests that Dione may contain a subsurface liquid ocean deep beneath its icy crust. " +
                    "Because of this, scientists consider Dione one of the interesting icy worlds in Saturn's system.",
            "Dione was discovered in 1684 by the Italian astronomer Giovanni Cassini, who also discovered several other moons of Saturn. " +
                    "The moon was named after Dione, a figure from Greek mythology associated with the Titans.\n\n" +
                    "Scientists believe Dione formed from material orbiting Saturn during the early formation of the Solar System. " +
                    "Over billions of years, impacts and internal activity shaped its current appearance.",
            "Dione has been explored by spacecraft such as Pioneer 11, Voyager 1, Voyager 2, and especially NASA's Cassini spacecraft. " +
                    "Cassini captured highly detailed images of Dione's cliffs, craters, fractures, and icy terrain.\n\n" +
                    "Data collected by Cassini helped scientists study Dione's internal structure and possible underground ocean. " +
                    "The moon continues to be important for understanding the evolution of icy moons around giant planets.",
            "Dione is tidally locked to Saturn, meaning the same side always faces the planet. " +
                    "It orbits Saturn approximately every 2.7 Earth days at a distance similar to the Earth-Moon distance.\n\n" +
                    "Dione has two small co-orbital moons named Helene and Polydeuces that share parts of its orbit around Saturn.",
            562, 377400, true);
    saturn.addSatellite(dione);
    addObject(dione);
    Satellite iapetus = new Satellite("Iapetus", "Satellite",
            "A large moon of Saturn known for its unusual two-tone surface.", "Saturn",
            "Iapetus is the third-largest natural satellite of Saturn and one of the most unusual moons in the Solar System. " +
                    "It is famous for its two-tone appearance: one side is very dark, while the other side is much brighter. " +
                    "Because of this strong contrast, Iapetus is sometimes described as a moon with a light side and a dark side.\n\n" +
                    "The moon is made mostly of ice and rock. Its surface is heavily cratered, showing that it is very old and has been shaped by many impacts. " +
                    "Iapetus also has a strange ridge around much of its equator, making it look different from most other moons.\n\n" +
                    "Iapetus orbits much farther from Saturn than many of Saturn's other large moons. " +
                    "Because of its distant orbit, it gives scientists important information about the outer parts of Saturn's moon system.",
            "Iapetus was discovered in 1671 by the Italian astronomer Giovanni Cassini. " +
                    "Cassini noticed that the moon was easier to see on one side of Saturn than on the other, which later helped scientists understand its unusual bright and dark surface.\n\n" +
                    "Scientists believe Iapetus formed from icy and rocky material around Saturn early in the history of the Solar System. " +
                    "Its ancient surface has preserved impact craters and surface features for billions of years.",
            "Iapetus has been studied by spacecraft such as Voyager 1, Voyager 2, and especially NASA's Cassini spacecraft. " +
                    "Cassini captured detailed images of Iapetus and helped scientists study its dark material, bright icy regions, craters, and equatorial ridge.\n\n" +
                    "The Cassini mission showed that Iapetus has one of the most unusual surfaces among Saturn's moons. " +
                    "Scientists still study Iapetus to understand how its two-color surface and equatorial ridge formed.",
            "Iapetus is sometimes called Saturn's 'yin and yang' moon because of its very dark leading side and much brighter trailing side. " +
                    "Its equatorial ridge gives it a shape that looks different from most round moons.\n\n" +
                    "Iapetus has a mean radius of about 736 kilometers and orbits Saturn at an average distance of about 3,560,000 kilometers.",
            736, 3560000, true);
    saturn.addSatellite(iapetus);
    addObject(iapetus);
    Satellite titan = new Satellite("Titan", "Satellite",
            "The largest moon of Saturn and one of the most Earth-like worlds in the Solar System.", "Saturn",
            "Titan is the largest moon of Saturn and the second largest moon in the Solar System after Ganymede. " +
                    "It is one of the most fascinating worlds in the Solar System because it has a thick atmosphere, rivers, lakes, clouds, and weather systems. " +
                    "Titan's atmosphere is made mostly of nitrogen, similar to Earth's atmosphere, although it is much colder.\n\n" +
                    "Unlike Earth, Titan's lakes and rivers are filled with liquid methane and ethane instead of water. " +
                    "Scientists believe Titan may also contain a hidden subsurface ocean of liquid water beneath its icy crust.\n\n" +
                    "Titan's orange appearance comes from complex organic molecules in its atmosphere. " +
                    "Because Titan contains organic chemistry and liquid systems, scientists consider it one of the most important places " +
                    "for studying conditions that may resemble the early Earth.",
            "Titan was discovered in 1655 by the Dutch astronomer Christiaan Huygens. " +
                    "It was the first known moon of Saturn to be discovered and remains one of the most studied moons in the Solar System.\n\n" +
                    "Scientists believe Titan formed from icy and rocky material orbiting Saturn during the early formation of the Solar System. " +
                    "Over billions of years, Titan developed its thick atmosphere and complex surface systems.",
            "Titan has been explored by Pioneer 11, Voyager 1, Voyager 2, and especially NASA's Cassini spacecraft. " +
                    "The European Space Agency's Huygens probe landed on Titan in 2005, becoming the first spacecraft to land in the outer Solar System.\n\n" +
                    "The Cassini-Huygens mission revealed Titan's lakes, rivers, dunes, clouds, and atmospheric chemistry in great detail. " +
                    "NASA's Dragonfly mission is planned to explore Titan further using a flying robotic drone designed to study its surface and chemistry.",
            "Titan is the only moon in the Solar System with a dense atmosphere. " +
                    "It is also the only world besides Earth known to have stable liquid lakes and rivers on its surface.\n\n" +
                    "Titan orbits Saturn at an average distance of about 1,222,000 kilometers and takes about 16 Earth days to complete one orbit. " +
                    "Its thick atmosphere creates weather patterns including methane rain and seasonal climate changes.",
            2575, 1222000, true);
    saturn.addSatellite(titan);
    addObject(titan);
    Satellite mimas = new Satellite("Mimas", "Satellite",
            "A small icy moon of Saturn known for its giant impact crater.",
            "Saturn",
            "Mimas is one of Saturn's smaller icy moons and is best known for the enormous crater on its surface called Herschel Crater. " +
                    "This crater is so large compared to the size of the moon that Mimas is often compared to the fictional Death Star from Star Wars. " +
                    "The moon's surface is heavily cratered and made mostly of water ice.\n\n" +
                    "Mimas has a cold and ancient surface shaped by billions of years of impacts. " +
                    "Scientists believe the moon may contain more internal structure than previously expected, and some studies suggest it could even contain a hidden subsurface ocean.\n\n" +
                    "Because Mimas is relatively small, its gravity is weak and it has no atmosphere. " +
                    "Its icy surface reflects a large amount of sunlight.",
            "Mimas was discovered in 1789 by the British astronomer William Herschel. " +
                    "The moon was named after Mimas, a giant from Greek mythology.\n\n" +
                    "Scientists believe Mimas formed from icy and rocky material orbiting Saturn early in the history of the Solar System. " +
                    "Its surface has remained mostly unchanged for billions of years because it has little geological activity.",
            "Mimas has been studied by spacecraft including Pioneer 11, Voyager 1, Voyager 2, and NASA's Cassini spacecraft. " +
                    "Cassini provided highly detailed images of Herschel Crater and other surface features.\n\n" +
                    "Recent scientific studies using Cassini data suggested that Mimas may not be completely frozen inside. " +
                    "This possibility has made the moon more scientifically interesting than previously believed.",
            "Herschel Crater is about one-third the diameter of Mimas itself. " +
                    "The impact that created it almost shattered the moon completely.\n\n" +
                    "Mimas orbits Saturn at an average distance of about 185,500 kilometers and takes less than one Earth day to complete one orbit around the planet.",
            198, 185500, true);
    saturn.addSatellite(mimas);
    addObject(mimas);
    addObject(saturn);
    Planet uranus = new Planet("Uranus", "Planet",
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
            25362, 86.8, 2871, true, 29);
    Satellite ariel = new Satellite("Ariel", "Satellite",
            "One of Uranus's largest icy moons known for its bright surface and deep valleys.",
            "Uranus",
            "Ariel is one of the five major moons of Uranus and is considered one of the brightest moons in the Solar System because of its highly reflective icy surface. " +
                    "Its surface contains valleys, cliffs, canyons, ridges, and relatively few large craters compared to many other icy moons.\n\n" +
                    "Scientists believe Ariel experienced geological activity in the past. " +
                    "Parts of its surface appear younger and smoother, suggesting that icy material may once have flowed across the moon. " +
                    "The moon is composed mainly of water ice mixed with rocky material.\n\n" +
                    "Ariel is one of the most geologically interesting moons of Uranus and may have once contained internal heat that reshaped parts of its surface.",
            "Ariel was discovered in 1851 by the British astronomer William Lassell. " +
                    "The moon was named after a spirit character appearing in works by William Shakespeare and Alexander Pope.\n\n" +
                    "Scientists believe Ariel formed from material orbiting Uranus early in the Solar System's history. " +
                    "Over time, impacts and possible internal activity helped create its canyons and smooth plains.",
            "Ariel has only been visited by one spacecraft: NASA's Voyager 2 during its flyby of Uranus in 1986. " +
                    "Voyager 2 captured detailed images showing Ariel's valleys, ridges, icy plains, and relatively young surface.\n\n" +
                    "Scientists continue studying Ariel using telescope observations and Voyager 2 data to better understand icy moons and the Uranian system.",
            "Ariel has one of the brightest surfaces among Uranus's moons because its icy surface reflects a large amount of sunlight. " +
                    "The moon orbits Uranus at an average distance of about 191,000 kilometers and takes about 2.5 Earth days to complete one orbit.\n\n" +
                    "Large fractures and valleys on Ariel may have formed when the moon expanded as internal water froze and changed volume.",
            579, 191000, true);
    uranus.addSatellite(ariel);
    addObject(ariel);
    Satellite titania = new Satellite("Titania", "Satellite",
            "The largest moon of Uranus and one of its five major satellites.", "Uranus",
            "Titania is the largest moon of Uranus and one of the most important moons in the Uranian system. " +
                    "Its surface contains enormous valleys, cliffs, craters, and icy plains formed over billions of years. " +
                    "Scientists believe Titania is made of nearly equal amounts of rock and water ice.\n\n" +
                    "The moon shows evidence of geological activity in the past. " +
                    "Large fault valleys and fractures suggest that Titania may once have expanded internally, causing its surface to crack. " +
                    "Its surface is less heavily cratered than some older moons, which means parts of it may have been resurfaced long ago.\n\n" +
                    "Titania is extremely cold and has a very thin atmosphere containing traces of carbon dioxide. " +
                    "Because of its size and structure, scientists think Titania may possibly contain a subsurface liquid layer deep below its icy crust.",
            "Titania was discovered in 1787 by the British astronomer William Herschel, the same astronomer who discovered Uranus itself. " +
                    "The moon was named after Titania, the queen of the fairies in William Shakespeare's play 'A Midsummer Night's Dream'.\n\n" +
                    "Scientists believe Titania formed from icy and rocky material surrounding Uranus during the early history of the Solar System. " +
                    "Impacts, internal heating, and surface fracturing later shaped the moon's appearance.",
            "Titania has only been visited by one spacecraft: NASA's Voyager 2 during its flyby of Uranus in 1986. " +
                    "Voyager 2 captured images showing giant canyons, cliffs, craters, and icy plains across Titania's surface.\n\n" +
                    "Scientists continue studying Voyager 2 data and telescope observations to better understand Titania's composition, geology, and possible internal structure. " +
                    "Future missions to Uranus may study Titania in much greater detail.",
            "Titania contains one of the largest known canyon systems among Uranus's moons. " +
                    "Some cliffs and valleys extend for hundreds of kilometers across its surface.\n\n" +
                    "Titania orbits Uranus at an average distance of about 436,000 kilometers and takes about 8.7 Earth days to complete one orbit around the planet.",
            789, 436000, true);
    uranus.addSatellite(titania);
    addObject(titania);
    Satellite miranda = new Satellite("Miranda", "Satellite",
            "The smallest and most unusual of Uranus's major moons.",
            "Uranus",
            "Miranda is the smallest and innermost of Uranus's five major moons and is famous for its strange and dramatic surface. " +
                    "Its surface contains enormous cliffs, deep canyons, ridges, terraces, and regions that look completely different from one another. " +
                    "Because of these unusual features, Miranda is often considered one of the strangest moons in the Solar System.\n\n" +
                    "Scientists believe Miranda may have been shattered and reassembled in the distant past because different parts of its surface appear very different in age and structure. " +
                    "Large fault canyons and steep cliffs suggest that geological activity once reshaped much of the moon.\n\n" +
                    "Miranda is made mostly of water ice mixed with rocky material. " +
                    "Although it is small, its surface shows signs of past internal heating and tectonic activity.",
            "Miranda was discovered in 1948 by the Dutch-American astronomer Gerard Kuiper. " +
                    "The moon was named after Miranda, a character from William Shakespeare's play 'The Tempest'.\n\n" +
                    "Scientists believe Miranda formed from material orbiting Uranus early in the Solar System's history. " +
                    "Some researchers think the moon may have experienced major collisions that broke it apart before gravity pulled the pieces back together.",
            "Miranda has only been closely explored by NASA's Voyager 2 spacecraft during its flyby of Uranus in 1986. " +
                    "Voyager 2 revealed enormous cliffs, strange surface patterns, and geological formations unlike those on most other moons.\n\n" +
                    "The data collected by Voyager 2 remains the main source of detailed information about Miranda. " +
                    "Scientists continue studying those images to understand how such a small moon developed such a complex surface.",
            "Miranda contains Verona Rupes, one of the tallest known cliffs in the Solar System, which may rise more than 20 kilometers high. " +
                    "The moon orbits Uranus at an average distance of about 130,000 kilometers and completes one orbit in about 1.4 Earth days.\n\n" +
                    "Miranda's patchwork-like appearance makes it one of the most visually unique moons in the Solar System.",
            236, 130000, true);
    uranus.addSatellite(miranda);
    addObject(miranda);

    Satellite oberon = new Satellite("Oberon", "Satellite",
            "The outermost and second-largest major moon of Uranus.",
            "Uranus",
            "Oberon is the second-largest moon of Uranus and the outermost of Uranus's five major satellites. " +
                    "Its surface is heavily covered with impact craters, mountains, valleys, and bright ejecta material produced by collisions over billions of years. " +
                    "The moon is composed mainly of water ice mixed with rocky material.\n\n" +
                    "Oberon has one of the darkest surfaces among Uranus's major moons, although bright ice can be seen around some impact craters. " +
                    "Large fractures and valleys suggest that internal geological activity may once have affected its surface.\n\n" +
                    "Because Oberon orbits far from Uranus, scientists believe it preserves ancient surface features that can provide information about the early Solar System and the history of Uranus's moon system.",
            "Oberon was discovered in 1787 by the British astronomer William Herschel, the same astronomer who discovered Uranus itself. " +
                    "The moon was named after Oberon, the king of the fairies in William Shakespeare's play 'A Midsummer Night's Dream'.\n\n" +
                    "Scientists believe Oberon formed from icy and rocky material surrounding Uranus during the formation of the Solar System. " +
                    "Impacts and possible internal expansion later shaped its surface and valleys.",
            "Oberon has only been visited by NASA's Voyager 2 spacecraft during its flyby of Uranus in 1986. " +
                    "Voyager 2 provided the first close-up images of Oberon's heavily cratered surface and large fault valleys.\n\n" +
                    "Because only one side of Oberon was photographed in detail by Voyager 2, much of the moon remains poorly explored. " +
                    "Future missions to Uranus may reveal far more about its geology and internal structure.",
            "Oberon is the outermost major moon of Uranus and orbits the planet at an average distance of about 584,000 kilometers. " +
                    "It takes about 13.5 Earth days to complete one orbit around Uranus.\n\n" +
                    "Some craters on Oberon contain bright material that may be exposed ice from beneath the surface. " +
                    "The moon's ancient and heavily cratered appearance makes it one of the oldest-looking moons in the Uranian system.",
            761, 584000, true);
    uranus.addSatellite(oberon);
    addObject(oberon);
    addObject(uranus);

    Planet neptune = new Planet("Neptune", "Planet",
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
            24622, 102, 4495, true, 16);
    Satellite triton = new Satellite("Triton", "Satellite",
            "The largest moon of Neptune and one of the coldest worlds in the Solar System.",
            "Neptune",
            "Triton is the largest natural satellite of Neptune and one of the most unusual moons in the Solar System. " +
                    "It is unique because it orbits Neptune in the opposite direction of the planet's rotation, a motion called retrograde orbit. " +
                    "Scientists believe this unusual orbit means Triton was probably captured by Neptune long ago rather than forming around the planet.\n\n" +
                    "Triton's surface is covered with nitrogen ice, frozen water, and frozen carbon dioxide. " +
                    "The moon has plains, ridges, valleys, craters, and icy volcano-like features called cryovolcanoes. " +
                    "Its surface temperature is extremely cold, making Triton one of the coldest known objects in the Solar System.\n\n" +
                    "Despite its cold environment, Triton is geologically active. " +
                    "Scientists observed geyser-like eruptions that release nitrogen gas and dark material above the surface.",
            "Triton was discovered in 1846 by the British astronomer William Lassell shortly after the discovery of Neptune itself. " +
                    "The moon was named after Triton, the son of Poseidon in Greek mythology.\n\n" +
                    "Scientists think Triton may originally have been a dwarf planet from the Kuiper Belt before Neptune captured it through gravity. " +
                    "Its unusual orbit and composition support this idea.",
            "Triton has only been visited by one spacecraft: NASA's Voyager 2 during its flyby of Neptune in 1989. " +
                    "Voyager 2 revealed Triton's icy surface, active geysers, and unusual terrain in remarkable detail.\n\n" +
                    "The mission showed that Triton is one of the few moons in the Solar System with active geology. " +
                    "Scientists continue studying Voyager 2 data to better understand Triton's atmosphere, surface activity, and possible internal ocean.",
            "Triton orbits Neptune at an average distance of about 355,000 kilometers and takes about 5.9 Earth days to complete one orbit. " +
                    "Because of tidal forces, Triton is slowly moving closer to Neptune and may eventually break apart in the distant future.\n\n" +
                    "Triton has a thin atmosphere made mainly of nitrogen, and its geysers can send material several kilometers above the surface.",
            1353, 355000, true);
    neptune.addSatellite(triton);
    addObject(triton);
    Satellite proteus = new Satellite("Proteus", "Satellite",
            "The second-largest moon of Neptune and one of the darkest moons in the Solar System.",
            "Neptune",
            "Proteus is the second-largest natural satellite of Neptune after Triton. " +
                    "It is an irregularly shaped moon with a dark, heavily cratered surface made mostly of ice and rocky material. " +
                    "Unlike many large moons, Proteus is not perfectly spherical because its gravity is not strong enough to fully pull it into a round shape.\n\n" +
                    "The surface of Proteus contains many impact craters and rough terrain formed over billions of years. " +
                    "One of its largest craters is called Pharos, which stretches across a large part of the moon.\n\n" +
                    "Proteus reflects very little sunlight, making it one of the darker moons in the Solar System. " +
                    "Scientists believe it formed from material orbiting Neptune after Triton was captured by the planet.",
            "Proteus was discovered in 1989 by scientists studying images taken by NASA's Voyager 2 spacecraft during its flyby of Neptune. " +
                    "The moon was named after Proteus, a sea god from Greek mythology associated with the ocean.\n\n" +
                    "Scientists think Proteus formed from debris orbiting Neptune after major gravitational changes in the Neptunian system. " +
                    "Its irregular shape and ancient cratered surface preserve information about Neptune's history.",
            "Proteus has only been closely observed by Voyager 2. " +
                    "The spacecraft captured images showing its dark surface, irregular shape, and giant craters.\n\n" +
                    "Because no spacecraft has visited Neptune since Voyager 2, much about Proteus remains unknown. " +
                    "Future missions to Neptune could provide much more detailed information about the moon's composition and internal structure.",
            "Proteus is one of the largest known moons that is not completely spherical. " +
                    "Its average distance from Neptune is about 117,600 kilometers, and it completes one orbit around Neptune in less than 27 hours.\n\n" +
                    "The moon's dark surface reflects only a small amount of sunlight, making it difficult to observe from Earth.",
            210, 117600, true);
    neptune.addSatellite(proteus);
    addObject(proteus);
    addObject(neptune);
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
    addObject(new Nebula("Orion", "Nebula",
            "A bright star-forming nebula in the constellation Orion.",
            "The Orion Nebula is one of the brightest and most famous nebulae visible from Earth. " +
                    "It is a huge cloud of gas and dust where new stars are forming.",
            "The Orion Nebula formed from a large cloud of interstellar gas and dust. " +
                    "Gravity pulled parts of the cloud together, creating dense regions where stars began to form.",
            "This nebula is important because it helps scientists understand how stars and planetary systems are born.",
            "The Orion Nebula can be faintly seen with the naked eye under very dark skies, but it is much clearer through binoculars or telescopes. \nIt is located in Orion’s sword.",
            1500, "Emission Nebula", true));

    addObject(new Nebula("Eagle", "Nebula",
            "A star-forming nebula famous for the Pillars of Creation.",
            "The Eagle Nebula is a large cloud of gas and dust. It is famous for a region called the Pillars of Creation.",
            "The nebula contains cold gas and dust that can collapse under gravity and form new stars.",
            "The Eagle Nebula is important because it shows active star formation and beautiful structures shaped by radiation.",
            "The Pillars of Creation are one of the most famous space images ever taken.",
            7000, "Emission Nebula", true));

    addObject(new Nebula("Crab", "Nebula",
            "A supernova remnant created after a massive star exploded.",
            "The Crab Nebula is the remains of a star that exploded in a supernova. " +
                    "It contains gas moving outward from the explosion.",
            "It formed when a massive star reached the end of its life and exploded. " +
                    "The explosion was observed from Earth in the year 1054.",
            "The Crab Nebula helps scientists study supernova explosions and neutron stars.",
            "At the center of the Crab Nebula is a rapidly spinning neutron star called a pulsar.",
            6500, "Supernova Remnant", false));

    addObject(new Nebula("Ring", "Nebula",
            "A planetary nebula formed from a dying star.",
            "The Ring Nebula is a colorful shell of gas released by a dying star. " +
                    "Despite its name, it has nothing to do with planets.",
            "It formed when a Sun-like star pushed its outer layers into space near the end of its life.",
            "The Ring Nebula helps scientists understand what may happen to stars like the Sun in the far future.",
            "It looks like a glowing ring when viewed through telescopes.",
            2000, "Planetary Nebula", false));

    addObject(new Nebula("Horsehead", "Nebula",
            "A dark nebula shaped like a horse's head.",
            "The Horsehead Nebula is a dark cloud of dust and gas. It blocks light from the bright background behind it.",
            "It formed from dense interstellar dust and gas. Its shape is carved by radiation from nearby stars.",
            "The Horsehead Nebula is important because it shows how dark nebulae can hide star-forming material.",
            "Its famous shape makes it one of the most recognizable nebulae in astronomy.",
            1375, "Dark Nebula", true));
    addObject(new Comet(
            "Comets",
            "Comet",


            "Small icy objects that travel through the Solar System.",


            "Comets are small icy objects that travel through our Solar System. " +
                    "They are often called dirty snowballs because they are made of ice, dust, rock, and frozen gases.",


            "Most comets originate from distant regions such as the Kuiper Belt and the Oort Cloud far beyond the planets.",


            "When a comet moves closer to the Sun, the heat causes its ice to evaporate and release gas and dust. " +
                    "This creates a glowing atmosphere around the comet called a coma and often forms a long bright tail. " +
                    "The tail always points away from the Sun because of solar wind and radiation.",


            "Comets are important to scientists because they contain very old material left over from the formation " +
                    "of the Solar System about 4.6 billion years ago. By studying them astronomers can learn more " +
                    "about the origins of planets water and organic molecules in space.",


            "Comets are among the most fascinating objects in the Solar System. " +
                    "Their bright tails and rare appearances have inspired humans for centuries.",


            100,


            true,
            "default"
    ));
    addObject(new Comet(
            "Halley's Comet",
            "Comet",


            "The most famous comet in history.",


            "Halley’s Comet is the most famous comet in history. " +
                    "It becomes visible from Earth approximately every 76 years.",


            "The comet is believed to originate from the Kuiper Belt.",


            "As it approaches the Sun, Halley’s Comet develops a bright tail visible from Earth.",


            "Scientists study Halley’s Comet to better understand the early Solar System.",


            "The comet is named after astronomer Edmond Halley who correctly predicted its return. " +
                    "Its next appearance near Earth is expected in 2061.",


            76,


            true,
            "/spaceencyclopedia/images/halley.jpg"
    ));
    addObject(new Comet(
            "Comet Hale-Bopp",
            "Comet",


            "One of the brightest comets of the 20th century.",


            "Hale–Bopp was one of the brightest comets ever observed.",


            "It traveled into the inner Solar System from distant outer regions.",


            "The comet displayed an enormous bright tail visible for months.",


            "Its long visibility allowed scientists to perform extensive observations.",


            "Millions of people observed Hale–Bopp during 1996 and 1997 without telescopes.",


            2533,


            true,
            "/spaceencyclopedia/images/Comet_Hale-Bopp.jpg"


    ));
    addObject(new Comet(
            "Comet NEOWISE",
            "Comet",


            "A bright comet visible in 2020.",


            "Comet NEOWISE became very popular in 2020 because it was visible to the naked eye.",


            "It was discovered by NASA's NEOWISE space telescope.",


            "The comet developed a long golden tail while approaching the Sun.",


            "Scientists used the comet to study comet composition and dust behavior.",


            "Photographers around the world captured impressive images of NEOWISE.",


            6800,


            true,
            "/spaceencyclopedia/images/Comet-NEOWISE.jpg"


    ));
    addObject(new Comet(
            "Comet Shoemaker-Levy 9",
            "Comet",


            "A comet famous for colliding with Jupiter.",


            "Shoemaker–Levy 9 became famous after colliding with Jupiter in 1994.",


            "The comet was captured by Jupiter’s gravity before impact.",


            "Fragments of the comet crashed into Jupiter’s atmosphere causing enormous explosions.",


            "The collision helped scientists better understand impacts in the Solar System.",


            "This was the first direct observation of two Solar System bodies colliding.",


            2,


            false,
            "/spaceencyclopedia/images/Comet Shoemaker–Levy 9.jpg"


    ));
    addObject(new Comet(
            "Comet 67P",
            "Comet",


            "The comet visited by the Rosetta spacecraft.",


            "Comet 67P became famous because of the European Space Agency Rosetta mission.",


            "It is a periodic comet orbiting the Sun every few years.",


            "The comet releases gas and dust when heated by the Sun.",


            "The Rosetta mission provided valuable information about comet composition and structure.",


            "In 2014 the Philae probe successfully landed on the comet’s surface.",


            6.45,


            false,
            "/spaceencyclopedia/images/Comet 67P Churyumov–Gerasimenko.jpg"


    ));
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
    public ArrayList<Satellite> getSatellites() {
        ArrayList<Satellite> satellites = new ArrayList<>();
        for (SpaceObject object : objects) {
            if (object instanceof Satellite) {
                satellites.add((Satellite) object);
            }
        }
        return satellites;
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
    public ArrayList<Nebula> getNebulae() {

        ArrayList<Nebula> nebulae =new ArrayList<>();
        for (SpaceObject object : objects) {
            if (object instanceof Nebula) {
                nebulae.add((Nebula) object);
            }
        }
        return nebulae;
    }
}