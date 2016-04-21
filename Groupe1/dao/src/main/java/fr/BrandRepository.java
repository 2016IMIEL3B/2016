package fr;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by joe on 19/04/2016.
 */
public interface BrandRepository extends CrudRepository<Brand, Integer>{

    Brand save (Brand brand);

    Brand findOne(Integer integer);

    Iterable<Brand> findAll();

    void delete(Integer integer);
}
