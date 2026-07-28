package memento_design_pattern;

import java.util.Stack;

public class Client {
  public static void main(String[] args) {
	TextEditor textEditor = new TextEditor();
	TextEditorCareTaker textEditorCareTaker = new TextEditorCareTaker();
	textEditor.write("Hello");
	textEditorCareTaker.save(textEditor.save());
	textEditor.write("Hello World");
	textEditorCareTaker.save(textEditor.save());
	textEditor.showContent();
	textEditor.restore(textEditorCareTaker.undo());
	textEditor.showContent();
}
}

//originator
class TextEditor {
	String content;
	
	public void write(String text) {
		content = text;
	}
	public TextEditorMemento save() {
		return new TextEditorMemento(content);
	}
	
	public void restore(TextEditorMemento textEditorMemento) {
		this.content = textEditorMemento.getContent();
	}
	public void showContent() {
		System.out.println(content);
	}
}

//Memento
class TextEditorMemento {
	private final String content;
	
	public TextEditorMemento(String content) {
		this.content = content;
	}
	public String getContent() {
		return content;
	}
}
//CareTaker
class TextEditorCareTaker {
    Stack<TextEditorMemento> history = new Stack<>();
    
    public void save(TextEditorMemento memento) {
    	history.push(memento);
    }
    public TextEditorMemento undo() {
    	if(history.size() > 1) {
    		history.pop();
    	}
    	return history.peek();
    }
}










