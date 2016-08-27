package eshopping.dao;

import java.util.List;

public interface CrudDao<E,I> {
    List<E> getList();

    E getOneById(int id);

    void add(E domain);

    void edit(E domain);

    void delete(E domain);
}