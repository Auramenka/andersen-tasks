package repository;

import java.util.List;

public interface CrudRepository<T, N> {

    List<T> getAllRooms();
    void save(T t);
    T update(T t);
    boolean deleteByNumber(Integer number);
}
