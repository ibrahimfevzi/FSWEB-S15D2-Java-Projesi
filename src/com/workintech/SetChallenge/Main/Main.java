package com.workintech.SetChallenge.Main;

import com.workintech.SetChallenge.Entity.Task;
import com.workintech.SetChallenge.Entity.TaskData;
import com.workintech.SetChallenge.Enums.Priority;
import com.workintech.SetChallenge.Enums.Status;

import java.util.Set;

public class Main {
    public static void main(String[] args) {
        TaskData taskData = new TaskData();

        // Creating sample tasks
        Task task1 = new Task("ProjectA", "Implement feature X", Priority.HIGH, Status.ASSIGNED);
        Task task2 = new Task("ProjectB", "Fix bug Y", Priority.MED, Status.IN_PROGRESS);
        Task task3 = new Task("ProjectC", "Write documentation for Z", Priority.LOW, Status.IN_QUEUE);
        Task task4 = new Task("ProjectA", "Test feature X", Priority.MED, Status.ASSIGNED);
        Task task5 = new Task("ProjectB", "Refactor code", Priority.LOW, Status.IN_PROGRESS);
        Task task6 = new Task("ProjectC", "Optimize database queries", Priority.HIGH, Status.ASSIGNED);
        Task task7 = new Task("ProjectD", "Design UI for new module", Priority.HIGH, Status.IN_PROGRESS);
        Task task8 = new Task("ProjectE", "Write unit tests", Priority.MED, Status.ASSIGNED);
        Task task9 = new Task("ProjectF", "Write unit tests", Priority.MED, Status.IN_QUEUE);

        // Adding tasks to corresponding sets in taskData
        taskData.addTask("ann", task1);
        taskData.addTask("bob", task2);
        taskData.addTask("carol", task3);
        taskData.addTask("ann", task4);
        taskData.addTask("bob", task5);
        taskData.addTask("carol", task6);
        taskData.addTask("ann", task7);
        taskData.addTask("bob", task8);
        taskData.addTask("carol", task9);


        // Tüm çalışanların üzerindeki tasklar nelerdir ?
        Set<Task> allTasks = taskData.getTasks("all");
        System.out.println("All Tasks: " + allTasks);

        // Her bir çalışanın üzerindeki tasklar nelerdir ?
        Set<Task> annsTasks = taskData.getTasks("ann");
        Set<Task> bobsTasks = taskData.getTasks("bob");
        Set<Task> carolsTasks = taskData.getTasks("carol");
        System.out.println("Ann's Tasks: " + annsTasks);
        System.out.println("Bob's Tasks: " + bobsTasks);
        System.out.println("Carol's Tasks: " + carolsTasks);

        // Herhangi bir çalışana atanması yapılmamış tasklar nelerdir ?
        Set<Task> unassignedTasks = taskData.getUnassignedTasks();
        System.out.println("Unassigned Tasks: " + unassignedTasks);

        // Birden fazla çalışana atanmış task var mı ? Varsa bunlar hangileri ?
        Set<Task> duplicateTasks = taskData.getTasksAssignedToMultiple();
        System.out.println("Duplicate Tasks: " + duplicateTasks);

        // Getting union of Ann and Bob's tasks
        Set<Task> annAndBobTasks = taskData.getUnion(annsTasks, bobsTasks);
        System.out.println("Union of Ann and Bob's Tasks: " + annAndBobTasks);

        // Getting intersection of Bob and Carol's tasks
        Set<Task> bobAndCarolTasks = taskData.getIntersect(bobsTasks, carolsTasks);
        System.out.println("Intersection of Bob and Carol's Tasks: " + bobAndCarolTasks);

        // Getting difference of Carol's tasks from Ann's tasks
        Set<Task> carolTasksDifference = taskData.getDifference(annsTasks, carolsTasks);
        System.out.println("Difference of Carol's Tasks from Ann's Tasks: " + carolTasksDifference);
    }
}
