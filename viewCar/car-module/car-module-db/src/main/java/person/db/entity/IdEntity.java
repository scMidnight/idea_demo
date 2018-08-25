package person.db.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * Created by SunChang on 2018/8/22
 */
@SuppressWarnings("serial")
@MappedSuperclass
public abstract class IdEntity implements Serializable {

    private static final long serialVersionUID = -604044662442334062L;

    /**
     * 需要自动生成主键ID的pojo都要继承此类，ID生成参考RbacUserHandlerImpl中addRbacUser方法
     */
    protected String id;
    @Id
    @Column(name = "ID", unique = true, nullable = false)
    public String getId() {

        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
