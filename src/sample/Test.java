package sample;



import java.util.Arrays;

import static sample.Main.Generate;


public class Test {
    public static int pn = Generate();

    public static void main(String[] args) {
        Play();
    }

    public static int[] Play() {
        int[] possible_values = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[][] gusses = new int[2][1];
        int guess1 = Generate();
        int guess2 = Generate();
        Solver s = new Solver();
        int[] res = s.getNumbs("" + pn,"" + guess1);
        int[] res2 = s.getNumbs("" + pn,"" + guess2);

        if (res[0] == 0){
            String str = "" + guess1;
            for (int i =0;i<str.length();i++){
                possible_values = RemoveElements(possible_values,(str.charAt(i)) - 48);
            }
        }else if (res2[0] == 0){
            String str = "" + guess2;
            for (int i =0;i<str.length();i++){
                possible_values = RemoveElements(possible_values,(str.charAt(i)) - 48);
            }
        }else{
            if (res[0] == 4 && res[1] == 4 && res2[0] == 4 && res2[1] == 4){
                System.out.println("Computer won");
            }else {
                int[] dups = getIntersection("" + guess1, "" + guess2);
                if (dups.length == 3){

                }
            }
        }
        return possible_values;
    }

    public static int[] RemoveElements(int[] myArr,int n){
        int index = 0;
        for (int i =0;i<myArr.length;i++){
            if (myArr[i] == n){
                index = i;
            }else{
                //pass
            }
        }
        int[] newArr = new int[myArr.length-1];
        System.arraycopy(myArr,0,newArr,0,index);
        System.arraycopy(myArr,index + 1,newArr,index,myArr.length - index -1);
        return newArr;
    }

    public static int[] getIntersection(String s , String s2){
        int[] res = new int[s.length()];
        int count = 0;
        for (int i =0;i<s.length();i++){
            if (s.charAt(i)==s2.charAt(i)){
                res[i - count] = s.charAt(i) - 48;
            }else{
                count++;
            }
        }
        return res;
    }

    public static int getIndex(int[] l , int n){
       int index = 0;
       for(int i =0;i<l.length;i++){
           if (l[i] == n){
               index = i;
           }else{
               //pass
           }
       }
       return index;
    }
}
