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
            numArray = newArray;
        }
    }


}
