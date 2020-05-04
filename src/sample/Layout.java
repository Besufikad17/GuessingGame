package sample;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import static sample.MultiPlayer.*;

public class Layout {
    public Scene startSinglePlayer(){

        TableView tb = Main.constructTable();
        TableView tb2 = Main.constructTable();
        HBox hbox  = SinglePlayer.bottom_box(tb);
        VBox root = new VBox();
        root.getChildren().addAll(tb, hbox);
        Scene s = new Scene(root);
        return s;
    }

    public Scene startMultiplayer(Stage stage){
        Scene s;

        AnchorPane root = new AnchorPane();
        root.setPrefSize(400,345);

        Label l = new Label("MultiPlayer");
        l.setFont(Font.font("Consolas",37));
        l.setLayoutX(78);
        l.setLayoutY(27);

        JFXButton btn1 = new JFXButton();
        btn1.setText("Create Game");
        btn1.setFont(Font.font("Consolas",20));
        btn1.setLayoutX(114);
        btn1.setLayoutY(123);

        JFXButton btn2 = new JFXButton();
        btn2.setText("Join Game");
        btn2.setFont(Font.font("Consolas",20));
        btn2.setLayoutX(114);
        btn2.setLayoutY(173);
        root.getChildren().addAll(l,btn1,btn2);

        btn1.setOnAction(e->{
            VBox v = new VBox(20);
            TableView t = Main.constructTable();
            HBox h = bottom_box3(t);
            v.getChildren().addAll(t,h);
            Scene scene  = new Scene(v);
            stage.setScene(scene);
            stage.setTitle("GuessingGame");
            stage.setResizable(false);
            stage.show();
        });

        btn2.setOnAction(e->{
            VBox v = new VBox(20);
            TableView t = Main.constructTable();
            HBox h = bottom_box4(t);
            v.getChildren().addAll(t,h);
            Scene scene  = new Scene(v);
            stage.setScene(scene);
            stage.setTitle("GuessingGame");
            stage.setResizable(false);
            stage.show();
        });

        s = new Scene(root);
        return s;
    }

    public AnchorPane createGame(Stage s){
        AnchorPane root = new AnchorPane();
        root.setPrefSize(400,345);

        Label l = new Label("Create Game");
        l.setFont(Font.font("Consolas",37));
        l.setLayoutX(78);
        l.setLayoutY(27);

        JFXTextField l2 = new JFXTextField();
        l2.setPromptText("Port");
        l2.setFont(Font.font("Consolas",20));
        l2.setLayoutX(114);
        l2.setLayoutY(123);

        JFXButton btn = new JFXButton("Continue");
        btn.setFont(Font.font("Consolas",20));
        btn.setLayoutX(114);
        btn.setLayoutY(183);

        btn.setOnAction(e->{

        });

        root.getChildren().addAll(l,l2,btn);
        return root;
    }


    public AnchorPane joinGame(Stage s){
        AnchorPane root = new AnchorPane();
        root.setPrefSize(400,345);

        Label l = new Label("Join Game");
        l.setFont(Font.font("Consolas",37));
        l.setLayoutX(78);
        l.setLayoutY(27);

        JFXTextField l2 = new JFXTextField();
        l2.setPromptText("Port");
        l2.setFont(Font.font("Consolas",20));
        l2.setLayoutX(114);
        l2.setLayoutY(123);

        JFXTextField l3 = new JFXTextField();
        l3.setPromptText("Ip Adress");
        l3.setFont(Font.font("Consolas",20));
        l3.setLayoutX(114);
        l3.setLayoutY(173);

        JFXButton btn = new JFXButton("Continue");
        btn.setFont(Font.font("Consolas",20));
        btn.setLayoutX(114);
        btn.setLayoutY(218);

        btn.setOnAction(e->{
            VBox v = new VBox(20);
            TableView t = Main.constructTable();;
            HBox h = bottom_box4(t);

            v.getChildren().addAll(t,h);
            Scene scene  = new Scene(v);

            s.setScene(scene);
            s.setResizable(false);
            s.setTitle("GuessingGame");
            s.show();
        });

        root.getChildren().addAll(l,l2,l3,btn);
        return root;
    }


}
