package FFSSM;
import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Embauche {

    private final LocalDate debut;

    private LocalDate fin;

    public Embauche(LocalDate debut, DiplomeDeMoniteur employe, Club employeur) {
        this.debut = debut;
    }

    public void terminer(LocalDate fin) {
        this.fin = fin;
    }

    public boolean estTerminee() {
        return fin != null;
    }

    public Club employeur() {
        return null;
    }


    
}
