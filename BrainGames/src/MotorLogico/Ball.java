package MotorLogico;

import java.awt.Color;
import java.awt.Graphics;

public class Ball {
    
    private float mAnguloActual = 0.0f;
    private float mAnguloDelta = 0.01f;
    
    private int mRadioMax = 100 ; 
    
    private int mRadioBola = 5;
    
    private int mX = 0;
    private int mY = 0;
    
    private int mK = 5;
    
    private int mXOffset = 0;
    private int mYOffset = 0;
    
    private Color mColor = Color.red;
    
    double maxAngle = Math.PI ;
    
    double angleOffset = 1.0;
    
    public Ball() {
     
    }
    
    public void actualizarEstado() {
    
        mAnguloActual += mAnguloDelta;
        
        double r = Math.cos( (double)mK * ( mAnguloActual - angleOffset ) );
        
        double radio =  r * (double)mRadioMax ;
    
        mX = (int)( Math.cos( mAnguloActual  ) * radio );
        mY = (int)( Math.sin( mAnguloActual  ) * radio );
        
        mX += mXOffset;
        mY += mYOffset;
                
    }
    
    public void dibujarse( Graphics g )    
    {
        g.setColor(mColor);
        g.fillOval(mX, mY, mRadioBola*2, mRadioBola*2);
    }

    public void setAnguloDelta(float mAnguloDelta) {
        this.mAnguloDelta = mAnguloDelta;
    }

    public float getAnguloDelta() {
        return mAnguloDelta;
    }

    public void setRadioMax(int mRadioMax) {
        this.mRadioMax = mRadioMax;
    }

    public int getRadioMax() {
        return mRadioMax;
    }

    public void setRadioBola(int mRadioBola) {
        this.mRadioBola = mRadioBola;
    }

    public int getRadioBola() {
        return mRadioBola;
    }

    public int getX() {
        return mX;
    }

    public int getY() {
        return mY;
    }

    public void setK(int mK) {
        this.mK = mK;
    }

    public int getK() {
        return mK;
    }

    public void setXOffset(int mXOffset) {
        this.mXOffset = mXOffset;
    }

    public int getXOffset() {
        return mXOffset;
    }

    public void setYOffset(int mYOffset) {
        this.mYOffset = mYOffset;
    }

    public int getYOffset() {
        return mYOffset;
    }

    public void setColor(Color mColor) {
        this.mColor = mColor;
    }

    public Color getColor() {
        return mColor;
    }
}
