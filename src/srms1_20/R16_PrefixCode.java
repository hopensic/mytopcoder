package srms1_20;

public class R16_PrefixCode {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s[] = { "Is", "this", "a", "dagger", "which", "I", "see",
				"before", "me" };
		String r = isOne(s);
		System.out.println(r);
	}

	public static String isOne(String[] words) {
		int len = words.length;
		int min = 999;
		if (len == 1)
			return "Yes";

		for (int i = 0; i < len; i++) {
			int j = 0;
			for (; j < len; j++) {
				int n = -1;
				if (i == j)
					continue;
				if ((n = words[i].indexOf(words[j])) == 0) {
					if (j < min)
						min = j;
				}
			}

		}
		if (min == 999)
			return "Yes";
		else
			return "No, " + min;

	}
}
