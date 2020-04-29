//Given a text containing brackets  '(', ')', '{', '}', '[' and ']'.
//Sequences "\\(", "\\)", "\\[", "\\]", "\\{" and "\\}" are not brackets.
//Write a boolean verifyBrackets(String text) method of the MyUtils class to check
// a input text.
//The brackets must close in the correct order, for example "()", "()[]{}", "{(())}"
// and "(\\()" are all valid but "(]", ")(" and "([)]" are not.

import java.util.Deque;
import java.util.LinkedList;
import java.util.Arrays;

public class MyUtils {
    public boolean verifyBrackets(String text) {
        //System.out.println(text);
        if(text.equals("")) return true;
        text = text.replaceAll("(\\\\){1,2}(\\(|\\)|\\{|\\}|\\[|\\])", "");
        Deque<String> braces = new LinkedList<String>();
        for(String s : Arrays.asList(text.split(""))){
            if (braces.size() > 0 && isClosing(braces.peek(), s)) {
                braces.pop();
            } else {
                braces.push(s);
            }
        }
        return braces.size() == 0;
    }
    public boolean isClosing(String x, String s) {
        return (x.equals("{") && s.equals("}")) || (x.equals("(") && s.equals(")")) || (x.equals("[") && s.equals("]"));
    }
}
