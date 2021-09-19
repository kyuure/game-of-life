// For canvas.
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;;
// Anything other than canvas.
import java.lang.Thread;
import java.util.Random;


public class GameOfLife extends Canvas {
  // I forgot what this variable used for...
  private static final long serialVersionUID = 1L;

  // Window and canvas size.
  private static int windowX = 750;
  private static int windowY = 500;

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
    // Generate a random cells' status (grid array). 0 or 1 (dead or alive).
    for(int y = 0; y < grid.length; y++) {
      for(int x = 0; x < grid[y].length; x++) {
        this.grid[y][x] = rand.nextInt(2);
      }
    }
  }

  // For canvas.
  @Override
  public void paint(Graphics g) {
    // Access paint superclass constructor.
    super.paint(g);

    // GameOfLife object
    GameOfLife gol = new GameOfLife();

    //-------------------------------Draw Section-------------------------------
    // Draw the cells and copy the grid.
    for(int y = 0; y < grid.length; y++) {
      for(int x = 0; x < grid[y].length; x++) {
        if(grid[y][x] == 1) {
          // Set color to black.
          g.setColor(Color.BLACK);
          g.fillRect(x*squareSize, y*squareSize, squareSize, squareSize);
        } else {
          g.setColor(Color.WHITE);
          g.fillRect(x*squareSize, y*squareSize, squareSize, squareSize);
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
            if(    ((y+b) < 0 || (y+b) >= grid.length)
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

    // Sleep for 10 seconds?.
    try{Thread.sleep(150);}catch(InterruptedException ie){}
    // Repaint.
    repaint();
  }

  // Main function.
  public static void main(String[] args) throws InterruptedException {
    java.awt.EventQueue.invokeLater(new Runnable() {
      @Override
      public void run() {
        // Create new frame.
        JFrame frame = new JFrame();

        // Setting for window.
        frame.setSize(windowX, windowY+30);
        frame.setTitle("Game of Life, CA, salsa's version");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Draw and show it.
        frame.add(new GameOfLife());
        frame.setVisible(true);
      }
    });
  }
}
