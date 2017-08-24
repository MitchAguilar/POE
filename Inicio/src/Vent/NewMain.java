/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vent;

import java.awt.Color;
import java.awt.Frame;
import java.awt.HeadlessException;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class NewMain extends Frame {

    public NewMain() throws HeadlessException {
        setSize(300, 400);
        setBackground(Color.PINK);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        }
        );
        setVisible(true);
        setLocationRelativeTo(null);
    }
}
