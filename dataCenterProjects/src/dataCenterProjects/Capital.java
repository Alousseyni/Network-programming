package dataCenterProjects;

public class Capital extends Ville
{
		private String monument ;
		//constructors
		public Capital() {
				super();
				monument ="aucun";
				
		}
		public Capital(String pNomVille,int pNbrHabitants,String pNomPays,String pMonument) {
			super(pNomVille,pNbrHabitants,pNomPays);
			monument =pMonument;
			
	}
		//-------Method
		public String toString() {
			String str =super.toString()+"\n <"+this.monument+"> est une des monuments de cette ville";
			return str;
		}
		public String getMonument() {
			return monument;
		}
		public void setMonument(String monument) {
			this.monument = monument;
		}
		
		
	
}
