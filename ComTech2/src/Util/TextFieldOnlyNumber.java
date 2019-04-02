package Util;


import javafx.scene.control.TextField;

public class TextFieldOnlyNumber extends TextField {

	public TextFieldOnlyNumber() {
	
		
	}
	@Override
	public void replaceText(int i, int il, String str) {
		// TODO Auto-generated method stub
		if(Utiles.isOnlyNum(str)) {
			super.replaceText(i, il, str);
		}
	}
	@Override
	public void replaceSelection(String arg0) {
		// TODO Auto-generated method stub
		super.replaceSelection(arg0);
	}
}
