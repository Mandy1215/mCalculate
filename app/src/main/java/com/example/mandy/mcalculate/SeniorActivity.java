package com.example.mandy.mcalculate;

import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import java.math.BigDecimal;

public class SeniorActivity extends AppCompatActivity implements OnClickListener {
    private ImageButton turn_left;

    boolean falg_drop = false;
    boolean flag_operation = false;

    double number2;
    double number1;
    private boolean clear;
    double result = 0;

    private Button button_factorial;
    private Button button_power;
    private Button button_sqrt;
    private Button button_pa;
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
    private Button button_sin;
    private Button button_cos;
    private Button button_tan;
    private Button button_ln;
    private Button button_log;
    private Button button_right_parenthese;
    private Button button_left_parenthese;
    private Button button_e;


    private EditText input2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_senior);

        turn_left = (ImageButton) findViewById(R.id.turn_left);
        turn_left.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SeniorActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });


        button_factorial = (Button) findViewById(R.id.factorial);
        button_power = (Button) findViewById(R.id.power);
        button_sqrt = (Button) findViewById(R.id.sqrt);
        button_pa = (Button) findViewById(R.id.pa);
        button_sin = (Button) findViewById(R.id.sin);
        button_right_parenthese = (Button) findViewById(R.id.right_parentheses);
        button_left_parenthese = (Button) findViewById(R.id.left_parentheses);
        button_cos = (Button) findViewById(R.id.cos);
        button_tan = (Button) findViewById(R.id.tan);
        button_ln = (Button) findViewById(R.id.ln);
        button_log = (Button) findViewById(R.id.log);
        button_e = (Button) findViewById(R.id.e);
        button1 = (Button) findViewById(R.id.one2);
        button2 = (Button) findViewById(R.id.two2);
        button3 = (Button) findViewById(R.id.three2);
        button4 = (Button) findViewById(R.id.four2);
        button5 = (Button) findViewById(R.id.five2);
        button6 = (Button) findViewById(R.id.six2);
        button7 = (Button) findViewById(R.id.seven2);
        button8 = (Button) findViewById(R.id.eight2);
        button9 = (Button) findViewById(R.id.nine2);
        button0 = (Button) findViewById(R.id.zero2);
        button_add = (Button) findViewById(R.id.puls);
        button_clear = (Button) findViewById(R.id.clear2);
        button_deletd = (Button) findViewById(R.id.delete);
        button_minus = (Button) findViewById(R.id.minus2);
        button_multipy = (Button) findViewById(R.id.multipy);
        button_divide = (Button) findViewById(R.id.divide);
        button_drop = (Button) findViewById(R.id.drop2);
        button_equel = (Button) findViewById(R.id.equal2);
        input2 = (EditText) findViewById(R.id.text2);


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
        button_factorial.setOnClickListener(this);
        button_power.setOnClickListener(this);
        button_sqrt.setOnClickListener(this);
        button_pa.setOnClickListener(this);
        button_sin.setOnClickListener(this);
        button_log.setOnClickListener(this);
        button_cos.setOnClickListener(this);
        button_tan.setOnClickListener(this);
        button_ln.setOnClickListener(this);
        button_left_parenthese.setOnClickListener(this);
        button_right_parenthese.setOnClickListener(this);
        button_e.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        String str = input2.getText().toString();
        switch (v.getId()) {
            case R.id.one2:
            case R.id.two2:
            case R.id.three2:
            case R.id.four2:
            case R.id.five2:
            case R.id.six2:
            case R.id.seven2:
            case R.id.eight2:
            case R.id.nine2:
            case R.id.zero2:
            case R.id.e:
            case R.id.pa:
                input2.setText(str + ((Button) v).getText());
                break;

            case R.id.drop2://只允许输入一个小数点
                if (clear) {
                    clear = false;
                    str = "";
                    input2.setText("");
                }
                input2.setText(str + ((Button) v).getText());
                falg_drop = true;
                if (falg_drop) {
                    button_drop.setClickable(false);
                    falg_drop = false;
                }

                break;
            case R.id.puls:
            case R.id.minus2:
            case R.id.multipy:
            case R.id.divide:
                if (clear) {
                    clear = false;
                    str = "";
                    input2.setText("");
                }
                input2.setText(str + " " + ((Button) v).getText() + " ");
                flag_operation = true;
                if (flag_operation) {
                    button_add.setClickable(false);
                    button_minus.setClickable(false);
                    button_multipy.setClickable(false);
                    button_divide.setClickable(false);
                    flag_operation = false;
                }
                break;

            case R.id.factorial:
                input2.setText(str + " " + ((Button) v).getText() + " ");
                break;
            case R.id.power:
                input2.setText(str + " " + ((Button) v).getText() + " ");
                break;
            case R.id.sqrt:
                input2.setText(str + " " + ((Button) v).getText() + " ");
                break;
            case R.id.right_parentheses:
            case R.id.left_parentheses:
                input2.setText(str + " " + ((Button) v).getText() + " ");
                break;
            case R.id.sin:
            case R.id.cos:
            case R.id.tan:
            case R.id.ln:
            case R.id.log:
                input2.setText(str + ((Button) v).getText() + "(");
                break;
            case R.id.clear2:
                input2.setText("");
                break;
            case R.id.delete:
                if (str != null || !str.equals("")) {
                    input2.setText(str.substring(0, str.length() - 1));
                }
                break;
            case R.id.equal2:
                getResult();
                break;
        }
    }

    private void getResult() {
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

        String text = input2.getText().toString();
        if (text == null || text.equals("")) {
            return;
        }
        if (clear) {
            clear = false;
            return;
        }
        clear = true;

        if (text.indexOf("!") > -1){
            result = 2;
        }


        if (text.contains(" ")) {
            String num1 = text.substring(0, text.indexOf(" "));
            String operation = text.substring(text.indexOf(" ") + 1, text.indexOf(" ") + 2);
            String num2 = text.substring(text.indexOf(" ") + 3);

            if (num1 != null) {
                number1 = Double.parseDouble(num1);
            } else {
                number1 = 0;
            }
            if (num1 != null) {
                number2 = Double.parseDouble(num2);
            } else {
                number2 = 0;
            }


            if (num1 != null && num2 != null) {
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
            }


            if (num1.equals("") && !num2.equals("")) {
                if (operation.equals("+")) {
                    result += number2;
                } else if (operation.equals("-")) {
                    result -= number2;
                } else if (operation.equals("*")) {
                    result *= 0;
                } else if (operation.equals("÷")) {
                    result = 0;
                }

            }


            BigDecimal bigDecimal = new BigDecimal(result);
            double result_equel = bigDecimal.setScale(13, BigDecimal.ROUND_HALF_UP).doubleValue();

            if (!num1.contains(".") && !num2.contains(".") && !operation.equals("÷")) {
                input2.setText((int) result_equel + "");
            } else {
                input2.setText(result_equel + "");
            }
            if (clear) {
                clear = false;
                return;
            }
            clear = true;


        }
    }

/*


*/


}
