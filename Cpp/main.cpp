#include <iostream>
#include <string>
#include <vector>
#include <iomanip>
using namespace std;

class Estudiante {
private:
    string cedula;
    string nombre;
    string apellido;
    float nota1;
    float nota2;
    float nota3;
    float promedio;
    string estado;
 
public:
    Estudiante(string ced, string nom, string ape, float n1, float n2, float n3) {
        cedula   = ced;
        nombre   = nom;
        apellido = ape;
        nota1    = n1;
        nota2    = n2;
        nota3    = n3;
        calcularPromedio();
        determinarEstado();
    }
 
    string getCedula()   { return cedula; }
    string getNombre()   { return nombre; }
    string getApellido() { return apellido; }
    float  getNota1()    { return nota1; }
    float  getNota2()    { return nota2; }
    float  getNota3()    { return nota3; }
    float  getPromedio() { return promedio; }
    string getEstado()   { return estado; }
 
    void setCedula(string ced)   { cedula   = ced; }
    void setNombre(string nom)   { nombre   = nom; }
    void setApellido(string ape) { apellido = ape; }
    void setNota1(float n)       { nota1 = n; calcularPromedio(); determinarEstado(); }
    void setNota2(float n)       { nota2 = n; calcularPromedio(); determinarEstado(); }
    void setNota3(float n)       { nota3 = n; calcularPromedio(); determinarEstado(); }

    void calcularPromedio() {
        promedio = (nota1 + nota2 + nota3) / 3.0f;
    }
 
    void determinarEstado() {
        estado = (promedio >= 7.0f) ? "APROBADO" : "REPROBADO";
    }
 
    void mostrarInformacion() {
        cout << "----------------------------------------------" << endl;
        cout << "  Cedula   : " << cedula << endl;
        cout << "  Nombre   : " << nombre << " " << apellido << endl;
        cout << "  Nota 1   : " << fixed << setprecision(2) << nota1 << endl;
        cout << "  Nota 2   : " << nota2 << endl;
        cout << "  Nota 3   : " << nota3 << endl;
        cout << "  Promedio : " << promedio << endl;
        cout << "  Estado   : " << estado << endl;
    }
};

float leerNota(const string& etiqueta) {
    float nota;
    do {
        cout << "  " << etiqueta << " (0-10): ";
        cin  >> nota;
        if (nota < 0 || nota > 10)
            cout << "  [!] Nota invalida. Ingrese un valor entre 0 y 10." << endl;
    } while (nota < 0 || nota > 10);
    return nota;
}

int main() {
    const int TOTAL = 5;
    vector<Estudiante> lista;
 
    cout << "============================================" << endl;
    cout << "  Sistema de Control de Estudiantes - C++  " << endl;
    cout << "============================================" << endl;
 
    for (int i = 1; i <= TOTAL; i++) {
        string ced, nom, ape;
        float n1, n2, n3;
 
        cout << "\n--- Estudiante " << i << " ---" << endl;
        cout << "  Cedula   : "; cin >> ced;
        cout << "  Nombre   : "; cin >> nom;
        cout << "  Apellido : "; cin >> ape;
 
        n1 = leerNota("Nota 1");
        n2 = leerNota("Nota 2");
        n3 = leerNota("Nota 3");
 
        lista.push_back(Estudiante(ced, nom, ape, n1, n2, n3));
    }
 
    cout << "\n============================================" << endl;
    cout << "          LISTADO DE ESTUDIANTES            " << endl;
    cout << "============================================" << endl;
    for (Estudiante& e : lista)
        e.mostrarInformacion();
 
    int aprobados = 0, reprobados = 0;
    for (Estudiante& e : lista) {
        if (e.getEstado() == "APROBADO") aprobados++;
        else                             reprobados++;
    }
 
    cout << "\n============================================" << endl;
    cout << "  Total aprobados  : " << aprobados  << endl;
    cout << "  Total reprobados : " << reprobados << endl;
    cout << "============================================" << endl;
 
    return 0;
}
 
