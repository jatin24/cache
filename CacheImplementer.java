package cache;

import java.util.Scanner;

public class CacheImplementer {
	public static void main(String[] args) {
		Cache cache = new Cache();
		cache.chooseAlgo();

		while (true) {
			try {
				System.out.println("Press");
				System.out.println("1 and the key to fetch");
				System.out.println("2 and key value to store");
				System.out.println("3 to change size");
				System.out.println("Any key to exit");

				Scanner sc = new Scanner(System.in);
				String choice = sc.nextLine();
				if (choice.length() == 0) {
					continue;
				}
				String ch[] = choice.split(" ");
				switch (ch[0]) {
				case "1":
					if (ch.length == 2) {
						int key = Integer.parseInt(ch[1]);
						;
						int value = cache.getCache().get(key);
						if (value == -1) {
							System.out.println("key not present");
						} else {
							System.out.println("value is :" + value);
						}
					} else {
						System.out.println("argument not proper");
					}
					break;
				case "2":
					if (ch.length == 3) {
						int key = Integer.parseInt(ch[1]);
						int value = Integer.parseInt(ch[2]);
						cache.getCache().set(key, value);
						System.out.println("Added");
					} else {
						System.out.println("argument not proper");
					}
					break;
				case "3":
					if (ch.length == 2) {
						int size = Integer.parseInt(ch[1]);
						cache.getCache().size(size);
						System.out.println("Size = " + ch[1]);
					} else {
						System.out.println("argument not proper");
					}
					break;
				default:
					System.out.println("Thank you");
					return;
				}
			} catch (Exception e) {
				System.out.println("Please give correct values");
			}
		}
	}
}