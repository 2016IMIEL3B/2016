package services;

import model.HouseInsurance;
import model.Insurance;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.HouseInsuranceRepository;

import java.util.List;

/**
 * Created by Enzo on 18/04/2016.
 */
@Service
public class HouseInsuranceService implements IHouseInsuranceService {
    @Autowired
    private HouseInsuranceRepository houseInsuranceRepository;

    public HouseInsurance findByInsurance(Insurance insurance) {
        return houseInsuranceRepository.findByInsurance(insurance);
    }
}
