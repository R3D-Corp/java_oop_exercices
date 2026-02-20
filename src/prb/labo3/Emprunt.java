package prb.labo3;

public class Emprunt {
    public static double calculerTauxMensuel(double tauxAnnuel) {
        double tauxMensuel = Math.pow((1 + tauxAnnuel), (1.0 / 12)) - 1;
        tauxMensuel = Math.round(tauxMensuel * 100000); 
        tauxMensuel = tauxMensuel / 100000; 
        return tauxMensuel;
    }

    public static double calculerMensualite(double tauxMensuel, double capital, double nombreMensualite) {
        double mensualite;
        mensualite = tauxMensuel / (1 - Math.pow(1 + tauxMensuel, -nombreMensualite));
        mensualite = mensualite * capital;

        mensualite = Math.round(mensualite * 100000);
        mensualite = mensualite / 100000;

        return mensualite;
    }
}
