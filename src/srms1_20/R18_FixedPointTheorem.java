package srms1_20;

public class R18_FixedPointTheorem {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		double R = 3.00005d;
		double x = cycleRange(R);
		System.out.println(x);

	}

	public static double cycleRange(double R) {
		int n = 0;
		double x = 0.25D;
		while (n < 2000000) {
			x = R * x * (1.0D - x);
			n++;
		}
		double min = 1.0D;
		double max = 0.0D;
		n = 0;
		while (n < 1000) {
			x = R * x * (1.0D - x);
			if (x < min)
				min = x;
			if (x > max)
				max = x;
			n++;
		}

		return max - min;

	}
}
