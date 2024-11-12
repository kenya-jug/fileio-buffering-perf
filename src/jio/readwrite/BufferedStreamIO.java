package jio.readwrite;
import java.io.*;

public class BufferedStreamIO {
    public static void writeFile(){
        try {
            //The output file can be absolute path or just file name
            var filePath = "content.txt";

            // Create a FileWriter
            var fileWriter = new FileWriter(filePath);

            var bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("BufferedWriter");
            //Create a new line, you can also use `\n` escape character
            bufferedWriter.newLine(); //\n
            bufferedWriter.write("Writes text to a character-output stream, buffering characters so as to provide for the efficient writing of single characters, arrays, and strings.");
            bufferedWriter.newLine();
            bufferedWriter.write("The buffer size may be specified, or the default size may be accepted.");
            bufferedWriter.newLine();
            bufferedWriter.write("The default is large enough for most purposes.");

            //Remember to close
            bufferedWriter.close();
        } catch(IOException ex){
            ex.printStackTrace();
        }
    }
    public static void readFile(){
        try {
            //The content file can be absolute path or just file name
            var filePath = "content.txt";

            // Create a FileReader
            var fileReader = new FileReader(filePath);

            var bufferedReader = new BufferedReader(fileReader);
            String line;
            while((line = bufferedReader.readLine()) != null){
                System.out.println("\n" + line);
            }
            bufferedReader.close();
        } catch(IOException ex) {
            ex.printStackTrace();
        }
    }
    public static void writeFile(int bufferSize){
        try {
            //The output file can be absolute path or just file name
            var filePath = "content.txt";

            // Create a FileWriter
            var fileWriter = new FileWriter(filePath);

            //Initialize with the buffer size
            var bufferedWriter = new BufferedWriter(fileWriter,bufferSize);
            bufferedWriter.write("BufferedWriter");
            //Create a new line, you can also use `\n` escape character
            bufferedWriter.newLine();
            bufferedWriter.write("Writes text to a character-output stream, buffering characters so as to provide for the efficient writing of single characters, arrays, and strings.");
            bufferedWriter.newLine();
            bufferedWriter.write("The buffer size may be specified, or the default size may be accepted.");
            bufferedWriter.newLine();
            bufferedWriter.write("The default is large enough for most purposes.");

            //Remember to close
            bufferedWriter.close();
        } catch(IOException ex){
            ex.printStackTrace();
        }
    }
    public static void main(String[] args) {
        BufferedStreamIO.writeFile(1054);
        BufferedStreamIO.readFile();
    }
}
