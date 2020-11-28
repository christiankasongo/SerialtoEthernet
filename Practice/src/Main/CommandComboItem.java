package Main;

public class CommandComboItem {
	
	String Command;
	boolean CRset;
	boolean LFset;
	
	public CommandComboItem (String cmd, boolean cr, boolean lf) {
		Command = cmd;
		CRset = cr;
		LFset = lf;
	}
	
	@Override
	public String toString () {
		String ret = Command;
		if (CRset == true)
			ret += "[CR]";
		if(LFset == true)
			ret += "[LF]";
		return ret;
	}
}
