import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


/**creacion de una clase llamada tarea cuya funcion es definir las lista que manejaremos en el programa
 * una de tipo string para almacenar las tareas a realizar y otra de tipo boolean para almacenar el estado de cada tarea,
 * esta clase tiene un constructor que recibe como parametros una tarea y su estado, y asigna
 * estos parametros a las variables de la clase, esta clase se utiliza para crear objetos de tipo tarea que se almacenan 
 * en una lista de tareas,
 */
class Tarea{ 
    String tareas;
    boolean completada;

    public Tarea(String tareas, boolean completada){
        this.tareas = tareas;//asignacion del parametro tarea a la variable de la clase tareas.
        this.completada = completada;//asignacion del parametro completada a la variable de la clase completada.
    }
        
    
}

public class mi_gestor_tareas{
        static int options;// variable para opciones del menu
        static Scanner Seleccion = new Scanner(System.in);
        static boolean continuar = true; // variable para controlar el bucle del menu
        static String respuesta; 
        static String respuesta2;
        static List<Tarea> tareas = new ArrayList<>(Arrays.asList(
            new Tarea("Hacer trabajos", false),
            new Tarea("Estudiar inglés", false),
            new Tarea("Hacer ejercicio", false)
        ));      /*+ definimos la lista de tareas a realizar, esta lista se inicializa con tres tareas pendientes, 
        cada tarea es un objeto de tipo Tarea que contiene una descripcion de la tarea y su estado de completada o pendiente. */ 
       
    
////////////////////////////////////////////////////////////////////
        /**funcion para obtener las tareas a realizar y su estado.
         Esta funcion recorre las listas declaradas, tareas y completada, para crear una nueva lista organizada,
         no recibe parametros, pero retorna una lista tipo string con las tareas y su estado marcado con [x] si esta completada 
         o [] si esta pendiente.
         */ 
        public static List<String>  obtenerTareas(){
                List<String> listaTareas = new ArrayList<>();
                    for(int i=0; i<tareas.size(); i++){ /** for para recorrer las listas tareas y completada, 
                    para crear una nueva lista organizada.*/
                        if(tareas.get(i).completada==false){
                        //si la tarea esta pendiente, se agrega a la lista de tareas con el estado marcado como []. 
                        listaTareas.add(tareas.get(i).tareas + "\t\t[]\n");
                        }
                        else{//si la tarea esta completada, se agrega a la lista de tareas con el estado marcado como [x].
                            listaTareas.add(tareas.get(i).tareas + "\t\t[x]\n");
                        }
                    }
            return listaTareas;
        }

    //opcion 1: Ver tareas    
    //funcion para mostrar las tareas a realizar y su estado.
    /** Esta funcion recibe como parametro la listaTareas para mostrarlas porque es la lista que contiene los datos que 
     * mostraremos en pantalla, no retorna nada
     * cuando es llamada, muestra la lista de tareas a realizar y su estado,
     * tambien pregunta al usuario si desea volver al menu principal o salir.
     */
    public static void mostrarTareas(List<String> listaTareas){
        Scanner scanner = new Scanner(System.in);
        int posicion=0;
        for(int i=0; i<listaTareas.size(); i++){/** for para recorrer la lista de tareas a mostrar,
        se muestra el numero de la tarea y su descripcion con su estado.
        ademas el contador nos sirve para mostrar la posicion de la tarea en la lista*/
            posicion++;
            System.out.println(posicion + " - " + listaTareas.get(i));
        }
        System.out.println("Desea volver al menu principal? (s/n)");
                    respuesta=scanner.next();
                    if (respuesta.equalsIgnoreCase("s")){
                        continuar=true;
                    }
                     else {
                    System.out.println("Buen dia\n");
                continuar=false;
                     }
    }

    //opcion 2: Agregar tarea
    /**funcion para agregar una tarea nueva y su estado a la lista de tareas a realizar.
     * esta funcion recibe como parametros la lista de tareas y la lista de estados. pide al usuario
     * ingresar por teclado una nueva tarea, la agrega a la lista de tareas y se agrega un estado "false" 
     * a la lista de estados en la misma posicion para indicar que esta pendiente, retorna la lista de tareas actualizada, 
     * esta lista actualizada se muestra al usuario si se regresa al menu principal y se selecciona la opcion 1 de ver tareas,  
     * tambien pregunta al usuario si desea agregar otra tarea o volver al menu principal o salir.
     * 
     */
    public static List<Tarea> agregarTarea(List<Tarea> listaTareas,boolean completada){
        Scanner scanner = new Scanner(System.in);
        do{
        System.out.println("Describe la nueva tarea: ");
        String nuevaTarea = scanner.nextLine();
        listaTareas.add(new Tarea(nuevaTarea, false));
        System.out.println("Tarea agregada exitosamente\n");
        System.out.println("Desea agregar otra tarea? (s/n)");
                    respuesta= scanner.next();
                    scanner.nextLine();
                } while (respuesta.equalsIgnoreCase("s"));//el ciclo termina si el usuario no desea 
                if (respuesta.equalsIgnoreCase("n")){
                    System.out.println("Desea volver al menu principal? (s/n)");
                    respuesta2=scanner.next();
                    if (respuesta2.equalsIgnoreCase("s")){
                        continuar=true;
                    }
                     else {
                    System.out.println("Buen dia\n");
                continuar=false;
                     }
        }
        
        return listaTareas;
          
    }

