package com.example.todo.Controller;
import com.example.todo.Model.Task;
import com.example.todo.Repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@CrossOrigin(origins = "http://localhost:4200")
@Controller
public class TaskController {

    @Autowired
    TaskRepository taskRepository;

    //open add task page
    @GetMapping("/newTask")
    public String newTask(Task task, Model model){
        return "add-task";
    }

    //add new task and return to show all tasks page
    @PostMapping("/addtask")
    public String addTask(@Valid Task task, BindingResult result, Model model) {
        if (result.hasErrors()){
            return "add-task";
        }
        taskRepository.save(task);
        return "redirect:/index";
    }

    //show all tasks page
    @GetMapping("/index")
    public String showAllTasks(Model model){
        model.addAttribute("tasks", taskRepository.findAll());
        return "index";
    }
    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid task Id:" + id));

        model.addAttribute("task", task);
        return "update-task";
    }
    @GetMapping("/delete/{id}")
    public String deleteTask(@PathVariable("id") long id, Model model) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid task Id:" + id));
        taskRepository.delete(task);
        model.addAttribute("tasks", task);
        return "redirect:/index";
    }
    @PostMapping("/update/{id}")
    public String updateInfo(@PathVariable("id") long id, @Valid Task task,
                             BindingResult result, Model model) {
        if (result.hasErrors()) {
            task.setId(id);
            return "update-task";
        }
        taskRepository.save(task);
        return "redirect:/index";
    }
}
