package MotorLogico;

import java.util.Hashtable;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author mitch
 */
public class Frame implements ChangeListener{

    JFrame a;
    JLabel b;
    JPanel c;
    JSlider s,t,u;
    Hashtable h;

    public void Components() {
        s = new JSlider(JSlider.HORIZONTAL, 0, 255, 0);
        s.setBounds(100, 50, 400, 150);
        s.setMajorTickSpacing(30);
        s.setPaintTicks(true);
        s.setMajorTickSpacing(10);
        s.setMinorTickSpacing(30);
        s.setPaintTicks(true);
        s.setPaintLabels(true);
        s.addChangeListener(this);
        
        t = new JSlider(JSlider.HORIZONTAL, 0, 255, 0);
        t.setBounds(100, 150, 400, 150);
        t.setMajorTickSpacing(30);
        t.setPaintTicks(true);
        t.setMajorTickSpacing(10);
        t.setMinorTickSpacing(30);
        t.setPaintTicks(true);
        t.setPaintLabels(true);
        t.addChangeListener(this);
        
        u = new JSlider(JSlider.HORIZONTAL, 0, 255, 0);
        u.setBounds(100, 250, 400, 150);
        u.setMajorTickSpacing(30);
        u.setPaintTicks(true);
        u.setMajorTickSpacing(10);
        u.setMinorTickSpacing(30);
        u.setPaintTicks(true);
        u.setPaintLabels(true);
        u.addChangeListener(this);
        
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
    }

    public void Frame() {
        a = new JFrame("Selector De Color");
        a.setSize(800, 600);
        a.setLayout(null);

        a.add(s);
        a.add(t);
        a.add(u);

        a.setVisible(true);
        a.setResizable(false);
        a.setLocationRelativeTo(null);
        a.setDefaultCloseOperation(a.EXIT_ON_CLOSE);
    }

    public Frame() {
        Components();
        Frame();
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        
    }
}
