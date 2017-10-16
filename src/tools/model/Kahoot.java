package tools.model;

public class Kahoot {
	
	private int questionCount;
	private String creator;
	private String topic;
	private int ID;
	
	private static int IDAccumulator = 0;
	
	public Kahoot(String topic, int questionCount, String creator){
		this.creator = creator;
		this.questionCount = questionCount;
		this.topic = topic;
		ID = IDAccumulator;
		IDAccumulator++;
	}
	public Kahoot(){
		this.creator = "";
		this.questionCount = 0;
		this.topic = "";
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
	
	public void setTopic(String topic){
		this.topic = topic;
	}
	public void setQuestionCount(int count){
		this.questionCount = count;
	}
	public void setCreator(String creator){
		this.creator = creator;
	}
	
	public String toString(){
		return "ID: " + ID +
				"\nTopic: " + topic +
				"\nCreator: " + creator + 
				"\nQuestion Count: " + questionCount;
	}
	
}
