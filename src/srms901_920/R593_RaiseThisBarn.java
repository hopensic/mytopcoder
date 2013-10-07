package srms901_920;

public class R593_RaiseThisBarn {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "cc..c..c";
		int c = calc(str);
		System.out.println(c);

	}

	public static int calc(String str) {
		char[] arr = str.toCharArray();
		int len = arr.length;
		int num = 0;
		int n = 0;
		int i;
		int result = 1;
		for (i = 0; i < len; i++)
			if (arr[i] == 'c')
				num++;
		if (num == 0)
			return len - 1;
		if (num % 2 > 0)
			return 0;
		num = num / 2;
		int j = 0;
		while (n < num) {
			if (arr[j] == 'c') {
				n++;
			}
			j++;
		}

		while (arr[j] != 'c') {
			result++;
			j++;
		}

		return result;
	}
}
