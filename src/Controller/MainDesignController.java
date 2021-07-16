package Controller;

import animatefx.animation.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
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

    @FXML
    Pane totalCalculatorView;

    /////////////////////////////////////////////////////////........Converter...........//////////////////////////////////////////////////////////////////////////
    @FXML
    Button currencyButton,lengthButton,areaButton,volumeButton,speedButton,timeButton,massButton,numeralButton,temperatureButton,converterACButton,converterButton,converterCLRButton;

    @FXML
    TextField convertInput;

    @FXML
    Label titleConverter;

    @FXML
    Pane singlePaneFor9Item;

    @FXML
    ComboBox<String> leftComboBox,RightComboBox;

    @FXML
    CheckBox firstCheckBox,SecondCheckBox;


    int ValueOne=1,ValueTwo=2,ValueThree=3,ValueFour=4,ValueFive=5,ValueSix=6,ValueSeven=7,ValueEight=8,ValueNine=9,ValueZero=0;
    String ValueZeroZero="00",ValueFull_Stop="0.",ValueMulti="x",ValuePlus="+",ValueSubtraction="-",ValueEqual="=",ValueSlash="/",ValuePercent="%",ValueX="x",ValueAC= "";
    char lastValue;
    double StoreCalculationValue=0,BeforeCalValue,AfterCalValue;
    public String SplitString="";
    public String PublicOperator="NULL";
    //public String publicKeyBoardValue="Emran";
    public int conditionForOperator;
    String PO1="Don't have any Previous Output",PO2="Don't have any Previous Output";

    /////////////////////////////
    ObservableList<String> CurrencyList= FXCollections.observableArrayList( "Afghan Afghani", "Albanian Lek", "Algerian Dinar", "Angolan Kwanza", "Argentine Peso"," Armenian Dram", "Aruban Florinm",
            "Australian Dollar", "Azerbaijani Manat", "Bahamian Dollar", "Bahraini Dinar", "Bajan dollar", "Bangladeshi Taka", "Belarusian Ruble", "Belize Dollar", "Bermudan Dollar", "Bhutan currency", "Bitcoin",
            "Bitcoin Cash","Bolivian Bolivian", "Bosnia-Herzegovina Convertible Mark", "Botswanan Pula", "Brazilian Real","Brunei Dollar Bulgarian Lev","Burundian Franc", "CFP Franc", "Cambodian Riel", "Canadian Dollar", "Cape Verdean Escudo", "Cayman Islands Dollar",
            "Central African CFA franc", "Chilean Peso", "Chilean Unit of Account (UF)", "Chinese Yuan", "Chinese Yuan (offshore)", "Colombian Peso", "Comorian franc", "Congolese Franc",
            "Costa Rican Colds", "Croatian Kuna", "Cuban Peso"," Czech Koruna", "Danish Krone"," Djiboutian Franc"," Dominican Peso", "East Caribbean Dollar"," Egyptian Pound", "Ether", "Ethiopian Birr", "Euro",
            "Fijian Dollar", "Gambian dalasi", "Georgian Lari", "Ghanaian Cedi", "Guatemalan Quetzal", "Guinean Franc", "Guyanaese Dollar", "Haitian Gourde",
            "Honduran Lempira", "Hong Kong Dollar","Hungarian Forint", "Icelandic Kr6na", "Indian Rupee", "Indonesian Rupiah", "Iranian Rial", "Iraqi Dinar", "Israeli New Shekel",
            "Jamaican Dollar", "Japanese Yen", "Jordanian Dinar", "Kazakhstani Tenge", "Kenyan Shilling", "Kuwaiti Dinar", "Kyrgystani Som", "Laotian Kip", "Lebanese pound", "Lesotho loti","Liberian Dollar",
            "Swedish Krona", "Swiss Franc",
            "Tajikistani Somoni", "Tanzanian Shilling","Thai Bahl", "Tongan Pa'anga Trinidad & Tobago Dollar", "Tunisian Dinar" ,"Turkish lira",
            "Turkmenistani manat", "Ugandan Shilling", "Ukrainian hryvnia", "United Arab Emirates Dirham", "United States Dollar", "Uruguayan Peso", "Uzbekistani Som", "Vietnamese dong West", "African CFA franc", "Yemeni Rial", "Zambian Kwacha"
            );
    ObservableList<String> TemperatureList= FXCollections.observableArrayList("Celsius","Fahrenheit","Kelvin");
    ObservableList<String> TimeList= FXCollections.observableArrayList("Nanosecond", "Microsecond", "Millisecond", "Second", "Minute", "Hour", "Day", "Week", "Month", "Calendar", "year", "Decade", "Century");
    ObservableList<String> SpeedList= FXCollections.observableArrayList("Miles per hour" ,"Foot per second", "Meter per second", "Kilometer per hour", "Knot" );
    ObservableList<String> LengthList= FXCollections.observableArrayList("kilometre", "Meter", "Centimeter", "Millimetre", "micrometres", "Nanometre", "Mile", "Yard", "Foot", "Inch", "Nautical", "mile" );
    ObservableList<String> AreaList= FXCollections.observableArrayList("Square kilometer" ,"Square meter", "Square mile", "Square yard", "Square foot", "Square inch", "Hectare", "Acre" );
    ObservableList<String> VolumeList= FXCollections.observableArrayList("US liquid gallon"," US liquid quart", "US liquid pint", "US legal cup", "fluid ounce", "US tablespoon", "US teaspoon", "Cubic meter",
            "Liter", "Milliliter", "Imperial gallon", "imp. quart", "Imperial pint", "Imperial cup", "fluid ounce", "Imperial tablespoon", "Imperial teaspoon", "Cubic foot", "Cubic inch" );
    ObservableList<String> NumeralList= FXCollections.observableArrayList("Binary" ,"Octal" ,"Decimal", "Hexadecimal" );
    ObservableList<String> MassList= FXCollections.observableArrayList("tonne", "Kilogram", "Gram", "Milligram", "Microgram", "Imperial ton", "US ton", "Stone", "Pound", "Ounce" );

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //x.setDisable(true);
        fontSizeRestore();
        //System.out.println("oneTTT: "+oneTTT);

    }



    public void ActionEvent(ActionEvent actionEvent)
    {
        if(actionEvent.getSource()==CalculatorButton)
        {
            CalculatorPane.toFront();
            ConverterPane.toBack();
            MortgagePane.toBack();
            new Flip(totalCalculatorView).play();

        }
        else if(actionEvent.getSource()==ConverterButton)
        {
            ConverterPane.toFront();
            CalculatorPane.toBack();
            MortgagePane.toBack();
            AnimationEffect(currencyButton,lengthButton,areaButton,volumeButton,speedButton,timeButton,massButton,numeralButton,temperatureButton);
        }
        else if(actionEvent.getSource()==MortgageButton)
        {
            MortgagePane.toFront();
            ConverterPane.toBack();
            CalculatorPane.toBack();
        }
    }
    void AnimationEffect(Button currencyButton, Button lengthButton, Button areaButton, Button volumeButton, Button speedButton, Button timeButton, Button massButton, Button numeralButton, Button temperatureButton)
    {
        new Wobble(currencyButton).play();
        new Wobble(lengthButton).play();
        new Wobble(areaButton).play();
        new Wobble(volumeButton).play();
        new Wobble(speedButton).play();
        new Wobble(timeButton).play();
        new Wobble(massButton).play();
        new Wobble(numeralButton).play();
        new Wobble(temperatureButton).play();
    }

    public void CalculatorButtonAction(ActionEvent actionEventForCB)
    {
        userValue.setTextFill(Color.web("#1D1D1D", 1));
        output.setTextFill(Color.web("#1D1D1D", 1));
        if(actionEventForCB.getSource()==one)
        {
            CheckPO();
            fontSizeRestore();
            PrintMethod(ValueOne,"Emran");
            OperandStore(Integer.toString(ValueOne));
            return;
        }
        else if(actionEventForCB.getSource()==two)
        {
            CheckPO();
            fontSizeRestore();
            PrintMethod(ValueTwo,"Emran");
            OperandStore(Integer.toString(ValueTwo));
            return;
        }
        else if(actionEventForCB.getSource()==three)
        {
            CheckPO();
            fontSizeRestore();
            PrintMethod(ValueThree,"Emran");
            OperandStore(Integer.toString(ValueThree));
            return;
        }
        else if(actionEventForCB.getSource()==four)
        {
            CheckPO();
            fontSizeRestore();
            PrintMethod(ValueFour,"Emran");
            OperandStore(Integer.toString(ValueFour));
            return;
        }
        else if(actionEventForCB.getSource()==five)
        {
            CheckPO();
            fontSizeRestore();
            PrintMethod(ValueFive,"Emran");
            OperandStore(Integer.toString(ValueFive));
            return;

        }
        else if(actionEventForCB.getSource()==six)
        {
            CheckPO();
            fontSizeRestore();
            PrintMethod(ValueSix,"Emran");
            OperandStore(Integer.toString(ValueSix));
            return;
        }
        else if(actionEventForCB.getSource()==seven)
        {
            CheckPO();
            fontSizeRestore();
            PrintMethod(ValueSeven,"Emran");
            OperandStore(Integer.toString(ValueSeven));
            return;
        }
        else if(actionEventForCB.getSource()==eight)
        {
            CheckPO();
            fontSizeRestore();
            PrintMethod(ValueEight,"Emran");
            OperandStore(Integer.toString(ValueEight));
            return;
        }
        else if(actionEventForCB.getSource()==nine)
        {
            CheckPO();
            fontSizeRestore();
            PrintMethod(ValueNine,"Emran");
            OperandStore(Integer.toString(ValueNine));
            return;
        }
        else if(actionEventForCB.getSource()==zero)
        {
            CheckPO();
            fontSizeRestore();
            PrintMethod(ValueZero,"Emran");
            OperandStore(Integer.toString(ValueZero));
            return;
        }
        else if(actionEventForCB.getSource()==zero_zero)
        {
            CheckPO();
            fontSizeRestore();
            PrintMethod(-1,ValueZeroZero);
            OperandStore(ValueZeroZero);
            return;
        }
        else if(actionEventForCB.getSource()==full_stop)
        {
            CheckPO();
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
            if(lastValue=='A')
            {
                output.setText("");
                userValue.setText("");
            } //This Condition Similar to 372 line to 380 line
            userValue.setFont(new Font("Serif",13));
            output.setFont(new Font("Serif", 25));
            userValue.setText(userValue.getText());
            output.setText(output.getText());
            return;
        }
        else if(actionEventForCB.getSource()==x)
        {
            if(PO2.equals("Don't have any Previous Output") || PO1.equals("Don't have any Previous Output"))
            {
                output.setFont(new Font("Serif", 25));
                output.setTextFill(Color.web("#ff6600", 1));
                output.setText(PO2);
                userValue.setText("");
                return;
            }
            else
            {
                userValue.setFont(new Font("Serif",13));
                output.setFont(new Font("Serif", 25));
                userValue.setTextFill(Color.web("#ff6600", 0.9));
                output.setTextFill(Color.web("#ff6600", 1));
                userValue.setText(PO1);
                output.setText("=> It’s just an (Previous Output)             "+PO2);
                return;
            }

            //When Using Remove Elements...
//            if(userValue.getText().length()==0 || userValue.getText().length()==1) {
//                userValue.setText("");
//                return; }
//            else
//            { String RemoveValue=removeLastChar(userValue.getText());  userValue.setText(RemoveValue); }
        }
        else if(actionEventForCB.getSource()==ac)
        {
            if(PO1==userValue.getText() || PO2==output.getText()) {  }
            else if(userValue.getText().isEmpty() || output.getText().isEmpty()){  }
            else { PO1=userValue.getText(); PO2=output.getText(); }

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
        System.out.println("LastValue: "+lastValue);

        if(!(lastValue =='A')) //When A then get Exception and this Condition Will break this Problems
        {
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
                    {
                        if(StoreCalculationValue==0.0 && BeforeCalValue==AfterCalValue)
                        {
                            BeforeCalValue=0.0;
                            System.out.println("BeforeCalValue:  "+BeforeCalValue);
                        }
                        else
                        {
                            BeforeCalValue= Double.parseDouble(SplitString);
                            System.out.println("If BeforeCalValue: "+BeforeCalValue);
                        }

                    }
                    else
                    {
                        if(StoreCalculationValue==0.0 && BeforeCalValue==AfterCalValue)
                        {
                            BeforeCalValue=0.0;
                            System.out.println("BeforeCalValue:  "+BeforeCalValue);
                        }
                        else
                        {
                            BeforeCalValue=StoreCalculationValue;
                            System.out.println("else BeforeCalValue: "+BeforeCalValue);
                        }

                    }

                    SplitString="";
                }catch (Exception e)
                {
                    System.out.println("Error E2H 265");
                }

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
                CheckPO();
                try {


                    if(StoreCalculationValue==0)
                    {
                        if(StoreCalculationValue==0.0 && BeforeCalValue==AfterCalValue)
                        {
                            BeforeCalValue=0.0;
                            System.out.println("BeforeCalValue:  "+BeforeCalValue);
                        }
                        else
                        {
                            BeforeCalValue= Double.parseDouble(SplitString);
                            System.out.println("If BeforeCalValue: "+BeforeCalValue);
                        }

                    }
                    else
                    {
                        if(StoreCalculationValue==0.0 && BeforeCalValue==AfterCalValue)
                        {
                            BeforeCalValue=0.0;
                            System.out.println("BeforeCalValue:  "+BeforeCalValue);
                        }
                        else
                        {
                            BeforeCalValue=StoreCalculationValue;
                            System.out.println("else BeforeCalValue: "+BeforeCalValue);
                        }

                    }

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
                }catch (Exception e)
                {
                    System.out.println("Error E2H 365");
                }


            }
        }
        else
        {
            output.setText("");
            userValue.setText("");
            //PO1=""; PO2="";
        }


    }

    public void KeyPressAction(KeyEvent keyEvent)
    {
        userValue.setTextFill(Color.web("#1D1D1D", 1));
        output.setTextFill(Color.web("#1D1D1D", 1));
        //System.out.println(keyEvent.getCode().toString());
        //publicKeyBoardValue=keyEvent.getCode().toString();
        if(keyEvent.getCode().toString().equals("DIGIT1") || keyEvent.getCode().toString().equals("NUMPAD1"))
        {
            CheckPO();
            fontSizeRestore();
            PrintMethod(ValueOne,"Emran");
            OperandStore(Integer.toString(ValueOne));
            return;
        }
        else if(keyEvent.getCode().toString().equals("DIGIT2") || keyEvent.getCode().toString().equals("NUMPAD2"))
        {
            CheckPO();
            fontSizeRestore();
            PrintMethod(ValueTwo,"Emran");
            OperandStore(Integer.toString(ValueTwo));
            return;
        }
        else if(keyEvent.getCode().toString().equals("DIGIT3") || keyEvent.getCode().toString().equals("NUMPAD3"))
        {
            CheckPO();
            fontSizeRestore();
            PrintMethod(ValueThree,"Emran");
            OperandStore(Integer.toString(ValueThree));
            return;
        }
        else if(keyEvent.getCode().toString().equals("DIGIT4") || keyEvent.getCode().toString().equals("NUMPAD4"))
        {
            CheckPO();
            fontSizeRestore();
            PrintMethod(ValueFour,"Emran");
            OperandStore(Integer.toString(ValueFour));
            return;
        }
        else if(keyEvent.getCode().toString().equals("DIGIT5") || keyEvent.getCode().toString().equals("NUMPAD5"))
        {
            CheckPO();
            fontSizeRestore();
            PrintMethod(ValueFive,"Emran");
            OperandStore(Integer.toString(ValueFive));
            return;
        }
        else if(keyEvent.getCode().toString().equals("DIGIT6") || keyEvent.getCode().toString().equals("NUMPAD6"))
        {
            CheckPO();
            fontSizeRestore();
            PrintMethod(ValueSix,"Emran");
            OperandStore(Integer.toString(ValueSix));
            return;
        }
        else if(keyEvent.getCode().toString().equals("DIGIT7") || keyEvent.getCode().toString().equals("NUMPAD7"))
        {
            CheckPO();
            fontSizeRestore();
            PrintMethod(ValueSeven,"Emran");
            OperandStore(Integer.toString(ValueSeven));
            return;
        }
        else if(keyEvent.getCode().toString().equals("DIGIT8") || keyEvent.getCode().toString().equals("NUMPAD8"))
        {
            CheckPO();
            fontSizeRestore();
            PrintMethod(ValueEight,"Emran");
            OperandStore(Integer.toString(ValueEight));
            return;
        }
        else if(keyEvent.getCode().toString().equals("DIGIT9") || keyEvent.getCode().toString().equals("NUMPAD9"))
        {
            CheckPO();
            fontSizeRestore();
            PrintMethod(ValueNine,"Emran");
            OperandStore(Integer.toString(ValueNine));
            return;
        }
        else if(keyEvent.getCode().toString().equals("DIGIT0") || keyEvent.getCode().toString().equals("NUMPAD0"))
        {
            CheckPO();
            fontSizeRestore();
            PrintMethod(ValueZero,"Emran");
            OperandStore(Integer.toString(ValueZero));
            return;
        }
        else if(keyEvent.getCode().toString().equals("DECIMAL"))
        {
            CheckPO();
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
        }//////////
        else if(keyEvent.getCode().toString().equals("EQUALS"))
        {
            if(lastValue=='A')
            {
                output.setText("");
                userValue.setText("");
            } //This Condition Similar to 372 line to 380 line
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

        else if(keyEvent.getCode().toString().equals("BACK_SPACE"))
        {
            if(PO2.equals("Don't have any Previous Output") || PO1.equals("Don't have any Previous Output"))
            {
                output.setFont(new Font("Serif", 25));
                output.setTextFill(Color.web("#ff6600", 1));
                output.setText(PO2);
                userValue.setText("");
                return;
            }
            else
            {
                if(PO2.equals("Don't have any Previous Output") || PO1.equals("Don't have any Previous Output"))
                {
                    output.setFont(new Font("Serif", 25));
                    output.setTextFill(Color.web("#ff6600", 1));
                    output.setText(PO2);
                    userValue.setText("");
                    return;
                }
                else
                {
                    userValue.setFont(new Font("Serif",13));
                    output.setFont(new Font("Serif", 25));
                    userValue.setTextFill(Color.web("#ff6600", 0.9));
                    output.setTextFill(Color.web("#ff6600", 1));
                    userValue.setText(PO1);
                    output.setText("=> It’s just an (Previous Output)             "+PO2);
                    return;
                }

                //When Using Remove Elements...
//            if(userValue.getText().length()==0 || userValue.getText().length()==1) {
//                userValue.setText("");
//                return; }
//            else
//            { String RemoveValue=removeLastChar(userValue.getText());  userValue.setText(RemoveValue); }
            }
        }
        else if(keyEvent.getCode().toString().equals("ESCAPE") )
        {
            if(PO1==userValue.getText() || PO2==output.getText()) {  }
            else if(userValue.getText().isEmpty() || output.getText().isEmpty()){  }
            else { PO1=userValue.getText(); PO2=output.getText(); }

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
        System.out.println("LastValue: "+lastValue);

        if(!(lastValue =='A')) //When A then get Exception and this Condition Will break this Problems
        {
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
                    {
                        if(StoreCalculationValue==0.0 && BeforeCalValue==AfterCalValue)
                        {
                            BeforeCalValue=0.0;
                            System.out.println("BeforeCalValue:  "+BeforeCalValue);
                        }
                        else
                        {
                            BeforeCalValue= Double.parseDouble(SplitString);
                            System.out.println("If BeforeCalValue: "+BeforeCalValue);
                        }

                    }
                    else
                    {
                        if(StoreCalculationValue==0.0 && BeforeCalValue==AfterCalValue)
                        {
                            BeforeCalValue=0.0;
                            System.out.println("BeforeCalValue:  "+BeforeCalValue);
                        }
                        else
                        {
                            BeforeCalValue=StoreCalculationValue;
                            System.out.println("else BeforeCalValue: "+BeforeCalValue);
                        }

                    }


                    SplitString="";
                }catch (Exception e)
                {
                    System.out.println("Error E2H 600+");
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
                CheckPO();
                try {

                    if(StoreCalculationValue==0)
                    {
                        if(StoreCalculationValue==0.0 && BeforeCalValue==AfterCalValue)
                        {
                            BeforeCalValue=0.0;
                            System.out.println("BeforeCalValue:  "+BeforeCalValue);
                        }
                        else
                        {
                            BeforeCalValue= Double.parseDouble(SplitString);
                            System.out.println("If BeforeCalValue: "+BeforeCalValue);
                        }

                    }
                    else
                    {
                        if(StoreCalculationValue==0.0 && BeforeCalValue==AfterCalValue)
                        {
                            BeforeCalValue=0.0;
                            System.out.println("BeforeCalValue:  "+BeforeCalValue);
                        }
                        else
                        {
                            BeforeCalValue=StoreCalculationValue;
                            System.out.println("else BeforeCalValue: "+BeforeCalValue);
                        }

                    }

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
                }catch (Exception e)
                {
                    System.out.println("Error E2H 650+");
                }

            }
        }//if(!(lastValue =='A'))
        else
        {
            output.setText("");
            userValue.setText("");
            //PO1=""; PO2="";
        }



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

        AfterCalValue=splitPartOne; //Split Done Now Store After Value...

        if(conditionForOperator==1)
        {
            StoreCalculationValue= BeforeCalValue+AfterCalValue;
            System.out.println("+1...StoreCalculationValue: "+StoreCalculationValue);
            System.out.println("+2...BeforeCalValue: "+BeforeCalValue);
            System.out.println("+3...AfterCalValue: "+AfterCalValue);

        }
        else if(conditionForOperator==2)
        {
            StoreCalculationValue= BeforeCalValue-AfterCalValue;
            System.out.println("-1...StoreCalculationValue: "+StoreCalculationValue);
            System.out.println("-2...BeforeCalValue: "+BeforeCalValue);
            System.out.println("-3...AfterCalValue: "+AfterCalValue);
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

    private static String removeLastChar(String str) {
        return str.substring(0, str.length() - 1);
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

    public void CheckPO()
    {
        if(!PO2.equals("Don't have any Previous Output") || !PO1.equals("Don't have any Previous Output"))
        {
            System.out.println("Cooooollllllll");
            output.setText("");
            userValue.setText("");
            PO1="Don't have any Previous Output";
            PO2="Don't have any Previous Output";
        }
    }



    /////////////////////////////////////////////////////////........Converter...........//////////////////////////////////////////////////////////////////////////
    public void KeyTypeAction(KeyEvent keyTypeAction)
    {
        try{
            convertInput.textProperty().addListener(new ChangeListener<String>() {
                @Override
                public void changed(ObservableValue<? extends String> observable, String oldValue,
                                    String newValue) {
                    if (!newValue.matches("\\d*")) {
                        convertInput.setText(newValue.replaceAll("[^\\d]", ""));
                    }
                }
            });
        }catch (Exception e)
        {
            System.out.println("Line 950+: "+e.toString());
        }
    }
    public void ConverterButtonActionEvent(ActionEvent event_CBC)
    {
        if(event_CBC.getSource()==currencyButton)
        {
            CategoryWiseChange("Currency",CurrencyList);
            //CheckBoXSelect();
        }
        else if(event_CBC.getSource()==lengthButton)
        {
            CategoryWiseChange("Length",LengthList);
        }
        else if(event_CBC.getSource()==areaButton)
        {
            CategoryWiseChange("Area",AreaList);
        }
        else if(event_CBC.getSource()==volumeButton)
        {
            CategoryWiseChange("Volume",VolumeList);
        }
        else if(event_CBC.getSource()==speedButton)
        {
            CategoryWiseChange("Speed",SpeedList);
        }
        else if(event_CBC.getSource()==timeButton)
        {
            CategoryWiseChange("Time",TimeList);
        }
        else if(event_CBC.getSource()==massButton)
        {
            CategoryWiseChange("Mass",MassList);
        }
        else if(event_CBC.getSource()==numeralButton)
        {
            CategoryWiseChange("Numeral",NumeralList);
        }
        else if(event_CBC.getSource()==temperatureButton)
        {
            CategoryWiseChange("Temperature",TemperatureList);
        }
        else if(event_CBC.getSource()==leftComboBox || event_CBC.getSource()==RightComboBox)
        {
            CheckBoXSelect();
        }
        else if(event_CBC.getSource()==firstCheckBox)
        {
            firstCheckBox.setSelected(true);
            SecondCheckBox.setSelected(false);
            firstCheckBox.setStyle("-fx-text-fill: #ff6600;");
            SecondCheckBox.setStyle("-fx-text-fill: #0a0a0a;");
        }
        else if(event_CBC.getSource()==SecondCheckBox)
        {
            SecondCheckBox.setSelected(true);
            firstCheckBox.setSelected(false);
            firstCheckBox.setStyle("-fx-text-fill: #0a0a0a;");
            SecondCheckBox.setStyle("-fx-text-fill: #ff6600;");

        }
//        ////////////////////////////////////////////////
//        else if(event_CBC.getSource()==converterACButton)
//        {
//
//        }
//        else if(event_CBC.getSource()==converterButton)
//        {
//
//        }
//        else if(event_CBC.getSource()==converterCLRButton)
//        {
//
//        }

    }


    void CategoryWiseChange(String category, ObservableList<String> categoryList)
    {
        //Flip,
        new Flip(singlePaneFor9Item).play();
        titleConverter.setText(category+" Converter");
        leftComboBox.setItems(categoryList);
        RightComboBox.setItems(categoryList);
        leftComboBox.setPromptText(categoryList.get(0));
        RightComboBox.setPromptText(categoryList.get(0));
    }

    void CheckBoXSelect()
    {
        String leftComboValue,RightComboValue;
        leftComboValue=leftComboBox.getSelectionModel().getSelectedItem();
        RightComboValue=RightComboBox.getSelectionModel().getSelectedItem();
        if(leftComboValue==null || RightComboValue==null)
        {
            System.out.println("Cool: "+leftComboBox.getItems());
        }else
        {
            firstCheckBox.setText(leftComboValue+" to "+RightComboValue);
            SecondCheckBox.setText(RightComboValue+" to "+leftComboValue);
        }

    }














}