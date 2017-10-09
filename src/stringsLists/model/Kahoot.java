package stringsLists.model;

public class Kahoot {
	
	private int questionCount;
	private String creator;
	private String topic;
	private int ID;
	
	private static int IDAccumulator = 0;
	
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
	public int getID(){
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
