package com.simpleCalculator.r3v3nan7.simpleCalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.r3v3nan7.secondapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    public final String ERR_INVALID_EXPRESSION = "Invalid expression";

    @BindView(R.id.txt_result) TextView txt_result;
    @BindView(R.id.btnZero) Button btnZero;
    @BindView(R.id.btnOne) Button btnOne;
    @BindView(R.id.btnTwo) Button btnTwo;
    @BindView(R.id.btnThree) Button btnThree;
    @BindView(R.id.btnFour) Button btnFour;
    @BindView(R.id.btnFive) Button btnFive;
    @BindView(R.id.btnSix) Button btnSix;
    @BindView(R.id.btnSeven) Button btnSeven;
    @BindView(R.id.btnEight) Button btnEight;
    @BindView(R.id.btnNine) Button btnNine;
    @BindView(R.id.btnCalc) Button btnCalc;
    @BindView(R.id.btnClear) Button btnClear;
    @BindView(R.id.btnAdd) Button btnAdd;
    @BindView(R.id.btnSubtract) Button btnSubtract;
    @BindView(R.id.btnMultiply) Button btnMultiply;
    @BindView(R.id.btnDivide) Button btnDivide;
    @BindView(R.id.btnSquare) Button btnSquare;
    @BindView(R.id.btnPourcent) Button btnPourcent;
    @BindView(R.id.btnComma) Button btnComma;

    private Calculator calculator;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setTitle("Simple Calculator");
        this.calculator = new Calculator(R.layout.activity_main);

    }

    private void clearErrorMessage(){
        if(txt_result.getText().toString().equals(ERR_INVALID_EXPRESSION)){
            txt_result.setText("");
        }
    }

    @OnClick(R.id.btnZero)
    public void onClickZeroBtn(){
        clearErrorMessage();
        txt_result.append("0");
    }

    @OnClick(R.id.btnOne)
    public void onClickOneBtn(){
        clearErrorMessage();
        txt_result.append("1");
    }

    @OnClick(R.id.btnTwo)
    public void onClickTwoBtn(){
        clearErrorMessage();
        txt_result.append("2");
    }

    @OnClick(R.id.btnThree)
    public void onClickThreeBtn(){
        clearErrorMessage();
        txt_result.append("3");
    }

    @OnClick(R.id.btnFour)
    public void onClickFourBtn(){
        clearErrorMessage();
        txt_result.append("4");
    }

    @OnClick(R.id.btnFive)
    public void onClickFiveBtn(){
        clearErrorMessage();
        txt_result.append("5");
    }

    @OnClick(R.id.btnSix)
    public void onClickSixBtn(){
        clearErrorMessage();
        txt_result.append("6");
    }

    @OnClick(R.id.btnSeven)
    public void onClickSevenBtn(){
        clearErrorMessage();
        txt_result.append("7");
    }

    @OnClick(R.id.btnEight)
    public void onClickEightBtn(){
        clearErrorMessage();
        txt_result.append("8");
    }

    @OnClick(R.id.btnNine)
    public void onClickNineBtn(){
        clearErrorMessage();
        txt_result.append("9");
    }

    @OnClick(R.id.btnClear)
    public void onClickClearBtn(){
        clearErrorMessage();
        txt_result.setText("");
    }


    @OnClick(R.id.btnAdd)
    public void onClickAddBtn(){
        clearErrorMessage();
        txt_result.append("+");
    }

    @OnClick(R.id.btnSubtract)
    public void onClickSubtractBtn(){
        clearErrorMessage();
        txt_result.append("-");
    }

    @OnClick(R.id.btnMultiply)
    public void onClickMultiplyBtn(){
        clearErrorMessage();
        txt_result.append("*");
    }

    @OnClick(R.id.btnDivide)
    public void onClickDivideBtn(){
        clearErrorMessage();
        txt_result.append("/");
    }

    @OnClick(R.id.btnLeftBracket)
    public void onClickLeftBracketBtn(){
        clearErrorMessage();
        txt_result.append("(");
    }

    @OnClick(R.id.btnRightBracket)
    public void onClickRightBracketBtn(){
        clearErrorMessage();
        txt_result.append(")");
    }


    @OnClick(R.id.btnComma)
    public void onClickCommaBtn(){
        clearErrorMessage();
        txt_result.append(".");
    }

    @OnClick(R.id.btnCalc)
    public void onClickCalculateBtn(){
        String expressionForCalculation = txt_result.getText().toString();
        String result = calculator.calculateExpression(expressionForCalculation);
        txt_result.setText(result);

    }


    @OnClick(R.id.btnSquare)
    public void onCLickSquareRootBtn(){
        StringBuilder sb = new StringBuilder();
        String expression = txt_result.getText().toString();
        String resultOfExpression = calculator.calculateExpression(expression);
        if(resultOfExpression.equals(ERR_INVALID_EXPRESSION)){
            txt_result.setText(ERR_INVALID_EXPRESSION);
            return;
        }

        Double squareRoot = Math.sqrt(Double.parseDouble(resultOfExpression));
        sb.append(squareRoot);

        txt_result.setText(sb.toString());

    }


    @OnClick(R.id.btnPourcent)
    public void onClickPourcentBtn(){
        Intent pourcentCalcViewTurnOn = new Intent(getApplicationContext(), PourcentCalcActivity.class);
        startActivity(pourcentCalcViewTurnOn);
    }



}
