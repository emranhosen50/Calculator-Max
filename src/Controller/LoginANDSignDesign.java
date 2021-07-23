package Controller;

import MainClass.ConnectMySQL;
import animatefx.animation.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;


public class LoginANDSignDesign implements Initializable {

    @FXML
    AnchorPane AnchorPane1;
    @FXML
    Pane SignInPaneLeft,SignInPaneRight, signUpPaneButton,signInPaneButton, signUpPaneScreen,signInPaneScreen;
    @FXML
    Button SignUpButtonInPane,SignInButtonInPane,SignInButton,SignUpButton;
    @FXML
    TextField SignUpName,SignUpEmail,SignInEmail;
    @FXML
    PasswordField SignUpPass,SignInPass;
    @FXML
    Label SignInWrongInfo,SignUpWrongInfo,forgotPassLabel, minimize,close,TitleText;

    Notifications noti= Notifications.create();

    //Stage window= new Stage();
    ConnectMySQL Con=new ConnectMySQL(); //Public SQLDatabase Connection

    double mouseX,mouseY;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
       // window.initModality(Modality.APPLICATION_MODAL);
        Con.createConnection();
    }//initialize


    public void ActionEvent(javafx.event.ActionEvent actionEvent)
    {
        if(actionEvent.getSource()==SignUpButtonInPane)
        {

            new Swing(SignInPaneLeft).play();
            new SlideInRight(SignInPaneLeft).play();
                signInPaneScreen.toBack();
                signUpPaneButton.toBack();
//            signUpPaneScreen.toFront();
//            signUpPaneButton.toBack();
            new Swing(SignInPaneRight).play();
            new SlideInLeft(SignInPaneRight).play();
            TitleText.setText("Sign Up");
//            signInPaneScreen.toBack();
//            signUpPaneScreen.toFront();
            signUpPaneScreen.toFront();
            signInPaneButton.toFront();

        }
        else if(actionEvent.getSource()==SignInButtonInPane)
        {
            new Tada(SignInPaneLeft).play();
            new SlideInRight(SignInPaneLeft).play();
            signUpPaneScreen.toBack();
            signInPaneButton.toBack();
//            signUpPaneScreen.toBack();
//            signUpPaneButton.toFront();
            new Tada(SignInPaneRight).play();
            new SlideInLeft(SignInPaneRight).play();
            TitleText.setText("Sign In");
//            signInPaneScreen.toFront();
//            signUpPaneScreen.toBack();
            signInPaneScreen.toFront();
            signUpPaneButton.toFront();
        }
        //////////
        else if(actionEvent.getSource()==SignUpButton)
        {
            String getName,getEmail,getPass;
            getName=SignUpName.getText(); getEmail=SignUpEmail.getText(); getPass=SignUpPass.getText();

            if(getName.isEmpty() || getEmail.isEmpty() || getPass.isEmpty())
            {
                SignUpWrongInfo.setText("Fill the all information please!");
                ///////
                NotificationTray("Information", "Fill the all information please!",3);
            }
            else
            {
                SignUpMethod(getName,getEmail,getPass);
            }
        }
        else if(actionEvent.getSource()==SignInButton)
        {
            //MainFrame(actionEvent);
            String getEmail,getPass;
            getEmail=SignInEmail.getText(); getPass=SignInPass.getText();
            if(getEmail.isEmpty() || getPass.isEmpty())
            {
                SignInWrongInfo.setText("Fill the all information please!");
                //////
                NotificationTray("Information", "Fill the all information please!",3);
            }
            else
            {
                SignInMethod(getEmail,getPass,actionEvent);
            }
        }



    }//ActionEvent

    public void MouseClick(MouseEvent mouseEvent)
    {
        if(mouseEvent.getSource()==close)
        {
            Stage stage=(Stage) close.getScene().getWindow();
            stage.close();
            //System.exit(0);
        }
        else if(mouseEvent.getSource()==minimize)
        {
            Stage stage=(Stage) minimize.getScene().getWindow();
            stage.setIconified(true);
        }
    }//MouseClick

    ////////////// Login and SignUp Methods ///////////////
    public void SignUpMethod(String setName, String setEmail, String setPass)
    {
        try{
            PreparedStatement stmt = Con.con.prepareStatement("INSERT INTO signup_info VALUES( ?,?,? ) ");
            stmt.setString(1,setName);
            stmt.setString(2,setEmail);
            stmt.setString(3,setPass);
            stmt.execute();
            stmt.close();
            SignUpWrongInfo.setText("Sign up successful");
            NotificationTray("Successful", "Sign up successful "+setName,1);
            SignUpName.setText(""); SignUpEmail.setText(""); SignUpPass.setText("");
        }
        catch(SQLException ex)
        {
            if(ex.getMessage().equals("Duplicate entry '"+setEmail+"' for key 'signup_info.PRIMARY'"))
            {
                SignUpWrongInfo.setText("You have already signUp !");
                NotificationTray("Warning", "You have already signUp !",2);
            }
            //SignUpWrongInfo.setText(ex.getMessage());
        }
    }//SignUpMethod

    public void SignInMethod(String setEmail, String setPass,ActionEvent actionEvent)
    {
        String DBName,DBEmail,DBPassword;
        try {
            Statement stmt= Con.con.createStatement();
            ResultSet rs =stmt.executeQuery("SELECT * FROM signup_info");
            while(rs.next())
            {
                DBName = rs.getString("Name");
                DBEmail = rs.getString("Email");
                DBPassword = rs.getString("Password");
                if(DBEmail.equals(setEmail) && DBPassword.equals(setPass))
                {
                    System.out.println("Login successful "+DBName);
                    NotificationTray("Successful", "Login successful "+DBName,1);
                    SignInWrongInfo.setText("Login successful "+DBName);
                    SignInEmail.setText(""); SignInPass.setText("");
                    //Insert Login Information
                    PreparedStatement Pstmt = Con.con.prepareStatement("INSERT INTO login_info VALUES( ?,? ) ");
                    Pstmt.setString(1,"1");
                    Pstmt.setString(2,DBEmail);
                    Pstmt.execute();
                    Pstmt.close();
                    //Insert Login Information
                    MainFrame(actionEvent);
                    return;
                }
            }
            SignInWrongInfo.setText("Your account email or password is incorrect.!!!");
            ///
            NotificationTray("Warring", "Your account email or password is incorrect.!!!",2);
            //stmt.close();
        }catch (SQLException ex)
        {
            SignInWrongInfo.setText(ex.getMessage());
            System.out.println("SignIn: "+ex.getMessage());
        }

    }//SignInMethod

    public void MainFrame(ActionEvent event)
    {
        Stage stage= (Stage) ((Node)event.getSource()).getScene().getWindow();

        try {
            Parent root = FXMLLoader.load(getClass().getResource("../FXML/MainDesign.fxml"));
            Scene scene=new Scene(root);
            scene.getStylesheets().add(getClass().getResource("../CSS/TotalCSSDesign.css").toExternalForm());
            stage.setScene(scene);
            new FadeIn(root).play(); //FadeIn,
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }//MainFrame

    void NotificationTray(String title,String message,int value)
    {
        TrayNotification tray = new TrayNotification();
        AnimationType type=AnimationType.SLIDE;
        tray.setAnimationType(type);
        tray.setTitle(title);
        tray.setMessage(message);
        if(value==1){
            tray.setNotificationType(NotificationType.SUCCESS);
        }
        else if(value==2){
            tray.setNotificationType(NotificationType.WARNING);
        }
        else if(value==3){
            tray.setNotificationType(NotificationType.INFORMATION);
        }
        tray.showAndDismiss(Duration.millis(2000));
        tray.showAndWait();
    }



    //mouse
    public void mouseDrag(MouseEvent event) {
        //Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Stage stage=(Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setX(event.getScreenX()-mouseX);
        stage.setY(event.getScreenY()-mouseY);

    }
    public void mousePressed(MouseEvent event) {
        mouseX =event.getSceneX();
        mouseY=event.getSceneY();
        //System.out.println("mouseX:"+mouseX+"   "+"mouseY:"+mouseY);
    }


}
