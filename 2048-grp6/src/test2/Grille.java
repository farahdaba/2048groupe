/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;


public class Grille implements Parametres {

    private final HashSet<Case> grille;
    private int valeurMax = 0;
    private boolean deplacement;

    public Grille() {
        this.grille = new HashSet<>();
    }

    @Override
    public String toString() {
        int[][][] tableau = new int[STAGE][TAILLE][TAILLE];
        for (Case c : this.grille) {
            tableau[c.getZ()][c.getY()][c.getX()] = c.getValeur();
        }
        String result = "";
        for (int i = 0; i < TAILLE ; i++) {
            for (int j= 0 ; j < STAGE ; j++){
                result += Arrays.toString(tableau[j][i]);
            }
            result += "\n";
        }
        return result;
    }
    
    public String toHTML() {
        int[][][] tableau = new int[STAGE][TAILLE][TAILLE];
        for (Case c : this.grille) {
            tableau[c.getZ()][c.getY()][c.getX()] = c.getValeur();
        }
        String result = "<html>";
        for (int i = 0; i < tableau.length; i++) {
            result += Arrays.toString(tableau[i]) + "<br/>";
        }
        result += "</html>";
        return result;
    }

    public HashSet<Case> getGrille() {
        return grille;
    }

    public int getValeurMax() {
        return valeurMax;
    }

