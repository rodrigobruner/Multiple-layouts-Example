package app.bruner.multiplelayoutsexample.models;

import java.io.Serializable;

//The object needs to be Serializable to work in the putExtra of the Intent object
public class UserDetails implements Serializable {

    //Name of user
    private String name;

    public UserDetails(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
