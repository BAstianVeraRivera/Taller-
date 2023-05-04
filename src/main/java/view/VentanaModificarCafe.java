package view;

import data.GestorDatos;
import model.Cafe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaModificarCafe extends Ventana implements ActionListener {
    private JLabel lblNombreCafe, lblGramosCafe, lblMililitros, lblTamaño, lblIngredientesOpcionales;
    private JTextField txtNombreCafe, txtGramosCafe, txtMililitros, txtTamaño, txtIngredientesOpcionales;
    private JButton btnModificar, btnCancelar;
    private JPanel panel;
    private GestorDatos gestor;

    public VentanaModificarCafe(String titulo, int ancho, int alto, GestorDatos gestor) {
        super(titulo, ancho, alto);
        this.gestor = gestor;
        crearComponentes();
        agregarComponentes();
        agregarEventos();
        setVisible(true);
    }

    private void crearComponentes() {
        lblNombreCafe = new JLabel("Nombre del café:");
        lblGramosCafe = new JLabel("Gramos de café:");
        lblMililitros = new JLabel("Mililitros de café:");
        lblTamaño = new JLabel("Tamaño del café:");
        lblIngredientesOpcionales = new JLabel("Ingredientes adicionales:");
        txtNombreCafe = new JTextField(15);
        txtGramosCafe = new JTextField(15);
        txtMililitros = new JTextField(15);
        txtTamaño = new JTextField(15);
        txtIngredientesOpcionales = new JTextField(15);
        btnModificar = new JButton("Agregar Café");
        btnCancelar = new JButton("Cancelar");
        panel = new JPanel();
        panel.setLayout(new GridLayout(7, 2));
    }

    private void agregarComponentes() {
        panel.add(lblNombreCafe);
        panel.add(txtNombreCafe);
        panel.add(lblGramosCafe);
        panel.add(txtGramosCafe);
        panel.add(lblMililitros);
        panel.add(txtMililitros);
        panel.add(lblTamaño);
        panel.add(txtTamaño);
        panel.add(lblIngredientesOpcionales);
        panel.add(txtIngredientesOpcionales);
        panel.add(btnModificar);
        panel.add(btnCancelar);

        add(panel);
    }

    private void agregarEventos() {
        btnModificar.addActionListener(this);
        btnCancelar.addActionListener(this);
    }

    public void actionPerformed(ActionEvent accion) {
        if (accion.getSource() == btnModificar) {
            String nombre = txtNombreCafe.getText();
            int gramosCafe = Integer.parseInt(txtGramosCafe.getText());
            int mililitros = Integer.parseInt(txtMililitros.getText());
            String tamaño = txtTamaño.getText();
            String ingredientes = txtIngredientesOpcionales.getText();
            Cafe cafe = new Cafe(nombre, gramosCafe, mililitros, tamaño, ingredientes);
            gestor.agregarCafe(cafe);
            JOptionPane.showMessageDialog(this, "Información del café actualizada con éxito");
            dispose();
            new VentanaBienvenida("", 500, 300, gestor);
        } else if (accion.getSource() == btnCancelar) {
            dispose();
            new VentanaBienvenida("Cafetería BASTIAN", 500, 300, gestor);
        }
    }
}
