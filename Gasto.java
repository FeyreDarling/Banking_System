import java.text.NumberFormat;
import java.util.Locale;

public class Gasto extends Dinero {

	public Gasto(double gasto, String description) {

		this.description = description;
		this.dinero = gasto;
	}

	@Override
	public String toString(){
		Locale spain = new Locale("es", "ES");
		String sCantidad = NumberFormat.getInstance(spain).format(this.dinero);
		String string = ("Gasto: " + this.description + ", cantidad: " + sCantidad + "€");
		return (string);
		
	}

}
