package com.forsys.revmantra.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.forsys.revmantra.model.RmanUserResponsibilities;
import com.forsys.revmantra.model.RmanUsers;

public class RmanPrincipal implements UserDetails {

    private static final long serialVersionUID = 1L;

    private RmanUsers user;

    public RmanPrincipal(RmanUsers user) {
        this.user = user;
    }


    @Override
    public String getUsername() {
        return user.getUserName();
    }

    @Override
    public String getPassword() {
        return user.getUserPassword();
    }
    

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        final List<GrantedAuthority> authorities = new ArrayList<>();
       Set<RmanUserResponsibilities> responsilibities = user.getRmanUserResponsibilitiesSet();
      
       Set<RmanUserResponsibilities> filteredResps = responsilibities.stream().filter(p->"Y".equalsIgnoreCase(p.getEnabledFlag())).collect(Collectors.toCollection(LinkedHashSet::new));
       filteredResps.forEach(responsibility->{
   	   if(responsibility.getEnabledFlag().equals("Y")){
   		   SimpleGrantedAuthority auth=new SimpleGrantedAuthority("ROLE_"+responsibility.getRmanResponsibilities().getResponsibilityName());
          	   authorities.add(auth);
   	   }
   	   
      });
       
       /** for (RmanUserResponsibilities responsibility:responsilibities) {
        	SimpleGrantedAuthority auth=new SimpleGrantedAuthority("ROLE_"+responsibility.getRmanResponsibilities().getResponsibilityName());
        	authorities.add(auth);
        	
        }*/
        
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public RmanUsers getUser() {
        return user;
    }

}