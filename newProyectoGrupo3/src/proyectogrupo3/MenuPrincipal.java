package proyectogrupo3;

import javax.swing.*;
import java.awt.*;

/**
 * Menu Principal estilo moderno tipo web
 */
public class MenuPrincipal extends JFrame {

    // Colores base del tema oscuro
    private final Color COLOR_FONDO = new Color(22, 22, 30);   // Fondo del panel
    private final Color COLOR_BOTON = new Color(45, 45, 60);   // Botón base
    private final Color COLOR_HOVER = new Color(70, 70, 90);   // Hover del botón
    private final Color COLOR_TEXTO = Color.WHITE;             // Color de texto

    // Constructor: se ejecuta al crear la ventana
    public MenuPrincipal() {

        // Título de la ventana
        setTitle("Sistema de Recepción - DHL");

        // Dimensiones de la ventana
        setSize(500, 500);

        // Centra la ventana
        setLocationRelativeTo(null);

        // Cierra la app completa al cerrar esta ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Color de fondo del panel principal
        getContentPane().setBackground(COLOR_FONDO);

        // Layout centrado en columna
        setLayout(new GridBagLayout());

        // Controlador de posiciones del layout
        GridBagConstraints gbc = new GridBagConstraints();

        // Espaciado entre botones
        gbc.insets = new Insets(12, 12, 12, 12);

        // Botones ocupan todo el ancho
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Columna inicial
        gbc.gridx = 0;

        // Crear botones principales
        JButton btnCatalogos = crearBoton("Catálogos");
        JButton btnModuloCine = crearBoton("Módulo de Cine");
        JButton btnModuloGym = crearBoton("Módulo de Gimnasio");
        JButton btnModuloClases = crearBoton("Módulo de Clases");
        JButton btnModuloCafeteria = crearBoton("Módulo de Cafetería");
        JButton btnSalir = crearBoton("Salir");

        // Agregar cada botón por fila
        gbc.gridy = 0;
        add(btnCatalogos, gbc);
        gbc.gridy = 1;
        add(btnModuloCine, gbc);
        gbc.gridy = 2;
        add(btnModuloGym, gbc);
        gbc.gridy = 3;
        add(btnModuloClases, gbc);
        gbc.gridy = 4;
        add(btnModuloCafeteria, gbc);
        gbc.gridy = 5;
        add(btnSalir, gbc);

        // Eventos de clic — abren otras ventanas del sistema
        btnCatalogos.addActionListener(e -> new CatalogoGrafica());
        btnModuloCine.addActionListener(e -> new CineGrafica());
        btnModuloGym.addActionListener(e -> new GymGrafica());
        btnModuloClases.addActionListener(e -> new ClasesGrafica());
        btnModuloCafeteria.addActionListener(e -> new CafeteriaGrafica());

        // Botón salir — cierra toda la aplicación
        btnSalir.addActionListener(e -> System.exit(0));

        // Mostrar la ventana
        setVisible(true);
    }

    /**
     * Crea un botón moderno oscuro con efecto hover
     */
    private JButton crearBoton(String texto) {

        // Crear botón con el texto indicado
        JButton btn = new JButton(texto);

        // Fuente moderna grande
        btn.setFont(new Font("Segoe UI", Font.BOLD, 18));

        // Quitar el borde azul de enfoque
        btn.setFocusPainted(false);

        // Color inicial del botón
        btn.setBackground(COLOR_BOTON);

        // Color del texto
        btn.setForeground(COLOR_TEXTO);

        // Borde suave
        btn.setBorder(BorderFactory.createLineBorder(COLOR_HOVER, 1, true));

        // Cursor de mano
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // Permite personalizar el fondo
        btn.setOpaque(true);

        // Tamaño recomendado
        btn.setPreferredSize(new Dimension(300, 50));

        // Efecto hover: oscurecer al entrar y volver al salir
        btn.addMouseListener(new java.awt.event.MouseAdapter() {

            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn.setBackground(COLOR_HOVER);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn.setBackground(COLOR_BOTON);
            }
        });

        return btn; // Devuelve el botón listo
    }
}
