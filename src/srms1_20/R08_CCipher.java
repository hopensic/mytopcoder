package srms1_20;

public class R08_CCipher {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s = "LIPPSASVPH";
		// QRSTUVWXYZABCDEFGHIJKLMNOP
		int n = 4;
		String t = decode(s, n);
		System.out.println(t);

	}

	public static String decode(String cipherText, int shift) {
		int len = cipherText.length();

		if (len == 0)
			return "";
		StringBuilder sb = new StringBuilder();
		char array[] = cipherText.toCharArray();
		for (int i = 0; i < len; i++) {
			int a = array[i] - shift;
			int b = a + 26;
			array[i] = array[i] - 'A' >= shift ? (char) a : (char) b;
			sb.append(array[i]);
		}
		return sb.toString();

	}
}
