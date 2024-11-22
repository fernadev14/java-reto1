import java.util.Scanner;
import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        String[] planetas = {
                "Mercurio",
                "Venus",
                "Marte",
                "Jupiter",
                "Saturno",
                "Urano"
        };

        String[] naves = {
                "Endorex x5050",
                "InteresTelar",
                "Enterprise",
                "Galactica",
                "Start ship"
        };

        var eleccionPlaneta = -1;
        var eleccionNave = -1;
        var nombre = "";

        Arrays.sort(planetas);
        Arrays.sort(naves);
        double[] distancias = {
                2000,
                1500,
                3450,
                1789,
                2598
        };

        double[] velocidades = {
                500,
                600,
                450,
                1000,
                2000
        };

        System.out.println("Bienvenido a spaceX, la empresa de viajes espaciales");

        // PEDIR NOMBRE AL USUARIO
        while (nombre.isEmpty()) {
            System.out.print("Por favor ingresa su nombre -> ");
            nombre = scanner.nextLine();
            nombre = capitalizeFirstLetter(nombre);
        }
        System.out.println("");

        System.out.println("A continuación te podras ver los destinos que tenemos disponibles en el momento:");

        // ELEGIR DESTINO
        System.out.println("==================================");
        System.out.println("####### MENU DE PLANETAS ########");
        for (int i = 0; i < planetas.length; i++) {
            System.out.printf("Planeta %d: %s%n", (i + 1), planetas[i]);
        }

        // PEDIR AL USUARIO ELEGIR SU DESTINO
        while (eleccionPlaneta <= 0 || eleccionPlaneta > planetas.length) {
            System.out.printf("%nHola %s, elige el destino planetario donde quieres ir -> ", nombre);
            eleccionPlaneta = scanner.nextInt();
        }
        System.out.printf("%nHas eligido viajar a: %s%n%n", planetas[eleccionPlaneta - 1].toUpperCase());

        System.out.println("A continuación veras las naves que tenemos disponibles:");

        // ELEGIR NAVE
        System.out.println("==================================");
        System.out.println("####### MENU DE NAVES ########");
        for (int i = 0; i < naves.length; i++) {
            System.out.printf("Nave %d: %s%n", (i + 1), naves[i]);
        }

        while (eleccionNave <= 0 || eleccionNave > naves.length) {
            System.out.printf("%nHola %s, elige la nave para comenzar el viaje -> ", nombre);
            eleccionNave = scanner.nextInt();
        }
        System.out.printf("%nHas eligido la nave: %s%n", naves[eleccionNave - 1].toUpperCase());

        System.out.printf("%n %s! VES PREPARANDOTE PARA EL VIAJE AL ESPACIO!", nombre.toUpperCase());

        // CALCULAR DISTANCIA Y TIEMPO
        double distancia = distancias[eleccionPlaneta - 1];
        double velocidad = velocidades[eleccionNave - 1];
        double tiempo = distancia / velocidad;

        System.out.printf("%nDistancia al planeta %s %.1f millones de KM %n", planetas[eleccionPlaneta - 1],
                distancia);
        System.out.printf("%nTiempo del viaje con la nave %s es de %.1f horas %n", naves[eleccionNave - 1],
                tiempo);

        scanner.close();
    }

    // METODO PARA CONVERTIR LA PRIMERA LETRA EN MAYUSCULA
    public static String capitalizeFirstLetter(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
    }

}
