package org.launchcode.liftoffgroupproject.models;

public enum TaskProgressEnum {
    TODO("To Do"),
    INPROGRESS("In Progress"),
    COMPLETED("Completed");

    private final String displayStatus;

    TaskProgressEnum(String displayStatus) {
        this.displayStatus = displayStatus;
    }

    public String getDisplayStatus() {
        return displayStatus;
    }

    public static TaskProgressEnum fromDisplayString(String displayString)
    {
        for(TaskProgressEnum myEnum : TaskProgressEnum.values()){
            if(myEnum.getDisplayStatus().equals(displayString.trim().toUpperCase())){
                return myEnum;}


        } return null;
    }
}
