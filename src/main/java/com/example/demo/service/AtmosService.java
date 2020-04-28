package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Atmosphere;
import com.example.demo.repository.AtmosRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AtmosService{

    @Autowired
    AtmosRepository atmosRepository;
    
    public void saveAll(List<Atmosphere> atmos) {
        log.info("service 도착");
        atmosRepository.saveAll(atmos);
    }



}