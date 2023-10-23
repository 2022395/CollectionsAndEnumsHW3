/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package collectionsandenumshw3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 *
 * @author Volkan Tibet Tuylu -2022395
 * GitHub : 
 */
public class TeamCreation {
     public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        List<Team> teams = new ArrayList<>();
        Set<Integer> usedIds = new HashSet<>();

        // Read data from the csv file and store it in the 'people' list
        try (BufferedReader reader = new BufferedReader(new FileReader("MOCK_DATA.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    int id = Integer.parseInt(parts[0]);
                    String firstName = parts[1];
                    String lastName = parts[2];
                    String email = parts[3];
                    people.add(new Person(id, firstName, lastName, email));
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading the file.");
            
        }

        // Shuffle the list of people to randomize the team assignment
        Collections.shuffle(people);

        // Create 20 teams with unique members
        for (int i = 1; i <= 20; i++) {
            Team team = new Team("Team " + i);
            for (int j = 0; j < 5; j++) {
                // Ensure that each team member belongs to only one team
                Person person = null;
                do {
                    person = getRandomPerson(people);
                } while (usedIds.contains(person.getId()));
                usedIds.add(person.getId());
                team.addMember(person);
            }
            teams.add(team);
        }

        // Print the teams and their members
        for (Team team : teams) {
            System.out.println("Team: " + team.getName());
            for (Person person : team.getMembers()) {
                System.out.println("  " + person.getFirstName() + " " + person.getLastName()+ "/ Email: " + person.getEmail());
               
            }
            System.out.println();
        }
    }
     //chooses random person
    private static Person getRandomPerson(List<Person> people) {
        Random random = new Random();
        int randomIndex = random.nextInt(people.size());
        return people.remove(randomIndex);
    }
    
}
