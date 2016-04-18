package fr;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by joe on 18/04/2016.
 */
public interface HabitationRepository extends CrudRepository<Habitation, Integer> {

    Habitation save (Habitation habitation);

    Habitation findOne(Integer integer);

    Iterable<Habitation> findAll();

    void delete(Integer integer);
}
