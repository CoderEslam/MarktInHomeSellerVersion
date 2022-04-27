package com.doubleclick.marktinhome.Model;

/**
 * Created By Eslam Ghazy on 4/25/2022
 */
public class PostsGroup {

    private String id;
    private String adminId;
    private long time;
    private String text;
    private String type;
    private String images;
    private String video;
    private String groupId;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "PostsGroup{" +
                "id='" + id + '\'' +
                ", adminId='" + adminId + '\'' +
                ", time=" + time +
                ", text='" + text + '\'' +
                ", type='" + type + '\'' +
                ", images='" + images + '\'' +
                ", video='" + video + '\'' +
                '}';
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }
}
