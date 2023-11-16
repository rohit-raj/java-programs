package algo.misc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * https://leetcode.com/problems/design-in-memory-file-system/
 */
public class FileSystem {
    class Dir {
        HashMap<String, Dir> dirs = new HashMap<>();
        HashMap<String, String> files = new HashMap<>();
    }
    Dir root;

    public FileSystem() {
        root = new Dir();

    }

    public List<String> ls(String path) {
        Dir r= root;
        List<String> files = new ArrayList<>();
        if(!path.equals("/")) {
            String[] d = path.split("/");
            for (int i = 1; i < d.length - 1; i++) {
                r = r.dirs.get(d[i]);
            }

            if (r.files.containsKey(d[d.length - 1])) {
                files.add(d[d.length-1]);
                return files;
            } else {
                r = r.dirs.get(d[d.length-1]);
            }
        }
        files.addAll(new ArrayList<>(r.dirs.keySet()));
        files.addAll(new ArrayList<>(r.files.keySet()));
        return files;
    }

    public void mkdir(String path) {
        Dir r = root;
        String[] d = path.split("/");
        for(int i=1;i<d.length;i++){
            if(!r.dirs.containsKey(d[i])) {
                r.dirs.put(d[i], new Dir());
            }
            r = r.dirs.get(d[i]);
        }
    }

    public void addContentToFile(String filePath, String content) {
        Dir r = root;
        String[] d = filePath.split("/");
        for(int i=1;i<d.length-1;i++){
            r = r.dirs.get(d[i]);
        }
        r.files.put(d[d.length-1], r.files.getOrDefault(d[d.length-1], "")+content);
    }

    public String readContentFromFile(String filePath) {
        Dir r = root;
        String[] d = filePath.split("/");
        for (int i=1;i<d.length-1;i++){
            r = r.dirs.get(d[i]);
        }
        return r.files.get(d[d.length-1]);
    }

    public static void main(String[] args) {
        FileSystem fs = new FileSystem();
        System.out.println(fs.ls("/"));                         // return []
        fs.mkdir("/a/b/c");
        fs.addContentToFile("/a/b/c/d", "hello");
        System.out.println(fs.ls("/"));                         // return ["a"]
        System.out.println(fs.readContentFromFile("/a/b/c/d")); // return "hello"
    }
}
