package sample;

import java.util.Arrays;

import static sample.Main.Generate;

public class Test2 {
    public static int pn = Generate();
    public static void main(String[] args) {
        int[] ns = new int[5];
        int[] numbers = new int[5];
        Solver s = new Solver();
        for(int i = 0;i<5;i++){
            int guessed_number = Generate();
            numbers[i] = guessed_number;
            ns[i] = s.getNumbs("" + guessed_number,"" + pn)[0];
        }
        System.out.println(pn);
        System.out.println(Arrays.toString(numbers));
        System.out.println(Arrays.toString(ns));
        int largest_n = 0;
        for(int j =0;j<ns.length;j++){
            if (ns[j] >= ns[largest_n]){
                largest_n = j;
            }else{
                largest_n = 0;
            }
        }
        System.out.println(largest_n);
        int smallest_n = 0;
        for(int j =0;j<ns.length;j++){
            if (ns[j] <= ns[smallest_n]){
                smallest_n = j;
            }else{
                smallest_n = 0;
            }
        }
        System.out.println(smallest_n);

    }

}
