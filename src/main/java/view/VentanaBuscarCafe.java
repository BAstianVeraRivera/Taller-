package view;
import data.GestorDatos;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Cafe;

public class VentanaBuscarCafe extends Ventana implements ActionListener {
    private JTextField txtTamañoCafe;
    private JLabel lblTamañoCafe;
    private JButton btnBuscar, btnCancelar;
    private JPanel panel;
    private GestorDatos gestor;

    public VentanaBuscarCafe(String titulo, int ancho, int alto, GestorDatos gestor) {
        super(titulo, ancho, alto);
        this.gestor = gestor;
        crearComponentes();
        agregarComponentes();
        agregarEventos();
        setVisible(true);
    }

    private void crearComponentes() {
        lblTamañoCafe = new JLabel("Tamaño de café:");
        txtTamañoCafe = new JTextField(15);
        btnBuscar = new JButton("Buscar");
        btnCancelar = new JButton("Cancelar");
        panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2));
    }

    private void agregarComponentes() {
        panel.add(lblTamañoCafe);
        panel.add(txtTamañoCafe);
        panel.add(btnBuscar);
        panel.add(btnCancelar);
        add(panel);
    }

    private void agregarEventos() {
        btnBuscar.addActionListener(this);
        btnCancelar.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnBuscar) {
            String tamaño = txtTamañoCafe.getText();
            Cafe cafe = gestor.buscarCafePorTamaño(tamaño);
            if (cafe != null) {
                JOptionPane.showMessageDialog(this, "Café encontrado: " +cafe.toString());
            } else {
                JOptionPane.showMessageDialog(this, "No se encontró el café");
            }
        } else if (e.getSource() == btnCancelar) {
            dispose();
            new VentanaBienvenida("Cafetería BASTIAN", 500, 300, gestor);
        }
    }
}