package pathcrawlerswing;

import java.io.*;

class PathName{
	public String FileName;
	public String Path;
}
public class PathCrawlerSwing {
	private final String pathInput;
	private final int sumFile;
	private PathName[] ArrayFileName;
	
	public PathCrawlerSwing(String input){ // Konstruktor
		pathInput = input;
		sumFile = 0; // default
	}
	public int GetSumMaxFile(){ // Perkiraan banyaknya file di dalam direktori terkait
		return ArrayFileName.length;
	}
	public String GetFileName (int Indeks){ // Dapat Nama Fisik File 
		return ArrayFileName[Indeks].FileName;
	}
	public String GetFilePath (int Indeks){ // Dapat path direktori File 
		return ArrayFileName[Indeks].Path;
	}
	public String GetInputPath (){ // Dapat direktori input yang hendak ditelusuri isi filenya
		return pathInput;
	}
	
	public boolean IsMusicFile (String pathName){ // cek apakah file berekstensi musik atau bukan
		return (pathName.contains(".mp3") || pathName.contains(".wma") || pathName.contains(".wav")
				|| pathName.contains(".ra") || pathName.contains(".ram") || pathName.contains(".rm")
				|| pathName.contains(".java"));
	}
	public void ReadDirectory(){ // Lakukan pembacaan dari direktori input ke array of PathName
		// Konstruktor kelas path untuk penelusuran direktori
		File input = new File (pathInput);
		// Masukkan daftar file di direktori pathInput ke array of string
		String[] ArrayFile = input.list();
		
		ArrayFileName = new PathName [ArrayFile.length];
		for (int i = 0; i < ArrayFile.length; i++)
		{
			File childPath = new File (pathInput + "/" + ArrayFile[i]);
			ArrayFileName[i] = new PathName();
			
			if ((childPath.isFile()) && (IsMusicFile(childPath.getName()))) { 
				ArrayFileName[i].FileName = childPath.getName();
				ArrayFileName[i].Path = childPath.getPath();
			}
			else{ // Isi dengan string default
				ArrayFileName[i].FileName = "buffer";
				ArrayFileName[i].Path = "buffer";
			}
		}
	}
}