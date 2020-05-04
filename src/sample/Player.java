package sample;

import static sample.Main.Generate;
public class Player {
    public  int players_number = Generate();

    public int getPlayers_number() {
        return players_number;
    }

    public  void setPlayers_number(int players_number) {
        this.players_number = players_number;
    }


}
