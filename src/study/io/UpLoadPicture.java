package study.io;

import java.io.*;

/**
 * @author loongzhang
 * @Description DOING
 * @date 2023-01-11-11:16
 */
public class UpLoadPicture {

    public static void upLoadPicture() throws IOException {
        String path="src/study/resource/1.jpg";
        FileInputStream fileInputStream = new FileInputStream(path);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bytes=new byte[1024];
        int len=-1;
        while ((len=fileInputStream.read(bytes))!=-1){
            byteArrayOutputStream.write(bytes,0,len);
        }
        byte[] bytes1 = byteArrayOutputStream.toByteArray();
        System.out.println(bytes1);
    }

    public static void main(String[] args) throws IOException {
        upLoadPicture();
    }
}
