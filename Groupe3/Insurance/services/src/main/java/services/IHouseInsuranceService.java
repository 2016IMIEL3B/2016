package services;

import model.HouseInsurance;
import model.Insurance;
import model.User;

import java.util.List;

/**
 * Created by Enzo on 18/04/2016.
 */
public interface IHouseInsuranceService {
    HouseInsurance findByInsurance(Insurance insurance);
}
