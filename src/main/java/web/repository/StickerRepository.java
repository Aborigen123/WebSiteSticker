package web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import web.entity.Sticker;

@Repository
public interface StickerRepository extends JpaRepository<Sticker, Integer>{

}
