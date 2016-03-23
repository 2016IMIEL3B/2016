package com;

import com.front.Driver;

/**
 * Created by kevin on 22/03/16.
 */
public interface IDriverService {
    Driver findOneByCarId(int driverId);
}
