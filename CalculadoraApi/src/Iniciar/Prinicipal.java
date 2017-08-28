package Iniciar;

import Frames.CalApi;
import Frames.CalNormal;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class Prinicipal {

    public static void main(String[] args) throws MalformedURLException, IOException {
//        CalNormal A = new CalNormal();
//        CalApi B = new CalApi();
        URL url = new URL("http://191.102.85.226/Mitch/Api/Register");
        BufferedReader bf = new BufferedReader(new InputStreamReader(url.openStream()));
        File archivo = new File("Descargado.txt");
        BufferedWriter bw = new BufferedWriter(new FileWriter(archivo));
        String cadena;
        String Response = null;
        while ((cadena = bf.readLine()) != null) {
            bw.write(cadena);
            Response = cadena;
        }
        String que[]=Response.split(",");
        for (int i = 0; i < que.length; i++) {
            System.out.println(que[i]);
        }
        bf.close();
        bw.close();

    }

}
