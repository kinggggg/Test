package com.zeek.javatest.javacodegenerate;

/**
 * 实体对应的属性类
 *
 * @author: weibo_li
 * @since: 2018-08-03 下午4:09
 */
public class Property {

    // 属性数据类型
    private String javaType;
    // 属性名称
    private String propertyName;

    private PropertyType propertyType;

    public String getJavaType() {
        return javaType;
    }

    public void setJavaType(String javaType) {
        this.javaType = javaType;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public PropertyType getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(PropertyType propertyType) {
        this.propertyType = propertyType;
    }

}
