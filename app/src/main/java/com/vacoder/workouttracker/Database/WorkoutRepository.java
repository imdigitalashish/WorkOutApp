package com.vacoder.workouttracker.Database;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.room.Update;

import java.util.List;

public class WorkoutRepository {

    private WorkoutDAO workoutDAO;
    private LiveData<List<Workout>> allWorkout;

    public WorkoutRepository(Application application) {
        WorkoutDatabase workoutDatabase = WorkoutDatabase.getInstance(application);
        workoutDAO = workoutDatabase.workoutDAO();
        allWorkout = workoutDAO.getAllWorkOut();
    }

    public void insert(Workout workout) {
        new InsertAsynTask(workoutDAO).execute(workout);
    }

    public void update(Workout workout) {
        new UpdateAsyncTask(workoutDAO).execute(workout);
    }

    public void delete(Workout workout) {
        new DeleteAsyncTask(workoutDAO).execute(workout);
    }

    public void deleteAll() {
        new DeleteAllAsyncTask(workoutDAO).execute();
    }

    public LiveData<List<Workout>> getAllWorkout() {
        return allWorkout;
    }

    public class InsertAsynTask extends AsyncTask<Workout, Void, Void> {
        private WorkoutDAO workoutDAO;

        private InsertAsynTask(WorkoutDAO workoutDAO) {
            this.workoutDAO = workoutDAO;
        }

        @Override
        protected Void doInBackground(Workout... workouts) {
            workoutDAO.insert(workouts[0]);
            return null;
        }
    }


    public class UpdateAsyncTask extends AsyncTask<Workout, Void, Void> {
        private WorkoutDAO workoutDAO;

        private UpdateAsyncTask(WorkoutDAO workoutDAO) {
            this.workoutDAO = workoutDAO;
        }

        @Override
        protected Void doInBackground(Workout... workouts) {
            workoutDAO.update(workouts[0]);
            return null;
        }
    }


    public class DeleteAsyncTask extends AsyncTask<Workout, Void, Void> {
        private WorkoutDAO workoutDAO;

        private DeleteAsyncTask(WorkoutDAO workoutDAO) {
            this.workoutDAO = workoutDAO;
        }

        @Override
        protected Void doInBackground(Workout... workouts) {
            workoutDAO.delete(workouts[0]);
            return null;
        }
    }

    private static class DeleteAllAsyncTask extends AsyncTask<Void, Void, Void> {
        private WorkoutDAO workoutDAO;

        private DeleteAllAsyncTask(WorkoutDAO workoutDAO) {
            this.workoutDAO = workoutDAO;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            workoutDAO.deleteAllWorkout();
            return null;
        }
    }


}
