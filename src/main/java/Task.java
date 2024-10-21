import com.fasterxml.jackson.annotation.*;

import java.time.LocalDate;

public class Task {

    private String name;
    private boolean status;
    private LocalDate dueDate;


    @JsonCreator
    public Task(@JsonProperty("name")String name, @JsonProperty("status")boolean status){
        this.name = name;
        this.status = status;
    }

    public Task(String name){
        this.name = name;
        this.status = false;
        this.dueDate = null;
    }

    public String getName(){
        return this.name;
    }

    public boolean getStatus(){
        return this.status;
    }

    public LocalDate getDueDate() {
        return this.dueDate;
    }

    public void setStatus(boolean newStatus){
        this.status = newStatus;
    }

    public void setDueDate(LocalDate newDueDate){ this.dueDate = newDueDate; }

    public String toString(){
        return name;
    }

    public void setName(String newName){
        this.name = newName;
    }

    @Override
    public boolean equals(Object object){

        if (object == null) return false;
        if (this == object) return true;
        if (getClass() != object.getClass()) return false;

        final Task other = (Task) object;
        return this.name.equals(other.name);

    }

}
