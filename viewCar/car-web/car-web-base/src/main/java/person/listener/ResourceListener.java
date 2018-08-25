package person.listener;

import person.security.cache.CacheManager;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by SunChang on 2018/8/22
 */
public class ResourceListener implements ServletContextListener {
    @Override
    public void contextDestroyed(ServletContextEvent arg0) {

    }

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        try {
            /*****
             * 初始化缓存
             */
            CacheManager.getInstance().initComSumer();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
