package services;



import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.UserRepository;

/**
 * Created by Nico on 09/02/2016.
 */
@Service
public class HelloService implements IHelloService {
    @Override
    public String hello() {
        return "Hello from hello service";
    }

  }
