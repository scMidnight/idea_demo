package person.db.bean;

import java.io.Serializable;
import java.util.Date;

public class SourcesBean implements Serializable {
    private String id;
    private String sourceTag;//来源标签名称
    private Date insertDate;//插入时间
    private String isDel;//是否删除0否1是

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSourceTag() {
        return sourceTag;
    }

    public void setSourceTag(String sourceTag) {
        this.sourceTag = sourceTag;
    }

    public Date getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(Date insertDate) {
        this.insertDate = insertDate;
    }

    public String getIsDel() {
        return isDel;
    }

    public void setIsDel(String isDel) {
        this.isDel = isDel;
    }
}
