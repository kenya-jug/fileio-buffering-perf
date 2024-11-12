package jio.perf;

import java.io.*;
import java.util.Optional;

public class BufferSizeVPerformance {
    public static Optional<ReadMetadata> readWithBuffer(int bufferSize){
        try {
            var startTime = System.currentTimeMillis();

            //The content file can be absolute path or just file name
            var filePath = "large29MB_text.txt";

            // Create a FileReader
            var fileReader = new FileReader(filePath);

            var bufferedReader = new BufferedReader(fileReader,bufferSize);
            String line;
            String output = "";
            while((line = bufferedReader.readLine()) != null){
                output = output.concat(line);
            }
            bufferedReader.close();
            long readTime = System.currentTimeMillis() - startTime;
            System.out.println("Read: Processing Time: " + readTime + "ms : Buffer Size " + bufferSize + " bytes");
            var readData = new ReadMetadata(readTime,output);
            return Optional.of(readData);
        } catch(IOException ex) {
            ex.printStackTrace();
        }
        return Optional.empty();
    }
    public static void writeWithBuffer(int bufferSize, ReadMetadata readMetadata){
        try {
            var startTime = System.currentTimeMillis();
            //The output file can be absolute path or just file name
            var filePath = "large29MB_text.txt";

            // Create a FileWriter
            var fileWriter = new FileWriter(filePath);

            // Initialize with the buffer size
            var bufferedWriter = new BufferedWriter(fileWriter,bufferSize);
            bufferedWriter.write(readMetadata.content());
            //Remember to close
            bufferedWriter.close();
            long writeTime = System.currentTimeMillis() - startTime;
            long overallReadWriteTime = System.currentTimeMillis() - readMetadata.durationMillis();
            System.out.println("Write: Processing Time: " + writeTime + "ms : Buffer Size " + bufferSize + " bytes");
            System.out.println("Overall Read - Write: Processing Time: " + overallReadWriteTime + "ms : Buffer Size " + bufferSize + " bytes");
        } catch(IOException ex){
            ex.printStackTrace();
        }
    }
    public static void main(String[] args) {
        var bufferSize = 100_000_000; //bytes
        var readDataOptional = readWithBuffer(bufferSize);
        readDataOptional.ifPresent(readMetadata -> writeWithBuffer(bufferSize, readMetadata));
    }
}
