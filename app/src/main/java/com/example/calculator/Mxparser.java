package com.example.calculator;

import org.mariuszgromada.math.mxparser.Expression;
import org.mariuszgromada.math.mxparser.Function;

public class Mxparser {
  public static String getREsult(String question)
  {
      Expression expression=new Expression(question);
      double doubleresult=expression.calculate();
      String result=String.valueOf(doubleresult);
      return result;
  }


  public static String getEquationResult(String function,String numbers)
  {
      Function function1=new Function(function);
      String numerstoset="F"+numbers;
      Expression expression=new Expression(numerstoset,function1);
      double doubleresult=expression.calculate();
      String result=String.valueOf(doubleresult);
      return result;
  }

}
