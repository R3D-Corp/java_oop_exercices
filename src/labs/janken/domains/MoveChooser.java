package labs.janken.domains;

import labs.janken.domains.events.GameEventSubscriber;
// import labsutil.ToOverrideException;

/**
 * TODO: ajouter le rôle (exo 1)
 *
 * <p>Ce type délègue la sélection d'une option parmi une plage de valeurs,
 * généralement utilisée pour choisir un coup dans un jeu ou une action dans une application interactive.
 * L'implémentation concrète (par exemple, une interface console ou graphique) est responsable
 * de l'affichage du prompt et de la récupération du choix de l'utilisateur.</p>
 *
 * <p><strong>Contrat :</strong></p>
 * <ul>
 *   <li>Le choix retourné doit toujours être dans l'intervalle [minIncl, maxIncl].</li>
 *   <li>Le prompt ne doit pas être {@code null} et doit être affiché à l'utilisateur.</li>
 * </ul>
 */
public class MoveChooser extends GameEventSubscriber {

    /**
     * Demande à l'utilisateur de choisir une option parmi une plage de valeurs.
     * <p> Cette méthode est à implémenter par une sous-classes.</p>
     * 
     * @param prompt le message à afficher pour guider l'utilisateur (ne doit pas être {@code null}).
     * @param minIncl la valeur minimale incluse dans la plage de choix.
     * @param maxIncl la valeur maximale incluse dans la plage de choix.
     * @return le choix de l'utilisateur, un entier compris entre {@code minIncl} et {@code maxIncl}.
     */
    public int chooseBetween(String prompt, int minIncl, int maxIncl) {
        return 1;
    }
}

