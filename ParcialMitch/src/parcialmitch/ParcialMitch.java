/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcialmitch;

import MotorInner.Estudiante;
import MotorLogico.Frame;
import MotorLogico.FrameE;
import java.util.ArrayList;

/**
 *
 * @author estudiante
 */
public class ParcialMitch {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
//        Frame  a = new Frame();
//        FrameE  a = new FrameE();
        ArrayList<Estudiante> arr= new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            Estudiante a=new Estudiante();
            arr.add(a);
        }
        for (int i = 0; i < arr.size(); i++) {
            System.err.println(arr.get(i));
        }
    }
    
}
