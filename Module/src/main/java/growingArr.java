import java.util.NoSuchElementException;

public class growingArr {
    private int liveCount;
    private Integer[] numArray;

    public growingArr(Integer[] numarray, int livecount) {
        numArray = numarray;
        liveCount = livecount;
    }

    /** Returns the number of elements in the list represented by the object */
    public int length() {
        return liveCount;
    }

    /** Accepts another object of your class and returns true when they contain the same elements */
    public boolean equalElts(growingArr a) {
        if (length() == a.length()) {
            for (int x = 0; x < a.length(); x++) {
                if (a.numArray[x].equals(numArray[x])) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }

    /** Constructs a new object representing the empty list of integers */
    public static growingArr empty() {
        return new growingArr(new Integer[1], 0);
    }

    /** Accepts an index and returns the element at that index */
    public Integer get(int index) {
        if (index>numArray.length){
            throw new NoSuchElementException();
        } else {
            return numArray[index];
        }
    }


    /** Accepts an index and a new value and mutates the underlying array to contain the new value at the given index */
    public void set(int index, int newVal){
        if (index>numArray.length){
            throw new NoSuchElementException();
        }
        else {
            numArray[index]=newVal;
        }
    }

    /** Accepts and index and an element, and inserts the given item at the given index, moving later elements up by one */
    public void insert(int index, int newVal){
        if (numArray==null){
            throw new IllegalArgumentException();
        } else
        if (index > numArray.length-1){
            throw new NoSuchElementException();
        } else {
            Integer[] replace = new Integer[numArray.length+1];
            for (int a = 0; a<index; a++){
                replace[a] = numArray[a];
            }
            replace[index] = newVal;
            for (int b = index; b<numArray.length; b++){
                replace[b+1] = numArray[b];
            }
            numArray = replace;
            liveCount++;
        }
    }

    /** Accepts an element and adds it to the start of a list */
    public void addToStart(int newVal){
        Integer[] newArr = new Integer[length()+1];
        newArr[0] = newVal;
        for (int x = 0; x<numArray.length; x++){
            newArr[x+1] = numArray[x];
        }
        numArray = newArr;
        liveCount++;
    }

    /** Accepts an element and adds it to the end of a list */
    public void addToEnd(int newVal){
        numArray[length()-1] = newVal;
    }

    /** Removes an element at a given index */
    public void remove(int index){
        if (index > numArray.length-1){
            throw new NoSuchElementException();
        } else {
            Integer[] replace = new Integer[numArray.length-1];
            System.arraycopy(numArray, 0, replace, 0, index-1);
            System.arraycopy(numArray, index+1, replace, index, length()-index-1);
            numArray = replace;
            liveCount--;
        }
    }

    /**
     * ArrayList vs growing Arr (differences)
     * --> growingArr only stores Integers while ArrayList can store other data types as well
     * --> ArrayList has more methods like contains(), indexOf(), and clear()
     * --> growingArr creates a brand-new array every time it grows or shrinks while ArrayList keeps extra unused capacity that it uses when it grows
     * */

    static void main(String[] args){
        growingArr ex1 = empty();
        ex1.addToEnd(1);
        ex1.addToEnd(3);
        ex1.addToEnd(4);
        ex1.addToStart(7);
    }

}
