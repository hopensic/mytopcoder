package test;

public class KMP_Next {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String t = "abacabcabcacde";
		String s = "abcac";

		int nextArray[] = next(s);
		for (int c : nextArray)
			System.out.print(c + ",");
		boolean isExistflag = false;
		int i = 0;
		int q = 0;
		char tArray[] = t.toCharArray();
		char sArray[] = s.toCharArray();
		int len = tArray.length;
		int m = s.length();
		if (len > 0) {
			for (; i < len; i++) {
				while (q > 0 && sArray[q] != tArray[i])
					q = nextArray[q - 1];
				if (sArray[q] == tArray[i])
					q++;
				if (q == m) {
					isExistflag = true;
					break;
				}
				// q = nextArray[q - 1];
			}
		}
		System.out.println("index is:" + (i - m + 1));

	}

	public static int[] next(String s) {
		char arr[] = s.toCharArray();
		int length = arr.length;
		int t[] = new int[length];
		if (length == 0)
			return t;
		t[0] = 0;
		int k = 0;
		for (int q = 1; q < length; q++) {
			while (k > 0 && arr[k] != arr[q])
				k = t[k];
			if (arr[k] == arr[q])
				k++;
			t[q] = k;
		}
		return t;

	}
}
