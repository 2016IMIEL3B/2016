package services;

import model.HouseInsurance;
import model.Insurance;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import repository.HouseInsuranceRepository;

import java.util.List;

/**
 * Created by Enzo on 18/04/2016.
 */
public class HouseInsuranceService implements IHouseInsuranceService {
    @Autowired
    private HouseInsuranceRepository houseInsuranceRepository;

}
