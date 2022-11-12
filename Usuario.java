
public class Usuario {

	private String nombre;
	private String DNI;
	private int edad;

	public Usuario() {

	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getDNI() {
		return DNI;
	}

	public boolean setDNI(String DNI) {
		boolean isDNI = false;
		if (DNI.length() == 9) {
			if (DNI.substring(0, 8).matches("[0-9]+")) {
				if (DNI.substring(8).matches("[A-Z]")) {
					isDNI = true;
					this.DNI = DNI;
				}
			}
		} else if (DNI.length() == 10) {
			if (DNI.substring(0, 8).matches("[0-9]+")) {
				if ((DNI.substring(8, 9).equals("-")) && (DNI.substring(9).matches("[A-Z]"))) {
					isDNI = true;
					this.DNI = DNI;
				}
			}

		}
		return isDNI;

	}
	@Override
	 public String toString() {
		 return ("Usuario: " + this.nombre + ", DNI: " + this.DNI + ", Edad: " + this.edad);
	 }
}
