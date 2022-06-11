package dtos;

import entities.Role;
import entities.User;

import java.util.List;

public class RoleDTO {
    String role;
    List<User> userList;

    public RoleDTO() {
    }

    public RoleDTO(Role role){
        this.role = role.getRoleName();
        this.userList = role.getUserList();

    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    @Override
    public String toString() {
        return "RoleDTO{" +
                "role='" + role + '\'' +
                ", userList=" + userList +
                '}';
    }
}
