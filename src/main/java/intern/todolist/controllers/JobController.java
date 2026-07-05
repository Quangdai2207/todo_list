package intern.todolist.controllers;

import intern.todolist.entities.Job;
import intern.todolist.services.JobService;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/job")
public class JobController {
    private final JobService jobService;


    @GetMapping({"/", ""})
    public String listTodo(ModelMap model) {
        List<Job> jobs = jobService.findAll().stream().toList();
        model.put("jobs", jobs);
        return "/web/views/job/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        System.out.println("Delete job with id: " + id);
        boolean isDelete = jobService.remove(id);
        System.out.println("Delete job is " + isDelete);
        return "redirect:/job";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") int id, ModelMap model) {
        Job job = jobService.findById(id);
        model.put("job", job);
        return "/web/views/job/edit";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute Job job) {
        System.out.println("Edit job: " + job.toString());
        jobService.update(job);
        return "redirect:/job";
    }

    @GetMapping("/add")
    public String add(ModelMap model) {
        model.put("job", new Job());
        return "/web/views/job/add";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute Job job, ModelMap model) {
        int count = jobService.getTotal();
        job.setId(count + 1);

        if (!job.getTitle().matches("^[a-zA-Z0-9 ]+$")) {
            model.put("msg", "Tieu de khong nen chua ky tu dac biet.");
            return "/web/views/job/add";
        }

        int result = jobService.add(job);
        if (result == 1) {
            model.put("msg", "Ten Job da ton tai, doi ten Job");
            return "/web/views/job/add";
        }

        if (result == 2) {
            model.put("msg", "Ngay ket thuc phai lon hon hoac bang ngay bat dau");
            return "/web/views/job/add";
        }
        return "redirect:/job";
    }

    @GetMapping("/search")
    public String search(@PathParam("keyword") String keyword, ModelMap model) {
        if (keyword.equals("")) {
            model.put("jobs", jobService.findAll());
            return "/web/views/job/list";
        }
        List<Job> filterJob = jobService.findAll()
                .stream()
                .filter(job -> job.getTitle()
                        .toLowerCase()
                        .contains(keyword.toLowerCase()))
                .toList();
        model.put("jobs", filterJob);
        model.put("keyword", keyword);
        return "/web/views/job/list";
    }

    @GetMapping("/filter")
    public String status(@PathParam("status")  String status, ModelMap model) {
        if (status.equals("")) {
            model.put("jobs", jobService.findAll());
            return "/web/views/job/list";
        }
        List<Job> filterJob = jobService.findAll()
                .stream()
                .filter(job -> job.isStatus() == Boolean.parseBoolean(status))
                .toList();
        model.put("jobs", filterJob);
        model.put("status", status);
        return "/web/views/job/list";
    }
}
