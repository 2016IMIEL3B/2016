package dao;

import entity.front.Quotation;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by kevin on 22/03/16.
 */
public interface QuotationRepository extends CrudRepository<Quotation,Integer>{

    Quotation findByAll();
}
