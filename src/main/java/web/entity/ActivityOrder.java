package web.entity;

import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="activity_order")
@NoArgsConstructor
@Getter @Setter
@AllArgsConstructor
public class ActivityOrder extends BaseEntity {
	
	
	private String name;
	
	@Column(columnDefinition = "DECIMAL(7,2)")
	private BigDecimal price;
	
	
	
	@Column(name = "data_add_to_activity", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Date date;
	

	@JoinColumn(name = "sticker_image")
	private String stickerImage;
	
	
	
	@OneToOne(fetch = FetchType.LAZY, cascade = {
			CascadeType.DETACH, 
			CascadeType.MERGE, 
			CascadeType.PERSIST, 
			CascadeType.REFRESH
	})
	
@JoinColumn(name = "sticker_id")
private Sticker sticker;
	
	@OneToOne(mappedBy="sticker", fetch = FetchType.LAZY, cascade = {
			CascadeType.DETACH, 
			CascadeType.MERGE, 
			CascadeType.PERSIST, 
			CascadeType.REFRESH})
	private HistorySell historySell;
}
