package com.example.demo;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.entity.Atmosphere;
import com.example.demo.entity.CsvUtils;
import com.example.demo.repository.AtmosRepository;
import com.example.demo.service.AtmosService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.MOCK)
@AutoConfigureMockMvc
// @Transactional
public class FileRepositoryTest {

    @Autowired
    AtmosService atmosService;


    
    @Test
    public void test(){
        System.out.println("start@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        
        ArrayList<String> csvFile = run("C:\\test.csv", "utf-8");
        
        System.out.println("사이즈는: "+csvFile.size());

    }


    private ArrayList<String> run(String path, String encoding) {
        BufferedReader br = null;
        StringBuilder sb = new StringBuilder();

        CsvUtils.appending(sb);

        ArrayList<String> csvFile = new ArrayList<>();
        File newFile = new File("testForLocalFile.csv");

        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(path), encoding));

            while(true){
                String line = br.readLine();
                if(line==null) break;
                System.out.println("line  : "+line);
                if(line.startsWith("2")) {
                    sb.append(line);
                    sb.append('\n');
                    csvFile.add(line);
                }
                
            }
            
            try (PrintWriter writer = new PrintWriter(newFile) ) {
                writer.write(sb.toString());
                System.out.println("done!");
            } catch (FileNotFoundException e) {
                System.out.println("inside : "+e.getMessage());
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                List<Atmosphere> atmos = CsvUtils.read(Atmosphere.class, new FileInputStream(newFile));    
                atmosService.saveAll(atmos);
                
            } catch (Exception e) {
                System.out.println("**예외"+ e.toString()); 
            }
        }




        return csvFile;
    }


}



    




    // @Test
    // public void test() throws Exception{
    //     //파일읽고
    //     //읽어온거 그대로 가져와서
    //     //csvUtil해야하나,,
    //     //고민해야함
        

    //     //그러면 csvUtil을 service 클래스에서 실행해야할지, 아니면
    //     //controller에서 실행해야할지
    //     //respository는 아닌듯 아마 서비스단이 아닐까?

    //     //아니근데 살펴보니까 또 그건아닌거같아 controller에서 해도될거같..아니다

    //     //1. 일단은 서비스에 어떻게 옮길지 
    //     //2. try catch 문을 너무 많이 써서 그부분은 어떻게 하면 좋을지 생각해보자

    //     //일단 파일부터 읽자
    //     System.out.println("ddddddddddddddddd");

    //     //run("C:\test.csv", "utf-8");


    // }