package proyectogrupo3;

import javax.swing.*;
import java.awt.*;

/**
 * Interfaz gráfica moderna para Catálogos
 */
public class CatalogoGrafica extends JFrame {
    // Color de fondo principal del formulario (gris azulado oscuro)
    private final Color COLOR_FONDO = new Color(22, 22, 30);

    // Color base de los botones
    private final Color COLOR_BOTON = new Color(45, 45, 60);

    // Color del botón cuando el mouse pasa por encima (hover)
    private final Color COLOR_HOVER = new Color(70, 70, 90);

    // Color del texto dentro de los botones
    private final Color COLOR_TEXTO = Color.WHITE;

    // Constructor de la ventana
    public CatalogoGrafica() {

        // Título de la ventana
        setTitle("Catálogos");

        // Tamaño de la ventana (ancho, alto)
        setSize(420, 400);

        // Centra la ventana en la pantalla
        setLocationRelativeTo(null);

        // Cerrar solo esta ventana, no toda la app
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Cambiar el color del fondo de la ventana
        getContentPane().setBackground(COLOR_FONDO);

        // Usamos GridBagLayout para centrar los botones en columna
        setLayout(new GridBagLayout());

        // Objeto que controla las posiciones del GridBagLayout
        GridBagConstraints gbc = new GridBagConstraints();

        // Espaciado entre los botones
        gbc.insets = new Insets(10, 10, 10, 10);

        // Indica que los botones ocupan todo el ancho disponible
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Todos en la columna 0
        gbc.gridx = 0;

        // Crear cada botón con estilo moderno
        JButton btnVerEmpleados = crearBoton("Ver empleados");
        JButton btnAgregarEmpleado = crearBoton("Agregar empleado");
        JButton btnVerSalas = crearBoton("Ver salas de cine");
        JButton btnModificarPelicula = crearBoton("Modificar película");
        JButton btnVolver = crearBoton("Volver");

        // Agregar los botones a la ventana uno por fila
        gbc.gridy = 0; add(btnVerEmpleados, gbc);
        gbc.gridy = 1; add(btnAgregarEmpleado, gbc);
        gbc.gridy = 2; add(btnVerSalas, gbc);
        gbc.gridy = 3; add(btnModificarPelicula, gbc);
        gbc.gridy = 4; add(btnVolver, gbc);

        // Acciones al presionar cada botón
        btnVerEmpleados.addActionListener(e -> Sistema.verEmpleados());
        btnAgregarEmpleado.addActionListener(e -> Sistema.agregarEmpleado());
        btnVerSalas.addActionListener(e -> Sistema.verSalas());
        btnModificarPelicula.addActionListener(e -> Sistema.modificarPelicula());
        btnVolver.addActionListener(e -> dispose()); // cierra esta ventana

        // Mostrar la ventana
        setVisible(true);
    }

    /**
     * Método que crea un botón con estilo moderno oscuro
     */
    private JButton crearBoton(String texto) {

        // Crear botón con el texto indicado
        JButton btn = new JButton(texto);

        // Fuente moderna, estilo negrita, tamaño 16
        btn.setFont(new Font("Segoe UI", Font.BOLD, 16));

        // Quita el borde azul de selección
        btn.setFocusPainted(false);

        // Color base del botón
        btn.setBackground(COLOR_BOTON);

        // Color del texto
        btn.setForeground(COLOR_TEXTO);

        // Borde sutil alrededor del botón
        btn.setBorder(BorderFactory.createLineBorder(COLOR_HOVER, 1));

        // Cambia el cursor al pasar encima
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // Permite que el botón pinte fondo personalizado
        btn.setOpaque(true);

        // Tamaño sugerido del botón
        btn.setPreferredSize(new Dimension(280, 45));

        // Evento cuando pasa el mouse por encima (hover)
        btn.addMouseListener(new java.awt.event.MouseAdapter() {
            // Cuando entra el mouse, cambia el color del botón
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn.setBackground(COLOR_HOVER);
            }

            // Cuando sale el mouse, vuelve al color original
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn.setBackground(COLOR_BOTON);
            }
        });

        return btn; // devuelve el botón creado
    }
}
