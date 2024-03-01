import java.util.Scanner;
import java.util.ArrayList;
public class Estudiantes{
    //Definición de la clase Estudiante
    static class Estudiante{
        private int identf;
        private String nomb;
        private String correo;
        //Constructor de la clase Estudiante 
        public Estudiante(int identf, String nomb, String correo){
            this.identf = identf;
            this.nomb = nomb;
            this.correo = correo;
        }
        //Método para obtener los atributos del estudiante  
        public int getIdentf(){
            return identf;
        }
        public String getNomb(){
            return nomb;
        }

        public String getCorrep(){
            return correo;
        }

        //modificar los atributos del estudiante
        public void setIdentf(int identf){
            this.identf = identf;
        }

        public void setName(String nomb){
            this.nomb = nomb;
        }

        //imprimir los datos del estudiante
        public void imprimirEstudiante() {
            System.out.println("Identificación: " + identf);
            System.out.println("Nombre: " + nomb);
            System.out.println("Correo: " + correo);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Estudiante> listaDeEstudiantes = new ArrayList<>();
        System.out.print("Ingrese el número de estudiantes a cargar: ");
        int n = scanner.nextInt();

        //Ciclo para los datos de los estudiantes a cargar
        for (int i = 0; i < n; i++) {
            System.out.println("Ingrese los datos del estudiante " + (i + 1) + ":");
            System.out.print("Identificación: ");
            int identf = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Nombre: ");
            String nomb = scanner.nextLine();
            System.out.print("Correo: ");
            String correo = scanner.nextLine();
            Estudiante estudiante = new Estudiante(identf,nomb,correo);
            listaDeEstudiantes.add(estudiante);
        }

        //Imprimir la lista original de los estudiantes
        System.out.println("\nLista de los estudiantes:");
         for (Estudiante estudiante : listaDeEstudiantes){
         estudiante.imprimirDeEstudiante();
         System.out.println();
        }

        //Consulta de un estudiante por su número de identificación
        System.out.print("Ingrese el número de identificación del estudiante a consultar: ");
        int identfConsulta = scanner.nextInt();
        boolean encontrado = false;
        for (Estudiante estudiante : listaDeEstudiantes){
            if (estudiante.getIdentf() == identfConsulta) {
                System.out.println("\nDatos del estudiante encontrado:");
                estudiante.imprimirEstudiante();
                encontrado = true;
                break;
            }
        }
        
        if (!encontrado){
            System.out.println("No se encontró ningún estudiante con esta identificación.");
        }

        //Actualización de la identificación y el nombre
        System.out.print("\nIngrese el número de identificación del estudiante a actualizar: ");
        int identfActualizar = scanner.nextInt();
        for (Estudiante estudiante : listaDeEstudiantes){
            if (estudiante.getIdentf() == identfActualizar) {
                scanner.nextLine(); 
                System.out.print("Ingrese el nombre actualizado o el nuevo nombre: ");
                String nuevoNomb = scanner.nextLine();
                estudiante.setNomb(nuevoNomb);
                System.out.print("Ingrese la nueva identificación a actualizar: ");
                int nuevaIdentf = scanner.nextInt();
                estudiante.setIdentf(nuevaIdentf);
                System.out.println("Datos actualizados del estudiante:");
                estudiante.imprimirEstudiante();
                break;
            }
        }

        //Imprime el listado actualizado de los estudiantes 
        System.out.println("\nLista actualizada de estudiantes:");
        for (Estudiante estudiante : listaDeEstudiantes){
            estudiante.imprimirEstudiante();
            System.out.println();
        }
    }
}


