package fr;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by joe on 18/04/2016.
 */
public interface ModelRepository extends CrudRepository<Model,Integer> {

    Model save (Model model);

    Model findOne(Integer integer);

    Iterable<Model> findAll();

    void delete(Integer integer);
}
