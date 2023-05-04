package view;
import data.GestorDatos;
import model.Cafe;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaEliminarCafe extends Ventana implements ActionListener {
    private JTextField txtNombreCafe, txtRespuesta;
    private JLabel lblNombreCafe;
    private JButton btnBuscar, btnCancelar,btnEliminar;
    private JPanel panel;
    private GestorDatos gestor;

    public VentanaEliminarCafe(String titulo, int ancho, int alto, GestorDatos gestor) {
        super(titulo, ancho, alto);
        this.gestor = gestor;
        crearComponentes();
        agregarComponentes();
        agregarEventos();
        setVisible(true);
    }

    private void crearComponentes() {
        lblNombreCafe = new JLabel("Nombre del café que desea eliminar:");
        txtNombreCafe = new JTextField(15);
        btnBuscar = new JButton("Buscar");
        btnCancelar = new JButton("Cancelar");
        panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2));
    }

    private void agregarComponentes() {
        panel.add(lblNombreCafe);
        panel.add(txtNombreCafe);
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
            String tamaño = txtNombreCafe.getText();
            Cafe cafe = gestor.buscarCafePorTamaño(tamaño);
            if (cafe != null) {
                JOptionPane.showMessageDialog(this, "Café encontrado y eliminado" +cafe.toString());
                gestor.eliminarCafe(tamaño);
            } else {
                JOptionPane.showMessageDialog(this, "No se encontró el café");
            }
        } else if (e.getSource() == btnCancelar) {
            dispose();
            new VentanaBienvenida("Cafetería BASTIAN", 500, 300, gestor);
        }
    }
}