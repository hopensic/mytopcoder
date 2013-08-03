package srms21_40;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class R26_DiskSpace {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int used[] = { 750, 800, 850, 900, 950 };
		int total[] = { 800, 850, 900, 950, 1000 };
		int num = minDrives(used, total);
		System.out.println(num);

	}

	public static int minDrives(int[] used, int[] total) {
		int sum_used = 0;
		int sum_disk = 0;
		int len = used.length;
		for (int t : used)
			sum_used += t;
		Integer intBig[] = new Integer[len];
		for (int i = 0; i < len; i++)
			intBig[i] = total[i];
		Arrays.sort(intBig, new IntCompare());
		while (sum_used > 0) {
			sum_used -= intBig[sum_disk++];
		}
		return sum_disk;
	}

	static class IntCompare implements Comparator<Integer> {
		public IntCompare() {

		}

		public int compare(Integer o1, Integer o2) {
			return o2.compareTo(o1);
		}

	}
}
