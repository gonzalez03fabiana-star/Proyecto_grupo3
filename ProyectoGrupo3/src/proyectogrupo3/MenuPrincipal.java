/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectogrupo3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 *
 * @author gonza
 */
public class MenuPrincipal extends JFrame {

    public MenuPrincipal() {
        setTitle("Sistema de recepción - DHL");
        setSize(420, 320);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Fondo oscuro
        getContentPane().setBackground(new Color(30, 30, 30));
        setLayout(new GridLayout(4, 1, 12, 12));

        JButton btnCatalogos = crearBoton("Catálogos");
        JButton btnModuloCine = crearBoton("Módulo de Cine");
        JButton btnSalir = crearBoton("Salir");

        add(btnCatalogos);
        add(btnModuloCine);
        add(btnSalir);

        btnCatalogos.addActionListener(e -> new CatalogoGrafica());
        btnModuloCine.addActionListener(e -> new CineGrafica());
        btnSalir.addActionListener(e -> System.exit(0));

        setVisible(true);
    }

    private JButton crearBoton(String texto) {

        JButton btn = new JButton(texto);
        btn.setFont(new Font("Segoe UI", Font.BOLD, 16));
        btn.setFocusPainted(false);
        btn.setBackground(new Color(45, 45, 45));
        btn.setForeground(Color.WHITE);
        btn.setBorderPainted(false);
        btn.setOpaque(true);
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(new Color(60, 60, 60), 2, true), BorderFactory.createEmptyBorder(10, 20, 10, 20)
        ));

        return btn;
    }

}
