package person.db.bean;

import java.util.List;

/**
 * Created by SunChang on 2018/9/11
 */
public class PieBean {
    private List<PieData> pieData;
    private String pieLegends;
    private String selected;

    public PieBean() {
    }

    public PieBean(List<PieData> pieData, String pieLegends, String selected) {
        this.pieData = pieData;
        this.pieLegends = pieLegends;
        this.selected = selected;
    }

    public List<PieData> getPieData() {
        return pieData;
    }

    public void setPieData(List<PieData> pieData) {
        this.pieData = pieData;
    }

    public String getPieLegends() {
        return pieLegends;
    }

    public void setPieLegends(String pieLegends) {
        this.pieLegends = pieLegends;
    }

    public String getSelected() {
        return selected;
    }

    public void setSelected(String selected) {
        this.selected = selected;
    }
}
