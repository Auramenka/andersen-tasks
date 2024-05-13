package hibernate.service;

import java.util.List;

public interface HibernateCrudService<T, N> {
    List<T> getAllRooms();
    void save(T t);
    T update(T t);
    void deleteByNumber(N number);
}
