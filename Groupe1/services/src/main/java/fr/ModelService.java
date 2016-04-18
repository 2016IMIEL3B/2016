package fr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by joe on 18/04/2016.
 */
@Service
public class ModelService implements IModelService {

    @Autowired
    private ModelRepository modelDao;


    @Override
    public Model save(Model model) {
        return modelDao.save(model);
    }

    @Override
    public Model findOne(Integer integer) {
        return modelDao.findOne(integer);
    }

    @Override
    public Iterable<Model> findAll() {
        return modelDao.findAll();
    }

    @Override
    public void delete(Integer integer) {

    }
}
