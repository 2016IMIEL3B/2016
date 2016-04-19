package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.GroupRepository;

/**
 * Created by Enzo on 18/04/2016.
 */
@Service
public class GroupService implements IGroupService {
        @Autowired
        private GroupRepository groupRepository;
}
