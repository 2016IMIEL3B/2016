package controller;

import com.auth.UserSession;
import com.back.Model;
import com.utils.RestHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by kevin on 19/04/16.
 */
@RestController
public class ListController {

    @Autowired
    UserSession userSession;

    @RequestMapping(value = {"/modelByMark/{id}"}, method = RequestMethod.GET)
    public List<Model> modelByMark(@PathVariable int id){

        List<Model> models = this.getModelByMark(id);
        return models;

    }

    private List<Model> getModelByMark(int id) {
        return (List<Model>) new RestHelper(userSession.getHeaderToken()).apiRequest("/api/modelByMark/"+id).getBody();
    }
}
