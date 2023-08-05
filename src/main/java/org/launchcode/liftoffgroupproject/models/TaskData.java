package org.launchcode.liftoffgroupproject.models;

import java.util.ArrayList;

public class TaskData {

    public static ArrayList<Task> findByColumnAndValue(String column, String value, Iterable<Task> allTasks) {

        ArrayList<Task> results = new ArrayList<>();

        if (value.toLowerCase().equals("all")) {
            return (ArrayList<Task>) allTasks;
        }

        if (column.equals("all")){
            results = findByValue(value, allTasks);
            return results;
        }

        for (Task task : allTasks) {

            String aValue = getFieldValue(task, column);

            if (aValue != null && aValue.toLowerCase().contains(value.toLowerCase())) {
                results.add(task);
            }
        }
        return results;
    }

    public static String getFieldValue(Task task, String fieldName){
        String theValue;
        if (fieldName.equals("due date")){
            theValue = task.getDueDate().toString();
        } else if (fieldName.equals("description")){
            theValue = task.getDescription();
        } else if (fieldName.equals("start date")){
            theValue = task.getStartDate().toString();
        } else {
            theValue = task.getName();
        }

        return theValue;
    }
}
