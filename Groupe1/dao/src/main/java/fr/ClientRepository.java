package fr;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by joe on 18/04/2016.
 */
public interface ClientRepository extends CrudRepository<Client,Integer> {

    Client save (Client client);

    Client findOne(Integer integer);

    Iterable<Client> findAll();

    void delete(Integer integer);


}
