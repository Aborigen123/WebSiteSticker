package web.entity;

import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="history_sell")
@NoArgsConstructor
@Getter @Setter
@AllArgsConstructor
public class HistorySell extends  BaseEntity {

private String name;
	
	@Column(columnDefinition = "DECIMAL(7,2)")
	private BigDecimal price;
	
	
	
	@Column(name = "data_add_to_activity", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Date date;
	

	@Column(name = "sticker_image")
	private String stickerImage;
	
	@Column(name = "user_buy")
	private String userBuy;
	
	
	@OneToOne(fetch = FetchType.LAZY, cascade = {
			CascadeType.DETACH, 
			CascadeType.MERGE, 
			CascadeType.PERSIST, 
			CascadeType.REFRESH
	})
	
@JoinColumn(name = "sticker_id")
private Sticker sticker;

	@OneToOne(fetch = FetchType.LAZY, cascade = {
			CascadeType.DETACH, 
			CascadeType.MERGE, 
			CascadeType.PERSIST, 
			CascadeType.REFRESH
	})
	
@JoinColumn(name = "action_order_id")
private ActivityOrder activityOrder;
}
