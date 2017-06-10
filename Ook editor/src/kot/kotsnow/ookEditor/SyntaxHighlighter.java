package kot.kotsnow.ookEditor;

public class SyntaxHighlighter {

	private StringBuilder text;

	private final String KEYWORD_REGEX = "((Ook)[/!/.] (Ook)[/!/./?])|((Ook)[/?] (Ook)[/!/.])";

	private Style style;
	private HtmlTagHandler htmlTagHandler;

	private static SyntaxHighlighter INSTANCE;


    public static SyntaxHighlighter getInstance(){
        if(INSTANCE==null)
            INSTANCE = new SyntaxHighlighter();
        return INSTANCE;
    }


	private SyntaxHighlighter(){

		text= new StringBuilder();
		htmlTagHandler = HtmlTagHandler.getInstance();
		style = Style.getInstance();
	}

	public String highlight(String textFromEditor){

		text = new StringBuilder(textFromEditor);
		text = htmlTagHandler.convertParagraphTagsToBrTags(text);
		colorWords();
		System.out.println(getCaretPosition(textFromEditor, text.toString()));

		return text.toString();
	}

	public String getRefreshedContentWithTags(String content){

		StringBuilder text = new StringBuilder(content);
		text = htmlTagHandler.modifyTag(text, HtmlTagsRegex.BODY_OPEN, style.getOpenTagBody());
		return text.toString();
	}

	private void colorWords(){

		text = htmlTagHandler.deleteKeywordTags(text);

		String openKeywordTag = style.getOpenTagKeyword();
		String closeKeywordTag = style.getCloseTagKeyword();

		htmlTagHandler.deleteKeywordTags(text);
		htmlTagHandler.surroundByTag(text, KEYWORD_REGEX, openKeywordTag, closeKeywordTag);
	}
	private int getCaretPosition(String textBefore, String textAfter){

		int textBeforeLength = textBefore.length();
		int textAfterLength = textAfter.length();

		int end = Math.min(textBeforeLength	, textAfterLength);
		int position = 0;
		while(position<end){
			if(textBefore.charAt(position)!= textAfter.charAt(position)){
				String firstSegment = textBefore.substring(0, position);
				String lastSegment = textBefore.substring(position+1);
				/*if characters are added*/
				if(textAfter.endsWith(lastSegment))
					return textAfterLength-lastSegment.length();
				else{
					return firstSegment.length();
				}
			}

			position++;
		}

		return textAfterLength;

	}

}
