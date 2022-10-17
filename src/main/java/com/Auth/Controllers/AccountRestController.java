package com.Auth.Controllers;

import com.Auth.Entities.*;
import com.Auth.Repository.AppRoleRepository;
import com.Auth.Repository.AppUserRepository;
import com.Auth.Repository.MailRepository;
import com.Auth.Services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
public class AccountRestController {
    @Autowired
    private AccountService accountService;
    @Autowired
    private AppRoleRepository appRoleRepository;
    @Autowired
    private AppUserRepository appUserRepository;
    @Autowired
    private MailRepository mailRepository;

    @GetMapping("/users")
    public List<AppUser> appUsers() {
        return accountService.listUsers();

    }

    @PostMapping(path = "/register")
    public AppUser saveUser(@RequestBody UserRegister userRegister) {
        AppUser user= accountService.addNewUser(userRegister);
        return user;
    }

    @PostMapping(path = "/roles")
    public AppRole saveRole(@RequestBody AppRole appRole) {
        return accountService.addNewRole(appRole);
    }

    @PostMapping(path = "/addRoleToUser")
    public void addRoleToUser(@RequestBody RoleUserForm roleUserForm) {
        accountService.addRoleToUser(roleUserForm.getUsername(), roleUserForm.getRolename());

    }


    @GetMapping(path = "/profile")
    public AppUser profile(Principal principal) {
        return accountService.loadUserByUsername(principal.getName());
    }

    @GetMapping(path = "/role/{role}")
    public AppRole getRole(@PathVariable String role) {
        AppRole appRole =  appRoleRepository.getByRole(role);
        System.out.println(appRole);
        return appRole;
    }

    @PostMapping("/actived")
    public String activeAccount(@RequestBody ActivateAccount activeAccount) throws Exception {
        String username = activeAccount.getUsername();
        Mail mail = mailRepository.findByUsername(username);
        System.out.println(mail);

        System.out.println("---------------------------");
        System.out.println(username);
        if(activeAccount.getCode().equals(mail.getCode())){
            AppUser appUser = accountService.loadUserByUsername(username);
            appUser.setActive(1);
            appUserRepository.save(appUser);
            return "Account was Activated successfully";
        }
        else{
            return "Invalid Code";
        }
    }
}
