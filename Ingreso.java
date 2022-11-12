import java.text.NumberFormat;
import java.util.Locale;

public class Ingreso extends Dinero {

	public Ingreso(double ingreso, String description) {

		this.description = description;
		this.dinero = ingreso;

	}

	@Override
	public String toString() {
		Locale spain = new Locale("es", "ES");
		String sCantidad = NumberFormat.getInstance(spain).format(this.dinero);
		String string = ("Ingreso: " + this.description + ", cantidad: " + sCantidad + "€");
		return (string);
		
	}
}
