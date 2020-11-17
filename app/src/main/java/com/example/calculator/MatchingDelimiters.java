package com.example.calculator;

import java.util.Scanner;
import java.util.Stack;

public class MatchingDelimiters extends ArrayStack
{
    public MatchingDelimiters()
    {

    }
    public static boolean isMatched(String expression)
    {
        Stack<Character> myStack = new Stack<Character>();
        // loop through each individual character in string
        for(int i = 0; i < expression.length(); i++)
        {
            //current character iteration
            char c = expression.charAt(i);
            // if character is ({ or [
            if(c == '(')
            {
                // push that character into the stack
                myStack.push(c);
            }
            //else if it is )} or ]
            else if(c == ')')
            {
                // if stack is empty
                if(myStack.empty())
                {
                    // return false. It's an invalid expression
                    return false;
                }
                else if(myStack.peek() == '(')
                {
                    if(c == ')')
                        myStack.pop();
                }
            }
        }
        // return if stack is empty or not
        return myStack.empty();
    }
}
