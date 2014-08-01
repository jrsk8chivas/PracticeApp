package com.newthinkank.helloworld.app;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MyActivity extends ActionBarActivity {

    private final int ID_MENU_EXIT =1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        final TextView firstTextView = (TextView) findViewById(R.id.textView);

        final Button firstButton = (Button) findViewById(R.id.firstButton);

        firstButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                firstTextView.setText("Welcome");
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // call the base class method
        super.onCreateOptionsMenu(menu);

        //the menu option text is defined in resources
        menu.add(R.string.aboutOption);

        //get a SubMenu reference
        SubMenu sm = menu.addSubMenu("Options...");
        //add menu items to the submenu
        sm.add("Theme");
        sm.add("Settings");

        //it is better to use final variables for IDs than constant values
        //menu.add(Menu.NONE,1,Menu.NONE,"Exit");

        //get the MenuItem reference
        MenuItem item =
                menu.add(Menu.NONE,ID_MENU_EXIT,Menu.NONE,R.string.exitOption);
        //set the shortcut
        item.setShortcut('5', 'x');

        //the menu option text is defined as constant String
        menu.add("Restart");

        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
