/*
The following program solves a sudoku.
*/

import java.util.*;

public class Solver {
  static int grid[][];

  static class Cell {

    int row, col;
    public Cell(int row, int col) // Constructor of Cell class
    {
      super();
      this.row = row;
      this.col = col;
    }
  };

  public Solver() // Constructor
  {
    grid = new int[9][9];
    Scanner s = new Scanner(System.in);
    System.out.println("Enter the Sudoku Matrix: ");
    for (int i = 0; i < 9; i++)
      for (int j = 0; j < 9; j++)
        grid[i][j] = s.nextInt();
    s.close();
  }

  static boolean legal(Cell cell, int value) {
    if (grid[cell.row][cell.col] != 0) {
      throw new RuntimeException(
          "Cannot call for cell which already has a value");
    }

    // if v present row, return false
    for (int c = 0; c < 9; c++) {
      if (grid[cell.row][c] == value)
        return false;
    }

    // if v present in col, return false
    for (int r = 0; r < 9; r++) {
      if (grid[r][cell.col] == value)
        return false;
    }

    int x1 = 3 * (cell.row / 3), y1 = 3 * (cell.col / 3);
    int x2 = x1 + 2, y2 = y1 + 2;

    for (int x = x1; x <= x2; x++)
      for (int y = y1; y <= y2; y++)
        if (grid[x][y] == value)
          return false;

    // when value not present in row, col and bounding box (3x3)
    return true;
  }

  static Cell nextCell(Cell cur) {

    int row = cur.row;
    int col = cur.col;

    col++;

    if (col > 8) {
      // goto next line
      col = 0;
      row++;
    }

    // reached end of matrix, return null
    if (row > 8)
      return null; // reached end

    Cell next = new Cell(row, col);
    return next;
  }

  static boolean solve(Cell cur) // returns true sudoku is solved
  {

    if (cur == null) // when we have reached the end of sudoku
      return true;

    if (grid[cur.row][cur.col] != 0) // When there is already a value there
      return solve(nextCell(cur));   // Determines state of solution

    for (int i = 1; i <= 9; i++) {
      // update valid when solution is Valid
      boolean valid = legal(cur, i);

      if (!valid)
        continue; // Try other values

      grid[cur.row][cur.col] = i;

      boolean solved = solve(nextCell(cur));

      if (solved)
        return true;
      else
        grid[cur.row][cur.col] = 0; // reset
    }
    return false;
  }

  public static void display() {
    System.out.println();
    for (int i = 0; i < 9; i++) {
      if (i % 3 == 0 && i != 0) // to display _ _ _
      {
        for (int k = 0; k < 15; k++)
          System.out.print("_ ");
        System.out.println("\n");
      }
      for (int j = 0; j < 9; j++) {
        if (j % 3 == 0 && j != 0) // to display |
          System.out.print("| ");
        if (grid[i][j] != 0)
          System.out.print(grid[i][j] + "  ");
        else
          System.out.print("   ");
      }
      System.out.println();
    }
    System.out.println();
  }

  public static void main(String[] args) {
    Solver obj = new Solver();

    System.out.println("Your Sudoku");
    obj.display();

    boolean solved = solve(new Cell(0, 0));
    if (!solved) // When solved = false
    {
      System.out.println("SUDOKU cannot be solved.");
      return;
    }

    System.out.println("Solution of above Sudoku");
    obj.display();
  }
}
/*
3 0 6 5 0 8 4 0 0
5 2 0 0 0 0 0 0 0
0 8 7 0 0 0 0 3 1
0 0 3 0 1 0 0 8 0
9 0 0 8 6 3 0 0 5
0 5 0 0 9 0 6 0 0
1 3 0 0 0 0 2 5 0
0 0 0 0 0 0 0 7 4
0 0 5 2 0 6 3 0 0
*/