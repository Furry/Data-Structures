public class UnlimitedArraySlow implements UnlimitedArray {
    private int[] cache = {};

    @Override
    public boolean isEmpty() {
        return cache.length == 0;
    }

    @Override
    public int getFirst() {
        if (this.isEmpty()) {
            throw new IndexOutOfBoundsException();
        } else {
            return cache[0];
        }
    }

    @Override
    public int getLast() {
        if (this.isEmpty()) {
            throw new IndexOutOfBoundsException();
        } else {
            return cache[this.cache.length];
        }
    }

    @Override
    public void add(int number) {
        int[] newCache = new int[cache.length + 1];
        System.arraycopy(this.cache, 0, newCache, 0, cache.length);
        newCache[cache.length] = number;
        this.cache = newCache;
    }

    @Override
    public int removeFirst() {
        if (this.isEmpty()) {
            throw new IndexOutOfBoundsException();
        } else {
            int[] newCache = new int[cache.length - 1];
            int first = cache[0];
            System.arraycopy(this.cache, 1, newCache, 0, cache.length - 1);
            this.cache = newCache;
            return first;
        }
    }

    @Override
    public int removeLast() {
        if (this.isEmpty()) {
            throw new IndexOutOfBoundsException();
        } else {
            int[] newCache = new int[cache.length - 1];
            int last = cache[cache.length - 1];
            System.arraycopy(this.cache, 0, newCache, 0, cache.length - 1);
            this.cache = newCache;
            return last;
        }
    }
    
}
