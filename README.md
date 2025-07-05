# Proyecto-2-CI-0112
Clinica Veterniaria

Estructuras Implementadas

- `ColaAtencion<T>`: lista enlazada simple con operaciones FIFO.
- `ArbolMascotas`: árbol binario de búsqueda con recorrido inorden, inserción, búsqueda y eliminación.
- `Mascota`: clase base con atributos `id`, `nombre`, `especie` y `dueño`.

Funcionalidades Principales

- Registro de mascotas con generación automática de ID único.
- Al llegar una mascota, se registra (si no existe) y se encola.
- El veterinario atiende a las mascotas por orden de llegada (FIFO).
- Visualización del historial de mascotas en orden usando recorrido inorden.
- Guardado y carga desde archivo `.txt`, persistiendo toda la información.
- Interfaz gráfica amigable usando `JTextField`, `JButton`, `JTextArea`, `JMenuItem`, entre otros componentes de Swing.

Instrucciones de Uso

1. Compilar:

   Desde consola o terminal, en el mismo directorio de los archivos `.java`:
   javac *.java

2. Ejecutar:
   java VentanaClinica

3. Interfaz:
  Usá el menú superior para guardar o cargar mascotas.

  Registrá mascotas desde el panel de registro y agregalas a la cola.

  Visualizá mascotas atendidas y las que están en espera.

  Todo se guarda en mascotas_guardadas.txt.
