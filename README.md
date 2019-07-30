# life4j
[![Build Status](https://travis-ci.com/perfectstorms/life4j.svg?branch=master)](https://travis-ci.com/perfectstorms/life4j)

Library for the implementation of 
[Conway's Game of Life](https://en.wikipedia.org/wiki/Conway's_Game_of_Life)
with the ability to read/write coordinates using
[RLE](https://en.wikipedia.org/wiki/Run-length_encoding)
algorithm.
Code samples for [FX](), [Swing](), [AWT](), [StdDraw]().

## Installation
**Maven**
```xml
<dependency>
    <groupId>com.github.perfectstorms</groupId>
    <artifactId>life4j</artifactId>
    <version>1.0-SNAPSHOT</version>
</dependency>
```
**Gradle**
```groovy
implementation 'com.github.perfectstorms:life4j:1.0-SNAPSHOT'
```

## Architecture
![Architecture](https://i.ibb.co/xSCRG2K/life4j.png)
This project contains the main 
[Game](src/main/java/org/perfectstorms/life4j/Game.java) 
interface, as well as the 
[LifeAbstract](src/main/java/org/perfectstorms/life4j/AbstractLife.java) class, 
which implements the Game and adds abstract methods, and, in turn, 
the 
[GameOfLife](src/main/java/org/perfectstorms/life4j/GameOfLife.java)
class extends the LifeAbstract class.

## Sample

```java
import org.perfectstorms.life4j.GameOfLife;

public class LifeConsoleApplication {

    @SuppressWarnings("InfiniteLoopStatement")
    public static void main(String[] args) throws InterruptedException {
        GameOfLife gol = new GameOfLife(50, 100);

        gol.fill();
        gol.generate();
        gol.start();

        while (true) {
            gol.display();
            gol.update();
            gol.sleep(100); // wait 100 milliseconds

            /* to clear data in ANSI console */
            System.out.print("\033[2J\033[H"); // works only on ANSI console
        }
    }
}
```

## Demos
![Run Life4j from console](https://i.ibb.co/zbtXmtJ/life.gif)

## Contribute
For any problems, comments, or feedback please create an issue [here](https://github.com/perfectstorms/life4j/issues).
<br>

## License
This software is released under the [MIT License](http://mitlicense.org).