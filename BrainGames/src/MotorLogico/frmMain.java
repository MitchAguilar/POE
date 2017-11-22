package MotorLogico;

import MotorVisual.InitialView;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;

public class frmMain extends JFrame {

    private MathFuncPanel mPanel = new MathFuncPanel();
    private BorderLayout borderLayout1 = new BorderLayout();

    public frmMain() {
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Devol dv=new Devol(this);
        dv.start();
    }

    public static class Devol extends Thread{
        JFrame fr;

        public Devol(JFrame fr) {
            this.fr = fr;
        }

        @Override
        public void run() {
            try {
                sleep(5000);
                fr.dispose();
                InitialView intview= new InitialView();
            } catch (InterruptedException ex) {
                Logger.getLogger(frmMain.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void jbInit() throws Exception {
        setUndecorated(true);
        setLocationRelativeTo(null);
        this.getContentPane().setLayout(borderLayout1);
        setResizable(false);
        this.setSize(new Dimension(400, 300));
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        mPanel.setBackground(Color.white);
        this.getContentPane().add(mPanel, BorderLayout.CENTER);
        this.addKeyListener(mPanel);
    }
}
