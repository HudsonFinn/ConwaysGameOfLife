package src;

public class Cell {
    private boolean currAlive;
    private boolean prevAlive;
    private int col;
    private int row;

    public Cell(int alive, int startCol, int startRow) {
        col = startCol;
        row = startRow;
        prevAlive = false;
        currAlive = (alive == 1);
    }

    public void update() {

        // Calculate surrounding total
        int surround = 0;
        surround += GameOfLife.wasAlive(col - 1, row - 1) ? 1: 0;
        surround += GameOfLife.wasAlive(col, row - 1) ? 1: 0;
        surround += GameOfLife.wasAlive(col + 1, row - 1) ? 1: 0;
        surround += GameOfLife.wasAlive(col - 1, row) ? 1: 0;
        surround += GameOfLife.wasAlive(col + 1, row) ? 1: 0;
        surround += GameOfLife.wasAlive(col - 1, row + 1) ? 1: 0;
        surround += GameOfLife.wasAlive(col, row + 1) ? 1: 0;
        surround += GameOfLife.wasAlive(col + 1, row + 1) ? 1: 0;

        // Game of life rules
        if (surround == 2) return;
        if (surround == 3) {
            currAlive = true;
        } else {
            currAlive = false;
        }
        
    }

    public void age() {
        prevAlive = currAlive;
    }

    public boolean isCurrAlive() {
        return this.currAlive;
    }

    public void setCurrAlive(boolean currAlive) {
        this.currAlive = currAlive;
    }

    public boolean isPrevAlive() {
        return this.prevAlive;
    }

    public void setPrevAlive(boolean prevAlive) {
        this.prevAlive = prevAlive;
    }
}
