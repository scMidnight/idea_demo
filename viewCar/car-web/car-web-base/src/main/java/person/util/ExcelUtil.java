package person.util;

import jodd.util.StringUtil;
import org.apache.commons.lang.time.DateUtils;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import person.db.bean.*;

import java.io.*;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class ExcelUtil {

    /**
     * HSSFWorkbook转换为inputStram
     * @param wb
     * @return
     */
    public static InputStream wbToInputstream(HSSFWorkbook wb) {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        try {
            wb.write(os);
        } catch (IOException e) {
            System.out.println("wb转换byte有误：" + e.getMessage());
            e.printStackTrace();
        }
        byte[] content = os.toByteArray();
        InputStream is = new ByteArrayInputStream(content);
        return is;
    }

    /*
     * 列头单元格样式
     */
    public static HSSFCellStyle getColumnTopStyle(HSSFWorkbook workbook) {
        // 设置字体
        HSSFFont font = workbook.createFont();
        //设置字体大小
        font.setFontHeightInPoints((short) 11);
        //字体加粗
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        //设置字体名字
        font.setFontName("Courier New");
        //设置样式;
        HSSFCellStyle style = workbook.createCellStyle();
        //设置底边框;
        style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        //设置底边框颜色;
        style.setBottomBorderColor(HSSFColor.BLACK.index);
        //设置左边框;
        style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        //设置左边框颜色;
        style.setLeftBorderColor(HSSFColor.BLACK.index);
        //设置右边框;
        style.setBorderRight(HSSFCellStyle.BORDER_THIN);
        //设置右边框颜色;
        style.setRightBorderColor(HSSFColor.BLACK.index);
        //设置顶边框;
        style.setBorderTop(HSSFCellStyle.BORDER_THIN);
        //设置顶边框颜色;
        style.setTopBorderColor(HSSFColor.BLACK.index);
        //在样式用应用设置的字体;
        style.setFont(font);
        //设置自动换行;
        style.setWrapText(false);
        //设置水平对齐的样式为居中对齐;
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        //设置垂直对齐的样式为居中对齐;
        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);

        return style;
    }

    /*
     * 列数据信息单元格样式
     */
    public static HSSFCellStyle getStyle(HSSFWorkbook workbook) {
        // 设置字体
        HSSFFont font = workbook.createFont();
        //设置字体大小
        //font.setFontHeightInPoints((short)10);
        //字体加粗
        //font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        //设置字体名字
        font.setFontName("Courier New");
        //设置样式;
        HSSFCellStyle style = workbook.createCellStyle();
        //设置底边框;
        style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        //设置底边框颜色;
        style.setBottomBorderColor(HSSFColor.BLACK.index);
        //设置左边框;
        style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        //设置左边框颜色;
        style.setLeftBorderColor(HSSFColor.BLACK.index);
        //设置右边框;
        style.setBorderRight(HSSFCellStyle.BORDER_THIN);
        //设置右边框颜色;
        style.setRightBorderColor(HSSFColor.BLACK.index);
        //设置顶边框;
        style.setBorderTop(HSSFCellStyle.BORDER_THIN);
        //设置顶边框颜色;
        style.setTopBorderColor(HSSFColor.BLACK.index);
        //在样式用应用设置的字体;
        style.setFont(font);
        //设置自动换行;
        style.setWrapText(false);
        //设置水平对齐的样式为居中对齐;
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        //设置垂直对齐的样式为居中对齐;
        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);

        return style;

    }

    /**
     * 导出Excel
     * @param sheetName sheet名称
     * @param title 标题
     * @param values 内容
     * @param wb HSSFWorkbook对象
     * @return HSSFWorkbook
     */
    public static HSSFWorkbook getHSSFWorkbook(String sheetName,String[] title,String[][] values, HSSFWorkbook wb) {
        // 第一步，创建一个HSSFWorkbook，对应一个Excel文件
        if(wb == null){
            wb = new HSSFWorkbook();
        }
        // 第二步，在workbook中添加一个sheet,对应Excel文件中的sheet
        HSSFSheet sheet = wb.createSheet(sheetName);
        // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制
        HSSFRow row = sheet.createRow(0);
        // 第四步，创建带格式的列头样式对象
        HSSFCellStyle columnTopStyle = getColumnTopStyle(wb);
        HSSFCellStyle style = getStyle(wb);//单元格内容样式对象

        //声明列对象
        HSSFCell cell = null;
        //创建标题
        for(int i=0;i<title.length;i++){
            cell = row.createCell(i);
            cell.setCellType(HSSFCell.CELL_TYPE_STRING);//设置列头单元格的数据类型
            cell.setCellValue(title[i]);
            cell.setCellStyle(columnTopStyle);
        }
        //创建内容
        for(int i=0;i<values.length;i++){
            row = sheet.createRow(i + 1);
            for(int j=0;j<values[i].length;j++){
                HSSFCell cellTemp = null;
                //设置单元格的数据类型
                cellTemp = row.createCell(j, HSSFCell.CELL_TYPE_STRING);
                //将内容按顺序赋给对应的列对象
                if (StringUtil.isNotBlank(values[i][j])) {
                    cellTemp.setCellValue(values[i][j]);//设置单元格的值
                }else {
                    cellTemp.setCellValue("");
                }
                cellTemp.setCellStyle(style);
            }
        }
        //让列宽随着导出的列长自动适应
        for (int colNum = 0; colNum < title.length; colNum++) {
            int columnWidth = sheet.getColumnWidth(colNum) / 256;
            for (int rowNum = 0; rowNum < sheet.getLastRowNum(); rowNum++) {
                HSSFRow currentRow;
                //当前行未被使用过
                if (sheet.getRow(rowNum) == null) {
                    currentRow = sheet.createRow(rowNum);
                } else {
                    currentRow = sheet.getRow(rowNum);
                }
                if (currentRow.getCell(colNum) != null) {
                    HSSFCell currentCell = currentRow.getCell(colNum);
                    if (currentCell.getCellType() == HSSFCell.CELL_TYPE_STRING) {
                        int length = currentCell.getStringCellValue().getBytes().length;
                        if (columnWidth < length) {
                            columnWidth = length;
                        }
                    }
                }
            }
            if (colNum == 0) {
                sheet.setColumnWidth(colNum, (columnWidth - 2) * 256);
            } else {
                sheet.setColumnWidth(colNum, (columnWidth + 4) * 256);
            }
        }
        return wb;
    }

    /**
     * @Author SunChang
     * @Date 2018/11/30 13:11
     * @param inputStream
    * @param fileType
     * @Description 广告项目管理用
     */
    public static List<TblAdProManageBean> readStreamAdProManage(InputStream inputStream, String fileType) throws IOException, ParseException {
        List<TblAdProManageBean> list = new ArrayList<>();
        InputStream stream = inputStream;
        Workbook wb = null;
        if (fileType.equals("xls")) {
            wb = new HSSFWorkbook(stream);
        } else if (fileType.equals("xlsx")) {
            wb = new XSSFWorkbook(stream);
        } else {
            System.out.println("您输入的excel格式不正确");
        }
        Sheet sheet1 = wb.getSheetAt(0);
        int rowNUmber = sheet1.getLastRowNum();
        for (int i = 1; i <= rowNUmber; i++) {
            Row row = sheet1.getRow(i);
            String val = "";
            for (int j = 0; j < row.getLastCellNum();j++) {
                Cell cell = row.getCell(j);
                if(cell !=null) {
                    DecimalFormat df = new DecimalFormat("#");
                    switch (cell.getCellType()) {
                        case HSSFCell.CELL_TYPE_NUMERIC:// 数字
                            if(DateUtil.isCellDateFormatted(cell)) {
                                Date theDate = cell.getDateCellValue();
                                SimpleDateFormat dff = new SimpleDateFormat("yyyy-MM-dd");
                                val += dff.format(theDate);
                            }else {
                                val += df.format(cell.getNumericCellValue()) + ",";
                            }
                            break;
                        default:
                            val += cell.toString() + ",";
                            break;
                    }

                }
            }
            String[] vals = val.split(",");
            TblAdProManageBean adProManageBean = new TblAdProManageBean();
            adProManageBean.setId(IdUtils.randomString());
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");// HH:mm:ss
            adProManageBean.setInsertDate(sdf.parse(vals[0]));
            adProManageBean.setProId(vals[1]);
            adProManageBean.setProName(vals[2]);
            adProManageBean.setBrandName(vals[3]);
            adProManageBean.setTradeName(vals[4]);
            adProManageBean.setCarSysName(vals[5]);
            adProManageBean.setStatus("0");
            list.add(adProManageBean);
        }
        return list;
    }

    /**
     * @Author SunChang
     * @Date 2018/11/30 13:11
     * @param inputStream
    * @param fileType
     * @Description 意向客户采集
     */
    public static List<TblIntentClientBean> readStreamIntentClient(InputStream inputStream, String fileType) throws IOException, ParseException {
        List<TblIntentClientBean> list = new ArrayList<>();
        InputStream stream = inputStream;
        Workbook wb = null;
        if (fileType.equals("xls")) {
            wb = new HSSFWorkbook(stream);
        } else if (fileType.equals("xlsx")) {
            wb = new XSSFWorkbook(stream);
        } else {
            System.out.println("您输入的excel格式不正确");
        }
        Sheet sheet1 = wb.getSheetAt(0);
        int rowNUmber = sheet1.getLastRowNum();
        for (int i = 1; i <= rowNUmber; i++) {
            Row row = sheet1.getRow(i);
            String val = "";
            for (int j = 0; j < row.getLastCellNum();j++) {
                Cell cell = row.getCell(j);
                if(cell !=null) {
                    DecimalFormat df = new DecimalFormat("#");
                    switch (cell.getCellType()) {
                        case HSSFCell.CELL_TYPE_NUMERIC:// 数字
                            if(DateUtil.isCellDateFormatted(cell)) {
                                Date theDate = cell.getDateCellValue();
                                SimpleDateFormat dff = new SimpleDateFormat("yyyy-MM-dd");
                                val += dff.format(theDate);
                            }else {
                                val += df.format(cell.getNumericCellValue()) + ",";
                            }
                            break;
                        default:
                            val += cell.toString() + ",";
                            break;
                    }

                }
            }
            String[] vals = val.split(",");
            TblIntentClientBean intentClientBean = new TblIntentClientBean();
            intentClientBean.setId(IdUtils.randomString());
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");// HH:mm:ss
            intentClientBean.setInsertDate(sdf.parse(vals[0]));
            intentClientBean.setUserName(vals[1]);
            intentClientBean.setPhone(vals[2]);
            intentClientBean.setAge(vals[3]);
            intentClientBean.setBrandName(vals[4]);
            intentClientBean.setCarSys(vals[5]);
            intentClientBean.setCarProduct(vals[6]);
            intentClientBean.setStage(vals[7]);
            intentClientBean.setSource(vals[8]);
            list.add(intentClientBean);
        }
        return list;
    }

    /**
     * @Author SunChang
     * @Date 2018/11/30 13:11
     * @param inputStream
    * @param fileType
     * @Description 汽车流量分析用
     */
    public static List<TblFlowAnalysisBean> readStreamFlowAnalysis(InputStream inputStream, String fileType) throws IOException, ParseException {
        List<TblFlowAnalysisBean> list = new ArrayList<>();
        InputStream stream = inputStream;
        Workbook wb = null;
        if (fileType.equals("xls")) {
            wb = new HSSFWorkbook(stream);
        } else if (fileType.equals("xlsx")) {
            wb = new XSSFWorkbook(stream);
        } else {
            System.out.println("您输入的excel格式不正确");
        }
        Sheet sheet1 = wb.getSheetAt(0);
        int rowNUmber = sheet1.getLastRowNum();
        for (int i = 1; i <= rowNUmber; i++) {
            Row row = sheet1.getRow(i);
            String val = "";
            for (int j = 0; j < row.getLastCellNum();j++) {
                Cell cell = row.getCell(j);
                if(cell !=null) {
                    DecimalFormat df = new DecimalFormat("#");
                    switch (cell.getCellType()) {
                        case HSSFCell.CELL_TYPE_NUMERIC:// 数字
                            if(DateUtil.isCellDateFormatted(cell)) {
                                Date theDate = cell.getDateCellValue();
                                SimpleDateFormat dff = new SimpleDateFormat("yyyy-MM-dd");
                                val += dff.format(theDate);
                            }else {
                                val += df.format(cell.getNumericCellValue()) + ",";
                            }
                            break;
                        default:
                            val += cell.toString() + ",";
                            break;
                    }

                }
            }
            String[] vals = val.split(",");
            TblFlowAnalysisBean flowAnalysisBean = new TblFlowAnalysisBean();
            flowAnalysisBean.setId(IdUtils.randomString());
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");// HH:mm:ss
            SimpleDateFormat sdfM=new SimpleDateFormat("yyyy-MM");// HH:mm:ss
            flowAnalysisBean.setInsertDate(sdf.parse(vals[0]));
            Date date = sdfM.parse(vals[0]);
            flowAnalysisBean.setInsertMonth(sdfM.format(date));
            flowAnalysisBean.setModuleName(vals[1]);
            flowAnalysisBean.setTitleName(vals[2]);
            flowAnalysisBean.setExposureNum(vals[3]);
            flowAnalysisBean.setClickNum(vals[4]);
            list.add(flowAnalysisBean);
        }
        return list;
    }

    /**
     * @Author SunChang
     * @Date 2018/11/30 13:11
     * @param inputStream
    * @param fileType
     * @Description 线下潜客用
     */
    public static List<TblOfflineFilterBean> readStreamOffLine(InputStream inputStream, String fileType) throws IOException, ParseException {
        List<TblOfflineFilterBean> list = new ArrayList<>();
        InputStream stream = inputStream;
        Workbook wb = null;
        if (fileType.equals("xls")) {
            wb = new HSSFWorkbook(stream);
        } else if (fileType.equals("xlsx")) {
            wb = new XSSFWorkbook(stream);
        } else {
            System.out.println("您输入的excel格式不正确");
        }
        Sheet sheet1 = wb.getSheetAt(0);
        int rowNUmber = sheet1.getLastRowNum();
        for (int i = 1; i <= rowNUmber; i++) {
            Row row = sheet1.getRow(i);
            String val = "";
            for (int j = 0; j < row.getLastCellNum();j++) {
                Cell cell = row.getCell(j);
                if(cell !=null) {
                    DecimalFormat df = new DecimalFormat("#");
                    switch (cell.getCellType()) {
                        case HSSFCell.CELL_TYPE_NUMERIC:// 数字
                            if(DateUtil.isCellDateFormatted(cell)) {
                                Date theDate = cell.getDateCellValue();
                                SimpleDateFormat dff = new SimpleDateFormat("yyyy-MM-dd");
                                val += dff.format(theDate);
                            }else {
                                val += df.format(cell.getNumericCellValue()) + ",";
                            }
                            break;
                        default:
                            val += cell.toString() + ",";
                            break;
                    }

                }
            }
            String[] vals = val.split(",");
            TblOfflineFilterBean offlineFilterBean = new TblOfflineFilterBean();
            offlineFilterBean.setId(IdUtils.randomString());
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");// HH:mm:ss
            SimpleDateFormat sdfM=new SimpleDateFormat("yyyy-MM");// HH:mm:ss
            offlineFilterBean.setInsertDate(sdf.parse(vals[0]));
            Date date = sdfM.parse(vals[0]);
            offlineFilterBean.setInsertMonth(sdfM.format(date));
            offlineFilterBean.setSource(vals[1]);
            offlineFilterBean.setCity(vals[2]);
            offlineFilterBean.setBrandName(vals[3]);
            offlineFilterBean.setOfflineFlow(vals[4]);
            offlineFilterBean.setStayDate(vals[4]);
            list.add(offlineFilterBean);
        }
        return list;
    }

    /**
     * @Author SunChang
     * @Date 2018/11/30 13:11
     * @param inputStream
    * @param fileType
     * @Description 读取附件中内容插入实体类集合
     */
    public static List<TblShowBean> readStream(InputStream inputStream, String fileType) throws IOException {
        List<TblShowBean> list = new ArrayList<>();
        InputStream stream = inputStream;
        Workbook wb = null;
        if (fileType.equals("xls")) {
            wb = new HSSFWorkbook(stream);
        } else if (fileType.equals("xlsx")) {
            wb = new XSSFWorkbook(stream);
        } else {
            System.out.println("您输入的excel格式不正确");
        }
        Sheet sheet1 = wb.getSheetAt(0);
        int rowNUmber = sheet1.getLastRowNum();
        for (int i = 1; i <= rowNUmber; i++) {
            Row row = sheet1.getRow(i);
            String val = "";
            for (int j = 0; j < row.getLastCellNum();j++) {
                Cell cell = row.getCell(j);
                if(cell !=null) {
                    DecimalFormat df = new DecimalFormat("#");
                    switch (cell.getCellType()) {
                        case HSSFCell.CELL_TYPE_NUMERIC:// 数字
                            if(DateUtil.isCellDateFormatted(cell)) {
                                Date theDate = cell.getDateCellValue();
                                SimpleDateFormat dff = new SimpleDateFormat("yyyy-MM-dd");
                                val += dff.format(theDate);
                            }else {
                                val += df.format(cell.getNumericCellValue()) + ",";
                            }
                            break;
                        default:
                            val += cell.toString() + ",";
                            break;
                    }

                }
            }
            String[] vals = val.split(",");
            TblShowBean tblShowBean = new TblShowBean();
            tblShowBean.setId(IdUtils.randomString());
            tblShowBean.setSource(vals[0]);
            tblShowBean.setIntentionPerson(vals[1]);
            tblShowBean.setCityOrientation(vals[2]);
            tblShowBean.setIntentionBrand(vals[3]);
            tblShowBean.setIntentionTrade(vals[4]);
            tblShowBean.setIntentionModel(vals[5]);
            tblShowBean.setPhone(vals[6]);
            tblShowBean.setNetworkNum(vals[7]);
            tblShowBean.setAnalysis(vals[8]);
            tblShowBean.setCarMonth(vals[9]);
            tblShowBean.setInsertDate(vals[10]);
            list.add(tblShowBean);
        }
        return list;
    }

    /**
     * @Author SunChang
     * @Date 2018/9/5 17:01
     * @param filePath
     * @Description 读取excel内容
     */
    public static LinkedList<String> read(String filePath) throws IOException {
        LinkedList<String> list = new LinkedList<>();
        String fileType = filePath.substring(filePath.lastIndexOf(".") + 1, filePath.length());
        InputStream stream = new FileInputStream(filePath);
        Workbook wb = null;
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
            for (int i = 0; i < row.getLastCellNum();i++) {
                Cell cell = row.getCell(i);
                String mobile = "";
                if(cell !=null) {
                    mobile = cell.toString();
                    DecimalFormat df = new DecimalFormat("#");
                    switch (cell.getCellType()) {
                        case HSSFCell.CELL_TYPE_NUMERIC:// 数字
                            mobile = df.format(cell.getNumericCellValue());
                            break;
                    }
                }
                if(i == 3) {
                    c += mobile.trim() + "\t";
                }else {
                    mobile = mobile.replaceAll("\\s*", "");
                    mobile = mobile.replace("  ", "");
                    mobile = mobile.replace(" ", "");
                    c += mobile.replace("\"", "").trim() + "\t";
                }
            }
            if (c.trim().length() > 0) {
                list.add(c);
            }
        }
        list.add(new File(filePath).getName());
        return list;
    }

    /**
     * @Author SunChang
     * @Date 2018/9/5 17:01
     * @param outPath
    * @param dataList
     * @Description 输出excel
     */
    public static boolean write(String outPath, List<String[]> dataList) throws Exception {
        String fileType = outPath.substring(outPath.lastIndexOf(".") + 1, outPath.length());
        System.out.println(fileType);
        // 创建工作文档对象
        Workbook wb = null;
        if (fileType.equals("xls")) {
            wb = new HSSFWorkbook();
        } else if (fileType.equals("xlsx")) {
            wb = new XSSFWorkbook();
        } else {
            System.out.println("您的文档格式不正确！");
            return false;
        }
        // 创建sheet对象
        Sheet sheet1 = (Sheet) wb.createSheet("sheet1");
        // 循环写入行数据
        for (int i = 0; i < dataList.size(); i++) {
            Row row = (Row) sheet1.createRow(i);
            String[] col = dataList.get(i);
            for (int j = 0; j < col.length; j++) {
                Cell cell = row.createCell(j);
                cell.setCellValue(col[j]);
            }
        }
        // 创建文件流
        OutputStream stream = new FileOutputStream(outPath);
        // 写入数据
        wb.write(stream);
        // 关闭文件流
        stream.close();
        return true;
    }

    /**
     * @Author SunChang
     * @Date 2018/9/5 17:01
    * @param dataList
     * @Description 输出excel
     */
    public static boolean writeWeb(OutputStream out, List<String[]> dataList) throws Exception {
        // 创建工作文档对象
        Workbook wb = new XSSFWorkbook();
        // 创建sheet对象
        Sheet sheet1 = (Sheet) wb.createSheet("sheet1");
        // 循环写入行数据
        for (int i = 0; i < dataList.size(); i++) {
            Row row = (Row) sheet1.createRow(i);
            String[] col = dataList.get(i);
            for (int j = 0; j < col.length; j++) {
                Cell cell = row.createCell(j);
                cell.setCellValue(col[j]);
            }
        }
        // 写入数据
        wb.write(out);
        // 关闭文件流
        out.close();
        return true;
    }

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM");
        String date = "2018-01-01";
        Date date1 = sdf.parse(date);
        System.out.println(sdf.format(date1));
        //try {
        //    read("C:\\Users\\SunChang\\Desktop\\原-1120-12046-一汽丰田奕泽IZOA9-11月-丰田-全国.xls");
        //} catch (IOException e) {
        //    e.printStackTrace();
        //}
    }
}
