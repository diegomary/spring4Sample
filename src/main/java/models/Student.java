package models;

/**
 *
 * @author Diego
 */
public class Student {
    private String id;
    private String firstName;
    private String lastName;
    private String email; 
    
public Student(String _id,String _firstName,String _lastName,String _email){
    this.id=_id;
    this.firstName= _firstName;
    this.lastName= _lastName;
    this.email = _email;
}


public String getId() {return this.id;}    
public void setId(String _id) {this.id = _id;}

public String getFirstName(){return this.firstName;}    
public void setFirstName(String _firstName) { this.firstName = _firstName;}

public String getLastName(){return this.lastName;}    
public void setLastName(String _lastName){this.lastName = _lastName;}

public String getEmail(){return this.email;}    
public void setEmail(String _email){this.email = _email;}





     
}