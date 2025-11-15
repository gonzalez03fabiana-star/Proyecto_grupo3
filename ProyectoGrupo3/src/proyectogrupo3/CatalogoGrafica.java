/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectogrupo3;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author gonza
 */
public class CatalogoGrafica extends JFrame {

    public CatalogoGrafica() {
        setTitle("Catalogos");
        setSize(400, 250);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 2, 10, 10));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JButton btnVerEmpleados = new JButton("Ver empleados");
        JButton btnAgregarEmpleado = new JButton("Agregar empleado");
        JButton btnVerSalas = new JButton("Ver salas de cine");
        JButton btnModificarPelicula = new JButton("Modificar película");
        JButton btnVolver = new JButton("Volver");

        add(btnVerEmpleados);
        add(btnAgregarEmpleado);
        add(btnVerSalas);
        add(btnModificarPelicula);
        add(btnVolver);

        btnVerEmpleados.addActionListener(e -> Sistema.verEmpleados());
        btnAgregarEmpleado.addActionListener(e -> Sistema.agregarEmpleado());
        btnVerSalas.addActionListener(e -> Sistema.verSalas());
        btnModificarPelicula.addActionListener(e -> Sistema.modificarPelicula());
        btnVolver.addActionListener(e -> dispose());

        setVisible(true);

    }

}
