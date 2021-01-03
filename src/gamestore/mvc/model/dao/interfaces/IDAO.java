package gamestore.mvc.model.dao.interfaces;

import java.util.List;


public interface IDAO<T> {
	T get(Integer id);

    List<T> getAll();

    boolean save(T t);

    boolean update(T t);

    boolean delete(T t);
}