package srms1_20;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class R01_BinaryCode {
	private static long[][] ttarray = new long[9][101];
	private static long[][] tfarray = new long[9][101];

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String a[] = { "EDIILRNBDEXKFQKQZFG ISAJ NWYUILYFX  RQJ: 32 1 T F",
				"TE: 42 3 T F", "JQVODZ: 83 4 F T",
				"VABK MEOMS PEXZ ANPRHQUU: 52 1 T F",
				"UXXRYY IMMNJBTIU KAABB ESW: 80 7 F F",
				"H FI YJXAYLWRTCJT  SRVHSJYE: 16 4 F T",
				"OTYMVKFEDSXNHI: 63 7 T T",
				"QR  MSWFADV NQTTFNBHQGI: 19 3 F F",
				"QDGKLAMFGFHAMSQPQCRY: 24 7 F F",
				"EAGLNRN ZDQTT DHTWT ZDWVRBO: 21 8 F F",
				"BLMQZJHZZLMD IGOWZAD: 84 2 T F",
				"ZGHBSKWI L KNEHXKNQCEMS: 56 4 F T", "YAN X NB: 14 5 F T",
				"R   XQBTNVSYMJC PHKJQIYROZASEJOATSFH: 14 7 T T",
				"QSXAXHCMTUQ Q S BJ: 94 8 F F",
				"TMZ JI GHEFQMCWSGBLC: 20 1 T F",
				"R J E  BYVK RIE  JKOWTPIQFE ZEXMC QFC: 99 7 T F",
				"ZSP  MAEJZJRB U BJGNWX IWDUHFVLAAESLM: 11 4 T T",
				"ZHQPWIJKGBKQZ: 14 8 F F", "SGTAMPKFE: 32 8 T F",
				"ACBNWMZIHAGJBOQZCMQMIRITJ P: 67 2 T T",
				"NKZ MKPTKPRJVCMPDUGGFCAATNVTWBLEOP T: 84 5 F T",
				"EOBXBCLQSYQDVWYNXNGBDXL: 35 1 T F",
				"DAUEZQIFUHMY L NZFDO WZM: 39 8 F F",
				"AWYXTHHFMNEYZNMIL PL: 13 3 T F",
				"BC YPIGGXUPIVIUL EOBO: 33 4 F F", "AYFSX: 56 8 T T",
				"CHXEWBAYSP: 97 4 T F", "GUPMLCVYKOOVRQNF: 94 3 T T",
				"GGJVQB LSH  W: 90 8 F F", "JR BCGFFPI: 41 4 F T",
				"ZDZDKTYFWJESLEB BYDRVLI: 51 4 T T",
				"VLJHGUYGEEUVA ZO LFNTVXUQ UKYAOTMQDCAX: 44 1 F F",
				"LTFFJBFTLOEDEQPKMZA LUWJ: 82 8 T F",
				"YIVR R K  LDAYRCOJRJJ: 58 3 F F",
				"WGVSXCEEBCM MYUYYKCRX LS HNV: 53 1 T T",
				"INIOQXI  LHTIS L: 14 1 F T", "LBXAI: 44 3 T T",
				"JYWFMUBTXBJYBYHSRPICUSSAJAUQU TGGN DWMV: 10 6 F F",
				"TPYOAHPVTWFWGN: 37 4 T T",
				"WKVPBJZ  XAU SWSBXJHVXT OA JYJTXNPF PDQ: 86 8 F T",
				"PI DEJS SZMIUKJSXQUIK: 21 2 F F",
				"UJZU PJRNFBUARAVKJYEIVNUQPVTVL NXGLM: 92 6 T F",
				"JM: 29 4 T F", "BOW OXZSNQIYYJZAZI P: 51 2 T F",
				"KIGJUU: 16 6 F F", "AMILPCBM VCEDMXYL: 50 1 F F",
				"WZIFQGGDZTKIHGUCJUHGFADMKVHYMVCVSZ: 84 1 T F",
				"CSJHWDHYPBK JFGHUEPVMPJRLBRPMESD: 65 1 T F",
				"SZJJP PSGSUKFVHTPMFYIDLUNBLCAW CJ: 93 1 T T" };

		String result[] = sortByOdds(a);
		for (String c : result)
			System.out.print(c + ",");

	}

	public static String[] sortByOdds(String[] rules) {
		int len = rules.length;
		if (len == 0)
			return new String[0];
		ArrayList<String> list = new ArrayList<String>();
		String result[] = new String[len];

		for (int i = 0; i < len; i++) {
			long sum = 0L;
			String t[] = rules[i].split(":");
			String name = t[0];
			String rule = t[1];
			if (len == 1) {
				result[0] = name;
				return result;
			}
			String[] flags = rule.trim().split(" ");
			int max = Integer.parseInt(flags[0]);
			int tempmax = max;
			int num = Integer.parseInt(flags[1]);
			boolean isSorted = flags[2].equals("T") ? true : false;
			boolean isUnique = flags[3].equals("T") ? true : false;
			long ff = 0;
			long tt = 0;
			long ft = tempmax;
			long tf = 0;
			ff = (long) Math.pow(max, num);
			for (int j = 1; j < num; j++)
				ft *= --tempmax;
			tt = getTt(num, max);
			tf = getTf(num, max);

			if (num == 1)
				sum = max;
			else
				for (int k = 0; k < num; k++) {
					if (!isSorted && !isUnique)
						sum = ff;
					else if (!isSorted && isUnique)
						sum = ft;
					else if (isSorted && !isUnique)
						sum = tf;
					else
						sum = tt;
				}

			list.add(sum + "-" + name);
			for (int x = 0; x < 9; x++)
				for (int y = 0; y < 101; y++) {
					ttarray[x][y] = 0;
					tfarray[x][y] = 0;
				}
		}

		Collections.sort(list, new Comparator<String>() {
			public int compare(String s1, String s2) {
				String array1[] = s1.split("-");
				String array2[] = s2.split("-");
				long v1, v3;
				String v2, v4;
				v1 = Long.parseLong(array1[0]);
				v2 = array1[1];
				v3 = Long.parseLong(array2[0]);
				v4 = array2[1];
				if (v1 > v3)
					return 1;
				else if (v1 < v3)
					return -1;
				else {
					if (v2.compareTo(v4) > 1)
						return 1;
					else
						return -1;
				}
			}
		});

		for (int i = 0; i < len; i++)
			result[i] = list.get(i).split("-")[1];
		return result;

	}

	private static long getTt(int digit, int n) {
		if (digit < 0)
			return 0;
		long t = ttarray[digit][n];
		if (t != 0)
			return t;
		long tt = 0L;
		if (digit == 2) {
			if (n == 0 || n == 1)
				return 0;
			else
				return n * (n - 1) / 2;
		} else {
			for (int i = 1; i <= n; i++)
				tt += getTt(digit - 1, n - i);
		}
		ttarray[digit][n] = tt;
		return tt;
	}

	private static long getTf(int digit, int n) {
		if (digit < 0)
			return 0;
		long t = tfarray[digit][n];
		if (t != 0)
			return t;
		long tf = 0L;
		if (digit == 2) {
			return n * (n + 1) / 2;
		} else {
			for (int i = 1; i <= n; i++)
				tf += getTf(digit - 1, n - i + 1);
		}
		tfarray[digit][n] = tf;
		return tf;
	}

}
