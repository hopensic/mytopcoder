package srms21_40;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class R27_Salary {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String arrival[] = { "22:19:46" };
		String depart[] = { "23:12:46" };
		int wage = 5320;

		// String arrival[] = {"08:00:00","13:00:00","19:27:32"};
		// String depart[] ={"12:00:00","17:00:00","20:48:10"}
		// int wage = 1000;

		// String arrival[] = { "01:05:47", "16:48:12" };
		// String depart[] = { "09:27:30", "21:17:59" };
		// int wage = 2000;
		int salary = howMuch(arrival, depart, wage);
		System.out.println(salary);
	}

	public static int howMuch(String[] arrival, String[] departure, int wage) {
		double sum = 0;
		try {
			DateFormat df = new SimpleDateFormat("HH:mm:ss");
			Date d1 = df.parse("00:00:00");
			Date d2 = df.parse("06:00:00");
			Date d3 = df.parse("18:00:00");
			// Date d4 = df.parse("23:59:59");
			int len = arrival.length;
			Date arrivalDate[] = new Date[len];
			Date departureDate[] = new Date[len];

			long oneAndhalf = 0;
			long one = 0;

			for (int i = 0; i < len; i++) {
				arrivalDate[i] = df.parse(arrival[i]);
				departureDate[i] = df.parse(departure[i]);
				if (arrivalDate[i].compareTo(d1) >= 0
						&& arrivalDate[i].before(d2)) {
					if (departureDate[i].before(d2))
						oneAndhalf += (departureDate[i].getTime() - arrivalDate[i]
								.getTime());

					else if (departureDate[i].compareTo(d2) >= 0
							&& departureDate[i].before(d3)) {

						oneAndhalf += (d2.getTime() - arrivalDate[i].getTime());
						one += (departureDate[i].getTime() - d2.getTime());

					} else {
						oneAndhalf += (d2.getTime() - arrivalDate[i].getTime()
								+ departureDate[i].getTime() - d3.getTime());

						one += (d3.getTime() - d2.getTime());
					}

				} else if (arrivalDate[i].compareTo(d2) >= 0
						&& arrivalDate[i].before(d3)) {
					if (departureDate[i].before(d3)) {
						one += (departureDate[i].getTime() - arrivalDate[i]
								.getTime());
					} else {
						oneAndhalf += (departureDate[i].getTime() - d3
								.getTime());
						one += (d3.getTime() - arrivalDate[i].getTime());

					}
				} else {
					oneAndhalf += (departureDate[i].getTime() - arrivalDate[i]
							.getTime());
				}

			}
			sum = (oneAndhalf * 1.5 + one) / 3600000.0 * wage;

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (int) sum;

	}
}
