package srms1_20;

public class R06_YahtzeeScore {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a[] = { 2, 2, 3, 5, 4 };
		int s = maxPoints(a);
		System.out.println(s);
	}

	public static int maxPoints(int[] toss) {
		int len = toss.length;
		int t[] = new int[7];
		int max = 0;
		for (int i = 0; i < len; i++)
			t[toss[i]] += toss[i];
		for (int i = 1; i <= 6; i++)
			if (t[i] > max)
				max = t[i];
		return max;

	}

}
