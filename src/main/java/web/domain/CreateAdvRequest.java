package web.domain;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import web.entity.UserEntity;
import web.entity.enumeration.AboutSticker;
import web.entity.enumeration.StickerType;
import web.validator.NotNullImage;


@NoArgsConstructor
@Getter @Setter
public class CreateAdvRequest {
	private String name;
	private BigDecimal price;
	private StickerType stickerType;
	private AboutSticker aboutSticker;
	private UserEntity entity;
	@NotNullImage
	private MultipartFile stickerImage;
}
