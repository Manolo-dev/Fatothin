package utils;

public class Pair<A, B> {
    private A first;
    private B second;

    public Pair(A first, B second) {
        if(first == null) throw new IllegalArgumentException("First element cannot be null");
        if(second == null) throw new IllegalArgumentException("Second element cannot be null");

        this.first = first;
        this.second = second;
    }

    public A getFirst() {
        return first;
    }

    public B getSecond() {
        return second;
    }

    @Override
    public String toString() {
        return "(" + first.toString() + ", " + second.toString() + ")";
    }
}
