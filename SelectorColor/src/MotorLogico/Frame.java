package MotorLogico;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Hashtable;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author mitch
 */
public class Frame implements ChangeListener, ItemListener {

    JFrame a;
    JLabel b, b1, b2, b3, b4, b5, b6, rgb;
    JPanel c;
    JSlider s, t, u;
    Hashtable h;
    JComboBox jc, jc2, jc3;

    public void Components() {
        s = new JSlider(JSlider.HORIZONTAL, 0, 255, 0);
        s.setBounds(100, 70, 400, 90);
        s.setMajorTickSpacing(30);
        s.setPaintTicks(true);
        s.setMajorTickSpacing(10);
        s.setMinorTickSpacing(30);
        s.setPaintTicks(true);
        s.setPaintLabels(true);
        s.addChangeListener(this);
        s.setOpaque(false);

        t = new JSlider(JSlider.HORIZONTAL, 0, 255, 0);
        t.setBounds(100, 200, 400, 90);
        t.setMajorTickSpacing(30);
        t.setPaintTicks(true);
        t.setMajorTickSpacing(10);
        t.setMinorTickSpacing(30);
        t.setPaintTicks(true);
        t.setPaintLabels(true);
        t.addChangeListener(this);
        t.setOpaque(false);

        u = new JSlider(JSlider.HORIZONTAL, 0, 255, 0);
        u.setBounds(100, 330, 400, 90);
        u.setMajorTickSpacing(30);
        u.setPaintTicks(true);
        u.setMajorTickSpacing(10);
        u.setMinorTickSpacing(30);
        u.setPaintTicks(true);
        u.setPaintLabels(true);
        u.addChangeListener(this);
        u.setOpaque(false);

        //Create the label table
        h = new Hashtable();
        h.put(new Integer(0), new JLabel("0"));
        h.put(new Integer(30), new JLabel("30"));
        h.put(new Integer(60), new JLabel("60"));
        h.put(new Integer(90), new JLabel("90"));
        h.put(new Integer(120), new JLabel("120"));
        h.put(new Integer(150), new JLabel("150"));
        h.put(new Integer(180), new JLabel("180"));
        h.put(new Integer(210), new JLabel("210"));
        h.put(new Integer(255), new JLabel("255"));

        s.setLabelTable(h);
        t.setLabelTable(h);
        u.setLabelTable(h);

        b = new JLabel("Color Selector");
        Font cursiva = new Font("MathJax_Math", Font.ITALIC, 40);
        b.setFont(cursiva);
        b.setBounds(300, 0, 300, 60);

        b1 = new JLabel("R");
        Font cursiva1 = new Font("MathJax_Math", Font.ITALIC, 60);
        b1.setFont(cursiva1);
        b1.setBounds(20, 85, 65, 65);
        b1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED));

        b2 = new JLabel("G");
        Font cursiva2 = new Font("MathJax_Math", Font.ITALIC, 60);
        b2.setFont(cursiva2);
        b2.setBounds(20, 215, 65, 65);
        b2.setBorder(new SoftBevelBorder(BevelBorder.LOWERED));

        b3 = new JLabel("B");
        Font cursiva3 = new Font("MathJax_Math", Font.ITALIC, 60);
        b3.setFont(cursiva3);
        b3.setBounds(20, 345, 65, 65);
        b3.setBorder(new SoftBevelBorder(BevelBorder.LOWERED));

        jc = new JComboBox();
        for (int i = 0; i <= 225; i++) {
            jc.addItem(i);
        }
        jc.setBounds(60, 470, 120, 30);
        jc.addItemListener(this);
        jc.setOpaque(false);

        jc2 = new JComboBox();
        for (int i = 0; i <= 225; i++) {
            jc2.addItem(i);
        }
        jc2.setBounds(200, 470, 120, 30);
        jc2.addItemListener(this);
        jc2.setOpaque(false);

        jc3 = new JComboBox();
        for (int i = 0; i <= 225; i++) {
            jc3.addItem(i);
        }
        jc3.setBounds(340, 470, 120, 30);
        jc3.addItemListener(this);
        jc3.setOpaque(false);

        b4 = new JLabel("R");
        Font cursiva4 = new Font("MathJax_Math", Font.ITALIC, 40);
        b4.setFont(cursiva4);
        b4.setBounds(100, 510, 43, 43);
        b4.setBorder(new SoftBevelBorder(BevelBorder.LOWERED));

        b5 = new JLabel("G");
        Font cursiva5 = new Font("MathJax_Math", Font.ITALIC, 40);
        b5.setFont(cursiva5);
        b5.setBounds(240, 510, 43, 43);
        b5.setBorder(new SoftBevelBorder(BevelBorder.LOWERED));

        b6 = new JLabel("B");
        Font cursiva6 = new Font("MathJax_Math", Font.ITALIC, 40);
        b6.setFont(cursiva6);
        b6.setBounds(380, 510, 43, 43);
        b6.setBorder(new SoftBevelBorder(BevelBorder.LOWERED));

        c = new JPanel();
        c.setBounds(600, 70, 120, 430);
        c.setBackground(new Color(1, 1, 1));
        c.setBorder(BorderFactory.createMatteBorder(8, 2, 2, 2, new Color(255, 255, 255)));

        rgb = new JLabel("RGB(255,255,255)");
        rgb.setBounds(600, 500, 150, 30);

    }

    Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Complements/img.jpg"));

    public void Frame() {
        a = new JFrame("Color Selector");
        a.setSize(800, 600);
        a.setLayout(null);

        a.add(s);
        a.add(t);
        a.add(u);
        a.add(b);
        a.add(b1);
        a.add(b2);
        a.add(b3);
        a.add(jc);
        a.add(jc2);
        a.add(jc3);
        a.add(b4);
        a.add(b5);
        a.add(b6);
        a.add(c);
        a.add(rgb);
        a.setIconImage(icon);

        a.setVisible(true);
        a.setResizable(false);
        a.setLocationRelativeTo(null);
        a.setDefaultCloseOperation(a.EXIT_ON_CLOSE);

        Imagen img = new Imagen("/Complements/img.jpg", a.getWidth(), a.getHeight());
        a.add(img);
        a.repaint();
    }

    public Frame() {
        Components();
        Frame();
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        if (e.getSource() == s || e.getSource() == t || e.getSource() == u) {
            c.setBackground(new Color(s.getValue(), t.getValue(), u.getValue()));
            jc.setSelectedIndex(0);
            jc2.setSelectedIndex(0);
            jc3.setSelectedIndex(0);
            rgb.setText("RGB(" + s.getValue() + "," + t.getValue() + "," + u.getValue() + ")");
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == jc || e.getSource() == jc2 || e.getSource() == jc3) {
            c.setBackground(new Color(jc.getSelectedIndex() + 1, jc2.getSelectedIndex() + 1, jc3.getSelectedIndex() + 1));
            s.setValue(0);
            t.setValue(0);
            u.setValue(0);
            rgb.setText("RGB(" + (jc.getSelectedIndex() + 1) + "," + (jc2.getSelectedIndex() + 1) + "," + (jc3.getSelectedIndex() + 1) + ")");
        }
    }
}
