package intern.todolist.repositories;

import intern.todolist.entities.Job;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Component
public class JobRepository {
    private List<Job> jobs = new ArrayList<>();

    // Todo-list: Khoi tao du lieu ban dau cho toan bo ung dung Todo-list
    public JobRepository() {
        jobs = new ArrayList<>(
                List.of(
                        new Job(1, "Job 1", "Do something...", LocalDate.now(), LocalDate.now(), false, LocalDateTime.now(), null, false),
                        new Job(2, "Job 2", "Do something...", LocalDate.now(), LocalDate.now(), false, LocalDateTime.now(), null, false),
                        new Job(3, "Job 3", "Do something...", LocalDate.now(), LocalDate.now(), false, LocalDateTime.now(), null, false)));
    };

    // Todo-list: Lay tong so records tao Id tang dan co Job moi
    public int total() {
        return jobs.size();
    }

    // Todo-list: Lay danh sach viec can lam
    public List<Job> getJobs() {
        return jobs.stream().filter(j -> !j.isDeleted()).sorted(Comparator.comparing(Job::getCreatedAt).reversed()).toList();
    }

    // Todo-list: Lay Job Id
    public Job getJobById(int id) {
        return jobs.stream().filter(j -> j.getId() == id).findFirst().orElse(null);
    }

    // Todo-list: Kiem tra Job da ton tai chua
    public boolean isExist(Job job) {
        return jobs.stream().anyMatch(j -> !j.isDeleted() && j.getTitle().equalsIgnoreCase(job.getTitle()));
    }

    // Todo-list Lay Job bang title
    public Job getJobByName(String title) {
        return jobs.stream().filter(j -> j.getTitle().equals(title)).findFirst().orElse(null);
    }

    // Todo-list: Them Job moi
    public int save(Job job) {
        jobs.add(job);
        return 0;
    }

    // Todo-list luu Job Cap nhat
    public boolean saveUpdate(Job jobUpdated) {
        for (int i = 0; i < jobs.size(); i++) {
            if (jobs.get(i).getId() == (jobUpdated.getId())) {
                jobs.set(i, jobUpdated);
                return true;
            }
        }
        return false;
    }

    // todo-list: Xoa Job
    public boolean remove(int id) {
        try {
            jobs.removeIf(j -> j.getId() == id);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}
