package repository;

import java.util.List;

public interface CrudRepository<T, N> {

    List<T> getAllRooms();
    T save(T t);
    T update(T t, Boolean access);
    boolean deleteByNumber(N number);
}
