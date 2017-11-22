package MotorLogico;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import java.util.LinkedList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MathFuncPanel extends DBPanel implements KeyListener {

    private LinkedList<Ball> mElementos = new LinkedList<Ball>();

    private boolean mLimpiarFondo = true;

    int ultimoK = 5;

    public MathFuncPanel() {
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Thred th = new Thred(this);
        th.start();
    }

    public static class Thred extends Thread {

        MathFuncPanel Aux;

        public Thred(MathFuncPanel Aux) {
            this.Aux = Aux;
        }

        public void run() {
            try {
                sleep(100);
                Aux.initv();
            } catch (InterruptedException ex) {
                Logger.getLogger(MathFuncPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void jbInit() throws Exception {
        this.setLayout(null);
    }

    public void initv() {
        for (int i = 0; i < 10; i++) {
            agregarBola();
            agregarBola2();
        }
        iniciar();
    }

    public void keyTyped(KeyEvent e) {
    }

    public void actualizarEstado() {

        for (Ball e : mElementos) {
            e.actualizarEstado();
        }

    }

    public void dibujarBuffer() {

        if (mLimpiarFondo) {
            this.bufferG.clearRect(0, 0, buffer.getWidth(),
                    buffer.getHeight());
        }

        for (Ball e : mElementos) {
            e.dibujarse(this.bufferG);
        }

    }

    private void iniciarFunc() {

        if (isRunning) {
            return;
        }

        Ball b = new Ball();

        int mx = (int) (this.getWidth() / 2.0);
        int my = (int) (this.getHeight() / 2.0);

        b.setXOffset(mx);
        b.setYOffset(my);

        mElementos.add(b);

        this.iniciar();

    }

    public Color getRandColor() {
        int r = (int) (Math.random() * 255);
        int g = (int) (Math.random() * 255);
        int b = (int) (Math.random() * 255);
        return new Color(r, g, b);
    }

    void agregarBola() {

        Ball b = new Ball();

        b.setColor(getRandColor());

        Random r = new Random();

        b.setAnguloDelta((float) Math.pow(-1, r.nextInt(2)) * r.nextInt(10)
                * 0.002f + 0.002f);

        ultimoK = r.nextInt(7) + 1;
        b.setK(ultimoK);

        b.setRadioMax(Math.min(this.getWidth(), this.getHeight()) / 2);

        int mx = (int) (this.getWidth() / 2.0);
        int my = (int) (this.getHeight() / 2.0);

        b.setXOffset(mx);
        b.setYOffset(my);

        mElementos.add(b);

    }

    void agregarBola2() {
        Ball b = new Ball();

        b.setColor(getRandColor());

        Random r = new Random();

        b.setAnguloDelta((float) Math.pow(-1, r.nextInt(2)) * r.nextInt(10)
                * 0.002f + 0.002f);

        b.setK(ultimoK);

        b.setRadioMax(Math.min(this.getWidth(), this.getHeight()) / 2);

        int mx = (int) (this.getWidth() / 2.0);
        int my = (int) (this.getHeight() / 2.0);

        b.setXOffset(mx);
        b.setYOffset(my);

        mElementos.add(b);
    }

    void cambiarColores() {
        for (Ball e : mElementos) {
            e.setColor(getRandColor());
        }
    }

    void quitarBola() {
        if (mElementos.size() > 1) {
            mElementos.removeLast();
        }
    }

    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_S: {
                iniciarFunc();
                break;
            }
            case KeyEvent.VK_F: {
                mLimpiarFondo = !mLimpiarFondo;
                break;
            }
            case KeyEvent.VK_R: {
                quitarBola();
                break;
            }
            case KeyEvent.VK_C: {
                cambiarColores();
                break;
            }
            case KeyEvent.VK_A: {
                agregarBola();
                break;
            }
            case KeyEvent.VK_Q: {
                agregarBola2();
                break;
            }
        }
    }

    public void keyReleased(KeyEvent e) {
    }
}
