package srms21_40;

import java.util.ArrayList;

public class R23_PaternityTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String child = "WXETPYCHUWSQEMKKYNVP";
		String mother = "AXQTUQVAUOSQEEKCYNVP";
		String men[] = { "WNELPYCHXWXPCMNKDDXD", "WFEEPYCHFWDNPMKKALIW",
				"WSEFPYCHEWEFGMPKIQCK", "WAEXPYCHAWEQXMSKYARN",
				"WKEXPYCHYWLLFMGKKFBB" };
		int n[] = possibleFathers(child, mother, men);
		for (int i = 0; i < n.length; i++)
			System.out.print(n[i] + ",");

	}

	public static int[] possibleFathers(String child, String mother,
			String[] men) {
		int len = mother.length();
		int len_half = len / 2;
		int len_men = men.length;
		String man;

		ArrayList<Integer> notEqualList = new ArrayList<Integer>();
		ArrayList<Integer> resultIndexList = new ArrayList<Integer>();
		ArrayList<Integer> tmpList = new ArrayList<Integer>();
		for (int i = 0; i < len; i++)
			tmpList.add(i);

		char m_array[] = mother.toCharArray();
		char c_array[] = child.toCharArray();
		char man_array[];
		char mother_array[][] = new char[len][2];
		for (int i = 0; i < len; i++) {
			mother_array[i][0] = m_array[i];
			mother_array[i][1] = 'n';
			if (m_array[i] == c_array[i]) {
				mother_array[i][1] = 'y';
			} else {
				notEqualList.add(i);
			}
		}
		tmpList.removeAll(notEqualList);

		int len_notEqual = notEqualList.size();
		int left = len_half - len_notEqual;

		for (int i = 0; i < len_men; i++) {
			boolean isFather = true;
			man = men[i];
			man_array = man.toCharArray();
			for (int j = 0; j < len_notEqual; j++) {
				int k = notEqualList.get(j);
				if (c_array[k] != man_array[k]) {
					isFather = false;
					break;
				}
			}
			if (!isFather)
				continue;
			int z = 0;
			for (int p = 0; p < len; p++) {
				if (z == left)
					break;
				if (notEqualList.contains(p))
					continue;
				if (c_array[p] == man_array[p]) {
					z++;
				}
			}
			if (z == left)
				resultIndexList.add(i);
		}

		int num = resultIndexList.size();
		if (num == 0)
			return new int[0];
		int arr[] = new int[num];
		for (int i = 0; i < num; i++)
			arr[i] = resultIndexList.get(i);
		return arr;

	}

}
