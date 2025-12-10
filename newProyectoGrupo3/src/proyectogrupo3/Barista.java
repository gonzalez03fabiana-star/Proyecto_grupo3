/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectogrupo3;

/**
 *
 * @author PCadmin
 */
public class Barista {
    private int[] idEmpleado;     
    private String[] bebida;      
    private String[] horaEntrega; 
    private int cantidad;         

    public Barista(int maxReservas) {
        idEmpleado = new int[maxReservas];
        bebida = new String[maxReservas];
        horaEntrega = new String[maxReservas];

        for (int i = 0; i < maxReservas; i++) {
            idEmpleado[i] = -1;
            bebida[i] = "";
            horaEntrega[i] = "";
        }

        cantidad = 0;
    }
    
   
    // Confirma si ya se reservo
    public int buscarReserva(int idEmp) {
        for (int i = 0; i < cantidad; i++) {
            if (idEmpleado[i] == idEmp) {
                return i;
            }
        }
        return -1;
    }

    //Metodo para rservar una bebida por empleado
    public boolean reservar(int idEmp, String bebidaSel, String hora) {

        
        if (buscarReserva(idEmp) != -1) {
            return false;
        }

        // si se pasa de la cantidad de empleados
        if (cantidad >= idEmpleado.length) {
            return false;
        }

        
        idEmpleado[cantidad] = idEmp;
        bebida[cantidad] = bebidaSel;
        horaEntrega[cantidad] = hora;
        cantidad++;

        return true;
    }
    
  
    // Modulo para modificar la reserva
    public boolean modificar(int idEmp, String nuevaBebida, String nuevaHora) {

        int modi = buscarReserva(idEmp);

        if (modi == -1) {
            return false; // no existe reserva
        }

        bebida[modi] = nuevaBebida;
        horaEntrega[modi] = nuevaHora;
        return true;
    }
    
    // Modulo para cancelar la reserva
    public boolean liberar(int idEmp) {
        for (int i = 0; i < idEmpleado.length; i++) {
        if (idEmpleado[i] == idEmp) {

            // Eliminar sin compactar
            idEmpleado[i] = -1;
            bebida[i] = "";
            horaEntrega[i] = "";

            return true;
        }
    }

    return false; // no lo encontró
}

    // Modulo para hacer la lista de reservas del barista
    public String listar() {
        String lista = "Lista de reservas del Barista \n\n";

        for (int i = 0; i < cantidad; i++) {
            if (idEmpleado[i] >= 0) {  // solo mostrar reservas activas
            lista += "Empleado: " + idEmpleado[i]
                 + " | Bebida: " + bebida[i]
                 + " | Hora: " + horaEntrega[i]
                 + "\n";
                     }
        }
        return lista;
    }
}
