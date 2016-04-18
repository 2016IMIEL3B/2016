package services;

import org.springframework.beans.factory.annotation.Autowired;
import repository.RoleRepository;

/**
 * Created by Enzo on 18/04/2016.
 */
public class RoleService implements IRoleService {
    @Autowired
    private RoleRepository roleRepository;
}
