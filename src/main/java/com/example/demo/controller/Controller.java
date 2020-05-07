
package com.example.demo.controller;







import java.io.BufferedReader;

import java.io.InputStreamReader;

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

    @PostMapping(value = "/upload", consumes = "multipart/form-data")

    public void uploadMultipart(@RequestParam("file") MultipartFile file) {

        Date before = new Date();

        try {



            List<Atmosphere> atmos = CsvUtils.read(Atmosphere.class, file.getInputStream());    

            System.out.println("atmos : "+atmos.get(0).getVocs());

            atmosService.saveAll(atmos);

            // 

            Date after = new Date(); 

            System.out.println("시간 before : "+before);

            System.out.println("시간 after : "+after);

        } catch (Exception e) {

            log.info("**예외"+ e.toString()); 

            // e.toString()

        }

    }





     // jpa repository  

     @PostMapping(value = "/upload2", consumes = "multipart/form-data")

     public void uploadMultipart2(@RequestParam("file") MultipartFile file) {

         Date before = new Date();

         try {

             String line;

            BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()));

            while ((line = br.readLine()) != null) {

                System.out.println(line);

                String[] field = line.split(",");

                System.out.println(field.length);

                System.out.println(field[0]);

                System.out.println(field[1]);


                break;

            }



           

         } catch (Exception e) {

          

         }

     }



}