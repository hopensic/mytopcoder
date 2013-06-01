package srms1_20;

import java.util.ArrayList;

public class R17_LeaguePicks {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int pos = 1;
		int friends = 1;
		int picks = 5;
		int a[] = returnPicks(pos, friends, picks);
		for (int c : a)
			System.out.println(c);

	}

	public static int[] returnPicks(int position, int friends, int picks) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		int n = 1;
		int curPos = 1;
		int direction = 1;
		if (friends == 1) {
			int a[] = new int[picks];
			for (int i = 0; i < picks; i++)
				a[i] = i + 1;
			return a;
		}

		while (true) {
			if (n > picks)
				break;
			if (curPos == position)
				list.add(n);
			n++;
			if (direction == 1) {
				curPos++;
				if (curPos == friends)
					direction = 0;
			} else if (direction == 0) {
				if (curPos == friends)
					direction = -1;
				else
					direction = 1;
			} else {
				curPos--;
				if (curPos == 1)
					direction = 0;

			}
		}
		int len = list.size();
		int t[] = new int[len];
		for (int i = 0; i < list.size(); i++)
			t[i] = list.get(i);
		return t;
	}

}
