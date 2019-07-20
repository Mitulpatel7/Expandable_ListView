package com.example.a2506app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ExpandableListView expandableListView;
    String[] technology = {"Android","Python","Php","IOS"};
    int[] images = {R.drawable.android,R.drawable.python,R.drawable.php,R.drawable.download};
    ArrayList<Chatlist> ArrayChatList;


    String[] androidArray = {"Toast","Intent","Listview","Spinner"};
    int[] android = {R.drawable.toast,R.drawable.intent,R.drawable.listview,R.drawable.spinner};
    String[] pythonArray = {"Django","MongoDB"};
    int[] python = {R.drawable.django,R.drawable.mongo};
    String[] phpArray = {"Core php","HTML","CSS"};
    int[] php = {R.drawable.corephp,R.drawable.html,R.drawable.css};
    String[] iosArray = {"C++"};
    int[] ios = {R.drawable.cplusplus};
    ArrayList<Childlist> Arraychildlist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        expandableListView = findViewById(R.id.list_view);
        ArrayChatList = new ArrayList<>();
        for(int i=0;i<technology.length;i++){
            Chatlist list = new Chatlist();
            list.setName(technology[i]);
            list.setImages(images[i]);

            if(i==0){
               Arraychildlist = new ArrayList<>();
               for(int j=0;j<androidArray.length;j++){
                   Childlist cList = new Childlist();
                   cList.setChildName(androidArray[i]);
                   cList.setImages(android[i]);
                   Arraychildlist.add(cList);
               }
                list.setchildLists(Arraychildlist);
            }


            if(i==1){
                Arraychildlist = new ArrayList<>();
                for(int j=0;j<pythonArray.length;j++){
                    Childlist cList = new Childlist();
                    cList.setChildName(pythonArray[i]);
                    cList.setImages(python[i]);
                    Arraychildlist.add(cList);
                }
                list.setChildLists(Arraychildlist);
            }


            if(i==2){
                Arraychildlist = new ArrayList<>();
                for(int j=0;j<phpArray.length;j++){
                    Childlist cList = new Childlist();
                    cList.setChildName(phpArray[i]);
                    cList.setImages(php[i]);
                    Arraychildlist.add(cList);
                }
                list.setChildLists(Arraychildlist);
            }

            if(i==3){
                Arraychildlist = new ArrayList<>();
                for(int j=0;j<iosArray.length;j++){
                    Childlist cList = new Childlist();
                    cList.setChildName(iosArray[i]);
                    cList.setImages(ios[i]);
                    Arraychildlist.add(cList);
                }
                list.setChildLists(Arraychildlist);
            }
            ArrayChatList.add(list);
        }
        ChatAdapter chatAdapter =new ChatAdapter(MainActivity.this,ArrayChatList);
        expandableListView.setAdapter((ExpandableListAdapter) chatAdapter);




    }
}
