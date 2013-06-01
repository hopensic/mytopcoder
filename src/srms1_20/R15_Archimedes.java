package srms1_20;

public class R15_Archimedes {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int numSides = 17280;

		double x = approximatePi(numSides);
		System.out.println(x);
	}

	public static double approximatePi(int numSides) {
		double x = (double) numSides * Math.sin(Math.PI / numSides);
		return x;
	}

}
