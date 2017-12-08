package facture;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Facture {

    private Client destinataire;
    private Date emission;
    private int numero;

    private List<LigneFacture> lignes = new ArrayList<>();
    //   private List<Facture> factures = new ArrayList<>();

    public Facture(Client d, Date e, int n) {
        destinataire = d;
        emission = e;
        numero = n;
    }

    /**
     * Get the value of numero
     *
     * @return the value of numero
     */
    public int getNumero() {
        return numero;
    }

    /**
     * Get the value of emission
     *
     * @return the value of emission
     */
    public Date getEmission() {
        return emission;
    }

    /**
     * Get the value of destinataire
     *
     * @return the value of destinataire
     */
    public Client getDestinataire() {
        return destinataire;
    }

    public void ajouteLigne(Article a, int nombre, float remise) {
        LigneFacture l = new LigneFacture(nombre, this, a, remise);
        lignes.add(l);
    }

    public float montantTTC(float tauxTVA) {
        float result = 0;
        for (int i = 0; i < lignes.size(); i++) {
            result += (lignes.get(i).montantLigne() * (1 + tauxTVA));
        }
        return result;
    }

    public void print(PrintStream out, float tva) {
        for (int i = 0; i < this.lignes.size(); i++) {
            out.println(lignes.toString() + tva);
        }
    }

}
