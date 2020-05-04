package sample;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

import static sample.Main.*;
class MultiPlayer {
    private static TableView<Values> tb2;

    static HBox bottom_box3(TableView<Values> t){
        HBox hbox  = new HBox();
        hbox.setPadding(new Insets(10, 10, 10, 10));
        hbox.setSpacing(10);
        TextField v_one = new TextField();
        v_one.setPromptText("Value One");
        Button addbtn = new Button("Add");
        hbox.getChildren().addAll(addbtn,v_one);
        addbtn.setOnAction(e -> {
            ServerSocket server;
            Socket socket;
            try {
                server = new ServerSocket(5000);
                socket = server.accept();
                System.out.println("connected");

                InputStreamReader input = new InputStreamReader(socket.getInputStream());
                BufferedReader bf = new BufferedReader(input);

                while(true) {
                    send(socket,v_one.getText());
                    String str = bf.readLine();
                    int[] res = PlayMultiPlayer(Integer.parseInt(v_one.getText()));
                    if (res == null) {
                        Alert a = new Alert(Alert.AlertType.ERROR);
                        a.setContentText("Invalid Guess!!");
                        a.show();
                    } else {
                        addValue(Integer.parseInt(v_one.getText()), res[0], res[1], t);
                        if (res[0] == 4 && res[1] == 4) {
                            Alert a = new Alert(Alert.AlertType.INFORMATION);
                            a.setContentText("Player2 won!!");
                            a.show();
                            v_one.clear();
                            break;
                        } else {
                            v_one.clear();
                            int n = Integer.parseInt(str);
                            HBox hb = bottom_boxx(n,window.getScene());
                            VBox v = new VBox();
                            v.getChildren().addAll(tb2,hb);
                            s4 = new Scene(v);
                            window.setScene(s4);
                            window.setTitle("Player1's  Turn");
                        }
                    }
                }
            } catch (Exception ex) {
                System.out.println("Connection lost");
            }

        });
        VBox v = new VBox();
        v.getChildren().addAll(t,hbox);
        s3 = new Scene(v);
        return hbox;
    }

    private static HBox bottom_boxx(int i,Scene s) {
        HBox hbox  = new HBox();
        hbox.setPadding(new javafx.geometry.Insets(10, 10, 10, 10));
        hbox.setSpacing(10);
        Button addbtn = new Button("Continue");
        int[] res = PlayMultiPlayer2(i);
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
                    window.setScene(s);
                }
            }
        });
        hbox.getChildren().add(addbtn);
        return hbox;
    }

    static HBox bottom_box4(TableView<Values> t){
        tb = constructTable();
        HBox hbox  = new HBox();
        hbox.setPadding(new javafx.geometry.Insets(10, 10, 10, 10));
        hbox.setSpacing(10);
        TextField v_one = new TextField();
        v_one.setPromptText("Value One");
        Button addbtn = new Button("Add");
        hbox.getChildren().addAll(addbtn,v_one);
        addbtn.setOnAction(e -> {
            Socket socket;
            try {
                socket = new Socket("127.0.0.1",5000);
                InputStreamReader input = new InputStreamReader(socket.getInputStream());
                BufferedReader bf = new BufferedReader(input);
                while(true) {
                    send(socket,v_one.getText());
                    String str = bf.readLine();
                    System.out.println("Player 1 : " + v_one.getText());
                    int[] res = PlayMultiPlayer2(Integer.parseInt(v_one.getText()));
                    if (res == null) {
                        Alert a = new Alert(Alert.AlertType.ERROR);
                        a.setContentText("Invalid Guess!!");
                        a.show();
                    } else {
                        addValue(Integer.parseInt(v_one.getText()), res[0], res[1], t);
                        if (res[0] == 4 && res[1] == 4) {
                            Alert a = new Alert(Alert.AlertType.INFORMATION);
                            a.setContentText("Player1 won!!");
                            a.show();
                            v_one.clear();
                            break;
                        } else {
                            v_one.clear();
                            int n = Integer.parseInt(str);
                            HBox hb = bottom_boxx(n,window.getScene());
                            VBox v = new VBox();
                            v.getChildren().addAll(tb2, hb);
                            s3 = new Scene(v);
                            window.setScene(s3);
                        }
                        }
                }
            } catch (Exception ex) {
                System.out.println("Connection lost");
            }
        });
        return hbox;
    }
    private static void send(Socket s, String msg)throws Exception{
        PrintWriter pr = new PrintWriter(s.getOutputStream());
        pr.println(msg);
        pr.flush();
    }
    private static int[] PlayMultiPlayer(int g){
        int res[] = new int[2];
        XMLTool xml = new XMLTool();
        Solver s = new Solver();
        int player1_number = xml.decodeXML2()[0];
        res = s.getNumbs(""+g,player1_number + "");
        return res;
    }
    private static int[] PlayMultiPlayer2(int guess) {
        int res[] = new int[2];
        XMLTool xml = new XMLTool();
        Solver s = new Solver();
        int player2_number = xml.decodeXML2()[1];
        res = s.getNumbs(""+guess,player2_number + "");
        return res;
    }
}
