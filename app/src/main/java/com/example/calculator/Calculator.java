package com.example.calculator;

import java.util.Stack;

public class Calculator
{
    // result of equation
    double result;
    // for outputting postfix to user
    String postfix = "";
    boolean validation = false;


    public Calculator(String newInfix)
    {
        // make sure they pick operator, parenthesis, or integer
        String newstr0= newInfix.replaceAll("log","l");
        String newstr1=  newstr0.replaceAll("sin","s");
        String newstr2= newstr1.replaceAll("cos","c") ;
        System.out.println(newstr2);
        validation = check(newstr2);
        System.out.println(validation);

        // if they did, next.. make sure the parenthesis are matching
        if(validation)
            validation = isMatching(newstr2);
        // if THAT is true then go ahead and evaluate the postfix
        if(validation == true)
            // conversion returns the postfix string
            evaluatePostfix(conversionToPostfix(newstr2));
    }
    private <E> String conversionToPostfix(String newInfix)
    {
        Stack<Character> characterStack = new ArrayStack<>();

        for(int i = 0; i < newInfix.length(); i++)
        {
            char currentChar = newInfix.charAt(i);
            while (currentChar >= '0' && currentChar <= '9')
            {
                postfix += currentChar;
                // if next character is within length, make that new current
                // else current = space
                if(i + 1 < newInfix.length())
                    currentChar = newInfix.charAt(++i);

                else
                    currentChar = ' ';
                // if character is not a digit, add space to postfix
                if(!(currentChar >= '0' && currentChar <= '9'))
                    postfix += ' ';
            }
            if (currentChar == '+' || currentChar == '-' || currentChar == '*'
                    || currentChar == '/' || currentChar == '%' || currentChar == '^'||currentChar=='l'||currentChar=='c'||currentChar=='s')
            {
                while(!characterStack.isEmpty() && !isOpeningParenthesis(((ArrayStack<Character>) characterStack).top())
                        && hasHigherPrec(((ArrayStack<Character>) characterStack).top(), currentChar))
                {
                    postfix += ((ArrayStack<Character>) characterStack).top() + " ";
                    characterStack.pop();
                }
                characterStack.push(currentChar);
            }
            else if (isOpeningParenthesis(currentChar))
            {
                characterStack.push(currentChar);
            }
            else if (isClosingParenthesis(currentChar))
            {
                while(!characterStack.isEmpty() && !isOpeningParenthesis(((ArrayStack<Character>) characterStack).top()))
                {
                    postfix += ((ArrayStack<Character>) characterStack).top() + " ";
                    characterStack.pop();
                }
                characterStack.pop();
            }
        }
        // pop all remaining operators on the stack
        while(!characterStack.isEmpty())
        {
            postfix += ((ArrayStack<Character>) characterStack).top() + " ";
            characterStack.pop();
        }
        return postfix;
    }

