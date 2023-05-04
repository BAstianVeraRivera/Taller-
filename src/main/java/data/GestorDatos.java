package data;
import model.Cafe;
import java.io.*;
public class GestorDatos {
    private String archivoCafe;
    private String archivoCafetería;

    public String getArchivoCafe() {
        return archivoCafe;
    }

    public void setArchivoCafe(String archivoCafe) {
        this.archivoCafe = archivoCafe;
    }

    public String getArchivoCafetería() {
        return archivoCafetería;
    }

    public void setArchivoCafetería(String archivoCafetería) {
        this.archivoCafetería = archivoCafetería;
    }

    public GestorDatos(String archivoCafe, String archivoCafetería) {
        this.archivoCafe = archivoCafe;
        this.archivoCafetería = archivoCafetería;
    }

    public void agregarCafe(Cafe cafe) {
        try {
            FileWriter fw = new FileWriter(archivoCafe, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            pw.println(cafe.getNombreCafe()+", "+cafe.getGramosCafe() + ", " + cafe.getMililitros() + ", " + cafe.getTamaño() + ", " + cafe.getIngredientesOpcionales());
            pw.close();
            bw.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public Cafe buscarCafePorTamaño(String tamaño) {
        try {
            FileReader fr = new FileReader(archivoCafe);
            BufferedReader br = new BufferedReader(fr);
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos[3].equals(tamaño)) {
                    br.close();
                    fr.close();
                    return new Cafe(datos[0], Integer.parseInt(datos[1]), Integer.parseInt(datos[2]), datos[3], datos[4]);
                }
            }
            br.close();
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    public Cafe buscarCafePorNombre(String nombre) {
        try {
            FileReader fr = new FileReader(archivoCafe);
            BufferedReader br = new BufferedReader(fr);
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos[3].equals(nombre)) {
                    br.close();
                    fr.close();
                    return new Cafe(datos[0], Integer.parseInt(datos[1]), Integer.parseInt(datos[2]), datos[3], datos[4]);
                }
            }
            br.close();
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    public Cafe eliminarCafe(String nombre) {
        try {
            FileReader fr = new FileReader(archivoCafe);
            BufferedReader br = new BufferedReader(fr);
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos[0].equals(nombre)) {
                    br.close();
                    fr.close();
                    return new Cafe(datos[0], Integer.parseInt(datos[1]), Integer.parseInt(datos[2]), datos[3], datos[4]);
                }
            }
            br.close();
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}