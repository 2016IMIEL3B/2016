package com;

import com.front.Quotation;
import com.front.TypeQuotation;

/**
 * Created by kevin on 22/03/16.
 */
public interface ITypeQuotationService {

    TypeQuotation findOneByEntitled(String entitled);

}
