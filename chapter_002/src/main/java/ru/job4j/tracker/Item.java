package ru.job4j.tracker;

public class Item {
    private String id;
    private String name;
    private String desc;
    private String[] comments = new String[10];
    private int index;

    public Item(String name, String comments) {
        this.name = name;
        this.comments[index] = comments;
        this.index++;
    }
    public void setComments(String comments) {
        this.comments[index] = comments;
        this.index++;
    }
    public String[] getComments() {
        return comments;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getId() {
        return this.id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }
    public String getDesc() {
        return this.desc;
    }
    /*
    public void setCreated(long created) {
        this.created = created;
    }
    public long getCreated() {
        return this.created;
    }*/
}
