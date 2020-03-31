import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 284. Peeking Iterator -- Medium
 */

// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {
    private Iterator<Integer> iter;
    private Integer cur;

	public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        iter = iterator;
        cur = iter.next();
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return cur;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
        Integer nxt = cur;
        if (iter.hasNext()) cur = iter.next();
        else cur = null;
        return nxt;
	}

	@Override
	public boolean hasNext() {
	    return cur != null;
	}
} 