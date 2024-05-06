package task1;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * .
 *
 * @belongsProject: myTak
 * @belongsPackage: task1
 * @author: ZGY
 * @createTime: 2024-03-25  14:46
 * @version: 1.0
 */

public class test2 {
    public static void main(String[] args) {
        // 对 数据 进行存储  (高速缓存)
       Cache<String, List<String>> cache = Caffeine.newBuilder()
                // 默认在内存中存在的时间 是 6 小时
                .expireAfterWrite(6, TimeUnit.HOURS)
                .maximumSize(10_000) // 创建缓存 时间
                .build(); //
      List<String> sy = new ArrayList<>();
        sy.add("11-212");
        sy.add("21-2");
        cache.put("yi", sy);
        List<String> yi = cache.getIfPresent("yi");
        System.out.println(yi);

    }
}