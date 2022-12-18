package td4.tp_parking;

import java.util.ArrayList;

public class LocHistorique {

    public ArrayList<LocationArchiver> locationsHistorique;

    public LocHistorique(ArrayList<LocationArchiver> locationsHistorique) {
        this.locationsHistorique = locationsHistorique;
    }

    public LocHistorique() {
    }

    public ArrayList<LocationArchiver> getLocationsHistorique() {
        return locationsHistorique;
    }

    public void setLocationsHistorique(ArrayList<LocationArchiver> locationsHistorique) {
        this.locationsHistorique = locationsHistorique;
    }

    public void ajouterLocationHistorique(LocationArchiver locationArchiver){
        this.locationsHistorique.add(locationArchiver);
    }



}
