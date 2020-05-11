package com.example.demo;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import com.example.demo.repository.AtmosRepository;

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
    private  AtmosRepository atmosRepository;


    
    @Test
    public void test(){

        System.out.println("dddddddddddddddddddddd");

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

    // private static void run(String path, String encoding) {
    //     BufferedReader br = null;
    //     String line;
    //     String cvsSplitBy = ",";

    //     try {
    //         br = new BufferedReader(new InputStreamReader(new FileInputStream(path), encoding));
    //         System.out.println("ddddddddddddddddd");
    //         while ((line = br.readLine()) != null) {
    //             String[] field = line.split(cvsSplitBy);
    //             System.out.println(field[0]);
    //             break;
    //         }
    //     } catch (FileNotFoundException e) {
    //         e.printStackTrace();
    //     } catch (IOException e) {
    //         e.printStackTrace();
    //     } finally {
    //         if (br != null) {
    //             try {
    //                 br.close();
    //             } catch (IOException e) {
    //                 e.printStackTrace();
    //             }
    //         }
    //     }
    // }


}



    

