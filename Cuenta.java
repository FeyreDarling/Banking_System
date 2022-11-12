import java.util.ArrayList;
import java.util.List;

public class Cuenta {

	private double saldo;
	private Usuario usuario;
	private List<Gasto> gastos = new ArrayList<Gasto>();
	private List<Ingreso> ingresos = new ArrayList <Ingreso>();

	public Cuenta(Usuario usuario) {
		this.usuario = usuario;
		this.saldo = 0;
	}

	public double getSaldo() {
		return this.saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public double addIngreso(String description, double cantidad) {
		Ingreso ingreso = new Ingreso(cantidad, description);
		this.saldo = this.saldo + cantidad;
		this.ingresos.add(ingreso);
		return this.saldo;
	}

	public double addGasto(String description, double cantidad) throws GastoException {
		Gasto gasto = new Gasto(cantidad, description);
		if (cantidad < this.saldo) {
			this.saldo = this.saldo - cantidad;
			this.gastos.add(gasto);
		} else {
			throw new GastoException();
		}

		return this.saldo;
	}

	public List<Gasto> getGastos() {
		return this.gastos;
	}

	

	public List<Ingreso> getIngresos() {
		return this.ingresos;
	}

	@Override
	public String toString() {
		return ("Usuario: " + this.usuario.toString() + ", Saldo: " + this.saldo);
	}
}
