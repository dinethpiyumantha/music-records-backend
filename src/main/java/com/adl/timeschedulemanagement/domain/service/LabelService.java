package com.adl.timeschedulemanagement.domain.service;

import com.adl.timeschedulemanagement.domain.boundary.LabelRepositoryInterface;
import com.adl.timeschedulemanagement.domain.entities.Label;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LabelService {

    @Autowired
    LabelRepositoryInterface labelRepositoryInterface;

    public Label create(Label label) {
        return labelRepositoryInterface.save(label);
    }

    public List<Label> createAll(List<Label> labels) {
        return labelRepositoryInterface.saveAll(labels);
    }

    public Label getById(int id) {
        return labelRepositoryInterface.findById(id).get();
    }

    public List<Label> getAll() {
        List<Label> labels = new ArrayList<Label>();
        labelRepositoryInterface.findAll().forEach(label -> labels.add(label));
        return labels;
    }

    public Label update(Label label) {
        return labelRepositoryInterface.save(label);
    }

    public Boolean removeById(int id) {
        try {
            labelRepositoryInterface.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
