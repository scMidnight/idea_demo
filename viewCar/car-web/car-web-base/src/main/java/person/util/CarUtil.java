package person.util;

import jodd.util.StringUtil;
import person.db.bean.TblAreaBean;
import person.db.bean.TblCarSystemBean;
import person.db.bean.TblFileDetailBean;
import person.handler.FileDetailHandler;
import person.security.cache.CacheManager;

import java.text.SimpleDateFormat;
import java.util.Date;
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
        fileDetailBean.setName(StringUtil.isNotBlank(strs[0]) ? strs[0] : "");
        fileDetailBean.setPhone(StringUtil.isNotBlank(strs[1]) ? strs[1] : "");
        fileDetailBean.setArea(StringUtil.isNotBlank(strs[2]) ? strs[2] : "");
        fileDetailBean.setCarSys(StringUtil.isNotBlank(strs[3]) ? strs[3] : "");
        if(strs.length > 4) {
            fileDetailBean.setTaskId(StringUtil.isNotBlank(strs[6]) ? strs[6] : "");
        }else {
            fileDetailBean.setTaskId("");
        }
        fileDetailBean.setStatus("0");
        return fileDetailBean;
    }

    /**
     * @Author SunChang
     * @Date 2018/9/6 19:52
    * @param cityName
    * @param mobileFrom
     * @Description 通过号码归属地与提供的城市名比对，得出城市ID
     */
    public static boolean checkFromPhone(String cityName, String mobileFrom) {
        String mobile = "";
        if (mobileFrom == null || mobileFrom.equals("&nbsp;")) {
            return true;
        } else {
            String[] mobileFroms = mobileFrom.split("&nbsp;");
            if (mobileFroms.length > 1) {
                mobile = mobileFroms[mobileFroms.length - 1];
            } else {
                mobile = mobileFroms[0];
            }
        }
        if(mobile.contains(cityName) || cityName.contains(mobile)) {
            return true;
        }else {
            return false;
        }
    }

    /**
     * @Author SunChang
     * @Date 2018/10/19 16:58
     * @param areaBeans
    * @param cityName
     * @Description 城市转id
     */
    public static String getCityId(List<TblAreaBean> areaBeans, String cityName) {
        String id = "";
        for (TblAreaBean areaBean : areaBeans) {
            if(areaBean.getCityName().equals(cityName.trim())) {
                id = areaBean.getId();
                break;
            }
        }
        if(StringUtil.isBlank(id)) {
            for (TblAreaBean areaBean : areaBeans) {
                if(areaBean.getCityName().contains(cityName) || cityName.contains(areaBean.getCityName())) {
                    id = areaBean.getId();
                    break;
                }
            }
        }
        if(StringUtil.isNotBlank(id)) {
            return id;
        }else {
            return cityName;
        }
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
    public static TblCarSystemBean getCarSysId(List<TblCarSystemBean> carSystemBeans, String carSysName) {
        TblCarSystemBean bean = null;
        for (TblCarSystemBean carSystemBean : carSystemBeans) {
            if(carSystemBean.getCarSysName().equals(carSysName)) {
                bean = carSystemBean;
                break;
            }
        }
        return bean;
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
     * @Date 2018/9/6 20:38
     * @param bean
     * @Description 检测是否品牌重复
     */
    public static boolean checkBrand(TblFileDetailBean bean, FileDetailHandler fileDetailHandler) {
        boolean res = false;
        String phone = bean.getPhone();
        List<TblFileDetailBean> beans = fileDetailHandler.queryByHql("FROM TblFileDetail t where t.carSys in (select carSysId from TblCarSystem where brandId = ?) and t.phone = ? and t.fileId != ?", bean.getBrand(), phone, bean.getFileId());
        if(null != beans && !beans.isEmpty()) {
            res = true;
        }
        return res;
    }

    /**
     * @Author SunChang
     * @Date 2018/9/6 20:38
     * @param bean
     * @Description 检测是否厂商重复
     */
    public static boolean checkTrade(TblFileDetailBean bean, FileDetailHandler fileDetailHandler) {
        boolean res = false;
        String phone = bean.getPhone();
        List<TblFileDetailBean> beans = fileDetailHandler.queryByHql("FROM TblFileDetail t where t.carSys in (select carSysId from TblCarSystem where tradeId = ?) and t.phone = ? and t.fileId != ?", bean.getTrade(), phone, bean.getFileId());
        if(null != beans && !beans.isEmpty()) {
            res = true;
        }
        return res;
    }

    /**
     * @Author SunChang
     * @Date 2018/9/7 14:32
     * @param str
     * @Description 判断是否为整数
     */
    public static boolean isInteger(String str) {
        if(StringUtil.isNotBlank(str)) {
            Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
            return pattern.matcher(str).matches();
        }else {
            return false;
        }
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

    /**
     * @Author SunChang
     * @Date 2018/10/18 14:36
     * @param d
    * @param formatStr
     * @Description 根据传入的日期格式，获取当前日期时间字符串
     */
    public static String getDateStr(Date d, String formatStr) {
        SimpleDateFormat sdf = new SimpleDateFormat(formatStr);
        String dateNowStr = sdf.format(d);
        return dateNowStr;
    }
}
