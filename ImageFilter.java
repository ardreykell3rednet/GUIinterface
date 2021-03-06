import java.io.File;
import javax.swing.*;
import javax.swing.filechooser.*;
import java.util.*;
public class ImageFilter extends FileFilter {
    public boolean accept(File f) {
        if (f.isDirectory()) {
            return true;
        }
        String extension = getExtension(f);
        if (extension != null) {
            if (extension.equals("tif") ||
                extension.equals("nd2") || extension.contentEquals("roi"))  {
                    return true;
            } else {
                return false;
            }
        }
        return false;
    }
    public String getDescription() {
        return ".ND2 or .tif";
    }	
    public static String getExtension(File f) {
        String ext = null;
        String s = f.getName();
        int i = s.lastIndexOf('.');

        if (i > 0 &&  i < s.length() - 1) {
            ext = s.substring(i+1).toLowerCase();
        }
        return ext;
    }
}