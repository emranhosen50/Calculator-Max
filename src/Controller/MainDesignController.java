package Controller;

import MainClass.ConnectMySQL;
import animatefx.animation.*;
import com.jfoenix.controls.JFXButton;
import javafx.animation.TranslateTransition;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Formatter;
import java.util.Objects;
import java.util.ResourceBundle;


public class MainDesignController implements Initializable
{
    @FXML
    Pane CalculatorPane, ConverterPane, MortgagePane,AboutPane;

//    @FXML
//    Button CalculatorButton,ConverterButton,MortgageButton;

    @FXML
    JFXButton CalculatorButton,ConverterButton,MortgageButton,logOut,About;

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
    Label titleConverter,ConvertDisplay;

    @FXML
    Pane singlePaneFor9Item,animationADD_pane;

    @FXML
    ComboBox<String> leftComboBox,RightComboBox;

    @FXML
    CheckBox firstCheckBox,SecondCheckBox;

    public Text adminText;


    int ValueOne=1,ValueTwo=2,ValueThree=3,ValueFour=4,ValueFive=5,ValueSix=6,ValueSeven=7,ValueEight=8,ValueNine=9,ValueZero=0;
    String ValueZeroZero="00",ValueFull_Stop="0.",ValueMulti="x",ValuePlus="+",ValueSubtraction="-",ValueEqual="=",ValueSlash="/",ValuePercent="%",ValueX="x",ValueAC= "";
    char lastValue;
    double StoreCalculationValue=0,BeforeCalValue,AfterCalValue;
    public String SplitString="";
    public String PublicOperator="NULL";
    //public String publicKeyBoardValue="Emran";
    public int conditionForOperator;
    String PO1="Don't have any Previous Output",PO2="Don't have any Previous Output";
    ObservableList<String> GlobalCategoryList;
    String leftComboValue,RightComboValue;
    boolean leftOrRight=true;

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

    double mouseX,mouseY;
    @FXML
    Label close,minimize,TitleText;

    @FXML
    private Button menu;
    @FXML
    private AnchorPane drawer;

    ConnectMySQL Con=new ConnectMySQL(); //Public SQLDatabase Connection

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Con.createConnection();
        AdminPresentOrNot();
        TitleText.setText("Max Calculator");
        CalculatorPane.toFront();
        fontSizeRestore();
        drawerAction();

        //CalculatorButton,ConverterButton,MortgageButton
//        CalculatorButton.setStyle("-fx-background-color : rgba(25, 45, 50, 1.0);");
//        ConverterButton.setStyle("-fx-background-color : rgba(76, 175, 80, 0.0);");
//        MortgageButton.setStyle("-fx-background-color : rgba(76, 175, 80, 0.0);");


        ////////////////////////////////
        titleConverter.setText("Currency"+" Converter");
        leftComboBox.setItems(CurrencyList);
        RightComboBox.setItems(CurrencyList);
        leftComboBox.setPromptText(CurrencyList.get(0));
        RightComboBox.setPromptText(CurrencyList.get(0));

        firstCheckBox.setText(CurrencyList.get(0)+" to "+CurrencyList.get(0));
        SecondCheckBox.setText(CurrencyList.get(0)+" to "+CurrencyList.get(0));
        GlobalCategoryList=CurrencyList;

        firstCheckBox.setSelected(true);
        firstCheckBox.setStyle("-fx-text-fill: #ff6600;");

