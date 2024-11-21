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
        System.out.println("\n" + "1. Mercurio" + "\n" +
                "2. Venus" + "\n" +
                "3. Marte" + "\n" +
                "4. Jupiter" + "\n" +
                "5. Saturno" + "\n");

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
        System.out.println("\n" + "1. Endorex x5050" + "\n" +
                "2. InteresTelar" + "\n" +
                "3. Enterprise" + "\n" +
                "4. Galactica" + "\n" +
                "5. Start ship" + "\n");

        System.out.print("Elige la nave para comenzar el viaje -> ");
        var eleccionNave = scanner.nextInt();

        if (eleccionNave >= 0 && eleccionNave <= planetas.length) {
            System.out.printf("Has eligido la nave: %s%n", naves[eleccionNave - 1].toUpperCase());
        }

        // CALCULAR DISTANCIA Y TIEMPO

    }

}
