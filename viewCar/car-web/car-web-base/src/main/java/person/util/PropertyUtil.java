package person.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by SunChang on 2019/1/12
 * properties文件获取工具类
 */
public class PropertyUtil {
    private static Properties props;

    static {
        loadProps();
    }

    synchronized static private void loadProps() {
        props = new Properties();
        InputStream in = null;
        //第一种，通过类加载器进行获取properties文件流
        //in = PropertyUtil.class.getClassLoader().getResourceAsStream("sysConfig.properties");
        //第二种，通过类进行获取properties文件流
        try {
            in = PropertyUtil.class.getResourceAsStream("/sysConfig.properties");
            props.load(in);
        } catch (FileNotFoundException e) {
            //logger.error("sysConfig.properties文件未找到");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != in) {
                    in.close();
                }
            } catch (IOException e) {
                //logger.error("sysConfig.properties文件流关闭出现异常");
            }
        }
    }

    public static String getProperty(String key) {
        if (null == props) {
            loadProps();
        }
        return props.getProperty(key);
    }
}
