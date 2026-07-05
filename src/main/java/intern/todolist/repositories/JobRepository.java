package intern.todolist.repositories;

import intern.todolist.entities.Job;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Component
public class JobRepository {
    private List<Job> jobs = new ArrayList<>();

    // Todo-list: Seeding data on Ram machine
    public JobRepository() {
        jobs = new ArrayList<>(List.of(
                new Job(1, "Reading", "Reading 10 pages on a book per day", null, null, false, LocalDateTime.now(), null, false),
                new Job(2, "Apply CV", "2 CV per day", null, null, false, LocalDateTime.now(), null, false),
                new Job(3, "Learn skill", "Understanding one skill per day", null, null, false, LocalDateTime.now(), null, false)
        ));
    }

    public int total() {
        return jobs.size();
    }

    // Get list todo-list
    public List<Job> getJobs() {
        return jobs.stream()
                .filter(j -> !j.isDeleted())
                .sorted(Comparator.comparing(Job::getCreatedAt).reversed())
                .toList();
    }

    // todo-list get by ID
    public Job getJobById(int id) {
        return jobs.stream().filter(j -> j.getId() == id).findFirst().orElse(null);
    }

    // todo-list checkin exist
    public boolean isExist(Job job) {
        return jobs.stream().anyMatch(j -> !j.isDeleted() && j.getTitle().equalsIgnoreCase(job.getTitle()));
    }

    // todo-list get by name/title
    public Job getJobByName(String title) {
        return jobs.stream().filter(j -> j.getTitle().equals(title)).findFirst().orElse(null);
    }

    // todo-list save a new job
    public int save(Job job) {
        jobs.add(job);
        return 0;
    }

    // todo-list save updated job into todo-list
    public boolean saveUpdate(Job jobUpdated) {
        for (int i = 0; i < jobs.size(); i++) {
            if (jobs.get(i).getId() == (jobUpdated.getId())) {
                jobs.set(i, jobUpdated);
                return true;
            }
        }
        return false;
    }

    // todo-list remove jon
    public boolean remove(int id) {
        try {
            jobs.removeIf(j -> j.getId() == id);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}
