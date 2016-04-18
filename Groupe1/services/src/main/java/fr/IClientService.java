package fr;

/**
 * Created by joe on 18/04/2016.
 */
public interface IClientService {

    Client save (Client client);

    Client findOne(Integer integer);

    Iterable<Client> findAll();

    void delete(Integer integer);
}
