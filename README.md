# Tic-Tac-Toe

https://en.wikipedia.org/wiki/Tic-tac-toe

## Getting Started

### Installing

Download project as .zip and unzip it. From command line go to the project folder and build it:

```
mvn clean install
```

Afterwards that all the tests will be passed, target source folder will be created. Due to run the game, type following command from target folder:

```
java -jar tictactoe-0.0.1-SNAPSHOT.jar
```
### Application Properties Settings
User can change game settings from application.properties file that located in /src/main/resources folder. After any updates in properties file, user should build new jar.
```
screen.rows -> game board rows count
screen.columns -> game board columns count
player.human.1.sign -> first player's mark
player.human.2.sign -> second player's mark
player.computer.sign -> computer's mark
```
