package dataCenterProjects;

public class Programs_01 {

	public static void main(String[] args) {
	/*	Ville ville1 =new Ville("Bamako",10_000_000,"Mali");
		Ville ville2 =new Ville("Dakar",20_000_000,"Senegal");
		Ville ville3 =new Ville("Lagos",50_000_000,"Nigeria");
		System.out.println(ville1.toString());
		System.out.println("----------------------------------------");
		System.out.println(ville2.toString());
		System.out.println("----------------------------------------");
		ville1.compareVille(ville3);
		System.out.println("Le nombre de ville cree est:"+ville1.getNumberOfInstant());
		Capital niamey = new Capital();
				niamey.setNomVille("Niamey");
				niamey.setNomPays("Niger");
				niamey.setNbrHabitants(13_000_000);
				niamey.setMonument("place de l'independance");
		System.out.println(niamey.toString());
		Capital rio = new Capital("Rio de janero",30_000_000,"Brezil","Santiago");
		System.out.println(rio.toString());
	*/
		//------Polymorphisme
	  Ville[] tableaux = new Ville[6];
	  String[] tab = {"Marseille", "lille", "caen", "lyon", "paris", "nantes"};
	  int[] tab2 = {123456, 78456, 654987, 75832165, 1594, 213};
	  for(int i=0;i<tab.length;i++) 
	  {
			if (i<3) {
				  Ville v= new Ville(tab[i],tab2[i],"France");
				  tableaux[i]=v;
			}else {
				  Capital c= new Capital(tab[i],tab2[i],"France","Tour Eiffel");
				  tableaux[i]=c;
			}
	  }
	  
	  for (Object ville : tableaux) 
	  {
		System.out.println(ville.toString()+"\n");
		break;
	  }

	}

}
