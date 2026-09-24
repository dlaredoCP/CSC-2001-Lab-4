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

    /** Accepts and index and an element, and inserts the given item at the given index, moving later elements up by one */
    public void insert(int index, int newVal){
        int sub1;
        int sub2;
        if (index>numArray.length-1) {
            throw new NoSuchElementException();
        }
        for (int x = 0; x < numArray.length; x++) {
            if (x == index) {
                sub1 = numArray[x];
                numArray[x] = newVal;
                for (int i = x+1; i<numArray.length; i++){
                    sub2 = numArray[i];
                    numArray[i] = sub1;
                    sub1 = sub2;
                }
                return;
            }
        }
    }

    /** Accepts an element and adds it to the start of a list */
    public void addToStart(int newVal){
        int sub1;
        int sub2;
        sub1 = numArray[0];
        numArray[0] = newVal;
        for (int i = 1; i < numArray.length; i++) {
            sub2 = numArray[i];
            numArray[i] = sub1;
            sub1 = sub2;
        }
    }

    /** Accepts an element and adds it to the end of a list */
    public void addToEnd(int newVal){
        for (int x = 0; x<numArray.length; x++){
            if (numArray[x]==0){
                numArray[x]=newVal;
                return;
            }
        }
    }

    /** Removes an element at a given index */
    public void remove(int index){
        if (index>numArray.length-1){
            throw new NoSuchElementException();
        } else {
            numArray[index] = 0;
            for (int x=index; x<numArray.length-1; x++){
                numArray[x] = numArray[x+1];
            }
        }
    }

    /** ArrayList vs growing Arr (differences) */
    /** -->  When creating an ArrayList, unlike growArr, you don't have to give it a beginning set of values or a set length*/
    /** --> .insert is known as .add for ArrayLists */
    /** --> All ArrayList's methods run in constant time, unlike growingArr's which are linear*/

    static void main(String[] args){
        growingArr ex1 = new growingArr(new int[]{1,3,4,6,0,0,0,0});
        growingArr ex2 = new growingArr(new int[]{0,0,0,0});

//        IO.println(ex1.empty().equalElts(ex2));

        /** Testing .insert method */
//        ex1.insert(2,5);
//        for (int j : ex1.numArray){
//            IO.println(j);
//        }

        /** Testing .addToStart method */
//        ex1.addToStart(3);
//        for (int j : ex1.numArray){
//            IO.println(j);
//        }

        /** Testing .addToEnd method */
//        ex1.addToEnd(3);
//        for (int j : ex1.numArray){
//            IO.println(j);
//        }

        /** Testing .remove method */
        ex1.remove(1);
        for (int j : ex1.numArray){
            IO.println(j);
        }

    }


}
