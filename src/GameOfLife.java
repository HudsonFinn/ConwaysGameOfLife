package src;

import java.util.concurrent.TimeUnit;

class GameOfLife {
    private static Cell[][] game;
    public GameOfLife(int[][] grid) {
        game = new Cell[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                game[i][j] = new Cell(grid[i][j], i, j);
            }
        }
    }

    public void age() {
        for (int i = 0; i < game.length; i++) {
            for (int j = 0; j < game[0].length; j++) {
                Cell cell = game[i][j];
                cell.age();
            }
        }

        for (int i = 0; i < game.length; i++) {
            for (int j = 0; j < game[0].length; j++) {
                Cell cell = game[i][j];
                cell.update();
            }
        }
    }

    public static boolean wasAlive(int i, int j) {
        if (i >= game.length || i < 0 || j >= game[0].length || j < 0) return false;
        return game[i][j].isPrevAlive();
    }

    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < game.length; i++) {
            for (int j = 0; j < game[0].length; j++) {
                if (game[i][j].isCurrAlive()) {
                    result = result + "* ";
                } else {
                    result = result + ". ";
                }
            }
            result = result + "\n";
        }
        return result;
    }


    public static void main(String[] args) throws InterruptedException {
        int[][] grid = { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 1, 1, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 1, 1, 0, 0, 0, 0, 0 },
            { 0, 0, 1, 1, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 1, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }
        };
        GameOfLife game = new GameOfLife(grid);
        System.out.println(game.toString());
        for (int i = 0; i < 100; i++) {
            TimeUnit.SECONDS.sleep(1);
            game.age();
            System.out.println(game.toString());
        }
    }
}