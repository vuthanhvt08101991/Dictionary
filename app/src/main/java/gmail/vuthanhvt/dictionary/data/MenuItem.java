package gmail.vuthanhvt.dictionary.data;

/**
 * Create by FRAMGIA\vu.anh.thanh on 23/10/2018.
 * Phone: 096.320.8650
 * Email: vuthanhvt@gmail.com
 * <p>
 * Item for Menu screen.
 */
public class MenuItem {

    private int type;

    private int icon;

    private String title;

    public MenuItem(int type, int icon, String title) {
        this.type = type;
        this.icon = icon;
        this.title = title;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
