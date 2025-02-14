package eus.bim.dam.Domain;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Comic extends BaseEntity{

	@Column(name = "title")
	private String title;

	@Column(name = "author")
	private String author;

	@Column(name = "releaseDate")
	private LocalDate releaseDate;

	@ManyToOne
	@JoinColumn(name = "tienda_id")
	private Tienda tienda;

	public Comic(String title, String author, LocalDate releaseDate) {
		super();
		this.title = title;
		this.author = author;
		this.releaseDate = releaseDate;
	}

	
	
}
