package hacckerank;

import java.util.Stack;

/**
 * Created by christian.gao on 1/6/18.
 */
public class BalancedBrackets {

    public static boolean isClosed(Character c, Character closed){

        switch(c){
            case '[': return closed.equals(']');
            case '{': return closed.equals('}');
            case '(': return closed.equals(')');
        }
        return false;
    }

    public static boolean isBalanced(String expression) {

        String openBrackets = "{[(";

        Stack<Character> stack = new Stack<Character>();
        for(Character character : expression.toCharArray()){
            if(openBrackets.contains(character.toString()))
                stack.add(character);
            else if (stack.size() == 0)
                return false;
            else if (isClosed(stack.peek(),character))
                stack.pop();
            else
                return false;
        }

        if(stack.size() != 0)
            return false;

        return true;
    }

    public static void main(String args[]){

        System.out.println(isBalanced("{[()){}]}"));


    }

}
