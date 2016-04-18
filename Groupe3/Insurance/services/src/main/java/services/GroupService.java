package services;

import org.springframework.beans.factory.annotation.Autowired;
import repository.GroupRepository;

/**
 * Created by Enzo on 18/04/2016.
 */
public class GroupService implements IGroupService {
        @Autowired
        private GroupRepository groupRepository;
}
