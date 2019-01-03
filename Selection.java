import java.util.*;

public class Selection{
	
	//variables
	private int rewardAmount, rewardDay, rewardType, popSent, roll;
	private String rewardMsg;
	private String divider = "-----------------------------------------------------------------------------------------------------------";
	
	//objects
	public City cityObject = new City();
	private Rewards rewardsObject = new Rewards(cityObject);
	RewardResult rewardResultObject = new RewardResult(rewardDay, rewardType, rewardAmount, popSent, rewardMsg);
	
	//Array Lists
	ArrayList<RewardResult> rewardResultAL = new ArrayList<RewardResult>();
	
	
	public void PlayerSetup(){
		
		//Scanner
		Scanner nameInput = new Scanner(System.in);
		
		cityObject.setDay(1);
		cityObject.setFOOD(10);
		cityObject.setIdle(10);
		cityObject.setPOP(10);
		cityObject.setLoveHotel(false);
		cityObject.setFarm(false);
		
		//entering city name
		System.out.println(divider);
		System.out.println("What would you like to name the city?\n (enter the name of your city)");
		System.out.println(divider);
		cityObject.setName(nameInput.nextLine());
				
		selectionMenu();
	}
	
	public void selectionMenu(){
		
		//Stat Display
		System.out.println(divider);
		System.out.println(cityObject.getName() + "'s Stats:\n\nDay: " + cityObject.getDay());
		System.out.println("\nPopulation (Idle/Total): " + cityObject.getIdle() + "/" + cityObject.getPOP());
		System.out.println("Food: " + cityObject.getFOOD());
		System.out.println("\nIntelligence: " + cityObject.getINT());
		System.out.println("Power: " + cityObject.getPOW());
		System.out.println("Stamina: " + cityObject.getSTA() + "\n");
		
		//Selection Screen
		System.out.println("Options (Enter one of the following numbers): ");
		System.out.println("1. Defend(" + cityObject.getDefense() + " Workers Allocated)");
		System.out.println("2. Hunt(" + cityObject.getHunt() + " Workers Allocated)");
		System.out.println("3. Gather Fruits(" + cityObject.getGather() + " Workers Allocated)");
		System.out.println("4. Scout(" + cityObject.getScout() + " Workers Allocated)");
		System.out.println("5. Mate(" + cityObject.getMate() + " Workers Allocated)");
		System.out.print("6. Feast(");
		if(cityObject.getFeast() == true){
			System.out.println("WE ARE HAVING A FEAST TONIGHT!!!)");
		}
		else{
			System.out.println("There is no feast tonight...)");
		}
		//work on this later
		System.out.println("7. Build Structure(" + cityObject.getBuild() + " Workers Allocated)");
		System.out.println("8. Sleep");
		System.out.println(divider);
		
		Decision();
		
	}
	
	public void Decision(){
		//Scanner for input
		String choice;
		Scanner decisionInput = new Scanner(System.in);
		while(true){
			
			//prompts input
			choice = decisionInput.nextLine();
			
			//decision tree
			if(choice.equals("1")){
				Defend();
			}
			else if(choice.equals("2")){
				Hunt();
			}
			else if (choice.equals("3")){
				Gather();
			}
			else if(choice.equals("4")){
				Scout();
			}
			else if(choice.equals("5")){
				Mate();
			}
			else if(choice.equals("6")){
				Feast();
			}
			else if(choice.equals("7")){
				Build();
			}
			else if(choice.equals("8")){		
				Sleep();
			}
			else{
				System.out.println(divider + "\nInvalid Input. Try Again!\n" + divider);
			}
		}
	}
			
