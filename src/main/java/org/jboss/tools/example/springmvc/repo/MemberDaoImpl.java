package org.jboss.tools.example.springmvc.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.jboss.tools.example.springmvc.domain.AppUser;
import org.jboss.tools.example.springmvc.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class MemberDaoImpl implements MemberDao
{
    @Autowired
    private EntityManager em;

    public Member findById(Long id)
    {
        return em.find(Member.class, id);
    }

    public Member findByEmail(String email)
    {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Member> criteria = builder.createQuery(Member.class);
        Root<Member> member = criteria.from(Member.class);

        /*
         * Swap criteria statements if you would like to try out type-safe criteria queries, a new
         * feature in JPA 2.0 criteria.select(member).orderBy(cb.asc(member.get(Member_.name)));
         */

        criteria.select(member).where(builder.equal(member.get("email"), email));
        return em.createQuery(criteria).getSingleResult();
    }

    public List<Member> findAllOrderedByName()
    {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Member> criteria = cb.createQuery(Member.class);
        Root<Member> member = criteria.from(Member.class);

        /*
         * Swap criteria statements if you would like to try out type-safe criteria queries, a new
         * feature in JPA 2.0 criteria.select(member).orderBy(cb.asc(member.get(Member_.name)));
         */

        criteria.select(member).orderBy(cb.asc(member.get("name")));
        return em.createQuery(criteria).getResultList();
    }

    public void register(Member member)
    {
        em.persist(member);
        return;
    }

	@Override
	public Boolean isRegistered(String username, String password) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<AppUser> criteria = builder.createQuery(AppUser.class);
        Root<AppUser> member = criteria.from(AppUser.class);

        /*
         * Swap criteria statements if you would like to try out type-safe criteria queries, a new
         * feature in JPA 2.0 criteria.select(member).orderBy(cb.asc(member.get(Member_.name)));
         */

        criteria.select(member).where(builder.equal(member.get("username"), username));
        AppUser user= em.createQuery(criteria).getSingleResult();
        if (user==null) return false;
        return user.getPassword().equals(password);

	}

	@Override
	public void register(AppUser user) {
		em.persist(user);
		return;
		
	}

	@Override
	public List<AppUser> findAll() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<AppUser> criteria = cb.createQuery(AppUser.class);
        Root<AppUser> user = criteria.from(AppUser.class);

        /*
         * Swap criteria statements if you would like to try out type-safe criteria queries, a new
         * feature in JPA 2.0 criteria.select(member).orderBy(cb.asc(member.get(Member_.name)));
         */

        criteria.select(user).orderBy(cb.asc(user.get("username")));
        return em.createQuery(criteria).getResultList();
	}
}
