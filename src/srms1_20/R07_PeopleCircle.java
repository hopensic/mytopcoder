package srms1_20;

public class R07_PeopleCircle {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s = order(0, 2, 1000);
		System.out.println(s);

	}

	public static String order(int numMales, int numFemales, int K) {
		int sum = numMales + numFemales;
		int step = K;
		int arrays[] = new int[sum];
		int i = 0;
		if (numMales + numFemales == 0) {
			return "";
		}
		while (true) {
			if (numFemales == 0) {
				break;
			}
			if (i == sum)
				i = 0;
			if (step == 1) {
				if (arrays[i] == 0) {
					if (numFemales == 0) {
						break;
					}
					arrays[i] = 1;
					step = K;
					numFemales--;
				}
			} else {
				if (arrays[i] == 0)
					step--;
			}
			i++;
		}
		StringBuilder sb = new StringBuilder();
		for (int k = 0; k < sum; k++)
			sb.append(arrays[k] == 0 ? "M" : "F");
		return sb.toString();

	}
}
