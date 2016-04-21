package fr;

/**
 * Created by joe on 18/04/2016.
 */
public interface IModelService {

    Model save (Model model);

    Model findOne(Integer integer);

    Iterable<Model> findAll();

    void delete(Integer integer);
}
