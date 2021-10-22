package com.miles.demo1;

/**
 * @Classname ImageToStr
 * @Description TODO
 * @Date 2021-10-21 18:36
 * @Created by ChenMX
 */

import org.json.JSONArray;
import org.json.JSONObject;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;

public class ImageToStr {

    public static void createAsciiPic(final String path,final String base) {
        //final String base = "@#&$%*o!;.";// 字符串由复杂到简单
//        final String base = "KSPkscxscsdcsap;.";
        try {
            final BufferedImage image = ImageIO.read(new File(path));
            System.out.println("W:" + image.getWidth() + " H:" + image.getHeight());
            for (int y = 0; y < image.getHeight(); y += 2) {
                for (int x = 0; x < image.getWidth(); x++) {
                    final int pixel = image.getRGB(x, y);
                    final int r = (pixel & 0xff0000) >> 16, g = (pixel & 0xff00) >> 8, b = pixel & 0xff;
                    final float gray = 0.299f * r + 0.578f * g + 0.114f * b;
                    final int index = Math.round(gray * (base.length() + 1) / 255);
                    System.out.print(index >= base.length() ? " " : String.valueOf(base.charAt(index)));
                }
                System.out.println();
            }
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) throws IOException {
        File file = new File("D:\\文档\\XBOM系统\\1013诊断BOM生成XML\\digitalDevelopment.json");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        String line=null;
        StringBuilder stringBuilder = new StringBuilder();
        while((line= bufferedReader.readLine())!=null){
            stringBuilder.append(line);
        }
        String s = stringBuilder.toString();
        JSONArray array = new JSONArray(s);
        StringBuilder stringBuilder1 = new StringBuilder();
        for (int i = 0; i < array.length(); i++) {
            stringBuilder1.append(array.get(i)+"  ");
        }
        String staffs = stringBuilder1.toString();
        System.out.println(staffs);
        ImageToStr.createAsciiPic("D:\\文档\\XBOM系统\\1013诊断BOM生成XML\\testImage.jpg",staffs);
    }


}