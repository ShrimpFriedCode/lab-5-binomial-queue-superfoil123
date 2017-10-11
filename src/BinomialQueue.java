
class ListNode<T> {
    T data;
    ListNode<T> next;
    ListNode(T d, ListNode<T> nxt) { data = d; next = nxt; }

    public String toString() {
        if (next == null)
            return data.toString();
        else
            return data.toString() + " " + next.toString();
    }
}

class BinomialHeap<K extends Comparable<K>> {
    K key;
    int height;
    ListNode<BinomialHeap<K>> children;

    BinomialHeap(K k, int h, ListNode<BinomialHeap<K>> kids) {
        this.key = k; this.height = h; this.children = kids;
    }

    /*
    * @precondition this.height == other.height
     */
    BinomialHeap<K> link(BinomialHeap<K> other) {
        if (this.key.compareTo(other.key) < 0) {
            ListNode<BinomialHeap<K>> kids = new ListNode<>(other, this.children);
            return new BinomialHeap<>(this.key, this.height + 1, kids);
        } else {
            ListNode<BinomialHeap<K>> kids = new ListNode<>(this, other.children);
            return new BinomialHeap<>(other.key, other.height + 1, kids);
        }
    }

    /**
     * TODO
     *
     * The isHeap method checks whether or not the subtree of this node
     * satisfies the heap property.
     */
    boolean isHeap() {
	throw new UnsupportedOperationException();
    }

    public String toString() {
        String ret = "(" + key.toString();
        if (children != null)
            ret = ret + " " + children.toString();
        return ret + ")";
    }

}

public class BinomialQueue<K extends Comparable<K>> {
    ListNode<BinomialHeap<K>> forest;

    public BinomialQueue() {
        forest = null;
    }

    public void push(K key) {
        this.forest = insert(new BinomialHeap<>(key,0,null), this.forest);
    }

    public K extract_min() {
        BinomialHeap<K> min = find_min(this.forest);
        this.forest = remove(min, this.forest);
        ListNode<BinomialHeap<K>> kids = reverse(min.children, null);
        this.forest = merge(this.forest, kids);
        return min.key;
    }

    public boolean isEmpty() {
        return forest == null;
    }

    /**
     * The isHeap method returns whether or not the Binomial Queue (a forest of Binomial Trees)
     * satisfies the heap property.
     */
    public boolean isHeap() {
        ListNode<BinomialHeap<K>> curr = this.forest;
        boolean ret = true;
        while (curr != null) {
            ret = ret && curr.data.isHeap();
            curr = curr.next;
        }
        return ret;
    }

    public String toString() {
        if (this.forest == null)
            return "";
        else
            return this.forest.toString(); }

    /**********************************
     * Helper functions
     */

    BinomialHeap<K> find_min(ListNode<BinomialHeap<K>> ns) {
        if (ns == null)
            return null;
        else
            return find_min_helper(ns.next, ns.data);
    }

    BinomialHeap<K> find_min_helper(ListNode<BinomialHeap<K>> ns, BinomialHeap<K> best) {
        if (ns == null)
            return best;
        else if (ns.data.key.compareTo(best.key) < 0)
                return find_min_helper(ns.next, ns.data);
        else
            return find_min_helper(ns.next, best);
    }

    ListNode<BinomialHeap<K>> remove(BinomialHeap<K> n, ListNode<BinomialHeap<K>> ns) {
        if (ns == null)
            return null;
        else {
            if (ns.data == n)
                return remove(n, ns.next);
            else
                return new ListNode<>(ns.data, remove(n, ns.next));
        }
    }

    ListNode<BinomialHeap<K>> reverse(ListNode<BinomialHeap<K>> ns, ListNode<BinomialHeap<K>> out) {
        if (ns == null)
            return out;
        else {
           return reverse(ns.next, new ListNode<>(ns.data, out));
        }
    }

    /**
     * TODO
     * The insert method is analogous to binary addition. That is,
     * it inserts the node n into the list ns to produce a new list
     * that is still sorted by height.
     *
     * @param n     The node to insert.
     * @param ns    The binomial forest into which to insert, ordered by height.
     * @param <K>   The type of the keys.
     * @return      A new binomial forest that includes the new node.
     */
    static <K extends Comparable<K>> ListNode<BinomialHeap<K>>
    insert(BinomialHeap<K> n, ListNode<BinomialHeap<K>> ns) {
	throw new UnsupportedOperationException();
    }

    /**
     * TODO
     * The merge method is analogous to the merge part of merge sort. That is,
     * it takes two lists that are sorted (by height) and returns a new list that
     * contains the elements of both lists, and the new list is sorted by height.
     * @param ns1
     * @param ns2
     * @return A list that is sorted and contains all and only the elements in ns1 and ns2.
     */
    ListNode<BinomialHeap<K>> merge(ListNode<BinomialHeap<K>> ns1, ListNode<BinomialHeap<K>> ns2) {
	throw new UnsupportedOperationException();
    }

}
