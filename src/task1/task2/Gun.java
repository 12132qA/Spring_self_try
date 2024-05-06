package task1.task2;

import java.util.List;

/**
 * .
 *
 * @belongsProject: myTak
 * @belongsPackage: task1
 * @author: ZGY
 * @createTime: 2024-03-25  21:44
 * @version: 1.0
 */

public class Gun {
    // 枪支名称
    String gunName;
    // 型号
    String type;
    // 口径大小
    int open;
    // 射程
    int distance;
    public String getGunName() {
        return gunName;
    }

    public void setGunName(String gunName) {
        this.gunName = gunName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getOpen() {
        return open;
    }

    public void setOpen(int open) {
        this.open = open;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getContainer() {
        return container;
    }

    public void setContainer(int container) {
        this.container = container;
    }

    // 射速
    int speed;
    // 弹夹容量
    int container;
}