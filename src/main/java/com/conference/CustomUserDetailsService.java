package com.conference;



import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.conference.entities.Role;
import com.conference.repos.UserRepository;

@Service
@Qualifier("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService{
	
	
	@Autowired
	UserRepository userRepository;
	
	//Recupération de l'user
	@Transactional(readOnly=true)
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		com.conference.entities.User user = userRepository.findByEmail(email);
		List<GrantedAuthority> authorities = buildUserAuthority(user.getRoles());
		return buildUserForAuthentication(user, authorities);
	}
	
		//Création de USER_Details apartir de l'user qu'on a dans la BD
	  private User buildUserForAuthentication(com.conference.entities.User user,List<GrantedAuthority> authorities) {
        return new User(user.getEmail(), user.getPassword(), authorities);
    }

	  //Recupération des Roles de l'utilisateur
    private List<GrantedAuthority> buildUserAuthority(Collection<Role> userRoles) {

        Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();

        // Build user's authorities
        for (Role userRole : userRoles) {
            setAuths.add(new SimpleGrantedAuthority(userRole.getRole()));
        }

        return new ArrayList<GrantedAuthority>(setAuths);
    }
	
}