	public void Defend(){
		//Scanner for input
		Scanner defendInput = new Scanner(System.in);
		
		//print instruction to user
		System.out.println(divider + "\nInput how many people you would like to send to defend the city: \n(Takes 1 day to complete)\n0. Return to Selection\n" + divider);
		
		//prompts input
		while(true){
			while(!defendInput.hasNextInt()){
				System.out.println(divider + "\nInvalid Input. Try Again!\n" + divider);
				defendInput.nextLine();
			}
			cityObject.setDefense(defendInput.nextInt());
			if(cityObject.getDefense() <= cityObject.getIdle()){
				cityObject.setIdle(cityObject.getIdle() - cityObject.getDefense());
				selectionMenu();
			}
			else{
				System.out.println(divider + "\nInvalid Input. Try Again!\n" + divider);
				defendInput.nextLine();
			}
		}
	}
	public void Hunt(){
		//Scanner for input
		Scanner huntInput = new Scanner(System.in);
				
		//print instruction to user
		System.out.println(divider + "\nInput how many people you would like to send to go hunting:\n(Takes 1 day to complete)\n0. Return to Selection\n" + divider);
				
		//prompts input
		while(true){
			while(!huntInput.hasNextInt()){
				System.out.println(divider + "\nInvalid Input. Try Again!\n" + divider);
				huntInput.nextLine();
			}
			cityObject.setHunt(huntInput.nextInt());
			if(cityObject.getHunt() <= cityObject.getIdle()){
				cityObject.setIdle(cityObject.getIdle() - cityObject.getHunt());
				selectionMenu();
			}
			else{
				System.out.println(divider + "\nInvalid Input. Try Again!\n" + divider);
				huntInput.nextLine();
			}
		}
	}
	
	public void Gather(){
		//Scanner for input
		Scanner gatherInput = new Scanner(System.in);
				
		//print instruction to user
		System.out.println(divider + "\nInput how many people you would like to send to go gathering for fruits:\n(Takes 1 day to complete)\n0. Return to Selection\n" + divider);
				
		//prompts input
				while(true){
					while(!gatherInput.hasNextInt()){
						System.out.println(divider + "\nInvalid Input. Try Again!\n" + divider);
						gatherInput.nextLine();
					}
					cityObject.setGather(gatherInput.nextInt());
					if(cityObject.getGather() <= cityObject.getIdle()){
						cityObject.setIdle(cityObject.getIdle() - cityObject.getGather());
						selectionMenu();
					}
					else{
						System.out.println(divider + "\nInvalid Input. Try Again!\n" + divider);
						gatherInput.nextLine();
					}
				}		
		
	}
	public void Scout(){
		//Scanner for input
		Scanner scoutInput = new Scanner(System.in);
				
		//print instruction to user
		System.out.println(divider + "\nInput how many people you would like to send to go scouting outside the city:\n0. Return to Selection\n" + divider);
				
		//prompts input
		while(true){
			while(!scoutInput.hasNextInt()){
				System.out.println(divider + "\nInvalid Input. Try Again!\n" + divider);
				scoutInput.nextLine();
			}
			cityObject.setScout(scoutInput.nextInt());
			if(cityObject.getScout() <= cityObject.getIdle()){
				cityObject.setIdle(cityObject.getIdle() - cityObject.getScout());
				selectionMenu();
			}
			else{
				System.out.println(divider + "\nInvalid Input. Try Again!\n" + divider);
				scoutInput.nextLine();
			}
		}
	}
	public void Mate(){
		//Scanner for input
		Scanner mateInput = new Scanner(System.in);
				
		//print instruction to user
		System.out.println(divider + "\nInput how many people you would like to send to go mating together:\n(Takes 3 days to complete)\n(Input must be a multiple of 2)\n0. Return to Selection\n" + divider);
				
		//prompts input
		while(true){
			while(!mateInput.hasNextInt()){
				System.out.println(divider + "\nInvalid Input. Try Again!\n" + divider);
				mateInput.nextLine();
			}
			cityObject.setMate(mateInput.nextInt());
			if(cityObject.getMate() <= cityObject.getIdle() && cityObject.getMate() % 2 == 0){
				cityObject.setIdle(cityObject.getIdle() - cityObject.getMate());
				selectionMenu();
			}
			else{
				System.out.println(divider + "\nInvalid Input. Try Again!\n" + divider);
				mateInput.nextLine();
			}
		}
	}	
	public void Feast(){
		//Scanner for input
		Scanner feastInput = new Scanner(System.in);
		String userInput;
			
		//check to see if theres enough food for a feast
			if(cityObject.getFOOD() >= cityObject.getPOP() * 3){
			System.out.println(divider + "\nA feast will cost you: " + (cityObject.getPOP() * 2) + " Food\n (Takes 1 day to complete)");
			System.out.println("1. Have a feast tonight");
			System.out.println("0. Return to Selection Menu\n" + divider);
				
			//input whether you would like to have a feast or not
				while(true){
					userInput = feastInput.nextLine();
					if(userInput.equals("1")){
						cityObject.setFeast(true);
						selectionMenu();
					}
					else if(userInput.equals("0")){
						cityObject.setFeast(false);
						selectionMenu();
					}
					else{
						System.out.println(divider + "\nInvalid Input. Try Again!\n" + divider);
					}
				}
			}
			
			//report that there isn't enough food
			else{
				System.out.println(divider + "/nYou must have at least " + (cityObject.getPOP() * 3) + " Food");
				System.out.println("0. Return to Selection Menu/n" + divider);
				while(true){
					userInput = feastInput.nextLine();
					if(userInput.equals("0")){
						cityObject.setFeast(false);
						selectionMenu();
					}
					else{
						System.out.println(divider + "\nInvalid Input. Try Again!\n" + divider);
					}
				}
				
			}
	}

