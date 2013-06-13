package srms21_40;

import java.util.ArrayList;

public class R21_CheatCode {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String t[] = { "LLOLLL", "LOOLLL", "OOLLOL", "LLOLLL", "OOOLLO",
				"OLOLLL", "LLOOOO", "LLOLLL", "LOLOOO", "OLLLLL", "OOOOOO",
				"OOLLLO", "LLOOLO", "OLLLOO", "OLOOLO", "LLLOOO", "LLLLLO",
				"OLOLOL", "LOLLOL", "LLLOOO", "OOOOLL", "OOLOOL", "LOOLOL",
				"LOOLLL", "LLLOOL", "LLOOLL", "OOOOLL", "OOOLOO", "OOLLOL",
				"OLLOOL", "OOLOLL", "OOOLLL", "LOOLLL", "OOOOOL", "LLLLLO",
				"LOLOLL", "OOOOOO", "OLOLLO", "LOLOLO", "OLLLOL", "OOOLLL",
				"LLOLOO", "OLOLLO", "OLLOOL", "OLOOLL", "OLOLLL", "LLLLLO",
				"OLOLLO", "OLOOOL", "OLLLOO" };
		String keyPresses = "LOLOLLLLOOLLOLLLOOLLOLOLOLOOLLOLOOOLLLLOOLOOOOOLLO";
		int a[] = matches(keyPresses, t);

		for (int i = 0; i < a.length; i++)
			System.out.print(a[i] + ",");

	}

	public static int[] matches(String keyPresses, String[] codes) {
		ArrayList<Integer> list = new ArrayList<Integer>();

		int len = codes.length;
		int tLength = keyPresses.length();
		char[] tArray = keyPresses.toCharArray();
		int m = tArray.length;
		if (keyPresses.equals("") || len == 0)
			return new int[0];
		for (int i = 0; i < len; i++) {
			int nextArray[] = next(codes[i]);
			boolean isCheat = false;
			boolean isRepeated = false;
			String p = codes[i];
			char[] pArray = p.toCharArray();
			int len_code = pArray.length;
			if (m < len_code)
				continue;
			int q = 0;

			for (int j = 0; j < tLength; j++) {
				while (q > 0 && tArray[j] != pArray[q]) {
					if (j > 0 && tArray[j] == tArray[j - 1]) {
						isRepeated = true;
						break;
					} else
						isRepeated = false;
					q = nextArray[q - 1];
				}
				if (tArray[j] == pArray[q]) {
					if (isRepeated)
						isRepeated = false;
					q++;
				}

				if (isRepeated)
					continue;

				if (q == len_code) {
					isCheat = true;
					break;
				}
			}
			if (isCheat) {
				list.add(i);
				continue;
			}

		}
		int lenList = list.size();
		if (lenList > 0) {
			int r[] = new int[lenList];
			for (int i = 0; i < lenList; i++)
				r[i] = list.get(i);
			return r;
		} else {
			return new int[0];
		}

	}

	private static int[] next(String s) {
		char arr[] = s.toCharArray();
		int length = arr.length;
		int t[] = new int[length];
		if (length == 0)
			return t;
		t[0] = 0;
		int k = 0;
		for (int q = 1; q < length; q++) {
			while (k > 0 && arr[k] != arr[q])
				k = t[k - 1];
			if (arr[k] == arr[q])
				k++;
			t[q] = k;
		}
		return t;

	}

}
