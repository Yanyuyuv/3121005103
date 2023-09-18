package org.example;
import org.example.Utils.HamMingUtils;
import org.example.Utils.IOtxt;
import org.example.Utils.SimilarityHash;
import org.example.Utils.TxtException;

public class App 
{
    public static void main( String[] args )
    {
        String str0 = IOtxt.readTxt(args[0]);//文件1的路径
        String str1 = IOtxt.readTxt(args[1]);//文件2
        String resultFileName = args[2];
        // simHash值
        String simHash0 = SimilarityHash.getSimHash(str0);
        String simHash1 = SimilarityHash.getSimHash(str1);
        // 求相似度
        double similarity = HamMingUtils.getSimilarity(simHash0, simHash1);
        String result="查重率:"+similarity;
        // 写结果文件
        IOtxt.writeTxt(result, resultFileName);
        // 退出程序
        System.exit(0);
    }
}
