package com.vacoder.workouttracker.Database;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class WorkoutViewModel extends AndroidViewModel {

    private WorkoutRepository workoutRepository;
    private LiveData<List<Workout>> allWorkout;

    public WorkoutViewModel(@NonNull Application application) {
        super(application);
        workoutRepository = new WorkoutRepository(application);
        allWorkout = workoutRepository.getAllWorkout();
    }

    public void insert(Workout workout) {
        workoutRepository.insert(workout);
    }

    public void update(Workout workout) {
        workoutRepository.update(workout);
    }

    public void delete(Workout workout) {
        workoutRepository.delete(workout);
    }

    public void deleteAllNotes(Workout workout) {
        workoutRepository.deleteAll();
    }

    public LiveData<List<Workout>> getAllWorkout() {
        return allWorkout;
    }

}
