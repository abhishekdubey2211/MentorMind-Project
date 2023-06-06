package com.CustomerManagement.repos;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.CustomerManagement.entity.*;


@Repository
public interface CustomerRepos extends JpaRepository<Customer,Long>
{
	

}
