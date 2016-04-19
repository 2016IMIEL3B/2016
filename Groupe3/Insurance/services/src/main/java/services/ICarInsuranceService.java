package services;

import model.CarInsurance;
import model.Insurance;
import model.User;

import java.util.List;

/**
 * Created by Enzo on 18/04/2016.
 */
public interface ICarInsuranceService {
    CarInsurance findByInsurance(Insurance insurance);
    CarInsurance saveAndgetCarInsurance(CarInsurance carInsurance);
    void saveCarInsurance(CarInsurance carInsurance);
}
