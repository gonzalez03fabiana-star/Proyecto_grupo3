/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectogrupo3;

/**
 *
 * @author PCadmin
 */
public class ClaseBaile {
    private String nombreEstiloBaile;
    private String profesor;
    private boolean[] ocupado;   
    private int[] idEmpleado;  

    public ClaseBaile(String nombreEstiloBaile, String profesor, boolean[] ocupado, int[] idEmpleado) {
        this.nombreEstiloBaile = nombreEstiloBaile;
        this.profesor = profesor;
        this.ocupado = ocupado;
        this.idEmpleado = idEmpleado;
    }
    
    
     public String mostrarSalon() {
        String salon = "Clase de : " + nombreEstiloBaile + " | Profesor: " + profesor + "\n";

        for (int i = 0; i < ocupado.length; i++) {
            salon += "Espacio" + (i + 1)+ ": "+ (ocupado[i] ? "OCUPADO" : "LIBRE") + "\n"; 
        }
        salon += "\n";

        return salon;
    }

    public boolean reservar(int idEmp, int espacio) {
        if (ocupado[espacio]) 
            return false;
        
        ocupado[espacio] = true;
        this.idEmpleado[espacio] = idEmp;

        return true;
    }

    public boolean liberar(int espacio) {
        if (!ocupado[espacio]) {
            return false;
        }
        ocupado[espacio] = false;
        this.idEmpleado[espacio] = -1;

        return true;
    }
}

