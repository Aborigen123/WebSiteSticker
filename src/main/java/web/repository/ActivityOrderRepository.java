package web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import web.entity.ActivityOrder;
@Repository
public interface ActivityOrderRepository extends JpaRepository<ActivityOrder, Integer> {

}
