import java.util.*;

public static class Punonjesi{
    protected int id;
    protected String emri ;
    protected double paga;
    public Punonjesi(int id,String emri , double paga){
        this.id = id;
        this.emri = emri;
        this.paga = paga;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPaga() {
        return paga;
    }

    public void setPaga(double paga) {
        this.paga = paga;
    }

    public String getEmri() {
        return emri;
    }

    public void setEmri(String emri) {
        this.emri = emri;
    }

    public void shfaqTeDhenat(){
        System.out.println(STR."ID e punonjesit eshte:\{getId()}");
        System.out.println(STR."Emri i punonjesit eshte:\{getEmri()}");
        System.out.println(STR."Paga e punonjesit eshte:\{getPaga()}" );
    }
}

public static class Menaxher extends Punonjesi{
    private double bonus;
    public Menaxher(int id ,String emri , double paga , double bonus){
        super(id ,emri , paga);
        this.bonus = bonus;
    }

    public double llogaritPagen(){
        return paga + bonus;
    }

    @Override
    public void shfaqTeDhenat() {
        super.shfaqTeDhenat();
        System.out.println(STR."Bonusi i menaxherit eshte:\{bonus}");
        System.out.println(STR."Paga totale eshte:\{llogaritPagen()}");
    }
}

public static class Programues extends Punonjesi{
    private int oreShtese;
    private double pagaPerOre;

    public Programues(int id ,String emri , double paga , int oreShtese , double pagaPerOre){
        super(id ,emri , paga);
        this.oreShtese = oreShtese;
        this.pagaPerOre = pagaPerOre;
    }

    public double pagaTotale(){
        return getPaga() + (oreShtese * pagaPerOre);
    }

    @Override
    public void shfaqTeDhenat() {
        super.shfaqTeDhenat();
        System.out.println(STR."Paga per ore eshte:\{pagaPerOre}");
        System.out.println(STR."Oret shtese jane:\{oreShtese}");
        System.out.println(STR."Paga totale eshte:\{pagaTotale()}");
    }
}


void main(){
    int zgjedhja;
    boolean cikli = true;
    Scanner sc = new Scanner(System.in);
    Vector<Punonjesi> punonjesit = new Vector<>();

   while(cikli) {
       System.out.println("--SISTEMI MENAXHIMIT TE PUNONJESVE--");
       System.out.println("1) Shto punonjes");
       System.out.println("2) Shfaq punonjes");
       System.out.println("3) Fshi punonjes");
       System.out.println("4) Dil");

       System.out.print("Jepni zgjidhjen: ");
       zgjedhja = sc.nextInt();
       switch (zgjedhja) {
           case 1:
               int zgjidhProfesioni;
               Scanner inputi = new Scanner(System.in);

               System.out.println("Cilin profesion do zgjidhni?:");
               System.out.println("1) Punonjes");
               System.out.println("2) Menaxher");
               System.out.println("3) Programues");
               System.out.println("Zgjidhni: ");

               zgjidhProfesioni = inputi.nextInt();

               switch (zgjidhProfesioni) {
                   case 1:
                       int id_Punonjes;
                       String emri_Punonjes;
                       double paga_Punonjes;

                       System.out.println("Jepni te dhenat:");

                       id_Punonjes = sc.nextInt();
                       emri_Punonjes = sc.next();
                       paga_Punonjes = sc.nextDouble();
                       Punonjesi p = new Punonjesi(id_Punonjes,emri_Punonjes, paga_Punonjes);

                       System.out.println("Punonjesi u krijua me sukses");
                       punonjesit.add(p);
                       break;

                   case 2:
                       int id_Menaxher;
                       String emri_Menaxher;
                       double paga_Menaxher, bonus_Menaxher;

                       System.out.println("Jepni te dhenat:");

                       id_Menaxher = sc.nextInt();
                       emri_Menaxher = sc.next();
                       paga_Menaxher = sc.nextDouble();
                       bonus_Menaxher = sc.nextDouble();
                       Menaxher m = new Menaxher(id_Menaxher,emri_Menaxher, paga_Menaxher, bonus_Menaxher);

                       System.out.println("Menaxheri u krijua me sukses");
                       punonjesit.add(m);
                       break;

                   case 3:
                       int id_Programues;
                       String emri_Programues;
                       double paga_Programues;
                       double pagaPerOre_Programues;
                       int oreShteseProgramues;

                       System.out.println("Jepni te dhenat:");

                       id_Programues = sc.nextInt();
                       emri_Programues = sc.next();
                       paga_Programues = sc.nextDouble();
                       pagaPerOre_Programues = sc.nextDouble();
                       oreShteseProgramues = sc.nextInt();
                       Programues pr = new Programues(id_Programues ,emri_Programues, paga_Programues, (int) pagaPerOre_Programues, oreShteseProgramues);

                       System.out.println("Programuesi u krijua me sukses");
                       punonjesit.add(pr);
                       break;
               }
               break;

           case 2:
               System.out.println("--Punonjesit qe ndodhen ne sistem--");

               for (Punonjesi p : punonjesit){
                   p.shfaqTeDhenat();

               }
               break;

           case 3:
               int idZgjedhur;

               System.out.println("--Jepni id e punonjesit qe doni te hiqni--");
               idZgjedhur = sc.nextInt();

               boolean zgjedhur = punonjesit.removeIf( p-> p.getId() == idZgjedhur);
               if (!zgjedhur) {
                   System.out.println("--Punonjesi nuk u gjend ne sistem!!--");
               }else{
                   System.out.println("--Punonjesi u hoq me sukses!!--");
               }

               break;

           case 4:
               System.out.println("MIRUPAFSHIM!!");
               cikli = false;

               break;

       }

   }

}