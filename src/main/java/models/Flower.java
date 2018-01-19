package models;

//import org.springframework.data.mongodb.core.mapping.Document;
 
//@Document(collection="BachFlowers")
public class Flower {
   
  private   int Id;
  private  String Name;
  private  String Description;
  private  String ImagePath;
  private  String FlowerColor;
  
    public Flower(int id, String name, String description,String imagePath,String flowerColor){
        this.Id = id;
        this.Name = name;
        this.Description = description;
        this.ImagePath = imagePath;
        this.FlowerColor = flowerColor;
    }
    
    public int getId() {
        return this.Id;
    }
    
    public void setId(int num) {
        this.Id = num;
    }
    
    public String getName() {
        return this.Name;
    }
    
    public void setName(String name) {
        this.Name = name;
    }
    
    public String getDescription() {
        return this.Description;
    }
    
    public void setDescription(String description) {
        this.Description = description;
    }
    
    public String getImagePath() {
        return this.ImagePath;
    }
    
    public void setImagePath(String imagePath) {
        this.ImagePath = imagePath;
    }
    
    public String getFlowerColor() {
        return this.FlowerColor;
    }
    
    public void setFlowerColor(String flowerColor) {
        this.FlowerColor = flowerColor;
    }
   
} 