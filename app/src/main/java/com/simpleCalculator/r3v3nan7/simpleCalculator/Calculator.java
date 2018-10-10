package com.simpleCalculator.r3v3nan7.simpleCalculator;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.r3v3nan7.secondapp.R;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;



public class Calculator implements Operations {

    public final String ERR_INVALID_EXPRESSION = "Invalid expression";

    //to define buttons with annotations for ButterKnife
    @BindView(R.id.txt_result)
    TextView result;

    @BindView(R.id.btnOne)
    Button btnOne;

    public View view;


    public Calculator(){

    }


    public Calculator(int activity_main){

    }

    public Calculator(View v){
        this.view = v;
        ButterKnife.bind(v);
    }



    public void onCreate(View v) {
        ButterKnife.bind(v);
    }





    @OnClick(R.id.btnOne)
    public void OnButtonOneClicked(){
        result.append("1");
    }



    @Override
    public String calculateExpression(String expression) {
        Context rhino = Context.enter();
// turn off optimization to work with android
        rhino.setOptimizationLevel(-1);

        String result;

        if(expression.equals("")){
            result = ERR_INVALID_EXPRESSION;
            return result;
        }


        try {
            Scriptable scope = rhino.initStandardObjects();
            result = rhino.evaluateString(scope, expression, "JavaScript", 1, null).toString();
        }catch (Exception exc){
            result = ERR_INVALID_EXPRESSION;
        }

        finally {
            Context.exit();
        }


        return result;
    }
}
