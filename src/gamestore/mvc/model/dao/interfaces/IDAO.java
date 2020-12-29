package gamestore.mvc.model.dao.interfaces;

import java.util.List;

public interface IDAO<T> {
	T get(Integer id);
    
    List<T> getAll();
    
    T save(T t);
    
    T update(T t);
    
    int delete(T t);
}