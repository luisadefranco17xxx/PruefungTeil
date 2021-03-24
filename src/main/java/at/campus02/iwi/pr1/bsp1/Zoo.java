package at.campus02.iwi.pr1.bsp1;

import java.util.Arrays;

public class Zoo {
    static final int LIMIT_KLEINTIER = 5;
    static final int LIMIT_GROSZTIER = 500;

    static final double KOSTEN_KLEINTIER = 3.2;
    static final double KOSTEN_GROSZTIER = 8.5;
    static final double KOSTEN_ELEFANT = 23.9;

    static final int LIMIT_CONTAINER = 500;

    public static void main(String[] args) {
        final double[] GEWICHTE = ZooData.ANIMAL_WEIGHTS;

        System.out.println("GEWICHTE = " + tiereImContainer(GEWICHTE,140));
        System.out.println("GEWICHTE = " + tiereImContainer(GEWICHTE,190));

        System.out.println("GEWICHTE[190] = " + GEWICHTE[190]);
        System.out.println("GEWICHTE[191] = " + GEWICHTE[191]);
        System.out.println("GEWICHTE[192] = " + GEWICHTE[192]);
        System.out.println("GEWICHTE[193] = " + GEWICHTE[193]);
        System.out.println("GEWICHTE[194] = " + GEWICHTE[194]);
        System.out.println("GEWICHTE[194] = " + GEWICHTE[195]);
        System.out.println("GEWICHTE[194] = " + GEWICHTE[196]);
        System.out.println("GEWICHTE[194] = " + GEWICHTE[197]);

    }

    // 16 %
    public static int tierAnzahl(double[] gewichte) {
       // int tierAnzahl= ZooData.ANIMAL_WEIGHTS.length;

        int tierAnzahl= gewichte.length;
        return tierAnzahl;
    }

    // 16 %
    public static int elefanten(double[] gewichte) {
        int elefatenAnzahl=0;
        int LIMIT_GROSZTIER=500;
        for (int i = 0; i < gewichte.length; i++) {
            if (ZooData.ANIMAL_WEIGHTS[i]>=LIMIT_GROSZTIER){
                elefatenAnzahl=elefatenAnzahl+1;
            }
        }
        return elefatenAnzahl;
    }

    // 16 %
    public static double mittleresGewicht(double[] gewichte) {
        double sum=0;

        for (int i = 0; i < gewichte.length; i++) {
            sum=sum+gewichte[i];
        }
        return sum/gewichte.length;
    }

    // 16 %
    public static double futterKosten(double[] gewichte) {
        int elefatenAnzahl=elefanten(gewichte);
        int kleinTierAnzahl=0;
        int mittleTierAnzhl=0;
        int LIMIT_KLEINTIER=5;
        double kosten=0;
        for (int i = 0; i < gewichte.length; i++) {
            if (gewichte[i]<LIMIT_KLEINTIER) {
                kleinTierAnzahl=kleinTierAnzahl+1;
            }
        }
        mittleTierAnzhl= gewichte.length-elefatenAnzahl-kleinTierAnzahl;
        kosten=elefatenAnzahl*23.9+mittleTierAnzhl*8.5+kleinTierAnzahl*3.2;
        return kosten; 
    }

    // 16 %
    public static boolean problemFallVorhanden(double[] gewichte) {

        for (int i = 0; i < gewichte.length; i++) {
            if(gewichte[i]<1.0) return true;
        }
        return false;
    }

    // 10%
    public static int problemFallIndex(double[] gewichte, int startIndex) {
        double newGewichte;

        if (problemFallVorhanden(gewichte)) {
            for (int i = startIndex; i <gewichte.length; i++) {
                if(gewichte[i]<1.0) return i;
            }
        }
        return -1;
    }

    // 10 %
    public static int tiereImContainer(double[] gewichte, int index) {
        int anzahl = 0;
        double sumGewichte = 0;
        for (int i = index; i < gewichte.length; i++) {
          if(gewichte[i]<LIMIT_GROSZTIER) {   //nur wenn kein Elefant ist
              anzahl++;
              sumGewichte = sumGewichte + gewichte[i];
              if (anzahl == 5) {

                  if (sumGewichte >= LIMIT_CONTAINER) {

                      anzahl=anzahl-1;
                      return anzahl;
                  }
                  return anzahl;
              }
              if (sumGewichte >= LIMIT_CONTAINER) {
                  anzahl=anzahl-1;
                  return anzahl;
              }
          }
        }

        return -1;
    }

}
