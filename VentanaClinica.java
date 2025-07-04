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

        JButton botonRegistrar = new JButton("Registrar e ingresar a la fila");
        JButton botonAtender = new JButton("Atender mascota");

        panelRegistro.add(botonRegistrar);
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
        //este boton es el de agregar a la cola
        botonRegistrar.addActionListener(e -> {
            String nombre = campoNombre.getText().trim();//trim para quitar espacios al inicio y final por si acaso
            String especie = campoEspecie.getText().trim();
            String dueno = campoDueno.getText().trim();

            //Por si les falta poner alguna cosa y no se salve sin nada
            if (nombre.isEmpty() || especie.isEmpty() || dueno.isEmpty()){
                JOptionPane.showMessageDialog(this, "Complete todos los campos por favor.");
                return;
            }

            int id = GeneradorIds.generarNuevoId();
            Mascota m = new Mascota(id, nombre, especie, dueno);

            arbol.insertar(m);
            cola.agregarFinal(m);
            actualizarPantallas();//metodo para actualizar y que salga de una vez en la cola

            campoNombre.setText("");
            campoEspecie.setText("");
            campoDueno.setText("");

        });

        //este botono es para atender a la mascota
        botonAtender.addActionListener(e -> {
            //Si no hay mascotas en la cola
            if (cola.estaVacia()) {
                JOptionPane.showMessageDialog(this, "No hay mascotas en la fila.");
                return;
            }

            Mascota atendida = cola.eliminarInicio("No hay mascotas para atender.");
            areaActual.setText(atendida.toString());
            actualizarPantallas();

        });

        itemSalir.addActionListener(e -> System.exit(0)); // boton de salir

        //para guardar y cargar
        itemGuardar.addActionListener(e -> {
            ArchivoMascotas.guardarEnArchivo(arbol);
        })
        itemCargar.addActionListener(e -> JOptionPane.showMessageDialog(this, "Funcion de cargar"));


    }


    //metodo actualizar pantalla
    private void actualizarPantallas() {
        //actualiza la cola
        StringBuilder sbCola = new StringBuilder();
        NodoCola<Mascota> actual = cola.getFrente();
        while(actual != null) {
            //es para poner el nombre de la mascota y la especie 
            sbCola.append(actual.getDato().getNombre());
            sbCola.append(" - ");
            sbCola.append(actual.getDato().getEspecie());
            sbCola.append("\n");
            actual = actual.getSiguiente();
        }

        areaCola.setText(sbCola.toString());

        //tambien hay que actualizar el arbol:
        String[] mascotas = arbol.obtenerMascotasOrdenadas();
        StringBuilder sbArbol = new StringBuilder();
        for(int i = 0; i < mascotas.length; i++){
            sbArbol.append(mascotas[i]).append("\n");
        }
        areaArbol.setText(sbArbol.toString());
    }


    //para ir probando cada cosa del gui
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            VentanaClinica ventana = new VentanaClinica();
            ventana.setVisible(true);
        });
    }
}
