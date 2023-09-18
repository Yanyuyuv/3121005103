package org.example;

import org.example.Utils.TxtException;
import org.example.Utils.SimilarityHash;
import org.example.Utils.IOtxt;
import org.example.Utils.HamMingUtils;
import org.junit.Test;


public class AppTest {

    String path1="C:\\Users\\zengyf\\Desktop\\测试文本\\orig.txt";//原文
    String path2="C:\\Users\\zengyf\\Desktop\\测试文本\\orig_0.8_add.txt";
    String path3="C:\\Users\\zengyf\\Desktop\\测试文本\\orig_0.8_del.txt";
    String path4="C:\\Users\\zengyf\\Desktop\\测试文本\\orig_0.8_dis_1.txt";
    String path5="C:\\Users\\zengyf\\Desktop\\测试文本\\orig_0.8_dis_10.txt";
    String path6="C:\\Users\\zengyf\\Desktop\\测试文本\\orig_0.8_dis_15.txt";

@Test// 把原文和其他文章对比
public void Test1(){
    try {
        String[] str = new String[6];
        str[0] = IOtxt.readTxt(path1);
        str[1] = IOtxt.readTxt(path2);
        str[2] = IOtxt.readTxt(path3);
        str[3] = IOtxt.readTxt(path4);
        str[4] = IOtxt.readTxt(path5);
        str[5] = IOtxt.readTxt(path6);
        String ansFileName = "C:\\Users\\zengyf\\Desktop\\测试文本\\ans.txt";//输出路径
        for(int i = 0; i <= 5; i++){
            double ans= HamMingUtils.getSimilarity(SimilarityHash.getSimHash(str[0]), SimilarityHash.getSimHash(str[i]));
            String result="查重率："+ans;
            IOtxt.writeTxt(result, ansFileName);
        }
    }catch (Exception err){
        System.out.println(err);
    }
}

    @Test     //原文与原文对比,查重率百分之百
    public void Test2(){
     try {
         String str0 = IOtxt.readTxt(path1);
         String str1 = IOtxt.readTxt(path1);
         String ansFileName = "C:\\Users\\zengyf\\Desktop\\测试文本\\ans1.txt";
         double ans = HamMingUtils.getSimilarity(SimilarityHash.getSimHash(str0), SimilarityHash.getSimHash(str1));
         String result="查重率："+ans;
         IOtxt.writeTxt(result, ansFileName);
     }catch (Exception err){
         System.out.println(err);
     }
    }

    @Test     //读入的路径不存在的异常情况
    public void Test3(){
        try {
            String str0 = IOtxt.readTxt("C:\\NotFound.txt");
            String str1 = IOtxt.readTxt(path1);
            String ansFileName = "C:\\Users\\zengyf\\Desktop\\测试文本\\ans2.txt";
            double ans = HamMingUtils.getSimilarity(SimilarityHash.getSimHash(str0), SimilarityHash.getSimHash(str1));
            String result="查重率："+ans;
            IOtxt.writeTxt(result, ansFileName);
        }catch (Exception err){
            err.printStackTrace();
            System.out.println("未找到指定路径文件");
        }
    }

    @Test     //写入的路径错误的异常情况
    public void Test4(){
        try {
            String str0 = IOtxt.readTxt(path1);
            String str1 = IOtxt.readTxt(path1);
            String ansFileName = "Z:\\Users\\zengyf\\Desktop\\测试文本\\ans3.txt";
            double ans = HamMingUtils.getSimilarity(SimilarityHash.getSimHash(str0), SimilarityHash.getSimHash(str1));
            String result="查重率："+ans;
            IOtxt.writeTxt(result, ansFileName);
        }catch (Exception err){
            err.printStackTrace();
            System.out.println("写入路径错误！");
        }
    }

    @Test     //正常读写(文章内容为空)
    public void Test5(){
        try {
            String str0 = IOtxt.readTxt("");
            String str1 = IOtxt.readTxt("");
            String ansFileName = "C:\\Users\\zengyf\\Desktop\\测试文本\\ans4.txt";
            double ans = HamMingUtils.getSimilarity(SimilarityHash.getSimHash(str0), SimilarityHash.getSimHash(str1));
            String result="查重率："+ans;
            IOtxt.writeTxt(result, ansFileName);
        }catch (Exception err){
            err.printStackTrace();
            System.out.println("文章内容太少");
        }
    }

    @Test     //正常读写(不传入参数)
    public void Test6(){
        try {
            String str0 = IOtxt.readTxt(path5);
            String str1 = IOtxt.readTxt(path6);
            String ansFileName = "C:\\Users\\zengyf\\Desktop\\测试文本\\ans5.txt";
            double ans = HamMingUtils.getSimilarity(SimilarityHash.getSimHash(), SimilarityHash.getSimHash());
            String result="查重率："+ans;
            IOtxt.writeTxt(result, ansFileName);
        }catch (Exception err){
            err.printStackTrace();
            System.out.println("请输入参数！");
        }
    }

    @Test     //正常读写(传入参数类型错误)
    public void Test7(){
        try {
            String str0 = IOtxt.readTxt(path2);
            String str1 = IOtxt.readTxt(path6);
            String ansFileName = "E:\\Users\\zengyf\\Desktop\\测试文本\\ans6.txt";
            double ans = HamMingUtils.getSimilarity(SimilarityHash.getSimHash(1), SimilarityHash.getSimHash(2));
            String result="查重率："+ans;
            IOtxt.writeTxt(result, ansFileName);
        }catch (Exception err){
            err.printStackTrace();
            System.out.println("传入参数类型错误！");
        }
    }

    @Test     //正常读写(文件内容差距大)
    public void Test8(){
        try {
            String str0 = IOtxt.readTxt(path1);
            String str1 = IOtxt.readTxt(path5);
            String ansFileName = "E:\\Users\\zengyf\\Desktop\\测试文本\\ans7.txt";
            double ans = HamMingUtils.getSimilarity(SimilarityHash.getSimHash(str0), SimilarityHash.getSimHash(str1));
            String result="查重率："+ans;
            IOtxt.writeTxt(result, ansFileName);
        }catch (Exception err){
            err.printStackTrace();
            System.out.println("写入路径错误！");
        }
    }

    @Test     //正常读写(文件内容差距小)
    public void Test9(){
        try {
            String str0 = IOtxt.readTxt(path3);
            String str1 = IOtxt.readTxt(path4);
            String ansFileName = "E:\\Users\\zengyf\\Desktop\\测试文本\\ans8.txt";
            double ans = HamMingUtils.getSimilarity(SimilarityHash.getSimHash(str0), SimilarityHash.getSimHash(str1));
            String result="查重率："+ans;
            IOtxt.writeTxt(result, ansFileName);
        }catch (Exception err){
            err.printStackTrace();
            System.out.println("写入路径错误！");
        }
    }

    @Test     //正常读写(文件内容差距大)
    public void Test10(){
        try {
            String str0 = IOtxt.readTxt(path4);
            String str1 = IOtxt.readTxt(path2);
            String ansFileName = "E:\\Users\\zengyf\\Desktop\\测试文本\\ans9.txt";
            double ans = HamMingUtils.getSimilarity(SimilarityHash.getSimHash(str0), SimilarityHash.getSimHash(str1));
            String result="查重率："+ans;
            IOtxt.writeTxt(result, ansFileName);
        }catch (Exception err){
            err.printStackTrace();
            System.out.println("写入路径错误！");
        }
    }
}