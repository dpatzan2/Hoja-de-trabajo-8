package uvg.edu.gt;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Scanner;

public class HospitalEmergencySystem {
    public static void menuPrincipal() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Seleccione la implementación de PriorityQueue:");
        System.out.println("1. VectorHeap");
        System.out.println("2. Java Collection Framework (PriorityQueue)");
        int opcion = scanner.nextInt();
        switch (opcion) {
            case 1:
                menuPrincipalVectorHeap();
                break;
            case 2:
                menuPrincipalPriorityQueue();
                break;
            default:
                System.out.println("Opción inválida. Saliendo del programa.");
        }
    }

    public static void menuPrincipalVectorHeap() {
        VectorHeap<Paciente> pacientes = leerPacientes("pacientes.txt");
        while (!pacientes.isEmpty()) {
            Paciente paciente = pacientes.remove();
            System.out.println("Atendiendo a: " + paciente);
        }
    }

    public static void menuPrincipalPriorityQueue() {
        PriorityQueue<Paciente> pacientes = leerPacientesJava("pacientes.txt");
        while (!pacientes.isEmpty()) {
            Paciente paciente = pacientes.poll();
            System.out.println("Atendiendo a: " + paciente);
        }
    }

    public static VectorHeap<Paciente> leerPacientes(String fileName) {
        VectorHeap<Paciente> pacientes = new VectorHeap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] datos = line.split(",");
                if (datos.length == 3) {
                    pacientes.add(new Paciente(datos[0].trim(), datos[1].trim(), datos[2].trim().charAt(0)));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return pacientes;
    }

    public static PriorityQueue<Paciente> leerPacientesJava(String fileName) {
        PriorityQueue<Paciente> pacientes = new PriorityQueue<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] datos = line.split(",");
                if (datos.length == 3) {
                    pacientes.add(new Paciente(datos[0].trim(), datos[1].trim(), datos[2].trim().charAt(0)));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return pacientes;
    }
}
