package fr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by joe on 18/04/2016.
 */
@Service
public class ClientService implements IClientService{

    @Autowired
    private ClientRepository clientDao;


    @Override
    public Client save(Client client) {
        return clientDao.save(client);
    }

    @Override
    public Client findOne(Integer integer) {
        return clientDao.findOne(integer);
    }

    @Override
    public Iterable<Client> findAll() {
        return clientDao.findAll();
    }

    @Override
    public void delete(Integer integer) {

    }
}
