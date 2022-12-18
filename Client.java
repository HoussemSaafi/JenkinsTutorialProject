package td4.tp_parking;

public class Client {

    //Attributes:
    double numClient;
    String nom;
    String prenom;
    String adresse;

    //Methodes:

    public Client(double numClient, String nom, String prenom, String adresse) {
        this.numClient = numClient;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
    }

    public Client() {
    }

    public double getNumClient() {
        return numClient;
    }

    public void setNumClient(double numClient) {
        this.numClient = numClient;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    @Override
    public String toString() {
        return "Client{" +
                "numClient=" + numClient +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", adresse='" + adresse + '\'' +
                '}';
    }
}
