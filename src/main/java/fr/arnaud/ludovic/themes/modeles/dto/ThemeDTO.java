package fr.arnaud.ludovic.themes.modeles.dto;

public class ThemeDTO {
	
	private String nom;
	private String couleur;
	private String description;
	private String descriptionDetaillee;
	private Integer id;
	
	public ThemeDTO(Integer id) {
		super();
		this.id = id;
	}

	public ThemeDTO(String nom, String couleur, String description, String descriptionDetaillee) {
		super();
		this.nom = nom;
		this.couleur = couleur;
		this.description = description;
		this.descriptionDetaillee = descriptionDetaillee;
	}

	public ThemeDTO(String nom, String couleur, String description, String descriptionDetaillee, Integer id) {
		super();
		this.nom = nom;
		this.couleur = couleur;
		this.description = description;
		this.descriptionDetaillee = descriptionDetaillee;
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescriptionDetaillee() {
		return descriptionDetaillee;
	}

	public void setDescriptionDetaillee(String descriptionDetaillee) {
		this.descriptionDetaillee = descriptionDetaillee;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "ThemeDTO [nom=" + nom + ", couleur=" + couleur + ", description=" + description
				+ ", descriptionDetaillee=" + descriptionDetaillee + "]";
	}

}
