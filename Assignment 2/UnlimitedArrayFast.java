public class UnlimitedArrayFast implements UnlimitedArray {
    private int[] cache = new int[1];
    private int maxSize = 1;
    private int elements = 0;

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
        // Resize the array if needed
        if (this.elements == this.maxSize) {
            this.maxSize *= 2;
            int[] newCache = new int[this.maxSize];
            System.arraycopy(this.cache, 0, newCache, 0, this.elements);
            this.cache = newCache;
        }

        // Add the element and increm by one
        this.cache[this.elements] = number;
        this.elements++;
    }

    @Override
    public int removeFirst() {
        if (this.isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
        
        int first = this.cache[0];
        int[] newCache = new int[this.maxSize];
        System.arraycopy(this.cache, 1, newCache, 0, this.elements - 1);
        this.cache = newCache;
        this.elements--;
        return first;
    }

    @Override
    public int removeLast() {
        if (this.isEmpty()) {
            throw new IndexOutOfBoundsException();
        } 

        int last = this.cache[this.elements - 1];
        int[] newCache = new int[this.maxSize];
        System.arraycopy(this.cache, 0, newCache, 0, this.elements - 1);
        this.cache = newCache;
        this.elements--;
        return last;
    }
    
}
