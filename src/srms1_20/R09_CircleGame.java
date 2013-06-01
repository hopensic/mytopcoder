package srms1_20;

import java.util.HashMap;
import java.util.LinkedList;

public class R09_CircleGame {
	public final static HashMap<Character, Integer> m = new HashMap<Character, Integer>();

	static {
		m.put('A', 1);
		m.put('2', 2);
		m.put('3', 3);
		m.put('4', 4);
		m.put('5', 5);
		m.put('6', 6);
		m.put('7', 7);
		m.put('8', 8);
		m.put('9', 9);
		m.put('T', 10);
		m.put('J', 11);
		m.put('Q', 12);
		m.put('K', 13);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// String s = "KKKKKAQT23";
		// String s = "AQK262362TKKAQ6262437892KTTJA332";
		// J92J43KT5T879QA2QK3-----9
		// A8929JTAQ6J247759TKK5K3K947JQA284Q4256Q36587T6833A----30

		// AJJTKK29T883J2JJT9329JAJJTJKK2JTJKQQ88TJ2A-------31
		String s = "AQK262362TKKAQ6262437892KTTJA332";
		int x = cardsLeft(s);
		System.out.println(x);
	}

	public static int cardsLeft(String deck) {
		LinkedList<Character> list = new LinkedList<Character>();
		int compareA = 0;
		int compareB = 0;
		int indexA = 0;
		int indexB = indexA + 1;
		boolean sumFirstLast = false;
		int hasDeletedtimes = 0;
		char carray[] = deck.toCharArray();
		int len = carray.length;
		for (int i = 0; i < len; i++)
			if (carray[i] != 'K')
				list.add(carray[i]);

		do {
			hasDeletedtimes = 0;
			len = list.size();
			if (len == 0)
				return 0;
			else if (len == 1)
				return 1;
			else if (len == 2) {
				if (m.get(list.get(0)) + m.get(list.get(1)) == 13)
					return 0;
				else
					return 2;
			} else {
				if (!sumFirstLast) {
					sumFirstLast = true;
					compareA = m.get(list.getFirst());
					compareB = m.get(list.getLast());
					if (compareA + compareB == 13) {
						list.removeFirst();
						list.removeLast();
						hasDeletedtimes++;
						sumFirstLast = false;
					}
				} else {
					sumFirstLast = false;
					while (true) {
						compareA = m.get(list.get(indexA));
						compareB = m.get(list.get(indexB));
						if (indexB == len - 1) {
							if (compareA + compareB == 13) {
								list.remove(indexA);
								list.remove(indexA);
								hasDeletedtimes++;
							}
							break;
						} else {
							if (compareA + compareB == 13) {
								list.remove(indexA);
								list.remove(indexA);
								hasDeletedtimes++;
								len = list.size();
								if (indexA == len - 1)
									break;
								else
									continue;
							} else {
								indexA++;
								indexB++;
								continue;
							}
						}
					}
					indexA = 0;
					indexB = 1;
				}

			}
			if (hasDeletedtimes == 0 && !sumFirstLast)
				break;

		} while (true);

		return list.size();
	}
}
