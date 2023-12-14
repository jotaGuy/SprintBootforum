package com.perscholas.caseStudy.security;

import com.perscholas.caseStudy.enity.Users;
import lombok.extern.slf4j.Slf4j;
import com.perscholas.caseStudy.database.dao.UserDAO;
import com.perscholas.caseStudy.database.dao.UserRoleDAO;
import com.perscholas.caseStudy.database.entity.User;
import com.perscholas.caseStudy.database.entity.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Slf4j
@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserDAO userDao;

    @Autowired
    private UserRoleDAO userRoleDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.debug("User login attempt with username: " + username);

        // lookup the incoming username in the database
        Users users = userDao.findByEmailIgnoreCase(username);

        // if we did not find the user in the database then we throw an exception because the user is not valid
        if (users == null) {
            throw new UsernameNotFoundException("Username '" + username + "' not found in database");
        }

        boolean accountIsEnabled = true;
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;

        List<UserRole> userRoles = userRoleDao.findByUserId(Math.toIntExact(users.getId()));

        // setup user roles
        Collection<? extends GrantedAuthority> springRoles = buildGrantAuthorities(userRoles);


        return new org.springframework.security.core.userdetails.User(users.getEmail(), users.getPassword(), accountIsEnabled,
                accountNonExpired, credentialsNonExpired, accountNonLocked, springRoles);
    }

    public static Collection<? extends GrantedAuthority> buildGrantAuthorities(List<UserRole> userRoles) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

        for (UserRole role : userRoles) {
            authorities.add(new SimpleGrantedAuthority(role.getRoleName().toString()));
        }

        // always add the user role
        authorities.add(new SimpleGrantedAuthority("USER"));

        return authorities;
    }

}