package person.util;

import com.google.gson.Gson;
import net.sf.ezmorph.object.DateMorpher;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.JSONUtils;

import java.util.*;

/**
 * Created by SunChang on 2018/8/22
 */
public class JsonUtil {
    public static final String JSON_ATTRIBUTE = "json";
    public static final String JSON_ATTRIBUTE1 = "json1";
    public static final String JSON_ATTRIBUTE2 = "json2";
    public static final String JSON_ATTRIBUTE3 = "json3";
    public static final String JSON_ATTRIBUTE4 = "json4";

    public JsonUtil() {
    }

    public static Object getDTO(String jsonString, Class clazz) {
        JSONObject jsonObject = null;

        try {
            setDataFormat2JAVA();
            jsonObject = JSONObject.fromObject(jsonString);
        } catch (Exception var4) {
            var4.printStackTrace();
        }

        return JSONObject.toBean(jsonObject, clazz);
    }

    public static Object getDTO(String jsonString, Class clazz, Map map) {
        JSONObject jsonObject = null;

        try {
            setDataFormat2JAVA();
            jsonObject = JSONObject.fromObject(jsonString);
        } catch (Exception var5) {
            var5.printStackTrace();
        }

        return JSONObject.toBean(jsonObject, clazz, map);
    }

    public static Object[] getDTOArray(String jsonString, Class clazz) {
        setDataFormat2JAVA();
        JSONArray array = JSONArray.fromObject(jsonString);
        Object[] obj = new Object[array.size()];

        for(int i = 0; i < array.size(); ++i) {
            JSONObject jsonObject = array.getJSONObject(i);
            obj[i] = JSONObject.toBean(jsonObject, clazz);
        }

        return obj;
    }

    public static Object[] getDTOArray(String jsonString, Class clazz, Map map) {
        setDataFormat2JAVA();
        JSONArray array = JSONArray.fromObject(jsonString);
        Object[] obj = new Object[array.size()];

        for(int i = 0; i < array.size(); ++i) {
            JSONObject jsonObject = array.getJSONObject(i);
            obj[i] = JSONObject.toBean(jsonObject, clazz, map);
        }

        return obj;
    }

    public static List getDTOList(String jsonString, Class clazz) {
        setDataFormat2JAVA();
        JSONArray array = JSONArray.fromObject(jsonString);
        List list = new ArrayList();
        Iterator iter = array.iterator();

        while(iter.hasNext()) {
            JSONObject jsonObject = (JSONObject)iter.next();
            list.add(JSONObject.toBean(jsonObject, clazz));
        }

        return list;
    }

    public static List getDTOList(String jsonString, Class clazz, Map map) {
        setDataFormat2JAVA();
        JSONArray array = JSONArray.fromObject(jsonString);
        List list = new ArrayList();
        Iterator iter = array.iterator();

        while(iter.hasNext()) {
            JSONObject jsonObject = (JSONObject)iter.next();
            list.add(JSONObject.toBean(jsonObject, clazz, map));
        }

        return list;
    }

    public static Map getMapFromJson(String jsonString) {
        setDataFormat2JAVA();
        JSONObject jsonObject = JSONObject.fromObject(jsonString);
        Map map = new HashMap();
        Iterator iter = jsonObject.keys();

        while(iter.hasNext()) {
            String key = (String)iter.next();
            map.put(key, jsonObject.get(key));
        }

        return map;
    }

    public static Object[] getObjectArrayFromJson(String jsonString) {
        JSONArray jsonArray = JSONArray.fromObject(jsonString);
        return jsonArray.toArray();
    }

    public static String getJSONString(Object object) throws Exception {
        String jsonString = null;
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
        if (object != null) {
            if (!(object instanceof Collection) && !(object instanceof Object[])) {
                jsonString = JSONObject.fromObject(object, jsonConfig).toString();
            } else {
                jsonString = JSONArray.fromObject(object, jsonConfig).toString();
            }
        }

        return jsonString == null ? "{}" : jsonString;
    }

    private static void setDataFormat2JAVA() {
        JSONUtils.getMorpherRegistry().registerMorpher(new DateMorpher(new String[]{"yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss"}));
    }

    public static void main(String[] arg) throws Exception {
        String s = "{status : 'success'}";
        System.out.println(" object : " + getJSONString(s));
    }

    public static MessageBean toString(String status, String msg) {
        MessageBean bean = new MessageBean();
        bean.setStatus(status);
        bean.setMsg(msg);
        return bean;
    }

    public static MessageBean toString(String status, String msg, String info) {
        MessageBean bean = new MessageBean();
        bean.setStatus(status);
        bean.setMsg(msg);
        bean.setInfo(info);
        return bean;
    }

    /**
     * @Author SunChang
     * @Date 2018/8/27 16:06
     * @param bean
     * @Description 将对象转换为json字符串
     */
    public static String beanToJsonString(Object bean) {
        return new Gson().toJson(bean);
    }

}
