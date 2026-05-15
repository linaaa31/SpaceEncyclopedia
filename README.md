# Space Encyclopedia

## Project Description

Space Encyclopedia is a Java Swing desktop application that provides information about different astronomical objects such as planets, stars, satellites, nebulae, comets, and asteroids.

The project was developed using Object-Oriented Programming principles and graphical user interface design with Java Swing.

Users can:
- Browse space objects
- Read detailed information
- Search objects
- Add objects to favorites
- Navigate through different categories

---

## Technologies Used

- Java
- Java Swing
- AWT
- Object-Oriented Programming (OOP)

---

## OOP Concepts Used

### Inheritance
Classes such as `Planet`, `Star`, `Satellite`, `Nebula`, `Comet`, and `Asteroid` inherit from the `SpaceObject` base class.

### Encapsulation
Fields are private and accessed through getters.

### Polymorphism
Different objects are stored and handled using `SpaceObject` references.

---

## Project Structure

```text
spaceencyclopedia/
│
├── core/          # Main object classes
├── gui/           # GUI pages
├── manager/       # Managers and data handling
├── exception/     # Custom exceptions
├── images/        # Images used in GUI
```

---

## Dependencies

This project uses only standard Java libraries:

- javax.swing
- java.awt
- java.util

No external libraries or frameworks are required.

---

## How to Run the Project

### 1. Open Terminal

Open terminal in the project root folder.

### 2. Compile the Project

```bash
javac src/main/java/spaceencyclopedia/core/*.java src/main/java/spaceencyclopedia/gui/*.java src/main/java/spaceencyclopedia/manager/*.java src/main/java/spaceencyclopedia/exception/*.java src/main/java/spaceencyclopedia/*.java
```

### 3. Run the Project

```bash
java -cp src/main/java spaceencyclopedia.Main
```

---
## Presentation
https://canva.link/2paphrx52qtoj6e

---
## Authors

- Lina Badalyan
- Marina Hakobyan
- Tatevik Gharibyan

