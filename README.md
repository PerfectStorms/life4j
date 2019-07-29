# life4j
Library for the implementation of Conway's Game of Life with the ability to read/write coordinates using RLE algorithm.

[Installation](#Installation)<br/>
[Samples](#Samples)<br/>
[Demos](#Demos)<br/>
[Contribute](#Contribute)<br/>
[License](#License)<br/>

## Installation
**Maven**
```xml
<dependency>
    <groupId>org.perfectstorms</groupId>
    <artifactId>life4j</artifactId>
    <version>1.0.RELEASE</version>
</dependency>
```
**Gradle**
```groovy
implementation 'org.perfectstorms:life4j:1.0.RELEASE'
```

## Samples
Code samples for [FX](), [Swing](), [AWT](), [StdDraw]().

## Architecture
![Architecture](https://i.ibb.co/xSCRG2K/life4j.png)
This project contains the main Game interface, as well as the LifeAbstract class, 
which implements the Game and adds abstract methods, and, in turn, 
the GameOfLife class extends the LifeAbstract class.

## Demos

## Contribute
For any problems, comments, or feedback please create an issue [here](https://github.com/perfectstorms/life4j/issues).
<br>

## License
This software is released under the [MIT License](http://mitlicense.org).