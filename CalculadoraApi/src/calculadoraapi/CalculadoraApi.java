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
    public static void hacerDescarga() throws MalformedURLException, IOException{
        URL url= new URL("http://191.102.85.226/Mitch/ApI/Restar?N1=3456&N2=1237");
        BufferedReader bf= new BufferedReader(new InputStreamReader(url.openStream()));
        File archivo= new File("Descargado.txt");
        BufferedWriter bw= new BufferedWriter(new FileWriter(archivo));
        String cadena;
        while((cadena=bf.readLine())!=null){
            bw.write(cadena);
        }
        bf.close();
        bw.close();
        System.out.println("Archivo exitoso");
    }
    public static void main(String[] args) throws IOException {
        CalculadoraApi a= new CalculadoraApi();
        a.hacerDescarga();
    
    }
}
