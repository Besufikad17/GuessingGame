
package sample;


public class Values {
    private int value_one;
    private int value_two;
    private int value_three;
    
    //Creating the object to be saved 
    public Values(int val_one, int val_two, int val_three){
       this.value_one = val_one;
       this.value_two = val_two;
       this.value_three = val_three;
    }

    public int getValue_one() {
        return value_one;
    }

    public void setValue_one(int value_one) {
        this.value_one = value_one;
    }

    public int getValue_two() {
        return value_two;
    }

    public void setValue_two(int value_two) {
        this.value_two = value_two;
    }

    public int getValue_three() {
        return value_three;
    }

    public void setValue_three(int value_three) {
        this.value_three = value_three;
    }

    @Override
    public String toString() {
        String con = value_one + ", " + value_two + ", " + value_three;
        return con; //To change body of generated methods, choose Tools | Templates.
    }
    
}
