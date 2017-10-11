import org.junit.Test;

import static org.junit.Assert.*;

public class StudentTest {


    //returns a heap with an initialized child array
    private BinomialHeap<Integer> genHeap(int rootVal, int[] childrenRootVals){
        BinomialHeap<Integer> H = new BinomialHeap<>(rootVal, 0, null);

        ListNode<BinomialHeap<Integer>> headHeap = null;
        for (int val : childrenRootVals) {
            BinomialHeap<Integer> newHeap = new BinomialHeap<>(val, 0, null);
            headHeap = new ListNode<>(newHeap, headHeap);
        }
        H.children = headHeap;
        return H;
    }

    @Test
    public void isHeapOnHeap() throws Exception {

        int[] goodVals = {7,8,9};
        int[] badVals = {7,8,9,4};
        int rootVal = 5;

        //singleton heap
        BinomialHeap<Integer> H = new BinomialHeap<>(5,0,null);
        assertTrue(H.isHeap());

        //multilevel heap - true
        assertTrue(genHeap(rootVal, goodVals).isHeap());

        //multilevel heap - false
        assertFalse(genHeap(rootVal, badVals).isHeap());
    }


    @Test
    public void isHeapOnQueue() throws Exception {

        BinomialQueue<Integer> Q = new BinomialQueue<>();

        int[] goodVals = {7,8,9};
        int[] badVals = {7,8,9,4};
        int rootVal = 5;

        //single heap queue
        ListNode<BinomialHeap<Integer>> headForest = null;
        for(int i = 0; i < 1; i++) headForest = new ListNode<>(genHeap(rootVal, goodVals), headForest);
        Q.forest = headForest;
        assertTrue(Q.isHeap());

        //single heap queue - True
        headForest = null;
        for(int i = 0; i < 5; i++) headForest = new ListNode<>(genHeap(rootVal, goodVals), headForest);
        Q.forest = headForest;
        assertTrue(Q.isHeap());


        //multi heap queue - False
        headForest = null;
        for(int i = 0; i < 5; i++) headForest = new ListNode<>(genHeap(rootVal, badVals), headForest);
        Q.forest = headForest;
        assertFalse(Q.isHeap());

    }


    @Test
    public void pushOne() throws Exception {
        BinomialQueue<Integer> H = new BinomialQueue<>();
        H.push(1);
        assertTrue(H.isHeap());
        assertTrue(H.forest.data.height == 0);

    }

    @Test
    public void pushThree() throws Exception {
        BinomialQueue<Integer> H = new BinomialQueue<>();
        H.push(1);
        H.push(2);
        H.push(3);
        assertTrue(H.isHeap());
        assertTrue(H.forest.data.height == 0);
        assertTrue(H.forest.next.data.height == 1);


    }


    @Test
    public void pushFour() throws Exception {
        BinomialQueue<Integer> H = new BinomialQueue<>();
        H.push(1);
        H.push(2);
        H.push(3);
        H.push(4);
        assertTrue(H.isHeap());
        assertTrue(H.forest.data.height == 2);
    }




    @Test
    public void extractMinOne() throws Exception {
        BinomialQueue<Integer> H = new BinomialQueue<>();
        H.push(1);
        assertEquals(H.extract_min(), new Integer(1));
    }

    @Test
    public void extractMinThree() throws Exception {
        BinomialQueue<Integer> H = new BinomialQueue<>();
        H.push(1);
        H.push(2);
        H.push(3);
        assertEquals(H.extract_min(), new Integer(1));
        assertEquals(H.extract_min(), new Integer(2));
        assertEquals(H.extract_min(), new Integer(3));
    }

    @Test
    public void isHeapEmpty() throws Exception {
        BinomialQueue<Integer> H = new BinomialQueue<>();
        assertTrue(H.isHeap());
    }

    @Test
    public void smallMerge() throws Exception {
        BinomialQueue<Integer> H0 = new BinomialQueue<>(),
                               H1 = new BinomialQueue<>();

        H0.push(1);
        H1.push(2);

        BinomialQueue<Integer> H2 = new BinomialQueue<>();

        H2.forest = H2.merge(H0.forest, H1.forest);

        assertTrue(H2.isHeap());

        assertEquals(new Integer(1), H2.extract_min());
        assertEquals(new Integer(2), H2.extract_min());
    }

    @Test
    public void mediumMerge() throws Exception {
    	BinomialQueue<Integer> H0 = new BinomialQueue<>(), H1 = new BinomialQueue<>();
    	
    	for (int x : new int[] { 9, 3, 4, 7, 6, 9 })
		H0.push(x);
    	
    	for (int x : new int[] { 8, 2, 1, 5, 10 })
    		H1.push(x);
    	
	assertTrue(H0.isHeap());
	assertTrue(H1.isHeap());
    	BinomialQueue<Integer> H2 = new BinomialQueue<>();
      	H2.forest = H2.merge(H0.forest, H1.forest);  	
    	assertTrue(H2.isHeap());
    	for (Integer x : new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 9, 10 })
    		assertEquals(x, H2.extract_min());    	
	assertTrue(H2.isHeap());
    }
    
    @Test
    public void mediumMergeChar() throws Exception {
    	BinomialQueue<Character> H0 = new BinomialQueue<>(), H1 = new BinomialQueue<>();
    	
    	for (char x : new char[] { 'a', 'b', 'd', 'g', 'i' })
		H0.push(x);
    	
    	for (char x : new char[] { 'e', 'c', 'f', 'j', 'h' })
    		H1.push(x);
    	
	assertTrue(H0.isHeap());
	assertTrue(H1.isHeap());
    	BinomialQueue<Character> H2 = new BinomialQueue<>();
      	H2.forest = H2.merge(H0.forest, H1.forest);  	
    	assertTrue(H2.isHeap());
    	for (Character x : new Character[] { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j' })
    		assertEquals(x, H2.extract_min()); 
	assertTrue(H2.isHeap());
    }
}
