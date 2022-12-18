package td4.tp_parking;

public class Voiture {

    //Attributes:
    private double numImmatriculation;
    private String constructeur;
    private String marqueCommerciale;
    private EtatCourant etatCourantVoiture;

    //Methods:


    public Voiture(double numImmatriculation, String constructeur, String marqueCommerciale, EtatCourant etatCourantVoiture) {
        this.numImmatriculation = numImmatriculation;
        this.constructeur = constructeur;
        this.marqueCommerciale = marqueCommerciale;
        this.etatCourantVoiture = etatCourantVoiture;
    }

    public Voiture() {
    }

    public double getNumImmatriculation() {
        return numImmatriculation;
    }

    public void setNumImmatriculation(double numImmatriculation) {
        this.numImmatriculation = numImmatriculation;
    }

    public String getConstructeur() {
        return constructeur;
    }

    public void setConstructeur(String constructeur) {
        this.constructeur = constructeur;
    }

    public String getMarqueCommerciale() {
        return marqueCommerciale;
    }

    public void setMarqueCommerciale(String marqueCommerciale) {
        this.marqueCommerciale = marqueCommerciale;
    }

    public EtatCourant getEtatCourantVoiture() {
        return etatCourantVoiture;
    }

    public void setEtatCourantVoiture(EtatCourant etatCourantVoiture) {
        this.etatCourantVoiture = etatCourantVoiture;
    }

    @Override
    public String toString() {
        return "Voiture{" +
                "numImmatriculation=" + numImmatriculation +
                ", constructeur='" + constructeur + '\'' +
                ", marqueCommerciale='" + marqueCommerciale + '\'' +
                ", etatCourantVoiture=" + etatCourantVoiture +
                '}';
    }
}
