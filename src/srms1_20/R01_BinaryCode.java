package srms1_20;

public class R01_BinaryCode {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// String s = "123210122";
		String s = "123210122";
		String arr[] = decode(s);
		System.out.print(arr[0] + "," + arr[1]);
	}

	public static String[] decode(String message) {
		boolean flag1 = true;
		boolean flag2 = true;
		String[] s = new String[2];
		int len = message.length();
		int s0[] = new int[len + 2];
		int s1[] = new int[len + 2];
		int t[] = new int[len + 2];
		char charArray[] = message.toCharArray();
		for (int i = 0; i < len; i++)
			t[i + 1] = Integer.parseInt(String.valueOf(charArray[i]));
		t[0] = 0;
		t[len + 1] = 0;
		if (len == 1) {
			if (t[1] == 0) {
				s[0] = "0";
				s[1] = "NONE";
			} else if (t[1] == 1) {
				s[0] = "NONE";
				s[1] = "1";
			} else {
				s[0] = "NONE";
				s[1] = "NONE";
			}
			return s;
		}
		{
			s0[1] = 0;
			s1[1] = 1;
			flag1 = getFlag(s0, t, len);
			flag2 = getFlag(s1, t, len);

			StringBuilder sb1 = new StringBuilder();
			StringBuilder sb2 = new StringBuilder();

			if (flag1) {
				for (int i = 1; i <= len; i++)
					sb1.append(s0[i]);
				s[0] = sb1.toString();
			} else
				s[0] = "NONE";

			if (flag2) {
				for (int i = 1; i <= len; i++)
					sb2.append(s1[i]);
				s[1] = sb2.toString();
			} else {
				s[1] = "NONE";
			}
		}
		return s;
	}

	private static boolean getFlag(int s[], int t[], int len) {
		for (int i = 1; i < len; i++) {
			s[i + 1] = t[i] - s[i] - s[i - 1];
			if (s[i + 1] > 1 || s[i + 1] < 0)
				return false;
		}
		if (s[len - 1] + s[len] != t[len])
			return false;

		return true;
	}
}
