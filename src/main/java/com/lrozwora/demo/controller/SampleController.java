package com.lrozwora.demo.controller;

import com.lrozwora.demo.entity.SampleEntity;
import com.lrozwora.demo.repository.SampleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SampleController {
    @Autowired
    private SampleRepository repository;

    @CrossOrigin
    @GetMapping("/create")
    String createSample() {
        SampleEntity entity = new SampleEntity();
        repository.saveAndFlush(entity);
        return "Sucessfully made " + entity.getId() + " sample!";
    }

    @CrossOrigin
    @GetMapping("/list")
    List<SampleEntity> listSamples() {
        return repository.findAll();
    }
}
