package inicio;

import java.awt.Button;
import java.awt.Canvas;
import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Label;
import java.awt.List;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Views implements ActionListener{
    
    Frame a;//es el lienzo por decirlo así, es donde vamos a pintar los componentes
    Button b;//es un componente de tipo boton
    TextArea c;//es un compoenente de tipo area de texto
    TextField d;//es un componente de tipo campo de texto
    Label f;//es un compoente de tipo label o etiqueta de texto
    Canvas g;//es un componente para pintar (buscar más información)
    List h;//es un componente de tipo lista de opciones
    Checkbox i;//es un componente de tipo casilla chequeable
    
    public void Componets() {//metodo que construe los componentes
        f = new Label("!Hello World¡");// creando el nuevo componente
        f.setBounds((600-90)/2, 30, 90, 30);// asignando la posicion (pos en x,pos en y,ancho,largo) parecido la plano caesiano
        
        c= new TextArea();// creando nuevo componente
        c.setBounds(0, 70, 200, 150);//asignando la posicion (pos en x,pos en y,ancho,largo) parecido la plano caesiano
        
        d= new TextField();//creando nuevo componente
        d.setBounds(110, 250, 150, 20);//asignando la posicion (pos en x,pos en y,ancho,largo) parecido la plano caesiano
        
        b= new Button("Quit");//creando nuevo componente
        b.setBounds(280, 250, 50, 20);//asignando la posicion (pos en x,pos en y,ancho,largo) parecido la plano caesiano
        b.addActionListener(this);
        
        i= new Checkbox("Check");//creando nuevo componente
        i.setBounds(340, 250, 70, 20);//asignando la posicion (pos en x,pos en y,ancho,largo) parecido la plano caesiano
        
        h= new List();//creando nuevo componente
        h.setBounds(400, 70, 200,150 );//asignando la posicion (pos en x,pos en y,ancho,largo) parecido la plano caesiano
        h.add("List Item 1");//adjuntano nuevo item a la lista
        h.add("List Item 2");
        h.add("List Item 3");
        h.add("List Item 4");
        h.add("List Item 5");
        h.add("List Item 6");
        h.add("List Item 7");
        h.add("List Item 8");
        h.add("List Item 9");
        h.add("List Item 10");
        
        g= new Canvas();//creando nuevo componente
        g.setBounds(220, 70, 160, 160);//asignando la posicion (pos en x,pos en y,ancho,largo) parecido la plano caesiano
        g.setBackground(Color.LIGHT_GRAY);//dandole un color de fondo
        
        
    }
    
    public void VFrame() {//metodo para crear el frame o lienzo
        a = new Frame("First Frame");//creando componente
        a.setSize(600, 300);//asignando tamaño, ancho largo
        
        a.add(f);//adjuntando al lienzo los otros componentes
        a.add(c);//adjuntando al lienzo los otros componentes
        a.add(d);//adjuntando al lienzo los otros componentes
        a.add(b);//adjuntando al lienzo los otros componentes
        a.add(i);//adjuntando al lienzo los otros componentes
        a.add(h);//adjuntando al lienzo los otros componentes
        a.add(g);//adjuntando al lienzo los otros componentes
        
        a.setLayout(null);//instrucción para que no tome layouts (consultar más)
        a.setResizable(false);// para que no permita ampliar la ventana
        a.setVisible(true);//para que se vea la ventana
        a.setLocationRelativeTo(null);//para que aparezca en el centro cuando se inicia
        a.addWindowListener(new WindowAdapter() {//oara cerrar la ventana y el proceso
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        }
        );
    }
    
    public Views() {//constructor
        Componets();//primero se crean los componentes
        VFrame();//luego el lienzo, respetar el orden de ésto
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(b)){
//            a.dispose();
            MyCanvas aaaa =new MyCanvas();
            
        }
    }
}
