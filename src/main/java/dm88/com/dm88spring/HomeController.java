package dm88.com.dm88spring;

import models.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class HomeController {

	@RequestMapping(method = RequestMethod.GET)
	public String sayHello(ModelMap model) {
		model.addAttribute("greeting", "Hello World from Spring 4 MVC");
		return "welcome";
	}

	@RequestMapping(value = "/helloagain", method = RequestMethod.GET)
	public String sayHelloAgain(ModelMap model) {
		model.addAttribute("greeting", "Hello World Again, from Spring 4 MVC");
		return "welcome";
	}
        
        
        @RequestMapping(value = "/person", method = RequestMethod.GET)
	public String getPerson(ModelMap model) {
		model.addAttribute("person", "This is a person");
		return "person";
	}
        
        
        @RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test(ModelMap model) {
		model.addAttribute("test", "This is a TEST");
		return "test";
	}
        
        //http://localhost:8080/Spring4MVCHelloWorldNoXMLDemo/student?id=33&firstname=Diego&lastname=Burlando&email=myemail
        @RequestMapping(value = "/student")  
        public @ResponseBody  
        Student getStudent(@RequestParam(value = "id", required=false) String id,
                           @RequestParam(value = "firstname", required=false) String name,
                           @RequestParam(value = "lastname", required=false) String lastName,
                           @RequestParam(value = "email", required=false) String email)
        {
            return new Student(id,name,lastName, email);
        }  
        
        
        
        

}