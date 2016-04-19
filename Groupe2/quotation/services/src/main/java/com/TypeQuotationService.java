package com;

import com.front.Quotation;
import com.front.TypeQuotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by kevin on 22/03/16.
 */
@Service
public class TypeQuotationService implements ITypeQuotationService {

    @Autowired
    private TypeQuotationRepository typeQuotationDao;

    @Override
    public TypeQuotation findOneByEntitled(String user_entitled) {
        return typeQuotationDao.findOneByEntitled(user_entitled);
    }

}
