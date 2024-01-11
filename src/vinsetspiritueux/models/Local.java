package vinsetspiritueux.models;

/**
 * Modèle qui représente un local d'entreposage dans lequel on peut placer des armoires à vin.
 *
 * @author <a href="mailto:paul.friedli@edufr.ch">Paul Friedli</a>
 * @since 08.12.2023
 * @version 1.1.0
 */
public class Local {

    /**
     * Les armoires de ce local.
     */
    // VOTRE CODE ICI...

    /**
     * Le nom de ce local non modifiable.
     */
    // VOTRE CODE ICI...

    /**
     * Le constructeur de la classe Local. Toujours initialiser TOUS les attributs ! Lors de la création d'un nouveau
     * local, il n'y a encore aucune armoire dans la liste.
     *
     * @param nom le nom de ce nouveau local
     */
    public Local( String nom ) {
        // VOTRE CODE ICI...
    }

    /**
     * Ajoute une armoire à la liste des armoires de ce local. Le succès est garanti : cette méthode n'échoue jamais
     * dans sa tâche ! Pour parvenir à toujours être en mesure de rajouter une armoire dans la liste d'armoires de ce
     * local, cette méthode va aggrandir le tableau en conséquence.
     *
     * @param armoire l'armoire à rajouter
     */
    public void ajouterArmoire( Armoire armoire ) {
        // VOTRE CODE ICI...
    }

    /**
     * Supprime une armoire de la liste des armoires de ce local. Cette méthode ne laissera pas traîner une position
     * inoccupée dans la liste des armoires du local, sa taille sera donc réadaptée.
     *
     * @param armoire l'armoire à supprimer de la liste des armoires de ce local
     * @return vrai si et seulement si cette armoire était présente dans la liste des armoires de ce local
     */
    public boolean enleverArmoire( Armoire armoire ) {
        // VOTRE CODE ICI...
    }

    /**
     * Calcule la valeur totale des bouteilles contenues dans ce local.
     *
     * @return la valeur totale des bouteilles contenues dans ce local
     */
    public double valeurTotaleStock() {
        // VOTRE CODE ICI...
    }

    /**
     * Calcule diverses statistiques sur ce local et les retourne sous forme d'un bean Statistique. Parmi ces
     * information retournées on trouve la bouteille la plus chère dans ce local, la bouteille la moins chère dans ce
     * local, le nombre de bouteilles dans ce local et le prix moyen des bouteilles de ce local.
     *
     * @return un objet Statistique transportant les informations précitées
     */
    public Statistique calculerStatistiques() {
        // VOTRE CODE ICI...
    }

    /**
     * Getter du nom de ce local.
     *
     * @return le nom de ce local
     */
    public String getNom() {
        // VOTRE CODE ICI...
    }

    /**
     * Getter des armoires de ce local.
     *
     * @return les armoires de ce local
     */
    public Armoire[] getArmoires() {
        // VOTRE CODE ICI...
    }

}
