package web.entity;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import web.entity.enumeration.AboutSticker;
import web.entity.enumeration.StickerType;

@Entity
@Table(name = "sticker_safe", indexes = @Index(columnList = "name"))
@NoArgsConstructor
@Getter @Setter
public class StickerSafe extends BaseEntity {

	private String name;
	
	
	@Column(columnDefinition = "DECIMAL(7,2)")
	private BigDecimal price;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "sticker_type")
	private StickerType stickerType;
	
	
	@Enumerated(EnumType.STRING)
	@Column(name = "about_sticker")
	private AboutSticker aboutSticker;	
	
	@Column(name = "sticker_image")
	private String stickerImage;
	
/*	@ManyToOne(fetch = FetchType.LAZY, cascade = {
			CascadeType.DETACH, 
			CascadeType.MERGE, 
			CascadeType.PERSIST, 
			CascadeType.REFRESH
	})
	
	@JoinColumn(name = "user_id")
	private UserEntity user;*/
	

	@OneToOne(fetch = FetchType.LAZY, cascade = {
			CascadeType.DETACH, 
			CascadeType.MERGE, 
			CascadeType.PERSIST, 
			CascadeType.REFRESH
	})
	
@JoinColumn(name = "sticker_id")
private Sticker sticker;


}