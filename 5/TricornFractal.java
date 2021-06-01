import java.awt.geom.Rectangle2D;
public class TricornFractal extends FractalGenerator {
	public static final int MAX_ITERATIONS = 2000;
	@Override
	public void getInitialRange(Rectangle2D.Double range) {
	     range.width = 3;
	     range.height = 3;
	     range.y = -1.5;
	     range.x = -2;
	}
	@Override
	public int numIterations(double x, double y) {
		int countIterations=0;
		ComplexNumber complexNumber= new ComplexNumber(0,0);
		ComplexNumber complexNumberBefore;
		ComplexNumber complexNumberConst= new ComplexNumber(x,y);
		while(complexNumber.lenPow2()<4) {
			if(countIterations++==MAX_ITERATIONS) return -1;
			complexNumberBefore=(complexNumber.multiply(complexNumber)).sum(complexNumberConst);
			complexNumber=complexNumberBefore.sum(new ComplexNumber(0,0));
		}
		return countIterations;
	}
}
