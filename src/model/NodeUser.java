package model;
public class NodeUser{
	
private User us;
	
	private NodeUser next;
	private NodeUser previous;
	
	public NodeUser(User us) {
		this.us = us;
	}
	public User getUser() {
		return us;
	}
	public void setUser(User us) {
		this.us = us;
	}
	public NodeUser getNext() {
		return next;
	}
	public void setNext(NodeUser next) {
		this.next = next;
	}
	public NodeUser getPrevious() {
		return previous;
	}
	public void setPrevious(NodeUser previous) {
		this.previous = previous;
	}

}


//lista circular nodo