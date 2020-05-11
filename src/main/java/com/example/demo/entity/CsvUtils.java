package com.example.demo.entity;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CsvUtils {
    private static final CsvMapper mapper = new CsvMapper();
    
    public static <T> List<T> read(Class<T> clazz, InputStream stream) throws IOException {
        log.info( "read()함수 호출" );
        CsvSchema schema = mapper.schemaFor(clazz).withHeader().withColumnReordering(true);
        ObjectReader reader = mapper.readerFor(clazz).with(schema);

        List<T> atmos = reader.<T>readValues(stream).readAll();

        log.info("size : "+ Integer.toString(atmos.size()) );

        return atmos;
    }

    public static void appending(StringBuilder sb) {
        sb.append("measureTime,altitude,lon,lat,temperature,humidity,pressure,vocs,so2,co,no2,o3no2,pm1,pm25,pm10,cxhy,h2s,hcl,wrSo2,tsp,nh3,co2,hcn,h2,ph3,cl2,");
        sb.append('\n');
    }
}