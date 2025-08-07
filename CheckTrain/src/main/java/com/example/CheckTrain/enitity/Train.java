package com.example.CheckTrain.enitity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Train {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String trainName;
    private String trainNumber;

    @OneToMany(mappedBy = "train",cascade = CascadeType.ALL)
    @JsonBackReference
    private List<com.example.CheckTrain.enitity.TrainSchedule> scheduleList;
    public Train()
    {

    }

    public Train(Long id, String trainName, String trainNumber, List<com.example.CheckTrain.enitity.TrainSchedule> scheduleList) {
        this.id = id;
        this.trainName = trainName;
        this.trainNumber = trainNumber;
        this.scheduleList = scheduleList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public String getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(String trainNumber) {
        this.trainNumber = trainNumber;
    }

    public List<com.example.CheckTrain.enitity.TrainSchedule> getScheduleList() {
        return scheduleList;
    }

    public void setScheduleList(List<com.example.CheckTrain.enitity.TrainSchedule> scheduleList) {
        this.scheduleList = scheduleList;
    }
}
