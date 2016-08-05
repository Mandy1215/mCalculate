package com.example.mandy.mcalculate;

/**
 * Created by Mandy on 2016/7/20.
 */
public class MathOperation {

    //!
    private  double getFactorialResult(double number1) {
        double result = 1;
        if (number1 == 1){
            result = number1;
        }else{
            result = number1 * getFactorialResult(number1 - 1);
        }
        return result;
    }
}
