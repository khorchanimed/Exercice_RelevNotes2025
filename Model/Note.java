package Model;

public class Note {
	
	
	String matiere ; 
	double noteTp ; 
	double noteEx ;
	
	public String getMatiere() {
		return matiere;
	}
	public void setMatiere(String matiere) {
		this.matiere = matiere;
	}
	public double getNoteTp() {
		return noteTp;
	}
	public void setNoteTp(double noteTp) {
		this.noteTp = noteTp;
	}
	public double getNoteEx() {
		return noteEx;
	}
	public void setNoteEx(double noteEx) {
		this.noteEx = noteEx;
	}
	
	public Note(String matiere, double noteTp, double noteEx) {
		
		this.matiere = matiere;
		this.noteTp = noteTp;
		this.noteEx = noteEx;
	} 
	
	
	

}
