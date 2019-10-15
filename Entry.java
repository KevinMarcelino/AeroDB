import java.util.LinkedHashMap;
import java.util.ArrayList;
import java.util.Set;
import java.util.LinkedList; 
import java.util.Collections;
import java.util.*; 
 
public class Entry {
	static String key;
	static String values;
   // static String keyValues;
    static Object test;
    public int id=0;
    static  LinkedHashMap<String, LinkedList<String>> Structures1;
    static String keyValues;
  
    public static LinkedHashMap<String, LinkedList<String>> Structures = new LinkedHashMap<String, LinkedList<String>>();
    
    
     public Entry(){
        this.Structures= Structures;
         
    }
    public void set(String key,LinkedList<String>listValues ){
            Structures.put(key, listValues); 
            System.out.println("ok"+"\n");
            
            
            
        }
   
     public void get(String key,LinkedList<String>listValues ){
           // ArrayList<String> list = new ArrayList<String>();
            
             if(Structures.get(key)==null){
                 System.out.println("no such key");
                 System.out.println();
             }
        
            
            
             else{

            ArrayList<String> arrayList = new ArrayList<String>(Structures.get(key));
            String joinedString = String.join(" ", arrayList);
             System.out.println('['+joinedString+']');
             System.out.println();
             }
     }
      public void listKeys(String key,LinkedList<String>listValues){
              ArrayList <String>listofkeys = new ArrayList<String>(Structures.keySet());
          if(listofkeys.size()<1){
              System.out.println("no keys");
          }
          else{
           for (int i = Structures.size() - 1; i >= 0; i--) {
              String keyDisplay = listofkeys.get(i);
             System.out.println(keyDisplay);
              }
          }
          System.out.println();
      }
      public void listentries(String key,LinkedList<String>listValues){
          
         
        ArrayList <String>listofkeys = new ArrayList<String>(Structures.keySet());
          
          if(listofkeys.size()<1){
              System.out.println("no entries");
              System.out.println();
          }
          
          else{
            for (int i = Structures.size() - 1; i >= 0; i--) {
             String keyDisplay = listofkeys.get(i);
            LinkedList<String> value = Structures.get(listofkeys.get(i));
            ArrayList <String>list = new ArrayList<String>(value);
                String joinedString = String.join(" ", list);
             System.out.println(keyDisplay+" "+'['+joinedString+']');
              }

                System.out.println();
          }
          
      }
        
        
          
      public void del(String key,LinkedList<String>listValues){
          
          ArrayList <String>list = new ArrayList<String>();
            
          if(Structures.get(key)==null){
                  System.out.println("no such key");
                  System.out.println();
              }
              else{
             Structures.remove(key);
              System.out.println("ok");
                System.out.println();
          }
      
      }
    
      public void pop(String key,LinkedList<String>listValues){
          ArrayList <String>listofkeys = new ArrayList<String>(Structures.keySet());
          ArrayList<String> list = new ArrayList<String>();
        
          if(Structures.get(key)==null){
                  System.out.println("no such key");
                  System.out.println();
              }
        else if((Structures.get(key)).size()==0)
              {
                  System.out.println("nil");
                System.out.println();
              }
        
          else{
    
              LinkedList<String> val = (LinkedList<String>)Structures.get(key);
              System.out.println(val.getFirst());
              val.pop();
              Structures.put(key,val);
              
                System.out.println();
          }
      }
        public void pick(String key,int value){
            
        if(Structures.get(key)==null){
                 System.out.println("no such key");
                 System.out.println();
             }
        else{
            LinkedList<String> value4 = Structures.get(key);
            ArrayList <String>vally = new ArrayList<String>(value4);
          //  LinkedList<String> valuess = (LinkedList<String>)Structures.get(key);
           //String valuess=Structures.get(key);
           // String[] listofvalues=vally.split(" ");
        		
        
        
            Entry.keyValues=String.join(" ",vally);
            if (vally.size()<value || value==0){
                System.out.println("index out of range");
                System.out.println();
            }
            else{
                int value2=value-1;
                System.out.println(vally.get(value2));
                System.out.println();
            }
            
        }
        
    }
     public void push(String key,LinkedList<String>listValues){
       
        
         if(Structures.get(key)==null){
                  System.out.println("no such key");
                  System.out.println();
              }
         else{
             ArrayList<String> arrayList = new ArrayList<String>(Structures.get(key));
            LinkedList<String> val = (LinkedList<String>)Structures.get(key);
          //   val.push(num)
            for(int i=0;listValues.size()>i;i++){
                val.push(listValues.get(i));
            }
             Structures.put(key,val);
             System.out.println("ok");
             System.out.println();
         }
     }
    public void pluck(String key,int value){
        
            if(Structures.get(key)==null){
                System.out.println("no such key");
                System.out.println();
            }
        else{
            LinkedList<String> value4 = Structures.get(key);
            ArrayList <String>vally = new ArrayList<String>(value4);
            Entry.keyValues=String.join(" ",vally);
            if (vally.size()<value || value==0){
                System.out.println("index out of range");
                System.out.println();
            }
            else{
                int newval=value-1;
                System.out.println(value4.get(newval));
                value4.remove(newval);
                Structures.put(key,value4);
                
                System.out.println();
            }
        }
        
    }
    
