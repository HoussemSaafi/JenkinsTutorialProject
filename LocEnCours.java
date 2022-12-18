package td4.tp_parking;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class LocEnCours {

    //Attributes:
    private ArrayList<Location> locations;
    private LocHistorique locationsHistorique;

    //Methodes:

    public LocEnCours(ArrayList<Location> locations) {
        this.locations = locations;
    }

    public LocEnCours(ArrayList<Location> locations, LocHistorique locationsHistorique) {
        this.locations = locations;
        this.locationsHistorique = locationsHistorique;
    }

    public LocEnCours(){
    }

    public ArrayList<Location> getLocations() {
        return locations;
    }

    public void setLocations(ArrayList<Location> locations) {
        this.locations = locations;
    }

    public void ajouterLocation(Location nouvelleLocation){
        //verification des contraintes
        if(nouvelleLocation.getVehicule().getEtatCourantVoiture()==EtatCourant.Disponible && nouvelleLocation.getMontantAvance()!=0){
            locations.add(nouvelleLocation);
            nouvelleLocation.getVehicule().setEtatCourantVoiture(EtatCourant.Loué);
        }
        else{
            System.out.println("Location Rules Violated - Location was not accepted nor added to the current locations list");
        }
    }

    public void afficherLocations(){
        for(int i=0;i<locations.size();i++){
            System.out.println(locations.get(i));
        }
    }
    public void supprimerLocation(double numClient, double numMatricule, LocalDate dateDeRemise, boolean carIsInGoodState, LocHistorique locationHistorique){
            for(int i=0 ; i < locations.size();i++){
                if(locations.get(i).getClient().getNumClient()==numClient && locations.get(i).getVehicule().getNumImmatriculation()==numMatricule){
                    if(dateDeRemise.compareTo(locations.get(i).getDateFin())>0){
                        System.out.println("Car returned after official returning date. Please take necessary actions!");
                        LocationArchiver locationArchiver = new LocationArchiver(locations.get(i),false,carIsInGoodState);
                        locationHistorique.getLocationsHistorique().add(locationArchiver);
                        if(!carIsInGoodState)
                            locations.get(i).getVehicule().setEtatCourantVoiture(EtatCourant.EnCoursDeReparation);
                        locations.remove(locations.get(i));
                    }
                    else{
                        if(!carIsInGoodState)
                            locations.get(i).getVehicule().setEtatCourantVoiture(EtatCourant.EnCoursDeReparation);
                        LocationArchiver locationArchiver = new LocationArchiver(locations.get(i),true,carIsInGoodState);
                        locationHistorique.getLocationsHistorique().add(locationArchiver);
                        locations.remove(locations.get(i));
                    }
                }
            }
    }

    public void afficherLocationsParClient(double numClient){
        for(int i=0 ; i<locations.size();i++){
            if(locations.get(i).getClient().getNumClient()==numClient){
                System.out.println(locations.get(i));
            }
        }
    }

    //statistiques
    public int nombreLocationPeriode(LocalDate debut, LocalDate fin){
        int nombre = 0;
        for (int i=0 ; i < locations.size();i++){
            if(locations.get(i).getDateDebut().compareTo(debut)>0 && locations.get(i).getDateFin().compareTo(fin)<0){
                nombre++;
            }
        }
        ArrayList<LocationArchiver> locationsHistoriqueArchive = this.locationsHistorique.getLocationsHistorique();
        for(int i=0;i<locationsHistoriqueArchive.size();i++){
            if(locationsHistoriqueArchive.get(i).getLocation().getDateDebut().compareTo(debut)>0 && locations.get(i).getDateFin().compareTo(fin)<0){
                nombre++;
            }
        }
        return nombre;
    }

    public double totalRevenues(LocalDate debut,LocalDate fin){
        double total =0;
        for (int i=0 ; i < locations.size();i++){
            if(locations.get(i).getDateDebut().compareTo(debut)>0 && locations.get(i).getDateFin().compareTo(fin)<0){
                total+=locations.get(i).getPrixTotal();
            }
        }
        ArrayList<LocationArchiver> locationsHistoriqueArchive = this.locationsHistorique.getLocationsHistorique();
        for(int i=0;i<locationsHistoriqueArchive.size();i++){
            if(locationsHistoriqueArchive.get(i).getLocation().getDateDebut().compareTo(debut)>0 && locations.get(i).getDateFin().compareTo(fin)<0){
                total+=locations.get(i).getPrixTotal();
            }
        }
        return total;
    }

    public ArrayList<Client> listesDesClientsRisques(){
        ArrayList<Client> clientsRisques = new ArrayList<>();
        ArrayList<LocationArchiver> locationsHistoriqueArchive = this.locationsHistorique.getLocationsHistorique();
        for(int i=0;i<locationsHistoriqueArchive.size();i++){
            if(locationsHistoriqueArchive.get(i).isCarIsInGoodState()==false || locationsHistoriqueArchive.get(i).isCarIsReturnedInTime()==false){
                clientsRisques.add(locationsHistoriqueArchive.get(i).getLocation().getClient());
            }
        }
        return clientsRisques;
    }

}
