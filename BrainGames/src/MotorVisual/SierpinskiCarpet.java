/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MotorVisual;

/**
 *
 * @author Usuario
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class SierpinskiCarpet extends JPanel {

    private final int dim = 513;
    private final int margin = 20;
    private static Color colorRelleno = Color.WHITE;
    private static Color colorFondo = Color.BLACK;
    private int limit = dim;
    private JFrame f;
    Cursor c;

    public SierpinskiCarpet() {
        setPreferredSize(new Dimension(dim + 2 * margin, dim + 2 * margin));
        setBackground(colorFondo);
        setForeground(colorRelleno);
        new Timer(1000, (ActionEvent e) -> {
            limit /= 3;
            if (limit <= 3) {
                limit = dim;
            }
            repaint();
        }).start();
    }

    void drawCarpet(Graphics2D g, int x, int y, int size) {
        if (size < limit) {
            return;
        }
        size /= 3;
        for (int i = 0; i < 9; i++) {
            if (i == 4) {
                g.fillRect(x + size, y + size, size, size);
            } else {
                drawCarpet(g, x + (i % 3) * size, y + (i / 3) * size, size);
            }
        }
    }

    @Override
    public void paintComponent(Graphics gg) {
        super.paintComponent(gg);
        Graphics2D g = (Graphics2D) gg;
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g.translate(margin, margin);
        drawCarpet(g, 0, 0, dim);
    }

    public void main() {
        SwingUtilities.invokeLater(() -> {
            f = new JFrame();
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.setTitle("Sierpinski Carpet");
            f.setUndecorated(true);
            f.setResizable(false);
            f.add(new SierpinskiCarpet(), BorderLayout.CENTER);
            f.pack();
            f.setLocationRelativeTo(null);
            f.setVisible(true);
            Toolkit tk = Toolkit.getDefaultToolkit();
            Image iconoMaus = new ImageIcon(getClass().getResource("/Complements/Img/7.png")).getImage(); //Icono
            c = tk.createCustomCursor(iconoMaus, new Point(1, 1), "String");
            f.setCursor(c);
        });
    }

    public void Exit() {
        f.dispose();
    }
}
