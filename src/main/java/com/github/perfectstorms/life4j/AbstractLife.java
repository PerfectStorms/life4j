package com.github.perfectstorms.life4j;

import java.io.File;
import java.io.IOException;

/**
 * AbstractLife is an abstract class that contains descriptions of cell life.
 *
 * @see Game
 * @see Cell
 *
 * @author Sherzod Mamadaliev
 * @since 1.0
 */
public abstract class AbstractLife implements Game {

    /**
     * Fills cells with DeadCell objects.
     */
    public abstract void fill();

    /**
     * Fills area cells with the provided cell object.
     *
     * @param cells An array cell object.
     */
    public abstract void fill(Cell[][] cells);

    /**
     * Generates an era by chance.
     */
    public abstract void generate();

    /**
     * Gets neighbors of this cell by coordinates.
     *
     * @param x Coordinate x.
     * @param y Coordinate y.
     * @return Neighbors count of a cell with coordinates (x, y).
     */
    public abstract int getNeighborsCount(int x, int y);

    /**
     * Generates the next era (epoch).
     */
    public abstract void generateNextEpoch();

    /**
     * Reads cell position data from a file object.
     *
     * @param file The file object that provides the path to the file.
     * @return Returns an array of cells.
     * @throws IOException Throws this exception if it receives I/O errors in real time.
     */
    public abstract Cell[][][] read(File file) throws IOException;

    /**
     * Reads the cell position data from the file that was specified in the parameters as a string.
     *
     * @param filename A string that is the file path.
     * @return Returns an array of cells.
     * @throws IOException Throws this exception if it receives I/O errors in real time.
     */
    public abstract Cell[][][] read(String filename) throws IOException;

    /**
     * Writes cell positions to a file.
     *
     * @param file The file object that is the path to the file.
     * @throws IOException Throws this exception if it receives I/O errors in real time.
     */
    public abstract void write(File file) throws IOException;

    /**
     * Writes positions of cells to file.
     *
     * @param filename A string that is the file path.
     * @throws IOException Throws this exception if it receives I/O errors in real time.
     */
    public abstract void write(String filename) throws IOException;
}
