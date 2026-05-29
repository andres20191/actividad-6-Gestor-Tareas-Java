import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class mi_gestor_tareas{
    static int options;// variable para opciones del menu
    static Scanner Seleccion = new Scanner(System.in);
    static boolean continuar = true; // variable para controlar el bucle del menu
    static String respuesta;
    static String respuesta2;
    //listas para almacenar las tareas a realizar y su estado de completada o no completada.
    static List<String> tareas = new ArrayList<>(Arrays.asList("Hacer trabajos","Estudiar ingles","Hacer ejercicio"));
    static List<Boolean> completada = new ArrayList<>(Arrays.asList(false, false, false));


    //funcion para tomar las listas de tareas y su estado y crear una nueva lista para mostrar
    public static List<String> obtenerTareas(){
        List<String> listaTareas = new ArrayList<>();
        for(int i=0; i<completada.size(); i++){
            if(!completada.get(i)){
                listaTareas.add(tareas.get(i) + "\t\t[]\n");
            } else {
                listaTareas.add(tareas.get(i) + "\t\t[x]\n");
            }
        }
        return listaTareas;
    }

    //opcion 1: Ver tareas
    //funcion para mostrar las tareas a realizar y su estado.
    public static void mostrarTareas(List<String> listaTareas){
        Scanner scanner = new Scanner(System.in);
        int posicion=0;
        for(int i=0; i<listaTareas.size(); i++){
            posicion++;
            System.out.println(posicion + " - " + listaTareas.get(i));
        }
        System.out.println("Desea volver al menu principal? (s/n)");
        respuesta=scanner.next();
        if (respuesta.equalsIgnoreCase("s")){
            continuar=true;
        } else {
            System.out.println("Buen dia\n");
            continuar=false;
        }
    }

    //opcion 2: Agregar tarea
    //funcion para agregar una tarea nueva y su estado a la lista de tareas a realizar.
    public static void agregarTarea(){
        Scanner scanner = new Scanner(System.in);
        do{
            System.out.println("Describe la nueva tarea: ");
            String nuevaTarea = scanner.nextLine();
            tareas.add(nuevaTarea);
            completada.add(false);
            System.out.println("Tarea agregada exitosamente\n");
            System.out.println("Desea agregar otra tarea? (s/n)");
            respuesta = scanner.next();
            scanner.nextLine();
        } while (respuesta.equalsIgnoreCase("s"));
        if (respuesta.equalsIgnoreCase("n")){
            System.out.println("Desea volver al menu principal? (s/n)");
            respuesta2=scanner.next();
            if (respuesta2.equalsIgnoreCase("s")){
                continuar=true;
            } else {
                System.out.println("Buen dia\n");
                continuar=false;
            }
        }
    }

    //opcion 3: Marcar tarea como completada
    public static void marcarCompletada(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el numero de la tarea que desea marcar como completada: ");
        int numeroTarea = scanner.nextInt();
        if(numeroTarea>0 && numeroTarea<=tareas.size()){
            completada.set(numeroTarea-1, true);
        } else {
            System.out.println("Numero de tarea invalido\n");
        }
        System.out.println("Desea volver al menu principal? (s/n)");
        respuesta=scanner.next();
        if (respuesta.equalsIgnoreCase("s")){
            continuar=true;
        } else {
            System.out.println("Buen dia\n");
            continuar=false;
        }
    }

    //opcion 4: Mostrar total de tareas pendientes
    public static int contarTareasPendientes(int indice, List<Boolean> completada){
       if (indice == completada.size()){
            return 0;
       }
       if (!completada.get(indice)) {
            return 1 + contarTareasPendientes(indice + 1, completada);
       } else {
            return contarTareasPendientes(indice + 1, completada);
       }
    }

    public static void Salir(){
        System.out.println("Buen dia\n");
        continuar=false;
    }

    public static void main(String[] args) {
       do {
            System.out.println("seleccione una opcion: ");
            System.out.println("1. Ver tareas");
            System.out.println("2. Agregar tarea");
            System.out.println("3. Marcar tarea como completada");
            System.out.println("4. Mostrar total de tareas pendientes");
            System.out.println("5. Salir");
            options = Seleccion.nextInt();

            switch (options) {
                case 1:
                    mostrarTareas(obtenerTareas());
                    break;
                case 2:
                    agregarTarea();
                    break;
                case 3:
                    marcarCompletada();
                    break;
                case 4:
                    Scanner scanner = new Scanner(System.in);
                    int pendientes = contarTareasPendientes(0, completada);
                    System.out.println("Las tareas pendientes son: " + pendientes);
                    System.out.println("Desea volver al menu principal? (s/n)");
                    respuesta=scanner.next();
                    if (respuesta.equalsIgnoreCase("s")){
                        continuar=true;
                    } else {
                        continuar=false;
                    }
                    break;
                case 5:
                    Salir();
                    break;
                default: {
                    System.out.println("Opcion no valida\n");
                    continuar = true;
                }
            }
       } while(continuar==true);
    }
}
