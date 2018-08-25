package person;

import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigUtils;
import org.springframework.context.support.GenericApplicationContext;

/**
 * Created by SunChang on 2018/8/22
 */
public class ApplicationContextUtils {
    static final String						SPRING_DB_FILE_PATH		= "classpath:spring/applicationContext.xml";

    static ApplicationContextUtils	app						= null;

    public synchronized static ApplicationContextUtils getInstance() {
        if (null == app) {
            app = new ApplicationContextUtils();
        }
        return app;
    }

    private ApplicationContextUtils() {
        init();
    }

    /** spring application context. */
    static ApplicationContext applicationContext	= null;

    /**
     * 初始化applicationContext
     */
    static void init() {
        if (applicationContext == null) {
            /**/
            GenericApplicationContext context = new GenericApplicationContext();
            createBeanDefinitionReader(context).loadBeanDefinitions(SPRING_DB_FILE_PATH);
            AnnotationConfigUtils.registerAnnotationConfigProcessors(context);
            context.refresh();
            applicationContext = context;
        }
    }

    /**
     * 创建 XmlBeanDefinitionReader
     * @param context
     * @return
     */
    private static BeanDefinitionReader createBeanDefinitionReader(
            GenericApplicationContext context) {
        return new XmlBeanDefinitionReader(context);
    }


    /**
     * 根据bean的name来查找对象
     * @param beanName
     * @return bean 实例
     */
    public  Object getBean(String beanName) {
        Object obj = null;
        try {
            obj = applicationContext.getBean(beanName);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return obj;

    }
}
