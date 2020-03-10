package quixada.npi.springproject.model;

public enum Turno {

    MANHA("Manhâ"), TARDE("Tarde"), NOITE("Noite");

    private String name;

    Turno(String name) {
        this.setName(name);
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}