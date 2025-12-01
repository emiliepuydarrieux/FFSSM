import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import FFSSM.DiplomeDeMoniteur;
import FFSSM.Embauche;

import java.lang.reflect.Method;
import java.util.Arrays;
class TestDiplomeDeMoniteur {

    @Test
    public void employeurActuel_isNull_whenNoEmbauche() {
        DiplomeDeMoniteur d = new DiplomeDeMoniteur(null, 0);
        assertNull(d.employeurActuel(), "employeurActuel doit être null si aucune embauche");
    }

    @Test
    public void emplois_isUnmodifiable_andInitiallyEmpty() {
        DiplomeDeMoniteur d = new DiplomeDeMoniteur(null, 0);
        List<Embauche> l = d.emplois();
        assertNotNull(l, "emplois() ne doit pas retourner null");
        assertEquals(0, l.size(), "liste d'emplois doit être vide initialement");
        assertThrows(UnsupportedOperationException.class, () -> l.add(null),
            "la liste retournée par emplois() doit être non modifiable");
    }

    @Test
    public void nouvelleEmbauche_addsAnEntry() {
        DiplomeDeMoniteur d = new DiplomeDeMoniteur(null, 0);
        LocalDate now = LocalDate.now();
        // on passe null comme employeur — l'implémentation attend souvent un Club, mais
        // le but ici est de vérifier que la liste d'emplois s'incrémente
        d.nouvelleEmbauche(null, now);
        List<Embauche> l = d.emplois();
        assertEquals(1, l.size(), "nouvelleEmbauche doit ajouter une Embauche dans emplois()");
    }

@Test
public void embauche_hasExpectedAccessorMethods() throws Exception {
}
    @Test
    public void embauche_hasExpectedAccessorMethods() throws Exception {
        Class<?> c = Class.forName("FFSSM.Embauche");
        String[] expected = { "employeur", "estTerminee", "dateDebut" };
        Method[] methods = c.getDeclaredMethods();
        for (String name : expected) {
            boolean found = Arrays.stream(methods).anyMatch(m -> m.getName().equals(name));
            assertTrue(found, "Méthode attendue non trouvée dans Embauche: " + name);
        }
    }

    @Test
    public void domainClassesAreLoadable() throws Exception {
        String[] classes = { "Plongeur", "Moniteur", "Club", "Embauche", "DiplomeDeMoniteur" };
        for (String cn : classes) {
            try {
                Class.forName("FFSSM." + cn);
            } catch (ClassNotFoundException e) {
                fail("Classe non trouvée: FFSSM." + cn);
            }
        }
    }
    

    
}
