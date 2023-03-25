package com.example.pierp.Services.Implementation;

import org.json.JSONObject;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.util.Base64;

@Service
public class CommonServicesImpl {

    public String ReferenceGenerator(String prefix){
        return switch (prefix) {
            case "Facture" -> "Fact" + (int) (Math.random() * 1000000);
            case "Garantie" -> "Gar" + (int) (Math.random() * 1000000);
            case "Tache" -> "Task" + (int) (Math.random() * 1000000);
            case "Piece" -> "Piece" + (int) (Math.random() * 1000000);
            default -> "R" + (int) (Math.random() * 1000000);
        };
    }
    public byte[] photoToByte(String photo)  {
       try{
           FileOutputStream fos = new FileOutputStream("C:\\Users\\mabro\\IdeaProjects\\GarageErp\\src\\main\\java\\com\\example\\pierp\\Assets\\test.jpg");
           byte[] variable =  Base64.getDecoder().decode(photo);
           fos.write(variable);
           fos.close();
           return variable ;
       }catch (Exception e){
          System.out.println(e.getMessage());
          return null ;
       }


    }
    public String BcryptPassword(String password){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.encode(password);
    }
}
