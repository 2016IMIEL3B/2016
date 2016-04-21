package fr;

/**
 * Created by joe on 19/04/2016.
 */
public interface IBrandService {

    Brand save (Brand model);

    Brand findOne(Integer integer);

    Iterable<Brand> findAll();

    void delete(Integer integer);
}
