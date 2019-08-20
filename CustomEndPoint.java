package websocket.server;

import java.io.IOException;
import java.util.*;
import javax.websocket.*;
import javax.websocket.server.*;


@ServerEndpoint("/server")
public class CustomEndPoint 
{
  static List<Session> list = new ArrayList<Session>();
  static Map<ArrayList<String>,String> map = new HashMap<>();
  static ArrayList<String> arraylist = new ArrayList<>();
    
    static
    {
        Thread1 rateThread=new Thread1();
        rateThread.start();
    }

@OnOpen
public void open(Session session) 
{
  list.add(session);
  arraylist.add(session.toString());
}
 
@OnMessage
public void onMessage(Session session, String msg) { }

@OnError
public void error(Session session, Throwable t) 
{
  list.remove(session);
   arraylist.remove(session.toString());
  System.out.println("Error on session "+session.getId());  
}

@OnClose
public void closedConnection(Session session) 
{ 
  list.remove(session);
   arraylist.remove(session.toString());
  System.out.println("session closed: "+session.getId());
}
 
 
 
 
 

    public static void sendAll(String text1,String text2,String text3,String text4) throws IOException
    {
        String message1 = text1;
        String message2 = text2;
        String message3 = text3;
        String message4 = text4;
        
        int x=arraylist.size();
       
        for(int i=0;i<x;i++)
        {
            if(x>4)
            {
                i=0;
                x=x-4;
                
            }


            if(i==0)
            {
               map.clear();
               map.put(arraylist,message1);
               String str1=map.get(arraylist);
               for(int z=0;z<=arraylist.size()-1;z++)
               {
                    Session session = list.get(z);
                         session.getBasicRemote().sendText(str1);
               }

            }
            if(i==1)
            {
               map.put(arraylist,message2);
               String str2=map.get(arraylist);
               for(int z=1;z<=arraylist.size()-1;z++)
               {
                 
               Session session = list.get(z);
                    session.getBasicRemote().sendText(str2);
               }
            }
            if(i==2)
            {
               map.put(arraylist,message3);
               String str3=map.get(arraylist);
                for(int z=2;z<=arraylist.size()-1;z++)
               {
                 
               Session session = list.get(z);
                   session.getBasicRemote().sendText(str3);
               }
            }
            if(i==3)
            {      
                map.put(arraylist,message4);
                String str4=map.get(arraylist);
               
                for(int z=3;z<=arraylist.size()-1;z++)
               {
                 Session session = list.get(z);
                    session.getBasicRemote().sendText(str4);
               }
            }
        }
    }
          
    

}








 
 
/*
for (Session session : list) {
            if (session.isOpen())
               session.getBasicRemote().sendText(msg);
*/


/*
for(Map.Entry m:arraylist.entrySet()){    
       System.out.println(m.getKey()+" "+m.getValue());    
      }
*/