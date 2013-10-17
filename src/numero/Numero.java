package numero;

public class Numero {
	protected double parteReal;

	public Numero() {
		parteReal = 0.0;
	}

	public Numero(double parteReal) {
		this.parteReal = parteReal;
	}

	public String toString() {
		return " " + parteReal;
	}

	public void setParteReal(double parteReal) {
		this.parteReal = parteReal;
	}

	public double getParteReal() {
		return parteReal;
	}
}
