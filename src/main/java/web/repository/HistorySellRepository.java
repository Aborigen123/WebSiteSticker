package web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import web.entity.HistorySell;

@Repository
public interface HistorySellRepository extends JpaRepository<HistorySell, Integer> {

}
