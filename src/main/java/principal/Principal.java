package principal;
import data.GestorDatos;
import view.VentanaBienvenida;

public class Principal {
    public static void main(String[] args) {
        GestorDatos gestor = new GestorDatos("cafes.txt", "cafeteria.txt");
        new VentanaBienvenida("Cafetería BASTIAN", 500, 300,gestor);
    }
}