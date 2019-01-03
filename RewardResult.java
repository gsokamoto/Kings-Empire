
public class RewardResult {

	private int rewardAmount, rewardDay, rewardType, popSent;
	private String rewardMsg;
	
	public RewardResult(int rewardDay2, int rewardType2, int rewardAmount2, int popSent2, String rewardMsg2){
		rewardDay = rewardDay2;
		rewardType = rewardType2;
		rewardMsg = rewardMsg2;
		rewardAmount = rewardAmount2;
		popSent = popSent2;
	}
	
	public void setRewardDay(int rewardDay2){
		rewardDay = rewardDay2;
	}
	public int getRewardDay(){
		return rewardDay;
	}
	
	public void setRewardAmount(int rewardAmount2){
		rewardAmount = rewardAmount2;
	}
	public int getRewardAmount(){
		return rewardAmount;
	}
	
	public void setRewardType(int rewardType2){
		rewardType = rewardType2;
	}
	public int getRewardType(){
		return rewardType;
	}
	
	public void setPopSent(int popSent2){
		popSent = popSent2;
	}
	public int getPopSent(){
		return popSent;
	}
	
	public void setRewardMsg(String rewardMsg2){
		rewardMsg = rewardMsg2;
	}
	public String getRewardMsg(){
		return rewardMsg;
	}
}
