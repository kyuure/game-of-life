// For canvas.
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Polygon;
import java.awt.event.*;
import javax.swing.*;
// Anything other than canvas.
import java.lang.Math;
import java.util.Random;


public class GameOfLife extends javax.swing.JPanel {
  // I forgot what this variable used for...
  private static final long serialVersionUID = 1L;

  // For canvas variable. This variable will be declared publicly so that main
  // function can access it.
  public static Image buffer;
  public static Graphics bg;
  // Window and canvas size.
  private int windowX = 750;
  private int windowY = 500;

  // Random object.
  Random rand = new Random();

  // square's size.
  private int squareSize = 10;
  // Grid for cells' status.
  private int[][] grid = new int[windowY/squareSize][windowX/squareSize];
  private int[][] prevGrid = new int[windowY/squareSize][windowX/squareSize];
  // total neighbours.
  private int totalNeighbour;


  // GameOfLife class.
  public GameOfLife() {
    // Set size for canvas (the same as window size).
    setPreferredSize(new Dimension(windowX, windowY));

    // Generate a random cells' status (grid array). 0 or 1 (dead or alive).
    for(int y = 0; y < grid.length; y++) {
      for(int x = 0; x < grid[y].length; x++) {
        this.grid[y][x] = rand.nextInt(2);
      }
    }
  }

  // For canvas.
  @Override
  public void paintComponent(Graphics g) {
    // Create new canvas.
    buffer = createImage(windowX, windowY);
    bg = buffer.getGraphics();

    // Add background color.
    bg.setColor(Color.WHITE);
    bg.fillRect(0, 0, getWidth(), getHeight());

    // GameOfLife object
    GameOfLife gol = new GameOfLife();

    //-------------------------------Draw Section-------------------------------
    // Draw the cells and copy the grid.
    for(int y = 0; y < grid.length; y++) {
      for(int x = 0; x < grid[y].length; x++) {
        if(grid[y][x] == 1) {
          // Set color to black.
          bg.setColor(Color.BLACK);
          bg.fillRect(x*squareSize, y*squareSize, squareSize, squareSize);
        } else {
          bg.setColor(Color.WHITE);
          bg.fillRect(x*squareSize, y*squareSize, squareSize, squareSize);
        }
        // Copy the grid to temporary grid.
        prevGrid[y][x] = grid[y][x];
      }
    }

    //-------------------------------Algo Section-------------------------------
    // Go to every cells and check its cell.
    for(int y = 0; y < grid.length; y++) {
      for(int x = 0; x < grid[y].length; x++) {
        // Initialize the totalNeighbour to 0.
        totalNeighbour = 0;

        // Check every neighbours.
        for(int b = -1; b <= 1; b++) {
          for(int a = -1; a <= 1; a++) {
            if(     ((y+b) < 0 || (y+b) >= grid.length)
                 || ((x+a) < 0 || (x+a) >= grid[y].length)
                 || (a == 0 && b == 0)) {
              continue;
            }
            // Add its value (either dead or alive) to totalNeighbour.
            totalNeighbour = totalNeighbour + prevGrid[y+b][x+a];
          }
        }

        // Check cell status for next generation.
        if(prevGrid[y][x] == 1) {
          // The cell alive.
          if(totalNeighbour < 2 || totalNeighbour > 3) {
            // Dies because of (under/over)population.
            grid[y][x] = 0;
          } else {
            // Statis.
            grid[y][x] = prevGrid[y][x];
          }
        } else {
          // The cell dead.
          if(totalNeighbour == 3) {
            // Become alive due to reporduction.
            grid[y][x] = 1;
          } else {
            // Statis.
            grid[y][x] = prevGrid[y][x];
          }
        }
      }
    }

    // Draw the image from buffer onto canvas.
    g.drawImage(buffer, 0, 0, null);
  }

  // Main function.
  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        javax.swing.JFrame frame = new javax.swing.JFrame("Game of Life, CA, salsa's version");
        frame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);

        frame.getContentPane().add(new GameOfLife());

        frame.setResizable(false);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
      }
    });
  }
}
