package td4.tp_parking;

import java.time.LocalDate;
import java.util.ArrayList;
import td4.tp_parking.*;

public class Main {

    public static void main(String[] args){
        /*
        Gestion du Parc de l’Agence :
            1. Nouvelle acquisition (Ajout d’un véhicule)
            2. Modification de l’Etat d’un Véhicule
            3. Suppression d’un Véhicule
            4. Consultation Parc (tous les véhicules)
            5. Liste des véhicules loués
            6. Liste des véhicules en cours de réparation
            7. Liste des véhicules disponibles

         */
        //Gestion du parc de l'agence:
        System.out.println("Gestion du parc de l'agence");
        System.out.println("Ajout de 6 vehicules a notre parc");
        Voiture voiture1 = new Voiture(1234,"BMW Constructor","BMW 5 Series",EtatCourant.Disponible);
        Voiture voiture2 = new Voiture(5678,"BMW Constuctor","BMW X5",EtatCourant.Disponible);
        Voiture voiture3 = new Voiture(9101,"BMW Constuctor","BMW X5",EtatCourant.Disponible);
        Voiture voiture4 = new Voiture(1112,"BMW Constuctor","BMW X5",EtatCourant.Loué);
        Voiture voiture5 = new Voiture(1314,"BMW Constuctor","BMW X5",EtatCourant.EnCoursDeReparation);
        Voiture voiture6 = new Voiture(1111,"BMW Constructor","BMW 5 Series",EtatCourant.Disponible);
        Parc parc = new Parc(new ArrayList<Voiture>());
        parc.ajouterVehicule(voiture1);
        parc.ajouterVehicule(voiture2);
        parc.ajouterVehicule(voiture3);
        parc.ajouterVehicule(voiture4);
        parc.ajouterVehicule(voiture5);
        parc.ajouterVehicule(voiture6);
        System.out.println("cars available in our parc right now are:");
        parc.afficherVoitures();

        //modification voiture 1
        System.out.println("Modification de l etat de la voiture 1");
        parc.changerEtatVehicule(EtatCourant.Loué,1234);
        System.out.println("L etat courant de la voiture 1 est : " + voiture1.getEtatCourantVoiture());

        //Suppression de la véhicule v2:
        System.out.println("3. Suppression du voiture 2 faite");
        parc.supprimerVehicule(5678);

        //Consultation du parc:
        System.out.println("4. Consultation Parc (tous les véhicules)");
        parc.afficherVoitures();

        //liste des vehicules loué:
        System.out.println("5. Liste des vehicules loués");
        ArrayList<Voiture> vehicules = parc.getVehicules();
        for (int i = 0; i<vehicules.size();i++){
            if(vehicules.get(i).getEtatCourantVoiture()==EtatCourant.Loué)
                System.out.println(vehicules.get(i));
        }

        //Liste des vehicules en cours de reparation:
        System.out.println("6. Liste des vehicules en cours de reparation");
        for (int i = 0; i<vehicules.size();i++){
            if(vehicules.get(i).getEtatCourantVoiture()==EtatCourant.EnCoursDeReparation)
            System.out.println(vehicules.get(i));
        }

        //Liste des vehicules disponibles:
        System.out.println("6. Liste des vehicules disponibles");
        for (int i = 0; i<vehicules.size();i++){
            if(vehicules.get(i).getEtatCourantVoiture()==EtatCourant.Disponible)
                 System.out.println(vehicules.get(i));
        }

        /*
        Gestion Locations :
                1. Nouvelle Location (Ajout d’une location)
                2. Fin de Location (Suppression)
                3. Consultation des locations en cours
                4. Consultation des Véhicules Loués par un client
         */

        //Nouvelle Location (Ajout d'une location)
        //Creating client:
        Client client = new Client(1222,"Ben Ahmed","Ahmed","31 Rue Ahmed");
        Client client2 = new Client(1999,"Ben Foulen", "Foulen","14 Rue Ben Arous");

        LocalDate date1 = LocalDate.of(2022, 12, 8);
        LocalDate date2 = LocalDate.of(2022, 12, 11);

        Location location = new Location(client, voiture3, date1, date2, 1000.0, 300.0);
        Location location2 = new Location(client2,voiture6,date1, date2, 1000.0, 300.0);
        LocHistorique locationsHistorique = new LocHistorique();
        locationsHistorique.setLocationsHistorique(new ArrayList<LocationArchiver>());
        LocEnCours locationsEnCours = new LocEnCours(new ArrayList<Location>(),locationsHistorique);
        locationsEnCours.ajouterLocation(location);
        locationsEnCours.ajouterLocation(location2);
        System.out.println("Afficher les locations en cours");
        locationsEnCours.afficherLocations();

        //Fin de location:
        locationsEnCours.supprimerLocation(client.getNumClient(), voiture3.getNumImmatriculation(),LocalDate.of(2022, 12, 16),true,locationsHistorique);

        //consultation des locations en cours:
        System.out.println("Les locations en cours sont: ");
        locationsEnCours.afficherLocations();

        //Consultation des vehicules loués par un client:
        System.out.println("Les locations faite par le client ayant le Num 1222 sont: ");
        locationsEnCours.afficherLocationsParClient(1222);

        /*
        Statistiques :
                1. Nombre de locations pour une période déterminée
                2. Total des revenus pour une période déterminée
                3. Liste des clients à risque (Retard / mauvais état de véhicules rendus)
         */
        //Nombre de locations pour une periode
        int nbLocations = locationsEnCours.nombreLocationPeriode(LocalDate.of(2022, 11, 14), LocalDate.of(2022, 12, 20));
        System.out.println("Nombre de locations pour la periode entre 2022-11-14 et 2022-12-20 est : "+nbLocations );

        //Total revenues pour une periode
        double totalRev = locationsEnCours.totalRevenues(LocalDate.of(2022, 11, 14), LocalDate.of(2022, 12, 20));
        System.out.println("Revenus pour la periode entre 2022-11-14 et 2022-12-20 est : "+totalRev );

        //Liste des clients à risque (Retard / mauvais état de véhicules rendus)
        System.out.println("Liste des clients a risque");
        System.out.println(locationsEnCours.listesDesClientsRisques());
    }
}
