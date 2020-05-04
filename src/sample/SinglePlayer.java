package sample;


import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import static sample.Main.*;

public class SinglePlayer {
    static TableView tb2;

    public static HBox bottom_box(TableView<Values> t) {
        HBox hbox = new HBox();
        hbox.setPadding(new javafx.geometry.Insets(10, 10, 10, 10));
        hbox.setSpacing(10);
        javafx.scene.control.TextField v_one = new javafx.scene.control.TextField();
        v_one.setPromptText("Value One");
        Button addbtn = new Button("Add");
        XMLTool xml = new XMLTool();
        addbtn.setOnAction(e -> {
            int[] res = PlayPlayer(Integer.parseInt(v_one.getText()));
            if (res == null) {
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setContentText("Invalid Guess!!");
                a.show();
            } else {
                addValue(Integer.parseInt(v_one.getText()), res[0], res[1], t);
                if (res[0] == 4 && res[1] == 4) {
                    Alert a = new Alert(Alert.AlertType.INFORMATION);
                    a.setContentText("Player won!!");
                    a.show();
                    v_one.clear();
                } else {
                    v_one.clear();
                    HBox hb = bottom_box2();
                    VBox v = new VBox();
                    v.getChildren().addAll(tb2,hb);
                    s2 = new Scene(v);
                    window.setScene(s2);
                    window.setTitle("Computer'socket Turn");
                }
            }
        });
        hbox.getChildren().addAll(v_one,  addbtn);
//        socket = new Scene(hbox);
        return hbox;
    }

    public static HBox bottom_box2(){
        HBox hbox  = new HBox();
        hbox.setPadding(new javafx.geometry.Insets(10, 10, 10, 10));
        hbox.setSpacing(10);
        Button addbtn = new Button("Continue");
        int[] res = PlayComputer();
        addValue(res[2],res[0],res[1],tb2);
        addbtn.setOnAction(e ->{
            if (res == null){
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setContentText("Invalid Guess!!");
                a.show();
            }else{
                if (res[0] == 4 && res[1] ==4){
                    Alert a = new Alert(Alert.AlertType.INFORMATION);
                    a.setContentText("You Lost!!");
                    a.show();
                }else{
                    window.setScene(scene);
                    window.setTitle("Player'socket Turn");
                }
            }
        });
        hbox.getChildren().add(addbtn);
        return hbox;
    }

    public static int[] PlayComputer(){
        Player p = new Player();
        String guess = "" + Generate();
        XMLTool xml = new XMLTool();
        xml.decodeXML();
        String players_number = "" + p.getPlayers_number();
        Solver s = new Solver();
        int[] res = s.getNumbs(guess,players_number);
        res[2] = Integer.parseInt(guess);
        return res;
    }

    public static int[] PlayPlayer(int g){
        String guess = "" + g;
        XMLTool xml = new XMLTool();
        xml.decodeXML();
        String computers_number = "" + Computer.getComputers_number();
        Solver s = new Solver();
        return s.getNumbs(guess,computers_number);
    }

}
