public class GameOfLife extends javax.swing.JPanel {

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
