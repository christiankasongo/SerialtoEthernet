package main;

public class CommandComboItem {
	
	private String Command;
	private boolean CRset;
	private boolean LFset;
	
	public CommandComboItem (String cmd, boolean cr, boolean lf) {
		this.Command = cmd;
		this.CRset = cr;
		this.LFset = lf;
	}
	
	@Override
    public boolean equals(Object o) {
		if (!(o instanceof CommandComboItem)) { 
            return false; 
        } 
		
		CommandComboItem c = (CommandComboItem) o;
		
		System.out.println(c.Getcr().toString() + ", " + c.Getlf().toString());
		
		if (this.getitm().equals(c.getitm()) && this.Getcr().equals(c.Getcr()) && this.Getlf().equals(c.Getlf())) {
			return true;
		}
		else {
			return false;
		}				
	}
	
	public String getitm() {return Command;}
	
	
	@Override
	public String toString () {
		 return  Command;
	}

	public Boolean Getcr() {
		return CRset;
	}
	public Boolean Getlf() {
		return LFset;
	}
}
