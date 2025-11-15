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
public class CineGrafica extends JFrame{
    public CineGrafica (){
        setTitle("Cine");
        setSize(400, 250);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 2, 10, 10));
        
        JButton btnSala = new JButton("Ver sala");
        JButton btnReservar = new JButton("Reservar asiento");
        JButton btnLiberar = new JButton("Liberar asiento");
        JButton btnVolver = new JButton("Volver");
        
        add(btnSala);
        add(btnReservar);
        add(btnLiberar);
        add(btnVolver);
        
        btnSala.addActionListener(e -> Sistema.verMapa());
        btnReservar.addActionListener(e -> Sistema.reservarAsiento());
        btnLiberar.addActionListener(e -> Sistema.liberarAsiento());
        btnVolver.addActionListener(e-> dispose());
        
        setVisible(true);
    }
    
}
