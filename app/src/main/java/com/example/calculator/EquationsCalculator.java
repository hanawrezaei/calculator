package com.example.calculator;

import org.mariuszgromada.math.mxparser.Expression;
import org.mariuszgromada.math.mxparser.Function;

import java.util.EnumMap;

public class EquationsCalculator {


    public static String Calculate(String function,String numbers)
    {
        Function function1=new Function(function);
        String number="F"+numbers;
        Expression expression=new Expression(number,function1);
        double dblresult=expression.calculate();
        String result=String.valueOf(dblresult);
        return result;
    }




}