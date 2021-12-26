package tun.dev.ghassengas.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
public class LigneCommande implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idLigneCommande;

    private Long qte;
    private BigDecimal prixUnitairee;
    private BigDecimal prixTotal;
    private Long etat;

    @ManyToOne
    @JoinColumn(name = "commandeId")
    private Commande commande;

    @ManyToOne
    @JoinColumn(name = "produitId")
    private Produit produit;

    public LigneCommande() {
    }

    public LigneCommande(Long qte, BigDecimal prixUnitairee, BigDecimal prixTotal, Long etat, Commande commande, Produit produit) {
        this.qte = qte;
        this.prixUnitairee = prixUnitairee;
        this.prixTotal = prixTotal;
        this.etat = etat;
        this.commande = commande;
        this.produit = produit;
    }

    public int getIdLigneCommande() {
        return idLigneCommande;
    }

    public void setIdLigneCommande(int idLigneCommande) {
        this.idLigneCommande = idLigneCommande;
    }

    public Long getQte() {
        return qte;
    }

    public void setQte(Long qte) {
        this.qte = qte;
    }

    public BigDecimal getPrixUnitairee() {
        return prixUnitairee;
    }

    public void setPrixUnitairee(BigDecimal prixUnitairee) {
        this.prixUnitairee = prixUnitairee;
    }

    public BigDecimal getPrixTotal() {
        return prixTotal;
    }

    public void setPrixTotal(BigDecimal prixTotal) {
        this.prixTotal = prixTotal;
    }

    public Long getEtat() {
        return etat;
    }

    public void setEtat(Long etat) {
        this.etat = etat;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }
}
