package person.util;

import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by SunChang on 2018/8/22
 */
public class JsonDateValueProcessor implements JsonValueProcessor {
    private String format = "yyyy-MM-dd HH:mm:ss";

    public JsonDateValueProcessor() {
    }

    public JsonDateValueProcessor(String format) {
        this.format = format;
    }

    @Override
    public Object processArrayValue(Object value, JsonConfig jsonConfig) {
        return this.process(value, jsonConfig);
    }

    @Override
    public Object processObjectValue(String key, Object value, JsonConfig jsonConfig) {
        return this.process(value, jsonConfig);
    }

    private Object process(Object value, JsonConfig jsonConfig) {
        if (value instanceof Date) {
            String str = (new SimpleDateFormat(this.format)).format((Date)value);
            return str;
        } else {
            return value == null ? null : value.toString();
        }
    }

    public String getFormat() {
        return this.format;
    }

    public void setFormat(String format) {
        this.format = format;
    }
}
