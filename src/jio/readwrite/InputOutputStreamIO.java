package jio.readwrite;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
public class InputOutputStreamIO {
    public static void write() {
        var filesName = "in_out_stream_data.txt";
        var content = "This is some IOStream Data";
        try (FileOutputStream outputStream = new FileOutputStream(filesName)) {
            var bytes = content.getBytes();
            outputStream.write(bytes);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    public static void read(){
        var fileName = "in_out_stream_data.txt";
        try(FileInputStream inputStream = new FileInputStream(fileName)){
            var stringsBuffer = new StringBuffer();
            int bytesRead;
            while((bytesRead = inputStream.read()) != -1){
                char characterRead = (char) bytesRead;
                System.out.println("Read Character : " + characterRead);
                stringsBuffer.append(characterRead);
            }
            String fullContent = stringsBuffer.toString();
            System.out.println(fullContent);
        } catch(IOException ex) {
            ex.printStackTrace();
        }
    }
    public static void main(String[] args) {
        //write();
        read();
    }
}
