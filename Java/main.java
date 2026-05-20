import java.util.ArrayList;
import java.util.Scanner;

class Estudiante {
    private String cedula;
    private String nombre;
    private String apellido;
    private double nota1, nota2, nota3;

    public Estudiante(String cedula, String nombre, String apellido,
                       double nota1, double nota2, double nota3) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
    }

    public double calcularPromedio() {
        return (nota1 + nota2 + nota3) / 3;
    }

    public String getEstado() {
        return calcularPromedio() >= 7 ? "APROBADO" : "REPROBADO";
    }

    public void mostrarInformacion() {
        System.out.println("----------------------------------");
        System.out.println("Cédula   : " + cedula);
        System.out.println("Nombre   : " + nombre + " " + apellido);
        System.out.println("Promedio : " + calcularPromedio());
        System.out.println("Estado   : " + getEstado());
    }
}

public class main {

    public static double leerNota(Scanner sc, String etiqueta) {
        double nota;

        do {
            System.out.print("  " + etiqueta + " (0-10): ");

            while (!sc.hasNextDouble()) {
                System.out.print("  [!] Valor inválido. " + etiqueta + " (0-10): ");
                sc.next();
            }

            nota = sc.nextDouble();

            if (nota < 0 || nota > 10)
                System.out.println("  [!] Nota fuera de rango. Ingrese entre 0 y 10.");

        } while (nota < 0 || nota > 10);

        return nota;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        final int TOTAL = 5;

        ArrayList<Estudiante> lista = new ArrayList<>();

        System.out.println("============================================");
        System.out.println("  Sistema de Control de Estudiantes - Java  ");
        System.out.println("============================================");

        for (int i = 1; i <= TOTAL; i++) {

            System.out.println("\n--- Estudiante " + i + " ---");

            System.out.print("  Cedula   : ");
            String ced = sc.next();

            System.out.print("  Nombre   : ");
            String nom = sc.next();

            System.out.print("  Apellido : ");
            String ape = sc.next();

            double n1 = leerNota(sc, "Nota 1");
            double n2 = leerNota(sc, "Nota 2");
            double n3 = leerNota(sc, "Nota 3");

            lista.add(new Estudiante(ced, nom, ape, n1, n2, n3));
        }

        System.out.println("\n============================================");
        System.out.println("          LISTADO DE ESTUDIANTES            ");
        System.out.println("============================================");

        for (Estudiante e : lista)
            e.mostrarInformacion();

        long aprobados = lista.stream()
                .filter(e -> e.getEstado().equals("APROBADO"))
                .count();

        long reprobados = lista.stream()
                .filter(e -> e.getEstado().equals("REPROBADO"))
                .count();

        System.out.println("\n============================================");
        System.out.println("  Total aprobados  : " + aprobados);
        System.out.println("  Total reprobados : " + reprobados);
        System.out.println("============================================");

        sc.close();
    }
}
