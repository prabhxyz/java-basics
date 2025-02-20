import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class swing3d extends JPanel implements ActionListener {
    private Timer timer;
    private double angle = 0;

    private double[][] cube = {
            {-1, -1, -1},
            {-1, -1,  1},
            {-1,  1, -1},
            {-1,  1,  1},
            { 1, -1, -1},
            { 1, -1,  1},
            { 1,  1, -1},
            { 1,  1,  1}
    };

    private int[][] edges = {
            {0, 1}, {0, 2}, {0, 4},
            {1, 3}, {1, 5},
            {2, 3}, {2, 6},
            {3, 7},
            {4, 5}, {4, 6},
            {5, 7},
            {6, 7}
    };

    public swing3d() {
        timer = new Timer(16, this);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        angle += 0.02; // increment rotation angle
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, getWidth(), getHeight());

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int cx = getWidth() / 2;
        int cy = getHeight() / 2;

        double[][] transformed = new double[cube.length][3];

        for (int i = 0; i < cube.length; i++) {
            double x = cube[i][0];
            double y = cube[i][1];
            double z = cube[i][2];

            double x1 = x * Math.cos(angle) - z * Math.sin(angle);
            double z1 = x * Math.sin(angle) + z * Math.cos(angle);

            double y1 = y * Math.cos(angle) - z1 * Math.sin(angle);
            double z2 = y * Math.sin(angle) + z1 * Math.cos(angle);

            transformed[i][0] = x1;
            transformed[i][1] = y1;
            transformed[i][2] = z2;
        }

        double d = 2.0;
        int[] screenX = new int[transformed.length];
        int[] screenY = new int[transformed.length];

        for (int i = 0; i < transformed.length; i++) {
            double x = transformed[i][0];
            double y = transformed[i][1];
            double z = transformed[i][2] + 5;

            double factor = d / z;
            screenX[i] = (int) (x * factor * cx) + cx;
            screenY[i] = (int) (y * factor * cx) + cy;
        }

        g2d.setColor(Color.BLACK);
        for (int[] edge : edges) {
            int i1 = edge[0];
            int i2 = edge[1];
            g2d.drawLine(screenX[i1], screenY[i1], screenX[i2], screenY[i2]);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Simple 3D Cube Game");
        swing3d game = new swing3d();
        frame.add(game);
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); // center the window on screen
        frame.setVisible(true);
    }
}
