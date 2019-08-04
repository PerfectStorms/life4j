package com.github.perfectstorms.life4j.types;

import com.github.perfectstorms.life4j.Cell;

/**
 * This class is considered a living cell of the era.
 *
 * @see Cell
 * @see DeadCell
 *
 * @author Sherzod Mamadaliev
 * @since 1.0
 */
public class LifeCell implements Cell {

    /**
     * Overridden method that checks cell liveliness.
     *
     * @return Always returns true.
     */
    @Override
    public boolean isLive() {
        return true;
    }
}
