package com;

import com.QuotationRepository;
import com.front.Quotation;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by kevin on 22/03/16.
 */
public class QuotationService implements IQuotationService {

    @Autowired
    private QuotationRepository quotationDao;

    @Override
    public Quotation findByUserId(int userId) { return quotationDao.findByUserId(userId);  }
}
