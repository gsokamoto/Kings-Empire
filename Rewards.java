import java.util.*;

public class Rewards{
	//setting: land of all mythical beasts
	private int rewardAmount, rewardDay, rewardType, popSent, roll;
	private String rewardMsg;
	
	//objects
	ArrayList<RewardResult> rewardResultAL = new ArrayList<RewardResult>();
	RewardResult rewardResultObject = new RewardResult(rewardDay, rewardType, rewardAmount, popSent, rewardMsg);
	
	public Rewards(City cityObject){
	}
	public void dayEnd(City cityObject){
		if(cityObject.getHunt() > 0){
			huntRewardGenerator(cityObject);
		}
		if(cityObject.getGather() > 0){
			gatherRewardGenerator(cityObject);
		}
		if(cityObject.getMate() > 0){
			matingRewardGenerator(cityObject);
		}
		else{
		}
		cityObject.setDay(cityObject.getDay() + 1);
		daySearch(cityObject);
		
		//reset all values
		cityObject.setHunt(0);
		cityObject.setGather(0);
		cityObject.setMate(0);
	}
	
	public void huntRewardGenerator(City cityObject){
		roll = (int)(Math.random() * 100) + 1;
		if(roll > 50){
			rewardResultObject.setRewardType(1);
			rewardResultObject.setPopSent(cityObject.getHunt());
			rewardResultObject.setRewardAmount(rewardResultObject.getPopSent() * 2);
			rewardResultObject.setRewardDay(1);
			rewardResultObject.setRewardMsg("your group caught deers (+" + rewardResultObject.getRewardAmount() + " Food)");
		}
		else{
			rewardResultObject.setRewardType(0);
			rewardResultObject.setPopSent(cityObject.getHunt());
			rewardResultObject.setRewardAmount(0);
			rewardResultObject.setRewardDay(1);
			rewardResultObject.setRewardMsg("the deers ran away (+" + rewardResultObject.getRewardAmount() + " Food)");
		}
		rewardResultAL.add(rewardResultObject);
	}
	
	public void gatherRewardGenerator(City cityObject){
		roll = (int)(Math.random() * 100) + 1;
		if(roll > 50){
			rewardResultObject.setRewardType(1);
			rewardResultObject.setPopSent(cityObject.getGather());
			rewardResultObject.setRewardAmount(rewardResultObject.getPopSent() * 2);
			rewardResultObject.setRewardDay(1);
			rewardResultObject.setRewardMsg("your group picked up berries (+" + rewardResultObject.getRewardAmount() + " Food)");
		}
		else{
			rewardResultObject.setRewardType(0);
			rewardResultObject.setPopSent(cityObject.getHunt());
			rewardResultObject.setRewardAmount(0);
			rewardResultObject.setRewardDay(1);
			rewardResultObject.setRewardMsg("your group was too tired to pick up berries(+" + rewardResultObject.getRewardAmount() + " Food)");
		}
		rewardResultAL.add(rewardResultObject);
	}
	
	public void matingRewardGenerator(City cityObject){
		int babies = 0;

			rewardResultObject.setRewardType(2);
			rewardResultObject.setPopSent(cityObject.getMate());
			for(int i = 0; i < rewardResultObject.getPopSent() / 2; i++){
				roll = (int)(Math.random() * 100) + 1;
				if(roll > 80){
					babies++;
				}
			}
			rewardResultObject.setRewardAmount(babies);
			rewardResultObject.setRewardDay(3);
			rewardResultObject.setRewardMsg(rewardResultObject.getRewardAmount() + " babies were born, but " + ((cityObject.getMate() / 2) - babies) + " babies did not make it (+" + rewardResultObject.getRewardAmount() + " Population)");
			rewardResultAL.add(rewardResultObject);
	}
	
	public void daySearch(City cityObject){
		for(int i = 0; i < rewardResultAL.size(); i++){
			rewardResultAL.get(i).setRewardDay(rewardResultAL.get(i).getRewardDay() - 1);
		}
		for(int j = 0; j < rewardResultAL.size(); j++){
			if(rewardResultAL.get(j).getRewardDay() == 0){
				if(rewardResultAL.get(j).getRewardType() == 0){
					cityObject.setIdle(cityObject.getIdle() + rewardResultAL.get(j).getPopSent());
					cityObject.setHunt(cityObject.getHunt() - rewardResultAL.get(j).getPopSent());
					System.out.println(rewardResultAL.get(j).getRewardMsg());
				}
				//reward type 1 = food rewards
				if (rewardResultAL.get(j).getRewardType() == 1){
					cityObject.setFOOD(cityObject.getFOOD() + rewardResultAL.get(j).getRewardAmount());
					cityObject.setIdle(cityObject.getIdle() + rewardResultAL.get(j).getPopSent());
					System.out.println(rewardResultAL.get(j).getRewardMsg());
				}
				
				//reward type 2 = Population rewards
				if (rewardResultAL.get(j).getRewardType() == 2){
					cityObject.setPOP(cityObject.getPOP() + rewardResultAL.get(j).getRewardAmount());
					cityObject.setIdle(cityObject.getIdle() + rewardResultAL.get(j).getRewardAmount());
					cityObject.setIdle(cityObject.getIdle() + rewardResultAL.get(j).getPopSent());
					System.out.println(rewardResultAL.get(j).getRewardMsg());
				}
			}
		}
	}
}
