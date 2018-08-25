package person.util;

import person.db.bean.TblFunctionBean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by SunChang on 2018/8/23
 */
public class MenuObject implements Serializable {

    private static final long serialVersionUID = -3013873679274664380L;

    public TblFunctionBean obj = null;

    public List<MenuObject> children = new ArrayList<MenuObject>();

    public TblFunctionBean getObj() {
        return obj;
    }

    public void setObj(TblFunctionBean obj) {
        this.obj = obj;
    }

    public List<MenuObject> getChildren() {
        return children;
    }

    public void setChildren(List<MenuObject> children) {
        this.children = children;
    }
}
