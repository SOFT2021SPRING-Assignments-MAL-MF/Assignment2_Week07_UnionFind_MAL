package quickunion;

public class QuickUnionImpl implements QuickUnion{
    private int[] id;
    private int count;

    public QuickUnionImpl(int n) {
        //Initialisere arrayet med et bestemt antal pladser n
        id = new int[n];
        //Sætter størrelsen på arrayet til count ud fra det angivne n
        count = n;
        //Indsætter værdier i alle pladser af det angivne array
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
    }

    @Override
    public void union(int p, int q) {
        //Tjek om to angivne punkter er connected - hvis de er så skal der ikke gøres noget
        if(connected(p,q)) {
            System.out.println("Punkterne " + p + " og " + q + " er allerede forbundet!");
            return;
        }
        //Sætter nuværende forbindelse mellem punkterne p og q - således at plads p i array sættes med værdien
        //af den node som den peger på med q
        id[p] = q;
        //Tæller mulige kombinationer ned med 1
        count--;
    }

    @Override
    public int find(int p) {
        //Tjekker og returnerer top punktet som er forbundet - dette er lavet ud illustrationen i pdf for ugen
        //Hvis der søges efter punkt 5 - så fortsætter while løkken med at søge indtil den finder det øverste punkt
        //i dette tilfælde 1 - den stopper og returnerer når man når samme værdi i id[?] som værdien på pladsen
        //altså fortsætter denne algoritme med at søge indtil den finder 1 - fordi der står 1 i værdien id[1]
        //Dette kan ses på illustrationen i pdf for ugen under quickUnion
        while(id[p] != p){
            p = id[p];
        }
        return p;
    }

    @Override
    public boolean connected(int p, int q) {
        //Finder ud af om to punkter er forbundet
        return find(p) == find(q);
    }

    @Override
    public int count() {
        return count;
    }
}
