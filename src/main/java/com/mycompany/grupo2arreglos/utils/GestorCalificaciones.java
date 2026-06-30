package com.mycompany.grupo2arreglos.utils;


import java.util.ArrayList;


//Clase encargada de gestionar las operaciones sobre la colección de calificaciones.
//Aplica principios de POO como la encapsulación.
public class GestorCalificaciones {
    
    // El ArrayList está encapsulado (private) para que no sea modificado desde fuera
    private ArrayList<Double> calificaciones;

    //Constructor que inicializa la lista de calificaciones.
    public GestorCalificaciones() {
        this.calificaciones = new ArrayList<>();
    }

    //Agrega una nueva calificación a la lista validando su rango.
    //@param nota La calificación a agregar.
    public void agregarCalificacion(double nota) {
        if (nota < 0 || nota > 100) {
            throw new IllegalArgumentException("La calificacion debe estar entre 0 y 100.");
        }
        calificaciones.add(nota);
    }

    //Elimina una calificación basándose en su índice.
    //@param indice La posición de la nota a eliminar.
    //@return La calificación que fue eliminada.
    public double eliminarCalificacion(int indice) {
        if (indice < 0 || indice >= calificaciones.size()) {
            throw new IndexOutOfBoundsException("Indice fuera de rango.");
        }
        return calificaciones.remove(indice);
    }

    //Busca si una calificación específica existe en la lista.
    //@param nota La calificación a buscar.
    //@return true si la encuentra, false en caso contrario.
    public boolean buscarCalificacion(double nota) {
        return calificaciones.contains(nota);
    }

    //Devuelve una copia de la lista para evitar que sea modificada directamente.
    //@return ArrayList con las calificaciones actuales.
    public ArrayList<Double> obtenerTodas() {
        return new ArrayList<>(calificaciones);
    }

    //Calcula el promedio matemático de las calificaciones almacenadas.
    //@return El promedio, o 0 si la lista está vacía.
    public double calcularPromedio() {
        if (calificaciones.isEmpty()) return 0;
        
        double suma = 0;
        for (double nota : calificaciones) {
            suma += nota;
        }
        return suma / calificaciones.size();
    }

    //Determina la nota más alta de la colección.
    //@return La nota máxima, o 0 si está vacía.
    public double obtenerNotaMasAlta() {
        if (calificaciones.isEmpty()) return 0;
        
        double max = calificaciones.get(0);
        for (double nota : calificaciones) {
            if (nota > max) { 
                max = nota;
            }
        }
        return max;
    }

    //Determina la nota más baja de la colección.
    //@return La nota mínima, o 0 si está vacía.
    public double obtenerNotaMasBaja() {
        if (calificaciones.isEmpty()) return 0;
        
        double min = calificaciones.get(0);
        for (double nota : calificaciones) {
            if (nota < min) { 
                min = nota;
            }
        }
        return min;
    }

    //Indica si la lista de calificaciones está vacía.
    //@return true si no hay elementos, false si hay al menos uno.
    public boolean estaVacia() {
        return calificaciones.isEmpty();
    }
    
    //Devuelve la cantidad de calificaciones registradas.
    //@return Tamaño de la lista.
    public int cantidadCalificaciones() {
        return calificaciones.size();
    }
}