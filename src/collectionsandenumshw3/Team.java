/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package collectionsandenumshw3;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author volkan
 */
public class Team {
    private String name;
    private List<Person> members;

    public Team(String name) {
        this.name = name;
        this.members = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Person> getMembers() {
        return members;
    }

    public void addMember(Person person) {
        members.add(person);
    }
    
}
