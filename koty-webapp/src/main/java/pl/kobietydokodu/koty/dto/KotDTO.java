package pl.kobietydokodu.koty.dto;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

public class KotDTO {

	@NotBlank
	private String imie;

	@NotBlank
	@Pattern(regexp="[0-3]?[0-9]\\.[0-1]?[0-9]\\.[1-2][0-9]{3}")
	private String dataUrodzenia;
	
	@NotNull
	private Float waga;
	
	@NotBlank
	private String imieOpiekuna;

	public String getImie() {
		return imie;
	}

	public void setImie(String imie) {
		this.imie = imie;
	}

	public String getDataUrodzenia() {
		return dataUrodzenia;
	}

	public void setDataUrodzenia(String dataUrodzenia) {
		this.dataUrodzenia = dataUrodzenia;
	}

	public Float getWaga() {
		return waga;
	}

	public void setWaga(Float waga) {
		this.waga = waga;
	}

	public String getImieOpiekuna() {
		return imieOpiekuna;
	}

	public void setImieOpiekuna(String imieOpiekuna) {
		this.imieOpiekuna = imieOpiekuna;
	}

}
