package view;
import data.GestorDatos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VentanaBienvenida extends Ventana implements ActionListener {
    private JButton btnAgregarCafe, btnBuscarCafe, btnSalir, btnEliminarCafe, btnModificar;
    private JPanel panel;
    private GestorDatos gestor;

    public VentanaBienvenida(String titulo, int ancho, int alto, GestorDatos gestor) {
        super(titulo, ancho, alto);
        this.gestor = gestor;
        crearComponentes();
        agregarComponentes();
        agregarEventos();
        setVisible(true);
    }


    private void crearComponentes() {
        btnAgregarCafe = new JButton("Agregar café");
        btnBuscarCafe = new JButton("Buscar café por tamaño");
        btnEliminarCafe = new JButton("Eliminar café");
        btnModificar = new JButton("Modificar información");
        btnSalir = new JButton("Salir");
        panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1));
    }

    private void agregarComponentes() {
        panel.add(btnAgregarCafe);
        panel.add(btnBuscarCafe);
        panel.add(btnEliminarCafe);
        panel.add(btnModificar);
        panel.add(btnSalir);

        add(panel);
    }

    private void agregarEventos() {
        btnAgregarCafe.addActionListener(this);
        btnBuscarCafe.addActionListener(this);
        btnEliminarCafe.addActionListener(this);
        btnModificar.addActionListener(this);
        btnSalir.addActionListener(this);
    }

    public void actionPerformed(ActionEvent accion) {
        if (accion.getSource() == btnAgregarCafe) {
            dispose();
            new VentanaAgregarCafe("Agregar Café", 500, 300, gestor);
        } else if (accion.getSource() == btnBuscarCafe) {
            dispose();
            new VentanaBuscarCafe("Buscar Café o modificar información",500,300, gestor);
        } else if (accion.getSource() == btnEliminarCafe) {
            dispose();
            new VentanaEliminarCafe("Eliminar Café", 500, 300, gestor);
        } else if (accion.getSource() == btnSalir) {
            System.exit(0);
        }
    }
}