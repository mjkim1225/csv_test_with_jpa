
package com.example.demo.controller;







import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import com.example.demo.entity.Atmosphere;
import com.example.demo.entity.CsvUtils;
import com.example.demo.service.AtmosService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;



@Slf4j
@RestController
public class Controller {

    
    @Autowired
    AtmosService atmosService;

    // jpa repository  
    // @PostMapping(value = "/upload", consumes = "multipart/form-data")
    // public void uploadMultipart(@RequestParam("file") MultipartFile file) {
    //     Date before = new Date();
    //     try {
    //         List<Atmosphere> atmos = CsvUtils.read(Atmosphere.class, file.getInputStream());    
    //         System.out.println("atmos : "+atmos.get(0).getVocs());
    //         atmosService.saveAll(atmos);
    //         // 
    //         Date after = new Date(); 
    //         System.out.println("시간 before : "+before);
    //         System.out.println("시간 after : "+after);
    //     } catch (Exception e) {
    //         log.info("**예외"+ e.toString()); 
    //         // e.toString()
    //     }
    // }

     // jpa repository  
     @PostMapping(value = "/upload2", consumes = "multipart/form-data")
     public String uploadMultipart2(@RequestParam("file") MultipartFile file) {
        Date before = new Date();
        File newFile = new File("test.csv");

         try {
            BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()));
            StringBuilder sb = new StringBuilder();

            appending(sb);

            while(true){
                String line = br.readLine();
                if(line==null) break;
                if(line.startsWith("2")) {
                    sb.append(line);
                    sb.append('\n');
                }
            }
            
            try (PrintWriter writer = new PrintWriter(newFile) ) {
                writer.write(sb.toString());
                System.out.println("done!");
            } catch (FileNotFoundException e) {
                System.out.println("inside : "+e.getMessage());
            }

         } catch (Exception e) {
            System.out.println("outside : "+e.getMessage());   
         }
         
        
        try {
            List<Atmosphere> atmos = CsvUtils.read(Atmosphere.class, new FileInputStream(newFile));    
            atmosService.saveAll(atmos);
            
        } catch (Exception e) {
            log.info("**예외"+ e.toString()); 
        }

        Date after = new Date(); 

        return (before+",\n "+after);

     }

     private void appending(StringBuilder sb) {
         sb.append("measureTime,altitude,lon,lat,temperature,humidity,pressure,vocs,so2,co,no2,o3no2,pm1,pm25,pm10,cxhy,h2s,hcl,wrSo2,tsp,nh3,co2,hcn,h2,ph3,cl2,");
         sb.append('\n');
     }



}