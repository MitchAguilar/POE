package calculadoraapi;

import com.sun.corba.se.impl.encoding.BufferManagerWrite;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class CalculadoraApi {

    public static String hacerDescarga(String oper) throws MalformedURLException, IOException {
        URL url = new URL("http://191.102.85.226/Mitch/ApI/" + oper);
        BufferedReader bf = new BufferedReader(new InputStreamReader(url.openStream()));
        File archivo = new File("Descargado.txt");
        BufferedWriter bw = new BufferedWriter(new FileWriter(archivo));
        String cadena;
        String Response = null;
        while ((cadena = bf.readLine()) != null) {
            bw.write(cadena);
            Response = cadena;
        }
        bf.close();
        bw.close();
        return Response;
    }

//    public static void main(String[] args) throws IOException {
//        CalculadoraApi a = new CalculadoraApi();
//        int b= (int) (Math.random()*(1+10000));
//        int c= (int) (Math.random()*(1+10000));
//        System.out.println(a.hacerDescarga("Sumar?N1="+b+"&N2="+c));
//        System.out.println(a.hacerDescarga("Restar?N1="+b+"&N2="+c));
//        System.out.println(a.hacerDescarga("Multiplicar?N1="+b+"&N2="+c));
//        System.out.println(a.hacerDescarga("Dividir?N1="+b+"&N2="+c));
//
//    }
}