    //opcion 3: Marcar tarea como completada
    /**
     * funcion que marca una de las tareas de la lista como completada, esta funcion recibe dos parametros lsitaTareas y completada.
     * Por teclado ingresa el usuario el numero de la tarea que desea marcar como completada, esta funcion cambia el valor de la 
     * posicion numeroTarea-1 en la lista completada a true, indicando que la tarea esta completada, no retorna nada pero si modifica 
     * la lista completada en su estado, esta lista actualizada se muestra al usuario si se regresa al menu principal y se selecciona la opcion 1 de ver tareas,
     * sin embargo como se pide, se realizo el llamado del try catch para manejar el error de ingresar un numero de tarea inexistente o invalido, 
     * en este caso se muestra un mensaje de error y se pregunta al usuario si desea marcar otra tarea como completada o volver al menu principal o salir.
     */
    public static void marcarCompletada(List<Tarea> listaTareas, Boolean completada){
        Scanner scanner = new Scanner(System.in);
        do{
        System.out.println("Ingrese el numero de la tarea que desea marcar como completada: ");
        int numeroTarea = scanner.nextInt();
        try{//try catch para manejar el error de ingresar un numero de tarea inexistente o invalido.
            listaTareas.get(numeroTarea - 1).completada = true;/** set cambia el valor de la posicion numeroTarea-1 en la lista completada a true,
             indicando que la tarea esta completada.*/
            System.out.println("Tarea marcada como completada\n");
                    }
        catch (IndexOutOfBoundsException e){//catch para manejar el error de ingresar un numero de tarea inexistente o invalido.
                    System.out.println("Error: Numero de tarea invalido o no existe\n");
        }
        System.out.println("Desea marcar otra tarea como completada? (s/n)");
                    respuesta= scanner.next();
                    scanner.nextLine();
        } while (respuesta.equalsIgnoreCase("s"));//el ciclo termina si el usuario no desea
        System.out.println("Desea volver al menu principal? (s/n)");
                    respuesta=scanner.next();
                    if (respuesta.equalsIgnoreCase("s")){
                        continuar=true;
                    }
                     else {
                    System.out.println("Buen dia\n");
                continuar=false;
                     }
    }



    //opcion 4: Mostrar total de tareas pendientes
    /**
     * funcion para contar el numero de tareas pendientes, esta funcion recibe como parametros un indice y la lista
     * completada, esta funcion utiliza recursividad para recorrer la lista completada y contar el numero de tareas pendientes, 
     * el caso base es cuando el indice llega a ser igual al tamaño de la lista completada, en este caso se retorna 0, 
     * indicando que no hay tareas pendientes, si el valor en la posicion del indice es false, se suma 1 y se llama recursivamente 
     * a la funcion con el siguiente indice, si el valor en la posicion del indice es true, se llama recursivamente a la funcion 
     * con el siguiente indice sin sumar nada, esta funcion retorna el numero total de tareas pendientes.
     */
    public static int contarTareasPendientes(int indice, List<Tarea> tareas){
       if (indice== tareas.size()){//caso base: cuando el indice llega a ser igual al tamaño de la lista completadas.
        return  0;// retorna 0, indicando que no hay tareas pendientes.
       }

       if (!tareas.get(indice).completada) {
        /** Si está pendiente, retorna 1 más el resultado de contar las tareas pendientes a partir del siguiente índice+1.
         * Esto suma 1 por la tarea pendiente actual y continúa contando las siguientes tareas. hasta que se alcance el caso base.
        */
        return 1 + contarTareasPendientes(indice + 1, tareas);
       }

       else {
        return contarTareasPendientes(indice + 1, tareas);// Si está completada, solo seguimos con el siguiente índice sin 
        //sumar nada.

        }

}
        //opcion 5: Salir del programa
         public static void Salir(){
        System.out.println("Buen dia\n");
        continuar=false;
    }

        
        public static void  main(String[] args) {
            

           do
        {
            obtenerTareas();
            
            // seleccion de opciones:
        System.out.println("seleccione una opcion: ");
        System.out.println("1. Ver tareas");
        System.out.println("2. Agregar tarea");
        System.out.println("3. Marcar tarea como completada");
        System.out.println("4. Mostrar total de tareas pendientes");
        System.out.println("5. Salir");
        options = Seleccion.nextInt();    
        
        switch (options)  {/** switch para seleccionar la opcion del menu, dependiendo de la opcion seleccionada se llama a la funcion correspondiente,
         cada caso corresponde a una opcion del menu, si se selecciona una opcion valida se ejecuta la funcion correspondiente, si se selecciona una opcion 
         no valida se muestra un mensaje de error y se vuelve a mostrar el menu. */  

            

            case 1: 
                
                ///opcion 1: Agregar estudiantes
                mostrarTareas(obtenerTareas());
        
            break;
                       

                ///opcion 2: Mostrar estudiantes*/
           case 2:
                
                agregarTarea(tareas, tareas.get(0).completada);
            break;
                            
            ///opcion 3: Marcar tarea como completada
            case 3:
                
                marcarCompletada(tareas, tareas.get(0).completada);
                break;

            //opcion 4: Mostrar total de tareas pendientes
            case 4:
                Scanner scanner = new Scanner(System.in);
                int pendientes = contarTareasPendientes(0, tareas);
                System.out.println("Las tareas pendientes son: " + pendientes);
                    System.out.println("Desea volver al menu principal? (s/n)");
                        respuesta=scanner.next();
                        if (respuesta.equalsIgnoreCase("s")){
                            continuar=true;
                        }
                         else {
                            continuar=false;
                        }
                break;

                //opcion 5: Salir del programa
            case 5:
                Salir();
                break;
                //opcion cuando se digita un numero que no esta en el menu: Opcion no valida
            default: {
                System.out.println("Opcion no valida\n");
                continuar = true;
                }
            }
        } while(continuar==true); 
    }

        }      
    
   


