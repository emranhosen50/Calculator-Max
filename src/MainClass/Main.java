package MainClass;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;


public class Main extends Application {

    ConnectMySQL Con=new ConnectMySQL(); //Public SQLDatabase Connection


    @Override
    public void start(Stage primaryStage) throws Exception{
        boolean condition=true;
        Con.createConnection();
        condition=CheckUserAlreadyLoginORNot();

        System.out.println(condition);

        if(condition)
        {
            primaryStage.initStyle(StageStyle.UNDECORATED);
            FXMLLoader loader =new FXMLLoader(getClass().getResource("../FXML/LoginANDSignDesign.fxml"));
            //FXMLLoader loader =new FXMLLoader(getClass().getResource("../FXML/MainDesign.fxml"));
            Parent root =loader.load();
            primaryStage.setTitle("Calculator Max");
            Scene scene=new Scene(root);
            scene.getStylesheets().add(getClass().getResource("../CSS/TotalCSSDesign.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.show();
        }
        else
        {
            LoginSuccessful(primaryStage);
        }


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



    }

    private boolean CheckUserAlreadyLoginORNot()
    {
        String DBEmail;
        try {
            Statement stmt= Con.con.createStatement();
            ResultSet rs =stmt.executeQuery("SELECT * FROM login_info;");
            while(rs.next())
            {
                DBEmail = rs.getString("Email");
                System.out.println(DBEmail);
                return false;
            }
            stmt.close();
            return true;
        }catch (SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        return true;
    }

    private void LoginSuccessful(Stage stage) {
       //Stage stage= (Stage) ((Node)event.getSource()).getScene().getWindow();

        try {
            stage.initStyle(StageStyle.UNDECORATED);
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../FXML/MainDesign.fxml")));
            Scene scene=new Scene(root);
            scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("../CSS/TotalCSSDesign.css")).toExternalForm());
            stage.setScene(scene);
            //new FadeIn(root).play(); //FadeIn,
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public static void main(String[] args) {
        launch(args);
    }
}
