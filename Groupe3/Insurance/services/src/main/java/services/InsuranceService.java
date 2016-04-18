package services;

import org.springframework.beans.factory.annotation.Autowired;
import repository.InsuranceRepository;

/**
 * Created by Enzo on 18/04/2016.
 */
public class InsuranceService implements IInsuranceService {
    @Autowired
    private InsuranceRepository insuranceRepository;
}
