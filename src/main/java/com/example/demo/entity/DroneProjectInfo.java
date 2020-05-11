package com.example.demo.entity;

import java.sql.Date;

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
public class DroneProjectInfo {

    @Id 
    @GeneratedValue(generator = "generator") 
    @GenericGenerator(name = "generator", strategy = "increment")
    @Column(name="drone_project_id")
    private int id;

    private String droneProjectName;

    private String droneProjectType;

    private String shootingArea;

    @Column(columnDefinition = "NUMERIC(20,10)")
    private Double shootingUpperLeftLatitude;
    @Column(columnDefinition = "NUMERIC(20,10)")
    private Double shootingUpperLeftLongitude;
    @Column(columnDefinition = "NUMERIC(20,10)")
    private Double shootingUpperRightLatitude;
    @Column(columnDefinition = "NUMERIC(20,10)")
    private Double shootingUpperRightLongitude;
    @Column(columnDefinition = "NUMERIC(20,10)")
    private Double shootingLowerLeftLatitude;
    @Column(columnDefinition = "NUMERIC(20,10)")
    private Double shootingLowerLeftLongitude;
    @Column(columnDefinition = "NUMERIC(20,10)")
    private Double shootingLowerRightLatitude;
    @Column(columnDefinition = "NUMERIC(20,10)")
    private Double shootingLowerRightLongitude;

    @Column(columnDefinition = "GEOGRAPHY(POINT, 4326)")
    private String location;

    private String description;

    private int orthoImageCount;

    private int postprocessingImageCount;
    
    @Column(name="detected_object_item1_count")
    private int detectedObjectItem1Count;
    @Column(name="detected_object_item2_count")
    private int detectedObjectItem2Count;
    @Column(name="detected_object_item3_count")
    private int detectedObjectItem3Count;
    @Column(name="detected_object_item4_count")
    private int detectedObjectItem4Count;

    @Column(name="update_date", columnDefinition = "timestamp")
    private Date updateDate;
    @Column(name="insert_date", columnDefinition = "timestamp")
    private Date insertDate;


    //내가알기로 jpa가 카멜이거 변환 그냥 해주는걸로 알고 있는데 
    // 왜 안될까 그래서 내가 컬럼을 다 ㅈ작성하게 하는거야,,
    //csv유틸이라서 그런가..
    //아니야 그건 상관없어..csv에서 내가 컬럼명을 클래스 변수명이랑 똑같이 해놨으니까
    //그건 상관없어!
    //디비랑 엔티티 연동에 대해서 다시 찾아보자






    //외래키
    private int drone_id;

    
}
