package person.util;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.nio.charset.Charset;
import java.text.DecimalFormat;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * Created by SunChang on 2018/9/5
 */
public class ZipUtil {
    public static void main(String[] args) throws IOException {
        //unZip("D:\\car\\uploader\\bak\\123456789", "D:\\car\\uploader\\bak\\123456789a\\");
        //LinkedList<String> list = read("D:\\car\\uploader\\bak\\123456789a\\0905数据\\0905-247-凯翼167911427670209-凯翼V3-全国.xlsx");
        //for (int i = 0; i < list.size(); i++) {
        //    String[] strs = list.get(i).split("\t");
        //    System.out.println(strs);
        //}
        //String a = "0905-247-凯翼167911427670209-凯翼V3-全国.xlsx";
        //System.out.println(a.substring(0, a.lastIndexOf(".")));
        //System.out.println(a.substring(a.lastIndexOf(".") + 1, a.length()));
        String a = "上海市";
        String b = "上海市";
        System.out.println(a.contains(b));
    }

    public static LinkedList<String> read(String filePath) throws IOException {
        LinkedList<String> list = new LinkedList<>();
        Workbook wb = null;
        String fileType = filePath.substring(filePath.lastIndexOf(".") + 1, filePath.length());
        InputStream stream = new FileInputStream(filePath);
        if (fileType.equals("xls")) {
            wb = new HSSFWorkbook(stream);
        } else if (fileType.equals("xlsx")) {
            wb = new XSSFWorkbook(stream);
        } else {
            System.out.println("您输入的excel格式不正确");
        }
        Sheet sheet1 = wb.getSheetAt(0);
        for (Row row : sheet1) {
            String c = "";
            for (int i = 0; i < row.getLastCellNum(); i++) {
                Cell cell = row.getCell(i);
                String mobile = "";
                if (cell != null) {
                    mobile = cell.toString();
                    DecimalFormat df = new DecimalFormat("#");
                    switch (cell.getCellType()) {
                        case HSSFCell.CELL_TYPE_NUMERIC:// 数字
                            mobile = df.format(cell.getNumericCellValue());
                            break;
                    }
                }
                c = c + mobile.replace("\"", "").trim() + "\t";
            }
            if (c.trim().length() > 0) {
                list.add(c);
            }
        }
        System.out.println(list);
        return list;
    }

    /**
     * @Author SunChang
     * @Date 2018/9/6 10:27
     * @param zipPath
    * @param targetPath
     * @Description 放入待解压的文件的路径包括文件名
     */
    public static void unZip(String zipPath, String targetPath) {
        try {
            BufferedOutputStream dest = null;
            BufferedInputStream is = null;
            ZipEntry entry;
            ZipFile zipFile = new ZipFile(zipPath, Charset.forName("GBK"));
            Enumeration e = zipFile.entries();
            while (e.hasMoreElements()) {
                entry = (ZipEntry) e.nextElement();
                is = new BufferedInputStream(zipFile.getInputStream(entry));
                String outPath = (targetPath + "原标-" + entry.getName()).replaceAll("\\*", "/");
                if(entry.isDirectory()) {
                    File file = new File(outPath);
                    if(!file.exists()) {
                        file.mkdirs();
                    }
                }else {
                    if (entry.getName().lastIndexOf(".xls") != -1 || entry.getName().lastIndexOf(".xlsx") != -1) {
                        int count;
                        byte data[] = new byte[2048];
                        FileOutputStream fos = new FileOutputStream(outPath);
                        dest = new BufferedOutputStream(fos, 2048);
                        while ((count = is.read(data, 0, 2048)) != -1) {
                            dest.write(data, 0, count);
                        }
                        dest.flush();
                        dest.close();
                        is.close();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
