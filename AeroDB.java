import java.util.ArrayList;
import java.util.Scanner;
import java.util.LinkedList; 
import java.util.LinkedHashMap;
import java.util.Set;
public class AeroDB {
    public String key;
    public static int id;
	private static final String HELP =
		"BYE   clear database and exit\n"+
		"HELP  display this help message\n"+
		"\n"+
		"LIST KEYS       displays all keys in current state\n"+
		"LIST ENTRIES    displays all entries in current state\n"+
		"LIST SNAPSHOTS  displays all snapshots in the database\n"+
		"\n"+
		"GET <key>    displays entry values\n"+
		"DEL <key>    deletes entry from current state\n"+
		"PURGE <key>  deletes entry from current state and snapshots\n"+
		"\n"+
		"SET <key> <value ...>     sets entry values\n"+
		"PUSH <key> <value ...>    pushes values to the front\n"+
		"APPEND <key> <value ...>  appends values to the back\n"+
		"\n"+
		"PICK <key> <index>   displays value at index\n"+
		"PLUCK <key> <index>  displays and removes value at index\n"+
		"POP <key>            displays and removes the front value\n"+
		"\n"+
		"DROP <id>      deletes snapshot\n"+
		"ROLLBACK <id>  restores to snapshot and deletes newer snapshots\n"+
		"CHECKOUT <id>  replaces current state with a copy of snapshot\n"+
		"SNAPSHOT       saves the current state as a snapshot\n"+
		"\n"+
		"MIN <key>  displays minimum value\n"+
		"MAX <key>  displays maximum value\n"+
		"SUM <key>  displays sum of values\n"+
		"LEN <key>  displays number of values\n"+
		"\n"+
		"REV <key>   reverses order of values\n"+
		"UNIQ <key>  removes repeated adjacent values\n"+
		"SORT <key>  sorts values in ascending order\n"+
		"\n"+
		"DIFF <key> <key ...>   displays set difference of values in keys\n"+
		"INTER <key> <key ...>  displays set intersection of values in keys\n"+
		"UNION <key> <key ...>  displays set union of values in keys"+"\n"+
		"CARTPROD <key> <key ...>  displays set union of values in keys"+"\n";
	
	public static void bye() {
		System.out.println("bye");
	}
	
	public static void help() {
		System.out.println(HELP);
	}
	
	
	public static void main(String[] args) {
       try{
         LinkedHashMap<Integer, LinkedHashMap<String, LinkedList<String> > > SavedSnapshots = new LinkedHashMap<Integer, LinkedHashMap<String, LinkedList<String> > >();
         
        Snapshot snapshot1 = new Snapshot();
        Scanner input=new Scanner(System.in);
        Entry entries1=new Entry( );
        while (true){
            
            System.out.print("> ");
            String inputline = input.nextLine();
            String[] entry = inputline.split(" ");
            String[] entry1 = inputline.split("");
            String command=entry[0].toLowerCase( );
            LinkedList<Integer> list = new LinkedList<Integer>(); 
            LinkedList<String> list1 = new LinkedList<String>(); 
            ArrayList<String> values = new ArrayList<String>();
            ArrayList<String> listString = new ArrayList<String>();
            
         
             
            for(int i=2;i<entry.length;i++){
                
                 list1.add(entry[i]);
            }
            for(int i=1;i<entry.length;i++){
                
                 listString.add(entry[i]);
            }
        if (inputline.equals("")){
            System.out.println("No Input");
            
            System.out.println("");
            }
        else if (command.equals("bye")){
            bye();
            break;
            }
        else if (command.equals("help")){
            help();
           
            }
        else if (command.equals("set")){
            entries1.set(entry[1],list1);
            
            }
         else if(command.equals("get")){
             entries1.get(entry[1],list1);
         }
            
        
          else if(command.equals("list")){
          if(entry[1].toLowerCase().equals("keys")){
              entries1.listKeys(entry[1],list1);
          }
          else if(entry[1].toLowerCase().equals("entries")){
              entries1.listentries(entry[1],list1);
          }
              else if(entry[1].toLowerCase().equals("snapshots")){
                  
              
 
            snapshot1.listsnapshots();

          }
          }
          else if(command.equals("del")){
              entries1.del(entry[1],list1);
          }
          else if(command.equals("pop")){
              entries1.pop(entry[1],list1);
          }    
         else if(command.equals("pick")){
              int result = Integer.parseInt(entry[2]);		
              entries1.pick(entry[1],result);
          }  
         else if(command.equals("push")){
             
             String joined4 = String.join(" ", values);
             
              entries1.push(entry[1],list1);
          }    
           else if(command.equals("pluck")){
             
             int result = Integer.parseInt(entry[2]);		
             
              entries1.pluck(entry[1],result);
          }    
           else if(command.equals("append")){
             
             int result = Integer.parseInt(entry[2]);		
             
              entries1.append(entry[1],list1);
          }    
           else if(command.equals("len")){
      
              entries1.len(entry[1]);
          }  
          else if(command.equals("min")){
 
              entries1.min(entry[1]);
          }   
          else if(command.equals("max")){
	
             
              entries1.max(entry[1]);
          }   
            else if(command.equals("sum")){
             

              entries1.sum(entry[1]);
          }   
            else if(command.equals("rev")){
		
             
              entries1.rev(entry[1]);
          }   
           else if(command.equals("sort")){
             
	
             
              entries1.sort(entry[1]);
          }   
           else if(command.equals("purge")){
             
 
             
              snapshot1.purge(entry[1]);
          }   
           else if(command.equals("drop")){
             

             int result = Integer.parseInt(entry[1]);	
              snapshot1.drop(result);
          }   
           else if(command.equals("uniq")){

              entries1.uniq(entry[1]);
          }   
           else if (command.equals("checkout")){
                
                int result = Integer.parseInt(entry[1]);	
                snapshot1.checkout(result);
            }
           else if (command.equals("rollback")){
                
                int result = Integer.parseInt(entry[1]);	
                snapshot1.rollback(result);
            }
           else if (command.equals("diff")){

                entries1.diff(listString);
               
            }
           else if(command.equals("snapshot")){
             

             
              
            snapshot1.savesnapshot(Entry.Structures);
               // id=id+1;
          
            }
            else{
                System.out.println("Invalid Input");
                System.out.println();
            }
           
//         }    
        }
       }
        catch ( ArrayIndexOutOfBoundsException e){
            System.out.println("No Input");
            System.out.println("");
        }
		//Your main method here
	}
}
