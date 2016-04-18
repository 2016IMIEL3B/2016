package services;

import model.Insurance;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.InsuranceRepository;
import java.util.List;

/**
 * Created by Enzo on 18/04/2016.
 */
@Service
public class InsuranceService implements IInsuranceService {
    @Autowired
    private InsuranceRepository insuranceRepository;

    public List<Insurance> findByStatementAndUser(String statement, User user) {
        return insuranceRepository.findByStatementAndUser(statement, user);
    }
}
