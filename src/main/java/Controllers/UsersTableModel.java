package Controllers;

public class UsersTableModel {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String gender;
    private int phoneNum;
    private Integer idColum;

    public UsersTableModel(Integer idColum, String firstName, String lastName, String email, String password, String gender, int phoneNum) {
        this.idColum = idColum;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.phoneNum = phoneNum;
    }

    public Integer getIdColum() {
        return idColum;
    }

    public void setIdColum(Integer idColum) {
        this.idColum = idColum;
    }

    public String getFirstName() {

        return firstName;
    }

    public void setFirstName(String fullName) {

        this.firstName = fullName;
    }

    public String getLastName() {

        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {

        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(int phoneNum) {
        this.phoneNum = phoneNum;
    }


}
