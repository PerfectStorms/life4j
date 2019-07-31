import com.github.perfectstorms.life4j.GameOfLife;

public class LifeConsoleApplication {

    public static void main(String[] args) throws InterruptedException {
        GameOfLife gol = new GameOfLife(50, 100);
        gol.fill();
        gol.generate();
        gol.start();

        for (int i = 0; i < 100000000; i++) {
            gol.display();
            gol.update();
            gol.sleep(100);

            /* to clear data in ANSI console (works only on ANSI console) */
            System.out.print("\033[2J\033[H");
        }
    }
}
