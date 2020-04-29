//Write a String differentWords(String originalText, String modifyText) method of the
// MyUtils class to compare originalText and modifyText.
//The differentWords() method return the modified text with uppercase of additional words.
//For example, for a given originalText
//Java is a programming language that is class-based and designed to have as few
// implementation dependencies as possible.
//and modifyText
//Java is a   general-purpose programming   language that is class-based object-oriented
// and designed to have as few implementation dependencies as possible.
//you should get
//Java is a   GENERAL-PURPOSE programming   language that is class-based OBJECT-ORIENTED
// and designed to have as few implementation dependencies as possible.

import java.util.*;

public class MyUtils {
    public String differentWords(String originalText, String modifyText) {
        if(modifyText == null) return null;
        if(modifyText.equals("")) return "";
        if(originalText == null || originalText.equals("")) return modifyText.toUpperCase();
        String result = "";
        List<String> words = new ArrayList<String>(Arrays.asList(originalText.trim().split("\\s+")));
        List<String> modifiedWords = new ArrayList<String>(Arrays.asList(modifyText.split("\\s")));

        for(String modWord : modifiedWords) {
            if(modWord.trim().isEmpty()){
                result += modWord + " ";
                continue;
            }
            if(words.size()==0||!modWord.equals(words.get(0))){
                result += modWord.toUpperCase() + " ";
            }else{

                result += modWord + " ";
                words.remove(0);
            }
        }
        return result.trim();
    }
}
