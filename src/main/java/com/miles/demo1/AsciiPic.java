package com.miles.demo1;

/**
 * @Classname AsciiPic
 * @Description TODO
 * @Date 2021-10-21 19:28
 * @Created by ChenMX
 */

import org.json.JSONArray;

import java.awt.image.BufferedImage;
import java.io.*;

import javax.imageio.ImageIO;

/**
 * @author 东哥 2016年10月27日
 */
public class AsciiPic {

    /**
     * @param path 图片路径
     */
    public static void createAsciiPic(final String path, String base) {
        //final String base = "\"@#&$%*o!;.";// 字符串由复杂到简单
//        final String base = "#8XOHLTI)i=+;:,. ";// 字符串由复杂到简单
        try {
            final BufferedImage image = ImageIO.read(new File(path));  //读取图片
            //输出到指定文件中
            final BufferedWriter fos = new BufferedWriter(new FileWriter("D:\\文档\\XBOM系统\\1013诊断BOM生成XML\\test.txt", false));   //true表示是否追加
            int i = 0;
            float rate=0.5f;
            for (int y = 0; y < image.getHeight(); y += 2) {
                for (int x = 0; x < image.getWidth(); x++) {
                    final int pixel = image.getRGB(x, y);
                    final int r = (pixel & 0xff0000) >> 16, g = (pixel & 0xff00) >> 8, b = pixel & 0xff;
                    final float gray = 0.299f * r + 0.578f * g + 0.114f * b;
                    final int index = Math.round(gray * (base.length() + 1) / 255);
                    String s;
                    if (index <= 16) {
                        if (i > 4617) {
                            s = "#";
                        } else {
                            Character c = null;
                            c = base.charAt(i++);
                            s = String.valueOf(c);
                        }
                    } else {
                        s = " ";
                    }
                    fos.write(s);
                    System.out.print(s);
                }
                fos.newLine();
                System.out.println();
            }
            fos.close();
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * test
     *
     * @param args
     */
    public static void main(final String[] args) throws IOException {
        File file = new File("D:\\文档\\XBOM系统\\1013诊断BOM生成XML\\digitalDevelopment.json");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        String line = null;
        StringBuilder stringBuilder = new StringBuilder();
        while ((line = bufferedReader.readLine()) != null) {
            stringBuilder.append(line);
        }
        String s = stringBuilder.toString();
        JSONArray array = new JSONArray(s);
        StringBuilder stringBuilder1 = new StringBuilder();
        for (int i = 0; i < array.length(); i++) {
            stringBuilder1.append(array.get(i) + " ");
        }
        String staffs = stringBuilder1.toString();
        System.out.println(staffs.length());
        AsciiPic.createAsciiPic("D:\\文档\\XBOM系统\\1013诊断BOM生成XML\\imageBig.jpg", staffs);
    }

}
