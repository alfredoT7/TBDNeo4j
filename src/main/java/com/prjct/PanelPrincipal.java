package com.prjct;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PanelPrincipal extends JFrame{
    private JTextArea textArea;
    private JLabel usuarioLabel;
    private ArrayList<String> datos;

    public PanelPrincipal(String nombreUsuario, ArrayList<String> datos, InicioDeSesionUI inicioDeSesionUI) {
        this.datos = datos;

        setTitle("Mostrar Texto");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        usuarioLabel = new JLabel("Usuario: " + nombreUsuario + ", Interfaces DISPONIBLES");
        usuarioLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(usuarioLabel, BorderLayout.NORTH);

        textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);

        mostrarContenido();
    }

    private void mostrarContenido() {
        for (String linea : datos) {
            textArea.append(linea + "\n");
        }
    }
}
