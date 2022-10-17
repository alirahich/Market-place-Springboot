package com;


import com.Auth.Repository.AppRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class SpringBootMarketPlaceApplication{

	@Autowired
	AppRoleRepository appRoleRepository;
	public static void main(String[] args) {
		SpringApplication.run(SpringBootMarketPlaceApplication.class, args);
	}

	@Bean
	public PasswordEncoder passwordEncoder(){
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
	}

	/*@Bean
     CommandLineRunner start(AccountService accountService) {
		return args -> {
			AppRole admin = new AppRole();
			admin.setRole("Admin");
			AppRole user = new AppRole();
			user.setRole("User");
			appRoleRepository.save(admin);
			appRoleRepository.save(user);

			AppUser user1 = new AppUser();
			user1.setUsername("user1@gmail.com");
			user1.setPassword("123456789");
			user1.getAppRoles().add(user);
			accountService.addNewUser(user1);
			AppUser user2 = new AppUser();
			user2.setUsername("user2@gmail.com");
			user2.setPassword("123456789");
			user2.getAppRoles().add(user);
			accountService.addNewUser(user2);
		AppUser admin1 = new AppUser();
		admin1.setUsername("admin@gmail.com");
		admin1.setPassword("123456789");
		admin1.getAppRoles().add(admin);
		accountService.addNewUser(admin1);

		};
	}*/
}
