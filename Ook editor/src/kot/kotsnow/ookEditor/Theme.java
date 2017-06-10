package kot.kotsnow.ookEditor;

public enum Theme {
    DEFAULT ("defaultTheme","white","black","red"),
    BLUE ("blueTheme","blue","white","yellow"),
    CONTRAST("contrastTheme","black","yellow", "pink");

    private final String themeName;
    private final String backgroundColor;
    private final String fontColor;
    private final String keywordColor;

    Theme(String themeName, String backgroundColor, String fontColor, String keywordColor) {
        this.themeName = themeName;
        this.backgroundColor=backgroundColor;
        this.fontColor =fontColor;
        this.keywordColor=keywordColor;
    }

	public String getThemeName() {
		return themeName;
	}

	public String getBackgroundColor() {
		return backgroundColor;
	}

	public String getFontColor() {
		return fontColor;
	}

	public String getKeywordColor() {
		return keywordColor;
	}

	public static Theme getTheme(String name){

		for(Theme theme: Theme.values()){
			if((theme.getThemeName().equals(name))){
				return theme;
			}

		}
		return DEFAULT;
	}

}
