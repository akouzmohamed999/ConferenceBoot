package com.conference;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.conference.entities.User;
import com.conference.repos.UserRepository;

@SpringBootApplication
public class ConferenceBootApplication {

	public static void main(String[] args) {
		ApplicationContext ctx =SpringApplication.run(ConferenceBootApplication.class, args);
		/*UserRepository userrepo = ctx.getBean(UserRepository.class);
		User user = new User();
		PasswordEncoder enc = new BCryptPasswordEncoder();
		user.setEmail("moha@gmail.com");
		user.setPassword(enc.encode("moha"));
		userrepo.save(user);*/
	}
}
