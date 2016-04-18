package services;

import org.springframework.beans.factory.annotation.Autowired;
import repository.HouseInsuranceRepository;

/**
 * Created by Enzo on 18/04/2016.
 */
public class HouseInsuranceService implements IHouseInsuranceService {
    @Autowired
    private HouseInsuranceRepository houseInsuranceRepository;
}
