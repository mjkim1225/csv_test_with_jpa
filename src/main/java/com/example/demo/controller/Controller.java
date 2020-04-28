package com.example.demo.controller;


import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import com.example.demo.entity.Atmosphere;
import com.example.demo.entity.CsvUtils;
import com.example.demo.repository.AtmosRepository;
import com.example.demo.service.AtmosService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
        log.info("여기ㅈㅈㅈㅈㅈㅈㅈㅈㅈㅈㅈㅈㅈㅈㅈㅈㅈ");    
        try {
            log.info("**1");
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


    // @Autowired
    // private JdbcTemplate jdbcTemplate;


    // @PostMapping(value = "/upload", consumes = "multipart/form-data")
    // public void uploadMultipart(@RequestParam("file") MultipartFile file) {
    //     Date before = new Date();
    //     log.info("여기ㅈㅈㅈㅈㅈㅈㅈㅈㅈㅈㅈㅈㅈㅈㅈㅈㅈ");    
    //     try {
    //         log.info("**1");
    //         List<Atmosphere> atmos = CsvUtils.read(Atmosphere.class, file.getInputStream());
            
    //         // int i=0;
    //         // while(atmos.iterator().hasNext()){
    //         //     insert(atmos.get(i));
    //         //     i++;
    //         // }
            
    //             jdbcTemplate.save()

    //         Date after = new Date(); 
    //         System.out.println("시간 before : "+before);
    //         System.out.println("시간 after : "+after);
    //     } catch (Exception e) {
    //         log.info("**예외"+ e.toString()); 
    //         // e.toString()
    //     }
    // }

    // public void insert(Atmosphere atmosphere){
    //         String sql = " insert  into atmosphere (altitude, cl2, co, co2, cxhy, h2, h2s, hcl, hcn, humidity, lat, lon, measure_time, nh3, no2, o3_no2, ph3, pm1, pm10, pm25, pressure, so2, temperature, tsp, vocs, wr_so2) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    //         jdbcTemplate.update(sql, atmosphere.getAltitude(), atmosphere.getCl2(), atmosphere.getCo(), atmosphere.getCo2(), atmosphere.getCxhy(), atmosphere.getH2(), atmosphere.getH2s(), atmosphere.getHcl(), atmosphere.getHcn(), atmosphere.getHumidity(), atmosphere.getLat(), atmosphere.getLon(), new Date(), atmosphere.getNh3(), atmosphere.getNo2(), atmosphere.getO3no2(), atmosphere.getPh3(), atmosphere.getPm1(), atmosphere.getPm10(), atmosphere.getPm25(), atmosphere.getPressure(), atmosphere.getSo2(), atmosphere.getTemperature(), atmosphere.getTsp(), atmosphere.getVocs(), atmosphere.getWrSo2());
    // }



    
   

}