        animationTow(-155); //Initial Button Animation..

    }
    private void drawerAction() {

        TranslateTransition openNav = new TranslateTransition(new Duration(350), drawer);
        openNav.setToX(0);
        TranslateTransition closeNav = new TranslateTransition(new Duration(350), drawer);
        menu.setOnAction((ActionEvent evt) -> {
            if (drawer.getTranslateX() != 0) {
                openNav.play();
            } else {
                closeNav.setToX(-(drawer.getWidth()));
                closeNav.play();
            }
        });
    }

    void animationTow(int value)
    {
        TranslateTransition transition =new TranslateTransition();
        transition.setDuration(Duration.millis(300));
        transition.setNode(animationADD_pane);

        transition.setToY(value);
        //transition.setByX(-50);

        transition.play();
    }

    public void ActionEvent(ActionEvent actionEvent)
    {
        if(actionEvent.getSource()==CalculatorButton)
        {
            CalculatorPane.toFront();
            ConverterPane.toBack();
            MortgagePane.toBack();
            new Shake(totalCalculatorView).play();
            TitleText.setText("Max Calculator");

            //Animation 2
            animationTow(-155);

//            CalculatorButton.setStyle("-fx-background-color : rgba(25, 45, 50, 1.0);");
//            ConverterButton.setStyle("-fx-background-color : rgba(76, 175, 80, 0.0);");
//            new SlideInDown(ConverterButton).play();

        }
        else if(actionEvent.getSource()==ConverterButton)
        {
            ConverterPane.toFront();
            CalculatorPane.toBack();
            MortgagePane.toBack();
            AboutPane.toBack();
            TitleText.setText("Converter");
            AnimationEffect(currencyButton,lengthButton,areaButton,volumeButton,speedButton,timeButton,massButton,numeralButton,temperatureButton);

            animationTow(-101);


//            new SlideInUp(CalculatorButton).play();
//            ConverterButton.setStyle("-fx-background-color : rgba(25, 45, 50, 1.0);");
//            CalculatorButton.setStyle("-fx-background-color : rgba(76, 175, 80, 0.0);");

        }
        else if(actionEvent.getSource()==MortgageButton)
        {
            MortgagePane.toFront();
            ConverterPane.toBack();
            CalculatorPane.toBack();
            AboutPane.toBack();
            TitleText.setText("Mortgage");

            animationTow(-51);

        }
        else if(actionEvent.getSource()==logOut)
        {
            animationTow(51);
            LogOutMethod(actionEvent);
        }
        else if(actionEvent.getSource()==About)
        {
            AboutPane.toFront();
            MortgagePane.toBack();
            ConverterPane.toBack();
            CalculatorPane.toBack();
            TitleText.setText("About");
            animationTow(125);
        }
    }//ActionEvent

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
    }//AnimationEffect

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
            lastValue='A';
            System.out.println("CLEAR\n\n\n");
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
                System.out.println("subtraction  Else Login 2");
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
                    if(StoreCalculationValue==0)
                    {
                        BeforeCalValue=StoreCalculationValue;
                        System.out.println("Yes");
                    }
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
                System.out.println("subtraction  Else Login 3");
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
                        if(StoreCalculationValue==0)
                        {
                            BeforeCalValue=StoreCalculationValue;
                            System.out.println("Yes");
                        }
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
            if(actionEventForCB.getSource()==subtraction)
            {
                System.out.println("subtraction  Else Login 1");
                if(userValue.getText().isEmpty() ||  getLastValue(userValue.getText()) == '-' )
                {
                    fontSizeRestore();
                    conditionForOperator=2;
                    PrintMethod(-1,"0-");
                }
                return;

            }
        }


    }//CalculatorButtonAction

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
            new FadeIn(one).play();
            return;
        }
        else if(keyEvent.getCode().toString().equals("DIGIT2") || keyEvent.getCode().toString().equals("NUMPAD2"))
        {
            CheckPO();
            fontSizeRestore();
            PrintMethod(ValueTwo,"Emran");
            OperandStore(Integer.toString(ValueTwo));
            new FadeIn(two).play();
            return;
        }
        else if(keyEvent.getCode().toString().equals("DIGIT3") || keyEvent.getCode().toString().equals("NUMPAD3"))
        {
            CheckPO();
            fontSizeRestore();
            PrintMethod(ValueThree,"Emran");
            OperandStore(Integer.toString(ValueThree));
            new FadeIn(three).play();
            return;
        }
        else if(keyEvent.getCode().toString().equals("DIGIT4") || keyEvent.getCode().toString().equals("NUMPAD4"))
        {
            CheckPO();
            fontSizeRestore();
            PrintMethod(ValueFour,"Emran");
            OperandStore(Integer.toString(ValueFour));
            new FadeIn(four).play();
            return;
        }
        else if(keyEvent.getCode().toString().equals("DIGIT5") || keyEvent.getCode().toString().equals("NUMPAD5"))
        {
            CheckPO();
            fontSizeRestore();
            PrintMethod(ValueFive,"Emran");
            OperandStore(Integer.toString(ValueFive));
            new FadeIn(five).play();
            return;
        }
        else if(keyEvent.getCode().toString().equals("DIGIT6") || keyEvent.getCode().toString().equals("NUMPAD6"))
        {
            CheckPO();
            fontSizeRestore();
            PrintMethod(ValueSix,"Emran");
            OperandStore(Integer.toString(ValueSix));
            new FadeIn(six).play();
            return;
        }
        else if(keyEvent.getCode().toString().equals("DIGIT7") || keyEvent.getCode().toString().equals("NUMPAD7"))
        {
            CheckPO();
            fontSizeRestore();
            PrintMethod(ValueSeven,"Emran");
            OperandStore(Integer.toString(ValueSeven));
            new FadeIn(seven).play();
            return;
        }
        else if(keyEvent.getCode().toString().equals("DIGIT8") || keyEvent.getCode().toString().equals("NUMPAD8"))
        {
            CheckPO();
            fontSizeRestore();
            PrintMethod(ValueEight,"Emran");
            OperandStore(Integer.toString(ValueEight));
            new FadeIn(eight).play();
            return;
        }
        else if(keyEvent.getCode().toString().equals("DIGIT9") || keyEvent.getCode().toString().equals("NUMPAD9"))
        {
            CheckPO();
            fontSizeRestore();
            PrintMethod(ValueNine,"Emran");
            OperandStore(Integer.toString(ValueNine));
            new FadeIn(nine).play();
            return;
        }
        else if(keyEvent.getCode().toString().equals("DIGIT0") || keyEvent.getCode().toString().equals("NUMPAD0"))
        {
            CheckPO();
            fontSizeRestore();
            PrintMethod(ValueZero,"Emran");
            OperandStore(Integer.toString(ValueZero));
            new FadeIn(zero).play();
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
                new FadeIn(full_stop).play();
            }
            else
            {
                PrintMethod(-1,".");
                OperandStore(".");
                new FadeIn(full_stop).play();
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
            new FadeIn(equal).play();
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
                new FadeIn(x).play();
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
                    new FadeIn(one).play();
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
                    new FadeIn(one).play();
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
            lastValue='A';
            new FadeIn(ac).play();
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
                    new FadeIn(plus).play();
                    return;
                }
                else if(keyEvent.getCode().toString().equals("SUBTRACT"))
                {
                    if(StoreCalculationValue==0)
                    {
                        BeforeCalValue=StoreCalculationValue;
                        System.out.println("Yes line 850+");
                    }
                    fontSizeRestore();
                    conditionForOperator=2;
                    PrintMethod(-1,ValueSubtraction);
                    new FadeIn(subtraction).play();
                    return;
                }
                else if(keyEvent.getCode().toString().equals("MULTIPLY"))
                {
                    fontSizeRestore();
                    conditionForOperator=3;
                    PrintMethod(-1,ValueMulti);
                    new FadeIn(multi).play();
                    return;
                }
                else if(keyEvent.getCode().toString().equals("DIVIDE"))
                {
                    fontSizeRestore();
                    conditionForOperator=4;
                    PrintMethod(-1,ValueSlash);
                    new FadeIn(slash).play();
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
                        new FadeIn(plus).play();
                        return;
                    }
                    else if(keyEvent.getCode().toString().equals("SUBTRACT"))
                    {
                        if(StoreCalculationValue==0)
                        {
                            BeforeCalValue=StoreCalculationValue;
                            System.out.println("Yes");
                        }
                        fontSizeRestore();
                        conditionForOperator=2;
                        PrintMethod(-1,ValueSubtraction);
                        new FadeIn(subtraction).play();
                        return;
                    }
                    else if(keyEvent.getCode().toString().equals("MULTIPLY"))
                    {
                        fontSizeRestore();
                        conditionForOperator=3;
                        PrintMethod(-1,ValueMulti);
                        new FadeIn(multi).play();
                        return;
                    }
                    else if(keyEvent.getCode().toString().equals("DIVIDE"))
                    {
                        fontSizeRestore();
                        conditionForOperator=4;
                        PrintMethod(-1,ValueSlash);
                        new FadeIn(slash).play();
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
            if(keyEvent.getCode().toString().equals("SUBTRACT"))
            {
                System.out.println("subtraction  Else Login 1");
                if(userValue.getText().isEmpty() ||  getLastValue(userValue.getText()) == '-' )
                {
                    fontSizeRestore();
                    conditionForOperator=2;
                    PrintMethod(-1,"0-");
                }
                return;

            }
        }



    }//KeyPressAction

    public void PrintMethod(int valueI,String valueS)
    {
        output.setText(String.valueOf(StoreCalculationValue));
        if(valueI!=-1)
        {
            System.out.println("Sub 1111111111111111111111111111111");
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
            System.out.println("Sub 222222222222222222222222222222");
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
    }//PrintMethod

    public void OperandStore(String Value)
    {
        SplitString=SplitString+Value;
        System.out.println("Connected:"+SplitString);
        calculationMethod();
        //calculationMethod(SplitString,PublicOperator);
        //return;
    }//OperandStore

    public void calculationMethod()
    {
        //System.out.println("conditionForOperator: "+conditionForOperator);
        double splitPartOne= Double.parseDouble(SplitString);

        AfterCalValue=splitPartOne; //Split Done Now Store After Value...

        if(output.equals("0.00")){
            BeforeCalValue=0;
            AfterCalValue=0;
        }

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


    }//calculationMethod

    public void fontSizeRestore()
    {
        userValue.setFont(new Font("Serif",19));
        output.setFont(new Font("Serif",19));
    }//fontSizeRestore

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
    }//getLastValue

    public void setOutput(String output1)
    {
        output.setText(output1);
    }

    public void CheckPO()
    {
        if(!PO2.equals("Don't have any Previous Output") || !PO1.equals("Don't have any Previous Output"))
        {
            if(userValue.equals("0-"))
            {
                System.out.println("Cooooollllllll 222 line 1050+");
                output.setText("");
                userValue.setText("");
                PO1="Don't have any Previous Output";
                PO2="Don't have any Previous Output";
            }

        }
    }//CheckPO

    private void LogOutMethod(ActionEvent event)
    {
        Stage stage= (Stage) ((Node)event.getSource()).getScene().getWindow();
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../FXML/LoginANDSignDesign.fxml")));
            Scene scene=new Scene(root);
            scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("../CSS/LoginANDSignCSS.css")).toExternalForm());
            stage.setScene(scene);
            new FadeIn(root).play(); //FadeIn,
            stage.show();
            DatabaseLoginInfoRemove();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }//LogOutMethod

    private void DatabaseLoginInfoRemove() {
        try {
            PreparedStatement stmt1 = Con.con.prepareStatement("DELETE FROM login_info WHERE Code=1;");
            stmt1.executeUpdate();
            stmt1.close();
        }catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

    }

    private boolean AdminPresentOrNot()
    {
        String DBEmail;
        try {
            Statement stmt= Con.con.createStatement();
            ResultSet rs =stmt.executeQuery("SELECT * FROM login_info;");
            while(rs.next())
            {
                DBEmail = rs.getString("Email");
                if(DBEmail.equals("emranhosen50")){
                    adminText.setText("Admin Emran");
                    return true;
                }else{
                    adminText.setText(DBEmail);
                }
                System.out.println(DBEmail);
            }
            stmt.close();

        }catch (SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        return false;
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
    }//KeyTypeAction

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
            leftOrRight=true;
            firstCheckBox.setSelected(true);
            SecondCheckBox.setSelected(false);
            firstCheckBox.setStyle("-fx-text-fill: #ff6600;");
            SecondCheckBox.setStyle("-fx-text-fill: #0a0a0a;");
            if(!(leftComboBox.getSelectionModel().getSelectedItem() ==null) || !(RightComboBox.getSelectionModel().getSelectedItem() ==null)){
                TemperatureCalculation(convertInput.getText());
            }
        }
        else if(event_CBC.getSource()==SecondCheckBox)
        {
            leftOrRight=false;
            SecondCheckBox.setSelected(true);
            firstCheckBox.setSelected(false);
            firstCheckBox.setStyle("-fx-text-fill: #0a0a0a;");
            SecondCheckBox.setStyle("-fx-text-fill: #ff6600;");
            if(!(leftComboBox.getSelectionModel().getSelectedItem() ==null) || !(RightComboBox.getSelectionModel().getSelectedItem() ==null)){
                TemperatureCalculation(convertInput.getText());
            }
        }
        ////////////////////////////////////////////////
        else if(event_CBC.getSource()==converterACButton)
        {
            convertInput.clear();
            ConvertDisplay.setText("");
            leftOrRight=true;
            firstCheckBox.setSelected(true);
            SecondCheckBox.setSelected(false);
            firstCheckBox.setStyle("-fx-text-fill: #ff6600;");
            SecondCheckBox.setStyle("-fx-text-fill: #0a0a0a;");
        }
        else if(event_CBC.getSource()==converterButton)
        {
            if(leftComboBox.getSelectionModel().getSelectedItem()==null || RightComboBox.getSelectionModel().getSelectedItem()==null){
                Notifications noti= Notifications.create();
                noti.title("Warning");
                noti.text("Please Select Item Properly !!!");
                noti.showWarning();
                noti.hideAfter(Duration.millis(2000));
            }else{
                TemperatureCalculation(convertInput.getText());
            }

        }
        else if(event_CBC.getSource()==converterCLRButton)
        {
            if(convertInput.getText().length()==0 || convertInput.getText().length()==1) {
                convertInput.clear();
                return;
            }
            else
            { String RemoveValue=removeLastChar(convertInput.getText());  convertInput.setText(RemoveValue); }
        }

    }//ConverterButtonActionEvent


    void CategoryWiseChange(String category, ObservableList<String> categoryList)
    {
        GlobalCategoryList=categoryList;
        new Flip(singlePaneFor9Item).play();
        titleConverter.setText(category+" Converter");
        leftComboBox.setItems(categoryList);
        RightComboBox.setItems(categoryList);
        leftComboBox.setPromptText(categoryList.get(0));
        RightComboBox.setPromptText(categoryList.get(0));
        firstCheckBox.setText(categoryList.get(0)+" to "+categoryList.get(0));
        SecondCheckBox.setText(categoryList.get(0)+" to "+categoryList.get(0));
    }//CategoryWiseChange

    void CheckBoXSelect()
    {
        leftComboValue=leftComboBox.getSelectionModel().getSelectedItem();
        RightComboValue=RightComboBox.getSelectionModel().getSelectedItem();
        if(leftComboValue==null)
        {
            firstCheckBox.setText(GlobalCategoryList.get(0)+" to "+RightComboValue);
            SecondCheckBox.setText(RightComboValue+" to "+GlobalCategoryList.get(0));
        }
        else if(RightComboValue==null)
        {
            firstCheckBox.setText(leftComboValue+" to "+GlobalCategoryList.get(0));
            SecondCheckBox.setText(GlobalCategoryList.get(0)+" to "+leftComboValue);
        }
        else
        {
            firstCheckBox.setText(leftComboValue+" to "+RightComboValue);
            SecondCheckBox.setText(RightComboValue+" to "+leftComboValue);
        }


    }//CheckBoXSelect
    //"Celsius","Fahrenheit","Kelvin")
    void TemperatureCalculation(String ConvertValue){
        double ans;double ConvertDouble=Double.parseDouble(ConvertValue);
        if(leftComboValue.equals(RightComboValue)){
            ConvertDisplay.setText("Ans: "+ConvertValue);
        }
        else if(leftComboValue.equals("Celsius") && RightComboValue.equals("Fahrenheit")  ||  leftComboValue.equals("Fahrenheit") && RightComboValue.equals("Celsius")){
            if(leftOrRight){ //Celsius to Fahrenheit
                ans=((ConvertDouble - 32) * 5/9);
                ConvertDisplay.setText("Ans: "+ans);
            }
            else{ //Fahrenheit to Celsius
                ans=((ConvertDouble * 9/5) + 32);
                ConvertDisplay.setText("Ans: "+ans);
            }
        }
        else if(leftComboValue.equals("Celsius") && RightComboValue.equals("Kelvin")  ||  leftComboValue.equals("Kelvin") && RightComboValue.equals("Celsius")){
            if(leftOrRight){ //Celsius to Kelvin
                ans=ConvertDouble - 273.15;
                ConvertDisplay.setText("Ans: "+ans);
            }
            else{ //Kelvin to Celsius
                ans=ConvertDouble + 273.15;
                ConvertDisplay.setText("Ans: "+ans);
            }
        }
        else if(leftComboValue.equals("Kelvin") && RightComboValue.equals("Fahrenheit ")  ||  leftComboValue.equals("Fahrenheit") && RightComboValue.equals("Kelvin ")){
            if(leftOrRight){
                ans= ((ConvertDouble - 273.15) * 9/5 + 32);
                ConvertDisplay.setText("Ans: "+ans);
            }
            else{
                ans= ((ConvertDouble - 32) * 5/9 + 273.15);
                ConvertDisplay.setText("Ans: "+ans);
            }
        }


    }






    //Title Bar
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