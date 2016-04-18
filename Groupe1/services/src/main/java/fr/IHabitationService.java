package fr;

/**
 * Created by joe on 18/04/2016.
 */
public interface IHabitationService {

    Habitation save (Habitation habitation);

    Habitation findOne(Integer integer);

    Iterable<Habitation> findAll();

    void delete(Integer integer);
}
