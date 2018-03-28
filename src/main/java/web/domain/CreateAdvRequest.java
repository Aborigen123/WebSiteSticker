package web.domain;

import java.math.BigDecimal;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import web.entity.UserEntity;
import web.entity.enumeration.AboutSticker;
import web.entity.enumeration.StickerType;


@NoArgsConstructor
@Getter @Setter
public class CreateAdvRequest {
	private String name;
	private BigDecimal price;
	private StickerType stickerType;
	private AboutSticker aboutSticker;
	private UserEntity entity;
	private MultipartFile stickerImage;
}
