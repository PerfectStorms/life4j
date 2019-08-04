package com.github.perfectstorms.life4j.types;

import com.github.perfectstorms.life4j.Cell;

/**
 * This class is considered a dead cell of the era.
 *
 * @see Cell
 * @see LifeCell
 *
 * @author Sherzod Mamadaliev
 * @since 1.0
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
