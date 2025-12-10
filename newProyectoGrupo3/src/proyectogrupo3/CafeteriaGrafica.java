package proyectogrupo3;

import javax.swing.*;
import java.awt.*;

/**
 * Interfaz gráfica moderna para Cafetería
 */
public class CafeteriaGrafica extends JFrame {
    // Color de fondo principal de la ventana
    private final Color COLOR_FONDO = new Color(22, 22, 30);

    // Color base de los botones
    private final Color COLOR_BOTON = new Color(45, 45, 60);

    // Color del botón cuando el mouse pasa por encima (hover)
    private final Color COLOR_HOVER = new Color(70, 70, 90);

    // Color del texto de los botones
    private final Color COLOR_TEXTO = Color.WHITE;

    // Constructor de la ventana de Cafetería
    public CafeteriaGrafica() {

        // Título de la ventana
        setTitle("Cafetería");

        // Tamaño de la ventana (ancho x alto)
        setSize(420, 400);

        // Centrar la ventana en la pantalla
        setLocationRelativeTo(null);

        // Cerrar solo esta ventana al darle X (no toda la app)
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Establecer color de fondo del panel principal
        getContentPane().setBackground(COLOR_FONDO);

        // Usar GridBagLayout para organizar los botones en columna
        setLayout(new GridBagLayout());

        // Objeto para configurar posición y espaciado de los componentes
        GridBagConstraints gbc = new GridBagConstraints();

        // Márgenes alrededor de cada botón
        gbc.insets = new Insets(10, 10, 10, 10);

        // Los botones ocupan todo el ancho disponible en su columna
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Todos los botones estarán en la columna 0
        gbc.gridx = 0;

        // Crear los botones con el estilo oscuro moderno
        JButton btnReserva = crearBoton("Reservar bebida");
        JButton btnModificar = crearBoton("Modificar reserva");
        JButton btnLiberar = crearBoton("Liberar reserva");
        JButton btnLista = crearBoton("Ver reservas actuales");
        JButton btnVolver = crearBoton("Volver");

        // Agregar el botón "Reservar bebida" en la fila 0
        gbc.gridy = 0;
        add(btnReserva, gbc);

        // Agregar el botón "Modificar reserva" en la fila 1
        gbc.gridy = 1;
        add(btnModificar, gbc);

        // Agregar el botón "Liberar reserva" en la fila 2
        gbc.gridy = 2;
        add(btnLiberar, gbc);

        // Agregar el botón "Ver reservas actuales" en la fila 3
        gbc.gridy = 3;
        add(btnLista, gbc);

        // Agregar el botón "Volver" en la fila 4
        gbc.gridy = 4;
        add(btnVolver, gbc);

        // Asignar acción al botón "Reservar bebida" → llama al módulo lógico del sistema
        btnReserva.addActionListener(e -> Sistema.crearReserva());

        // Asignar acción al botón "Modificar reserva"
        btnModificar.addActionListener(e -> Sistema.modificarReserva());

        // Asignar acción al botón "Liberar reserva"
        btnLiberar.addActionListener(e -> Sistema.liberarReserva());

        // Asignar acción al botón "Ver reservas actuales"
        btnLista.addActionListener(e -> Sistema.listarReservas());

        // Botón "Volver" → cierra solo esta ventana
        btnVolver.addActionListener(e -> dispose());

        // Mostrar la ventana en pantalla
        setVisible(true);
    }

    /**
     * Método para crear un botón con estilo moderno oscuro y efecto hover
     */
    private JButton crearBoton(String texto) {

        // Crear el botón con el texto indicado
        JButton btn = new JButton(texto);

        // Establecer la fuente (tipo de letra, estilo y tamaño)
        btn.setFont(new Font("Segoe UI", Font.BOLD, 16));

        // Quitar el borde de enfoque azul típico de Swing
        btn.setFocusPainted(false);

        // Color base de fondo del botón
        btn.setBackground(COLOR_BOTON);

        // Color del texto del botón
        btn.setForeground(COLOR_TEXTO);

        // Borde del botón, fino y con el color de hover
        btn.setBorder(BorderFactory.createLineBorder(COLOR_HOVER, 1, true));

        // Cambiar el cursor a mano cuando se pasa por encima del botón
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // Indicar que el botón pinta su propio fondo
        btn.setOpaque(true);

        // Tamaño recomendado del botón
        btn.setPreferredSize(new Dimension(280, 45));

        // Agregar comportamiento de hover usando un MouseListener
        btn.addMouseListener(new java.awt.event.MouseAdapter() {

            // Cuando el mouse entra en el área del botón
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                // Cambia el color de fondo al color de hover
                btn.setBackground(COLOR_HOVER);
            }

            // Cuando el mouse sale del botón
            public void mouseExited(java.awt.event.MouseEvent evt) {
                // Vuelve al color base del botón
                btn.setBackground(COLOR_BOTON);
            }
        });

        // Devolver el botón ya configurado
        return btn;
    }
}
