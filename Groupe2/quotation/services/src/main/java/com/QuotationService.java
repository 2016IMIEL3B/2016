package com;

import com.QuotationRepository;
import com.front.Quotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;

/**
 * Created by kevin on 22/03/16.
 */
@Service
public class QuotationService implements IQuotationService {

    @Autowired
    private QuotationRepository quotationDao;

    @Override
    public Iterable<Quotation> findByUserId(int user_Id) { return quotationDao.findByUserId(user_Id);  }

    public Iterable<Quotation> findAll() { return quotationDao.findAll(); }

    public Quotation findOneById(int id) { return quotationDao.findOneById(id); }

}
