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
 * @author PCadmin
 */
public class ClasesGrafica extends JFrame{
    public ClasesGrafica (){
        setTitle("Clases");
        setSize(400, 250);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 2, 10, 10));
        
        JButton btnClase = new JButton("Ver clases");
        JButton btnReservar = new JButton("Reservar clase");
        JButton btnLiberar = new JButton("Liberar espacio");
        JButton btnVolver = new JButton("Volver");
        
        add(btnClase);
        add(btnReservar);
        add(btnLiberar);
        add(btnVolver);
        
        btnClase.addActionListener(e -> Sistema.verClases());
        btnReservar.addActionListener(e -> Sistema.reservarEspacio());
        btnLiberar.addActionListener(e -> Sistema.liberarEspacio());
        btnVolver.addActionListener(e-> dispose());
        
        setVisible(true);
    }
    
}