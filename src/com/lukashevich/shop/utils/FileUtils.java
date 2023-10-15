package com.lukashevich.shop.utils;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class FileUtils {

    public void writeData(String fileName,String dataString){
        File file = new File(fileName);
        try(FileWriter writer = new FileWriter(file, false))
        {
            writer.write(dataString);

            writer.flush();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }

    public String readData(String fileName){
        String result="";
        File file = new File(fileName);
        try(FileReader reader = new FileReader(file))
        {
            char[] buf = new char[256];
            int c;
            while((c = reader.read(buf))>0){

                if(c < 256){
                    buf = Arrays.copyOf(buf, c);
                }
            }
            result = new String(Files.readAllBytes(Path.of(file.getPath())));
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
        return result;
    }
}