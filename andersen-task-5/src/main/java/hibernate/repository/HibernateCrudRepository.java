package hibernate.repository;

import java.util.List;

public interface HibernateCrudRepository<T, N> {

    List<T> getAllRooms();
    void save(T t);
    T update(T t);
    void deleteByNumber(Integer number);
}
