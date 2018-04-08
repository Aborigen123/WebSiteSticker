package web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import web.entity.Sticker;

@Repository
public interface StickerRepository extends JpaRepository<Sticker, Integer>,JpaSpecificationExecutor<Sticker>{

	@Query("SELECT s FROM Sticker s WHERE s.stickerType = :stickerType")
	List<Sticker> findStickerType(@Param("stickerType") String stickerType);


}
