package proyectogrupo3;

import javax.swing.*;
import java.awt.*;

/**
 * Interfaz gráfica moderna para Cine
 */
public class CineGrafica extends JFrame {
    // Color de fondo general de la ventana
    private final Color COLOR_FONDO = new Color(22, 22, 30);

    // Color base de los botones
    private final Color COLOR_BOTON = new Color(45, 45, 60);

    // Color para hover (cuando pasa el mouse)
    private final Color COLOR_HOVER = new Color(70, 70, 90);

    // Color del texto dentro de los botones
    private final Color COLOR_TEXTO = Color.WHITE;

    // Constructor de la ventana de Cine
    public CineGrafica() {

        // Título de la ventana
        setTitle("Cine");

        // Dimensiones del formulario
        setSize(420, 300);

        // Centrar ventana en la pantalla
        setLocationRelativeTo(null);

        // Cierra solo esta ventana al presionar X
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Color del fondo principal
        getContentPane().setBackground(COLOR_FONDO);

        // Utilizar GridBagLayout para centrar botones verticalmente
        setLayout(new GridBagLayout());

        // Controlador del layout
        GridBagConstraints gbc = new GridBagConstraints();

        // Espaciado entre botones
        gbc.insets = new Insets(10, 10, 10, 10);

        // Que los botones usen todo el ancho disponible
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Primera y única columna
        gbc.gridx = 0;

        // Crear los botones con el estilo oscuro
        JButton btnSala = crearBoton("Ver sala");
        JButton btnReservar = crearBoton("Reservar asiento");
        JButton btnLiberar = crearBoton("Liberar asiento");
        JButton btnVolver = crearBoton("Volver");

        // Agregar botones por filas
        gbc.gridy = 0; add(btnSala, gbc);
        gbc.gridy = 1; add(btnReservar, gbc);
        gbc.gridy = 2; add(btnLiberar, gbc);
        gbc.gridy = 3; add(btnVolver, gbc);

        // Acciones de cada botón (llamando a la lógica de Sistema)
        btnSala.addActionListener(e -> Sistema.verMapa());
        btnReservar.addActionListener(e -> Sistema.reservarAsiento());
        btnLiberar.addActionListener(e -> Sistema.liberarAsiento());
        btnVolver.addActionListener(e -> dispose()); // cerrar ventana

        // Mostrar ventana
        setVisible(true);
    }

    /**
     * Método que crea un botón con estilo oscuro moderno
     */
    private JButton crearBoton(String texto) {

        // Crear botón con el texto que recibe el método
        JButton btn = new JButton(texto);

        // Tipo de letra moderna
        btn.setFont(new Font("Segoe UI", Font.BOLD, 16));

        // Quitar el borde azul de selección
        btn.setFocusPainted(false);

        // Color inicial del botón
        btn.setBackground(COLOR_BOTON);

        // Color del texto del botón
        btn.setForeground(COLOR_TEXTO);

        // Borde elegante alrededor
        btn.setBorder(BorderFactory.createLineBorder(COLOR_HOVER, 1, true));

        // Cursor tipo mano al pasar encima
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // Permitir que pinte fondo personalizado
        btn.setOpaque(true);

        // Tamaño estándar del botón
        btn.setPreferredSize(new Dimension(280, 45));

        // Efectos visuales al pasar el mouse
        btn.addMouseListener(new java.awt.event.MouseAdapter() {

            // Cuando el mouse entra en el botón
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn.setBackground(COLOR_HOVER); // cambiar fondo
            }

            // Cuando el mouse sale del botón
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn.setBackground(COLOR_BOTON); // restaurar color base
            }
        });

        return btn; // retornar el botón listo para usarse
    }

    // Método main para probar esta ventana individualmente
    public static void main(String[] args) {
        new CineGrafica();
    }
}
