package intern.todolist.services;

import intern.todolist.entities.Job;
import intern.todolist.repositories.JobRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;

@Component
@RequiredArgsConstructor
public class IJobService implements JobService {
    private final JobRepository jobRepository;

    @Override
    public int getTotal() {
        return jobRepository.total();
    }

    @Override
    public int add(Job job) {
        boolean isExist = this.isExist(job);
        if (isExist) return 1;
        LocalDate startDate = job.getStartDate();
        LocalDate endDate = job.getEndDate();
        if (endDate.isBefore(startDate)) {
            return 2;
        }
        return jobRepository.save(job);
    }

    @Override
    public boolean update(Job jobUpdate) {
        jobUpdate.setUpdatedAt(LocalDateTime.now());
        return jobRepository.saveUpdate(jobUpdate);
    }

    @Override
    public Collection<Job> findAll() {
        return jobRepository.getJobs();
    }

    @Override
    public Job findById(int id) {
        return jobRepository.getJobById(id);
    }

    @Override
    public boolean remove(int id) {
        Job jobDeleted = jobRepository.getJobById(id);
        if (jobDeleted == null) return false;
        jobDeleted.setDeleted(true);
        return jobRepository.saveUpdate(jobDeleted);
    }

    // Find by title/name
    @Override
    public Job findJobByTitle(String title) {
        return jobRepository.getJobByName(title);
    }

    // Check job is exist
    @Override
    public boolean isExist(Job job) {
        return jobRepository.isExist(job);
    }
}
