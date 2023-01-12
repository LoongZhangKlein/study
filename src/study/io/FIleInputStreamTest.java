package study.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author loongzhang
 * @Description DOING
 * @date 2023-01-11-10:18
 */
public class FIleInputStreamTest {
    public static void readPicture() throws IOException {
       // String name="src/study/resource/0111chineesewords.txt";
        //String name="src/study/resource/0111words.txt";
        String name="src/study/resource/1.jpg";
        File file = new File(name);
        System.out.println("文件的名字"+file+"文件的大小 "+file.length()+"字节");
        FileInputStream fileInputStream = new FileInputStream(name);
        String outPutStreamName="src/study/resource/2.jpg";
        File outPutFile = new File(outPutStreamName);

        if (!outPutFile.exists()){
            outPutFile.createNewFile();
        }
        FileOutputStream fileOutputStream = new FileOutputStream(outPutStreamName);
        int available = fileInputStream.available();
        byte[] bytes=new byte[available];
        //List<byte[]> byteArrayList = new ArrayList<>();
        int readCount=0;
        while((readCount=fileInputStream.read(bytes))!=-1){
            fileOutputStream.write(bytes);
        }
        fileInputStream.close();
    }
    public static void main(String[] args) throws IOException {
        readPicture();
    }
}
