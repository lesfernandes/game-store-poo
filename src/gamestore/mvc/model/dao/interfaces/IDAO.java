package gamestore.mvc.model.dao.interfaces;

import javafx.collections.ObservableList;

public interface IDAO<T> {
	T get(Integer id);

    ObservableList<T> getAll();

    boolean save(T t);

    boolean update(T t);

    boolean delete(T t);
}