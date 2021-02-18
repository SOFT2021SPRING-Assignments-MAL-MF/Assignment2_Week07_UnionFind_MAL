package weightedunion;

public class WeightedUnionImpl implements WeightedUnion{
    private int[] id;
    private int[] countRoot;
    private int count;

    public WeightedUnionImpl(int n) {
        //Initialisere arrayet med et bestemt antal pladser n
        id = new int[n];
        //Initialisere arrayet med et bestemt antal pladser n
        countRoot = new int[n];
        //Sætter størrelsen på arrayet til count ud fra det angivne n
        count = n;
        //Indsætter værdier i alle pladser af de angivne arrays
        for (int i = 0; i < n; i++) {
            id[i] = i;
            countRoot[i] = 0;
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

        //Finder root på den node som sættes på - f.eks. i eksemplet fra pdf slides, så er root for 0 og 5 = 1
        int root = find(p);
        //Finder den pågældende root værdi og +1
        countRoot[root] = countRoot[root] + 1;

        //Løber igennem countRoot arrayet for at se hvilken root, som har flest noder på sig, og dermed er størst
        //rootMax bliver lig med værdien for denne root
        int rootMax = 0;
        for (int i = 0; i < countRoot.length; i++) {
            if(countRoot[i] > countRoot[root]){
                rootMax = i;
            }
        }

        //Sætter værdien fra id arrayet ud fra index fra rootMax værdien
        int rootA = id[rootMax];
        //Sætter værdien fra root
        int rootB = root;

        //Tjekker om den root som har flest noder er forbundet til en anden root, og derefter sætter den højest
        //Altså gør således at værdien fra den anden forbundne root peger på den.
        if(connected(rootA,rootB)){
            id[rootA] = root;
            id[rootB] = rootB;
        }

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
