import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;

public class TaskManager {
    private static ObjectMapper objectMapper = new ObjectMapper();
//    public static List<Task> tasks = new ArrayList<>();
    public static List<Task> tasks;

    static {
        try {
            tasks = getTasksFromFile();
        } catch (IOException e) {
            tasks = new ArrayList<>();
        }
    }


    public static void addTask(Task newTask) throws IOException {
        tasks.add(newTask);
        System.out.println("Task added.");
    }

    public static void deleteTask(Task taskToDelete) throws IOException {

        if (tasks.isEmpty()){
            System.out.println("Task list is empty.");
            return;
        }

        for (Task task : tasks){
            if (task.equals(taskToDelete)) {
                tasks.remove(taskToDelete);
                System.out.println("Task removed.");
                return;
            }

        }
        System.out.println("Task does not exist");

    }

    public static void viewTasks(){

        if (tasks.isEmpty()){
            System.out.println("No tasks.");
            return;
        }

        int index = 1;
        String status;
        for (Task task : tasks){

            if (!task.getStatus()) status = "Not done";
            else status = "Done";

            System.out.println("| " + index + " | "+ task + " | "+ status+" |");
            index +=1;
        }

    }

    public static void markTaskDone(Task taskDone) throws IOException {
        if (tasks.isEmpty()){
            System.out.println("Task list is empty.");
            return;
        }

        for (Task task : tasks){
            if (task.equals(taskDone)) {
                task.setStatus(true);
                return;
            }

        }
        System.out.println("Task does not exist");
    }

    public static void updateFile() throws IOException {
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        objectMapper.writeValue(new File("tasks.json"), tasks);
    }

    public static List<Task> getTasksFromFile() throws IOException {
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        tasks = objectMapper.readValue(new File("tasks.json"), objectMapper.getTypeFactory().constructCollectionType(List.class, Task.class));

        return tasks;
    }


}
