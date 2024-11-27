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

                var opcionSalvavidasPlaneta = -1;
                var opcionSalvavidasNave = -1;
                var nombre = "";

                Arrays.sort(planetas);
                Arrays.sort(naves);

                double[] distancias = {
                                2000,
                                1500,
                                3450,
                                1789,
                                2598,
                                3000
                };

                double[] velocidades = {
                                500,
                                600,
                                450,
                                1000,
                                2000,
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
                                "🫧 ¡ALERTA! Una fuga de oxígeno ha sido detectada en la nave.",
                                "🔧 ¡EMERGENCIA! Fallo en el motor principal.",
                                "📡 ¡PELIGRO! Los sistemas de navegación han dejado de funcionar.",
                                "☄️ ¡URGENTE! Un meteorito está en curso de colisión con la nave."
                };

                String[][] solucionEventos = {
                                { "Sellar la fuga manualmente", "Activar el sistema de emergencia",
                                                "Ignorar la alerta" },
                                { "Intentar reiniciar el motor", "Buscar el motor de respaldo",
                                                "Reducir la velocidad de la nave" },
                                { "Reparar los sistemas de navegación", "Cambiar a control manual",
                                                "Apagar y reiniciar la nave" },
                                { "Desviar la trayectoria de la nave", "Aumentar la velocidad para esquivarlo",
                                                "Activar el escudo de la nave" }
                };

                System.out.println("###################################################################");
                System.out.println("#===== Bienvenido a spaceX, la empresa de viajes espaciales ======#");
                System.out.println("###################################################################");

                // PEDIR NOMBRE AL USUARIO
                while (nombre.isEmpty()) {
                        System.out.printf("%nPor favor ingresa su nombre -> ");
                        nombre = scanner.nextLine();
                        nombre = capitalizeFirstLetter(nombre);
                        System.out.printf("%n%n");
                }

                System.out.println(
                                "#############################################################################################");
                System.out.println(
                                "#=== A CONTINUACIÓN TE PONDRAS A VER LOS DESTINOS QUE TENEMOS DISPONIBLES EN EL MOMENTO: ===#");

                // 1. ELEGIR DESTINO
                System.out.printf("%n***** MENU DE PLANETAS *******%n%n");
                for (int i = 0; i < planetas.length; i++) {
                        System.out.printf("Planeta %d: %s%n", (i + 1), planetas[i]);
                }
                System.out.printf("%n%n");
                System.out.println(
                                "#############################################################################################");

                // PEDIR AL USUARIO ELEGIR SU DESTINO
                while (opcionSalvavidasPlaneta <= 0 || opcionSalvavidasPlaneta > planetas.length) {
                        System.out.printf("%nHola %s, elige el destino planetario donde quieres ir -> ", nombre);
                        opcionSalvavidasPlaneta = scanner.nextInt();
                }
                System.out.printf("%n%n****Has eligido viajar a: %s *****%n%n",
                                planetas[opcionSalvavidasPlaneta - 1].toUpperCase());

                System.out.println("################################################################");
                System.out.println("#===A CONTINUACIÓN VERAS LAS NAVES QUE TENEMOS DISPONIBLES: ===#");

                // ELEGIR NAVE
                System.out.printf("%n ********** MENU DE NAVES ********** %n%n");
                for (int i = 0; i < naves.length; i++) {
                        System.out.printf("Nave %d: %s%n", (i + 1), naves[i]);
                }
                System.out.printf("%n%n");
                System.out.println("################################################################");

                while (opcionSalvavidasNave <= 0 || opcionSalvavidasNave > naves.length) {
                        System.out.printf("%nHola %s, elige la nave para comenzar el viaje -> ", nombre);
                        opcionSalvavidasNave = scanner.nextInt();
                }
                System.out.printf("%n%n =========================================================== %n%n");
                System.out.printf("%n*********** Has eligido la nave: %s *********** %n",
                                naves[opcionSalvavidasNave - 1].toUpperCase());

                // 2. CALCULAR DISTANCIA Y TIEMPO
                double distancia = distancias[opcionSalvavidasPlaneta - 1];
                double velocidad = velocidades[opcionSalvavidasNave - 1];
                double timeYear = distancia / velocidad;

                System.out.printf("%n*********** Distancia al planeta %s %.1f millones de KM *********** %n",
                                planetas[opcionSalvavidasPlaneta - 1],
                                distancia);
                System.out.printf("%n *********** Tiempo del viaje con la nave %s es de %.1f años *********** %n",
                                naves[opcionSalvavidasNave - 1],
                                timeYear);

                // Limpiar consola despues de una espera de 20 segundos
                System.out.printf(
                                "%n%n ****** Lee la informació y presiona enter para continuar ****** %n%n");
                                scanner.nextLine();
                limpiarConsola();

                // 3. GESTIONAR RECURSOS DE LA NAVE
                System.out.printf(
                                "%n====================================================================================================%n");
                System.out.printf(
                                "%n%n **** A CONTINUACIÓN VERAS LOS RECURSOS NECESARIOS QUE NECESITAS PARA ESTA AVENTURA ESPACIAL! **** %n%n");

                // conversion de años a horas
                var horasTotales = timeYear * 365 * 24;

                // Recursos de combustible
                double recursoCombustiblePorHora = combustiblesPorDia[opcionSalvavidasNave - 1] / 24;
                double calculoCombustibleRequerido = recursoCombustiblePorHora * horasTotales;

                // recursos de oxigeno
                double recursoOxigenoPorDia = oxigenoNavePorDia[opcionSalvavidasNave - 1];
                double calculoOxigenoRequerido = recursoOxigenoPorDia * (timeYear * 365);

                System.out.printf(
                                "********* 1. Para viajar al planeta %s necesitas de combustible %.2f toneladas ********* %n",
                                planetas[opcionSalvavidasPlaneta - 1], calculoCombustibleRequerido);
                System.out.printf(
                                "********* 2. Para viajar al planeta %s necesitas una cantidad de oxigeno de %.2f KG ********* %n",
                                planetas[opcionSalvavidasPlaneta - 1],
                                calculoOxigenoRequerido);

                System.out.printf(
                                "%n%n ****** EMPEZAREMOS EL DESPEGUE ****** %n%n");

                System.out.printf("%n %s! VE PREPARANDOTE PARA EL VIAJE AL ESPACIO! %n%n", nombre.toUpperCase());
                System.out.printf("%n ======================================================== %n");
                System.out.println("Presiona enter para continuar");
                scanner.nextLine();
                limpiarConsola();

                for (int i = 1; i <= 1; i++) {
                        limpiarConsola();
                        System.out.println("=================================================================");
                        System.out.printf("%n%n ABROCHA TU CINTURON ESTAMOS APUNTO DE DESPEGAR %n%n");
                        System.out.println("=================================================================");
                        Thread.sleep(5000);
                }

                // Cuenta regresiva
                for (int i = 5; i > 0; i--) {
                        limpiarConsola();
                        System.out.printf("%n%n===========================%n");
                        System.out.printf(" DESPEGUE EN: %d%n", i);
                        System.out.printf("===========================%n");
                        Thread.sleep(1000);
                }

                // Despegue
                limpiarConsola();
                System.out.printf("%n%n===========================%n");
                System.out.println("        ¡DESPEGUE!        ");
                System.out.printf("===========================%n");

                Thread.sleep(1000);
                simularDespegue();

                System.out.printf(
                                "%n%n Felicitaciones %s el despegue fue exitoso, la nave opera al 100%%, en caso de algun contratiempo te informaremos %n%n ",
                                nombre);

                // 4. EVENTOS ALEATORIOS
                int eventoIndex = aleatorio.nextInt(eventosAleatorios.length);
                var evento = eventosAleatorios[eventoIndex];

                System.out.printf(
                                "%n%n ================================================================================ %n");
                System.err.printf("%n%n ⚠️  Atención %s, %s ⚠️  ", nombre, evento);
                System.out.printf(
                                "%n%n ================================================================================ %n%n");

                String[] opcionSoluciones = solucionEventos[eventoIndex];

                System.out.printf("%n%n =================================================================== %n%n");
                System.out.printf("%nQUE SOLUCIÓN LE VAS A DAR A LA NAVE, ELIGE UNA OPCIÓN: %n");
                for (int i = 0; i < opcionSoluciones.length; i++) {
                        System.out.printf("%nSolución %d: %s", (i + 1), opcionSoluciones[i]);
                }
                System.out.printf("%n%n =================================================================== %n%n");

                var opcionSalvavidas = 0;
                while (opcionSalvavidas < 1 || opcionSalvavidas > opcionSoluciones.length) {
                        System.out.printf("%n%nQue solución vas elegir -> ");
                        opcionSalvavidas = scanner.nextInt();
                }

                System.out.printf("%n%n ========================================================= %n%n");
                switch (eventoIndex) {
                        case 0: // Fuga de oxígeno
                                if (opcionSalvavidas == 1) {
                                        System.out.println(
                                                        "🛠️ Has sellado la fuga manualmente. ¡La tripulación está a salvo! 👍 ✅");
                                } else if (opcionSalvavidas == 2) {
                                        System.out.println(
                                                        "🚨 Has activado el sistema de emergencia, pero la fuga persiste. ¡Cuidado! ⚠️");
                                } else {
                                        System.out.println(
                                                        "💀 Has ignorado la alerta. ¡La nave  quedó sin oxígeno! ❌");
                                }
                                break;

                        case 1: // Fallo en el motor
                                if (opcionSalvavidas == 1) {
                                        System.out.println(
                                                        "🔧 Reiniciar el motor funcionó. ¡La nave sigue su curso! 👍 ✅");
                                } else if (opcionSalvavidas == 2) {
                                        System.out.println(
                                                        "⚡ El motor de respaldo está funcionando, pero con potencia limitada. ⚠️");
                                } else {
                                        System.out.println(
                                                        "🐢 Reducir la velocidad causó que el viaje sea más largo. ❌");
                                }
                                break;

                        case 2: // Sistemas de navegación
                                if (opcionSalvavidas == 1) {
                                        System.out.println(
                                                        "🛰️ Los sistemas de navegación han sido reparados. ¡Buen trabajo! 👍 ✅");
                                } else if (opcionSalvavidas == 2) {
                                        System.out.println(
                                                        "🕹️ El control manual está funcionando, pero requiere más atención. ⚠️");
                                } else {
                                        System.out.println(
                                                        "❌ Reiniciar los sistemas no solucionó el problema. ¡La nave está a la deriva! ❌");
                                }
                                break;

                        case 3: // Meteorito
                                if (opcionSalvavidas == 1) {
                                        System.out.println(
                                                        "🛡️ Has desviado la trayectoria justo a tiempo. ¡Impacto evitado! 👍 ✅");
                                } else if (opcionSalvavidas == 2) {
                                        System.out.println(
                                                        "🚀 Has aumentado la velocidad y esquivado el meteorito. ¡Bien hecho! ⚠️");
                                } else {
                                        System.out.println(
                                                        "💥 El escudo no era lo suficientemente fuerte. La nave ha sido dañada. ❌");
                                }
                                break;

                        default:
                                System.out.println("❓ Caso desconocido");
                                break;
                }
                System.out.printf("%n ========================================================= %n%n");

                System.out.println("Felicitaciones, has terminado el viaje con éxito, a continuación vitacora del viaje:");
                System.out.printf("%n combustible consumido %s %n oxigeno consumido %s %n Distancia recorrida %s %n Tiempo de viaje %s %n", calculoCombustibleRequerido, calculoOxigenoRequerido, distancia, timeYear);
                System.out.printf("%n %s aunque el viaje tuvo inconvenientes nunca perdiste la calma y siempre tomaste la mejor decisión, felicitaciones por tu destresa, gracias por volar con nosotros, hasta un proximo viaje.", nombre);

            




                scanner.close();
        }

        // METODO PARA CONVERTIR LA PRIMERA LETRA EN MAYUSCULA
        public static String capitalizeFirstLetter(String str) {
                if (str == null || str.isEmpty()) {
                        return str;
                }
                return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
        }

        // metodo para limpiar consola
        public static void limpiarConsola() {
                for (int i = 0; i < 100; i++) {
                        System.out.println();
                }
        }

        public static void simularDespegue() throws InterruptedException {
                // Dibujo ASCII de la nave
                String nave = "     /\\  \n" +
                                "    /  \\ \n" +
                                "   /    \\ \n" +
                                "  |      |\n" +
                                "  |  FJ  |\n" +
                                "  |______|\n" +
                                "   |    |\n" +
                                "  /| || |\\ \n" +
                                " //||||||\\\\\n" +
                                "    ||||\n";

                // Simulación del despegue
                int frameTotal = 5;
                limpiarConsola();
                // espacios en blanco para mover la nave hacia arriba
                for (int j = 0; j < frameTotal; j++) {
                        System.out.println();
                        System.out.println(nave);
                        Thread.sleep(500);
                }
        }
}
