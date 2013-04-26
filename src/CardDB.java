import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;


public class CardDB {
	public final static int initialListSize=1000;
	private ArrayList<Card> cards;
	
	public CardDB(){
		cards= new ArrayList<Card>(initialListSize);
		fromExternFile("C:\\Users\\Till Berger\\Desktop\\DBcards.js");
		//"C:\\Users\\Till Berger\\Desktop\\CardList2.txt"
		//"C:\\Users\\Till Berger\\Desktop\\DBcardsSmall.txt"
		toFileTest("C:\\Users\\Till Berger\\Desktop\\CardDB.txt");
		cards.clear();
		fromFile("C:\\Users\\Till Berger\\Desktop\\CardDB.txt");
	}
	
	public Card getCard(String name){
		int i= getCardIndex(name);
		if(i>=0){
			return cards.get(i);
		}else{
			return null;
		}
	}
	public Card getCard(int index){
		if(cards==null) return null;
		if(index>=0 && index<cards.size())
			return cards.get(index);
		else
			return null;
	}
	public Card removeCard(String name){
		int i= getCardIndex(name);
		if(i<0)
			return null;
		else
			return cards.remove(i);
	}
	public Card removeCard(int index){
		if(cards==null) return null;
		if(index>=0 && index<cards.size())
			return cards.remove(index);
		else
			return null;
	}
	public int getCardIndex(String name){
		if(cards==null || cards.isEmpty()) return -1;
		int rechts= cards.size()-1;
		int links=0;
		do{
			int mitte=(links+rechts)/2;
			int c= name.compareTo(cards.get(mitte).getName());
			if(c==0) return mitte;
			if(c>0)
				links=mitte+1;
			else
				rechts=mitte-1;
		}while(links<=rechts);
		
		return -1;
	}
	
	public void toFileTest(String filePath){
		System.out.println("Writing to file: "+filePath);
		System.out.print("...");
		try {
			FileWriter fw = new FileWriter(filePath);
			BufferedWriter bw= new BufferedWriter(fw);
			
			
			for(int i=0; i<cards.size(); i++){
				Card c= cards.get(i);
				String l= c.getName() +", "+
						c.getClan() +", "+
						c.getLvl() +", "+
						c.getPow()+", "+
						c.getDmg()+", "+
						c.getCondition()+", "+
						c.getEffect()+", "+
						c.getEffectvalue()+", "+
						c.getMin()+", "+
						c.getElo()+", "+
						c.getRarity()+", "+
						c.getValue();
				bw.write(l);
				bw.newLine();
			}
			
			
			bw.flush();
			fw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e){
			e.printStackTrace();
		}
		System.out.println("completed.");
	}
	
	public void fromFile(String path){
		if(cards==null) return;
		
		String line;
		System.out.println("Trying to read File: "+path);
		System.out.print("...");
		try {
			FileReader fr= new FileReader(path);
			BufferedReader br  = new BufferedReader(fr);
			
			
			
			while((line=br.readLine())!=null){
				//if line is a comment ignore
				if(line.startsWith("//")) continue;
				//if line is empty ignore
				if(line.isEmpty()) continue;
		
			
				System.out.println(line);
				String[] sa = line.split(",");
				//only if the split has lenght 14
				if(sa.length==12){
					
					Card c= new Card(/*Name*/sa[0].trim(),
							/*Clan*/sa[1].trim(),
							/*Level*/Integer.parseInt(sa[2].trim()),
							/*Pow*/Integer.parseInt(sa[3].trim()),
							/*Dmg*/Integer.parseInt(sa[4].trim()),
							/*Condition*/sa[5].trim(),
							/*Effect*/ sa[6].trim(),
							/*Effectvalue*/Integer.parseInt(sa[7].trim()),
							/*Min*/Integer.parseInt(sa[8].trim()),
							/*Elo*/ sa[9].trim(),
							/*Rarity*/ sa[10].trim(),
							/*Value*/ Integer.parseInt(sa[11].trim())
							);
					cards.add(c);
				}
			}
			fr.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e){
			e.printStackTrace();
		}
		
		System.out.println("All cards read! Found "+ cards.size()+" suitable cards.");
		System.out.print("Now sorting...");
		Collections.sort(cards);
		System.out.println("completed.");
		
	}
	
	
	public void fromExternFile(String path){
		if(cards==null) return;
		
		String line;
		System.out.println("Trying to read File: "+path);
		System.out.print("...");
		try {
			FileReader fr= new FileReader(path);
			BufferedReader br  = new BufferedReader(fr);
			
			
			
			while((line=br.readLine())!=null){
				//if line is a comment ignore
				if(line.startsWith("//")) continue;
				//if line is empty ignore
				if(line.isEmpty()) continue;
		
			
				System.out.println(line);
				String[] sa = line.split(",");
				//only if the split has lenght 14
				if(sa.length==14){
					
					//only max level cards should be added:
					if(sa[2].trim().compareTo(sa[11].trim())!=0) continue;
					
					Card c= new Card(/*Name*/sa[0].trim(),
							/*Clan*/sa[1].trim(),
							/*Level*/Integer.parseInt(sa[2].trim()),
							/*Pow*/Integer.parseInt(sa[3].trim()),
							/*Dmg*/Integer.parseInt(sa[4].trim()),
							/*Condition*/sa[5].trim(),
							/*Effect*/ sa[6].trim(),
							/*Effectvalue*/Integer.parseInt(sa[7].trim()),
							/*Min*/Integer.parseInt(sa[8].trim()),
							/*Elo*/ sa[9].trim(),
							/*Rarity*/ sa[13].trim(),
							/*Value*/ Integer.parseInt(sa[10].trim())
							);
					cards.add(c);
				}
			}
			fr.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e){
			e.printStackTrace();
		}
		
		System.out.println("All cards read! Found "+ cards.size()+" suitable cards.");
		System.out.print("Now sorting...");
		Collections.sort(cards);
		System.out.println("completed.");
		
	}
	
	
	
	public static void main(String[] args){
		CardDB db= new CardDB();
	}

}