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
        if (liveCount==0){
            numArray[0] = newVal;
        } else
        if (index > numArray.length-1){
            throw new NoSuchElementException();
        } else {
            Integer[] replace = new Integer[numArray.length+1];
            System.arraycopy(numArray, 0, replace, 0, index);
            replace[index] = newVal;
            System.arraycopy(numArray, index, replace, index+1, numArray.length-index);
            numArray = replace;
            liveCount++;
        }
    }

    /** Accepts an element and adds it to the start of a list */
    public void addToStart(int newVal){
        if (liveCount==0){
            numArray[0] = newVal;
            liveCount++;
        } else {
            Integer[] newArr = new Integer[length() + 1];
            newArr[0] = newVal;
            for (int x = 0; x < numArray.length; x++) {
                newArr[x + 1] = numArray[x];
            }
            numArray = newArr;
            liveCount++;
        }
    }

    /** Accepts an element and adds it to the end of a list */
    public void addToEnd(int newVal){
        if (liveCount==0){
            numArray[0] = newVal;
            liveCount++;
        } else{
            Integer[] newArr = new Integer[length()+1];
            newArr[liveCount-1] = newVal;
            for (int x = 0; x < numArray.length-1; x++) {
                newArr[x] = numArray[x];
            }
            numArray = newArr;
            liveCount++;
        }
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
     */

    static void main(String[] args){

    }

}
