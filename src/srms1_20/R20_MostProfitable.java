package srms1_20;

public class R20_MostProfitable {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static String bestItem(int[] costs, int[] prices, int[] sales,
			String[] items) {
		int len = costs.length;
		int sum = 0;
		int tmp = 0;
		int index = -1;
		for (int i = 0; i < len; i++) {
			if (prices[i] <= costs[i])
				continue;
			else {
				tmp = (sales[i] * (prices[i] - costs[i]));
				if (tmp > sum) {
					sum = tmp;
					index = i;
				}
			}
		}
		if (index == -1)
			return "";
		else
			return items[index];

	}

}
