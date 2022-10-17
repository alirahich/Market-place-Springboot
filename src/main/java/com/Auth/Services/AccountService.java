package com.Auth.Services;



import com.Auth.Entities.AppRole;
import com.Auth.Entities.AppUser;
import com.Auth.Entities.UserRegister;

import java.util.List;

public interface AccountService  {
    AppUser addNewUser(UserRegister userRegister);
    AppRole addNewRole(AppRole appRole);
    void addRoleToUser(String username,String roleName);
    AppUser loadUserByUsername(String username);
    List<AppUser> listUsers();

}


