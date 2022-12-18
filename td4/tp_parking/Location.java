package td4.tp_parking;

import java.time.LocalDate;
import java.util.Date;

public class Location {

    //Attributs:
    private Client client;
    private Voiture vehicule;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private double prixTotal;
    private double montantAvance;

    public Location(Client client, Voiture vehicule, LocalDate dateDebut, LocalDate dateFin, double prixTotal, double montantAvance) {
        this.client = client;
        this.vehicule = vehicule;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.prixTotal = prixTotal;
        this.montantAvance = montantAvance;
    }

    public Location() {
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Voiture getVehicule() {
        return vehicule;
    }

    public void setVehicule(Voiture vehicule) {
        this.vehicule = vehicule;
    }

    public LocalDate getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    public double getPrixTotal() {
        return prixTotal;
    }

    public void setPrixTotal(double prixTotal) {
        this.prixTotal = prixTotal;
    }

    public double getMontantAvance() {
        return montantAvance;
    }

    public void setMontantAvance(double montantAvance) {
        this.montantAvance = montantAvance;
    }

    @Override
    public String toString() {
        return "Location{" +
                "client=" + client +
                ", vehicule=" + vehicule +
                ", dateDebut=" + dateDebut +
                ", dateFin=" + dateFin +
                ", prixTotal=" + prixTotal +
                ", montantAvance=" + montantAvance +
                '}';
    }
}
