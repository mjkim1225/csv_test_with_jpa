
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
import com.example.demo.entity.DroneProjectInfo;
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

    @PostMapping(value = "/atmosphere", consumes = "multipart/form-data")
    public String uploadAtmosphere(@RequestParam("file") MultipartFile file) {
        Date before = new Date();
        File newFile = new File("testForAPI.csv");

        try {
        BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()));
        StringBuilder sb = new StringBuilder();

        CsvUtils.appending(sb);

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


    // 그 다음에 이제 프로젝트 만들기
    @PostMapping(value = "/droneproject", consumes = "multipart/form-data")
    public String uploadDroneProjectInfo(@RequestParam DroneProjectInfo  droneProjectInfo) {
        Date before = new Date();
   

        Date after = new Date(); 

        return (before+",\n "+after);

    }


}