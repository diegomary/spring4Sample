package models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

 
@Document(collection="BachFlowers")
public class Flower {
    @Id
    int Id;
    String Name;
    String Description;
    String ImagePath;
    String FlowerColor;
  
    public Flower(int id, String name, String description,String imagePath,String flowerColor){
        this.Id = id;
        this.Name = name;
        this.Description = description;
        this.ImagePath = imagePath;
        this.FlowerColor = flowerColor;
    } 
   
} 