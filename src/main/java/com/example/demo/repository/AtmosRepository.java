package com.example.demo.repository;



import java.io.InputStream;
import java.util.List;

import com.example.demo.entity.Atmosphere;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AtmosRepository extends JpaRepository<Atmosphere, Long> {

}