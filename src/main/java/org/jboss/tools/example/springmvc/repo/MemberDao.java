package org.jboss.tools.example.springmvc.repo;

import java.util.List;

import org.jboss.tools.example.springmvc.domain.AppUser;
import org.jboss.tools.example.springmvc.domain.Member;

public interface MemberDao
{
    public Member findById(Long id);

    public Member findByEmail(String email);

    public List<Member> findAllOrderedByName();

    public void register(Member member);
    
    public Boolean isRegistered(String username, String password);
    
    public void register(AppUser user);
    
    public List<AppUser> findAll();
    
}
