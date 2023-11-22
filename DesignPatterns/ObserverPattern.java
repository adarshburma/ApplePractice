/* Online Java Compiler and Editor */

import java.util.*;
public class HelloWorld{
    
    public interface ISubscriber {
        public abstract void notify (String message);
    }
    
    public static class User implements ISubscriber {
        String id;
        
        User (String id) {
            this.id = id;
        }
        
        public void notify (String message) {
            System.out.println("User " + this.id +  " received message : " + message);
        }
    }
    
    public static class Topic {
        List<ISubscriber> subscribers = new ArrayList<>();
        
        public void subscribe(User user) {
            subscribers.add(user);
        }
        
        public void unsubscribe(User user) {
            subscribers.remove(user);
        }
        
        public void notifyAll(String message) {
            for (ISubscriber subscriber: subscribers) {
                subscriber.notify(message);
            }
        }
        
    }

     public static void main(String []args){
         
        Topic topic = new Topic();
        
        User user1 = new User("user1");
        User user2 = new User("user2");
        User user3 = new User("user3");
        User user4 = new User("user4");
        User user5 = new User("user5");
        
        topic.subscribe(user1);
        topic.subscribe(user2);
        topic.subscribe(user3);
        topic.subscribe(user4);
        topic.subscribe(user5);
        
        topic.notifyAll("new message!!!");
        
        topic.unsubscribe(user3);
        topic.unsubscribe(user5);
        
        topic.notifyAll("new message again!!!");
        
        //System.out.println("Hello, World!");
     }
}
