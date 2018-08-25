package person.db.entity;

import java.io.Serializable;

/**
 * Created by SunChang on 2018/8/22
 */
public class PropertyFilter implements Serializable {

    private static final long serialVersionUID = 6181938274034080354L;
    /**
     * 多个属性间OR关系的分隔符.
     */
    public static final String OR_SEPARATOR = "_OR_";

    /**
     * 属性比较类型.EQ:=,LIKE:like,LESS_THAN:<,GREATER_THAN>,LESS_EQ_THAN<=,GREATER_EQ_THAN>=
     */
    public enum MatchType {
        /**
         * =
         */
        EQ,
        /**
         * NOT EQ
         */
        NE,
        /**
         * LIKE
         */
        LIKE,
        /**
         * %STR
         */
        STARTLIKE,
        /**
         * STR%
         */
        ENDLIKE,
        ISNULL,
        ISNOTNULL,
        /**
         * &lt;
         */
        LESS_THAN,
        /**
         * &gt;
         */
        GREATER_THAN,
        /**
         * &lt;=
         */
        LESS_EQ_THAN,
        /**
         * &gt;=
         */
        GREATER_EQ_THAN, IN, NOT_IN;
    }

    /**
     * 属性名
     */
    private String propertyName;
    /**
     * 属性值，MatchType为between类型时较大的值
     */
    private Object value;
    /**
     * between类型时较大的值
     */
    private Object afterValue;
    /**
     * 属性类型默认 =
     */
    private MatchType matchType = MatchType.EQ;

    public PropertyFilter() {
    }

    public PropertyFilter(final String propertyName, final MatchType matchType, final Object value, final Object afterValue) {
        this.propertyName = propertyName;
        this.matchType = matchType;
        this.value = value;
        this.afterValue = afterValue;
    }

    public PropertyFilter(final String propertyName, final MatchType matchType, final Object value) {
        this.propertyName = propertyName;
        this.matchType = matchType;
        this.value = value;
    }

    /**
     * 获取属性名称,可用'_OR_'分隔多个属性,此时属性间是or的关系.
     */
    public String getPropertyName() {
        return propertyName;
    }

    /**
     * 设置属性名称,可用'_OR_'分隔多个属性,此时属性间是or的关系.
     */
    public void setPropertyName(final String propertyName) {
        this.propertyName = propertyName;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(final Object value) {
        this.value = value;
    }

    public MatchType getMatchType() {
        return matchType;
    }

    public void setMatchType(final MatchType matchType) {
        this.matchType = matchType;
    }

    /**
     * @param afterValue the afterValue to set between类型时较大的值
     */
    public void setAfterValue(Object afterValue) {
        this.afterValue = afterValue;
    }

    /**
     * @return the afterValue between类型时较大的值
     */
    public Object getAfterValue() {
        return afterValue;
    }
}
