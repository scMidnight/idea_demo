package person;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by SunChang on 2018/8/22
 */
public class StringUtils {
    private static Pattern numericPattern = Pattern.compile("^[0-9\\-]+$");
    private static Pattern numericStringPattern = Pattern.compile("^[0-9\\-\\-]+$");
    private static Pattern floatNumericPattern = Pattern.compile("^[0-9\\-\\.]+$");
    private static Pattern abcPattern = Pattern.compile("^[a-z|A-Z]+$");
    public static final String splitStrPattern = ",|，|;|；|、|\\.|。|-|_|\\(|\\)|\\[|\\]|\\{|\\}|\\\\|/| |　|\"";
    private static Log logger = LogFactory.getLog(StringUtils.class);
    private static final String CHARSET_NAME = "UTF-8";
    public static final String EMPTY = "";

    public StringUtils() {
    }

    public static String[] split(String str, String separatorChar) {
        return str.split(separatorChar);
    }
    public static boolean equals(String s1, String s2) {
        if (isEmpty(s1) && isEmpty(s2)) {
            return true;
        } else {
            return !isEmpty(s1) && !isEmpty(s2) ? s1.equals(s2) : false;
        }
    }
    public static boolean isEmpty(String s) {
        return s == null || s.equals("");
    }

    public static List<String> StringToList(String from) {
        List<String> functionList = new ArrayList();
        String[] nodeArr = from.split(",");

        for(int i = 0; i < nodeArr.length; ++i) {
            functionList.add(nodeArr[i]);
        }

        return functionList;
    }
    public static String lowerCase(String str) {
        return str == null ? null : str.toLowerCase();
    }

    public static boolean isNotEmpty(Object str) {
        boolean flag = true;
        if (str != null && !str.equals("")) {
            if (str.toString().length() > 0) {
                flag = true;
            }
        } else {
            flag = false;
        }

        return flag;
    }
    public static String join(Iterator iterator, String separator) {
        if (iterator == null) {
            return null;
        } else if (!iterator.hasNext()) {
            return "";
        } else {
            Object first = iterator.next();
            if (!iterator.hasNext()) {
                return toString(first);
            } else {
                StringBuffer buf = new StringBuffer(256);
                if (first != null) {
                    buf.append(first);
                }

                while(iterator.hasNext()) {
                    if (separator != null) {
                        buf.append(separator);
                    }

                    Object obj = iterator.next();
                    if (obj != null) {
                        buf.append(obj);
                    }
                }

                return buf.toString();
            }
        }
    }
    public static String toString(Object obj) {

        return obj == null ? "" : obj.toString();
    }

    public static boolean contains(String str, String searchStr) {
        if (str != null && searchStr != null) {
            return str.indexOf(searchStr) >= 0;
        } else {
            return false;
        }
    }
}
