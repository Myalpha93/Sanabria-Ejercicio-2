import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Visitante> visitantes = new ArrayList();
    public static void main(String[] args) {
        boolean ciclo = true;
        Scanner lector= new Scanner(System.in);
        int seleccion;

        double numero;
        while (ciclo) {
            System.out.println("***************");
            System.out.println("*Bienvenido*");
            System.out.println("1. Ingresar datos de un visitante");
            System.out.println("2. Mostrar todos los visitantes");
            System.out.println("3. Salir");
            System.out.println("***************");
            seleccion= LectorDatos.solicitarEntero("Seleccione alguna opcion: ");
            switch (seleccion){
                case 1:
                    System.out.println("Ingrese los siguientes datos");
                    String nombre= LectorDatos.solicitarString("Ingrese el nombre del visitante: ");
                    String telefono= LectorDatos.solicitarString("Ingrese el telefono del visitante: ");
                    int visita=1;
                    Visitante nuevoVisitante= new Visitante();
                    try{
                        nuevoVisitante.setNombreCompleto(nombre);
                        nuevoVisitante.setTelefono(telefono);
                    } catch (ErrorValidacion e) {
                        System.err.println(e.getMessage());
                    }
                    nuevoVisitante.setNumVisitas(visita);
                    int indice=-1;
                    int cont=0;
                    if(!visitantes.isEmpty()) {
                        for (Visitante c : visitantes) {
                            if (c.getTelefono().equals(telefono)) {
                                System.out.println("El numero de telefono ya ha sido ingresado");
                                indice = cont;
                            }
                            cont++;
                        }
                    }
                        if (indice!=-1) {
                            visitantes.get(indice).setNumVisitas(visita);
                        } else {
                            if (nuevoVisitante.getTelefono()!=null && nuevoVisitante.getNombreCompleto()!=null) {
                                visitantes.add(nuevoVisitante);
                                System.out.println("Registro ingresado correctamente");
                            }else{
                                System.out.println("Ingreso el nombre o telefono de forma incorrecta no se agrega este registro");
                            }
                        }
                    break;
                case 2:
                    if(visitantes.isEmpty()){
                        System.out.println("No ha ingresado registros");
                    } else{
                        System.out.println("Mostrando todos los registros:");
                        int contador=1;
                        for (Visitante c : visitantes) {
                            System.out.println(contador + " cliente:");
                            System.out.println("Nombre: " + c.getNombreCompleto());
                            System.out.println("Telefono: " + c.getTelefono());
                            System.out.println("Cantidad de visitas: " + c.getNumVisitas());
                            contador++;
                        }
                    }
                    break;
                case 3:
                    System.out.println("Adios");
                    ciclo=false;
                    break;
                    default:
                        System.out.println("Opcion Invalida");
                        break;
            }
        }
    }
}
