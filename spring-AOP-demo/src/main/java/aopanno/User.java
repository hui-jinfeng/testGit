package aopanno;

import org.springframework.stereotype.Component;

@Component
public class User {
    public void add(){
        //int i=10/0;
        System.out.println("add...");
    }

    public void print(String string){
        System.out.println(string);
    }
}
