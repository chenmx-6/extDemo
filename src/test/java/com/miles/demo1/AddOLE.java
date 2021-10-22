package com.miles.demo1;

/**
 * @Classname AddOLE
 * @Description TODO
 * @Date 2021-10-13 17:51
 * @Created by ChenMX
 */

import com.spire.doc.documents.ImageType;
import com.spire.xls.*;
import com.spire.xls.core.IOleObject;
import com.spire.doc.Document;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;


public class AddOLE {

    public static void main(String[] args) throws IOException {
        //加载excel文档
        Workbook wb = new Workbook();
        wb.loadFromFile("D:\\文档\\XBOM系统\\1013诊断BOM生成XML\\test.xlsx");

        //获取第一个工作表
//        Worksheet sheet = wb.getWorksheets().get(1);
        Worksheet sheet = wb.createEmptySheet();

        //获取Word文档图片
        String zipDir = "C:\\Temp\\EOL报表2021-10-13-14-51-47.zip";
        String docDir = "D:\\文档\\XBOM系统\\飞书移动签批\\feishuapproval\\移动签批.docx";
        BufferedImage image = ImageIO.read(new File("D:\\文档\\XBOM系统\\1013诊断BOM生成XML\\image.png"));

        //插入OLE到工作表指定单元格
//        IOleObject oleObject = sheet.getOleObjects().add(docx, image, OleLinkType.Embed);//插入指定类型的OLE
        IOleObject oleObject = sheet.getOleObjects().add(zipDir, image, OleLinkType.Embed);

        oleObject.setLocation(sheet.getCellRange("B10"));//指定单元格
        oleObject.setObjectType(OleObjectType.Package);//指定OLE对象类型（这里可支持多种类型）

        //保存文档
        wb.saveToFile("D:\\文档\\XBOM系统\\1013诊断BOM生成XML\\test_new.xlsx", ExcelVersion.Version2016);
        wb.dispose();
    }
    //定义一个GetWordImage(string docxFile) 方法获取图片，这里的图片来自于Word文档中的数据信息图像，将OLE对象插入到Excel工作表后，这个图像将显示在Excel工作表中

//    public void foo(Workbook workbook, Worksheet sheet, Cell cell, byte[] data, String label, String fileName) {
//        InputStream systemResource = ClassLoader.getSystemResourceAsStream("static/document_404px_1302124_easyicon.net.png");
//        final byte[] bytes = IOUtils.toByteArray(systemResource);
//        int picId = workbook.addPicture(bytes, PICTURE_TYPE_PNG);
//        final int olePackage = workbook.addOlePackage(data, label, fileName, null);
//        final Drawing<?> drawingPatriarch = sheet.createDrawingPatriarch();
//        final int columnIndex = cell.getColumnIndex();
//        final int rowIndex = cell.getRowIndex();
//        final ClientAnchor anchor = drawingPatriarch.createAnchor(0, 0, 0, 0, columnIndex, rowIndex, columnIndex + 1, rowIndex + 1);
//        drawingPatriarch.createObjectData(anchor, olePackage, picId);
//    }


    static BufferedImage GetWordImage(String docxFile) {
        //加载Word文档
        Document doc = new Document();
        doc.loadFromFile(docxFile);

        //将Word文档的第一页保存为图片
        Image olePicture = doc.saveToImages(0, ImageType.Bitmap);
        return (BufferedImage) olePicture;
    }

    public static byte[] file2buf(File fobj) throws IOException {
        byte[] buffer = null;
        try {
            if (!fobj.exists()) {
                return null;
            }

            FileInputStream fis = new FileInputStream(fobj);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] b = new byte[1024];
            int len = -1;
            while ((len = fis.read(b)) != -1) {
                bos.write(b, 0, len);
            }
            fis.close();
            bos.close();
            buffer = bos.toByteArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return buffer;
    }

}
