package com.example.mandy.mcalculate;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import java.math.BigDecimal;


public class MainActivity extends AppCompatActivity implements OnClickListener {

    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;
    private Button button8;
    private Button button9;
    private Button button0;
    private Button button_add;
    private Button button_minus;
    private Button button_multipy;
    private Button button_divide;
    private Button button_clear;
    private Button button_deletd;
    private Button button_equel;
    private Button button_drop;

    private EditText input;

    private boolean clear;
    double result;


    boolean flag_operation = false;
    boolean falg_drop = false;

    private ImageButton turn_right;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        button1 = (Button) findViewById(R.id.one);
        button2 = (Button) findViewById(R.id.two);
        button3 = (Button) findViewById(R.id.three);
        button4 = (Button) findViewById(R.id.four);
        button5 = (Button) findViewById(R.id.five);
        button6 = (Button) findViewById(R.id.six);
        button7 = (Button) findViewById(R.id.seven);
        button8 = (Button) findViewById(R.id.eight);
        button9 = (Button) findViewById(R.id.nine);
        button0 = (Button) findViewById(R.id.zero);
        button_add = (Button) findViewById(R.id.add);
        button_clear = (Button) findViewById(R.id.clear);
        button_deletd = (Button) findViewById(R.id.del);
        button_minus = (Button) findViewById(R.id.minus);
        button_multipy = (Button) findViewById(R.id.mul);
        button_divide = (Button) findViewById(R.id.dev);
        button_drop = (Button) findViewById(R.id.drop);
        button_equel = (Button) findViewById(R.id.equal);
        input = (EditText) findViewById(R.id.input);
        turn_right = (ImageButton) findViewById(R.id.turn_right);

        turn_right.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(MainActivity.this, SeniorActivity.class);
                startActivity(intent1);
            }
        });

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
        button0.setOnClickListener(this);
        button_add.setOnClickListener(this);
        button_minus.setOnClickListener(this);
        button_multipy.setOnClickListener(this);
        button_divide.setOnClickListener(this);
        button_clear.setOnClickListener(this);
        button_deletd.setOnClickListener(this);
        button_drop.setOnClickListener(this);
        button_equel.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        String str = input.getText().toString();
        switch (v.getId()) {
            case R.id.one:
            case R.id.two:
            case R.id.three:
            case R.id.four:
            case R.id.five:
            case R.id.six:
            case R.id.seven:
            case R.id.eight:
            case R.id.nine:
            case R.id.zero:
                if (clear) {
                    clear = false;
                    str = "";
                    input.setText("");
                }
                input.setText(str + ((Button) v).getText());
                break;
            case R.id.drop://只允许输入一个小数点
                if (clear) {
                    clear = false;
                    str = "";
                    input.setText("");
                }
                input.setText(str + ((Button) v).getText());
                falg_drop = true;
                if (falg_drop) {
                    button_drop.setClickable(false);
                    falg_drop = false;
                }

                break;
            case R.id.add:
            case R.id.minus:
            case R.id.mul:
            case R.id.dev:
                if (clear) {
                    clear = false;
                    str = "";
                    input.setText("");
                }
                input.setText(str + " " + ((Button) v).getText() + " ");
                flag_operation = true;
                if (flag_operation) {
                    button_add.setClickable(false);
                    button_minus.setClickable(false);
                    button_multipy.setClickable(false);
                    button_divide.setClickable(false);
                    flag_operation = false;
                }
                break;
            case R.id.clear:
                str = "";
                clear = false;
                input.setText(str);
                break;
            case R.id.del:
                if (clear) {
                    clear = false;
                    str = "";
                    input.setText("");
                }
                if (str != null && !str.equals("")) {
                    // public int indexOf(String str)
                    // 返回字符串中第一次出现str的位置；
                    //String substring(int beginIndex, int endIndex) ：
                    // 取从beginIndex位置开始到endIndex位置的子字符串。
                    input.setText(str.substring(0, str.length() - 1));
                }
                break;
            case R.id.equal:
                getRusult();

                break;
        }
    }

    private void getRusult() {
        flag_operation = false;
        if (flag_operation == false) {
            button_add.setClickable(true);
            button_minus.setClickable(true);
            button_multipy.setClickable(true);
            button_divide.setClickable(true);
        }
        falg_drop = false;
        if (falg_drop == false) {
            button_drop.setClickable(true);
        }
        String textInput = input.getText().toString();
        if (textInput == null || textInput.equals("")) {
            return;
        }
        if (!textInput.contains(" ")) {
            return;
        }
        if (clear) {
            clear = false;
            return;
        }
        clear = true;

        String num1 = textInput.substring(0, textInput.indexOf(" "));
        String operation = textInput.substring(textInput.indexOf(" ") + 1, textInput.indexOf(" ") + 2);
        String num2 = textInput.substring(textInput.indexOf(" ") + 3);
        if (!num1.equals("") && !num2.equals("")) {
            double number1 = Double.parseDouble(num1);
            double number2 = Double.parseDouble(num2);
            if (operation.equals("+")) {
                result = number1 + number2;
            } else if (operation.equals("-")) {
                result = number1 - number2;
            } else if (operation.equals("*")) {
                result = number1 * number2;
            } else if (operation.equals("÷")) {
                if (number2 == 0) {
                    result = 0;
                } else {
                    result = number1 / number2;
                }
            }


            if (!num1.equals("") && num2.equals("")) {
                input.setText(textInput.substring(0, textInput.indexOf(" ")));
            }


            if (num1.equals("") && !num2.equals("")) {
                if (operation.equals("+")) {
                    result += number2;
                } else if (operation.equals("-")) {
                    result -= number2;
                } else if (operation.equals("*")) {
                    result = 0;
                } else if (operation.equals("÷")) {
                    result = 0;
                }
            }


            BigDecimal bigDecimal = new BigDecimal(result);
            double r = bigDecimal.setScale(10, BigDecimal.ROUND_HALF_UP).doubleValue();

            if (!num1.contains(".") && !num2.contains(".") && !operation.equals("÷")) {
                input.setText((int) r + "");
            } else {
                input.setText(r + "");
            }

            if (clear) {
                clear = false;
                return;
            }
            clear = true;


        }
    }
}
