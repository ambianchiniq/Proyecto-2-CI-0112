import javax.swing.*;
import java.io.*;

public class VentanaClinica extends JFrame {
    private ArbolMascotas arbol;
    private ColaAtencion<Mascota> cola;


    private JTextField campoNombre, campoEspecie, campoDueno;
    private JTextArea areaCola, areaArbol, areaActual;

    public VentanaClinica() {
        setTitle("Clinica Veterniaria");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); //Centra la ventana

        arbol = new ArbolMascotas();
        cola = new ColaAtencion<>();

        setLayout(new BorderLayout());


        //ahora el menu 
        JMenuBar menuBar = new JMenuBar();
        JMenu menuArchivo = new JMenu("Archivo");

        JMenuItem itemGuardar = new JMenuItem("Guardar");
        JMenuItem itemCargar = new JMenuItem("Cargar");
        JMenuItem itemSalir = new JMenuItem("Salir");

        menuArchivo.add(itemGuardar);
        menuArchivo.add(itemCargar);

        menuArchivo.addSeparator();

        menuArchivo.add(itemSalir);
        menuBar.add(menuArchivo);
        setJMenuBar(menuBar);


        //ahora para registrar a la mascota

    }
}