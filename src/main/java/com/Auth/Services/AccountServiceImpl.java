package com.Auth.Services;

import com.Auth.Entities.*;
import com.Auth.Repository.AppRoleRepository;
import com.Auth.Repository.AppUserRepository;
import com.Auth.Repository.MailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;
@Transactional
@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AppUserRepository appUserRepository;
    @Autowired
    private AppRoleRepository appRoleRepository;
    @Autowired
    private MailRepository mailRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private MailService mailService;

    @Override
    public AppUser addNewUser(UserRegister userRegister) {
        String _code = UserCode.getCode();
        AppUser user = appUserRepository.findByUsername(userRegister.getUsername());
        if(user!=null) throw new RuntimeException("the user already exist");
        if(!userRegister.getPassword().equals(userRegister.getConfirmpassword())) throw  new RuntimeException("please comfirme your password");
        AppUser appUser = new AppUser();
        mailService.sendCodeByEmail(userRegister.getUsername(),_code);
        Mail mail = new Mail();
        mail.setUsername(userRegister.getUsername());
        mail.setCode(_code);
        mailRepository.save(mail);
        appUser.setUsername(userRegister.getUsername());
        appUser.setPassword(passwordEncoder.encode(userRegister.getPassword()));
        appUser.setActive(0);
        AppRole appRole = appRoleRepository.getByRole("User");
        ArrayList<AppRole> roles = new ArrayList<AppRole>();
        roles.add(appRole);
        appUser.setAppRoles(roles);
        appUserRepository.save(appUser);
        return appUser;
    }

    @Override
    public AppRole addNewRole(AppRole appRole) {

        return appRoleRepository.save(appRole);
    }
    @Override
    public void addRoleToUser(String username, String roleName) {
        AppUser appUser=appUserRepository.findByUsername(username);
        AppRole appRole=appRoleRepository.getByRole(roleName);
        appUser.getAppRoles().add(appRole);
    }
    @Override
    public AppUser loadUserByUsername(String username) {
        return appUserRepository.findByUsername(username);
    }
    @Override
    public List<AppUser> listUsers() {
        return appUserRepository.findAll();
    }
}

