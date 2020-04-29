/Write a String reformatLines(String text) method of the MyUtils class to replacing
// all spaces with one and reformat lines of input text.
//Length of every lines should not exceed 60 characters.
//For example, for a given text
//Java    was      originally developed
//   by    James   Gosling at Sun Microsystems (which
// has since been
//acquired by Oracle) and released in 1995
// as a core component of Sun Microsystems' Java platform.
//you should get
//Java was originally developed by James Gosling at Sun
//Microsystems (which has since been acquired by Oracle) and
//released in 1995 as a core component of Sun Microsystems'
//Java platform.

public class MyUtils {
    public String reformatLines(String text) {
        text = text.trim();
        String result = "";
        String[] arr = text.split("\\s+");
        int lineLength = 0;
        for(String word : arr){
            if((lineLength + word.length() < 60)){
                result += word + " ";
            } else {
                result = result.substring(0, result.length() - 1) + "\n" + word + " ";
                lineLength = 0;
            }
            lineLength += word.length() + 1;
        }
        return result.trim();
    }
}