    public boolean partieFinie() {
        if (this.grille.size() < STAGE * TAILLE * TAILLE ) {
            return false;
        } else {
            for (Case c : this.grille) {
                for (int i = 1; i <= 3; i++) {
                    if (c.getVoisinDirect(i) != null) {
                        if (c.valeurEgale(c.getVoisinDirect(i))) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public boolean lanceurDeplacerCases(int direction) {
        Case[] extremites = this.getCasesExtremites(direction);
        deplacement = false; // pour v??rifier si on a boug?? au moins une case apr??s le d??placement, avant d'en rajouter une nouvelle
        for (int i = 0; i < TAILLE; i++) {
            switch (direction) {
                case HAUT:
                    this.deplacerCasesRecursif(extremites, i, direction, 0);
                    break;
                case BAS:
                    this.deplacerCasesRecursif(extremites, i, direction, 0);
                    break;
                case GAUCHE:
                    this.deplacerCasesRecursif(extremites, i, direction, 0);
                    break;
                case UP:
                    this.deplacerCasesRecursif(extremites, i, direction, 0);
                    break;
                case DOWN:
                    this.deplacerCasesRecursif(extremites, i, direction, 0);
                    break;
                default:
                    this.deplacerCasesRecursif(extremites, i, direction, 0);
                    break;
            }
        }
        return deplacement;
    }

    private void fusion(Case c) {
        c.setValeur(c.getValeur() * 2);
        if (this.valeurMax < c.getValeur()) {
            this.valeurMax = c.getValeur();
        }
        deplacement = true;
    }

    private void deplacerCasesRecursif(Case[] extremites, int rangee, int direction, int compteur) {
        if (extremites[rangee] != null) {
            if ((direction == HAUT && extremites[rangee].getY() != compteur)
                    || (direction == BAS && extremites[rangee].getY() != TAILLE - 1 - compteur)
                    || (direction == GAUCHE && extremites[rangee].getX() != compteur)
                    || (direction == DROITE && extremites[rangee].getX() != TAILLE - 1 - compteur)
                    || (direction == UP && extremites[rangee].getZ() != compteur)
                    || (direction == DOWN && extremites[rangee].getZ() != STAGE - 1 - compteur)) {
                this.grille.remove(extremites[rangee]);
                switch (direction) {
                    case HAUT:
                        extremites[rangee].setY(compteur);
                        break;
                    case BAS:
                        extremites[rangee].setY(TAILLE - 1 - compteur);
                        break;
                    case GAUCHE:
                        extremites[rangee].setX(compteur);
                        break;
                    case UP:
                        extremites[rangee].setZ(compteur);
                        break;
                    case DOWN:
                        extremites[rangee].setZ(STAGE - 1 - compteur);
                        break;
                    default:
                        extremites[rangee].setX(TAILLE - 1 - compteur);
                        break;
                }
                this.grille.add(extremites[rangee]);
                deplacement = true;
            }
            Case voisin = extremites[rangee].getVoisinDirect(-direction);
            if (voisin != null) {
                if (extremites[rangee].valeurEgale(voisin)) {
                    this.fusion(extremites[rangee]);
                    extremites[rangee] = voisin.getVoisinDirect(-direction);
                    this.grille.remove(voisin);
                    this.deplacerCasesRecursif(extremites, rangee, direction, compteur + 1);
                } else {
                    extremites[rangee] = voisin;
                    this.deplacerCasesRecursif(extremites, rangee, direction, compteur + 1);
                }
            }
        }
    }

    /*
    * Si direction = HAUT : retourne les 4 cases qui sont le plus en haut (une pour chaque colonne)
    * Si direction = DROITE : retourne les 4 cases qui sont le plus ?? droite (une pour chaque ligne)
    * Si direction = BAS : retourne les 4 cases qui sont le plus en bas (une pour chaque colonne)
    * Si direction = GAUCHE : retourne les 4 cases qui sont le plus ?? gauche (une pour chaque ligne)
    * Attention : le tableau retourn?? peut contenir des null si les lignes/colonnes sont vides
     */
    public Case[] getCasesExtremites(int direction) {
        Case[] result = new Case[TAILLE];
        for (Case c : this.grille) {
            switch (direction) {
                case HAUT:
                    if ((result[c.getX()] == null) || (result[c.getX()].getY() > c.getY()) || (result[c.getX()].getZ() > c.getZ())) { // si on n'avait pas encore de case pour cette rang??e ou si on a trouv?? un meilleur candidat
                        result[c.getX()] = c;
                    }
                    break;
                case BAS:
                    if ((result[c.getX()] == null) || (result[c.getX()].getY() < c.getY()) || (result[c.getX()].getZ() < c.getZ())) {
                        result[c.getX()] = c;
                    }
                    break;
                case GAUCHE:
                    if ((result[c.getY()] == null) || (result[c.getY()].getX() > c.getX()) || (result[c.getY()].getZ() > c.getZ())) {
                        result[c.getY()] = c;
                    }
                    break;
                case UP:
                    if((result[c.getZ()] == null) || (result[c.getZ()].getX() > c.getX()) || (result[c.getZ()].getY() > c.getY())){
                        result[c.getZ()] = c;
                    }
                    break;
                case DOWN:
                    if((result[c.getZ()] == null) || (result[c.getZ()].getX() < c.getX()) || (result[c.getZ()].getY() < c.getY())){
                        result[c.getZ()] = c;
                    }
                    break;
                default:
                    if ((result[c.getY()] == null) || (result[c.getY()].getX() < c.getX()) || (result[c.getY()].getZ() < c.getZ())) {
                        result[c.getY()] = c;
                    }
                    break;
            }
        }
        return result;
    }

    public void victory() {
        System.out.println("Bravo ! Vous avez atteint " + this.valeurMax);
        System.exit(0);
    }

    public void gameOver() {
        System.out.println("La partie est finie. Votre score est " + this.valeurMax);
        System.exit(1);
    }

    public boolean nouvelleCase() {
        if (this.grille.size() < STAGE * TAILLE * TAILLE) {
            ArrayList<Case> casesLibres = new ArrayList<>();
            Random ra = new Random();
            int valeur = (1 + ra.nextInt(2)) * 2;
            // on cr??e toutes les cases encore libres
            for (int z = 0; z < STAGE; z++) {
                for (int x = 0; x < TAILLE; x++) {
                    for (int y = 0; y < TAILLE; y++) {
                        Case c = new Case(x, y, z,  valeur);
                        if (!this.grille.contains(c)) { // contains utilise la m??thode equals dans Case
                            casesLibres.add(c);
                        }
                    }
                }
            }
            // on en choisit une au hasard et on l'ajoute ?? la grille
            Case ajout = casesLibres.get(ra.nextInt(casesLibres.size()));
            ajout.setGrille(this);
            System.out.println(ajout);
            this.grille.add(ajout);
            if ((this.grille.size() == 1) || (this.valeurMax == 2 && ajout.getValeur() == 4)) { // Mise ?? jour de la valeur maximale pr??sente dans la grille si c'est la premi??re case ajout??e ou si on ajoute un 4 et que l'ancien max ??tait 2
                this.valeurMax = ajout.getValeur();
            }
            return true;
        } else {
            return false;
        }
    }
}
