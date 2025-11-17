package labo2;

import io.Console;

public class VenteVoiture {
    public static void main(String[] args) {
        final float T_TVA = 0.21f;
        final float T_REMISE = 0.03f;
        double VoitureHTVA, VoitureTVA, VoitureTVAC, Remise;
        
        VoitureHTVA = Console.lireDouble("Montant HTVA de la voiture ? ");
        VoitureTVA = Math.round(VoitureHTVA * T_TVA * 100);
        VoitureTVA = VoitureTVA / 100;
        VoitureTVAC = Math.round((VoitureHTVA + VoitureTVA) * 100);
        VoitureTVAC = VoitureTVAC / 100;
        Remise = Math.round((VoitureTVAC * T_REMISE) * 100);
        Remise = Remise / 100;
        System.out.println("Montant de la TVA : " + VoitureTVA + " EUR");
        System.out.println("Montant de la remise : " + Remise + " EUR");
        System.out.println("Montant final : " + (VoitureTVAC - Remise) + " EUR");
    }
}