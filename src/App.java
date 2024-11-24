import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        Random aleatorio = new Random();

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

        double[] combustiblesPorDia = {
                1000,
                5000,
                7650,
                4980,
                10000
        };

        double[] oxigenoNavePorDia = {
                3.5,
                6.7,
                3.7,
                9.8,
                5.9
        };

        String[] eventosAleatorios = {
                "Alerta, daño en la calefacción",
                "Falla critica, daño en el motor 2",
                "Peligro, perdida de oxigeno",
                "Urgente, lluvia de meteoritos"
        };

        String[][] solucionEventos = {
                { "Redirección energia del motor 1", "Apagar iluminación" },
                { "Apagar motor 2", "Reparar motor 2" },
                { "Reducir el oxigeno al 50%,", "Redireccionar todo el oxigeno a la cabina del capitan" },
                { "Desviar la nave", "atravesar la lluvia de meteoritos" }
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

        // 1. ELEGIR DESTINO
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

        // 2. CALCULAR DISTANCIA Y TIEMPO
        double distancia = distancias[eleccionPlaneta - 1];
        double velocidad = velocidades[eleccionNave - 1];
        double timeYear = distancia / velocidad;

        System.out.printf("%nDistancia al planeta %s %.1f millones de KM %n", planetas[eleccionPlaneta - 1], distancia);
        System.out.printf("%nTiempo del viaje con la nave %s es de %.1f años %n", naves[eleccionNave - 1], timeYear);

        System.out.printf("%n %s! VES PREPARANDOTE PARA EL VIAJE AL ESPACIO! %n%n", nombre.toUpperCase());

        // 3. GESTIONAR RECURSOS DE LA NAVE
        System.out.printf("%n==============================================================%n");
        System.out.printf(
                "%n%nA CONTINUACIÓN VERAS LOS RECURSOS NECESARIOS QUE NECESITAS PARA ESTA AVENTURA ESPACIAL! %n%n");

        // conversion de años a horas
        var horasTotales = timeYear * 365 * 24;

        // Recursos de combustible
        double recursoCombustiblePorHora = combustiblesPorDia[eleccionNave - 1] / 24;
        double calculoCombustibleRequerido = recursoCombustiblePorHora * horasTotales;

        // recursos de oxigeno
        double recursoOxigenoPorDia = oxigenoNavePorDia[eleccionNave - 1];
        double calculoOxigenoRequerido = recursoOxigenoPorDia * (timeYear * 365);

        System.out.printf("Para viajar al planeta %s necesitas de combustible %.2f toneladas %n",
                planetas[eleccionPlaneta - 1], calculoCombustibleRequerido);
        System.out.printf("Para viajar al planeta %s necesitas una cantidad de oxigeno de %.2f KG %n",
                planetas[eleccionPlaneta - 1],
                calculoOxigenoRequerido);

        System.out.printf(
                "%n%n Abrocha tu cintoron despegamos en 5, 4, 3, 2, 1! %n%n");

        System.out.printf(
                "%n%n Felicitaciones %s el despegue fue exitoso, la nave opera al 100 porciento de capacidad, en caso de algun contratiempo te informaremos %n%n ",
                nombre);

        // 4. Eventos Aleatorios
        int eventoIndex = aleatorio.nextInt(eventosAleatorios.length);
        var evento = eventosAleatorios[eventoIndex];

        System.out.printf("%n%n Atención %s, %s ", nombre, evento);
        System.out.printf("%n%n Que quieres hacer:");

        String[] opcionSoluciones = solucionEventos[eventoIndex];

        for (int i = 0; i < opcionSoluciones.length; i++) {
            System.out.printf("%n Solución %d: %s", (i + 1), opcionSoluciones[i]);
        }

        var opcionSalvavidas = 0;
        while (opcionSalvavidas < 1 || opcionSalvavidas > opcionSoluciones.length) {
            System.out.printf("%n Que opción quieres elegir:");
            opcionSalvavidas = scanner.nextInt();
        }

        switch (eventoIndex) {
            case 0: // Este es la opción de Alerta, daño en la calefacción
                if (opcionSalvavidas == 1) {
                    System.out.print("Buen trabajo, esta opción consume un poco más de combustible pero no afecta la velocidad");
                } else if (opcionSalvavidas == 2) {
                    System.out.print("Excelente trabajo, esta opción es la ideal no sacrifica ni velocidad ni combustible");
                }
                break;
            case 1: // Esta es la opción de Falla critica, daño en el motor 2,
                if (opcionSalvavidas == 1) {
                    System.out.print("Esta opción reduce la velocidad del viaje y el tiempo de llegada");
                } else if (opcionSalvavidas == 2) {
                    System.out.print("Esta opción es la ideal, salva la integridad de la nave");
                }
                break;

            case 2: // Esta es la opción de Peligro, perdida de oxigeno
                if (opcionSalvavidas == 1) {
                    System.out.print("Reducir el oxigeno al 50%");
                } else if (opcionSalvavidas == 2) {
                    System.out.print("Redireccionar todo el oxigeno a la cabina del capitan");
                }
                break; 

            case 3: // Esta es la opción Urgente, lluvia de meteoritos
                if (opcionSalvavidas == 1) {
                    System.out.print("Desviar la nave");
                } else if (opcionSalvavidas == 2) {
                    System.out.print("atravesar la lluvia de meteoritos");
                }
                break; 

            default:
                break;
        }

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
