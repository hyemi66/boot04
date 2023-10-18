package net.daum.dao;

import org.springframework.data.repository.CrudRepository;

import net.daum.vo.Profile;

public interface ProfileRepository extends CrudRepository<Profile, Integer> {
	
}
