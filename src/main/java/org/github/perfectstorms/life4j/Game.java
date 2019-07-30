package org.github.perfectstorms.life4j;

/**
 * The game interface is the main interface of this library
 * and contains methods for creating the basis of the game.
 *
 * @see AbstractLife
 * @see Cell
 *
 * @author Sherzod Mamadaliev
 * @since 1.0
 */
public interface Game {

    /**
     * This method is used to start the game.
     */
    void start();

    /**
     * This method is used to update the game components.
     */
    void update();

    /**
     * This method is used to pause the game.
     */
    void pause();

    /**
     * This method is used to resume the game.
     */
    void resume();

    /**
     * This method is used to reset the game.
     */
    void reset();

    /**
     * This method is used to sleep the game update.
     *
     * @param milliseconds Milliseconds.
     * @throws InterruptedException Thrown when a thread is waiting,
     * sleeping, or otherwise occupied, and the thread is interrupted,
     * either before or during the activity.
     */
    void sleep(int milliseconds) throws InterruptedException;

    /**
     * This method is used to clear the game components.
     */
    void clear();

    /**
     * This method is used to display the game information to console.
     */
    void display();
}
