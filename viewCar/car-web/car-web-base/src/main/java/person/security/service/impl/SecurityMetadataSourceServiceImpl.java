package person.security.service.impl;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import person.db.bean.TblFunctionBean;
import person.security.cache.CacheManager;
import person.util.UrlUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * Created by SunChang on 2018/8/22
 */
public class SecurityMetadataSourceServiceImpl implements FilterInvocationSecurityMetadataSource {

    private static Map<String, Collection<ConfigAttribute>> resourceMap = null;

    public void loadResourceDefine() {
        if (resourceMap == null) {
            resourceMap = new HashMap<String, Collection<ConfigAttribute>>();
            List<TblFunctionBean> list = CacheManager.getInstance().getFunctionAll();
            for(TblFunctionBean func : list){
                Collection<ConfigAttribute> configAttributes = new ArrayList<ConfigAttribute>();
                ConfigAttribute configAttribute = new SecurityConfig(func.getId());
                configAttributes.add(configAttribute);
                resourceMap.put(func.getFunctionUrl(), configAttributes);
            }
        }
    }

    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        HttpServletRequest request =((FilterInvocation) object).getHttpRequest();
        String requestUrl = UrlUtil.buildRequestUrl(request);
        if (resourceMap == null) {
            try {
                loadResourceDefine();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        Collection<ConfigAttribute> ConfigAttributes = resourceMap.get(requestUrl);
        if(ConfigAttributes == null || ConfigAttributes.isEmpty()){
            return resourceMap.get(requestUrl.substring(0, requestUrl.lastIndexOf("/")));
        }
        return ConfigAttributes;
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }
}
