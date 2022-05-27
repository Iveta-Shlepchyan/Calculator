package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import org.mariuszgromada.math.mxparser.*;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    TextView Result;
    TextView Input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Result = findViewById(R.id.result);
        Input = findViewById(R.id.input);

    }
    public void clear(View view){
        Result.setText("");
        Input.setText("");

    }
    public void backspace(View view){
        if(!Input.getText().toString().equals(""))
        {
            StringBuffer sb = new StringBuffer(String.valueOf(Input.getText()));
            Input.setText(sb.deleteCharAt(sb.length() - 1));
        }
    }
    public void plus(View view){
        Input.setText(String.format("%s+", String.valueOf(Input.getText())));
    }
    public void minus(View view){
        Input.setText(String.format("%s-", String.valueOf(Input.getText())));
    }
    public void multiplication(View view){
        Input.setText(String.format("%s×", String.valueOf(Input.getText())));
    }
    public void division(View view){
        Input.setText(String.format("%s÷", String.valueOf(Input.getText())));
    }
    public void equal(View view){
        Result.setTextSize(70);
        String userExp = Input.getText().toString();

        userExp = userExp.replaceAll("÷", "/");
        userExp = userExp.replaceAll("×", "*");

        Expression exp = new Expression(userExp);
        double res = exp.calculate();
        if(res == (int)res)
            Result.setText(String.valueOf((int)res));
        else{
            String strRes = String.valueOf(res);
            int index = strRes.indexOf(".");
            int len = strRes.substring(index + 1).length();
            if(len>4)
                Result.setTextSize(50);
            if(len>10)
                res = Double.parseDouble(String.format(Locale.US, "%.10f", res ));
            Result.setText(String.valueOf(res));
        }



    }
    public void brackets(View view){
        short openBr = 0, closedBr = 0;
        int textLen = Input.getText().length();

        for (int i = 0; i < textLen; i++) {
            if (Input.getText().toString().charAt(i) == '(')
                openBr++;
            if (Input.getText().toString().charAt(i) == ')')
                closedBr++;
        }

        if ( (openBr == closedBr || Input.getText().toString().charAt(textLen - 1) == '('))
            Input.setText(String.format("%s(", String.valueOf(Input.getText())));
        else Input.setText(String.format("%s)", String.valueOf(Input.getText())));
    }
    public void point(View view){
        Input.setText(String.format("%s.", String.valueOf(Input.getText())));
    }
    public void percent(View view){
        Input.setText(String.valueOf(Input.getText()).concat("%"));
    }

    public void num0(View view){
        Input.setText(String.format("%s0", String.valueOf(Input.getText())));
    }
    public void num1(View view){
        Input.setText(String.format("%s1", String.valueOf(Input.getText())));
    }
    public void num2(View view){
        Input.setText(String.format("%s2", String.valueOf(Input.getText())));
    }
    public void num3(View view){
        Input.setText(String.format("%s3", String.valueOf(Input.getText())));
    }
    public void num4(View view){
        Input.setText(String.format("%s4", String.valueOf(Input.getText())));
    }
    public void num5(View view){
        Input.setText(String.format("%s5", String.valueOf(Input.getText())));
    }
    public void num6(View view){
        Input.setText(String.format("%s6", String.valueOf(Input.getText())));
    }
    public void num7(View view){
        Input.setText(String.format("%s7", String.valueOf(Input.getText())));
    }
    public void num8(View view){
        Input.setText(String.format("%s8", String.valueOf(Input.getText())));
    }
    public void num9(View view){
        Input.setText(String.format("%s9", String.valueOf(Input.getText())));
    }

}