     public void append(String key,LinkedList<String>listValues){
       
        
         if(Structures.get(key)==null){
                  System.out.println("no such key");
                  System.out.println();
              }
         else{
             ArrayList<String> arrayList = new ArrayList<String>(Structures.get(key));
            LinkedList<String> val = (LinkedList<String>)Structures.get(key);
            for(int i=0;listValues.size()>i;i++){
                val.addLast(listValues.get(i));
            }
             Structures.put(key,val);
             System.out.println("ok");
             System.out.println();
         }
        }
    public void len(String key){
        if(Structures.get(key)==null){
                  System.out.println("no such key");
                  System.out.println();
              }
        else{
        ArrayList<String> arrayList = new ArrayList<String>(Structures.get(key));
        LinkedList<String> val = (LinkedList<String>)Structures.get(key);
        System.out.println(val.size());
        System.out.println();
        
        }
    }
    public void min(String key){
        try{
        if(Structures.get(key)==null){
                  System.out.println("no such key");
                  System.out.println();
              }
        else{
        
        ArrayList<String> arraylistString = new ArrayList<String>(Structures.get(key));
        ArrayList<Integer> arraylistint = new ArrayList<Integer>();
            for(int i=0;i<arraylistString.size();i++){
                
            
                   // Number is integer
                
                int result = Integer.parseInt(arraylistString.get(i));
                arraylistint.add(result);
            }

        Object obj = Collections.min(arraylistint);
        System.out.println(obj);
        System.out.println();
        }
        }
        catch(NumberFormatException e){
            System.out.println("At least one value is not an integer");
            System.out.println();
        }
    }
    public void max(String key){
        if(Structures.get(key)==null){
                  System.out.println("no such key");
                  System.out.println();
              }
        else{
        ArrayList<String> arraylistString = new ArrayList<String>(Structures.get(key));
        ArrayList<Integer> arraylistint = new ArrayList<Integer>();
            for(int i=0;i<arraylistString.size();i++){
                int result = Integer.parseInt(arraylistString.get(i));
                arraylistint.add(result);
            }

        Object obj = Collections.max(arraylistint);
        System.out.println(obj);
        System.out.println();
        }
    }
    public void sum(String key){
        if(Structures.get(key)==null){
                  System.out.println("no such key");
                  System.out.println();
              }
        else{
        ArrayList<String> arraylistString = new ArrayList<String>(Structures.get(key));
        int count=0;
            for(int i=0;i<arraylistString.size();i++){
                int result = Integer.parseInt(arraylistString.get(i));
                count=count+result;
            }

        
        System.out.println(count);
        System.out.println();
        }
    }
    public void rev(String key){
        if(Structures.get(key)==null){
                  System.out.println("no such key");
                  System.out.println();
              }
        else{
        ArrayList<String> arraylistString = new ArrayList<String>(Structures.get(key));
        LinkedList<String>reverselist=new LinkedList<String>();
            for(int i=arraylistString.size()-1;i>=0;i--){
                reverselist.add(arraylistString.get(i));
            }
        Structures.put(key,reverselist);
        System.out.println("ok");
        System.out.println();
        }
    }
    public void sort(String key){
        if(Structures.get(key)==null){
                  System.out.println("no such key");
                  System.out.println();
              }
        else{
            ArrayList<String> arraylistString = new ArrayList<String>(Structures.get(key));
            ArrayList<Integer> arraylistInt = new ArrayList<Integer>();
            
            ArrayList<String> arraylistStr = new ArrayList<String>();
            for(int i=0;i<arraylistString.size();i++){
                int result = Integer.parseInt(arraylistString.get(i));
                arraylistInt.add(result);
            }
            Collections.sort(arraylistInt);
            for(int i=0;i<arraylistString.size();i++){
                String str3 = String.valueOf(arraylistInt.get(i));;
                arraylistStr.add(str3);
            }
            LinkedList<String>newlist=new LinkedList<String>(arraylistStr);
            Structures.put(key,newlist);
            System.out.println("ok");
            System.out.println();
        }
    }
   
    
    
    public void uniq(String key){
        
        if(Structures.get(key)==null){
                  System.out.println("no such key");
                  System.out.println();
              }
        else{
            ArrayList<String> arraylistString = new ArrayList<String>(Structures.get(key));
             ArrayList<String> newList = new ArrayList<String>();
                newList.add(arraylistString.get(0));

  
              for(int i = 1; i < arraylistString.size(); i++) {

            if(arraylistString.get(i-1).equals( arraylistString.get(i) )==false ) {
               newList.add(arraylistString.get(i));
            }
              }
          
            LinkedList<String>newl=new LinkedList<String>(newList);
            Structures.put(key,newl);
            System.out.println("ok");
            System.out.println();
            
        }
       
    }
    
    public void diff(ArrayList<String> listofkeys){
        ArrayList <LinkedList<String>> newset = new  ArrayList <LinkedList<String>>();

       }

}
    
    
