package person;

import org.apache.commons.beanutils.PropertyUtils;

import java.lang.reflect.*;
import java.util.*;

/**
 * Created by SunChang on 2018/8/22
 */
public class ReflectionUtils {
    public ReflectionUtils() {
    }

    public static Object getFieldValue(Object object, String fieldName) {
        Field field = getDeclaredField(object, fieldName);
        if (field == null) {
            throw new IllegalArgumentException("Could not find field [" + fieldName + "] on target [" + object + "]");
        } else {
            makeAccessible(field);
            Object result = null;

            try {
                result = field.get(object);
            } catch (IllegalAccessException var5) {
                System.err.println("不可能抛出的异常{}" + var5.getMessage());
            }

            return result;
        }
    }

    public static void setFieldValue(Object object, String fieldName, Object value) {
        Field field = getDeclaredField(object, fieldName);
        if (field == null) {
            throw new IllegalArgumentException("Could not find field [" + fieldName + "] on target [" + object + "]");
        } else {
            makeAccessible(field);

            try {
                field.set(object, value);
            } catch (IllegalAccessException var5) {
                System.err.println("不可能抛出的异常:{}" + var5.getMessage());
            }

        }
    }

    public static Map<Integer, String> getConstantValue(Class<?> clazz) {
        Map<Integer, String> map = new HashMap();
        Field[] fields = clazz.getDeclaredFields();
        Field[] arr$ = fields;
        int len$ = fields.length;

        for(int i$ = 0; i$ < len$; ++i$) {
            Field f = arr$[i$];
            makeAccessible(f);

            try {
                map.put((Integer)f.get(clazz), f.getName());
            } catch (IllegalArgumentException var8) {
                var8.printStackTrace();
            } catch (IllegalAccessException var9) {
                var9.printStackTrace();
            }
        }

        return map;
    }

    public static Object invokeMethodByUnique(Class<?> clazz, Object object, String methodName, Object[] parameters) throws InvocationTargetException {
        Method method = findMethod(clazz, methodName);
        if (method == null) {
            throw new IllegalArgumentException("Could not find method [" + methodName + "] on target [" + object + "]");
        } else {
            Class[] paramTypeList = method.getParameterTypes();
            Object param = null;
            if (paramTypeList != null && paramTypeList.length == 1) {
                Class cla = paramTypeList[0];
                int i$;
                if (cla.isArray() && cla.getComponentType().getName().equals("int")) {
                    int[] array = new int[parameters.length];
                    int i = 0;
                    Object[] arr$ = parameters;
                    i$ = parameters.length;

                    for(i$ = 0; i$ < i$; ++i$) {
                        Object para = arr$[i$];
                        array[i++] = Integer.parseInt(para.toString());
                    }

                    param = array;
                } else if (cla.getName().equals("java.util.List")) {
                    List list = new ArrayList();
                    Object[] arr$ = parameters;
                    int len$ = parameters.length;

                    for(i$ = 0; i$ < len$; ++i$) {
                        Object para = arr$[i$];
                        list.add(para.toString());
                    }

                    param = list;
                }
            }

            method.setAccessible(true);

            try {
                return param != null ? method.invoke(object, param) : method.invoke(object, parameters);
            } catch (IllegalAccessException var14) {
                System.err.println("不可能抛出的异常:{}" + var14.getMessage());
                return null;
            }
        }
    }

    public static Object invokeMethod(Object object, String methodName, Class<?>[] parameterTypes, Object[] parameters) throws InvocationTargetException {
        Method method = getDeclaredMethod(object, methodName, parameterTypes);
        if (method == null) {
            throw new IllegalArgumentException("Could not find method [" + methodName + "] on target [" + object + "]");
        } else {
            method.setAccessible(true);

            try {
                return method.invoke(object, parameters);
            } catch (IllegalAccessException var6) {
                System.err.println("不可能抛出的异常:{}" + var6.getMessage());
                return null;
            }
        }
    }

    protected static Field getDeclaredField(Object object, String fieldName) {
        Class superClass = object.getClass();

        while(superClass != Object.class) {
            try {
                return superClass.getDeclaredField(fieldName);
            } catch (NoSuchFieldException var4) {
                superClass = superClass.getSuperclass();
            }
        }

        return null;
    }

    protected static void makeAccessible(Field field) {
        if (!Modifier.isPublic(field.getModifiers()) || !Modifier.isPublic(field.getDeclaringClass().getModifiers())) {
            field.setAccessible(true);
        }

    }

    protected static Method getDeclaredMethod(Object object, String methodName, Class<?>[] parameterTypes) {
        Class superClass = object.getClass();

        while(superClass != Object.class) {
            try {
                return superClass.getDeclaredMethod(methodName, parameterTypes);
            } catch (NoSuchMethodException var5) {
                superClass = superClass.getSuperclass();
            }
        }

        return null;
    }

    public static <T> Class<T> getSuperClassGenricType(Class clazz) {
        return getSuperClassGenricType(clazz, 0);
    }

    public static Class getSuperClassGenricType(Class clazz, int index) {
        Type genType = clazz.getGenericSuperclass();
        if (!(genType instanceof ParameterizedType)) {
            System.err.println(clazz.getSimpleName() + "'s superclass not ParameterizedType");
            return Object.class;
        } else {
            Type[] params = ((ParameterizedType)genType).getActualTypeArguments();
            if (index < params.length && index >= 0) {
                if (!(params[index] instanceof Class)) {
                    System.err.println(clazz.getSimpleName() + " not set the actual class on superclass generic parameter");
                    return Object.class;
                } else {
                    return (Class)params[index];
                }
            } else {
                System.err.println("Index: " + index + ", Size of " + clazz.getSimpleName() + "'s Parameterized Type: " + params.length);
                return Object.class;
            }
        }
    }

    public static List fetchElementPropertyToList(Collection collection, String propertyName) {
        ArrayList list = new ArrayList();

        try {
            Iterator i$ = collection.iterator();

            while(i$.hasNext()) {
                Object obj = i$.next();
                list.add(PropertyUtils.getProperty(obj, propertyName));
            }
        } catch (Exception var5) {
            convertToUncheckedException(var5);
        }

        return list;
    }

    public static String fetchElementPropertyToString(Collection collection, String propertyName, String separator) {
        List list = fetchElementPropertyToList(collection, propertyName);
        return StringUtils.join(list.iterator(), separator);
    }

    public static void convertToUncheckedException(Exception e) throws IllegalArgumentException {
        if (!(e instanceof IllegalAccessException) && !(e instanceof IllegalArgumentException) && !(e instanceof NoSuchMethodException)) {
            throw new IllegalArgumentException(e);
        } else {
            throw new IllegalArgumentException("Refelction Exception.", e);
        }
    }

    public static Class classForName(String name) throws ClassNotFoundException {
        try {
            ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
            if (contextClassLoader != null) {
                return contextClassLoader.loadClass(name);
            }
        } catch (Throwable var2) {
            ;
        }

        return Class.forName(name);
    }

    public static Method findMethod(Class<?> clazz, String name) {
        for(Class searchType = clazz; searchType != null; searchType = searchType.getSuperclass()) {
            Method[] methods = searchType.isInterface() ? searchType.getMethods() : searchType.getDeclaredMethods();
            Method[] arr$ = methods;
            int len$ = methods.length;

            for(int i$ = 0; i$ < len$; ++i$) {
                Method method = arr$[i$];
                if (name.equals(method.getName())) {
                    return method;
                }
            }
        }

        return null;
    }
}
