/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectomusica;

import java.io.BufferedInputStream;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author estudiante
 */
public class Sonido {

    Sonido(String x) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        BufferedInputStream bis = new BufferedInputStream(getClass().getResourceAsStream(x));
        AudioInputStream ais = AudioSystem.getAudioInputStream(bis);
        Clip sonido = AudioSystem.getClip();
        sonido.open(ais);
        sonido.start();
    }
}
