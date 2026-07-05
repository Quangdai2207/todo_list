package intern.todolist.services;


import intern.todolist.entities.Job;

import java.util.Collection;

public interface JobService {
    int add(Job job);
    boolean update(Job job);
    Collection<Job> findAll();
    Job findById(int id);
    boolean remove(int id);
    Job findJobByTitle(String title);
    boolean isExist(Job job);
    int getTotal();
}
