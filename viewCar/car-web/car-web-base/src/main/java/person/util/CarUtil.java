package person.util;

import jodd.util.StringUtil;
import person.db.bean.TblAreaBean;
import person.db.bean.TblCarSystemBean;
import person.db.bean.TblFileDetailBean;
import person.handler.FileDetailHandler;
import person.security.cache.CacheManager;

import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * Created by SunChang on 2018/9/7
 */
public class CarUtil {
    /**
     * @Author SunChang
     * @Date 2018/9/6 18:57
     * @param strs
     * @Description 对filedetailBean赋初值
     */
    public static TblFileDetailBean getFileDetailBean(String[] strs) {
        TblFileDetailBean fileDetailBean = new TblFileDetailBean();
        fileDetailBean.setId(IdUtils.randomString());
        fileDetailBean.setName(strs[0]);
        fileDetailBean.setPhone(strs[1]);
        fileDetailBean.setArea(strs[2]);
        fileDetailBean.setCarSys(strs[3]);
        fileDetailBean.setTaskId(strs[6]);
        fileDetailBean.setStatus("0");
        return fileDetailBean;
    }

    /**
     * @Author SunChang
     * @Date 2018/9/6 19:52
     * @param areaBeans
    * @param cityName
    * @param mobileFrom
     * @Description 通过号码归属地与提供的城市名比对，得出城市ID
     */
    public static String checkCityId(List<TblAreaBean> areaBeans, String cityName, String mobileFrom) {
        String mobile = "";
        if(mobileFrom == null || mobileFrom.equals("&nbsp;")) {
            mobile = cityName;
        }else {
            String[] mobileFroms = mobileFrom.split("&nbsp;");
            if (mobileFroms.length > 1) {
                mobile = mobileFroms[mobileFroms.length - 1];
            } else {
                mobile = mobileFroms[0];
            }
        }
        String id = "";
        for (TblAreaBean areaBean : areaBeans) {
            if(areaBean.getCityName().contains(cityName) && areaBean.getCityName().contains(mobile)) {
                id = areaBean.getId();
                break;
            }
        }
        return id;
    }

    /**
     * @Author SunChang
     * @Date 2018/9/6 20:08
     * @param blacks
    * @param phone
     * @Description 检测号码是否在黑名单中
     */
    public static boolean isBlack(List<String> blacks, String phone) {
        boolean isBlack = false;
        for (String black : blacks) {
            if(black.equals(phone)) {
                isBlack = true;
                break;
            }
        }
        return isBlack;
    }

    /**
     * @Author SunChang
     * @Date 2018/9/6 20:15
     * @param carSystemBeans
    * @param carSysName
     * @Description 根据车系名称获取车系ID
     */
    public static String getCarSysId(List<TblCarSystemBean> carSystemBeans, String carSysName) {
        String carSysId = "";
        for (TblCarSystemBean carSystemBean : carSystemBeans) {
            if(carSystemBean.getCarSysName().equals(carSysName)) {
                carSysId = carSystemBean.getCarSysId();
                break;
            }
        }
        return carSysId;
    }

    /**
     * @Author SunChang
     * @Date 2018/9/6 20:24
     * @param carSysId
    * @param taskId
     * @Description 检测库中相同车系数据中手机号也是相同 的数据为车系重复数据
     */
    public static boolean checkCarSys(String carSysId, String phone, FileDetailHandler fileDetailHandler) {
        boolean isCarSys = false;
        //List<TblFileDetailBean> fileDetailBeans = fileDetailHandler.findByProperty2("carSys", carSysId);
        List<TblFileDetailBean> fileDetailBeans = fileDetailHandler.queryByHql("from TblFileDetail t where t.carSys = ? and t.phone = ?", carSysId, phone);
        if(null != fileDetailBeans && !fileDetailBeans.isEmpty()) {
            //for (TblFileDetailBean fileDetailBean : fileDetailBeans) {
            //    if(fileDetailBean.getPhone().equals(phone)) {
            //        isCarSys = true;
            //        break;
            //    }
            //}
            isCarSys = true;
        }
        return isCarSys;
    }

    /**
     * @Author SunChang
     * @Date 2018/9/6 20:29
     * @param taskId
    * @param phone
     * @Description 检测库中相同任务ID号中重复的手机号数据
     */
    public static boolean checkTask(String taskId, String phone, FileDetailHandler fileDetailHandler) {
        boolean isTask = false;
        //List<TblFileDetailBean> fileDetailBeans = fileDetailHandler.findByProperty2("taskId", taskId);
        List<TblFileDetailBean> fileDetailBeans = fileDetailHandler.queryByHql("from TblFileDetail t where t.taskId = ? and t.phone = ?", taskId, phone);
        if(null != fileDetailBeans && !fileDetailBeans.isEmpty()) {
            //for (TblFileDetailBean fileDetailBean : fileDetailBeans) {
            //    if(fileDetailBean.getPhone().equals(phone)) {
            //        isTask = true;
            //        break;
            //    }
            //}
            isTask = true;
        }
        return isTask;
    }

    /**
     * @Author SunChang
     * @Date 2018/9/6 20:38
     * @param phone
     * @Description 检测库中手机号重复的数据为大库重复
     */
    public static boolean checkBigLib(String phone, FileDetailHandler fileDetailHandler) {
        boolean isBigLib = false;
        List<TblFileDetailBean> fileDetailBeans = fileDetailHandler.findByProperty2("phone", phone);
        if(null != fileDetailBeans && !fileDetailBeans.isEmpty()) {
            isBigLib = true;
        }
        return isBigLib;
    }

    /**
     * @Author SunChang
     * @Date 2018/9/7 14:32
     * @param str
     * @Description 判断是否为整数
     */
    public static boolean isInteger(String str) {
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        return pattern.matcher(str).matches();
    }

    public static void updateCarSysAndAreaName(List list) {
        if(null != list && list.size() > 0) {
            Map<String, String> areaMap = CacheManager.getInstance().getAreaMap();
            Map<String, String> carMap = CacheManager.getInstance().getCarMap();
            for (Object obj : list) {
                TblFileDetailBean fileDetailBean = (TblFileDetailBean) obj;
                fileDetailBean.setArea(StringUtil.isNotBlank(areaMap.get(fileDetailBean.getArea()))?areaMap.get(fileDetailBean.getArea()):fileDetailBean.getArea());
                fileDetailBean.setCarSys(StringUtil.isNotBlank(carMap.get(fileDetailBean.getCarSys()))?carMap.get(fileDetailBean.getCarSys()):fileDetailBean.getCarSys());
            }
        }
    }
}
