import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        String[] planetas = {
                "Mercurio",
                "Venus",
                "Marte",
                "Jupiter",
                "Saturno"
        };

        String[] naves = {
                "Endorex x5050",
                "InteresTelar",
                "Enterprise",
                "Galactica",
                "Start ship"
        };

        // ELEGIR DESTINO
        System.out.println("==================================");
        System.out.println("####### MENU DE PLANETAS ########");
        for (int i = 0; i < planetas.length; i++) {
            System.out.printf("Planeta %d: %s%n", (i + 1), planetas[i]);
        }

        System.out.print("Elige el destino planetario donde quieres ir -> ");
        var eleccionPlaneta = scanner.nextInt();

        if (eleccionPlaneta >= 0 && eleccionPlaneta <= planetas.length) {
            System.out.printf("Has eligido viajar a: %s%n", planetas[eleccionPlaneta - 1].toUpperCase());
        } else {
            System.err.println("Elección incorrecta");
        }

        // ELEGIR NAVE
        System.out.println("");
        System.out.println("==================================");
        System.out.println("####### MENU DE NAVES ########");
        for (int i = 0; i < naves.length; i++) {
            System.out.printf("Nave %d: %s%n", (i + 1), naves[i]);
        }

        System.out.print("Elige la nave para comenzar el viaje -> ");
        var eleccionNave = scanner.nextInt();

        if (eleccionNave >= 0 && eleccionNave <= planetas.length) {
            System.out.printf("Has eligido la nave: %s%n", naves[eleccionNave - 1].toUpperCase());
        }

        // CALCULAR DISTANCIA Y TIEMPO

        scanner.close();
    }

}
