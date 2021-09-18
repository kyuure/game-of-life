import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Polygon;
import java.awt.event.*;
import java.lang.Math;
import javax.swing.*;


public class GameOfLife extends javax.swing.JPanel {
  // I forgot what this variable used for...
  private static final long serialVersionUID = 1L;

  // For canvas variable. This variable will be declared publicly so that main
  // function can access it.
  public static Image buffer;
  public static Graphics bg;
  // Window and canvas size
  private int windowX = 750;
  private int windowY = 500;

  // GameOfLife class
  public GameOfLife() {
    // Set size for canvas (the same as window size).
    setPreferredSize(new Dimension(windowX, windowY));
  }

  // For canvas
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

    // Draw the image from buffer onto canvas
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
