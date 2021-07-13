package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

import static java.sql.Types.NULL;

public class MainDesignController implements Initializable
{
    @FXML
    Pane CalculatorPane, ConverterPane, MortgagePane;

    @FXML
    Button CalculatorButton,ConverterButton,MortgageButton;

    @FXML
    Button one,two,three,four,five,six,seven,eight,nine,zero,zero_zero,full_stop,multi,plus,subtraction,equal,slash,percent,x,ac;

    @FXML
    Label userValue,output;

    int ValueOne=1,ValueTwo=2,ValueThree=3,ValueFour=4,ValueFive=5,ValueSix=6,ValueSeven=7,ValueEight=8,ValueNine=9,ValueZero=0;
    String ValueZeroZero="00",ValueFull_Stop=".",ValueMulti="x",ValuePlus="+",ValueSubtraction="-",ValueEqual="=",ValueSlash="/",ValuePercent="%",ValueX="x",ValueAC= "";

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

    public void CalculatorButtonAction(ActionEvent actionEventForCB)
    {
        if(actionEventForCB.getSource()==one)
        {

            PrintMethod(ValueOne,"Emran");
        }
        else if(actionEventForCB.getSource()==two)
        {
            PrintMethod(ValueTwo,"Emran");
        }
        else if(actionEventForCB.getSource()==three)
        {
            PrintMethod(ValueThree,"Emran");
        }
        else if(actionEventForCB.getSource()==four)
        {
            PrintMethod(ValueFour,"Emran");
        }
        else if(actionEventForCB.getSource()==five)
        {
            PrintMethod(ValueFive,"Emran");
        }
        else if(actionEventForCB.getSource()==six)
        {
            PrintMethod(ValueSix,"Emran");
        }
        else if(actionEventForCB.getSource()==seven)
        {
            PrintMethod(ValueSeven,"Emran");
        }
        else if(actionEventForCB.getSource()==eight)
        {
            PrintMethod(ValueEight,"Emran");
        }
        else if(actionEventForCB.getSource()==nine)
        {
            PrintMethod(ValueNine,"Emran");
        }
        else if(actionEventForCB.getSource()==zero)
        {
            PrintMethod(ValueZero,"Emran");
        }
        else if(actionEventForCB.getSource()==zero_zero)
        {
            PrintMethod(-1,ValueZeroZero);
        }

        else if(actionEventForCB.getSource()==full_stop)
        {
            PrintMethod(-1,ValueFull_Stop);
        }
        else if(actionEventForCB.getSource()==percent)
        {
            PrintMethod(-1,ValuePercent);
        }
        else if(actionEventForCB.getSource()==equal)
        {
            PrintMethod(-1,ValueEqual);
        }
        else if(actionEventForCB.getSource()==x)
        {
            if(userValue.getText().length()==0 || userValue.getText().length()==1)
            {
                userValue.setText("");
                return;
            }
            else
            {
                String RemoveValue=removeLastChar(userValue.getText());
                userValue.setText(RemoveValue);
            }

        }
        else if(actionEventForCB.getSource()==ac)
        {
            userValue.setText("");
            return;
        }

        ////
        char lastValue=userValue.getText().charAt(userValue.getText().length() - 1); //
        if(lastValue=='+' || lastValue=='-' || lastValue=='x' || lastValue=='/')
        {
            String RemoveValue=removeLastChar(userValue.getText());
            //PrintMethod(-1,ValueX);
            userValue.setText(RemoveValue);

            if(actionEventForCB.getSource()==multi)
            {
                PrintMethod(-1,ValueMulti);
            }
            else if(actionEventForCB.getSource()==plus)
            {
                PrintMethod(-1,ValuePlus);
            }
            else if(actionEventForCB.getSource()==subtraction)
            {
                PrintMethod(-1,ValueSubtraction);
            }
            else if(actionEventForCB.getSource()==slash)
            {
            PrintMethod(-1,ValueSlash);
            }
        }
        else
        {
            if(actionEventForCB.getSource()==multi)
            {
                PrintMethod(-1,ValueMulti);
            }
            else if(actionEventForCB.getSource()==plus)
            {
                PrintMethod(-1,ValuePlus);
            }
            else if(actionEventForCB.getSource()==subtraction)
            {
                PrintMethod(-1,ValueSubtraction);
            }
            else if(actionEventForCB.getSource()==slash)
            {
                PrintMethod(-1,ValueSlash);
            }
        }
        ///////////
    }

