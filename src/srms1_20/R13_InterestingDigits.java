package srms1_20;

import java.util.ArrayList;

public class R13_InterestingDigits {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int base = 26;
		int n[] = digits(base);

		for (int i = 0; i < n.length; i++)
			System.out.println(n[i]);

	}

	public static int[] digits(int base) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		int sum = 0;
		for (int j = 2; j < base; j++) {
			int i = 2;
			for (; i <= 999; i++) {
				sum = j * i;
				if (!isCanDivided(base, j, sum))
					break;
			}
			if (i > 999)
				list.add(j);

		}
		int n = list.size();
		int temp[] = new int[n];
		for (int i = 0; i < n; i++)
			temp[i] = list.get(i);
		return temp;
	}

	private static boolean isCanDivided(int base, int currentnum, int sum) {
		int len = (int) (Math.log(sum) / Math.log(base));
		int transSum = 0;
		int temp = 0;
		int exp = 0;
		for (int i = len; i >= 0; i--) {
			exp = (int) Math.pow(base, i);
			temp = sum / exp;
			transSum += temp;
			sum -= temp * exp;
		}
		if (transSum % currentnum == 0)
			return true;
		else
			return false;
	}
}
