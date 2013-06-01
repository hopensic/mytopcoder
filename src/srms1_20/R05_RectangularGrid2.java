package srms1_20;

public class R05_RectangularGrid2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		long l = countRectangles(5, 2);
		System.out.println(l);

	}

	public static long countRectangles(int width, int height) {
		long num = 0;
		int stepWidth, stepHeight, x, y, endWidth, endHeight;
		for (int i = 1; i <= width; i++) {
			stepWidth = i;
			x = 0;
			for (; x + stepWidth <= width; x++) {
				endWidth = x + stepWidth;
				for (int j = 1; j <= height; j++) {
					if (j == i)
						continue;
					stepHeight = j;
					y = 0;
					for (; y + stepHeight <= height; y++) {
						num++;
					}

				}
			}

		}

		return num;

	}
}
