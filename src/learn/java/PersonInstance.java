package learn.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// This is a singleton class
public class PersonInstance {
    
    private static PersonInstance instance;

    private Map<Integer, List<Person>> departmentMap = new HashMap<>();
    private Map<Integer, Person> personMap = new HashMap<>();

    private PersonInstance(List<Person> personList){
        for(Person person : personList){
            this.departmentMap.putIfAbsent(person.getDepartment().getDepatmentId(), new ArrayList<>());
            this.departmentMap.get(person.getDepartment().getDepatmentId()).add(person);

            if(!this.personMap.containsKey(person.getPersonId())){
                personMap.put(person.getPersonId(), person);
            }
        }
    }

    /**
     * Time Complexity: O(1)
     * @param departmentId
     * @return
     */
    public List<Person> getPersonByDepartmentId(int departmentId){
        return this.departmentMap.get(departmentId);
    }

    /**
     * Time Complexity: O(1)
     * @param personId
     * @return
     */
    public Person getPersonByPersonId(Integer personId){
        return this.personMap.get(personId);
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

        obj.getPersonByDepartmentId(11);
        obj.getPersonByPersonId(11);
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
