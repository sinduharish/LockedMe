package lockedme;

import java.io.*;
import java.util.*;

// Main menu

class Menu {
	Menu() {

		System.out.println("\n\n*******************************************************");
		System.out.println("|------------------------------|");
		System.out.println("|          LOCKEDME            |");
		System.out.println("|                              |");
		System.out.println("|                Created by    |");
		System.out.println("|                    Sindhu K  |");
		System.out.println("|------------------------------|");

		Scanner sc = new Scanner(System.in);
		System.out.println();
		System.out.println("*****MAIN MENU*****");
		System.out.println();
		System.out.println("1. Display files in ascending order");
		System.out.println("2. User Interface ");
		System.out.println("3. Close application");
		System.out.println("\n Enter your choice : ");
		int n = sc.nextInt();

		switch (n) {
		case 1:
			Sort s = new Sort();
			break;
		case 2:
			Userinterface ui = new Userinterface();
		case 3:
			Exit e = new Exit();
			break;

		}

	}

}

// Create a new file
class Userinterface {
	Userinterface() {
		Scanner sc = new Scanner(System.in);
		System.out.println("\n\n");
		System.out.println("*****User Interface*****");
		System.out.println("1. Create file");
		System.out.println("2. Delete file");
		System.out.println("3. Search file");
		System.out.println("4. Main menu");
		System.out.println("\n Enter your choice : ");
		int n = sc.nextInt();

		switch (n) {
		case 1:
			Createfile cf = new Createfile();
			break;
		case 2:
			Delete df = new Delete();
			break;
		case 3:
			Search cf1 = new Search();
			break;
		case 4:
			Menu m = new Menu();
			break;
		default:
			System.out.println("Enter the correct option");
			Userinterface ui = new Userinterface();
			break;
		}
	}
}

class Createfile {
	Createfile() {
		String str;
		System.out.println("Enter the file name");

		Scanner sc = new Scanner(System.in);
		str = sc.nextLine();
		File obj = new File(str + ".txt");

		try {
			if (obj.createNewFile()) {
				System.out.println("File created successfuly");
				System.out.println();
			}

			else {
				System.out.println("File creation failed");
			}
		} catch (IOException e) {
			System.out.println("Error occured");
		}
		Userinterface ui = new Userinterface();
	}

}

// Sort the file in ascending order
class Sort {
	Sort() {
		String path = "C:\\ws\\lockedme";
		File obj = new File(path);

		File files[] = obj.listFiles();

		Arrays.sort(files);
		for (File e : files) {
			if (e.isFile()) {

				System.out.println("Files : " + e.getName());
			}
			/*
			 * else if(e.isDirectory()) {
			 * 
			 * System.out.println(e.getName()); }
			 */
			else {
				System.out.println("not known : " + e.getName());
			}
		}

		Menu m = new Menu();

	}
}

// Delete a file
class Delete {

	Delete() {

		String path = "C:\\ws\\lockedme";

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the file to be delete");
		String str = sc.nextLine();
		File obj = new File(str + ".txt");

		if (obj.delete()) {
			System.out.println("File Successfully deleted");
		}

		else {
			System.out.println("File name does not exist");
		}
		Userinterface ui = new Userinterface();

	}

}

////////////////////////////////

class Search {
	Search() {

		System.out.println("Enter the file to be searched :");
		Scanner sc1 = new Scanner(System.in);
		String str = sc1.next();

		String path = "C:\\ws\\lockedme";
		File obj = new File(path);
		int f = 0;

		String files[] = obj.list();
		for (int i = 0; i < files.length; i++) {
			String str1 = files[i];

			if ((str + ".txt").matches(str1)) {
				System.out.println("File found");
				f = f + 1;
				break;
			}

		}

		if (f == 0) {
			System.out.println("File does not exist");
		}

		Userinterface ui = new Userinterface();
	}
}

//Exit from the application
class Exit {
	Exit() {
		System.out.println("Thanks for using our application");
	}
}

public class Lockedme {

	public static void main(String[] args) {
		System.out.println("Test");

		Menu m = new Menu();

	}

}
