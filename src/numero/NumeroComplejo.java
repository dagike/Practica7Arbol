package numero;

public class NumeroComplejo extends Numero {
	private double parteImaginaria;

	public NumeroComplejo() {
		super();
		parteImaginaria = 0.0;
	}

	public NumeroComplejo(double parteReal, double parteImaginaria) {
		super(parteReal);
		this.parteImaginaria = parteImaginaria;
	}

	public double getParteImaginaria() {
		return parteImaginaria;
	}

	public void setParteImaginaria(double parteImaginaria) {
		this.parteImaginaria = parteImaginaria;
	}

	public String toString() {
		return "(" + super.toString() + " + " + parteImaginaria + "i )";
	}
	
	public boolean equals(Object nc){
		if(parteImaginaria == ((NumeroComplejo)nc).parteImaginaria && parteReal == ((NumeroComplejo)nc).parteReal)
			return true;
		else
			return false;
	}
}
