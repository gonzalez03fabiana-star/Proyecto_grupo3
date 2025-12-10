package proyectogrupo3;

import javax.swing.JOptionPane;

public class Gym {

    private String nombreSala;
    private String entrenador;
    private boolean[] ocupado;    // true = reservado
    private int[] idEmpleado;     
    private String[] horarios;    // "14:00" - "19:00"

    public Gym(String nombreSala, String entrenador) {
        this.nombreSala = nombreSala;
        this.entrenador = entrenador;

        // Horarios de 2pm a 7pm (6 horas)
        horarios = new String[] {"14:00", "15:00", "16:00", "17:00", "18:00", "19:00"};

        ocupado = new boolean[horarios.length];
        idEmpleado = new int[horarios.length];

        
        for (int i = 0; i < ocupado.length; i++) {
            ocupado[i] = false;
            idEmpleado[i] = -1;
        }
    }

    // Metodo para mostrar estado de reservas
    public String mostrarReservas() {
        String msg = "Sala: " + nombreSala + " | Entrenador: " + entrenador + "\n";
        for (int i = 0; i < horarios.length; i++) {
            msg += horarios[i] + ": " + (ocupado[i] ? "Empleado " + idEmpleado[i] : "Libre") + "\n";
        }
        return msg;
    }

    // Metodo para mostrar solo horas disponibles
    public String horasDisponibles() {
        String msg = "Horas disponibles en " + nombreSala + ":\n";
        for (int i = 0; i < horarios.length; i++) {
            if (!ocupado[i]) {
                msg += (i+1) + ") " + horarios[i] + "\n";
            }
        }
        return msg;
    }

    // Metodo para crear reserva de una hora específica 
    public boolean crearReserva(int idEmp, int indiceHora) {
        if (indiceHora < 0 || indiceHora >= ocupado.length) return false;
        if (ocupado[indiceHora]) return false;

        ocupado[indiceHora] = true;
        idEmpleado[indiceHora] = idEmp;
        return true;
    }

    // Metodo para iberar reserva de una hora especifica
    public boolean liberarReserva(int indiceHora) {
        if (indiceHora < 0 || indiceHora >= ocupado.length) return false;
        if (!ocupado[indiceHora]) return false;

        ocupado[indiceHora] = false;
        idEmpleado[indiceHora] = -1;
        return true;
    }

    public String getNombreSala() {
        return nombreSala;
    }

    public String getEntrenador() {
        return entrenador;
    }

    public int getCantidadHoras() {
        return horarios.length;
    }

    public String getHorario(int indice) {
        if (indice < 0 || indice >= horarios.length) return "";
        return horarios[indice];
    }

    public int getIdEmpleado(int indice) {
        if (indice < 0 || indice >= idEmpleado.length) return -1;
        return idEmpleado[indice];
    }
}
