package kot.kotsnow.ookEditor;

public interface HtmlTagsRegex {

	String TAG_OPEN_REGEX="<[^>]*>";
	String TAG_CLOSE_REGEX="</[^>]*>";

	String KEYWORD_OPEN_REGEX="<span[^>]*>";
	String KEYWORD_CLOSE_REGEX="</span>";

	String HTML_OPEN = "<html[^>]*>";
	String HTML_CLOSE="</html>";

	String HEAD_OPEN="<head[^>]*>";
	String HEAD_CLOSE="</head>";

	String BODY_OPEN="<body[^>]*>";
	String BODY_CLOSE="</body>";

	String PARAGRAPH_OPEN="<p[^>]*>";
	String PARAGRAPH_CLOSE="</p>";

	String FONT_OPEN="<font[^>]*>";
	String FONT_CLOSE="</font>";

	String KEYWORD_OPEN="<span[^>]*>";
	String KEYWORD_CLOSE="</span>";

	String SCRIPT_OPEN="<script[^>]*>";
	String SCRIPT_CLOSE="</script>";

	String BR="</br>";

	String[] HTMLTAGS_REGEX ={TAG_OPEN_REGEX, TAG_CLOSE_REGEX};
}
