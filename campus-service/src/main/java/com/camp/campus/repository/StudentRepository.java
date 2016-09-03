package com.camp.campus.repository;

import com.camp.campus.model.Student;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface StudentRepository extends PagingAndSortingRepository<Student, Long>, JpaSpecificationExecutor {

}
