/Create the method writeFile(String filename, String text) that write the text to file
// as sequence of bytes in binary format.
//
//For example, the text fragment
//              Hello!
//
//should be represented in the file as a sequence of 7-bit bytes without spaces between them:
//
//
//If less than 7 bits are required to represent the character then add to binary sequence
// leading zeros '0'.

public static void writeFile(String filename, String text) {
    String result = "";
    byte[] bytes = text.getBytes(java.nio.charset.StandardCharsets.UTF_8);
    String temp;
    for (byte b : bytes) {
        temp = String.format("%8s", Integer.toBinaryString(b & 0xFF)).replace(' ', '0').substring(1);
        result += temp;
    }

    try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))){
        bw.write(result);
    } catch (IOException e) {
        e.printStackTrace();
    }
}
