import java.util.NoSuchElementException;

public class growingArr {
    private int liveCount;
    private int[] numArray;

    public growingArr(int[] numarray){
        liveCount = 0;
        for (int i = 0; i<numarray.length; i++){
            if (numarray[i]!=0){
                liveCount++;
            }
        }
        numArray = numarray;
    }

    /** I made these getters, so that I can test the add method in Main.java since it's a void method*/
    public int[] getArray(){
        return numArray;
    }

    public int getLiveCount(){
        return liveCount;
    }

    /** Accepts a new int to add to the growing array and increases the liveCount */
    /** --> If the array is overfull, your code will have to create a fresh array of double the size, and copy the elements */
    public void add(int n){
        int full = 0;
        for (int i = 0; i<numArray.length; i++) {
            if (numArray[i]==0) {
                numArray[i] = n;
                liveCount++;
                break;
            }
            if (numArray[i]!=0){
                full++;
            }
        }
        if (full==numArray.length){
            int[] newArray = new int[numArray.length*2];
            for (int i=0; i<numArray.length; i++){
                newArray[i] = numArray[i];
            }
            newArray[numArray.length] = n;
            liveCount++;
            numArray = newArray;
        }
    }

    /** Returns the number of elements in the list represented by the object */
    public int length(){
        int len = 0;
        for (int x=0; x<numArray.length; x++){
            if (numArray[x]!=0){
                len++;
            }
        }
        return len;
    }

    /** Accepts another object of your class and returns true when they contain the same elements */
    public boolean equalElts(growingArr a){
        if (length()==a.length()){
            for (int x=0; x<a.length(); x++){
                if (a.numArray[x] != numArray[x]){
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }

    /** Constructs a new object representing the empty list of integers */
    public growingArr empty(){
        int zeroCount = 0;
        for (int x=0; x<numArray.length; x++){
            if (numArray[x]==0){
                zeroCount++;
            }
        }
        return new growingArr(new int[zeroCount]);
    }

    /** Accepts an index and returns the element at that index */
    public int get(int index){
        for (int x = 0; x<numArray.length; x++){
            if (x==index){
                return numArray[x];
            }
        }
        throw new NoSuchElementException();
    }

    /** Accepts an index and a new value and mutates the underlying array to contain the new value at the given index */
    public void set(int index, int newVal){
        for (int x = 0; x<numArray.length; x++){
            if (x==index){
                numArray[index]=newVal;
                return;
            }
        }
        throw new NoSuchElementException();
    }

    static void main(String[] args){
        growingArr ex1 = new growingArr(new int[]{1,3,4,6,0,0,0,0});
        growingArr ex2 = new growingArr(new int[]{0,0,0,0});
        IO.println(ex1.empty().equalElts(ex2));
    }


}
