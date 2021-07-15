package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;

import java.net.URL;
import java.util.Formatter;
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
    String ValueZeroZero="00",ValueFull_Stop="0.",ValueMulti="x",ValuePlus="+",ValueSubtraction="-",ValueEqual="=",ValueSlash="/",ValuePercent="%",ValueX="x",ValueAC= "";
    char lastValue;
    double StoreCalculationValue=0,BeforeCalValue,AfterCalValue;
    public String SplitString="";
    public String PublicOperator="NULL";
    //public String publicKeyBoardValue="Emran";
    public int conditionForOperator;

    String oneTTT= String.valueOf(one);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        x.setDisable(true);
        fontSizeRestore();
        System.out.println("oneTTT: "+oneTTT);
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
        System.out.println("KeyEvent HI");
        if(actionEventForCB.getSource()==one)
        {
            System.out.println("oneTTT: "+one);

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

            System.out.println("Hi Sure ");
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
        else if(actionEventForCB.getSource()==full_stop)
        {
            fontSizeRestore();
            if(userValue.getText().isEmpty() || getLastValue(userValue.getText()) == '+' ||  getLastValue(userValue.getText()) == '-' || getLastValue(userValue.getText()) == '*' || getLastValue(userValue.getText()) == '/' || getLastValue(userValue.getText()) == '%')
            {
                PrintMethod(-1,"0.");
                OperandStore("0.");
            }
            else
            {
                PrintMethod(-1,".");
                OperandStore(".");
            }
            return;
        }

        else if(actionEventForCB.getSource()==equal)
        {
            //calculationMethod();
            userValue.setFont(new Font("Serif",13));
            output.setFont(new Font("Serif", 25));
            userValue.setText(userValue.getText());
            output.setText(output.getText());
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
            conditionForOperator=10;
            StoreCalculationValue=0;
            BeforeCalValue=0;
            AfterCalValue=0;
            userValue.setText("");
            output.setText("");
            SplitString="";
            return;
        }

        lastValue= getLastValue(userValue.getText());

        //System.out.println("LastValue: "+lastValue);
        if(lastValue=='+' || lastValue=='-' || lastValue=='x' || lastValue=='/' || lastValue=='.' || lastValue=='%')
        {
            //System.out.println("Entry If ?");
            //System.out.println("userValue.getText() :"+userValue.getText());
            //When Already add any Operator then user again push to change this .. then this Function will be work
            String RemoveValue=removeLastChar(userValue.getText());
            //System.out.println("RemoveValue :"+RemoveValue);

            userValue.setText(RemoveValue);


            //System.out.println("Shit: "+lastValue);

            try {
                if(StoreCalculationValue==0)
                { BeforeCalValue= Double.parseDouble(SplitString); }
                else
                { BeforeCalValue=StoreCalculationValue; }

                SplitString="";
            }catch (Exception e)
            {
                System.out.println("Error E2H");
            }

            if(actionEventForCB.getSource()==plus)
            {
                //System.out.println("Hi Plus");
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
            else if(actionEventForCB.getSource()==percent)
            {
                userValue.setFont(new Font("Serif",13));
                output.setFont(new Font("Serif", 25));
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

            System.out.println("Else ?");

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
            else if(actionEventForCB.getSource()==percent)
            {
                userValue.setFont(new Font("Serif",13));
                output.setFont(new Font("Serif", 25));
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
        //publicKeyBoardValue=keyEvent.getCode().toString();
        if(keyEvent.getCode().toString().equals("DIGIT1") || keyEvent.getCode().toString().equals("NUMPAD1"))
        {
            fontSizeRestore();
            PrintMethod(ValueOne,"Emran");
            OperandStore(Integer.toString(ValueOne));
            return;
        }
        else if(keyEvent.getCode().toString().equals("DIGIT2") || keyEvent.getCode().toString().equals("NUMPAD2"))
        {
            fontSizeRestore();
            PrintMethod(ValueTwo,"Emran");
            OperandStore(Integer.toString(ValueTwo));
            return;
        }
        else if(keyEvent.getCode().toString().equals("DIGIT3") || keyEvent.getCode().toString().equals("NUMPAD3"))
        {
            fontSizeRestore();
            PrintMethod(ValueThree,"Emran");
            OperandStore(Integer.toString(ValueThree));
            return;
        }
        else if(keyEvent.getCode().toString().equals("DIGIT4") || keyEvent.getCode().toString().equals("NUMPAD4"))
        {

            fontSizeRestore();
            PrintMethod(ValueFour,"Emran");
            OperandStore(Integer.toString(ValueFour));
            return;
        }
        else if(keyEvent.getCode().toString().equals("DIGIT5") || keyEvent.getCode().toString().equals("NUMPAD5"))
        {
            fontSizeRestore();
            PrintMethod(ValueFive,"Emran");
            OperandStore(Integer.toString(ValueFive));
            return;
        }
        else if(keyEvent.getCode().toString().equals("DIGIT6") || keyEvent.getCode().toString().equals("NUMPAD6"))
        {
            fontSizeRestore();
            PrintMethod(ValueSix,"Emran");
            OperandStore(Integer.toString(ValueSix));
            return;
        }
        else if(keyEvent.getCode().toString().equals("DIGIT7") || keyEvent.getCode().toString().equals("NUMPAD7"))
        {
            fontSizeRestore();
            PrintMethod(ValueSeven,"Emran");
            OperandStore(Integer.toString(ValueSeven));
            return;
        }
        else if(keyEvent.getCode().toString().equals("DIGIT8") || keyEvent.getCode().toString().equals("NUMPAD8"))
        {
            fontSizeRestore();
            PrintMethod(ValueEight,"Emran");
            OperandStore(Integer.toString(ValueEight));
            return;
        }
        else if(keyEvent.getCode().toString().equals("DIGIT9") || keyEvent.getCode().toString().equals("NUMPAD9"))
        {
            fontSizeRestore();
            PrintMethod(ValueNine,"Emran");
            OperandStore(Integer.toString(ValueNine));
            return;
        }
        else if(keyEvent.getCode().toString().equals("DIGIT0") || keyEvent.getCode().toString().equals("NUMPAD0"))
        {
            fontSizeRestore();
            PrintMethod(ValueZero,"Emran");
            OperandStore(Integer.toString(ValueZero));
            return;
        }
        else if(keyEvent.getCode().toString().equals("DECIMAL"))
        {
            fontSizeRestore();
            if(userValue.getText().isEmpty() || getLastValue(userValue.getText()) == '+' ||  getLastValue(userValue.getText()) == '-' || getLastValue(userValue.getText()) == '*' || getLastValue(userValue.getText()) == '/' || getLastValue(userValue.getText()) == '%')
            {
                PrintMethod(-1,"0.");
                OperandStore("0.");
            }
            else
            {
                PrintMethod(-1,".");
                OperandStore(".");
            }
            return;
        }
        else if(keyEvent.getCode().toString().equals("EQUALS"))
        {
            //calculationMethod();
            userValue.setFont(new Font("Serif",13));
            output.setFont(new Font("Serif", 25));
            userValue.setText(userValue.getText());
            output.setText(output.getText());

            return;
        }

//        else if(keyEvent.getCode().toString().equals("ENTER")) //EnterButton==Equal
//        {
//            //calculationMethod();
//            //keyEvent.consume();
//            System.out.println("HI Enter");
//            userValue.setFont(new Font("Serif",13));
//            output.setFont(new Font("Serif", 25));
//            userValue.setText(userValue.getText());
//            output.setText(output.getText());
//
//            //return;
//        }

        else if(keyEvent.getCode().toString().equals("BACK_SPACE Not Working Now"))
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
        else if(keyEvent.getCode().toString().equals("ESCAPE") )
        {
            fontSizeRestore();
            conditionForOperator=10;
            StoreCalculationValue=0;
            BeforeCalValue=0;
            AfterCalValue=0;
            userValue.setText("");
            output.setText("");
            SplitString="";
            return;
        }

        else{
            System.out.println("NO BRO Wrong Press !!!");
        }
        lastValue= getLastValue(userValue.getText());

        //System.out.println("LastValue: "+lastValue);
        if(lastValue=='+' || lastValue=='-' || lastValue=='x' || lastValue=='/' || lastValue=='.' || lastValue=='%')
        {
            //System.out.println("Entry If ?");
            //System.out.println("userValue.getText() :"+userValue.getText());
            //When Already add any Operator then user again push to change this .. then this Function will be work
            String RemoveValue=removeLastChar(userValue.getText());
            //System.out.println("RemoveValue :"+RemoveValue);

            userValue.setText(RemoveValue);


            //System.out.println("Shit: "+lastValue);

            try {
                if(StoreCalculationValue==0)
                { BeforeCalValue= Double.parseDouble(SplitString); }
                else
                { BeforeCalValue=StoreCalculationValue; }

                SplitString="";
            }catch (Exception e)
            {
                System.out.println("Error E2H");
            }
            ////
            if(keyEvent.getCode().toString().equals("ADD"))
            {
                //System.out.println("Hi Plus");
                fontSizeRestore();
                conditionForOperator=1;
                PrintMethod(-1,ValuePlus);
                return;
            }
            else if(keyEvent.getCode().toString().equals("SUBTRACT"))
            {
                fontSizeRestore();
                conditionForOperator=2;
                PrintMethod(-1,ValueSubtraction);
                return;
            }
            else if(keyEvent.getCode().toString().equals("MULTIPLY"))
            {
                fontSizeRestore();
                conditionForOperator=3;
                PrintMethod(-1,ValueMulti);
                return;
            }
            else if(keyEvent.getCode().toString().equals("DIVIDE"))
            {
                fontSizeRestore();
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

            //System.out.println("Else ?");

            SplitString="";

            if(keyEvent.getCode().toString().equals("ADD"))
            {
                fontSizeRestore();
                conditionForOperator=1;
                PrintMethod(-1,ValuePlus);
                return;
            }
            else if(keyEvent.getCode().toString().equals("SUBTRACT"))
            {
                fontSizeRestore();
                conditionForOperator=2;
                PrintMethod(-1,ValueSubtraction);
                return;
            }
            else if(keyEvent.getCode().toString().equals("MULTIPLY"))
            {
                fontSizeRestore();
                conditionForOperator=3;
                PrintMethod(-1,ValueMulti);
                return;
            }
            else if(keyEvent.getCode().toString().equals("DIVIDE"))
            {
                fontSizeRestore();
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
        Formatter formatter = new Formatter();
        formatter.format("%.2f", StoreCalculationValue);

        //output.setText(formatter.toString());
        setOutput(formatter.toString());

//        if(getLastValue(formatter.toString())=='0')
//        {
//            Formatter formatter1 = new Formatter();
//            formatter.format("%.1f", StoreCalculationValue);
//            setOutput(formatter1.toString());
//        }
//        else{ setOutput(formatter.toString()); }


    }

    public void fontSizeRestore()
    {
        userValue.setFont(new Font("Serif",19));
        output.setFont(new Font("Serif",19));
    }

    public char getLastValue(String valueInString)
    {
        char StoreLastValue;
        try {
            StoreLastValue=valueInString.charAt(valueInString.length() - 1); //
            return StoreLastValue;
        }catch (Exception e)
        {
            System.out.println("Error E2H");
            return 'A';
        }
    }

    public void setOutput(String output1)
    {
        output.setText(output1);
    }

    




}