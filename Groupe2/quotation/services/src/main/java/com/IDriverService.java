package com;

import com.front.Driver;

/**
 * Created by kevin on 22/03/16.
 */
public interface IDriverService {
    Driver findOneByCarIdAndPrincipal(int carId, boolean principal);
    Driver save(Driver driver);
}
