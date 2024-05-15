package Session2;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;

    public class Activity14 {
        public static void main(String[] args) throws IOException {
            try {
                File file = new File("C:/Users/Srilu/myLearnings/Java/newfile.txt");
                boolean fStatus = file.createNewFile();
                if(fStatus) {
                    System.out.println("File created successfully!");
                } else {
                    System.out.println("File already exists at this path.");
                }

                //get the file Object
                File fileUtil = FileUtils.getFile("C:/Users/Srilu/myLearnings/Java/Text.txt");
                //Read file
                System.out.println("Data in file: " + FileUtils.readFileToString(fileUtil, "UTF8"));

                //Create directory
                File destDir = new File("C:/Users/Srilu/myLearnings/Java/resources");
                //Copy file to directory
                FileUtils.copyFileToDirectory(fileUtil, destDir);

                //Get file from new directory
                File newFile = FileUtils.getFile(destDir, "Text.txt");
                //Read data from file
                String newFileData = FileUtils.readFileToString(newFile, "UTF8");
                //Print it
                System.out.println("Data in new file: " + newFileData);
            } catch(IOException errMessage) {
                System.out.println(errMessage);
            }
        }
    }

