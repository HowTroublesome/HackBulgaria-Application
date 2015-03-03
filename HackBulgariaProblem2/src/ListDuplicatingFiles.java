import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;


public class ListDuplicatingFiles {
	
	public static ArrayList<File> files = new ArrayList<File>();
	
	public static boolean detectEqualFiles(File firstFile, File secondFile) throws IOException{
		String pathFile1 = firstFile.toString();
		String pathFile2 = secondFile.toString();
		
		byte[] firstFileBytes = Files.readAllBytes(Paths.get(pathFile1));
		byte[] secondFileBytes = Files.readAllBytes(Paths.get(pathFile2));
		
		if(Arrays.equals(firstFileBytes, secondFileBytes)){
			return true;
		}
		
		return false;
	}
	
	public static void excludeAllFilesFromAllDirectories(File file) throws IOException{
		if(file.isFile()) {
			files.add(file);
	    	}
		else if(file.isDirectory()){
			File[] listOfFiles = file.listFiles();
	    		for(File i : listOfFiles){
	    			excludeAllFilesFromAllDirectories(i);
	    		}
    		}
	}
	
	public static void listDuplicatingFiles(String dir) throws IOException{
		
		File file = new File(dir);
		
		excludeAllFilesFromAllDirectories(file);
		for (int i = 0; i < files.size(); i++){
			for (int j = i + 1; j < files.size(); j++){
				if(detectEqualFiles(files.get(i), files.get(j)) ){
					files.remove(j);
				}
			}
		}
	}
	
	public static void main(String[] arguments) throws IOException{
		
		String myDir = "F:\\Apps\\Eclipse\\HowTroublesome\\HackBulgariaProblem2\\testDirectory";
		
		System.out.println("List Of Non-Duplicate Files: ");
		
		listDuplicatingFiles(myDir);
		for(int i = 0; i < files.size(); i++){
			System.out.println(files.get(i).getName() + " ");
		}
	}
}
