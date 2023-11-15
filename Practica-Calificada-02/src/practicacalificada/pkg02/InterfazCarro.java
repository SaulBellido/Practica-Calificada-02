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

public class InterfazCarro extends JFrame {
    private JTextField campoModelo, campoColor, campoPlaca, campoAño;
    private JRadioButton radioButtonTodoRiesgo, radioButtonTerceros;
    private JComboBox<Carro.TipoCarro> comboTipoCarro;
    private JComboBox<Carro.TipoPintura> comboTipoPintura;
    private JTextArea areaTexto; // Añadido

    public InterfazCarro() {
        setTitle("Edición de Datos de Carro");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        // Título "Datos del Carro"
        JLabel labelTitulo = new JLabel("Datos del Carro");
        labelTitulo.setFont(new Font("Arial", Font.BOLD, 30));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(labelTitulo, gbc);

        // Model
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        panel.add(new JLabel("Modelo:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(campoModelo = new JTextField(25), gbc); // Ajustado a 25 caracteres

        // Color
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(new JLabel("Color:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(campoColor = new JTextField(25), gbc); // Ajustado a 25 caracteres

        // Placa
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(new JLabel("Placa:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        panel.add(campoPlaca = new JTextField(25), gbc); // Ajustado a 25 caracteres

        // Modalidad de Seguro (Eliminado el texto)
        JPanel panelRadioButtons = new JPanel(new GridLayout(1, 2));
        radioButtonTodoRiesgo = new JRadioButton("A todo Riesgo");
        radioButtonTerceros = new JRadioButton("A terceros");

        ButtonGroup grupoRadioButtons = new ButtonGroup();
        grupoRadioButtons.add(radioButtonTodoRiesgo);
        grupoRadioButtons.add(radioButtonTerceros);

        panelRadioButtons.add(radioButtonTodoRiesgo);
        panelRadioButtons.add(radioButtonTerceros);

        gbc.gridx = 1;
        gbc.gridy = 4;
        panel.add(panelRadioButtons, gbc);

        // Año de Fabricación
        gbc.gridx = 0;
        gbc.gridy = 5;
        panel.add(new JLabel("Año de Fabricación:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 5;
        panel.add(campoAño = new JTextField(25), gbc); // Ajustado a 25 caracteres

        // Tipo de Carro
        gbc.gridx = 0;
        gbc.gridy = 6;
        panel.add(new JLabel("Tipo de Carro:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 6;
        comboTipoCarro = new JComboBox<>(Carro.TipoCarro.values());
        panel.add(comboTipoCarro, gbc);

        // Tipo de Pintura
        gbc.gridx = 0;
        gbc.gridy = 7;
        panel.add(new JLabel("Tipo de Pintura:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 7;
        comboTipoPintura = new JComboBox<>(Carro.TipoPintura.values());
        panel.add(comboTipoPintura, gbc);

        // Botón Guardar
        JButton botonGuardar = new JButton("Guardar");
        gbc.gridx = 1;
        gbc.gridy = 8;
        gbc.gridwidth = 1;
        panel.add(botonGuardar, gbc);

        // Texto para mostrar información del carro (Añadido)
        areaTexto = new JTextArea(10, 40);
        areaTexto.setEditable(false);

        gbc.gridx = 0;
        gbc.gridy = 9;
        gbc.gridwidth = 2;
        panel.add(areaTexto, gbc);

        // ... (Otros componentes si los hay)

        botonGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarDatosCarro();
            }
        });

        getContentPane().add(panel);

        setVisible(true);
    }

    private void guardarDatosCarro() {
        String modelo = campoModelo.getText();
        String color = campoColor.getText();
        String placa = campoPlaca.getText();
        Carro.ModalidadSeguro modalidadSeguro = radioButtonTodoRiesgo.isSelected()
                ? Carro.ModalidadSeguro.TODO_RIESGO
                : Carro.ModalidadSeguro.TERCEROS;
        int añoFabricacion = Integer.parseInt(campoAño.getText());
        Carro.TipoCarro tipoCarro = (Carro.TipoCarro) comboTipoCarro.getSelectedItem();
        Carro.TipoPintura tipoPintura = (Carro.TipoPintura) comboTipoPintura.getSelectedItem();

        Carro carro = new Carro(modelo, color, placa, modalidadSeguro, añoFabricacion, tipoCarro, tipoPintura);

        // Actualiza el área de texto con la información del carro
        areaTexto.setText(carro.toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new InterfazCarro();
            }
        });
    }
}