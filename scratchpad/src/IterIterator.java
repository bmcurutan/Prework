import java.util.*;

// Write an iterative that chains together multiple iterators

public class IterIterator<T> implements Iterator<T> {
    private List<Iterator<T>> iters;
    private int curr;

    public IterIterator(List<Iterator<T>> iters) {
        this.iters = iters;
        this.curr = 0;
    }

    @Override
    public boolean hasNext() {
        while (curr < iters.size()) {
            if (iters.get(curr).hasNext()) {
                return true;
            }
            curr++;
        }
        return false;
    }

    @Override
    public T next() {
        if (curr < iters.size()) {
            return iters.get(curr).next();
        }
        return null;
    }

    @Override
    public void remove() {
        if (curr < iters.size()) {
            iters.get(curr).remove();
        }
    }
}