	public void Build(){
		
		//Scanner for input
		Scanner buildInput = new Scanner(System.in);
		
		//choice variable
		String choice;
		
		//print instruction to user
		System.out.println(divider + "\n1. Build Love Hotel\n2. Build Farm\n0. Return to Selection\n" + divider);
		while(true){
			
			//prompt user to input which building to build
			choice = buildInput.nextLine();	
			
			//love hotel building
			if(choice.equals("1") && cityObject.getLoveHotel() == false){	
				System.out.println(divider + "\nHow many workers would you like to send to build the Love Hotel?\n0. Return to Selection Menu\n" + divider);
				while(true){
					while(!buildInput.hasNextInt()){
						System.out.println(divider + "\nInvalid Input. Try Again!\n" + divider);
						buildInput.nextLine();
					}
					cityObject.setLoveHotelValue(buildInput.nextInt());

					if(cityObject.getLoveHotelValue() <= cityObject.getIdle() && cityObject.getLoveHotelValue() != 0){
						cityObject.setLoveHotel(true);
						selectionMenu();
					}
					else if(cityObject.getLoveHotelValue() == 0){
						selectionMenu();
					}
					else{
						System.out.println(divider + "\nInvalid Input. Try Again!\n" + divider);
						buildInput.nextLine();
					}
				}
			}
			
			//farm building
			else if(choice.equals("2") && cityObject.getFarm() == false){
				//prompt user to input value
				System.out.println(divider + "\nHow many workers would you like to send to build the farm?\n0. Return to Selection Menu\n" + divider);
				while(true){
					while(!buildInput.hasNextInt()){
						System.out.println(divider + "\nInvalid Input. Try Again!\n" + divider);
						buildInput.nextLine();
					}
					cityObject.setFarmValue(buildInput.nextInt());
					//turns on farm
					if(cityObject.getFarmValue() <= cityObject.getIdle()){
						cityObject.setFarm(true); 
						selectionMenu();
					}
					else if(cityObject.getLoveHotelValue() == 0){
						cityObject.setIdle(cityObject.getIdle() - cityObject.getLoveHotelValue());
						selectionMenu();
					}
					else{
						System.out.println(divider + "\nInvalid Input. Try Again!\n" + divider);
						buildInput.nextLine();
					}
				}
			}
			
			//if building is already build
			else if ((choice.equals("1") || choice.equals("2")) && cityObject.getLoveHotel() == true){
				System.out.println(divider + "\nThis building is already built or under construction");
				System.out.println("0. Return to Selection Menu\n" + divider);
				while(true){
					choice = buildInput.nextLine();
					if(choice.equals("0")){
						selectionMenu();
					}
					else{
						System.out.println(divider + "\nInvalid Input. Try Again!\n" + divider);
					}
				}
			}
			
			else if (choice.equals("0")){
				cityObject.setIdle(cityObject.getIdle() - cityObject.getFarmValue());
				selectionMenu();
			}
			else{
				System.out.println(divider + "\nInvalid Input. Try Again!\n" + divider);
			}
		}
	}
	public void Sleep(){		
		Scanner sleepInput = new Scanner(System.in);
		String choice;
		
		System.out.println(divider);
		rewardsObject.dayEnd(cityObject);;
		System.out.println("1. Continue\n" + divider);
		while(true){
			choice = sleepInput.nextLine();
			if(choice.equals("1")){
				selectionMenu();
			}
			else{
				System.out.println(divider + "\nInvalid Input. Try Again!\n" + divider);
			}
		}

	}

}
