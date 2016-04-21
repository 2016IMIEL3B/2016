package fr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by joe on 19/04/2016.
 */
@Service
public class BrandService implements IBrandService {

    @Autowired
    BrandRepository brandDao;

    @Override
    public Brand save(Brand brand) {
        return brandDao.save(brand);
    }

    @Override
    public Brand findOne(Integer integer) {
        return brandDao.findOne(integer);
    }

    @Override
    public Iterable<Brand> findAll() {
        return brandDao.findAll();
    }

    @Override
    public void delete(Integer integer) {

    }
}
