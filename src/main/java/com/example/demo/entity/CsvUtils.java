package com.example.demo.entity;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvParser;
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
}