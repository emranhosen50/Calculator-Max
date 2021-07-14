package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;

import java.net.URL;
import java.util.ResourceBundle;


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
    char lastValue;
    double StoreCalculationValue=0,BeforeCalValue,AfterCalValue;
    public String SplitString="";
    public String PublicOperator="NULL";
    public int conditionForOperator;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        x.setDisable(true);
        fontSizeRestore();
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
            fontSizeRestore();
            PrintMethod(ValueOne,"Emran");
            OperandStore(Integer.toString(ValueOne));
            return;
        }
        else if(actionEventForCB.getSource()==two)
        {
            fontSizeRestore();
            PrintMethod(ValueTwo,"Emran");
            OperandStore(Integer.toString(ValueTwo));
            return;
        }
        else if(actionEventForCB.getSource()==three)
        {
            fontSizeRestore();
            PrintMethod(ValueThree,"Emran");
            OperandStore(Integer.toString(ValueThree));
            return;
        }
        else if(actionEventForCB.getSource()==four)
        {
            fontSizeRestore();
            PrintMethod(ValueFour,"Emran");
            OperandStore(Integer.toString(ValueFour));
            return;
        }
        else if(actionEventForCB.getSource()==five)
        {
            fontSizeRestore();
            PrintMethod(ValueFive,"Emran");
            OperandStore(Integer.toString(ValueFive));
            return;
        }
        else if(actionEventForCB.getSource()==six)
        {
            fontSizeRestore();
            PrintMethod(ValueSix,"Emran");
            OperandStore(Integer.toString(ValueSix));
            return;
        }
        else if(actionEventForCB.getSource()==seven)
        {
            fontSizeRestore();
            PrintMethod(ValueSeven,"Emran");
            OperandStore(Integer.toString(ValueSeven));
            return;
        }
        else if(actionEventForCB.getSource()==eight)
        {
            fontSizeRestore();
            PrintMethod(ValueEight,"Emran");
            OperandStore(Integer.toString(ValueEight));
            return;
        }
        else if(actionEventForCB.getSource()==nine)
        {
            fontSizeRestore();
            PrintMethod(ValueNine,"Emran");
            OperandStore(Integer.toString(ValueNine));
            return;
        }
        else if(actionEventForCB.getSource()==zero)
        {
            fontSizeRestore();
            PrintMethod(ValueZero,"Emran");
            OperandStore(Integer.toString(ValueZero));
            return;
        }
        else if(actionEventForCB.getSource()==zero_zero)
        {
            fontSizeRestore();
            PrintMethod(-1,ValueZeroZero);
            OperandStore(ValueZeroZero);
            return;
        }

        else if(actionEventForCB.getSource()==equal)
        {
            //calculationMethod();

            userValue.setFont(new Font("Serif",13));
            output.setFont(new Font("Serif", 25));
            userValue.setText(userValue.getText());
            output.setText(String.valueOf(StoreCalculationValue));
            return;
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
            fontSizeRestore();
            StoreCalculationValue=0;
            BeforeCalValue=0;
            AfterCalValue=0;
            userValue.setText("");
            output.setText("");
            SplitString="";
            return;
        }


        try {
            lastValue=userValue.getText().charAt(userValue.getText().length() - 1); //
        }catch (Exception e)
        {
            System.out.println("Error E2H");
            return;
        }

        System.out.println(lastValue);
        if(lastValue=='+' || lastValue=='-' || lastValue=='x' || lastValue=='/' || lastValue=='.' || lastValue=='%')
        {
            //System.out.println(userValue.getText().length());
            //When Already add any Operator then user again push to change this .. then this Function will be work
            String RemoveValue=removeLastChar(userValue.getText());
            userValue.setText(RemoveValue);

            //System.out.println("Shit: "+lastValue);

            if(StoreCalculationValue==0)
            { BeforeCalValue= Double.parseDouble(SplitString); }
            else
            { BeforeCalValue=StoreCalculationValue; }

            SplitString="";

            if(actionEventForCB.getSource()==plus)
            {
                fontSizeRestore();
                conditionForOperator=1;
                PrintMethod(-1,ValuePlus);
                return;
            }
            else if(actionEventForCB.getSource()==subtraction)
            {
                fontSizeRestore();
                conditionForOperator=2;
                PrintMethod(-1,ValueSubtraction);
                return;
            }
            else if(actionEventForCB.getSource()==multi)
            {
                fontSizeRestore();
                conditionForOperator=3;
                PrintMethod(-1,ValueMulti);
                return;
            }
            else if(actionEventForCB.getSource()==slash)
            {
                fontSizeRestore();
                conditionForOperator=4;
                PrintMethod(-1,ValueSlash);
                return;
            }
            /////
            else if(actionEventForCB.getSource()==full_stop)
            {
                fontSizeRestore();
                PrintMethod(-1,ValueFull_Stop);
                return;
            }
            else if(actionEventForCB.getSource()==percent)
            {
                fontSizeRestore();
                conditionForOperator=5;
                PrintMethod(-1,ValuePercent);
                calculationMethod();
                OperandStore(Integer.toString(ValueNine));
                return;
            }

        }
        else
        {
            if(StoreCalculationValue==0)
            { BeforeCalValue= Double.parseDouble(SplitString); }
            else
            { BeforeCalValue=StoreCalculationValue; }


            SplitString="";

            if(actionEventForCB.getSource()==plus)
            {
                fontSizeRestore();
                conditionForOperator=1;
                PrintMethod(-1,ValuePlus);
                return;
            }
            else if(actionEventForCB.getSource()==subtraction)
            {
                fontSizeRestore();
                conditionForOperator=2;
                PrintMethod(-1,ValueSubtraction);
                return;
            }
            else if(actionEventForCB.getSource()==multi)
            {
                fontSizeRestore();
                conditionForOperator=3;
                PrintMethod(-1,ValueMulti);
                return;
            }
            else if(actionEventForCB.getSource()==slash)
            {
                fontSizeRestore();
                conditionForOperator=4;
                PrintMethod(-1,ValueSlash);
                return;
            }
            ////
            else if(actionEventForCB.getSource()==full_stop)
            {
                fontSizeRestore();
                PrintMethod(-1,ValueFull_Stop);
                return;
            }
            else if(actionEventForCB.getSource()==percent)
            {
                fontSizeRestore();
                conditionForOperator=5;
                PrintMethod(-1,ValuePercent);
                OperandStore(Integer.toString(ValueNine)); //For Direct action in Output
                calculationMethod();                      //For Direct action in Output
                return;
            }
        }
    }

    public void KeyPressAction(KeyEvent keyEvent)
    {
        //System.out.println(keyEvent.getCode().toString());
        if(keyEvent.getCode().toString().equals("DIGIT1") || keyEvent.getCode().toString().equals("NUMPAD1"))
        {
            PrintMethod(ValueOne,"Emran");
            OperandStore(Integer.toString(ValueOne));
            return;
        }
        else if(keyEvent.getCode().toString().equals("DIGIT2") || keyEvent.getCode().toString().equals("NUMPAD2"))
        {
            PrintMethod(ValueTwo,"Emran");
            OperandStore(Integer.toString(ValueTwo));
            return;
        }
        else if(keyEvent.getCode().toString().equals("DIGIT3") || keyEvent.getCode().toString().equals("NUMPAD3"))
        {
            PrintMethod(ValueThree,"Emran");
            OperandStore(Integer.toString(ValueThree));
            return;
        }
        else if(keyEvent.getCode().toString().equals("DIGIT4") || keyEvent.getCode().toString().equals("NUMPAD4"))
        {
            PrintMethod(ValueFour,"Emran");
            OperandStore(Integer.toString(ValueFour));
            return;
        }
        else if(keyEvent.getCode().toString().equals("DIGIT5") || keyEvent.getCode().toString().equals("NUMPAD5"))
        {
            PrintMethod(ValueFive,"Emran");
            OperandStore(Integer.toString(ValueFive));
            return;
        }
        else if(keyEvent.getCode().toString().equals("DIGIT6") || keyEvent.getCode().toString().equals("NUMPAD6"))
        {
            PrintMethod(ValueSix,"Emran");
            OperandStore(Integer.toString(ValueSix));
            return;
        }
        else if(keyEvent.getCode().toString().equals("DIGIT7") || keyEvent.getCode().toString().equals("NUMPAD7"))
        {
            PrintMethod(ValueSeven,"Emran");
            OperandStore(Integer.toString(ValueSeven));
            return;
        }
        else if(keyEvent.getCode().toString().equals("DIGIT8") || keyEvent.getCode().toString().equals("NUMPAD8"))
        {
            PrintMethod(ValueEight,"Emran");
            OperandStore(Integer.toString(ValueEight));
            return;
        }
        else if(keyEvent.getCode().toString().equals("DIGIT9") || keyEvent.getCode().toString().equals("NUMPAD9"))
        {
            PrintMethod(ValueNine,"Emran");
            OperandStore(Integer.toString(ValueNine));
            return;
        }
        else if(keyEvent.getCode().toString().equals("DIGIT0") || keyEvent.getCode().toString().equals("NUMPAD0"))
        {
            PrintMethod(ValueZero,"Emran");
            OperandStore(Integer.toString(ValueZero));
            return;
        }
        else if(keyEvent.getCode().toString().equals(ValueZeroZero))
        {
            PrintMethod(-1,ValueZeroZero);
            OperandStore(ValueZeroZero);
            return;
        }
        else if(keyEvent.getCode().toString().equals("DECIMAL"))
        {
            PrintMethod(-1,ValueFull_Stop);
            return;
        }
        else if(keyEvent.getCode().toString().equals("EQUALS"))
        {
            calculationMethod();
            userValue.setFont(new Font("Serif",13));
            output.setFont(new Font("Serif", 25));
            userValue.setText(userValue.getText());
            output.setText(String.valueOf(StoreCalculationValue));
            return;
        }
        else if(keyEvent.getCode().toString().equals(""))
        {
            PrintMethod(-1,ValuePercent);
            return;
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
            StoreCalculationValue=0;
            BeforeCalValue=0;
            AfterCalValue=0;
            userValue.setFont(new Font("Serif",19));
            output.setFont(new Font("Serif",19));
            userValue.setText("");
            output.setText("");
            SplitString="";
            return;
        }

        try {
            lastValue=userValue.getText().charAt(userValue.getText().length() - 1); //
        }catch (Exception e)
        {
            System.out.println("Error E2H");
            return;
        }

        if(lastValue=='+' || lastValue=='-' || lastValue=='x' || lastValue=='/')
        {
            System.out.println(userValue.getText().length());
            String RemoveValue=removeLastChar(userValue.getText());
            userValue.setText(RemoveValue);

            if(StoreCalculationValue==0)
            { BeforeCalValue= Double.parseDouble(SplitString); }
            else
            { BeforeCalValue=StoreCalculationValue; }

            SplitString="";

            if(keyEvent.getCode().toString().equals("MULTIPLY"))
            {
                conditionForOperator=3;
                PrintMethod(-1,ValueMulti);
                return;
            }
            else if(keyEvent.getCode().toString().equals("ADD"))
            {
                conditionForOperator=1;
                PrintMethod(-1,ValuePlus);
                return;
            }
            else if(keyEvent.getCode().toString().equals("SUBTRACT"))
            {
                conditionForOperator=2;
                PrintMethod(-1,ValueSubtraction);
                return;
            }

            else if(keyEvent.getCode().toString().equals("DIVIDE"))
            {
                conditionForOperator=4;
                PrintMethod(-1,ValueSlash);
                return;
            }
        }
        else
        {
            if(StoreCalculationValue==0)
            { BeforeCalValue= Double.parseDouble(SplitString); }
            else
            { BeforeCalValue=StoreCalculationValue; }


            SplitString="";

            if(keyEvent.getCode().toString().equals("MULTIPLY"))
            {
                conditionForOperator=3;
                PrintMethod(-1,ValueMulti);
                return;
            }
            else if(keyEvent.getCode().toString().equals("ADD"))
            {
                conditionForOperator=1;
                PrintMethod(-1,ValuePlus);
                return;
            }
            else if(keyEvent.getCode().toString().equals("SUBTRACT"))
            {
                conditionForOperator=2;
                PrintMethod(-1,ValueSubtraction);
                return;
            }

            else if(keyEvent.getCode().toString().equals("DIVIDE"))
            {
                conditionForOperator=4;
                PrintMethod(-1,ValueSlash);
                return;
            }
        }


    }

    private static String removeLastChar(String str) {
        return str.substring(0, str.length() - 1);
    }

    public void PrintMethod(int valueI,String valueS)
    {
        output.setText(String.valueOf(StoreCalculationValue));
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

    public void OperandStore(String Value)
    {
        SplitString=SplitString+Value;
        System.out.println("Connected:"+SplitString);
        calculationMethod();
        //calculationMethod(SplitString,PublicOperator);
        //return;
    }

    public void calculationMethod()
    {
        //System.out.println("conditionForOperator: "+conditionForOperator);
        double splitPartOne= Double.parseDouble(SplitString);

        AfterCalValue=splitPartOne;

        if(conditionForOperator==1)
        {
            StoreCalculationValue= BeforeCalValue+AfterCalValue;
            System.out.println("1...StoreCalculationValue: "+StoreCalculationValue);
        }
        else if(conditionForOperator==2)
        {
            StoreCalculationValue= BeforeCalValue-AfterCalValue;
            System.out.println("2...StoreCalculationValue: "+StoreCalculationValue);
        }
        else if(conditionForOperator==3)
        {
            StoreCalculationValue= BeforeCalValue*AfterCalValue;
            System.out.println("3...StoreCalculationValue: "+StoreCalculationValue);
        }
        else if(conditionForOperator==4)
        {
            StoreCalculationValue= BeforeCalValue/AfterCalValue;
            System.out.println("4...StoreCalculationValue: "+StoreCalculationValue);
        }
        else if(conditionForOperator==5)
        {
            StoreCalculationValue= BeforeCalValue/100;
        }
        output.setText(String.valueOf(StoreCalculationValue));

    }

    public void fontSizeRestore()
    {
        userValue.setFont(new Font("Serif",19));
        output.setFont(new Font("Serif",19));
    }

    //RunTimeFrame




}