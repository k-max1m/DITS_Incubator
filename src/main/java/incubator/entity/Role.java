package incubator.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="Role")
public class Role implements Serializable {
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

    public void setRoleId(int roleId) {
        this.roleId = roleId;
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
