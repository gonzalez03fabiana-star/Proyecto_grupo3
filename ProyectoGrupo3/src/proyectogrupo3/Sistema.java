/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectogrupo3;

import javax.swing.JOptionPane;

/**
 *
 * @author gonza
 */
public class Sistema {

    static Empleado[] listaEmpleados = new Empleado[15];
    static int cantidadEmpleados = 0;
    static Cine[] listaSalas = new Cine[3];
    static int cantidadSalas = 0;
    static ClaseBaile [] listaBaile = new ClaseBaile[1];
    static ClaseYoga [] listaYoga = new ClaseYoga[1];
       // se agrega las variable de las clases y la cantidad de clases
    static int cantidadClases = 0;

    /**
     * Metodo para precargar los datos de los empleados y las salas de cine
     */
    public static void precargarDatos() {
        listaEmpleados[cantidadEmpleados++] = new Empleado(101, "Alberto Ramirez", "Finanzas");
        listaEmpleados[cantidadEmpleados++] = new Empleado(102, "Susana Martinez", "Recursos humanos");
        listaEmpleados[cantidadEmpleados++] = new Empleado(103, "Rogelio Orozco", "Auditoria");
        listaEmpleados[cantidadEmpleados++] = new Empleado(104, "Guillermo Gonzalez", "ITS");
        listaEmpleados[cantidadEmpleados++] = new Empleado(105, "Edward Sanchez", "ITS");
        listaEmpleados[cantidadEmpleados++] = new Empleado(106, "Maria Montero", "Ventas");
        listaEmpleados[cantidadEmpleados++] = new Empleado(107, "Fabiola Lopez", "Finanzas");
        listaEmpleados[cantidadEmpleados++] = new Empleado(108, "Andres Mora", "Contabilidad");
        listaEmpleados[cantidadEmpleados++] = new Empleado(109, "Andrea Hernandez", "Finanzas");
        listaEmpleados[cantidadEmpleados++] = new Empleado(110, "Ariana Jimenez", "Recursos humanos");

        boolean[][] ocupadoA = new boolean[5][6];
        int[][] idEmpA = new int[5][6];
        iniciarId(idEmpA);
        listaSalas[cantidadSalas++] = new Cine(" Sala A", "\nTelefono negro 2", ocupadoA, idEmpA);

        boolean[][] ocupadoB = new boolean[5][5];
        int[][] idEmpB = new int[5][5];
        iniciarId(idEmpB);
        listaSalas[cantidadSalas++] = new Cine(" Sala B", "\nLos ilusionistas 3", ocupadoB, idEmpB);

        boolean[][] ocupadoC = new boolean[5][5];
        int[][] idEmpC = new int[5][5];
        iniciarId(idEmpC);
        listaSalas[cantidadSalas++] = new Cine(" Sala C", "\nJujutsu Kaisen Ejecucion", ocupadoC, idEmpC);
        
        boolean[] ocupadoBaile1 = new boolean[30];
        int[] idBaile1 = new int[30];
        iniciarIdSimple(idBaile1);
        listaBaile[cantidadClases] = new ClaseBaile("Salsa", "Marcos", ocupadoBaile1, idBaile1);
        
        
        boolean[] ocupadoYoga1 = new boolean[30];
        int[] idYoga1 = new int[30];
        iniciarIdSimple(idYoga1);
        listaYoga[cantidadClases] = new ClaseYoga("Yoga Relax", "Lucía", ocupadoYoga1, idYoga1);
        

        cantidadClases++;
    }

