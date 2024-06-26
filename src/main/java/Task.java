import com.fasterxml.jackson.annotation.*;

public class Task {

    private String name;
    private boolean status;


    @JsonCreator
    public Task(@JsonProperty("name")String name, @JsonProperty("status")boolean status){
        this.name = name;
        this.status = status;
    }

    public Task(String name){
        this.name = name;
        this.status = false;
    }

    public String getName(){
        return this.name;
    }

    public boolean getStatus(){
        return this.status;
    }

    public void setStatus(boolean newStatus){
        this.status = newStatus;
    }

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
