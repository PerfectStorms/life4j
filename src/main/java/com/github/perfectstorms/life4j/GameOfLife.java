package com.github.perfectstorms.life4j;

import com.github.perfectstorms.life4j.utils.Encrypt;
import com.github.perfectstorms.life4j.types.DeadCell;
import com.github.perfectstorms.life4j.types.LifeCell;

import java.net.URL;
import java.io.File;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

/**
 * Implementation of the Conway's Game of Life.
 *
 * @see AbstractLife
 * @see Game
 * @see Cell
 *
 * @author Sherzod Mamadaliev
 * @since 1.0
 */
public class GameOfLife extends AbstractLife {

    private Cell[][][] cells;
    private Cell life;
    private Cell dead;
    private boolean state;
    private int width = 500;
    private int height = 500;

    public GameOfLife() {
        this.cells = new Cell[2][500][500];
        this.life = new LifeCell();
        this.dead = new DeadCell();
    }

    public GameOfLife(int width, int height) {
        this.cells = new Cell[2][width][height];
        this.width = width;
        this.height = height;
        this.life = new LifeCell();
        this.dead = new DeadCell();
    }

    public GameOfLife(Cell[][] cells) {
        this.width = cells.length;
        this.height = cells[0].length;
        this.cells = new Cell[2][this.width][this.height];
        this.life = new LifeCell();
        this.dead = new DeadCell();

        for (int x = 0; x < cells.length; x++) {
            System.arraycopy(cells[x], 0, this.cells[0][x], 0, cells[x].length);
        }
    }

    @Override
    public void fill() {
        for (int i = 0; i < cells[0].length; i++) {
            for (int j = 0; j < cells[0][i].length; j++) {
                cells[0][i][j] = this.dead;
            }
        }
    }

    @Override
    public void fill(Cell[][] cells) {
        for (int x = 0; x < cells.length; x++) {
            System.arraycopy(cells[x], 0, this.cells[0][x], 0, cells[x].length);
        }
    }

    @Override
    public void start() {
        this.state = true;
    }

    @Override
    public void update() {
        if (state) {
            this.generateNextEpoch();
        }
    }

    @Override
    public void pause() {
        if (this.state) this.state = false;
    }

    @Override
    public void resume() {
        if (!this.state) state = true;
    }

    @Override
    public void reset() {
        Arrays.fill(cells, null);
    }

    @Override
    public void sleep(int milliseconds) throws InterruptedException {
        Thread.sleep( milliseconds);
    }

    @Override
    public Cell[][][] read(File file) throws IOException {
        StringBuilder data = new StringBuilder();
        String currentLine;
        BufferedReader reader = new BufferedReader(new FileReader(file));

        while ((currentLine = reader.readLine()) != null) {
            data.append(currentLine);
        }
        reader.close();
        return Encrypt.decode(data.toString());
    }

    @Override
    public Cell[][][] read(String filename) throws IOException {
        URL url = getClass().getResource(filename);

        StringBuilder data = new StringBuilder();
        String currentLine;
        BufferedReader reader = new BufferedReader(new FileReader(url.getFile()));

        while ((currentLine = reader.readLine()) != null) {
            data.append(currentLine);
        }
        reader.close();
        return Encrypt.decode(data.toString());
    }

    @Override
    public void write(File file) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        writer.write(Encrypt.encode(cells));
        writer.close();
    }

    @Override
    public void write(String filename) throws IOException {
        URL url = getClass().getResource(filename);
        BufferedWriter writer = new BufferedWriter(new FileWriter(url.getFile()));
        writer.write(Encrypt.encode(cells));
        writer.close();
    }

    @Override
    public void generate() {
        Random random = new Random();
        int size = 0, x, y;
        int count = (int) (((this.width * this.height) / 100) * 50.0);

        while (size < count) {
            x = random.nextInt(this.width);
            y = random.nextInt(this.height);

            if (this.cells[0][x][y] instanceof DeadCell) {
                this.cells[0][x][y] = this.life;
                size++;
            }
        }
    }

    @Override
    public int getNeighborsCount(int x, int y) {
        int neighbors = 0;

        /* top */
        neighbors += (y == this.height - 1)
                ? this.cells[0][x][0] instanceof LifeCell ? 1 : 0
                : this.cells[0][x][y + 1] instanceof LifeCell ? 1 : 0;

        /* right */
        neighbors += (x == this.width - 1)
                ? this.cells[0][0][y] instanceof LifeCell ? 1 : 0
                : this.cells[0][x + 1][y] instanceof LifeCell ? 1 : 0;

        /* bottom */
        neighbors += (y == 0)
                ? this.cells[0][x][this.height - 1] instanceof LifeCell ? 1 : 0
                : this.cells[0][x][y - 1] instanceof LifeCell ? 1 : 0;

        /* left */
        neighbors += (x == 0)
                ? this.cells[0][this.width - 1][y] instanceof LifeCell ? 1 : 0
                : this.cells[0][x - 1][y] instanceof LifeCell ? 1 : 0;

        /* top right */
        if (x == this.width - 1 && y == this.height - 1) {
            neighbors += this.cells[0][0][0] instanceof LifeCell ? 1 : 0;
        } else {
            if (x < this.width - 1 && y < this.height - 1)
                neighbors += this.cells[0][x + 1][y + 1] instanceof LifeCell ? 1 : 0;
        }

        /* bottom right */
        if (x == this.width - 1 && y == 0) {
            neighbors += this.cells[0][0][this.height - 1] instanceof LifeCell ? 1 : 0;
        } else {
            if (x < this.width - 1 && y > 0)
                neighbors += this.cells[0][x + 1][y - 1] instanceof LifeCell ? 1 : 0;
        }

        /* bottom left */
        if (x == this.width - 1 && y == this.height - 1) {
            neighbors += this.cells[0][this.width - 1][this.height - 1] instanceof LifeCell ? 1 : 0;
        } else {
            if (x > 0 && y > 0)
                neighbors += this.cells[0][x - 1][y - 1] instanceof LifeCell ? 1 : 0;
        }

        /* top left */
        if (x == this.width - 1 && y == this.height - 1) {
            neighbors += this.cells[0][this.width - 1][0] instanceof LifeCell ? 1 : 0;
        } else {
            if (x > 0 && y < this.height - 1)
                neighbors += this.cells[0][x - 1][y + 1] instanceof LifeCell ? 1 : 0;
        }

        return neighbors;
    }

    @Override
    public void generateNextEpoch() {
        int neighbors;

        for (int x = 0; x < this.width; x++) {
            for (int y = 0; y < this.height; y++) {
                neighbors = getNeighborsCount(x, y);

                if (neighbors == 3 || ((this.cells[0][x][y] instanceof LifeCell) && neighbors == 2)) {
                    this.cells[1][x][y] = this.life;
                } else {
                    this.cells[1][x][y] = this.dead;
                }
            }
        }

        for (int i = 0; i < this.cells[0].length; i++) {
            System.arraycopy(this.cells[1][i], 0, this.cells[0][i], 0, this.cells[0][i].length);
        }
    }

    @Override
    public void clear() {
        for (int i = 0; i < this.width; i++) {
            for (int j = 0; j < this.height; j++) {
                this.cells[0][i][j] = this.dead;
            }
        }
    }

    @Override
    public void display() {
        for (int i = 0; i < this.cells[0].length; i++) {
            for (int j = 0; j < this.cells[0][i].length; j++) {
                if (this.cells[0][i][j] instanceof LifeCell) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    public Cell[][][] getCells() {
        return cells;
    }

    public void setCells(Cell[][][] cells) {
        this.cells = cells;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
