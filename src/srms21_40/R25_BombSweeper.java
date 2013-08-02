package srms21_40;

public class R25_BombSweeper {

	public static char arr[][];
	public static int[][] move = { { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 },
			{ 0, -1 }, { -1, -1 }, { -1, 0 }, { -1, 1 } };

	public static int sw;
	public static int sl;

	public static void main(String[] args) {
		String arrays[] = { ".....", ".....", "..B..", ".....", "....." };
		double f = winPercentage(arrays);
		System.out.println(f);
	}

	public static double winPercentage(String[] board) {
		boolean flag;
		int w = board.length;
		int l = board[0].length();
		sw = w;
		sl = l;
		double numOfBoms = 0;
		double numOfEmpty = 0;
		arr = new char[w][l];
		for (int i = 0; i < w; i++) {
			String s = board[i];
			int j;
			char c;
			for (j = 0; j < l; j++) {
				c = s.charAt(j);
				if (c == 'B')
					numOfBoms++;
				arr[i][j] = c;
			}
		}

		for (int i = 0; i < w; i++)
			for (int j = 0; j < l; j++) {
				char c = arr[i][j];
				if (c == 'B') {
					flagDistrictAroundBomb(i, j);
				}
			}

		for (int i = 0; i < w; i++)
			for (int j = 0; j < l; j++) {
				char c = arr[i][j];
				if (c == 'B' || c == 'N')
					continue;
				else {
					flag = isEmpty(i, j);
					if (flag)
						numOfEmpty++;
				}
			}

		return numOfEmpty * 100 / (numOfEmpty + numOfBoms);
	}

	private static void flagDistrictAroundBomb(int x, int y) {
		int tempX;
		int tempY;
		for (int i = 0; i < 8; i++) {
			tempX = x;
			tempY = y;
			tempX += move[i][0];
			tempY += move[i][1];
			if (tempX >= 0 && tempX < sw && tempY >= 0 && tempY < sl) {
				if (arr[tempX][tempY] == '.') {
					arr[tempX][tempY] = 'N';
				}
			}
		}
	}

	private static boolean isEmpty(int x, int y) {
		int tempX;
		int tempY;
		boolean flag = true;
		for (int i = 0; i < 8; i++) {
			tempX = x;
			tempY = y;
			tempX += move[i][0];
			tempY += move[i][1];
			if (tempX >= 0 && tempX < sw && tempY >= 0 && tempY < sl) {
				if (arr[tempX][tempY] == 'B') {
					return false;
				}
			}
		}
		return true;
	}
}
