package service;

import java.util.List;

public interface CrudService<T, N> {

    List<T> getAllRooms();
    T save(T t);
    void update(T t, Boolean access);
    boolean deleteByNumber(N number);
}
