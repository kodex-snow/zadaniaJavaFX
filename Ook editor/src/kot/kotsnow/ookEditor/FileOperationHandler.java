package kot.kotsnow.ookEditor;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileOperationHandler {

	private static FileOperationHandler INSTANCE;

    private FileOperationHandler(){}

    public static FileOperationHandler getInstance(){
        if(INSTANCE==null)
            INSTANCE = new FileOperationHandler();
        return INSTANCE;
    }


	public void save(String content, File file){

		try {
			PrintWriter out = new PrintWriter(file);
			out.println(content);
			out.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String open(File file){
		try {
			Scanner scanner = new Scanner(file);
			String content = scanner.useDelimiter("\\Z").next();
			scanner.close();

			return content;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return "";
	}

}
