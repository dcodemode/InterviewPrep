package learn.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// This is a singleton class
public class PersonInstance {
    
    private static PersonInstance instance;
    
    private Map<Integer, List<Person>> map = new HashMap<>();
    private List<Person> personList;

    private PersonInstance(List<Person> personList){
        this.personList = personList;
        for(Person person : personList){
            this.map.putIfAbsent(person.getDepartment().getDepatmentId(), new ArrayList<>());
            this.map.get(person.getDepartment().getDepatmentId()).add(person);
        }
    }

    public List<Person> getPersonByDepartment(int departmentId){
        if(this.map.containsKey(departmentId)){
            return this.map.get(departmentId);
        }
        return new ArrayList<>();
    }

    public Person getPerson(Integer personId){
        for(Person person : this.personList){
            if(person.getPersonId().equals(personId)) {
                return person;
            }
        }
        return null;
    }

    private static PersonInstance getInstance(List<Person> personList){
        if(instance == null){
            return new PersonInstance(personList);
        }
        return instance;
    }

    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        PersonInstance obj = PersonInstance.getInstance(personList);

    }

}
class Person{

    private Integer personId;
    private Integer personName;
    private Department department;

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public Integer getPersonName() {
        return personName;
    }

    public void setPersonName(Integer personName) {
        this.personName = personName;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

}

class Department{
    private Integer depatmentId;
    private Integer departmentName;

    public Integer getDepatmentId() {
        return depatmentId;
    }

    public void setDepatmentId(Integer depatmentId) {
        this.depatmentId = depatmentId;
    }

    public Integer getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(Integer departmentName) {
        this.departmentName = departmentName;
    }

}
