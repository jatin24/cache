package cache;

public interface ICache {
	public int get(int key);

	public void set(int key, int value);

	public void size(int size);
}