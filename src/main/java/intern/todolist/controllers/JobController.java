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

    // Todo-list: Trang mac dinh cua Jobs todo-list, liet ke danh sach viec can lam
    @GetMapping({"/", ""})
    public String listTodo(ModelMap model) {
        List<Job> jobs = jobService.findAll().stream().toList();
        model.put("jobs", jobs);
        return "web/views/job/list";
    }

    //  Todo-list: Trang xem noi dung chi tiet cua viec can lam
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        System.out.println("Delete job with id: " + id);
        boolean isDelete = jobService.remove(id);
        System.out.println("Delete job is " + isDelete);
        return "redirect:/job";
    }

    // Todo-list: Trang cap nhat thong tin viec can lam voi phuong thuc GET tra View cho nguoi dung
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") int id, ModelMap model) {
        Job job = jobService.findById(id);
        model.put("job", job);
        return "web/views/job/edit";
    }

    // Todo-list: Trang cap nhat thong tin viec can lam voi phuong thuc POST
    @PostMapping("/edit")
    public String edit(@ModelAttribute Job job, ModelMap model) {
        if (!job.getTitle().matches("^[a-zA-Z0-9 ]+$")) {
            model.put("msg", "Tieu de khong nen chua ky tu dac biet.");
            return "web/views/job/edit";
        }
        if (job.getEndDate().isBefore(job.getStartDate())) {
            model.put("msg", "Ngay ket thuc phai lon hon hoac bang ngay bat dau");
            return "web/views/job/edit";
        }

        if (job.getDescription().length() > 166) {
            model.put("msg", "Mo ta toi da 165 ky tu");
            return "web/views/job/edit";
        }

        jobService.update(job);
        return "redirect:/job";
    }

    // Todo-list: Trang them viec can lam voi phuong thuc GET tra view cho nguoi dung
    @GetMapping("/add")
    public String add(ModelMap model) {
        model.put("job", new Job());
        return "web/views/job/add";
    }

    // Todo-list: Trang them viec can lam voi phuong thuc POST cho phep nguoi dung them moi viec can lam
    @PostMapping("/add")
    public String add(@ModelAttribute Job job, ModelMap model) {
        int count = jobService.getTotal();
        job.setId(count + 1);

        if (!job.getTitle().matches("^[a-zA-Z0-9 ]+$")) {
            model.put("msg", "Tieu de khong nen chua ky tu dac biet.");
            return "web/views/job/add";
        }

        if (job.getDescription().length() > 166) {
            model.put("msg", "Mo ta toi da 165 ky tu");
            return "web/views/job/add";
        }

        int result = jobService.add(job);
        if (result == 1) {
            model.put("msg", "Ten Job da ton tai, doi ten Job");
            return "web/views/job/add";
        }

        if (result == 2) {
            model.put("msg", "Ngay ket thuc phai lon hon hoac bang ngay bat dau");
            return "web/views/job/add";
        }
        return "redirect:/job";
    }

    // Todo-list: Chuc nang search tim kiem tieu de viec can lam
    @GetMapping("/search")
    public String search(@PathParam("keyword") String keyword, ModelMap model) {
        if (keyword.equals("")) {
            model.put("jobs", jobService.findAll());
            return "web/views/job/list";
        }
        List<Job> filterJob = jobService.findAll()
                .stream()
                .filter(job -> job.getTitle()
                        .toLowerCase()
                        .contains(keyword.toLowerCase()))
                .toList();
        model.put("jobs", filterJob);
        model.put("keyword", keyword);
        return "web/views/job/list";
    }

    // Todo-list: Chuc nang filter trang thai viec can lam Completed/Process tu nguoi dung
    @GetMapping("/filter")
    public String status(@PathParam("status") String status, ModelMap model) {
        if (status.equals("")) {
            model.put("jobs", jobService.findAll());
            return "web/views/job/list";
        }
        List<Job> filterJob = jobService.findAll()
                .stream()
                .filter(job -> job.isStatus() == Boolean.parseBoolean(status))
                .toList();
        model.put("jobs", filterJob);
        model.put("status", status);
        return "web/views/job/list";
    }
}
