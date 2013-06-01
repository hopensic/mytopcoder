package srms1_20;

public class R10_DivisorDigits {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 730000000;
		int n = howMany(num);
		System.out.println(n);

	}

	public static int howMany(int number) {
		int copynum = number;
		int sum = 0;
		int digit;
		int num[] = new int[10];
		while (number > 0) {
			digit = number % 10;
			num[digit]++;
			number = number / 10;
		}
		for (int i = 1; i < 10; i++) {
			if (num[i] > 0)
				if (copynum % i == 0)
					sum += num[i];
		}

		return sum;

	}

}
