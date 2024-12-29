# MyFlappyBird

Description:

This Java code implements a simple Flappy Bird game using the LibGDX framework, a popular choice for 2D game development in Java. The game features a bird controlled by the player that must navigate through gaps between pairs of tubes to score points. The objective is to avoid collision with the tubes while keeping the bird airborne.

Key Features:

Responsive Controls: The game responds to player input, allowing the bird to flap its wings and gain altitude when the screen is tapped.

Dynamic Gameplay: Tubes are generated at random heights, creating dynamic gameplay where the player must react quickly to avoid collisions.

Scoring System: The game keeps track of the player's score, incrementing it each time the bird successfully passes through a pair of tubes.

Collision Detection: Collision detection is implemented to detect when the bird collides with the tubes. When a collision occurs, the game ends, and the player's final score is displayed.

Graphics and Animation: The game features simple graphics and animation for the bird, tubes, and background, providing an engaging visual experience.

Setup and Installation
Requirements:
  Java Development Kit (JDK 8+)
  LibGDX framework
  IDE with Java support (e.g., IntelliJ IDEA, Eclipse)

Steps to Set Up:
Clone or download this repository.
Install the LibGDX framework using the setup tool.
Place the following assets in the android/assets directory:
  bg.png - Background image
  bird.png - First bird frame
  bird2.png - Second bird frame
  toptube.png - Top tube texture
  bottomtube.png - Bottom tube texture
Import the project into your IDE.
  Run the desktop launcher to start the game.


How to Play
Start the Game:
  Click anywhere on the screen to start the game.
Flap:
  Click or tap to make the bird ascend.
Avoid Tubes:
  Navigate the bird through the gaps between tubes to avoid collisions.
Score Points:
  Pass through tubes to increase your score.

Known Issues
  The game state resets immediately upon collision, without a restart menu.  
  The bird's collision detection might be slightly off depending on tube positioning.
