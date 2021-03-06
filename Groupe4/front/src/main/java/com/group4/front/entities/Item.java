package com.group4.front.entities;

public class Item {
    /**
     * Item id.
     */
    private Integer id;

    /**
     * Item key.
     */
    private String listKey;

    /**
     * Value.
     */
    private String value;

    /**
     * Parent list id.
     */
    private Integer parentId;

    /**
     * Constructor.
     */
    public Item(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getListKey() {
        return listKey;
    }

    public void setListKey(String listKey) {
        this.listKey = listKey;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", listKey='" + listKey + '\'' +
                ", value='" + value + '\'' +
                ", parentId=" + parentId +
                '}';
    }
}
