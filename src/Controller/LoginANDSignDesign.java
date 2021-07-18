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
            }
            else
            {
                SignUpMethod(getName,getEmail,getPass);
            }
        }
        else if(actionEvent.getSource()==SignInButton)
        {
            MainFrame(actionEvent);
            String getEmail,getPass;
            getEmail=SignInEmail.getText(); getPass=SignInPass.getText();
            if(getEmail.isEmpty() || getPass.isEmpty())
            {
                SignInWrongInfo.setText("Fill the all information please!");
            }
            else
            {
                SignInMethod(getEmail,getPass);
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
            SignUpName.setText(""); SignUpEmail.setText(""); SignUpPass.setText("");
        }
        catch(SQLException ex)
        {
            SignUpWrongInfo.setText("You have already signUp !");
            //SignUpWrongInfo.setText(ex.getMessage());
        }
    }//SignUpMethod

    public void SignInMethod(String setEmail, String setPass)
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
                    SignInWrongInfo.setText("Login successful "+DBName);
                    SignInEmail.setText(""); SignInPass.setText("");
                    return;
                }
            }
            SignInWrongInfo.setText("Your account email or password is incorrect.!!!");
            //stmt.close();
        }catch (SQLException ex)
        {
            SignInWrongInfo.setText(ex.getMessage());
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
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
