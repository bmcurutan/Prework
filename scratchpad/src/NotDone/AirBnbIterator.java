package NotDone;

import java.util.*;

public class AirBnbIterator {

    private ArrayList<ArrayList<Integer>> lists;
    private int listIndex; // current list index
    private int index;

    private boolean didRemove;

    public AirBnbIterator(ArrayList<ArrayList<Integer>> lists) {
        this.lists = lists;
        this.didRemove = false;

        // TODO
        if (lists.size() > 0) {
            this.listIndex = 0;
            this.index = 0;
        } else {
            this.listIndex = -1;
            this.index = -1;
        }
    }

    public boolean hasNext() {
        while (listIndex >= 0 && listIndex < this.lists.size()) {
            ArrayList<Integer> currList = this.lists.get(listIndex);
            if (index >= 0 && index < currList.size()) {
                return true;
            }
            listIndex++;
            index = 0;
        }

        this.didRemove = false;
        return false;
    }

    public int next() throws Exception {
        if (!hasNext()) {
            throw new Exception();
        }

        this.didRemove = false;
        return this.lists.get(listIndex).get(index++);
    }

    public void remove() throws Exception {
        if (this.didRemove) {
            throw new Exception();
        }

        this.lists.get(listIndex).remove(--index);
    }

    public static void main(String[] args) throws Exception {
        ArrayList<ArrayList<Integer>> test = new ArrayList<>();
        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>();
        ArrayList<Integer> c = new ArrayList<>();
        ArrayList<Integer> d = new ArrayList<>();
        d.add(1);
        ArrayList<Integer> e = new ArrayList<>();
        e.add(3);
        e.add(4);
        e.add(5);
        e.add(6);
        ArrayList<Integer> f = new ArrayList<>();
        ArrayList<Integer> g = new ArrayList<>();
        ArrayList<Integer> h = new ArrayList<>();
        h.add(2);
        test.add(a);
        test.add(b);
        test.add(c);
        /*test.add(d);
        test.add(e);
        test.add(f);
        test.add(g);
        test.add(h);*/

        AirBnbIterator iter = new AirBnbIterator(test);
        iter.next();
        /*while (iter.hasNext()) {
            int temp = iter.next();
            System.out.println(temp);
            iter.remove();
            iter.remove();
        }
        System.out.println();

        AirBnbIterator iter2 = new AirBnbIterator(test);
        while (iter2.hasNext()) {
            System.out.println(iter2.next());
        }*/
    }
}
