package task1.task2;

/**
 * .
 *
 * @belongsProject: myTak
 * @belongsPackage: task1.task2
 * @author: ZGY
 * @createTime: 2024-03-25  21:47
 * @version: 1.0
 */

public class Bullet {
    String bulletName;

    public String getBulletName() {
        return bulletName;
    }

    public void setBulletName(String bulletName) {
        this.bulletName = bulletName;
    }

    public int getOpen() {
        return open;
    }

    public void setOpen(int open) {
        this.open = open;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    // 口径
    int open;
    // 型号
    String type;
}