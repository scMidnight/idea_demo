package person.util;

import java.io.File;

/**
 * Created by SunChang on 2018/9/5
 */
public class FileUtil {

    /**
     * @Author SunChang
     * @Date 2018/9/5 15:33
     * @param path
     * @Description 删除单个文件
     */
    public static void delFile(String path) {
        File file = new File(path);
        if(file.exists() && file.isFile()) {
            if(file.delete()) {
                System.out.println("删除文件成功！");
            }else {
                System.err.println("删除失败！");
            }
        }
    }
}