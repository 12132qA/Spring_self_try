package task1.Utils;

import task1.annotation.Component;
import task1.beanFactory.BeanContainer;
import task1.common.SelfCaffineCache;

import java.util.*;

/**
 * .
 *
 * @belongsProject: myTak
 * @belongsPackage: task1.Utils
 * @author: ZGY
 * @createTime: 2024-03-24  17:50
 * @version: 1.0
 *
 * 定时任务
 */
@Component
public class TimerTasker extends TimerTask {
    @Override
    public void run() {

        SelfCaffineCache selfCaffineCache = (SelfCaffineCache) BeanContainer.BeansFactory.get("SelfCaffineCache");
        // 获取 当前时间戳 作为后缀
        //  selfCaffineCache.put();        // 日志的统计
        List<String> cacheValueList = selfCaffineCache.cacheValueList;
        // 对数据

        //文件数量
        selfCaffineCache.readToFile();


    }
}