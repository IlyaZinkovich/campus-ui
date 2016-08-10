package com.camp.campus.repository;

import com.camp.campus.model.Profile;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProfileRepository extends PagingAndSortingRepository<Profile, Long>, JpaSpecificationExecutor {

}
