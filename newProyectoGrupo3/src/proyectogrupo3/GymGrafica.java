package proyectogrupo3;

import javax.swing.*;
import java.awt.*;

/**
 * Interfaz gráfica moderna para Gym
 */
public class GymGrafica extends JFrame {
    // Color de fondo principal
    private final Color COLOR_FONDO = new Color(22, 22, 30);

    // Color base de los botones
    private final Color COLOR_BOTON = new Color(45, 45, 60);

    // Color del botón cuando se pasa el mouse encima (hover)
    private final Color COLOR_HOVER = new Color(70, 70, 90);

    // Color del texto dentro de los botones
    private final Color COLOR_TEXTO = Color.WHITE;

    // Constructor de la ventana
    public GymGrafica() {

        // Título de la ventana
        setTitle("Gimnasio");

        // Tamaño de la ventana
        setSize(420, 400);

        // Centrar la ventana en la pantalla
        setLocationRelativeTo(null);

        // Solo cierra esta ventana cuando se presiona X
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Establecer color de fondo del panel
        getContentPane().setBackground(COLOR_FONDO);

        // Layout centrado verticalmente
        setLayout(new GridBagLayout());

        // Objeto para configurar posiciones en el grid
        GridBagConstraints gbc = new GridBagConstraints();

        // Espacio alrededor de cada botón
        gbc.insets = new Insets(10, 10, 10, 10);

        // Los botones ocupan todo el ancho disponible
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Columna única
        gbc.gridx = 0;

        // Crear botones modernos oscuros
        JButton btnReserva = crearBoton("Reservar sesión");
        JButton btnDisponible = crearBoton("Horarios disponibles");
        JButton btnLiberar = crearBoton("Liberar reserva");
        JButton btnLista = crearBoton("Ver reservas actuales");
        JButton btnVolver = crearBoton("Volver");

        // Agregar botones en filas correspondientes
        gbc.gridy = 0; add(btnReserva, gbc);
        gbc.gridy = 1; add(btnDisponible, gbc);
        gbc.gridy = 2; add(btnLiberar, gbc);
        gbc.gridy = 3; add(btnLista, gbc);
        gbc.gridy = 4; add(btnVolver, gbc);

        // Acciones enlazadas con la lógica del sistema
        btnReserva.addActionListener(e -> Sistema.crearReservaGym());
        btnDisponible.addActionListener(e -> Sistema.mostrarHorasDisponiblesGym());
        btnLiberar.addActionListener(e -> Sistema.liberarReservaGym());
        btnLista.addActionListener(e -> Sistema.listarReservasGym());

        // Botón volver -> cierra la ventana actual
        btnVolver.addActionListener(e -> dispose());

        // Mostrar ventana
        setVisible(true);
    }

    /**
     * Método para crear un botón estilo moderno oscuro
     */
    private JButton crearBoton(String texto) {

        // Crear botón con el texto indicado
        JButton btn = new JButton(texto);

        // Fuente moderna y clara
        btn.setFont(new Font("Segoe UI", Font.BOLD, 16));

        // Quitar borde azul de selección
        btn.setFocusPainted(false);

        // Color base del botón
        btn.setBackground(COLOR_BOTON);

        // Color del texto
        btn.setForeground(COLOR_TEXTO);

        // Borde estético alrededor del botón
        btn.setBorder(BorderFactory.createLineBorder(COLOR_HOVER, 1, true));

        // Cursor tipo mano para indicar acción
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // Permitir color de fondo personalizado
        btn.setOpaque(true);

        // Tamaño recomendado del botón
        btn.setPreferredSize(new Dimension(280, 45));

        // Efecto hover para mejorar experiencia visual
        btn.addMouseListener(new java.awt.event.MouseAdapter() {

            // Mouse entra al botón
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn.setBackground(COLOR_HOVER);
            }

            // Mouse sale del botón
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn.setBackground(COLOR_BOTON);
            }
        });

        // Devolver botón ya configurado
        return btn;
    }

    // Main para pruebas independientes
    public static void main(String[] args) {
        new GymGrafica();
    }
}
