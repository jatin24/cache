package cache;

import java.util.Scanner;

public class Cache {
	private int capacity = 10;

	private ICache icache;

	public void chooseAlgo() {
		System.out.print("Enter the algorithm : ");
		System.out.println("1. LRU cache");
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		switch (choice) {
		case 1:
			icache = new LRUCache(capacity);
			break;
		default:
			return;
		}
	}

	public ICache getCache() {
		return icache;
	}
}
