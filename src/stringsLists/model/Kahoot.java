package stringsLists.model;

public class Kahoot {
	
	private int questionCount;
	private int level;
	private String creator;
	private boolean isJumble;
	private static long IDAccumulator = 0;
	private long ID;
	private String topic;
	
	public Kahoot(String topic, String creator, int questionCount){
		this.creator = creator;
		this.questionCount = questionCount;
		this.topic = topic;
		ID = IDAccumulator;
		IDAccumulator++;
	}
	
	public String getCreator(){
		return creator;
	}
	public int getQuestionCount(){
		return questionCount;
	}
	public long getID(){
		return ID;
	}
	public String getTopic(){
		return topic;
	}
	
	public String toString(){
		return "ID: " + ID +
				"\nTopic: " + topic +
				"\nCreator: " + creator + 
				"\nQuestion Count: " + questionCount;
	}
	
}
