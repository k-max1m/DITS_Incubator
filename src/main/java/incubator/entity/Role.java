package incubator.entity;

import javax.persistence.*;

@Entity
@Table(name="Role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int roleId;
    private char tutor;
    private char user;
    private char admin;

    public Role(char tutor, char user, char admin) {
        this.tutor = tutor;
        this.user = user;
        this.admin = admin;
    }

    public Role() {
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleId=" + roleId +
                ", tutor=" + tutor +
                ", user=" + user +
                ", admin=" + admin +
                '}';
    }

    public int getRoleId() {
        return roleId;
    }

    public char getTutor() {
        return tutor;
    }

    public void setTutor(char tutor) {
        this.tutor = tutor;
    }

    public char getUser() {
        return user;
    }

    public void setUser(char user) {
        this.user = user;
    }

    public char getAdmin() {
        return admin;
    }

    public void setAdmin(char admin) {
        this.admin = admin;
    }
}
