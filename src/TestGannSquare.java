import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 
 */

/**
 * @author Shaurya
 *
 */
public class TestGannSquare {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Double> levels = new ArrayList<>();
		double[][] gannSq = new double[9][9];
		double ltp = 120	;
		int multiplyingFactor = 1;
		if (ltp / 10 < 10) {
			multiplyingFactor = 100;
		}
		int[] baseNum = new int[4];
		double meanLtp = Math.sqrt(ltp * multiplyingFactor);
		baseNum[0] = ((int) meanLtp) - 1;
		baseNum[1] = ((int) meanLtp);
		baseNum[2] = ((int) meanLtp) + 1;
		baseNum[3] = ((int) meanLtp) + 2;

		int i = 4, j = 4;
		gannSq[i][j] = (double) Math.pow(baseNum[0], 2) / multiplyingFactor;
		for (int k = 0; k < baseNum.length; k++) {
			double base = baseNum[k];
			base += 0.125;
			gannSq[i - (k + 1)][j] = (double) Math.pow(base, 2) / multiplyingFactor;
			base += 0.125;
			gannSq[i - (k + 1)][j - (k + 1)] = (double) Math.pow(base, 2) / multiplyingFactor;
			base += 0.125;
			gannSq[i][j - (k + 1)] = (double) Math.pow(base, 2) / multiplyingFactor;
			base += 0.125;
			gannSq[i + (k + 1)][j - (k + 1)] = (double) Math.pow(base, 2) / multiplyingFactor;
			base += 0.125;
			gannSq[i + (k + 1)][j] = (double) Math.pow(base, 2) / multiplyingFactor;
			base += 0.125;
			gannSq[i + (k + 1)][j + (k + 1)] = (double) Math.pow(base, 2) / multiplyingFactor;
			base += 0.125;
			gannSq[i][j + (k + 1)] = (double) Math.pow(base, 2) / multiplyingFactor;
			base += 0.125;
			gannSq[i - (k + 1)][j + (k + 1)] = (double) Math.pow(base, 2) / multiplyingFactor;
		}

		for (int k = 0; k < baseNum.length; k++) {
			levels.add(gannSq[i - (k + 1)][j]);
			levels.add(gannSq[i - (k + 1)][j - (k + 1)]);
			levels.add(gannSq[i][j - (k + 1)]);
			levels.add(gannSq[i + (k + 1)][j - (k + 1)]);
			levels.add(gannSq[i + (k + 1)][j]);
			levels.add(gannSq[i + (k + 1)][j + (k + 1)]);
			levels.add(gannSq[i][j + (k + 1)]);
			levels.add(gannSq[i - (k + 1)][j + (k + 1)]);
		}

		levels.add(ltp);

		Collections.sort(levels);

		for (Double d : levels) {
			if (d > ltp) {
				System.out.println("Resitance : " + d);
			} else if (d < ltp) {
				System.out.println("Support :" + d);
			}else{
				System.out.println("ltp : "+d);
			}
		}

	}

}
