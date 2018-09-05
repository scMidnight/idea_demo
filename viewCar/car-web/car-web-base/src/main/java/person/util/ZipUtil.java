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
    public static void main(String[] args) {
        unZip("D:\\car\\uploader\\bak");
    }

    public static void read(String file, InputStream stream) throws IOException {
        LinkedList<String> list = new LinkedList<>();
        Workbook wb = null;
        String fileType = file.substring(file.lastIndexOf(".") + 1, file.length());
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
    }

    public static void unZip(String filePath) {
        try {
            BufferedOutputStream dest = null;
            BufferedInputStream is = null;
            ZipEntry entry;
            ZipFile zipFile = new ZipFile("D:\\car\\uploader\\bak\\0905数据.zip", Charset.forName("GBK"));
            Enumeration e = zipFile.entries();
            while (e.hasMoreElements()) {
                entry = (ZipEntry) e.nextElement();
                System.out.println(entry.getName());
                is = new BufferedInputStream(zipFile.getInputStream(entry));
                String outPath = (filePath+entry.getName()).replaceAll("\\*", "/");
                //判断路径是否存在,不存在则创建文件路径
                File file = new File(outPath.substring(0, outPath.lastIndexOf('/')));
                if(!file.exists()){
                    file.mkdirs();
                }
                //判断文件全路径是否为文件夹,如果是上面已经上传,不需要解压
                if(new File(outPath).isDirectory()){
                    continue;
                }
                if(entry.getName().lastIndexOf(".xls") != -1 || entry.getName().lastIndexOf(".xlsx") != -1) {
                    int count;
                    byte data[] = new byte[2048];
                    FileOutputStream fos = new FileOutputStream(outPath);
                    dest = new BufferedOutputStream(fos, 2048);
                    while ((count = is.read(data, 0, 2048)) != -1) {
                        dest.write(data, 0, count);
                    }
                }
                dest.flush();
                dest.close();
                is.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
