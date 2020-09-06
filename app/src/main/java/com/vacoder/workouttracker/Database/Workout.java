package com.vacoder.workouttracker.Database;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "workout")
public class Workout {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String date;
    private String timeOfWorkout;

    public Workout(String date, String timeOfWorkout) {
        this.date = date;
        this.timeOfWorkout = timeOfWorkout;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTimeOfWorkout() {
        return timeOfWorkout;
    }

    public void setTimeOfWorkout(String timeOfWorkout) {
        this.timeOfWorkout = timeOfWorkout;
    }
}
