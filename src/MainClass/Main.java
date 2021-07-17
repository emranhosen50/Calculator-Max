package MainClass;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception{

        //FXMLLoader loader =new FXMLLoader(getClass().getResource("../FXML/LoginANDSignDesign.fxml"));
        FXMLLoader loader =new FXMLLoader(getClass().getResource("../FXML/MainDesign.fxml"));
        Parent root =loader.load();
        //Parent root = FXMLLoader.load(getClass().getResource("../FXML/MainDesign.fxml"));
        primaryStage.setTitle("Calculator Max");
        Scene scene=new Scene(root);

        //MainDesignController mainDesignController= loader.getController(); /// before Open.....

//        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
//            @Override
//            public void handle(KeyEvent keyEvent) {
//
//                System.out.println("Hi Enter");
//
//                switch (keyEvent.getCode())
//                {
//                    case SPACE:
//                        System.out.println("Hi Enter");
//                }
//
//                System.out.println("KeyBoard Click: "+keyEvent.getCode());
//                mainDesignController.KeyPressAction(keyEvent);
//            }
//        });


        scene.getStylesheets().add(getClass().getResource("../CSS/TotalCSSDesign.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
