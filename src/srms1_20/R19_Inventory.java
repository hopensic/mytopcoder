package srms1_20;

import java.math.BigDecimal;

public class R19_Inventory {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int sales[] = { 8773 };
		int days[] = { 16 };
		int x = monthlyOrder(sales, days);
		System.out.println(x);
	}

	public static int monthlyOrder(int[] sales, int[] daysAvailable) {
		double sum = 0;
		int minus = 0;
		int len = sales.length;
		for (int i = 0; i < len; i++) {
			if (daysAvailable[i] == 0) {
				minus++;
				continue;
			}
			sum += div(30.0D * sales[i], daysAvailable[i], 5);
		}
		sum = div(sum, len - minus, 5);
		sum = Math.ceil(sum);
		return (int) sum;

	}

	private static double div(double v1, double v2, int scale) {
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
	}

}
