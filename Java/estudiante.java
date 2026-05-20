public class estudiante {

    private String cedula;
    private String nombre;
    private String apellido;
    private double nota1;
    private double nota2;
    private double nota3;
    private double promedio;
    private String estado;

    public void Estudiante(String cedula, String nombre, String apellido,
                      double nota1, double nota2, double nota3) {
        this.cedula   = cedula;
        this.nombre   = nombre;
        this.apellido = apellido;
        this.nota1    = nota1;
        this.nota2    = nota2;
        this.nota3    = nota3;
        calcularPromedio();
        determinarEstado();
    }

    public String getCedula()   { return cedula; }
    public String getNombre()   { return nombre; }
    public String getApellido() { return apellido; }
    public double getNota1()    { return nota1; }
    public double getNota2()    { return nota2; }
    public double getNota3()    { return nota3; }
    public double getPromedio() { return promedio; }
    public String getEstado()   { return estado; }

    public void setCedula(String cedula)     { this.cedula   = cedula; }
    public void setNombre(String nombre)     { this.nombre   = nombre; }
    public void setApellido(String apellido) { this.apellido = apellido; }

    public void setNota1(double nota1) {
        this.nota1 = nota1; calcularPromedio(); determinarEstado();
    }
    public void setNota2(double nota2) {
        this.nota2 = nota2; calcularPromedio(); determinarEstado();
    }
    public void setNota3(double nota3) {
        this.nota3 = nota3; calcularPromedio(); determinarEstado();
    }

    public void calcularPromedio() {
        this.promedio = (nota1 + nota2 + nota3) / 3.0;
    }

    public void determinarEstado() {
        this.estado = (promedio >= 7.0) ? "APROBADO" : "REPROBADO";
    }

    public void mostrarInformacion() {
        System.out.println("----------------------------------------------");
        System.out.printf("  Cédula   : %s%n",   cedula);
        System.out.printf("  Nombre   : %s %s%n", nombre, apellido);
        System.out.printf("  Nota 1   : %.2f%n",  nota1);
        System.out.printf("  Nota 2   : %.2f%n",  nota2);
        System.out.printf("  Nota 3   : %.2f%n",  nota3);
        System.out.printf("  Promedio : %.2f%n",  promedio);
        System.out.printf("  Estado   : %s%n",    estado);
    }
}
