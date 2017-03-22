package lab.dao;

import lab.model.DbEntity;

import java.util.Optional;
import java.util.stream.Stream;

public interface DbEntityDao<T extends DbEntity> {

    Stream<T> getAll();

    void attach(T t);
    void update(T t);
    void detach(T t);

    default Optional<T> get(long id) {
        return getAll()
            .filter(t -> t.id() == id)
            .findAny();
    }
}
