package proyectogrupo3;

import javax.swing.*;
import java.awt.*;

/**
 * Interfaz gráfica moderna para Clases
 */
public class ClasesGrafica extends JFrame {
    // Color de fondo principal del formulario
    private final Color COLOR_FONDO = new Color(22, 22, 30);

    // Color base de los botones
    private final Color COLOR_BOTON = new Color(45, 45, 60);

    // Color del botón cuando el mouse pasa por encima
    private final Color COLOR_HOVER = new Color(70, 70, 90);

    // Color del texto dentro de los botones
    private final Color COLOR_TEXTO = Color.WHITE;

    // Constructor de la interfaz de Clases
    public ClasesGrafica() {

        // Título de la ventana
        setTitle("Clases");

        // Tamaño de la ventana
        setSize(420, 400);

        // Centrar ventana en pantalla
        setLocationRelativeTo(null);

        // Solo cerrar esta ventana al hacer clic en X
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Establecer color de fondo del panel
        getContentPane().setBackground(COLOR_FONDO);

        // Layout centrado en columna
        setLayout(new GridBagLayout());

        // Objeto que define posiciones del layout
        GridBagConstraints gbc = new GridBagConstraints();

        // Márgenes entre cada botón
        gbc.insets = new Insets(10, 10, 10, 10);

        // Los botones deben ocupar el ancho completo disponible
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Columna única
        gbc.gridx = 0;

        // Crear botones modernos estilo oscuro
        JButton btnClase = crearBoton("Ver clases");
        JButton btnReservar = crearBoton("Reservar clase");
        JButton btnLiberar = crearBoton("Liberar espacio");
        JButton btnVolver = crearBoton("Volver");

        // Agregar cada botón en una fila
        gbc.gridy = 0; add(btnClase, gbc);
        gbc.gridy = 1; add(btnReservar, gbc);
        gbc.gridy = 2; add(btnLiberar, gbc);
        gbc.gridy = 3; add(btnVolver, gbc);

        // Acciones de cada botón (enlazadas con la lógica del sistema)
        btnClase.addActionListener(e -> Sistema.verClases());
        btnReservar.addActionListener(e -> Sistema.reservarEspacio());
        btnLiberar.addActionListener(e -> Sistema.liberarEspacio());
        btnVolver.addActionListener(e -> dispose()); // cierra esta ventana

        // Mostrar la ventana
        setVisible(true);
    }

    /**
     * Crea un botón moderno oscuro con efecto hover.
     */
    private JButton crearBoton(String texto) {

        // Crear botón con el texto indicado
        JButton btn = new JButton(texto);

        // Fuente moderna y en negrita
        btn.setFont(new Font("Segoe UI", Font.BOLD, 16));

        // Evitar borde azul de enfoque
        btn.setFocusPainted(false);

        // Color inicial del botón
        btn.setBackground(COLOR_BOTON);

        // Color del texto
        btn.setForeground(COLOR_TEXTO);

        // Borde elegante
        btn.setBorder(BorderFactory.createLineBorder(COLOR_HOVER, 1, true));

        // Cursor de mano al pasar el mouse
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // Permite pintar fondo personalizado
        btn.setOpaque(true);

        // Tamaño recomendado
        btn.setPreferredSize(new Dimension(280, 45));

        // Efecto hover (cambio de color al pasar el mouse)
        btn.addMouseListener(new java.awt.event.MouseAdapter() {

            // Cuando entra el mouse
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn.setBackground(COLOR_HOVER);
            }

            // Cuando sale el mouse
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn.setBackground(COLOR_BOTON);
            }
        });

        // Retorna el botón listo para usar
        return btn;
    }

    // Método main para probar esta ventana independientemente
    public static void main(String[] args) {
        new ClasesGrafica();
    }
}
