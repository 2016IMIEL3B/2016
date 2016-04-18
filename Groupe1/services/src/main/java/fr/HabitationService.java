package fr;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by joe on 18/04/2016.
 */
public class HabitationService implements IHabitationService {

    @Autowired
    HabitationRepository habitationDao;
    
    @Override
    public Habitation save(Habitation habitation) {
        return habitationDao.save(habitation);
    }

    @Override
    public Habitation findOne(Integer integer) {
        return habitationDao.findOne(integer);
    }

    @Override
    public Iterable<Habitation> findAll() {
        return habitationDao.findAll();
    }

    @Override
    public void delete(Integer integer) {

    }
}
