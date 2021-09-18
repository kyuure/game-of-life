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

  // GameOfLife class
  public GameOfLife() {
    // 
  }

  // For canvas
  @Override
  public void paintComponent(Graphics g) {
    // 
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
