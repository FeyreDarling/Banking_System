import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws GastoException {

		Usuario user = new Usuario();
		Cuenta cuenta = new Cuenta(user);
		Scanner sc = new Scanner(System.in);
		boolean isDNI = false;
		int userOption = 6;
		String userDescription;
		double userCantidad;
		List<Gasto> gastos = new ArrayList<Gasto>();
		List<Ingreso> ingresos = new ArrayList<Ingreso>();

		System.out.println("Introduce el nombre de usuario");
		user.setNombre(sc.nextLine());

		System.out.println("Introduce la edad del usuario");
		user.setEdad(sc.nextInt());

		sc.nextLine();

		System.out.println("Introduce el DNI del usuario");

		while (isDNI == false) {

			isDNI = user.setDNI(sc.nextLine());
			if (isDNI == false) {
				System.out.println("DNI introducido no es correcto");
				System.out.println("Introduce el DNI del usuario válido");
			}
		}

		while (userOption != 0) {
			System.out.println("1 Introduce un nuevo gasto");
			System.out.println("2 Introduce un nuevo ingreso");
			System.out.println("3 Mostrar gastos");
			System.out.println("4 Mostrar ingresos");
			System.out.println("5 Mostrar saldo");
			System.out.println("0 Salir");
			userOption = sc.nextInt();
			sc.nextLine();

			switch (userOption) {

			case 0:
				break;

			case 1:

				System.out.println("Introduce la descripción");
				userDescription = sc.nextLine();
				System.out.println("Introduce la cantidad");
				userCantidad = sc.nextDouble();
				try {
					cuenta.addGasto(userDescription, userCantidad);
				} catch (Exception e) {

				}
				System.out.println("Saldo restante: " + convertToComa(cuenta.getSaldo()) + "€");
				break;
			case 2:

				System.out.println("Introduce la descripción");
				userDescription = sc.nextLine();
				System.out.println("Introduce la cantidad");
				userCantidad = sc.nextDouble();
				sc.nextLine();
				cuenta.addIngreso(userDescription, userCantidad);
				System.out.println("Saldo restante: " + convertToComa(cuenta.getSaldo()) + "€");
				break;
			case 3:

				gastos = cuenta.getGastos();
				for (int i = 0; i < gastos.size(); i++) {
					System.out.println(gastos.get(i));
				}
				break;
			case 4:

				ingresos = cuenta.getIngresos();
				for (int i = 0; i < ingresos.size(); i++) {
					System.out.println(ingresos.get(i));
				}
				break;
			case 5:
				System.out.println("El saldo actual de la cuenta es: " + convertToComa(cuenta.getSaldo()) + "€");
				break;
			default:
				System.out.println("Esta opción no está disponible");

			}
		}
		System.out.println("Fin del programa.");
		System.out.println("Gracias por utilizar la aplicación de M03B en el curso 1s2223.");

	}

	public static String convertToComa(double saldo) {
		Locale spain = new Locale("es", "ES");
		String sSaldo = NumberFormat.getInstance(spain).format(saldo);
		return sSaldo;

	}
}
