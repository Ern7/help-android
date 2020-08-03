package za.co.randomteam.help.data.model;

public class Alerts {
    private int id;
    private String title, subtitle, time, icon;

    public Alerts(int id, String title, String subtitle, String time, String icon) {
        this.id = id;
        this.title = title;
        this.subtitle = subtitle;
        this.time = time;
        this.icon = icon;
    }

    public int getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getSubtitle() {
        return subtitle;
    }
    public String getTime() {
        return time;
    }
    public String getIcon() {
        return icon;
    }
}
