package com.example.demogroup.model.role;

import javax.persistence.*;

@Entity
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id", nullable = false)
    private Integer id;

    @Enumerated(EnumType.STRING)
//    @Column(name = "role_name")
    private ERole roleName;

    public Role() {
    }
    public Role(ERole roleName) {
        this.roleName = roleName;
    }

//    @ManyToMany
//    @JoinTable(name = "user_role",
//            joinColumns = @JoinColumn(name = "role_code"),
//            inverseJoinColumns = @JoinColumn(name = "user_code"))
//    private Set<User> users = new LinkedHashSet<>();


    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public ERole getRoleName() {
        return roleName;
    }

    public void setRoleName(ERole roleName) {
        this.roleName = roleName;
    }

//    public Set<User> getUsers() {
//        return users;
//    }
//
//    public void setUsers(Set<User> users) {
//        this.users = users;
//    }
}
