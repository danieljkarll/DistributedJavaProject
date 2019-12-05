package FinalProject.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import javax.servlet.http.HttpServletRequest;



@Controller
public class HomeController {
    @RequestMapping(path = "/")
    public String showHomePage() {

        System.out.println("in home");
        return "index";
    }

    @RequestMapping(value = "/showCompanionPage", method = RequestMethod.GET)
    public String showSearchPage() {
        System.out.println("zzz");

        return "list-companions";
    }


    @RequestMapping(path = "/error")
    public String showErrorPage(HttpServletRequest request, Model theModel) {
        int httpErrorCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        String errorMsg;

        switch (httpErrorCode) {
            case 400:
                errorMsg = "Http Error Code 400: Bad request";
                break;
            case 401:
                errorMsg = "Http Error Code 401: Unauthorized";
                break;
            case 404:
                errorMsg = "Http Error Code 404: Resource not found";
                break;
            case 500:
                errorMsg = "Http Error Code 500: Internal server error";
                break;
            default:
                errorMsg = "Http Error Code " + httpErrorCode;
        }

        theModel.addAttribute("errorMessage", errorMsg);

        return "errors";
    }
}