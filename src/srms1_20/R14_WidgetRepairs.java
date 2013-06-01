package srms1_20;

public class R14_WidgetRepairs {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int a[] = { 6, 5, 4, 3, 2, 1, 0, 0, 1, 2, 3, 4, 5, 6 };
		int numPerday = 3;
		int r = days(a, numPerday);
		System.out.println(r);

	}

	public static int days(int[] arrivals, int numPerDay) {
		int day = 0;
		int remain = 0;
		int len = arrivals.length;
		int con = 0 - numPerDay;
		for (int i = 0; i < len; i++) {
			remain += arrivals[i] - numPerDay;
			if (remain != con) {
				day++;
				if (remain <= 0)
					remain = 0;
			} else
				remain = 0;
		}
		day += Math.ceil(((double) remain / numPerDay));
		return day;
	}
}