    public void KeyPressAction(KeyEvent keyEvent)
    {
        //System.out.println(keyEvent.getCode().toString());
        if(keyEvent.getCode().toString().equals("DIGIT1") || keyEvent.getCode().toString().equals("NUMPAD1"))
        {
            System.out.println("One");
            PrintMethod(ValueOne,"Emran");
        }
        else if(keyEvent.getCode().toString().equals("DIGIT2") || keyEvent.getCode().toString().equals("NUMPAD2"))
        {
            PrintMethod(ValueTwo,"Emran");
        }
        else if(keyEvent.getCode().toString().equals("DIGIT3") || keyEvent.getCode().toString().equals("NUMPAD3"))
        {
            PrintMethod(ValueThree,"Emran");
        }
        else if(keyEvent.getCode().toString().equals("DIGIT4") || keyEvent.getCode().toString().equals("NUMPAD4"))
        {
            PrintMethod(ValueFour,"Emran");
        }
        else if(keyEvent.getCode().toString().equals("DIGIT5") || keyEvent.getCode().toString().equals("NUMPAD5"))
        {
            PrintMethod(ValueFive,"Emran");
        }
        else if(keyEvent.getCode().toString().equals("DIGIT6") || keyEvent.getCode().toString().equals("NUMPAD6"))
        {
            PrintMethod(ValueSix,"Emran");
        }
        else if(keyEvent.getCode().toString().equals("DIGIT7") || keyEvent.getCode().toString().equals("NUMPAD7"))
        {
            PrintMethod(ValueSeven,"Emran");
        }
        else if(keyEvent.getCode().toString().equals("DIGIT8") || keyEvent.getCode().toString().equals("NUMPAD8"))
        {
            PrintMethod(ValueEight,"Emran");
        }
        else if(keyEvent.getCode().toString().equals("DIGIT9") || keyEvent.getCode().toString().equals("NUMPAD9"))
        {
            PrintMethod(ValueNine,"Emran");
        }
        else if(keyEvent.getCode().toString().equals("DIGIT0") || keyEvent.getCode().toString().equals("NUMPAD0"))
        {
            PrintMethod(ValueZero,"Emran");
        }
        else if(keyEvent.getCode().toString().equals(ValueZeroZero))
        {
            PrintMethod(-1,ValueZeroZero);
        }
        else if(keyEvent.getCode().toString().equals("DECIMAL"))
        {
            PrintMethod(-1,ValueFull_Stop);
        }
        else if(keyEvent.getCode().toString().equals("EQUALS"))
        {
            PrintMethod(-1,ValueEqual);
        }
        else if(keyEvent.getCode().toString().equals(""))
        {
            PrintMethod(-1,ValuePercent);
        }
        else if(keyEvent.getCode().toString().equals("BACK_SPACE"))
        {
            if(userValue.getText().length()==0 || userValue.getText().length()==1)
            {
                userValue.setText("");
                return;
            }
            else
            {
                String RemoveValue=removeLastChar(userValue.getText());
                userValue.setText(RemoveValue);
            }
        }
        else if(keyEvent.getCode().toString().equals("A"))
        {
            userValue.setText(ValueAC);
            return;
        }

        char lastValue=userValue.getText().charAt(userValue.getText().length() - 1); //
        if(lastValue=='+' || lastValue=='-' || lastValue=='x' || lastValue=='/')
        {
            String RemoveValue=removeLastChar(userValue.getText());
            userValue.setText(RemoveValue);

            if(keyEvent.getCode().toString().equals("MULTIPLY"))
            {
                PrintMethod(-1,ValueMulti);
            }
            else if(keyEvent.getCode().toString().equals("ADD"))
            {
                PrintMethod(-1,ValuePlus);
            }
            else if(keyEvent.getCode().toString().equals("SUBTRACT"))
            {
                PrintMethod(-1,ValueSubtraction);
            }

            else if(keyEvent.getCode().toString().equals("DIVIDE"))
            {
                PrintMethod(-1,ValueSlash);
            }
        }
        else
        {
            if(keyEvent.getCode().toString().equals("MULTIPLY"))
            {
                PrintMethod(-1,ValueMulti);
            }
            else if(keyEvent.getCode().toString().equals("ADD"))
            {
                PrintMethod(-1,ValuePlus);
            }
            else if(keyEvent.getCode().toString().equals("SUBTRACT"))
            {
                PrintMethod(-1,ValueSubtraction);
            }

            else if(keyEvent.getCode().toString().equals("DIVIDE"))
            {
                PrintMethod(-1,ValueSlash);
            }
        }


    }

    private static String removeLastChar(String str) {
        return str.substring(0, str.length() - 1);
    }

    public void PrintMethod(int valueI,String valueS)
    {
        if(valueI!=-1)
        {
            String ValueConvertToS;
            ValueConvertToS=Integer.toString(valueI);
            if(userValue.getText().isEmpty())
            {
                userValue.setText(ValueConvertToS);
            }
            else
            {
                String getTextUserValue=userValue.getText();
                userValue.setText(getTextUserValue+ValueConvertToS);
            }


        }
        else
        {
            if(userValue.getText().isEmpty())
            {
                userValue.setText(valueS);
            }
            else
            {
                String getTextUserValue=userValue.getText();
                userValue.setText(getTextUserValue+valueS);
            }

        }
    }


}