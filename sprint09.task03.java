//Pig Latin is a spoken "secret code" that many English-speaking children learn.
//The rules for written Pig Latin are:
//If a word begins with a consonant cluster, move it to the end and add "ay";
//If a word begins with a vowel, add "hay" to the end;
//Write a String pigLatinConverter(String text) method of the MyUtils class to convert input text.
//For example, for a given text
//Pig Latin is simply a form of jargon unrelated to Latin.
//you should get
//igPay atinLay ishay implysay ahay ormfay ofhay argonjay unrelatedhay otay atinLay.
//For more information, see https://en.wikipedia.org/wiki/Pig_Latin


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyUtils {
   public String pigLatinConverter(String text) {
      String result = "";
        String[] words = text.split(" ");
        for(String word : words) {
            if(Pattern.matches("(.*)-(.*)", word)) {
                String[] parts = word.split("-");
                String wordWithHyphen = "";
                for(String part : parts){
                    wordWithHyphen += convert(part) + "-";
                }
                result += " " + wordWithHyphen.substring(0, wordWithHyphen.length() - 1);
            } else {
                result += " " + convert(word);
            }
        }
        result = result.trim();
        return result;
    }
    private String convert(String word) {
        String vowels = "(A|a|E|e|I|i|O|o|U|u).*";
        String cons = "[^(A|a|E|e|I|i|O|o|U|u)].*";
        String nonLetters = "(.*)[^A-Za-z0-9]";
        if(Pattern.matches(vowels, word)) {
            if(Pattern.matches(nonLetters, word)){
                word = word.substring(0, word.length() - 1) + "hay" + word.substring(word.length() - 1);
            }else{
                word += "hay";
            }
        }else if(Pattern.matches(cons, word)){
            int index = 0;
            for(int i = 0; i < word.length(); i++){
                if(!Pattern.matches(cons, word.substring(i))){
                    break;
                }
                index++;
            }
            if(Pattern.matches(nonLetters, word)){
                word = word.substring(index, word.length() - 1) + word.substring(0, index) + "ay" + word.substring(word.length() - 1);
            }else {
                word = word.substring(index) + word.substring(0, index) + "ay";
            }
        }
        return word;
    }
}
