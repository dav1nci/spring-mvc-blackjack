package org.dav1nci.dbservice;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by dav1nci on 05.11.15.
 */
@Entity
@Table(name = "roles")
public class RoleEntity
{
    @Id
    @Column(name = "id")
    @GeneratedValue
    private int id;
    @Column(name = "role")
    private String role;
    @OneToMany(cascade=CascadeType.ALL)
    @JoinTable(name="user_roles",
            joinColumns = {@JoinColumn(name="role_id", referencedColumnName="id")},
            inverseJoinColumns = {@JoinColumn(name="user_id", referencedColumnName="id")}
    )
    private Set<UserEntity> userRoles;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Set<UserEntity> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(Set<UserEntity> userRoles) {
        this.userRoles = userRoles;
    }
}
