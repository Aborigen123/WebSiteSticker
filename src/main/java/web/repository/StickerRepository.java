package web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;



import web.entity.Sticker;
import web.entity.UserEntity;

@Repository
public interface StickerRepository extends JpaRepository<Sticker, Integer>,JpaSpecificationExecutor<Sticker>{

	/*@Query("SELECT s FROM Sticker s WHERE s.stickerType = :stickerType")
	List<Sticker> findStickerType(@Param("stickerType") String stickerType);*/
	
	@Query("SELECT s FROM Sticker s WHERE s.stickerType in :stickerType")
	List<Sticker> findStickerType(@Param("stickerType") List<String> stickerType);

	@Query("SELECT u FROM UserEntity u WHERE u.email = :email")
	UserEntity findUserByEmail(@Param("email") String email);
	
/*	@Query("SELECT u FROM UserEntity u left join u.Sticker  ON UserEntity.id = Sticker.user  WHERE u.block = true and  u.email = :email ")
	UserEntity findUserBlock(@Param("email") String email);*/

}
