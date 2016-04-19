package services;

import model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.CarInsuranceRepository;

import java.util.List;

/**
 * Created by Enzo on 18/04/2016.
 */
@Service
public class CarInsuranceService implements ICarInsuranceService {
    @Autowired
    private CarInsuranceRepository carInsuranceRepository;

    public CarInsurance findByInsurance(Insurance insurance) {
        return carInsuranceRepository.findByInsurance(insurance);
    }

    public CarInsurance saveAndgetCarInsurance(CarInsurance carInsurance) {
        carInsuranceRepository.save(carInsurance);
        carInsurance.setId(carInsurance.getId());
        return carInsurance;
    }

    public void saveCarInsurance(CarInsurance carInsurance) {
        carInsuranceRepository.save(carInsurance);
    }
}
