package manejoimagenesencompoentes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * Ejemplo5
 */
public class Ejemplo5 {

    private static JFrame frame;

    private static JPanel createExamplePanel() {
        JPanel panel = new JPanel();

        // Componentes de prueba
        JButton button = new JButton("Click");
        button.setPreferredSize(new Dimension(100, 100));
        button.setOpaque(false);
        JTextField textField = new JTextField(25);
        textField.setText("Escribe aqui...");
        textField.setOpaque(false);
        JTextArea textArea = new JTextArea(10, 25);
        textArea.setText("Escribe aqui...");
        textArea.setOpaque(false);

        List<Color> colors = new ArrayList<Color>();
        colors.add(Color.PINK);
        colors.add(Color.RED);

        button.setBorder(new RoundedBorder(colors, 5, 2, 2));

        colors = new ArrayList<Color>();
        colors.add(Color.PINK);
        colors.add(Color.RED);
        colors.add(Color.BLUE);
        colors.add(Color.YELLOW);

        textField.setBorder(new RoundedBorder(colors, 2, 5, 4));

        colors = new ArrayList<Color>();
        colors.add(Color.PINK);
        colors.add(Color.RED);
        colors.add(Color.BLUE);
        textArea.setBorder(new RoundedBorder(colors, 4, 5, 3));

        panel.add(button);
        panel.add(textField);
        panel.add(textArea);

        return panel;
    }

    /**
     * Create the GUI and show it. For thread safety, this method should be
     * invoked from the event dispatch thread.
     */
    private static void createAndShowGUI() {

        // Create and set up the window.
        frame = new JFrame("RoundedBorder");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Component contents = createExamplePanel();
        frame.getContentPane().add(contents, BorderLayout.CENTER);

        // Display the window.
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
  // Schedule a job for the event dispatch thread:
        // creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

}
