package com.example.dodobal_1.androidlauncherapp;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.*;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apps_grid1);

        PackageManager manager0;
        final List<AppDetail> apps0;

        manager0=getPackageManager();
        apps0=new ArrayList<AppDetail>();
        Intent i0=new Intent(Intent.ACTION_MAIN,null);
        i0.addCategory(Intent.CATEGORY_LAUNCHER);

        List<ResolveInfo> availableActivities0=manager0.queryIntentActivities(i0,0);

        Collections.sort(availableActivities0, new ResolveInfo.DisplayNameComparator(manager0));
        for (ResolveInfo ri:availableActivities0){
            AppDetail app=new AppDetail();
            app.label=ri.loadLabel(manager0);
            app.name=ri.activityInfo.packageName;
            app.icon=ri.activityInfo.loadIcon(manager0);
            apps0.add(app);
        }



        GridView grid;

        grid=(GridView)findViewById(R.id.apps_grid);

        ArrayAdapter<AppDetail> adapter=new ArrayAdapter<AppDetail>(this,R.layout.activity_apps_grid1 ,apps0){
            public View getView(int position,View convertView, ViewGroup parent){
                if(convertView==null){
                    convertView=getLayoutInflater().inflate(R.layout.grid_item1,null);
                }
                ImageView appIcon=(ImageView)convertView.findViewById(R.id.item_app_icon);
                appIcon.setImageDrawable(apps0.get(position).icon);

                TextView appLabel=(TextView)convertView.findViewById(R.id.item_app_label);
                appLabel.setText(apps0.get(position).label);

                      /*  TextView appName=(TextView)convertView.findViewById(R.id.item_app_name);
                        appName.setText(apps0.get(position).name);*/

                return convertView;
            }
        };
        grid.setAdapter(adapter);
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                Intent intent1=getPackageManager().getLaunchIntentForPackage(apps0.get(position).name.toString());
                startActivity(intent1);
            }
        });

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event){
        if (keyCode==KeyEvent.KEYCODE_BACK){
            Intent startMain=new Intent(Intent.ACTION_MAIN);
            startMain.addCategory(Intent.CATEGORY_HOME);
            startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(startMain);
            return true;
        }
        return super.onKeyDown(keyCode,event);
    }
   @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
