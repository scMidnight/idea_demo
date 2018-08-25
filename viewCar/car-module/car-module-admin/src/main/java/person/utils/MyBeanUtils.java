package person.utils;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.DynaBean;
import org.apache.commons.beanutils.DynaProperty;
import org.apache.commons.beanutils.PropertyUtils;

import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by SunChang on 2018/8/22
 */
public class MyBeanUtils extends BeanUtils {
    private static void convert(Object dest, Object orig) throws IllegalAccessException, InvocationTargetException {
        if (dest == null) {
            throw new IllegalArgumentException("No destination bean specified");
        } else if (orig == null) {
            throw new IllegalArgumentException("No origin bean specified");
        } else {
            int i;
            String name;
            Object value;
            if (orig instanceof DynaBean) {
                DynaProperty[] origDescriptors = ((DynaBean)orig).getDynaClass().getDynaProperties();

                for(i = 0; i < origDescriptors.length; ++i) {
                    name = origDescriptors[i].getName();
                    if (PropertyUtils.isWriteable(dest, name)) {
                        value = ((DynaBean)orig).get(name);

                        try {
                            copyProperty(dest, name, value);
                        } catch (Exception var10) {
                        }
                    }
                }
            } else if (orig instanceof Map) {
                Iterator names = ((Map)orig).keySet().iterator();

                while(names.hasNext()) {
                    String name1 = (String)names.next();
                    if (PropertyUtils.isWriteable(dest, name1)) {
                        Object value1 = ((Map)orig).get(name1);

                        try {
                            copyProperty(dest, name1, value1);
                        } catch (Exception var9) {
                        }
                    }
                }
            } else {
                PropertyDescriptor[] origDescriptors = PropertyUtils.getPropertyDescriptors(orig);

                for(i = 0; i < origDescriptors.length; ++i) {
                    name = origDescriptors[i].getName();
                    if (!"class".equals(name) && PropertyUtils.isReadable(orig, name) && PropertyUtils.isWriteable(dest, name)) {
                        try {
                            value = PropertyUtils.getSimpleProperty(orig, name);
                            copyProperty(dest, name, value);
                        } catch (IllegalArgumentException var7) {
                            ;
                        } catch (Exception var8) {
                            ;
                        }
                    }
                }
            }

        }
    }

    public static void copyBeanNotNull2Bean(Object databean, Object tobean) throws Exception {
        PropertyDescriptor[] origDescriptors = PropertyUtils.getPropertyDescriptors(databean);

        for(int i = 0; i < origDescriptors.length; ++i) {
            String name = origDescriptors[i].getName();
            if (!"class".equals(name) && PropertyUtils.isReadable(databean, name) && PropertyUtils.isWriteable(tobean, name)) {
                try {
                    Object value = PropertyUtils.getSimpleProperty(databean, name);
                    if (value != null) {
                        copyProperty(tobean, name, value);
                    }
                } catch (IllegalArgumentException var6) {
                    ;
                } catch (Exception var7) {
                    ;
                }
            }
        }

    }

    public static void copyBean2Bean(Object dest, Object orig) throws Exception {
        convert(dest, orig);
    }

    public static void copyBean2Map(Map map, Object bean) {
        PropertyDescriptor[] pds = PropertyUtils.getPropertyDescriptors(bean);

        for(int i = 0; i < pds.length; ++i) {
            PropertyDescriptor pd = pds[i];
            String propname = pd.getName();

            try {
                Object propvalue = PropertyUtils.getSimpleProperty(bean, propname);
                map.put(propname, propvalue);
            } catch (IllegalAccessException var7) {
                ;
            } catch (InvocationTargetException var8) {
                ;
            } catch (NoSuchMethodException var9) {
                ;
            }
        }

    }

    public static void copyMap2Bean(Object bean, Map properties) throws IllegalAccessException, InvocationTargetException {
        if (bean != null && properties != null) {
            Iterator names = properties.keySet().iterator();

            while(true) {
                String name;
                do {
                    if (!names.hasNext()) {
                        return;
                    }

                    name = (String)names.next();
                } while(name == null);

                Object value = properties.get(name);

                try {
                    Class clazz = PropertyUtils.getPropertyType(bean, name);
                    if (null != clazz) {
                        String className = clazz.getName();
                        if (!className.equalsIgnoreCase("java.sql.Timestamp") || value != null && !value.equals("")) {
                            setProperty(bean, name, value);
                        }
                    }
                } catch (NoSuchMethodException var7) {
                    ;
                }
            }
        }
    }

    public static void copyMap2Bean_Nobig(Object bean, Map properties) throws IllegalAccessException, InvocationTargetException {
        if (bean != null && properties != null) {
            Iterator names = properties.keySet().iterator();

            while(true) {
                String name;
                do {
                    if (!names.hasNext()) {
                        return;
                    }

                    name = (String)names.next();
                } while(name == null);

                Object value = properties.get(name);

                try {
                    if (value != null) {
                        String[] nameArray = name.toLowerCase().split("_");
                        if (nameArray.length > 0) {
                            String z = "";
                            String[] arr$ = nameArray;
                            int len$ = nameArray.length;

                            for(int i$ = 0; i$ < len$; ++i$) {
                                String p = arr$[i$];
                                if (z.equals("")) {
                                    z = p;
                                } else {
                                    p = p.substring(0, 1).toUpperCase() + p.substring(1);
                                    z = z + p;
                                }
                            }

                            name = z;
                        }

                        Class clazz = PropertyUtils.getPropertyType(bean, name);
                        if (null != clazz) {
                            String className = clazz.getName();
                            if (className.equalsIgnoreCase("java.util.Date")) {
                                value = new Date(((Timestamp)value).getTime());
                            }

                            setProperty(bean, name, value);
                        }
                    }
                } catch (NoSuchMethodException var11) {
                    ;
                }
            }
        }
    }

    public static void copyMap2Bean(Object bean, Map properties, String defaultValue) throws IllegalAccessException, InvocationTargetException {
        if (bean != null && properties != null) {
            Iterator names = properties.keySet().iterator();

            while(true) {
                String name;
                do {
                    if (!names.hasNext()) {
                        return;
                    }

                    name = (String)names.next();
                } while(name == null);

                Object value = properties.get(name);

                try {
                    Class clazz = PropertyUtils.getPropertyType(bean, name);
                    if (null != clazz) {
                        String className = clazz.getName();
                        if (!className.equalsIgnoreCase("java.sql.Timestamp") || value != null && !value.equals("")) {
                            if (className.equalsIgnoreCase("java.lang.String") && value == null) {
                                value = defaultValue;
                            }

                            setProperty(bean, name, value);
                        }
                    }
                } catch (NoSuchMethodException var8) {
                    ;
                }
            }
        }
    }

    public MyBeanUtils() {
    }
}
