import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.LinkedList; 
public class Snapshot {
    
	int id=1;
    String key;
    String value;
    public static LinkedHashMap<Integer, LinkedHashMap<String, LinkedList<String>>>SavedSnapshots = new LinkedHashMap<Integer, LinkedHashMap<String, LinkedList<String>>>(); 

    
     public void savesnapshot(LinkedHashMap<String, LinkedList<String>> CurrentState){
        LinkedHashMap<String, LinkedList<String>> SaveState = new LinkedHashMap<String, LinkedList<String>>(CurrentState);
       SavedSnapshots.put(id,SaveState);
        System.out.println("saved as snapshot "+id);
         System.out.println();
        id=id+1;
    }

    public void purge(String k){
        for(int i=1; i<=SavedSnapshots.size();i++){
            SavedSnapshots.get(i);
            // System.out.println(SavedSnapshots);
            SavedSnapshots.get(i).remove(k);
            
            //System.out.println(SavedSnapshots.get(i).remove(k));
        }
        Entry.Structures.remove(k);
        System.out.println("ok");
        System.out.println();
    }
     public void drop(Integer key) {
         if (SavedSnapshots.size()<key || key<=0){
             System.out.println("no such snapshot");
              System.out.println();
         }
         else{
         SavedSnapshots.remove(key);
         }
     }
    public void rollback(Integer Id){
        if (SavedSnapshots.size()<Id || Id<=0){
             System.out.println("no such snapshot");
              System.out.println();
         }
        else{
        Integer stateid=Id+1;
        for(int size=SavedSnapshots.size();stateid<=size;stateid++){
            SavedSnapshots.remove(stateid);
        }
            Entry.Structures=SavedSnapshots.get(Id);
            System.out.println("ok");
            System.out.println();
            
        }
    }

    public void checkout(Integer Id) {
         if (SavedSnapshots.size()<Id || Id<=0){
             System.out.println("no such snapshot");
              System.out.println();
         }
        else{
            Entry.Structures=SavedSnapshots.get(Id);
            System.out.println("ok");
            System.out.println();
        }
    }
    
    public void listsnapshots() {
        
    //     this.SavedSnapshots = new Snapshot ();
    //       }
        // System.out.print(Entry.test+"\n");
       // Entry.Structures();
        if (SavedSnapshots.size()==0){
            System.out.println("no snapshots");
            System.out.println("");
        }
        else{

            for(int i=SavedSnapshots.size();i>0;i--){
                System.out.println(i);
            }

            System.out.println("");
            
        }

        
         
    }
    
    
    
    
}

