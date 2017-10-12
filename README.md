# Lab: Binomial Heaps

Implement the `isHeap()` method in `BinomialNode` and `BinomialHeap`
and the `insert()` and `merge()` methods in `BinomialHeap`.

The `isHeap()` method should verify that the tree rooted at the 
current instance of `BinomialHeap` satisfies the min heap property,
that is, that the key of each parent is less or equal to
the keys of its children.

    ~~~~
    class BinomialHeap<K extends Comparable<K>> {
        K key;
        int height;
        ListNode<BinomialHeap<K>> children;
        ...
        boolean isHeap();
    }
    ~~~~
    
The `insert()` method should put the tree `n` into the forest `ns`
while maintaining two invariants:
(1) the trees in the forest must be sorted by increasing heights, and
(2) there should not be two trees with the same height.
Hint: the `link()` method takes two trees of the same height and
combines them into a new tree with one greater height.

    ~~~~
    public class BinomialQueue<K extends Comparable<K>> {
        ListNode<BinomialHeap<K>> forest;
        ...
        static <K extends Comparable<K>> ListNode<BinomialHeap<K>>
        insert(BinomialHeap<K> n, ListNode<BinomialHeap<K>> ns);
    }
    ~~~~
    
The `merge()` method combines two forests into a single forest
that satisfies the two invariants listed above.

    ~~~~
    ListNode<BinomialHeap<K>> merge(ListNode<BinomialHeap<K>> ns1,
                                    ListNode<BinomialHeap<K>> ns2);
    ~~~~
    
    
