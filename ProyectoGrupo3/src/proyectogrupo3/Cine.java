/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectogrupo3;

/**
 *
 * @author gonza
 */
public class Cine {

    private String nombre;
    private String pelicula;
    private boolean[][] ocupado;
    private int[][] idEmpleado;

    public Cine(String nombre, String pelicula, boolean[][] ocupado, int[][] idEmpleado) {
        this.nombre = nombre;
        this.pelicula = pelicula;
        this.ocupado = ocupado;
        this.idEmpleado = idEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPelicula() {
        return pelicula;
    }

    public void setPelicula(String pelicula) {
        this.pelicula = pelicula;
    }

    public boolean[][] getOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean[][] ocupado) {
        this.ocupado = ocupado;
    }

    public int[][] getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int[][] idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    /**
     * Metodo paara mostras la sala de cine en una matriz
     *
     * @return
     */
    public String mostrarSala() {
        String sala = "Sala" + nombre + " Pelicula " + pelicula + "\n";

        for (int i = 0; i < ocupado[0].length; i++) {
            sala = sala + (i + 1);
        }
        sala = sala + "\n";

        for (int j = 0; j < ocupado.length; j++) {
            sala = sala + (char) ('A' + j) + " | ";

            for (int k = 0; k < ocupado[0].length; k++) {
                if (ocupado[j][k]) {
                    sala = sala + " L ";
                } else {
                    sala = sala + " O ";
                }

            }

            sala = sala + "\n";

        }
        return sala;

    }

    /**
     * Metodo para reservar un asiento en el cine
     *
     * @param idEmpleado
     * @param fila
     * @param columna
     * @return
     */
    public boolean reservar(int idEmp, int fila, int columna) {

        if (ocupado[fila][columna]) {
            return false;
        }
        ocupado[fila][columna] = true;
        this.idEmpleado[fila][columna] = idEmp;

        return true;

    }

    /**
     * Metodo para liberar una reserva
     *
     * @param fila
     * @param columna
     * @return
     */
    public boolean liberar(int fila, int columna) {
        if (!ocupado[fila][columna]) {
            return false;
        }
        ocupado[fila][columna] = false;
        this.idEmpleado[fila][columna] = -1;

        return true;

    }
}
