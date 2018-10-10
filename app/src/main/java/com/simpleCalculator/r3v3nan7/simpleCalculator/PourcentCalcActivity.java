package com.simpleCalculator.r3v3nan7.simpleCalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.r3v3nan7.secondapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PourcentCalcActivity extends AppCompatActivity {

    public static final int POURCENT = 100;
    public static final String ERR_MESSAGE = "Cannot be empty.";

    @BindView(R.id.btnCalcPourcent)
    Button btnCalcPourcent;

    @BindView(R.id.edt_NumberOne)
    EditText numOne;

    @BindView(R.id.edt_NumberTwo)
    EditText numTwo;

    @BindView(R.id.tvResult)
    TextView calcResult;

    @BindView(R.id.edt_secondSecNumOne)
    EditText secondSecNumOne;

    @BindView(R.id.edt_secondSecNumTwo)
    EditText secondSecNumTwo;

    @BindView(R.id.btnCalcPourcentSecSection)
    Button btnCalcPourcentSecSection;

    @BindView(R.id.tvResultSecSection)
    TextView tvResultSecSection;

    @BindView(R.id.btnCalcPourcentThirdSection)
    Button btnCalcThirdSection;

    @BindView(R.id.edt_thirdSecNumOne)
    EditText thirdSecNumOne;

    @BindView(R.id.edt_thirdSecNumTwo)
    EditText thirdSecNumTwo;

    @BindView(R.id.tvResultThirdSection)
    TextView tvResultThirdSection;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pourcent_calc);
        ButterKnife.bind(this);
    }


    @OnClick(R.id.btnCalcPourcent)
    public void calculatePourcent(){

        try {
            double num1 = Double.parseDouble(this.numOne.getText().toString());
            double num2 = Double.parseDouble(this.numTwo.getText().toString());
            double result = (num1 * num2) / POURCENT;
            calcResult.setText("" + result);

        }catch (Exception ex){
            calcResult.setText(ERR_MESSAGE);

        }



    }

    @OnClick(R.id.btnCalcPourcentSecSection)
    public void calculaterPourcentSecSection(){

        try{

            double num1 = Double.parseDouble(this.secondSecNumOne.getText().toString());
            double num2 = Double.parseDouble(this.secondSecNumTwo.getText().toString());

            double result = (num1 * POURCENT) / num2;
            tvResultSecSection.setText("" + result);
        }catch (Exception ex){
            tvResultSecSection.setText(ERR_MESSAGE);
        }

    }


    @OnClick(R.id.btnCalcPourcentThirdSection)
    public void calculatePourcentThirdSection(){

        try{
            double num1 = Double.parseDouble(this.thirdSecNumOne.getText().toString());
            double num2 = Double.parseDouble(this.thirdSecNumTwo.getText().toString());

            double result = (num2 - num1) / num1 * POURCENT;
            tvResultThirdSection.setText("" + result);
        }catch (Exception ex){
            tvResultThirdSection.setText(ERR_MESSAGE);
        }


    }


}
