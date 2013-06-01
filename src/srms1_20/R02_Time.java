package srms1_20;

public class R02_Time {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		whatTime(0);
	}

	public static String whatTime(int seconds) {
		int h;
		int m;
		int s;
		h = seconds / 3600;
		m = (seconds - 3600 * h) / 60;
		s = (seconds - 3600 * h) % 60;
		StringBuilder sb = new StringBuilder();
		String ss = (sb.append(h).append(":").append(m).append(":").append(s))
				.toString();
		System.out.println(ss);
		return ss;
	}
}
