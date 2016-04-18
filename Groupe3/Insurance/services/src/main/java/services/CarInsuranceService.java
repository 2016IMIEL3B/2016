package services;

import model.CarInsurance;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import repository.CarInsuranceRepository;

import java.util.List;

/**
 * Created by Enzo on 18/04/2016.
 */
public class CarInsuranceService implements ICarInsuranceService {
    @Autowired
    private CarInsuranceRepository carInsuranceRepository;
}
