//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    /** Accepts an array of integers and returns true if all the elements are less than 100, false if not*/
    public static boolean lessThanHundred(int[] a){
        for (int i=0; i<a.length; i++){
            if (a[i]>=100){
                return false;
            }
        }
        return true;
    }

    static void main(String[] args) {
        int[] intarray1 = {3,10,17,2,190,46,77,31,8,5};
        int[] intarray2 = {6,18,19,4,0};
        int[] intarray3 = {5,5,18,900,76,34,43,2,3,2,124,589};

        growingArr first = new growingArr(intarray2);
        first.add(3);
        first.add(19);
        for (int i = 0; i<first.getArray().length; i++){
            IO.println(first.getArray()[i]);
        }
        IO.println(first.getLiveCount());
    }
}
