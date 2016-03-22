package services;

import dao.QuotationRepository;
import entity.front.Quotation;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by kevin on 22/03/16.
 */
public class QuotationService implements IQuotationService {

    @Autowired
    private QuotationRepository quotationDao;

    @Override
    public Quotation findByAll() { return quotationDao.findByAll();  }
}
