package com;


import com.front.Home;

/**
 * Created by kevin on 22/03/16.
 */
public interface IHomeService {
    Home findOneByQuotationId(int id);
}
