package Main;

public class Display  {
	
	private String itm;
	private boolean CR;
	private boolean LF;
	//private String check;
	
	public Display (String item, boolean CR, boolean LF) {
		//this.check = check;
		this.itm = item;
		this.CR = CR;
		this.LF = LF;
	}
	
	@Override
    public boolean equals(Object o) {
		if (!(o instanceof Display)) { 
            return false; 
        } 
		
		Display d = (Display) o;
		
		if (this.getitm().equals(d.getitm()) && this.Getcr().equals(d.Getcr()) && this.Getlf().equals(d.Getlf())) {
			return true;
		}
		else {
			return false;
		}				
	}
	
	public String getitm() {return itm;}
	//public String getcheck() {return check;}
	
	@Override
	public String toString() {
		return itm;
	}

	public Boolean Getcr() {
		return CR;
	}
	public Boolean Getlf() {
		return LF;
	}
}
