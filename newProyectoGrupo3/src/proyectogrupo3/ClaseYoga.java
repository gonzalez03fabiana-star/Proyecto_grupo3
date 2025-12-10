/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectogrupo3;

/**
 *
 * @author PCadmin
 */
public class ClaseYoga {
    private String nombreClase;
    private String instructor;
    private boolean[] ocupado;   
    private int[] idEmpleado;  

    public ClaseYoga(String nombreClase, String instructor, boolean[] ocupado, int[] idEmpleado) {
        this.nombreClase = nombreClase;
        this.instructor = instructor;
        this.ocupado = ocupado;
        this.idEmpleado = idEmpleado;
    }
    // String para mostrar el nombre de la clase y su informacion
    
     public String mostrarSalon() {
        int espaciosOcupados = 0;

   
            for (int i = 0; i < ocupado.length; i++) {
        boolean o = ocupado[i]; // se saca el valor (true/false)
        if (o) {
            espaciosOcupados++; 
                  }
            }   
            int espaciosLibres = ocupado.length - espaciosOcupados;

    
         return "Clase: " + nombreClase 
                 + " | Instructor: " + instructor + " | Hora: 7PM\n"
                 + "Ocupados: " + espaciosOcupados + " | Libres: " + espaciosLibres;
        }
    
 //Metodo para reservar espacio en la clase 
   

    public boolean reservar(int idEmp, int espacio) {
        
        if (ocupado[espacio]) 
            return false;
        
        ocupado[espacio] = true;
        this.idEmpleado[espacio] = idEmp;

        return true;
    }

    //Metodo para liberar espacio en la clase 

    public boolean liberar(int espacio) {
        if (!ocupado[espacio]) {
            return false;
        }
        ocupado[espacio] = false;
        this.idEmpleado[espacio] = -1;

        return true;
    }
}
