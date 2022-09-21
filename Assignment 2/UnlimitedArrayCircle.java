public class UnlimitedArrayCircle implements UnlimitedArray {
    private int[] cache;
    private int elements = 0;
    private int startPoint = 0; // Store where the

    @Override
    public boolean isEmpty() {
        return this.elements == 0;
    }

    @Override
    public int getFirst() {
        if (this.isEmpty())
            throw new IndexOutOfBoundsException();
        return cache[0];
    }

    @Override
    public int getLast() {
        if (this.isEmpty())
            throw new IndexOutOfBoundsException();
        return cache[this.elements - 1];
    }

    @Override
    public void add(int number) {
        if (this.elements == 0) {
            cache = new int[1];
            cache[0] = number;
        } else {
            int[] newCache = new int[this.elements + 1];
            for (int i = 0; i < this.elements; i++) {
                newCache[i] = cache[i];
            }
            newCache[this.elements] = number;
            cache = newCache;
        }
        this.elements++;
    }

    @Override
    public int removeFirst() {
        int first = this.cache[0];
        this.cache[0] = 0;
        this.elements--;
        return first;
    }

    @Override
    public int removeLast() {
        if (this.isEmpty()) {
            throw new IndexOutOfBoundsException();
        }

        int last = this.cache[this.elements - 1];
        this.cache[this.elements - 1] = 0;
        this.elements--;
        return last;
    }
    
}
