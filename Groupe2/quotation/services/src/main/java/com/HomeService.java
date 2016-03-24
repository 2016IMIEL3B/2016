package com;

import com.front.Driver;
import com.front.Home;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by kevin on 22/03/16.
 */
@Service
public class HomeService implements IHomeService {

    @Autowired
    private HomeRepository homeRepository;


    public Home findOneByQuotationId(int id) {
        return this.homeRepository.findOneByQuotationId(id);
    }

    @Override
    public Home save(Home home){
        return this.homeRepository.save(home);
    }
}
