//Write a method to read from a file a character-oriented data and return these data
// as String object.
//
//For example, next fragment:
//
//      This is text fragment
//      that contains some text data
//      and can be read!
//
//after reading will be transform to the next String object:
//
//
//"This is text fragment\nthat contains some text data\nand can be read!"

public static String readFile(String filename) {
    String result = "";
    try (BufferedReader reader = new BufferedReader(new FileReader(filename))){
        String line = null;
        while ((line = reader.readLine()) != null) {
            result += line + "\n";
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    result = result.substring(0, result.length() - 1);
    return result;
}
