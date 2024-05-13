package service;

import java.util.List;

public interface CrudService<T, N> {

    List<T> getAllRooms();
    void save(T t);
    T update(T t);
    boolean deleteByNumber(N number);
}
