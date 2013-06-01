package srms1_20;

public class R05_RectangularGrid {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		long l = countRectangles(592, 964);
		System.out.println(l);

	}

	public static long countRectangles(int width, int height) {
		long num = 0;
		long w[] = new long[width];
		long h[] = new long[height];

		for (int i = 0; i < width; i++)
			w[i] = width - i;
		for (int j = 0; j < height; j++)
			h[j] = height - j;
		for (int i = 0; i < width; i++)
			for (int j = 0; j < height; j++)
				if (i == j)
					continue;
				else
					num += w[i] * h[j];
		return num;

	}
}
