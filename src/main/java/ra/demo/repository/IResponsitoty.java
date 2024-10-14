package ra.demo.repository;

import java.util.List;

public interface IResponsitoty <T,E>{
    List<T> findAll();
    T findById(E id);
    void save(T t);
    void deleteById(E id);
}
