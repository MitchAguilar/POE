package calculadoraapi;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class CalculadoraApi {

    public static String Operaciones(String oper) throws MalformedURLException, IOException {
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
}
