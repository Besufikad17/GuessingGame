package sample;

import com.jfoenix.controls.JFXButton;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main extends Application {

    static Stage window;
    static Scene socket,scene;
    static Scene s2,s3,s4;
    static TableView tb;


    @Override
    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;
        XMLTool xml = new XMLTool();
        xml.encodeXML();

        AnchorPane root = new AnchorPane();
        root.setPrefSize(400,345);

        Label l = new Label("GuessingGame");
        l.setFont(Font.font("Consolas",37));
        l.setLayoutX(58);
        l.setLayoutY(27);

        JFXButton btn1 = new JFXButton();
        btn1.setText("SinglePlayer");
        btn1.setFont(Font.font("Consolas",20));
        btn1.setLayoutX(114);
        btn1.setLayoutY(123);

        JFXButton btn2 = new JFXButton();
        btn2.setText("MultiPlayer");
        btn2.setFont(Font.font("Consolas",20));
        btn2.setLayoutX(114);
        btn2.setLayoutY(173);

        Layout layout = new Layout();

        btn1.setOnAction(e ->{
            scene = layout.startSinglePlayer();
            primaryStage.setTitle("GuessingGame");
            primaryStage.setScene(scene);
            primaryStage.setResizable(false);
            primaryStage.getIcons().add(new Image(getClass().getResource("image/img.jpeg").toString()));
            primaryStage.show();
        });

        btn2.setOnAction(e->{
            scene = layout.startMultiplayer(primaryStage);
            primaryStage.setTitle("GuessingGame");
            primaryStage.setScene(scene);
            primaryStage.setResizable(false);
            primaryStage.getIcons().add(new Image(getClass().getResource("image/img.jpeg").toString()));
            primaryStage.show();
        });
        root.getChildren().addAll(l,btn1,btn2);
        primaryStage.setTitle("Guessing Game");
        primaryStage.setResizable(false);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.getIcons().add(new Image(getClass().getResource("image/img.jpeg").toString()));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static int Generate() {
        List<Integer> numbers = new ArrayList<>();
        for(int i = 1;i<10;i++){
            numbers.add(i);
        }
        Collections.shuffle(numbers);
        String result = "";
        for(int i = 0;i<4;i++){
            result+= numbers.get(i).toString();

        }
        return Integer.parseInt(result);
    }

    public static ObservableList<Values> getValues(){
        ObservableList<Values> values = FXCollections.observableArrayList();
        return values;
    }

    public static void addValue(int val_1, int val_2, int val_3, TableView<Values> t){
        Values val = new Values(val_1, val_2, val_3);
        t.getItems().add(val);
    }

    public static TableView constructTable(){
        TableColumn<Values, String> value_one_col = new TableColumn<>("Guess");
        value_one_col.setMinWidth(100);
        value_one_col.setCellValueFactory(new PropertyValueFactory<>("value_one"));

        TableColumn<Values, String> value_two_col = new TableColumn<>("N");
        value_two_col.setMinWidth(100);
        value_two_col.setCellValueFactory(new PropertyValueFactory<>("value_two"));

        TableColumn<Values, String> value_three_col = new TableColumn<>("S");
        value_three_col.setMinWidth(100);
        value_three_col.setCellValueFactory(new PropertyValueFactory<>("value_three"));

        TableView valuesTable = new TableView();
        valuesTable.getColumns().addAll(value_one_col, value_two_col, value_three_col);
        valuesTable.setItems(getValues());
        System.out.println(Arrays.toString(getValues().toArray()));
        return valuesTable;
    }
}
