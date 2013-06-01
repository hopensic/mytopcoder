package srms1_20;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class R03_Bonuses {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int s[] = { 485, 324, 263, 143, 470, 292, 304, 188, 100, 254, 296, 255,
				360, 231, 311, 275, 93, 463, 115, 366, 197, 470 };
		int r[] = getDivision(s);
		for (int i = 0; i < r.length; i++)
			System.out.print(r[i] + ",");

	}

	public static int[] getDivision(int[] points) {

		TreeMap<String, Integer> map = new TreeMap<String, Integer>(
				new Comparator<String>() {
					public int compare(String s1, String s2) {
						String array1[] = s1.split("-");
						String array2[] = s2.split("-");
						int v1, v2, v3, v4;
						v1 = Integer.parseInt(array1[0]);
						v2 = Integer.parseInt(array1[1]);
						v3 = Integer.parseInt(array2[0]);
						v4 = Integer.parseInt(array2[1]);
						if (v1 > v3)
							return -1;
						else if (v1 < v3)
							return 1;
						else {
							if (v2 > v4)
								return 1;
							else
								return -1;
						}
					}
				});
		int sum = 0;
		int len = points.length;
		int num = 100;
		int r[] = new int[len];
		for (int i = 0; i < len; i++)
			sum += points[i];
		for (int i = 0; i < len; i++) {
			r[i] = points[i] * 100 / sum;
			num -= r[i];
			map.put(points[i] + "-" + i, i);
		}
		if (num > 0) {
			int index = -1;
			Iterator titer = map.entrySet().iterator();
			while (titer.hasNext()) {
				if (num < 1) {
					break;
				}
				Map.Entry ent = (Map.Entry) titer.next();
				String keyt = ent.getKey().toString();
				String valuet = ent.getValue().toString();
				index = Integer.parseInt(valuet);
				r[index]++;
				num--;

			}
		}
		return r;
	}
}
