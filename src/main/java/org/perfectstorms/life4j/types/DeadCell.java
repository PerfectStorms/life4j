package org.perfectstorms.life4j.types;

import org.perfectstorms.life4j.Cell;

/**
 * This class is considered a dead cell of the era.
 *
 * @see Cell
 * @see LifeCell
 */
public class DeadCell implements Cell {

    /**
     * Overridden method that checks for dead cells.
     *
     * @return Always returns false.
     */
    @Override
    public boolean isLive() {
        return false;
    }
}
