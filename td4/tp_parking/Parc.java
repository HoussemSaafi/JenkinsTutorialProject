package td4.tp_parking;

import java.util.ArrayList;

public class Parc {

    //Attributes:

    private ArrayList<Voiture> vehicules;


    //Methodes:


    public Parc(ArrayList<Voiture> vehicules) {
        this.vehicules = vehicules;
    }

    public Parc() {
    }

    public ArrayList<Voiture> getVehicules() {
        return vehicules;
    }

    public void setVehicules(ArrayList<Voiture> vehicules) {
        this.vehicules = vehicules;
    }

    public void afficherVoitures(){
        for(int i=0 ; i < vehicules.size(); i++){
            System.out.println(vehicules.get(i));
        }
    }

    public void ajouterVehicule(Voiture v){
        vehicules.add(v);
    }

    public void supprimerVehicule(double immNumber) {
            for(int i = 0 ; i< vehicules.size(); i++){
                if(vehicules.get(i).getNumImmatriculation()==immNumber){
                    vehicules.remove(vehicules.get(i));
                }
            }
    }

    public void changerEtatVehicule(EtatCourant newState, double immNumber) {
        for (int i = 0; i < vehicules.size(); i++) {
            if (vehicules.get(i).getNumImmatriculation() == immNumber) {
                vehicules.get(i).setEtatCourantVoiture(newState);
            }
        }
    }

}
