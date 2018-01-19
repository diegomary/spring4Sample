package dm88.com.dm88spring;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import models.Flower;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.Arrays;
import java.util.List;
import javax.management.Query;
import models.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Criteria;

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
        
        //http://localhost:8080/dm88spring/student?id=33&firstname=Diego&lastname=Burlando&email=myemail
        @RequestMapping(value = "/student")  
        public @ResponseBody  
        Student getStudent(@RequestParam(value = "id", required=false) String id,
                           @RequestParam(value = "firstname", required=false) String name,
                           @RequestParam(value = "lastname", required=false) String lastName,
                           @RequestParam(value = "email", required=false) String email)
        {
            return new Student(id,name,lastName, email);
        }
        
        
        
        
       
        @RequestMapping(value = "/flower")  
        public @ResponseBody  
        org.bson.Document getFlower()
        {                  
            MongoCredential credential = MongoCredential.createCredential("booksadmin", "diegomary88", "diegomary".toCharArray());
            //MongoClient mongoClient = new MongoClient(new ServerAddress("ds061371.mlab.com",61371), Arrays.asList(credential));
            MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://booksadmin:diegomary@ds061371.mongolab.com:61371/diegomary88"));
            MongoDatabase db = mongoClient.getDatabase("diegomary88");         
            MongoCollection<org.bson.Document> mc = db.getCollection("BachFlowers");          
            long f =  mc.count();           
            FindIterable<org.bson.Document> Flowers = mc.find();
            org.bson.Document d = Flowers.first();   
            return d;        
        
        }
        
        
        
        
        
        
        

}