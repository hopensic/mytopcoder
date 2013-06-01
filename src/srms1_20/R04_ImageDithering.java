package srms1_20;

public class R04_ImageDithering {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String array[] = {
				"ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWX",
				"ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWX",
				"ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWX",
				"ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWX",
				"ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWX",
				"ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWX" };
		count("ACEGIKMOQSUWY", array);

	}

	public static int count(String dithered, String[] screen) {
		int num = 0;
		int ditheredArrayLenth = dithered.length();
		int scrLen = 0;
		String scr = null;
		int c[] = new int[26];
		char ch;
		char ditheredArray[] = dithered.toCharArray();
		int len = screen.length;
		for (int i = 0; i < len; i++) {
			scr = screen[i];
			scrLen = scr.length();
			for (int j = 0; j < scrLen; j++) {
				ch = scr.charAt(j);
				c[ch - 65]++;
			}
		}

		for (int i = 0; i < ditheredArrayLenth; i++)
			num += c[ditheredArray[i] - 65];

		System.out.println(num);
		return num;

	}
}
