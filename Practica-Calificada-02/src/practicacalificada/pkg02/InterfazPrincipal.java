/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practicacalificada.pkg02;

/**
 *
 * @author SAUL
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfazPrincipal extends JFrame {

    public InterfazPrincipal() {
        setTitle("Menú Principal");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu menuOpciones = new JMenu("Menú");
        menuBar.add(menuOpciones);

        JMenuItem itemRegistrarCarro = new JMenuItem("Registrar Carro");
        itemRegistrarCarro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirInterfazRegistro();
            }
        });

        JMenuItem itemListarCarros = new JMenuItem("Lista de Carros");
        itemListarCarros.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirInterfazLista();
            }
        });

        JMenuItem itemSalir = new JMenuItem("Salir");
        itemSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        menuOpciones.add(itemRegistrarCarro);
        menuOpciones.add(itemListarCarros);
        menuOpciones.add(itemSalir);

        JMenu menuAyuda = new JMenu("Ayuda");
        menuBar.add(menuAyuda);

        JMenuItem itemAyuda = new JMenuItem("Ayuda");
        itemAyuda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarAyuda();
            }
        });

        menuAyuda.add(itemAyuda);

        setVisible(true);
    }

    private void abrirInterfazRegistro() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new InterfazCarro();
            }
        });
    }

    private void abrirInterfazLista() {
        // Lógica para abrir la interfaz de lista de carros
        // Puedes implementarla según tus necesidades
        // Aquí puedes abrir la interfaz que lista los carros
    }

    private void mostrarAyuda() {
        // Lógica para mostrar la ayuda
        // Puedes implementarla según tus necesidades
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new InterfazPrincipal();
            }
        });
    }
}