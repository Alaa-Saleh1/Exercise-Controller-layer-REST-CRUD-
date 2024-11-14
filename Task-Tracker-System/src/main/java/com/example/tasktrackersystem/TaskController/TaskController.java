package com.example.tasktrackersystem.TaskController;

import com.example.tasktrackersystem.Model.Task;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/task-tracker-system")
public class TaskController {

    ArrayList<Task> tasks = new ArrayList<>();

    @GetMapping("/show")
    public ArrayList<Task> getTasks() {
        return tasks;
    }

    @PostMapping("/add")
    public String addTask(@RequestBody Task task) {
        tasks.add(task);
        return task.toString()+" is added";
    }

    @DeleteMapping("/delete/{index}")
    public String deleteTask(@PathVariable int index) {
        tasks.remove(index);
        return "Task is deleted";
    }

    @PutMapping("/update/{index}")
    public String updateTask(@PathVariable int index, @RequestBody Task task) {
        tasks.set(index, task);
        return task.toString()+" is updated";
    }

    @PutMapping("/change-status/{index}")
    public String changeStatus(@PathVariable int index) {
        if (tasks.get(index).getStatus().equalsIgnoreCase("not done")) {
            tasks.get(index).setStatus("done");
            return "Status of " + tasks.get(index).toString() + " is changed";
        }
        else return "Status of "+tasks.get(index).toString();
    }

    @GetMapping("/search-by-title/{titleSearch}")
    public String searchTask(@PathVariable String titleSearch) {
        for (Task task : tasks) {
            if (task.getTitle().toLowerCase().contains(titleSearch.toLowerCase())){
                return task.toString()+" is found";
            }
        }
        return titleSearch+" is not found";
    }




}
