package senior.day08.exer1;

import java.util.*;

/*
    定义一个泛型类DAO<T>，在其中定义一个Map成员变量，Map的键为String类型，值为T类型
    分别创建一下方法：
    public void save(String id, T entity)：保存T类型对象到map成员变量中
    public T get(String id)：从map中获取id对应的对象
    public void update(String id, T entity)：替换map中key为id的内容，改为entity
    public List<T> list()：返回map中存放的所有T对象
    public void delete(String id)：删除指定id对象
 */
public class DAO<T> {
    private Map<String, T> map = new HashMap<>();

    public void save(String id, T entity) {
        map.put(id, entity);
    }

    public T get(String id) {
        return map.get(id);
    }

    public void update(String id, T entity) {
        if (!map.containsKey(id)) {
            return;
        }
        map.put(id, entity);
    }

    public List<T> list() {
        List<T> result = new ArrayList<>(map.values());
        return result;
    }

    public void delete(String id) {
        map.remove(id);
    }
}
