package Controller;

import animatefx.animation.*;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;


public class LoginANDSignDesign {

    @FXML
    Pane SignInPaneLeft,SignInPaneRight, signUpPaneButton,signInPaneButton, signUpPaneScreen,signInPaneScreen;
    @FXML
    Button SignUpButtonInPane,SignInButtonInPane;



    public void ActionEvent(javafx.event.ActionEvent actionEvent)
    {

        if(actionEvent.getSource()==SignUpButtonInPane)
        {
            new SlideInRight(SignInPaneLeft).play();
            signUpPaneScreen.toFront();
            signUpPaneButton.toBack();
            new SlideInLeft(SignInPaneRight).play();
            signInPaneScreen.toBack();
            signUpPaneScreen.toFront();

        }
        else if(actionEvent.getSource()==SignInButtonInPane)
        {
            new SlideInRight(SignInPaneLeft).play();
            signUpPaneScreen.toBack();
            signUpPaneButton.toFront();
            new SlideInLeft(SignInPaneRight).play();
            signInPaneScreen.toFront();
            signUpPaneScreen.toBack();
        }

    }
}
