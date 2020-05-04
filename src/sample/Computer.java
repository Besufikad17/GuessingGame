package sample;

import static sample.Main.Generate;

public class Computer {
    public static int Computers_number = Generate();

    public static int getComputers_number() {
        return Computers_number;
    }

    public static void setComputers_number(int computers_number) {
        Computers_number = computers_number;
    }
}
