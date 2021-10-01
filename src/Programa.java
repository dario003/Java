import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Programa {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner archivo = new Scanner(new File("personas.txt"));
        archivo.useDelimiter("[;,\\n]");

        Persona mayor = null;
        int edadMayor =0, cantidadApellidoDado= 0;


        while (archivo.hasNextInt()){

            int documento = archivo.nextInt();
            String nombre = archivo.next();
            String apellido = archivo.next();
            int edad = archivo.nextInt();

            Persona p = new Persona(documento, nombre, apellido,edad);
            Persona nueva = new Persona(documento, nombre, apellido, edad);

            if ( mayor == null || p.getEdad() > mayor.getEdad()){

                mayor = p;
            }

            if (nueva.getEdad() >= 18){
                edadMayor ++;
            }

            if (nueva.getApellido().contains("PEREZ")){
                cantidadApellidoDado ++;
            }
        }
        System.out.println("La persona de mayor edad tiene los siguientes valores:");
        //System.out.println(mayor.getDocumento()+" "+ mayor.getNombre()+" "+mayor.getApellido()+" "+ mayor.getEdad());

        System.out.println("La cantidad de personas mayores de edad son: "+edadMayor);

        System.out.println("La cantidad de personas con el apellido dado es: "+cantidadApellidoDado);
    }
}
