package org.example.Utils;
//导入java的io包
import java.io.*;
public class IOtxt {
    //读txt文件
    public static String readTxt(String txtPath) {
        String str = "";
        String strLine;
        //txt文件按行读入
        File file = new File(txtPath);
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            // 字符串拼接
            while ((strLine = bufferedReader.readLine()) != null) {
                str += strLine;
            }
            // 关闭资源
            inputStreamReader.close();
            bufferedReader.close();
            fileInputStream.close();
        } catch (IOException e) {
            System.out.println("文件路径错误，请重新输入!");
            e.printStackTrace();
        }
        return str;
    }
     // 写入txt文件
    public static void writeTxt(String str,String txtPath){
//        String str = Double.toString(txtElem);
        File file = new File(txtPath);
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file, true);
            fileWriter.write(str);
            fileWriter.write("\r\n");
            // 关闭资源
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
