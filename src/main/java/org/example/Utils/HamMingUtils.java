package org.example.Utils;

public class HamMingUtils {
    //输入两个simHash值计算海明距离
    public static int getHammingDistance(String simHash1, String simHash2) {
        int distance = 0;
        if (simHash1.length() != simHash2.length()) {
            // error
            distance = -1;
        } else {
            for (int i = 0; i < simHash1.length(); i++) {
                if (simHash1.charAt(i) != simHash2.charAt(i)) {
                    distance++;
                }
            }
        }
        //海明距离
        return distance;
    }
    //输入两个simHash值，输出相似度
    public static double getSimilarity(String simHash1, String simHash2) {
        //获得海明距离
        int distance = getHammingDistance(simHash1, simHash2);
        //计算出相似度，并返回
        return 0.01 * (100 - distance * 100 / 128);
    }
}

