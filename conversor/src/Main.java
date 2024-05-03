import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        final String menu = """
                ****************************************
                Sea bienvenido/a al Conversor de Moneda =]
                
                1) Dolar =>> Peso Argentino
                2) Peso Argentino ==> Dolar
                3) Dolar ==> Real Brasileño
                4) Real Brasileño ==> Dolar
                5) Dolar ==> Peso Colombiano
                6) Peso Colombiano ==> Dolar
                7) Salir
                Elija una opción válida
                ****************************************
                """;

        Scanner scan = new Scanner(System.in);


        while (true) {
            // Menu bienvenida
            System.out.println(menu);

            // Obtener datos del usuario
            int opcion = scan.nextInt();

            // Checkear entrada
            if(opcion == 7){
                System.out.println("Gracias por usar el Conversor de Monedas");
                System.exit(0);
            } else if (opcion < 1 || opcion > 7) {
                System.out.println("Por favor ingrese un numero del 1 al 7");
                continue;
            }
            System.out.println("Ingrese el valor que desea convertir:");
            int valor = scan.nextInt();

            // Devolver informacion
            Convertidor convertidor = new Convertidor(opcion , valor);


        }
    }
}