package person.util;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * Created by SunChang on 2018/9/5
 */
public class FileUtil {

    public static void main(String[] args) throws IOException {
    }

    /**
     * @Author SunChang
     * @Date 2018/9/7 14:06
     * @param path
    * @param oldName
    * @param newName
     * @Description 重命名文件
     */
    public static boolean renameFile(String path, String oldName, String newName) {
        //新的文件名和以前文件名不同时,才有必要进行重命名
        if (!oldName.equals(newName)) {
            File oldfile = new File(path + "/" + oldName);
            File newfile = new File(path + "/" + newName);
            if (!oldfile.exists()) {
                System.out.println("重命名文件失败，" + oldName +"不存在！");
                return false;
            }
            //若在该目录下已经有一个文件和新文件名相同，则不允许重命名
            if (newfile.exists()) {
                System.out.println("重命名文件失败，" + newName + "已经存在！");
                return false;
            } else {
                oldfile.renameTo(newfile);
            }
        }
        return true;
    }

    /**
     * @Author SunChang
     * @Date 2018/9/5 15:33
     * @param path
     * @Description 删除单个文件
     */
    public static void delFile(String path) {
        File file = new File(path);
        if(file.exists() && file.isFile()) {
            System.gc();
            if(file.delete()) {
                System.out.println("删除文件成功！");
            }else {
                System.gc();
                file.delete();
                System.err.println("删除失败！");
            }
        }
    }
}
