package web.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import web.entity.enumeration.Country;
import web.entity.enumeration.Role;

@Entity
@NoArgsConstructor
@Getter @Setter
@Table(name = "user", indexes = @Index(columnList = "email"))
public class UserEntity extends BaseEntity {
	
	private String email;
	private String password;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	private int age;
	
	@Column(name = "image_path")
	private String imagePath;
	private Role role;
	 private Country country;
	@Column(name = "phone_number")
	private String phoneNumber;
	
	@Column(name = "block1")
	private Boolean block = false;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Sticker> cars = new ArrayList<>();

	public UserEntity(String email, String password, String firstName, String lastName, int age, String imagePath) {
		super();
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.imagePath = imagePath;
	}
	
	
}
