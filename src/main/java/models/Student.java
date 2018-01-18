package models;

/**
 *
 * @author Diego
 */
public class Student {
    public String id;
    public String FirstName;
    public String LastName;
    public String Email;   

public Student(String _id,String _firstName,String _lastName,String _email){
    id=_id;
    FirstName= _firstName;
    LastName= _lastName;
    Email = _email;
}
     
}