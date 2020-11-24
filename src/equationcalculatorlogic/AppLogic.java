package equationcalculatorlogic;

public class AppLogic {

	// coefficients
	private double a = 0;
	private double b = 0;
	private double c = 0;

	// quadratic equation solutions
	private double firstSolution = 0;
	private double secondSolution = 0;

	// linear equation solution
	private double linearSolution = 0;
	
	// to prevent square rooting negative numbers
	private boolean isSqrtPossible = false;

	// for solving quadratic equations
	public AppLogic(double a, double b, double c) {

		this.a = a;
		this.b = b;
		this.c = c;
		
	}

	// for solving linear equations
	public AppLogic(double b, double c) {
		
		this.a = 0;
		this.b = b;
		this.c = c;

	}

	public void setFirstSolution() {
		this.firstSolution = ((-1) * this.b + Math.sqrt(Math.pow(this.b, 2) - (4 * this.a * this.c))) / (2 * this.a);
	}

	public void setSecondSolution() {
		this.secondSolution = ((-1) * this.b - Math.sqrt(Math.pow(this.b, 2) - (4 * this.a * this.c))) / (2 * this.a);
	}

	public void setLinearSolution() {
		this.linearSolution = (-1) * (this.c / this.b);
	}

	public boolean isSqrtPossible() {
		
		double sqrt = Math.pow(this.b, 2) - (4 * this.a * this.c);
			
		if(sqrt < 0) {
			this.isSqrtPossible = false;
		}else {
			this.isSqrtPossible = true;
		}
		
		return isSqrtPossible;
	}

	@Override
	public String toString() {
		
		if(this.a == 0) {
			
			return "x = " + this.linearSolution;
			
		}
		
		return "x = " + String.format("%.2f", this.firstSolution) + ", x = " + String.format("%.2f", this.secondSolution);

	}

}