    private <E> void evaluatePostfix(String newPostfix)
    {
        Stack<Double> integerStack = new ArrayStack<>();

        //loop through entire length of postfix expression
        for(int i = 0; i < newPostfix.length(); i++)
        {
            String temp = "";

            //store current character
            char currentChar = newPostfix.charAt(i);
            // while character is 1-9
            while(currentChar >= '0' && currentChar <= '9')
            {
                temp += currentChar;

                // if the character next to it (right side)
                //store next character in postfix expression into currentChar
                if(i + 1 < newPostfix.length())
                    currentChar = newPostfix.charAt(++i);
                else
                    currentChar = ' ';

                //if current character is NOT 1-9
                //note: current character changed from beginning. so it might be *
                if(!(currentChar >= '0' && currentChar <= '9'))
                {
                    double tempInt = Integer.parseInt(temp);
                    integerStack.push(tempInt);
                }
            }

            if(currentChar == '+' || currentChar == '-' || currentChar == '*'
                    || currentChar == '/' || currentChar == '%' || currentChar == '^'||currentChar=='l'||currentChar=='c'||currentChar=='s')
            {
                if(currentChar == '+')
                {
                    result = integerStack.pop() + integerStack.pop();
                    integerStack.push(result);
                }
                else if (currentChar == '-')
                {
                    double secondNum = integerStack.pop();
                    result = integerStack.pop() - secondNum;
                    integerStack.push(result);
                }
                else if(currentChar == '*')
                {
                    result = integerStack.pop() * integerStack.pop();
                    integerStack.push(result);
                }
                else if(currentChar == '/')
                {
                    double secondDivision = integerStack.pop();
                    result = integerStack.pop() / secondDivision;
                    integerStack.push(result);
                }
                else if(currentChar == '%')
                {
                    double secondMod = integerStack.pop();
                    result = integerStack.pop() % secondMod;
                    integerStack.push(result);
                    //divided by zero
                }
                else if(currentChar == '^')
                {
                    result = power(integerStack.pop(), integerStack.pop());
                    integerStack.push(result);
                }
                else if(currentChar == 'l')
                {
                    result = Math.log10(integerStack.pop());
                    System.out.println(result);
                    //System.out.println("fr test:"+Math.l);
                    integerStack.push(result);
                }
                else if (currentChar=='c')
                {
                    result=Math.cos(integerStack.pop());
                    integerStack.push(result);
                }
                else if (currentChar=='s')
                {
                    result=Math.sin(integerStack.pop());
                    integerStack.push(result);
                }
            }
        }
    }
    public String print()
    {
        String finalresult="";
        if(validation == true)
        {
            System.out.println("Postfix expression: " + postfix);
            System.out.println("answer: " + result);
            finalresult=String.valueOf(result);
            System.out.println();
        }
        else
            finalresult="This is an invalid expression";
        return finalresult;
    }
    private boolean isOpeningParenthesis(Character newTop)
    {
        if(newTop == '(')
            return true;
        else
            return false;
    }
    private boolean isClosingParenthesis(Character newTop)
    {
        if(newTop == ')')
            return true;
        else
            return false;
    }
    // does top of stack have higher or equal precedence than current character?
    private boolean hasHigherPrec(Character newTop, Character newCurrentChar)
    {
        boolean higherPrec = false;
        if(newCurrentChar == '*' || newCurrentChar == '%' || newCurrentChar == '/')
        {
            if(newTop == '+' || newTop == '-')
                higherPrec = false;

            else if(newTop == '/' || newTop == '%' || newTop == '*' || newTop == '^')
                higherPrec = true;
        }
        else if(newCurrentChar == '+' || newCurrentChar == '-')
        {
            higherPrec = true;
        }
        else if(newCurrentChar == '^')
        {
            if (newTop=='l'||newTop=='s'||newTop=='c')
                higherPrec=true;
            else if (newTop == '/' || newTop == '%' || newTop == '*' || newTop == '^'||newTop == '+' || newTop == '-')
                higherPrec = false;
        }
        else if (newCurrentChar=='l'||newCurrentChar=='c'||newCurrentChar=='s')
        {
            higherPrec=false;
        }
        return higherPrec;
    }

    private double power(double power, double base)
    {
        double product = base;
        if(power == 0)
            return 1;
        if(power == 1)
            return base;
        for(int j = 1; j < power; j++)
            product *= base;
        return product;
    }

    private boolean check(String expression)
    {
        System.out.println(expression.length());
        for(int i = 0; i < expression.length(); i++)
        {
            // if it's not a valid input character, return false.
            char var = expression.charAt(i);
            System.out.println("var:"+var);
            if(!(var == '+' || var == '-' || var == '*'
                    || var == '/' || var == '%' || var == '^'
                    || var == '(' || var == ')'|| var >= '0' && var <= '9' || var == ' '||var=='l'||var=='c'||var=='s'))
                return false;

            System.out.println("false");
        }
        System.out.println("true");
        return true;
    }
    // make sure parenthesis match
    private boolean isMatching(String input)
    {
        MatchingDelimiters delimiters = new MatchingDelimiters();
        return delimiters.isMatched(input);
    }


}
