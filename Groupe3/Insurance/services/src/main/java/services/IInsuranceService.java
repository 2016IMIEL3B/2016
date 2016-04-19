package services;

import model.Insurance;
import model.User;
import java.util.List;

/**
 * Created by Enzo on 18/04/2016.
 */
public interface IInsuranceService {
    List<Insurance> findByStatementAndUser(String statement, User user);
    Insurance findByIdInsurance(int idInsurance);
    Insurance saveAndgetInsurance(Insurance insurance);
    void saveInsurance(Insurance insurance);
}
