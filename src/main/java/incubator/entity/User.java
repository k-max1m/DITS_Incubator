package incubator.entity;
import javax.persistence.*;

@Entity
@Table(name="user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    private String firstName;
    private String lastName;
    private String login;
    private String password;


    @ManyToOne
    @JoinColumn(name="roleId")
    private Role role;

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }

    public int getUserId() {
        return userId;
    }

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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setRole(int roleId) {
        if(roleId == 1) this.getRole().setAdmin('1');
        else this.getRole().setAdmin('0');
        if(roleId == 2) this.getRole().setTutor('1');
        else this.getRole().setTutor('0');
        if(roleId == 3) this.getRole().setUser('1');
        else this.getRole().setUser('0');
    }

    public void setAdmin(int value){
        if(value == 0){
            this.getRole().setAdmin('0');
        }
        else{
            this.getRole().setAdmin('1');
        }
    }
    public void setTutor(int value){
        if(value == 0){
            this.getRole().setTutor('0');
        }
        else{
            this.getRole().setTutor('1');
        }
    }
    public void setUser(int value){
        if(value == 0){
            this.getRole().setUser('0');
        }
        else{
            this.getRole().setUser('1');
        }
    }
    public User(String firstName, String lastName, String login, String password, Role role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
        this.password = password;
        this.role = role;
    }
    public User(String firstName, String lastName, String login, String password, int roleId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
        this.password = password;
        this.setRole(roleId);
    }
}
