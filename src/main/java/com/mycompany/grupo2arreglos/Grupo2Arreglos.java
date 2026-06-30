package com.mycompany.grupo2arreglos;

import com.mycompany.grupo2arreglos.utils.GestorCalificaciones;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Grupo2Arreglos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Instanciamos el objeto de nuestra clase lógica
        GestorCalificaciones gestor = new GestorCalificaciones();
        boolean salir = false;

        while (!salir) {
            mostrarMenu();
            
            try {
                System.out.print("Elige una opción: ");
                int opcion = scanner.nextInt();

                switch (opcion) {
                    case 1:
                        System.out.print("Ingresa la nueva calificación: ");
                        double nuevaNota = scanner.nextDouble();
                        // El gestor lanza excepción si la nota es inválida
                        gestor.agregarCalificacion(nuevaNota);
                        System.out.println("Calificación agregada exitosamente.");
                        break;

                    case 2:
                        if (gestor.estaVacia()) {
                            System.out.println("No hay calificaciones registradas.");
                            break;
                        }
                        System.out.print("Ingresa el índice (0 a " + (gestor.cantidadCalificaciones() - 1) + ") a eliminar: ");
                        int indice = scanner.nextInt();
                        double eliminada = gestor.eliminarCalificacion(indice);
                        System.out.println("Se eliminó la calificación: " + eliminada);
                        break;

                    case 3:
                        System.out.print("Ingresa la calificación que deseas buscar: ");
                        double notaBuscar = scanner.nextDouble();
                        if (gestor.buscarCalificacion(notaBuscar)) {
                            System.out.println("🔍 La calificación " + notaBuscar + " SÍ está en la lista.");
                        } else {
                            System.out.println("La calificación " + notaBuscar + " NO se encontró.");
                        }
                        break;

                    case 4:
                        if (gestor.estaVacia()) {
                            System.out.println("La lista está vacía.");
                        } else {
                            System.out.println("\n--- Lista de Calificaciones ---");
                            ArrayList<Double> lista = gestor.obtenerTodas();
                            for (int i = 0; i < lista.size(); i++) {
                                System.out.println("Índice [" + i + "] -> " + lista.get(i));
                            }
                        }
                        break;

                    case 5:
                        if (gestor.estaVacia()) {
                            System.out.println("No hay datos para calcular.");
                        } else {
                            System.out.println("El promedio del grupo es: " + gestor.calcularPromedio());
                        }
                        break;

                    case 6:
                        if (gestor.estaVacia()) {
                            System.out.println("No hay datos.");
                        } else {
                            System.out.println("La nota más alta es: " + gestor.obtenerNotaMasAlta());
                        }
                        break;

                    case 7:
                        if (gestor.estaVacia()) {
                            System.out.println("No hay datos.");
                        } else {
                            System.out.println("La nota más baja es: " + gestor.obtenerNotaMasBaja());
                        }
                        break;

                    case 8:
                        salir = true;
                        System.out.println("Saliendo del sistema... ¡Hasta pronto!");
                        break;

                    default:
                        System.out.println("Opción no válida. Intenta de nuevo.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error de formato: Debes ingresar un número. (Evita usar letras)");
                scanner.nextLine(); // Limpiamos el buffer del teclado
            } catch (IllegalArgumentException | IndexOutOfBoundsException e) {
                // Capturamos las excepciones de lógica lanzadas por el Gestor
                System.out.println("Error lógico: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Ocurrió un error inesperado: " + e.getMessage());
                scanner.nextLine();
            }
        }
        scanner.close();
    }

    /**
     * Imprime las opciones del menú en la consola.
     */
    private static void mostrarMenu() {
        System.out.println("\n=== GESTION DE CALIFICACIONES ===");
        System.out.println("1. Agregar calificacion");
        System.out.println("2. Eliminar calificacion");
        System.out.println("3. Buscar una calificacion");
        System.out.println("4. Mostrar todas las calificaciones");
        System.out.println("5. Calcular el promedio");
        System.out.println("6. Determinar la nota mas alta");
        System.out.println("7. Determinar la nota mas baja");
        System.out.println("8. Salir");
    }
}
