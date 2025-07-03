import javax.swing.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
//Tuve que meter 2 imports para que sirvieran algunas cosas

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
        JPanel panelRegistro = new JPanel(new GridLayout(4, 2));

        campoNombre = new JTextField();
        campoEspecie = new JTextField();
        campoDueno = new JTextField();

        panelRegistro.add(new JLabel("Nombre: "));
        panelRegistro.add(campoNombre);
        panelRegistro.add(new JLabel("Especie: "));
        panelRegistro.add(campoEspecie);
        panelRegistro.add(new JLabel("Dueno: "));
        panelRegistro.add(campoDueno);

        JButton botonRegitrar = new JButton("Registrar e ingresar a la fila");
        JButton botonAtender = new JButton("Atender mascota");

        panelRegistro.add(botonRegitrar);
        panelRegistro.add(botonAtender);

        add(panelRegistro, BorderLayout.NORTH);


        //ahora para la informacion
        JPanel panelCentro = new JPanel(new GridLayout(1, 3));

        areaCola = new JTextArea();
        areaCola.setEditable(false);
        areaCola.setBorder(BorderFactory.createTitledBorder("Cola de Atencion"));
        panelCentro.add(new JScrollPane(areaCola));

        areaArbol = new JTextArea();
        areaArbol.setEditable(false);
        areaArbol.setBorder(BorderFactory.createTitledBorder("Mascotas Registradas"));
        panelCentro.add(new JScrollPane(areaArbol));

        areaActual = new JTextArea();
        areaActual.setEditable(false);
        areaActual.setBorder(BorderFactory.createTitledBorder("Mascota Atendida"));
        panelCentro.add(new JScrollPane(areaActual));

        add(panelCentro, BorderLayout.CENTER);


        
        //Ahora conectar el gui con el programa en si

    }




    //para ir probando cada cosa del gui
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            VentanaClinica ventana = new VentanaClinica();
            ventana.setVisible(true);
        });
    }
}
