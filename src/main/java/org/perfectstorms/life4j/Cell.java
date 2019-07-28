package org.perfectstorms.life4j;

/**
 * The Cell interface is the main interface for all types of cells.
 */
public interface Cell {

    /**
     * Checks the cell for liveliness.
     *
     * @return Returns true if this cell is life, otherwise returns false.
     */
    boolean isLive();
}
