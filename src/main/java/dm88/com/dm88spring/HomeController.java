package dm88.com.dm88spring;
import com.google.gson.Gson;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import models.Flower;
import models.Student;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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
       
        @RequestMapping(value = "/allflowers")  
        public @ResponseBody  
        List<org.bson.Document> getFlowers()
        {        
            MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://booksadmin:diegomary@ds061371.mongolab.com:61371/diegomary88"));
            MongoDatabase db = mongoClient.getDatabase("diegomary88");         
            MongoCollection<org.bson.Document> mc = db.getCollection("BachFlowers");        
            long f =  mc.count();                        
            List<org.bson.Document> all;
            all = mc.find().into(new ArrayList<>());
            return all;            
        }
        
        @RequestMapping(value = "/allflowersnames")  
        public @ResponseBody  
        List<String> getFlowers1()
        {                 
            MongoCredential credential = MongoCredential.createCredential("booksadmin", "diegomary88", "diegomary".toCharArray());
            MongoClient mongoClient = new MongoClient(new ServerAddress("ds061371.mlab.com",61371), Arrays.asList(credential));           
            MongoDatabase db = mongoClient.getDatabase("diegomary88");         
            MongoCollection<org.bson.Document> mc = db.getCollection("BachFlowers");                   
            FindIterable<org.bson.Document> it = mc.find();         
            List<String> allFlowers = new ArrayList<>();
            for (org.bson.Document document : it) {            
                boolean add = allFlowers.add(document.getString("Name"));            
            }           
            return  allFlowers;
            
        }       
        
        
        @RequestMapping(value = "/allflowersobjgson")  
        public @ResponseBody  
        String getFlowers2()
        {                 
            MongoCredential credential = MongoCredential.createCredential("booksadmin", "diegomary88", "diegomary".toCharArray());
            MongoClient mongoClient = new MongoClient(new ServerAddress("ds061371.mlab.com",61371), Arrays.asList(credential));           
            MongoDatabase db = mongoClient.getDatabase("diegomary88");         
            MongoCollection<org.bson.Document> mc = db.getCollection("BachFlowers");                   
            FindIterable<org.bson.Document> it = mc.find();         
            ArrayList<Flower> allFlowers = new ArrayList<>();
            for (org.bson.Document document : it) {
                allFlowers.add(new Flower(document.getInteger("Id"),
                document.getString("Name"),
                document.getString("Description"),
                document.getString("ImagePath"),document.getString("FlowerColor"))
                );            
            }           
            Gson gson = new Gson();
            String json = gson.toJson(allFlowers);
            return   json;            
        } 
        
        @RequestMapping(value = "/allflowersobjjackson")  
        public @ResponseBody  
        String getFlowers3() throws IOException
        {                 
            MongoCredential credential = MongoCredential.createCredential("booksadmin", "diegomary88", "diegomary".toCharArray());
            MongoClient mongoClient = new MongoClient(new ServerAddress("ds061371.mlab.com",61371), Arrays.asList(credential));           
            MongoDatabase db = mongoClient.getDatabase("diegomary88");         
            MongoCollection<org.bson.Document> mc = db.getCollection("BachFlowers");                   
            FindIterable<org.bson.Document> it = mc.find();         
            ArrayList<Flower> allFlowers = new ArrayList<>();
            for (org.bson.Document document : it) {
                allFlowers.add(new Flower(document.getInteger("Id"),
                document.getString("Name"),
                document.getString("Description"),
                document.getString("ImagePath"),document.getString("FlowerColor"))
                );            
            }           
             ObjectMapper mapper = new ObjectMapper();
             //mapper.configure(SerializationConfig.Feature.FAIL_ON_EMPTY_BEANS, false);
             return mapper.writeValueAsString(allFlowers);
                    
        } 
        
        @RequestMapping(value = "/allflowersautomatic")  
        public @ResponseBody  
        ArrayList<Flower> getFlowers4() throws IOException
        {                 
            MongoCredential credential = MongoCredential.createCredential("booksadmin", "diegomary88", "diegomary".toCharArray());
            MongoClient mongoClient = new MongoClient(new ServerAddress("ds061371.mlab.com",61371), Arrays.asList(credential));           
            MongoDatabase db = mongoClient.getDatabase("diegomary88");         
            MongoCollection<org.bson.Document> mc = db.getCollection("BachFlowers");                   
            FindIterable<org.bson.Document> it = mc.find();         
            ArrayList<Flower> allFlowers = new ArrayList<>();
            for (org.bson.Document document : it) {
                allFlowers.add(new Flower(document.getInteger("Id"),
                document.getString("Name"),
                document.getString("Description"),
                document.getString("ImagePath"),document.getString("FlowerColor"))
                );            
            }           
             
             return allFlowers;
                    
        }      
        
        
        
}