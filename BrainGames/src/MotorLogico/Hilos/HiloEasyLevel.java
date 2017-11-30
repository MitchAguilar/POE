/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MotorLogico.Hilos;

import Core.EasyCore;
import MotorLogico.Sound;
import MotorVisual.GameViewOneLevel;
import MotorVisual.GameViewTwoLevel;

/**
 *
 * @author Usuario
 */
public class HiloEasyLevel extends Thread {

    EasyCore ec;
    GameViewOneLevel fr;

    public void Str() {
        fr.puntos.setText((Integer.parseInt(fr.puntos.getText()) + 1) + "");
        resume();
    }

    public HiloEasyLevel(EasyCore ec, GameViewOneLevel fr) {
        this.ec = ec;
        this.fr = fr;
    }
    String arr[];
    public void run() {
        //primera secuencia
        arr = ec.Mov1().split("-");
        fr.setBansera1(Integer.parseInt(arr[1]));
        fr.setBandera2(Integer.parseInt(arr[0]));
        suspend();
        
        arr = ec.Mov2().split("-");
        fr.setBansera1(Integer.parseInt(arr[1]));
        fr.setBandera2(Integer.parseInt(arr[0]));
        suspend();
        
        arr = ec.Mov3().split("-");
        fr.setBansera1(Integer.parseInt(arr[1]));
        fr.setBandera2(Integer.parseInt(arr[0]));
        suspend();
        
        arr = ec.Mov4().split("-");
        fr.setBansera1(Integer.parseInt(arr[1]));
        fr.setBandera2(Integer.parseInt(arr[0]));
        suspend();
        
        arr = ec.Mov5().split("-");
        fr.setBansera1(Integer.parseInt(arr[1]));
        fr.setBandera2(Integer.parseInt(arr[0]));
        suspend();
        
        arr = ec.Mov6().split("-");
        fr.setBansera1(Integer.parseInt(arr[1]));
        fr.setBandera2(Integer.parseInt(arr[0]));
        suspend();
        
        arr = ec.Mov7().split("-");
        fr.setBansera1(Integer.parseInt(arr[1]));
        fr.setBandera2(Integer.parseInt(arr[0]));
        suspend();
        
        arr = ec.Mov8().split("-");
        fr.setBansera1(Integer.parseInt(arr[1]));
        fr.setBandera2(Integer.parseInt(arr[0]));
        suspend();
        
        arr = ec.Mov9().split("-");
        fr.setBansera1(Integer.parseInt(arr[1]));
        fr.setBandera2(Integer.parseInt(arr[0]));
        suspend();
        
        arr = ec.Mov10().split("-");
        fr.setBansera1(Integer.parseInt(arr[1]));
        fr.setBandera2(Integer.parseInt(arr[0]));
        suspend();
        Sound.epic.stop();
        fr.dis();
        fr.ht.stop();
        GameViewTwoLevel gm= new GameViewTwoLevel();
    }
}
