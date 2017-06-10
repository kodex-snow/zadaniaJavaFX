package kot.kotsnow.ookEditor;

public class Style {

	private static String openTagKeyword="<span style=\"color:red\">";
	private static String closeTagKeyword="</span>";

	private static String openTagBody = "<body contenteditable=\"true\" id=\"editableContent\">"
			+ "<script type=\"text/javascript\" src=\"CaretPositionHandler.js\"></script>";

	private Theme theme=Theme.DEFAULT;

	private static Style INSTANCE;

    private Style(){}

    public static Style getInstance(){
        if(INSTANCE==null)
            INSTANCE = new Style();
        return INSTANCE;
    }


	public String getOpenTagKeyword() {
		return openTagKeyword;
	}

	public String getCloseTagKeyword() {
		return closeTagKeyword;
	}

	public String getOpenTagBody(){
		return openTagBody;
	}


	public void setTheme(String themeName){

		theme=Theme.getTheme(themeName);

		setKeywordColor(theme.getKeywordColor());
		setBackgroudColors(theme.getBackgroundColor(), theme.getFontColor());
	}

	private void setKeywordColor(String fontColor) {
		openTagKeyword = "<span style=\"color:"+fontColor+"\">";
	}

	private void setBackgroudColors(String backgroundColor, String fontColor){
		openTagBody = "<body contenteditable=\"true\" id=\"editableContent\" bgcolor=\""+backgroundColor+
				"\"text=\""+fontColor+"\"";

	}

}
//Ook! Ook!