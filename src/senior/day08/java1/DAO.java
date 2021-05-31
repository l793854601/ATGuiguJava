package senior.day08.java1;

import java.util.List;

/*
    DAO：data access object
 */
public abstract class DAO<T> {

    //  添加一条记录
    public abstract void add(T t);

    //  删除一条记录
    public abstract boolean remove(int index);

    //  修改一条记录
    public abstract void update(int index, T t);

    //  查询一条记录
    public abstract T get(int index);

    //  查询多条记录
    public abstract List<T> get(int... index);
}
