package web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import web.entity.ActivityOrder;
@Repository
public interface ActivityOrderRepository extends JpaRepository<ActivityOrder, Integer> {
//	@Query("SELECT u FROM UserEntity u WHERE u.email = :email")
//	ActivityOrder addCustomer(@Param("email") String email);
	
	@Query("SELECT a FROM ActivityOrder a WHERE a.userCustomer = :userCustomer")
	ActivityOrder selectActivetyOrderByParticularUser(@Param("userCustomer") String userCustomer);
}
