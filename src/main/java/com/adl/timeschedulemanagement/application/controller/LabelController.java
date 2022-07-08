package com.adl.timeschedulemanagement.application.controller;

import com.adl.timeschedulemanagement.domain.entities.Label;
import com.adl.timeschedulemanagement.domain.service.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/label")
public class LabelController {

    @Autowired
    LabelService labelService;

    @GetMapping
    private List<Label> getAll() {
        return labelService.getAll();
    }

    @GetMapping("/{id}")
    private Label getById(@PathVariable("id") int id) {
        return labelService.getById(id);
    }

    @PostMapping
    private Label create(@RequestBody Label label) {
        return labelService.create(label);
    }

    @PostMapping("/list")
    private List<Label> createAll(@RequestBody List<Label> labels) {
        return labelService.createAll(labels);
    }

    @PutMapping
    private Label update(@RequestBody Label label) {
        return labelService.update(label);
    }

    @DeleteMapping("/{id}")
    private Boolean removeById(@PathVariable("id") int id) {
        return labelService.removeById(id);
    }
}
