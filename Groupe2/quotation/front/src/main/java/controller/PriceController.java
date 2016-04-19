package controller;

import com.IQuotationService;
import com.auth.UserSession;
import com.back.Price;
import com.utils.RestHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@RestController
public class PriceController {

    @Autowired
    UserSession userSession;

    @RequestMapping(value = {"/price/{type}"}, method = RequestMethod.GET)
    public Price getPrice(@PathVariable String type){
        Price result = new RestHelper(userSession.getHeaderToken()).defaultRequest(
                "/api/price",
                type,
                HttpMethod.POST,
                Price.class
        ).getBody();

        return result;
    }

}
