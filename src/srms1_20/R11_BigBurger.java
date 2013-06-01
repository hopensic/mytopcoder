package srms1_20;

public class R11_BigBurger {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// int arrvials[] = { 3, 3, 9 };
		// int services[] = { 2, 15, 14 };
		int arrvials[] = { 2, 10, 12 };
		int services[] = { 15, 1, 15 };
		int maxTime = maxWait(arrvials, services);
		System.out.println(maxTime);
	}

	public static int maxWait(int[] arrival, int[] service) {
		int max = 0;
		int customLen = arrival.length;
		int waiTimes[] = new int[customLen];
		if (customLen == 1)
			return 0;
		int i = 0;
		int j = -1;
		while (true) {
			if (i == customLen)
				break;
			if (i == 0) {
				waiTimes[i] = 0;
			} else if (i > 0) {
				if (waiTimes[i - 1] + arrival[i - 1] + service[j] <= arrival[i])
					waiTimes[i] = 0;
				else {
					waiTimes[i] = waiTimes[i - 1] + arrival[i - 1] + service[j]
							- arrival[i];
				}
			}
			i++;
			j++;
		}
		for (int c : waiTimes)
			if (c > max)
				max = c;

		return max;

	}
}
