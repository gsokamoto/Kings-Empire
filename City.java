
public class City{
	
	private int defense;
	private int hunt;
	private int gather;
	private int scout;
	private int mate;
	private boolean feast;
	private int build;
	
	private String name;
	private int POP;
	private int idle;
	private int INT;
	private int POW;
	private int STA;
	private int day;
	private int FOOD;
	
	private boolean loveHotel;
	private int loveHotelValue;
	private boolean farm;
	private int farmValue;
	
	
	public void setPOP(int newPOP){
		POP = newPOP;
	}
	public int getPOP(){
		return POP;
	}
	
	public void setIdle(int newIdle){
		idle = newIdle;
	}
	public int getIdle(){
		return idle;
	}
	
	public void setINT(int newINT){
		INT = newINT;
	}
	public int getINT(){
		return INT;
	}
	
	public void setPOW(int  newPOW){
		POW = newPOW;
	}
	public int getPOW(){
		return POW;
	}
	
	public void setSTA(int newSTA){
		STA = newSTA;
	}
	public int getSTA(){
		return STA;
	}
	
	public void setDay(int newDay){
		day = newDay;
	}
	public int getDay(){
		return day;
	}
	
	public void setFOOD(int newFOOD){
		FOOD = newFOOD;
	}
	public int getFOOD(){
		return FOOD;
	}
	
	public void setName(String newName){
		name = newName;
	}
	public String getName(){
		return name;
	}
	public void setDefense(int defenseInput){
		defense = defenseInput;
	}
	public int getDefense(){
		return defense;
	}
	
	public void setHunt(int huntInput){
		hunt = huntInput;
	}
	public int getHunt(){
		return hunt;
	}
	
	public void setGather(int gatherInput){
		gather = gatherInput;
	}
	public int getGather(){
		return gather;
	}
	
	public void setScout(int scoutInput){
		scout = scoutInput;
	}
	public int getScout(){
		return scout;
	}
	
	public void setMate(int mateInput){
		mate = mateInput;
	}
	public int getMate(){
		return mate;
	}
	
	public void setFeast(boolean feastInput){
		feast = feastInput;
	}
	public boolean getFeast(){
		return feast;
	}
	
	public int getBuild(){
		build = loveHotelValue + farmValue;
		return build;
	}
	
	public void setLoveHotelValue(int loveHotelInput){
		loveHotelValue = loveHotelInput;
	}
	public int getLoveHotelValue(){
		return loveHotelValue;
	}
	public void setLoveHotel(boolean loveHotelActive){
		loveHotel = loveHotelActive;
	}
	public boolean getLoveHotel(){
		return loveHotel;
	}
	
	public void setFarmValue(int farmInput){
		farmValue = farmInput;
	}
	public int getFarmValue(){
		return farmValue;
	}
	public void setFarm(boolean farmActive){
		farm = farmActive;
	}
	public boolean getFarm(){
		return farm;
	}
	

}
