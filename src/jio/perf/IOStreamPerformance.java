package jio.perf;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Optional;

public class IOStreamPerformance {
    public static Optional<ReadMetadata> read(){
        var startTime = System.currentTimeMillis();
        var filePath = "large29MB_text.txt";
        try(FileInputStream inputStream = new FileInputStream(filePath)){
            var stringBuffer = new StringBuffer();
            int readBytes;
            while((readBytes = inputStream.read()) != -1){
                var character = (char) readBytes;
                stringBuffer.append(character);
            }
            var durationMillis = System.currentTimeMillis() - startTime;
            System.out.println("Read: Processing Time " + durationMillis + "ms");
            var stringContent = stringBuffer.toString();
            var metadata = new ReadMetadata(durationMillis,stringContent);
            return Optional.of(metadata);
        } catch(IOException ex){
            ex.printStackTrace();
            return Optional.empty();
        }
    }
    public static void write(ReadMetadata readMetadata){
        var startTime = System.currentTimeMillis();
        var filePath = "large29MB_text.txt";
        try(FileOutputStream outputStream = new FileOutputStream(filePath)){
            byte[] dataBytes = readMetadata.content().getBytes();
            outputStream.write(dataBytes);
            var durationMillis = System.currentTimeMillis() - startTime;
            System.out.println("Write: Processing Time " + durationMillis + "ms");
        } catch (IOException ex){
            ex.printStackTrace();
        }
    }
    public static void main(String[] args) {
        var optionalMetadata = read();
        optionalMetadata.ifPresent(IOStreamPerformance::write);
    }
}
