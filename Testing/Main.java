package Testing;
import java.util.*;


class FileSystem {

	Map<String, FileSystemAttributes> directoryDetailsMap; 
	PriorityQueue<Directory> directoryHeap;
	HashSet<Directory> isDirectoryPresentInHeap;

	int allFileSize;

	public FileSystem() {
		directoryDetailsMap = new HashMap<>();
		directoryHeap = new PriorityQueue<Directory>((a, b) -> b.size - a.size);
		isDirectoryPresentInHeap = new HashSet<>();
		this.allFileSize = 0;
	}

	public int getSizeOfAllFiles() {
		return this.allFileSize;
	}

	public List<Directory> getNCollection(int n) {

		if (directoryHeap.size() < n)
			return new ArrayList<>();

		List<Directory> output = new ArrayList<>();
		PriorityQueue<Directory> tempDirectoryHeap = new PriorityQueue<Directory>((a, b) -> b.size - a.size) ; 

		for (int i = 0; i < n; i++) {
			Directory d = directoryHeap.poll();
			output.add(d);
			tempDirectoryHeap.add(d);
		}

		for (int i = 0; i < n; i++) 
		{
				directoryHeap.add(tempDirectoryHeap.poll());
			 //   directoryHeap.addAll(output);
		}

		return output;
	}

	public void addFileToDirectory (String fileName, int size, String dName) {
		File file;
		if (dName.equals("")) {
			file = new File(fileName, size);
			directoryDetailsMap.put(fileName, file);
		} else {
			Directory d = (Directory)directoryDetailsMap.getOrDefault(dName, new Directory(dName));
			file = new File(d, fileName, size);

			d.size += size;
			d.files.add(file);

			if (!isDirectoryPresentInHeap.contains(d)) {
				directoryHeap.add(d);
				isDirectoryPresentInHeap.add(d);
			}else{
				directoryHeap.remove(d);
				directoryHeap.add(d);   // so that reordering happens and file with larger size when added comes to top
			}

			directoryDetailsMap.put(dName, d);
		}

		allFileSize += size;
	}
}

interface FileSystemAttributes {

	// So that only single map can contain both file and directory mapping depending upon value given  as map has
	// reference of interface and both classes implements interface so can contain object of either file or directory
}

class Directory implements FileSystemAttributes{

	String name;
	List<File> files;
	int size;

	public Directory (String name) {
		this.name = name;
		files = new ArrayList<>();
		this.size = 0;
	}
}

class File implements FileSystemAttributes {

	Directory directory;
	String name;
	int size;

	public File(Directory d, String n, int size) {
		this.directory = d;
		this.name = n;
		this.size = size;
	}

	public File(String n, int size) {
		this.name = n;
		this.size = size;
	}    
}

public class Main {

	public static void main(String args[]) {
		 
		 
		
		FileSystem fileSystem = new FileSystem();

		fileSystem.addFileToDirectory("file1.txt", 100, "");
		fileSystem.addFileToDirectory("file5.txt", 400, "collection4");
		fileSystem.addFileToDirectory("file2.txt", 300, "collection1");
		fileSystem.addFileToDirectory("file3.txt", 300, "collection1");
		fileSystem.addFileToDirectory("file4.txt", 200, "collection3");


		System.out.println(fileSystem.getSizeOfAllFiles());
		List<Directory> topNCollections = fileSystem.getNCollection(2);

		for (Directory collection: topNCollections)
			System.out.println(collection.name+" " + collection.size+" ");
	}    
}
