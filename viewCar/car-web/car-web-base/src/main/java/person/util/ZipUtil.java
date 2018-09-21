package person.util;

import jodd.util.StringUtil;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

/**
 * Created by SunChang on 2018/9/5
 */
public class ZipUtil {
    private static final int  BUFFER_SIZE = 2 * 1024;
    public static void main(String[] args) throws IOException {
        //unZip("D:\\car\\uploader\\bak\\111.zip", "D:\\car\\uploader\\bak\\111\\");
        //LinkedList<String> list = read("D:\\car\\uploader\\bak\\123456789a\\0905数据\\0905-247-凯翼167911427670209-凯翼V3-全国.xlsx");
        //for (int i = 0; i < list.size(); i++) {
        //    String[] strs = list.get(i).split("\t");
        //    System.out.println(strs);
        //}
        //String a = "0905-247-凯翼167911427670209-凯翼V3-全国.xlsx";
        //System.out.println(a.substring(0, a.lastIndexOf(".")));
        //System.out.println(a.substring(a.lastIndexOf(".") + 1, a.length()));
        /** 测试压缩方法1  */
        //FileOutputStream fos1 = new FileOutputStream(new File("D:\\car\\uploader\\bak\\zzz.zip"));
        //toZip("D:\\car\\uploader\\bak\\9891420180906142013924a", fos1,true);
        /**
         * 压缩文件
         */
        //File file = new File("D:\\car\\uploader\\bak\\111");
        //File[] files = file.listFiles();
        //FileOutputStream fos1 = new FileOutputStream(new File("D:\\car\\uploader\\bak\\111.zip"));
        //zipFiles(fos1, "", files);
        File[] files = new File("D:/car/uploader/bak/xxxxa/").listFiles();
        File file = new File("D:/car/uploader/bak/test.zip");
        FileOutputStream fos1 = new FileOutputStream(file);
        ZipUtil.zipFiles(fos1, "", files);
    }

    /**
     * 压缩文件-由于out要在递归调用外,所以封装一个方法用来
     * 调用ZipFiles(ZipOutputStream out,String path,File... srcFiles)
     *
     * @param out
     * @param path
     * @param srcFiles
     * @throws IOException
     * @author isea533
     */
    public static void zipFiles(OutputStream out, String path, File... srcFiles) throws IOException {
        ZipOutputStream zos = new ZipOutputStream(out);
        ZipUtil.zipFiles(zos, path, srcFiles);
        zos.close();
        System.out.println("*****************压缩完毕*******************");
    }

    /**
     * 压缩文件-File
     *
     * @param srcFiles 被压缩源文件
     * @author isea533
     */
    public static void zipFiles(ZipOutputStream out, String path, File... srcFiles) {
        if(StringUtil.isNotBlank(path)) {
            path = path.replaceAll("\\*", "/");
            if (!path.endsWith("/")) {
                path += "/";
            }
        }
        byte[] buf = new byte[1024];
        try {
            for (int i = 0; i < srcFiles.length; i++) {
                if (srcFiles[i].isDirectory()) {
                    File[] files = srcFiles[i].listFiles();
                    String srcPath = srcFiles[i].getName();
                    srcPath = srcPath.replaceAll("\\*", "/");
                    if (!srcPath.endsWith("/")) {
                        srcPath += "/";
                    }
                    out.putNextEntry(new ZipEntry(path + srcPath));
                    zipFiles(out, path + srcPath, files);
                } else {
                    FileInputStream in = new FileInputStream(srcFiles[i]);
                    System.out.println(path + srcFiles[i].getName());
                    out.putNextEntry(new ZipEntry(path + srcFiles[i].getName()));
                    int len;
                    while ((len = in.read(buf)) > 0) {
                        out.write(buf, 0, len);
                    }
                    out.closeEntry();
                    in.close();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 压缩成ZIP 方法1
     * @param srcDir 压缩文件夹路径
     * @param out    压缩文件输出流
     * @param KeepDirStructure  是否保留原来的目录结构,true:保留目录结构;
     *                          false:所有文件跑到压缩包根目录下(注意：不保留目录结构可能会出现同名文件,会压缩失败)
     * @throws RuntimeException 压缩失败会抛出运行时异常
     */
    public static void toZip(String srcDir, OutputStream out, boolean KeepDirStructure) {
        long start = System.currentTimeMillis();
        ZipOutputStream zos = null ;
        try {
            zos = new ZipOutputStream(out);
            File sourceFile = new File(srcDir);
            compress(sourceFile,zos,sourceFile.getName(),KeepDirStructure);
            long end = System.currentTimeMillis();
            System.out.println("压缩完成，耗时：" + (end - start) +" ms");
        } catch (Exception e) {
            throw new RuntimeException("zip error from ZipUtils",e);
        }finally{
            if(zos != null){
                try {
                    zos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 递归压缩方法
     * @param sourceFile 源文件
     * @param zos        zip输出流
     * @param name       压缩后的名称
     * @param KeepDirStructure  是否保留原来的目录结构,true:保留目录结构;
     *                          false:所有文件跑到压缩包根目录下(注意：不保留目录结构可能会出现同名文件,会压缩失败)
     * @throws Exception
     */
    private static void compress(File sourceFile, ZipOutputStream zos, String name, boolean KeepDirStructure) throws Exception{
        byte[] buf = new byte[BUFFER_SIZE];
        if(sourceFile.isFile()){
            // 向zip输出流中添加一个zip实体，构造器中name为zip实体的文件的名字
            zos.putNextEntry(new ZipEntry(name));
            // copy文件到zip输出流中
            int len;
            FileInputStream in = new FileInputStream(sourceFile);
            while ((len = in.read(buf)) != -1){
                zos.write(buf, 0, len);
            }
            // Complete the entry
            zos.closeEntry();
            in.close();
        } else {
            File[] listFiles = sourceFile.listFiles();
            if(listFiles == null || listFiles.length == 0){
                // 需要保留原来的文件结构时,需要对空文件夹进行处理
                if(KeepDirStructure){
                    // 空文件夹的处理
                    zos.putNextEntry(new ZipEntry(name + "/"));
                    // 没有文件，不需要文件的copy
                    zos.closeEntry();
                }
            }else {
                for (File file : listFiles) {
                    // 判断是否需要保留原来的文件结构
                    if (KeepDirStructure) {
                        // 注意：file.getName()前面需要带上父文件夹的名字加一斜杠,
                        // 不然最后压缩包中就不能保留原来的文件结构,即：所有文件都跑到压缩包根目录下了
                        compress(file, zos, name + "/" + file.getName(),KeepDirStructure);
                    } else {
                        compress(file, zos, file.getName(),KeepDirStructure);
                    }
                }
            }
        }
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
            File targetFile = new File(targetPath);
            if(!targetFile.exists()) {
                targetFile.mkdirs();
            }
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
                    if(entry.getName().indexOf("/") == -1) {
                        outPath = (targetPath + entry.getName()).replaceAll("\\*", "/");
                    }
                    if (entry.getName().lastIndexOf(".xls") != -1 || entry.getName().lastIndexOf(".xlsx") != -1) {
                        if(outPath.lastIndexOf("/") != -1) {
                            File fileTem = new File(outPath.substring(0, outPath.lastIndexOf("/") + 1));
                            if(!fileTem.exists()) {
                                fileTem.mkdirs();
                            }
                        }
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
