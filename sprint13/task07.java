//Create the method readFile(String filename) that read from file a sequence of bytes in binary format from previous task and return ridable string.
//
//For example, the sequence of 7-bit bytes
//  10010001100101110110011011001101111
//
//should be represented as text fragment:
//     Hello


public static String readFile(String filename) {
    StringBuilder stringBuilder = new StringBuilder();
        try(BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String binaryString = br.readLine();
            int charCode;
            for (int i = 0; i < binaryString.length(); i += 7) {
                charCode = Integer.parseInt(binaryString.substring(i, i + 7), 2);
                String returnChar = Character.toString((char) charCode);
                stringBuilder.append(returnChar);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
}
