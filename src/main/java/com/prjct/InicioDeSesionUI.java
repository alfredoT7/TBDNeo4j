package com.prjct;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;



public class InicioDeSesionUI extends JFrame {
    private JTextField usuarioField;
    private JTextField contraseñaField;
    public Controller controller;

    public InicioDeSesionUI(Controller controller) {
        setTitle("LOGIN");
        setSize(550, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        ImageIcon backgroundImage = new ImageIcon("Recursos/fondo.jpg");
        JLabel backgroundLabel = new JLabel(backgroundImage);
        setContentPane(backgroundLabel);
        setLayout(new BorderLayout());

        JPanel panelDeVentana = new JPanel(new GridBagLayout());
        panelDeVentana.setOpaque(false);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.gridx = 0;
        gbc.gridy = 0;
        JLabel usuarioLabel = new JLabel("Usuario:");
        usuarioLabel.setForeground(Color.WHITE);
        panelDeVentana.add(usuarioLabel, gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;
        usuarioField = new JTextField(15);
        panelDeVentana.add(usuarioField, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        JLabel contraseñaLabel = new JLabel("Contraseña:");
        contraseñaLabel.setForeground(Color.WHITE);
        panelDeVentana.add(contraseñaLabel, gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        contraseñaField = new JPasswordField(15);
        panelDeVentana.add(contraseñaField, gbc);

        JPanel panelDeBoton = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));

        JButton okBoton = new JButton("Verificar Datos");

        JButton cancelarBoton = new JButton("Cancelar");

        panelDeBoton.setOpaque(false);
        panelDeBoton.add(okBoton);
        panelDeBoton.add(cancelarBoton);

        add(panelDeVentana, BorderLayout.CENTER);
        add(panelDeBoton, BorderLayout.SOUTH);
        okBoton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean reponse=controller.getUILoginData(usuarioField.getText(), contraseñaField.getText());
                if(reponse) {
                    JOptionPane.showMessageDialog(InicioDeSesionUI.this, "Credenciales Correctas", "Correcto!!", JOptionPane.INFORMATION_MESSAGE);
                    controller.getInterfacesHabilidatas(usuarioField.getText(), InicioDeSesionUI.this);
                }else {
                    JOptionPane.showMessageDialog(InicioDeSesionUI.this, "Usuario o contraseña incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        cancelarBoton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                dispose();
            }
        });
        setVisible(true);
    }
}