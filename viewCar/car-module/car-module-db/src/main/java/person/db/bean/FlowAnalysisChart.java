package person.db.bean;

import java.util.List;

public class FlowAnalysisChart {
    private List<String> xAxisData;
    private List<FlowAnalysisChartValue> series;

    public FlowAnalysisChart(List<String> xAxisData, List<FlowAnalysisChartValue> series) {
        this.xAxisData = xAxisData;
        this.series = series;
    }

    public List<String> getxAxisData() {
        return xAxisData;
    }

    public void setxAxisData(List<String> xAxisData) {
        this.xAxisData = xAxisData;
    }

    public List<FlowAnalysisChartValue> getSeries() {
        return series;
    }

    public void setSeries(List<FlowAnalysisChartValue> series) {
        this.series = series;
    }
}
