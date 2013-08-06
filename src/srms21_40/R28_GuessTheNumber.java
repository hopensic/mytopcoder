package srms21_40;

public class R28_GuessTheNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int upper = 128;
		int answer = 64;
		int x = noGuesses(upper, answer);
		System.out.println(x);
	}

	public static int noGuesses(int upper, int answer) {
		int num = 1;
		int lower = 1;
		int mid = 0;

		while (lower <= upper) {
			mid = (upper + lower) / 2;
			if (answer == mid)
				return num;
			num++;
			if (mid < answer) {
				lower = mid + 1;
			} else
				upper = mid - 1;
		}
		return num;
	}

}
