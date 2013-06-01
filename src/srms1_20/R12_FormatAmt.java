package srms1_20;

public class R12_FormatAmt {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int dollars = 0;
		int cents = 5;

		String str = amount(dollars, cents);
		System.out.println(str);
	}

	public static String amount(int dollars, int cents) {
		int numOfComma = 0;
		String s1 = dollars + "";
		int len1 = s1.length(), lenA = len1;
		String s2 = cents + "";
		int len2 = s2.length();
		boolean canBeDivided = false;
		if (len1 % 3 == 0) {
			canBeDivided = true;
		}
		int l = len1 / 3;
		if (len1 > 3) {
			numOfComma = canBeDivided ? l - 1 : l;
		}
		StringBuilder sb = new StringBuilder();
		sb.append("$");
		if (numOfComma > 0) {
			char a[] = s1.toCharArray();
			char b[] = new char[len1 + numOfComma];
			int temBlen = b.length;
			for (int j = 0, i = temBlen - 1; i >= 0; i--)
				if (j == 3) {
					b[i] = ',';
					j = 0;
				} else {
					b[i] = a[--lenA];
					j++;
				}
			for (int i = 0; i < b.length; i++)
				sb.append(b[i]);
		} else {
			sb.append(s1);
		}

		sb.append(".");
		if (len2 == 2)
			sb.append(s2);
		else
			sb.append("0").append(s2);
		return sb.toString();

	}
}
