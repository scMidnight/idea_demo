package person.util;

import jodd.util.StringUtil;
import person.db.bean.TblAreaBean;
import person.db.bean.TblCarSystemBean;
import person.db.bean.TblFileBean;
import person.db.bean.TblFileDetailBean;
import person.handler.FileDetailHandler;
import person.security.cache.CacheManager;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
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
    public static TblFileDetailBean getFileDetailBean(String[] strs) throws Exception {
        try {
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
        } catch (Exception e) {
            System.err.println(e.getMessage());
            throw new Exception("文件异常，非常规数据格式，请查检文件");
        }
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
        List<TblFileDetailBean> beans = fileDetailHandler.queryByHql("FROM TblFileDetail t where t.carSys in (select carSysId from TblCarSystem where brandId = ? and carSysId != ?) and t.phone = ? and t.fileId != ?", bean.getBrand(), bean.getCarSys(), phone, bean.getFileId());
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
        List<TblFileDetailBean> beans = fileDetailHandler.queryByHql("FROM TblFileDetail t where t.carSys in (select carSysId from TblCarSystem where tradeId = ? and carSysId != ? and brandId != ?) and t.phone = ? and t.fileId != ?", bean.getTrade(), bean.getCarSys(), bean.getBrand(), phone, bean.getFileId());
        if(null != beans && !beans.isEmpty()) {
            res = true;
        }
        return res;
    }

    /**
     * @Author SunChang
     * @Date 2018/9/6 20:38
     * @param bean
     * @Description 手机号连号+三个以上+品牌相同30天内数据
     */
    public static boolean check4(TblFileDetailBean bean, FileDetailHandler fileDetailHandler) {
        LinkedList<TblFileDetailBean> list = getPhoneLian(bean, fileDetailHandler);
        if(null != list && list.size() >= 3) {
            return true;
        }
        return false;
    }

    /**
     * @Author SunChang
     * @Date 2018/9/6 20:38
     * @param bean
     * @Description 手机号前6位相同+三个以上+品牌相同+30天内数据
     */
    public static boolean check6(TblFileDetailBean bean, FileDetailHandler fileDetailHandler) {
        String phone = bean.getPhone();
        String phone6 = phone.substring(0, 6);
        LinkedList<TblFileDetailBean> list = getPhoneChong(bean, fileDetailHandler);
        if(null != list && list.size() >= 3) {
            return true;
        }
        return false;
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

    public static LinkedList<TblFileDetailBean> getPhoneChong(TblFileDetailBean bean, FileDetailHandler fileDetailHandler) {
        LinkedList<TblFileDetailBean> list = new LinkedList<>();
        list.add(bean);
        String phone = bean.getPhone();
        String phone6 = phone.substring(0, 6);
        String carSysId = bean.getCarSys();
        Map<String, TblCarSystemBean> carMapBean = CacheManager.getInstance().getCarMapBean();
        TblCarSystemBean carSystemBean = carMapBean.get(carSysId);
        List<Map<String, Object>> gMaps = null;
        List<Map<String, Object>> oMaps = null;
        if(carSystemBean.getTypeId().equals("1")) {//国产
            gMaps = fileDetailHandler.findForJdbc("select * from tbl_file_detail t where DATE_SUB(CURDATE(), INTERVAL 30 DAY) <= date(t.UPLOAD_DATE) and t.car_sys in (select car_sys_id from tbl_car_system where brand_id = ? ) and t.phone like ?", bean.getBrand(), phone6 + "%");
        }else {
            oMaps = fileDetailHandler.findForJdbc("select * from tbl_file_detail t where DATE_SUB(CURDATE(), INTERVAL 30 DAY) <= date(t.UPLOAD_DATE) and t.car_sys in (select car_sys_id from tbl_car_system where trade_id = ? ) and t.phone like ?", bean.getTrade(), phone6 + "%");
        }
        for (Map<String, Object> map : gMaps) {
            if(!map.get("id").toString().equals(bean.getId())) {
                list.add(getBean(map, fileDetailHandler));
            }
        }
        for (Map<String, Object> oMap : oMaps) {
            if(!oMap.get("id").toString().equals(bean.getId())) {
                list.add(getBean(oMap, fileDetailHandler));
            }
        }
        return list;
    }

    public static LinkedList<TblFileDetailBean> getPhoneLian(TblFileDetailBean bean, FileDetailHandler fileDetailHandler) {
        LinkedList<TblFileDetailBean> list = new LinkedList<>();
        list.add(bean);
        String phone = bean.getPhone();
        List<Map<String, Object>> xiaos = fileDetailHandler.findForJdbc("select * from tbl_file_detail t where DATE_SUB(CURDATE(), INTERVAL 30 DAY) <= date(t.UPLOAD_DATE) and t.car_sys in (select car_sys_id from tbl_car_system where brand_id = ?) and cast(t.phone as SIGNED) < cast(? as SIGNED) ORDER BY cast(t.phone as SIGNED) desc", bean.getBrand(), bean.getPhone());
        List<Map<String, Object>> das = fileDetailHandler.findForJdbc("select * from tbl_file_detail t where DATE_SUB(CURDATE(), INTERVAL 30 DAY) <= date(t.UPLOAD_DATE) and t.car_sys in (select car_sys_id from tbl_car_system where brand_id = ?) and cast(t.phone as SIGNED) > cast(? as SIGNED) ORDER BY cast(t.phone as SIGNED) asc", bean.getBrand(), bean.getPhone());
        addLinked(bean.getId(), phone, list, xiaos, "xiao", fileDetailHandler);
        addLinked(bean.getId(), phone, list, das, "da", fileDetailHandler);
        return list;
    }

    public static void sort(List<Map<String, Object>> list) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size() - 1 - i; j++) {
                Map<String, Object> map = list.get(j);
                Map<String, Object> map1 = list.get(j + 1);
                String a = map.get("phone").toString();
                String b = a.substring(a.length() - 4);
                String c = map1.get("phone").toString();
                String d = c.substring(c.length() - 4);
                if(Integer.parseInt(b) > Integer.parseInt(d)) {
                    list.set(j, map1);
                    list.set(j + 1, map);
                }
            }
        }
    }
    
    public static TblFileDetailBean getBean(Map<String, Object> map, FileDetailHandler fileDetailHandler) {
        TblFileDetailBean temp = new TblFileDetailBean();
        //temp.setId(map.get("id") != null ? map.get("id").toString() : "");
        //temp.setFileId(map.get("file_id") != null ? map.get("file_id").toString() : "");
        //temp.setFileName(map.get("file_name") != null ? map.get("file_name").toString() : "");
        //temp.setTaskId(map.get("task_id") != null ? map.get("task_id").toString() : "");
        //temp.setName(map.get("name") != null ? map.get("name").toString() : "");
        //temp.setPhone(map.get("phone") != null ? map.get("phone").toString() : "");
        //temp.setArea(map.get("area") != null ? map.get("area").toString() : "");
        //temp.setCarSys(map.get("car_sys") != null ? map.get("car_sys").toString() : "");
        //temp.setStatus(map.get("status") != null ? map.get("status").toString() : "");
        //temp.setErrInfo(map.get("err_info") != null ? map.get("err_info").toString() : "");
        //temp.setUploadDate(map.get("UPLOAD_DATE") != null ? (Date) map.get("UPLOAD_DATE") : null);
        //temp.setOrderNum(map.get("ORDER_NUM") != null ? map.get("ORDER_NUM").toString() : "");
        //temp.setBrand(map.get("brand") != null ? map.get("brand").toString() : "");
        //temp.setTrade(map.get("trade") != null ? map.get("trade").toString() : "");
        //temp.setIsLian(map.get("IS_LIAN") != null ? map.get("IS_LIAN").toString() : "");
        //temp.setIsChong(map.get("IS_CHONG") != null ? map.get("IS_CHONG").toString() : "");
        temp = fileDetailHandler.findByProperty("id", map.get("id").toString()).get(0);
        return temp;
    }

    public static void addLinked(String id, String phone, LinkedList<TblFileDetailBean> list, List<Map<String, Object>> maps, String flag, FileDetailHandler fileDetailHandler) {
        int i = 1;
        String phoneTemp = "";
        TblFileDetailBean temp = null;
        if(null != maps && maps.size() > 1) {
            for (Map<String, Object> map : maps) {
                String p = map.get("phone").toString();
                if(!map.get("id").toString().equals(id)) {
                    if (flag.equals("xiao")) {
                        if (new BigInteger(phone).subtract(new BigInteger(p)).compareTo(new BigInteger("" + i)) == 0) {
                            i = i + 1;
                            temp = getBean(map, fileDetailHandler);
                            list.add(temp);
                            phoneTemp = temp.getPhone();
                        } else if(map.get("phone").toString().equals(phoneTemp)) {
                            temp = getBean(map, fileDetailHandler);
                            list.add(temp);
                        }else {
                            break;
                        }
                    }
                    if (flag.equals("da")) {
                        if (new BigInteger(p).subtract(new BigInteger(phone)).compareTo(new BigInteger("" + i)) == 0) {
                            i = i + 1;
                            temp = getBean(map, fileDetailHandler);
                            list.add(temp);
                            phoneTemp = temp.getPhone();
                        } else if(map.get("phone").toString().equals(phoneTemp)){
                            temp = getBean(map, fileDetailHandler);
                            list.add(temp);
                        }else {
                            break;
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        String phone = "15502119051";
        String phone1 = "15602119052";
        BigInteger b = new BigInteger(phone);
        BigInteger c = new BigInteger(phone1);
        System.out.println(c.subtract(b) == new BigInteger(""+100000001));
    }
}
