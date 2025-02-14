package eus.bim.dam.Domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Tienda extends BaseEntity {

	@Column(name = "name")
	private String name;

	@Column(name = "dateOpened")
	private LocalDate dateOpened;

	@OneToMany(cascade=CascadeType.ALL) //Cambios en cascada.
	@JoinColumn( name = "tienda_id")
	List<Comic> comics = new ArrayList<>();

	public Tienda(String name, LocalDate dateOpened) {
		super();
		this.name = name;
		this.dateOpened = dateOpened;
	}

}