    public static void iniciarId(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                matriz[i][j] = -1;
            }

        }
    }
    public static void iniciarIdSimple(int[] vec) {
    for (int i = 0; i < vec.length; i++) {
        vec[i] = -1;
      }
    }
    /**
     * Metodo para ver la lista de empleados
     */
    public static void verEmpleados() {
        String mensaje = "Empleados registrados \n\n";
        for (int i = 0; i < cantidadEmpleados; i++) {
            mensaje = mensaje + listaEmpleados[i] + "\n";
        }
        JOptionPane.showMessageDialog(null, mensaje);
    }

    /**
     * Metodo para agregar un empleado
     */
    public static void agregarEmpleado() {
        int id = Integer.parseInt(JOptionPane.showInputDialog("Indique el codigo del empleado que desea agregar: "));
        String nombre = JOptionPane.showInputDialog("Indique el nombre del empleado; ");
        String puesto = JOptionPane.showInputDialog("Indique el puesto del empleado; ");

        listaEmpleados[cantidadEmpleados++] = new Empleado(id, nombre, puesto);

        JOptionPane.showMessageDialog(null, "Empleado agregado");

    }

    /**
     * Metodos para ver las salas de cine
     */
    public static void verSalas() {
        String mensaje = "Ver salas de cine";
        for (int i = 0; i < cantidadSalas; i++) {
            mensaje = mensaje + (i + 1) + listaSalas[i].getNombre() + " - Pelicula: " + listaSalas[i].getPelicula();

        }
        JOptionPane.showMessageDialog(null, mensaje);
    }

    public static void verMapa() { 
        int sala = Integer.parseInt(JOptionPane.showInputDialog("Sala (1-" + cantidadSalas + "):")) - 1;
        String mapa = listaSalas[sala].mostrarSala();
        JOptionPane.showMessageDialog(null, mapa);
        

    }

    /**
     * Metodos para reservar y liberar un asiento
     */
    public static void reservarAsiento() {
        int sala = Integer.parseInt(JOptionPane.showInputDialog("Sala (1-" + cantidadSalas + "):")) - 1;

        int idEmp = Integer.parseInt(JOptionPane.showInputDialog("ID empleado:"));
        String asiento = JOptionPane.showInputDialog("Asiento (Ej: A3):").toUpperCase();

        int fila = asiento.charAt(0) - 'A';
        int col = Integer.parseInt(asiento.substring(1)) - 1;

        boolean reservado = listaSalas[sala].reservar(idEmp, fila, col);

        JOptionPane.showMessageDialog(null, reservado ? "Asiento reservado." : "Ocupado.");

    }

    public static void liberarAsiento() {
        int sala = Integer.parseInt(JOptionPane.showInputDialog("Sala (1-" + cantidadSalas + "):")) - 1;

        String asiento = JOptionPane.showInputDialog("Asiento (Ej: B4):").toUpperCase();

        int fila = asiento.charAt(0) - 'A';
        int col = Integer.parseInt(asiento.substring(1)) - 1;

        boolean libre = listaSalas[sala].liberar(fila, col);

        JOptionPane.showMessageDialog(null, libre ? "Asiento liberado." : "Ya estaba libre.");
    }
     

    //  Metodo para ver clases Baile o Yoga
    public static void verClases(){

        String mensaje = "Listado de Clases:\n\n";

        for (int i = 0; i < cantidadClases; i++) {
            mensaje += (i + 1) + ") Baile: " + listaBaile[i].mostrarSalon() + "\n";
            mensaje += (i + 1) + ") Yoga:  " + listaYoga[i].mostrarSalon() + "\n";
        }

        JOptionPane.showMessageDialog(null, mensaje);
    }
//  Metodo para reservar espacio en las clases 
    public static void reservarEspacio() {

    int tipo = Integer.parseInt(
            JOptionPane.showInputDialog("¿Qué desea reservar?\n1) Baile\n2) Yoga")
    );

    int clase = 0; 
            

    int idEmp = Integer.parseInt(JOptionPane.showInputDialog("ID del empleado:"));

    int espacio = Integer.parseInt(
            JOptionPane.showInputDialog("Número de espacio:")
    ) - 1;
    
    if (espacio < 0 || espacio >= 30) {
    JOptionPane.showMessageDialog(null, "Número de espacio no existe(1–30)");
    
    return;
    }
    boolean reservado;

    if (tipo == 1) {
        reservado = listaBaile[clase].reservar(idEmp, espacio);
    } else {
        reservado = listaYoga[clase].reservar(idEmp, espacio);
    }

    JOptionPane.showMessageDialog(null,
            reservado ? "Espacio reservado correctamente." : "Ese espacio está ocupado.");
}

    //   Metodo para liberar espacio en las clases 
    public static void liberarEspacio() {

    int tipo = Integer.parseInt(
            JOptionPane.showInputDialog("¿Qué desea liberar?\n1) Baile\n2) Yoga")
    );

    int clase = 0; 

    int espacio = Integer.parseInt(
            JOptionPane.showInputDialog("Número de espacio:")
    ) - 1;

    boolean libre;

    if (tipo == 1) {
        libre = listaBaile[clase].liberar(espacio);
    } else {
        libre = listaYoga[clase].liberar(espacio);
    }

    JOptionPane.showMessageDialog(null,
            libre ? "Espacio liberado correctamente." : "Ese espacio ya estaba libre.");
}

    /**
     * Metodo para modificar el nombre de la pelicula
     */
    public static void modificarPelicula() {
        String listado = "Salas disponibles:\n\n";
        for (int i = 0; i < cantidadSalas; i++) {
            listado = listado + (i + 1) + ") " + listaSalas[i].getNombre() + " - Película: " + listaSalas[i].getPelicula() + "\n";
        }

        JOptionPane.showMessageDialog(null, listado);

        // Selección de sala
        int numSala = Integer.parseInt(JOptionPane.showInputDialog("¿Qué sala desea modificar? (1-" + cantidadSalas + "):")) - 1;

        // Nueva película
        String nuevaPelicula = JOptionPane.showInputDialog("Ingrese el nuevo nombre de la película para " + listaSalas[numSala].getNombre() + ":");

        //Actualizacion
        listaSalas[numSala].setPelicula(nuevaPelicula);

        // Confirmación
        JOptionPane.showMessageDialog(null, "Película actualizada correctamente.\nAhora en " + listaSalas[numSala].getNombre() + " se proyecta: " + listaSalas[numSala].getPelicula());

    }

}
