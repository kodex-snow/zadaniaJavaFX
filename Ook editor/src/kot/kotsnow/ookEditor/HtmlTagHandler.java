package kot.kotsnow.ookEditor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HtmlTagHandler implements HtmlTagsRegex {

	private Pattern pattern;
	private Matcher matcher;

	private Positions positions;

	private static HtmlTagHandler INSTANCE;

    private HtmlTagHandler(){}

    public static HtmlTagHandler getInstance(){
        if(INSTANCE==null)
            INSTANCE = new HtmlTagHandler();
        return INSTANCE;
    }

    public String wrapRawText(String text){

    	return "<html dir=\"ltr\"><head>"
    			+ "<script type = \"text/javascript\">"
    			+ "window.addEventListener (\"load\", "
    			+ "function () { "
    			+ "var input = document.getElementsByTagName (\"body\"); "
    			+ "input[0].addEventListener (\"keydown\", "
    			+ "function () {alert (\"Caret position: \" + this.selectionStart); "
    			+ "// You can also set the caret: this.selectionStart = 2; "
    			+ "}); });</script>"
    			+ "</head><body contenteditable=\"true\" id=\"editableContent\">"+text+"</body></html>";

    }

    public StringBuilder surroundByTag(StringBuilder text, String regexToSurround, String tagOpen, String tagClose){

    	int position =0;
    	pattern=Pattern.compile(regexToSurround);
		matcher = pattern.matcher(text);
		while(position<text.length()){
			matcher.matches();
			if(matcher.find(position)){
				text.insert(matcher.start(),tagOpen);
				text.insert(matcher.end()+tagOpen.length(), tagClose);
				position=matcher.end()+tagClose.length()+tagOpen.length();
				matcher = pattern.matcher(text);

			} else{
				break;
			}
		}
		return text;

    }

	public String deleteAllHtmlTags(String textToDeleteTags){

		StringBuilder text = new StringBuilder(textToDeleteTags);

		replaceTags(text, "&nbsp;", "\u0020");
		replaceTags(text, "<br>", "\r\n");

		deleteTag(text, TAG_OPEN_REGEX);

		replaceTags(text, "</p>", "\n");
		deleteTag(text, TAG_CLOSE_REGEX);

		return text.toString();
	}

	public StringBuilder convertParagraphTagsToBrTags(StringBuilder text){
		replaceTags(text, PARAGRAPH_OPEN+PARAGRAPH_CLOSE, "");
		replaceTags(text, PARAGRAPH_OPEN, BR);
		deleteTag(text, PARAGRAPH_CLOSE);
		deleteTag(text, PARAGRAPH_OPEN);

		return text;
	}

	public StringBuilder deleteKeywordTags(StringBuilder text){
		text = deleteTag(text, KEYWORD_OPEN_REGEX);
		text = deleteTag(text, KEYWORD_CLOSE_REGEX);
		return text;
	}

	private StringBuilder deleteTag(StringBuilder text, String tagRegex){

		pattern=Pattern.compile(tagRegex);
		matcher = pattern.matcher(text);

		while(matcher.find()){
			text.delete(matcher.start(), matcher.end());
			matcher = pattern.matcher(text);
		}

		return text;
	}

	public StringBuilder modifyTag(StringBuilder text, String tagToModifyRegex, String replacement){

		positions = locateFirstTagPositions(text, tagToModifyRegex);
		if(positions.isPositionsSet()){
			text.delete(positions.getStartPosition(), positions.getEndPosition());
			text.insert(positions.getStartPosition(), replacement);
		}

		return text;
	}

	public StringBuilder replaceTags(StringBuilder text, String tagToReplaceRegex, String replacement){

		pattern=Pattern.compile(tagToReplaceRegex);
		matcher = pattern.matcher(text);

		positions = locateFirstTagPositions(text, tagToReplaceRegex);

		do{
			if(positions.isPositionsSet()){
				text.delete(positions.getStartPosition(), positions.getEndPosition());
				text.insert(positions.getStartPosition(), replacement);
				positions.unsetPosition();
				positions = locateFirstTagPositions(text, tagToReplaceRegex);
			}
		} while(positions.isPositionsSet());
		return text;
	}

	private Positions locateFirstTagPositions(StringBuilder text, String tagRegex){

		Positions positions = new Positions();

		pattern=Pattern.compile(tagRegex);
		matcher = pattern.matcher(text);
		matcher.matches();

		if(positions.getStartPosition()<text.length() &&
				matcher.find()
				){
			positions.setPositions(matcher.start(), matcher.end());
		}
		return positions;
		}


	/*public static void main(String[] args) {
		StringBuilder s = new StringBuilder("Kanapka!");
		//System.out.println(s);
		HtmlTagHandler hTagHandler = new HtmlTagHandler();
		//System.out.println(hTagHandler.deleteTag(s, "kot"));
		//System.out.println(hTagHandler.replaceTag(s, "a","A"));
		//hTagHandler.locateFirstTagPosition(s, "Ka");
		//System.out.println(hTagHandler.replaceTag(s, "Ka", "OO"));
		hTagHandler.replaceTag(s, "ana", "<");
	}*/
}
