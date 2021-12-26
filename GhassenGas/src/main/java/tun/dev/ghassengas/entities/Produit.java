package tun.dev.ghassengas.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Entity
public class Produit implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProduit;

    private String code;
    private String marque;
    private String modele;
    private String carecteristiques;
    private BigDecimal prixUnitaire;
    private Long quantite;

    @ManyToOne
    @JoinColumn(name = "categorieId")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Categorie categorie;

    @OneToMany(mappedBy = "produit")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<LigneCommande> lignesCommande;

    public Produit() {

    }

    public Produit(String code, String marque, String modele, String carecteristiques, BigDecimal prixUnitaire, Long quantite, Categorie categorie, List<LigneCommande> lignesCommande) {
        this.code = code;
        this.marque = marque;
        this.modele = modele;
        this.carecteristiques = carecteristiques;
        this.prixUnitaire = prixUnitaire;
        this.quantite = quantite;
        this.categorie = categorie;
        this.lignesCommande = lignesCommande;
    }

    public int getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(int idProduit) {
        this.idProduit = idProduit;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public String getCarecteristiques() {
        return carecteristiques;
    }

    public void setCarecteristiques(String carecteristiques) {
        this.carecteristiques = carecteristiques;
    }

    public BigDecimal getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(BigDecimal prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }

    public Long getQuantite() {
        return quantite;
    }

    public void setQuantite(Long quantite) {
        this.quantite = quantite;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public List<LigneCommande> getLignesCommande() {
        return lignesCommande;
    }

    public void setLignesCommande(List<LigneCommande> lignesCommande) {
        this.lignesCommande = lignesCommande;
    }
}
