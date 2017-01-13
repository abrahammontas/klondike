package klondike.models;

public enum Suit {
	BRILLO,
	TREBOL,
	PICAS,
	CORAZON;
	
	public Color getColor(){
		if(this.name().equals(BRILLO) ||this.name().equals(CORAZON)){
			return Color.ROJO;
		}else{
			return Color.NEGRO;
		}
	}
}
