package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class MainDesignController implements Initializable
{
    @FXML
    Pane CalculatorPane, ConverterPane, MortgagePane;

    @FXML
    Button CalculatorButton,ConverterButton,MortgageButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void ActionEvent(ActionEvent actionEvent)
    {
        if(actionEvent.getSource()==CalculatorButton)
        {
            CalculatorPane.toFront();
            ConverterPane.toBack();
            MortgagePane.toBack();
        }
        else if(actionEvent.getSource()==ConverterButton)
        {
            ConverterPane.toFront();
            CalculatorPane.toBack();
            MortgagePane.toBack();
        }
        else if(actionEvent.getSource()==MortgageButton)
        {
            MortgagePane.toFront();
            ConverterPane.toBack();
            CalculatorPane.toBack();
        }
    }
}