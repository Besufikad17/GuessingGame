package sample;

public class Solver {
    public  boolean ValidateGuess ( int number){
        String numb = "" + number;
        if (number < 999 || number > 10000) {
            return false;
        } else if (numb.contains("0")) {
            return false;
        } else return CheckReptition(numb);
    }

    public static boolean CheckReptition (String str){
        char[] chars = str.toCharArray();
        for (char aChar : chars) {
            int index = str.indexOf(aChar);
            return str.lastIndexOf(aChar) <= 0;
        }
        return false;
    }

    public  int[] getNumbs (String str, String str2 ){
        int n = 0, s = 0,g = 0;
        for (int i = 0; i < str.length(); i++) {
            for (int j = 0; j < str2.length(); j++) {
                if (str.charAt(i) == str2.charAt(j)) {
                    n++;
                    if (j == i) {
                        s++;
                    }
                }
            }
        }
        int[] ns = {n, s,g};
        return ns;
    }

}
