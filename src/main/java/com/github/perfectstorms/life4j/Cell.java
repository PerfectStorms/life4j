package com.github.perfectstorms.life4j;

/**
 * The Cell interface is the main interface for all types of cells.
 *
 * @see Game
 * @see AbstractLife
 *
 * @author Sherzod Mamadaliev
 * @since 1.0
 */
public interface Cell {

    /**
     * Checks the cell for liveliness.
     *
     * @return Returns true if this cell is life, otherwise returns false.
     */
    boolean isLive();
}
