package com.example.pierp.Services.Implementation;

import com.fasterxml.jackson.databind.util.JSONPObject;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;

@Service
public class CommonServices {

    public String ReferenceGenerator(String prefix){
        switch (prefix){
            case "Facture":
                return "Fact"+(int)(Math.random()*1000000);
            case "Garantie":
                return "Gar"+(int)(Math.random()*1000000);
            case "Tache":
                return "Task"+(int)(Math.random()*1000000);
            case "Piece":
                return "Piece"+(int)(Math.random()*1000000);
            default:
                return "R"+(int)(Math.random()*1000000);
        }
    }
    public boolean photoToByte(String photo)  {
       try{

           JSONObject jsonpObject = new JSONObject(photo);
           String base64Image = jsonpObject.getString("photo");
           FileOutputStream fos = new FileOutputStream("C:\\Users\\mabro\\IdeaProjects\\GarageErp\\src\\main\\java\\com\\example\\pierp\\Assets\\test.jpg");
           byte[] variable =  Base64.getDecoder().decode(base64Image);
           fos.write(variable);
           fos.close();
           return true ;
       }catch (Exception e){
          System.out.println(e.getMessage());
          return false ;
       }


    }
}
