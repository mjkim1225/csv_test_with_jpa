package com.example.demo.entity ;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import javax.persistence.Id;


import org.hibernate.annotations.GenericGenerator;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Atmosphere {

    // @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    // @Column(name="atmosphere_id")
    @Id 
    @GeneratedValue(generator = "generator") 
    @GenericGenerator(name = "generator", strategy = "increment")
    @Column(name="atmosphere_id")
    public int id;

    @Column(columnDefinition = "NUMERIC(20,10)")
    public Double altitude;  
    @Column(columnDefinition = "NUMERIC(20,10)")
    private Double lat;
    @Column(columnDefinition = "NUMERIC(20,10)")
    private Double lon;

    @Column(columnDefinition = "NUMERIC(20,10)")
    private Double temperature;
    @Column(columnDefinition = "NUMERIC(20,10)")
    private Double humidity;
    @Column(columnDefinition = "NUMERIC(20,10)")
    private Double pressure;

    @Column(columnDefinition = "NUMERIC(20,10)")
    private Double vocs;
    @Column(columnDefinition = "NUMERIC(20,10)")
    private Double so2;
    @Column(columnDefinition = "NUMERIC(20,10)")
    private Double co;
    @Column(columnDefinition = "NUMERIC(20,10)")
    private Double no2;
    @Column(columnDefinition = "NUMERIC(20,10)", name="o3_no2")
    private Double o3no2;

    private int pm1;
    private int pm25;
    private int pm10;
    
    @Column(columnDefinition = "NUMERIC(20,10)")
    private Double cxhy;
    @Column(columnDefinition = "NUMERIC(20,10)")
    private Double h2s;
    @Column(columnDefinition = "NUMERIC(20,10)")
    private Double hcl;
    @Column(columnDefinition = "NUMERIC(20,10)", name="wr_so2")
    private Double wrSo2;
    @Column(columnDefinition = "NUMERIC(20,10)")
    private Double tsp;
    @Column(columnDefinition = "NUMERIC(20,10)")
    private Double nh3;
    @Column(columnDefinition = "NUMERIC(20,10)")
    private Double co2;
    @Column(columnDefinition = "NUMERIC(20,10)")
    private Double hcn;
    @Column(columnDefinition = "NUMERIC(20,10)")
    private Double h2;
    @Column(columnDefinition = "NUMERIC(20,10)")
    private Double ph3;
    @Column(columnDefinition = "NUMERIC(20,10)")
    private Double cl2;
    
    // @CreationTimestamp
    @Column(name="measure_time")
    private String measureTime;
    
    
    
}



/*
package com.example.demo.entity ;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Atmosphere {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="atmosphere_id")
    public int id;

    @Column(columnDefinition = "NUMERIC(20,10)")
    public Double altitude;  
    @Column(columnDefinition = "NUMERIC(20,10)")
    public Double lat;
    @Column(columnDefinition = "NUMERIC(20,10)")
    public Double lon;

    @Column(columnDefinition = "NUMERIC(20,10)")
    public Double temperature;
    @Column(columnDefinition = "NUMERIC(20,10)")
    public Double humidity;
    @Column(columnDefinition = "NUMERIC(20,10)")
    public Double pressure;

    @Column(columnDefinition = "NUMERIC(20,10)")
    public Double vocs;
    @Column(columnDefinition = "NUMERIC(20,10)")
    public Double so2;
    @Column(columnDefinition = "NUMERIC(20,10)")
    public Double no2;
    @Column(columnDefinition = "NUMERIC(20,10)", name="o3_no2")
    public Double o3no2;

    public int pm1;
    public int pm25;
    private int pm10;
    
    @Column(columnDefinition = "NUMERIC(20,10)")
    public Double cxhy;
    @Column(columnDefinition = "NUMERIC(13,10)")
    public Double h2s;
    @Column(columnDefinition = "NUMERIC(13,10)")
    public Double hcl;
    @Column(columnDefinition = "NUMERIC(13,10)", name="wr_so2")
    public Double wrSo2;
    @Column(columnDefinition = "NUMERIC(13,10)")
    public Double tsp;
    @Column(columnDefinition = "NUMERIC(13,10)")
    public Double nh3;
    @Column(columnDefinition = "NUMERIC(13,10)")
    public Double co2;
    @Column(columnDefinition = "NUMERIC(13,10)")
    public Double hcn;
    @Column(columnDefinition = "NUMERIC(13,10)")
    public Double h2;
    @Column(columnDefinition = "NUMERIC(13,10)")
    public Double ph3;
    @Column(columnDefinition = "NUMERIC(13,10)")
    public Double cl2;


    
    @CreationTimestamp
    public Date measureTime;
    
    
    
}
*/