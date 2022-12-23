## LPOO_T11G03 - Space Invaders

> This project is intended to recreate one of the most iconic games of the 80´s, Space Invaders. In this game you help humanity from aliens by destroying as many spaceships as you can.
> This project was developed by *Luís Contreiras* (*up202108742*@fe.up.pt) , *Diogo Santos* (*up202108747*@fe.up.pt) e *Domingos Neto* (*up202108728*@fe.up.pt) for LP00 2022/23.

------

### FEATURES

> **Movement** - The spaceship moves freely inside the borders of the screen with the arrow keys.
> **Attack** - When the user clicks space the spaceship throws a bullet that will affect alien spaceships.
> **elements.Enemy's** - Creation of enemy ships.


### PLANNED FEATURES

> **Damage** - When the spaceship gets attacked it loses the char that was damaged until there are no char members left.
> **Alien Attack** - Aliens may throw different kinds of bullets with different sizes and movement patterns.
> **SpaceShip Upgrade** - Every elements the spaceship will be upgraded with more chars (more lives).
> **elements.Enemy's difficulty** - Every elements will increase the difficulty of the game by modifying the characteristics of the enemy´s spaceships.

------

## UML Class Diagram

A UML class diagram showcasing used Design Patterns:

![UML class diagram](docs/uml.png)

------

### DESIGN PATTERNS

>**Implemented:** We have implemented the **Composite Design Pattern** in the functioning of our **elements.Element** and **elements.Char** classes, both have **draw()** and **move()** methods that run correctly either if we take an individual approach of moving a single **elements.Char** or a collective approach of moving all characters that constitute an **elements.Element**.


>**To Implement:** We plan on implementing the **Strategy Design Pattern** to our **Bullet** class, in order to create different types of bullets.

------

### PROBLEMS

>We have faced quite a lot of problems while developing the game, a current one that comes to mind is how the bullets still aren't able to move up by their own, when the player fires a bullet, it only moves if the player also moves.

------

### TESTING

- In process!

------

### SELF-EVALUATION

- Luís Contreiras: 33%
- Diogo Santos: 33%
- Domingos Neto: 33%
