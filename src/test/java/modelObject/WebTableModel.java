package modelObject;

public class WebTableModel extends BaseModel {
    // User details
    private String firstName;
    private String lastName;
    private String userEmail;
    private String age;
    private String salary;
    private String department;

    // Edited user details
    private String editFirstName;
    private String editLastName;
    private String editEmail;
    private String editAge;
    private String editSalary;
    private String editDepartment;

    public WebTableModel(String jsonFilePath) {
        super(jsonFilePath);
    }

    // Getters and Setters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEditFirstName() {
        return editFirstName;
    }

    public void setEditFirstName(String editFirstName) {
        this.editFirstName = editFirstName;
    }

    public String getEditLastName() {
        return editLastName;
    }

    public void setEditLastName(String editLastName) {
        this.editLastName = editLastName;
    }

    public String getEditEmail() {
        return editEmail;
    }

    public void setEditEmail(String editEmail) {
        this.editEmail = editEmail;
    }

    public String getEditAge() {
        return editAge;
    }

    public void setEditAge(String editAge) {
        this.editAge = editAge;
    }

    public String getEditSalary() {
        return editSalary;
    }

    public void setEditSalary(String editSalary) {
        this.editSalary = editSalary;
    }

    public String getEditDepartment() {
        return editDepartment;
    }

    public void setEditDepartment(String editDepartment) {
        this.editDepartment = editDepartment;
    }
}

