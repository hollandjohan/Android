package com.example.dodobal_1.androidlauncherapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageItemInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class ConfigureActivity extends Activity {

    private PackageManager manager;
    public static String pName1,pName2,pName3,pName4;
    public static Drawable icon1,icon2,icon3,icon4;

    private List<AppDetail> apps;
    final static Drawable icon[]=new Drawable[200];
    final static String packageName[]=new String[200];
    final static String appName[]=new String[200];
    SharedPreferences sharedpreferences;
    public static final String icon_order0="order0";
    public static final String icon_order1="order1";
    public static final String icon_order2="order2";
    public static final String icon_order3="order3";
    public static final String icon_order4="order4";
    public static final String icon_order5="order5";
    public static final String icon_order6="order6";
    public static final String icon_order7="order7";
    public static final String icon_order8="order8";
    public static final String icon_order9="order9";
    public static final String icon_order10="order10";
    public static final String icon_order11="order11";
    public static final String icon_order12="order12";
    public static final String icon_order13="order13";
    public static final String icon_order14="order14";
    public static final String icon_order15="order15";

    public static final String package_order0="p_order0";
    public static final String package_order1="p_order1";
    public static final String package_order2="p_order2";
    public static final String package_order3="p_order3";
    public static final String package_order4="p_order4";
    public static final String package_order5="p_order5";
    public static final String package_order6="p_order6";
    public static final String package_order7="p_order7";
    public static final String package_order8="p_order8";
    public static final String package_order9="p_order9";
    public static final String package_order10="p_order10";
    public static final String package_order11="p_order11";
    public static final String package_order12="p_order12";
    public static final String package_order13="p_order13";
    public static final String package_order14="p_order14";
    public static final String package_order15="p_order15";

    public static final String tab_order="tab";

    public static final String mypreference="mypref";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configure);

        manager=getPackageManager();

        Intent i=new Intent(Intent.ACTION_MAIN,null);
        i.addCategory(Intent.CATEGORY_LAUNCHER);

        final List<ResolveInfo> availableActivities=manager.queryIntentActivities(i,0);
        Collections.sort(availableActivities, new ResolveInfo.DisplayNameComparator(manager));

        Resources res = getResources();
        String s;
        int j=0;
        for (ResolveInfo ri:availableActivities){
            AppDetail app=new AppDetail();

            icon[j]=ri.activityInfo.loadIcon(manager);
            packageName[j]=ri.activityInfo.packageName;
            appName[j]=ri.loadLabel(manager).toString();
            j++;
        }
        sharedpreferences=getSharedPreferences(mypreference, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedpreferences.edit();

  //      Toast.makeText(ConfigureActivity.this,String.valueOf(sharedpreferences.getInt(icon_order1,0)),Toast.LENGTH_LONG).show();
        if (sharedpreferences.getInt(icon_order0,100)==100)
            editor.putInt(icon_order0,0);
        if (sharedpreferences.getInt(icon_order1,100)==100)
            editor.putInt(icon_order1,1);
        if (sharedpreferences.getInt(icon_order2,110)==110)
            editor.putInt(icon_order2,2);
        if (sharedpreferences.getInt(icon_order3,110)==110)
            editor.putInt(icon_order3,3);
        if (sharedpreferences.getInt(icon_order4,110)==110)
            editor.putInt(icon_order4,4);
        if (sharedpreferences.getInt(icon_order5,110)==110)
            editor.putInt(icon_order5,5);
        if (sharedpreferences.getInt(icon_order6,110)==110)
            editor.putInt(icon_order6,6);
        if (sharedpreferences.getInt(icon_order7,110)==110)
            editor.putInt(icon_order7,7);
        if (sharedpreferences.getInt(icon_order8,110)==110)
            editor.putInt(icon_order8,8);
        if (sharedpreferences.getInt(icon_order9,110)==110)
            editor.putInt(icon_order9,9);
        if (sharedpreferences.getInt(icon_order10,110)==110)
            editor.putInt(icon_order10,10);
        if (sharedpreferences.getInt(icon_order11,110)==110)
            editor.putInt(icon_order11,11);
        if (sharedpreferences.getInt(icon_order12,110)==110)
            editor.putInt(icon_order12,12);
        if (sharedpreferences.getInt(icon_order13,110)==110)
            editor.putInt(icon_order13,13);
        if (sharedpreferences.getInt(icon_order14,110)==110)
            editor.putInt(icon_order14,14);
        if (sharedpreferences.getInt(icon_order15,110)==110)
            editor.putInt(icon_order15,15);
        editor.commit();
       /* String a;
        a=sharedpreferences.getString(package_order15,"");
        Toast.makeText(this,a,Toast.LENGTH_LONG).show();
        String b;
        b=packageName[sharedpreferences.getInt(icon_order15,0)];
        Toast.makeText(this,b,Toast.LENGTH_LONG).show();*/
        if (sharedpreferences.getString(package_order0,"")=="")
            editor.putString(package_order0,packageName[sharedpreferences.getInt(icon_order0,0)]);
        if (sharedpreferences.getString(package_order1,"")=="")
            editor.putString(package_order1,packageName[1]);
        if (sharedpreferences.getString(package_order2,"")=="")
            editor.putString(package_order2,packageName[2]);
        if (sharedpreferences.getString(package_order3,"")=="")
            editor.putString(package_order3,packageName[3]);
        if (sharedpreferences.getString(package_order4,"")=="")
            editor.putString(package_order4,packageName[4]);
        if (sharedpreferences.getString(package_order5,"")=="")
            editor.putString(package_order5,packageName[5]);
        if (sharedpreferences.getString(package_order6,"")=="")
            editor.putString(package_order6,packageName[6]);
        if (sharedpreferences.getString(package_order7,"")=="")
            editor.putString(package_order7,packageName[7]);
        if (sharedpreferences.getString(package_order8,"")=="")
            editor.putString(package_order8,packageName[8]);
        if (sharedpreferences.getString(package_order9,"")=="")
            editor.putString(package_order9,packageName[9]);
        if (sharedpreferences.getString(package_order10,"")=="")
            editor.putString(package_order10,packageName[10]);
        if (sharedpreferences.getString(package_order11,"")=="")
            editor.putString(package_order11,packageName[11]);
        if (sharedpreferences.getString(package_order12,"")=="")
            editor.putString(package_order12,packageName[12]);
        if (sharedpreferences.getString(package_order13,"")=="")
            editor.putString(package_order13,packageName[13]);
        if (sharedpreferences.getString(package_order14,"")=="")
            editor.putString(package_order14,packageName[14]);
        if (sharedpreferences.getString(package_order15,"")=="")
            editor.putString(package_order15,packageName[15]);
        editor.commit();

    //    Toast.makeText(ConfigureActivity.this,sharedpreferences.getString(package_order1,""),Toast.LENGTH_LONG).show();
     //   ImageButton btnDismiss = (ImageButton)findViewById(R.id.power);
        ImageButton btnSetting=(ImageButton)findViewById(R.id.btn_setting);
        final ImageButton btn0= (ImageButton)findViewById(R.id.btn0);
        final  ImageButton btn1= (ImageButton)findViewById(R.id.btn1);
        final ImageButton btn2= (ImageButton)findViewById(R.id.btn2);
        final ImageButton btn3= (ImageButton)findViewById(R.id.btn3);
        final ImageButton btn4= (ImageButton)findViewById(R.id.btn4);
        final ImageButton btn5= (ImageButton)findViewById(R.id.btn5);
        final ImageButton btn6= (ImageButton)findViewById(R.id.btn6);
        final ImageButton btn7= (ImageButton)findViewById(R.id.btn7);
        final ImageButton btn8= (ImageButton)findViewById(R.id.btn8);
        final ImageButton btn9= (ImageButton)findViewById(R.id.btn9);
        final ImageButton btn10= (ImageButton)findViewById(R.id.btn10);
        final ImageButton btn11= (ImageButton)findViewById(R.id.btn11);
        final ImageButton btn12= (ImageButton)findViewById(R.id.btn12);
        final  ImageButton btn13= (ImageButton)findViewById(R.id.btn13);
        final ImageButton btn14= (ImageButton)findViewById(R.id.btn14);
        final  ImageButton btn15= (ImageButton)findViewById(R.id.btn15);

        final TextView name0=(TextView)findViewById(R.id.name0);
        final TextView name1=(TextView)findViewById(R.id.name1);
        final TextView name2=(TextView)findViewById(R.id.name2);
        final TextView name3=(TextView)findViewById(R.id.name3);
        final TextView name4=(TextView)findViewById(R.id.name4);
        final TextView name5=(TextView)findViewById(R.id.name5);
        final TextView name6=(TextView)findViewById(R.id.name6);
        final TextView name7=(TextView)findViewById(R.id.name7);
        final TextView name8=(TextView)findViewById(R.id.name8);
        final TextView name9=(TextView)findViewById(R.id.name9);
        final TextView name10=(TextView)findViewById(R.id.name10);
        final TextView name11=(TextView)findViewById(R.id.name11);
        final TextView name12=(TextView)findViewById(R.id.name12);
        final TextView name13=(TextView)findViewById(R.id.name13);
        final TextView name14=(TextView)findViewById(R.id.name14);
        final TextView name15=(TextView)findViewById(R.id.name15);

        ImageButton tab1=(ImageButton)findViewById(R.id.tab1);
        ImageButton tab2=(ImageButton)findViewById(R.id.tab2);
        ImageButton tab3=(ImageButton)findViewById(R.id.tab3);
        ImageButton tab4=(ImageButton)findViewById(R.id.tab4);

        btn0.setBackground(icon[sharedpreferences.getInt(icon_order0,0)]);
  //      Toast.makeText(this,String.valueOf(sharedpreferences.getInt(icon_order1,0)),Toast.LENGTH_LONG).show();
        btn1.setBackground(icon[sharedpreferences.getInt(icon_order1,0)]);
        btn2.setBackground(icon[sharedpreferences.getInt(icon_order2,0)]);
        btn3.setBackground(icon[sharedpreferences.getInt(icon_order3,0)]);
        btn4.setBackground(icon[sharedpreferences.getInt(icon_order4,0)]);
        btn5.setBackground(icon[sharedpreferences.getInt(icon_order5,0)]);
        btn6.setBackground(icon[sharedpreferences.getInt(icon_order6,0)]);
        btn7.setBackground(icon[sharedpreferences.getInt(icon_order7,0)]);
        btn8.setBackground(icon[sharedpreferences.getInt(icon_order8,0)]);
        btn9.setBackground(icon[sharedpreferences.getInt(icon_order9,0)]);
        btn10.setBackground(icon[sharedpreferences.getInt(icon_order10,0)]);
        btn11.setBackground(icon[sharedpreferences.getInt(icon_order11,0)]);

        btn12.setBackground(icon[sharedpreferences.getInt(icon_order12,0)]);
        btn13.setBackground(icon[sharedpreferences.getInt(icon_order13,0)]);
        btn14.setBackground(icon[sharedpreferences.getInt(icon_order14,0)]);
        btn15.setBackground(icon[sharedpreferences.getInt(icon_order15,0)]);

        name0.setText(appName[sharedpreferences.getInt(icon_order0,0)]);
        name1.setText(appName[sharedpreferences.getInt(icon_order1,0)]);
        name2.setText(appName[sharedpreferences.getInt(icon_order2,0)]);
        name3.setText(appName[sharedpreferences.getInt(icon_order3,0)]);
        name4.setText(appName[sharedpreferences.getInt(icon_order4,0)]);
        name5.setText(appName[sharedpreferences.getInt(icon_order5,0)]);
        name6.setText(appName[sharedpreferences.getInt(icon_order6,0)]);
        name7.setText(appName[sharedpreferences.getInt(icon_order7,0)]);
        name8.setText(appName[sharedpreferences.getInt(icon_order8,0)]);
        name9.setText(appName[sharedpreferences.getInt(icon_order9,0)]);
        name10.setText(appName[sharedpreferences.getInt(icon_order10,0)]);
        name11.setText(appName[sharedpreferences.getInt(icon_order11,0)]);
        name12.setText(appName[sharedpreferences.getInt(icon_order12,0)]);
        name13.setText(appName[sharedpreferences.getInt(icon_order13,0)]);
        name14.setText(appName[sharedpreferences.getInt(icon_order14,0)]);
        name15.setText(appName[sharedpreferences.getInt(icon_order15,0)]);

        btn0.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                pName1=sharedpreferences.getString(package_order0,"com.android.mms");
                pName2=sharedpreferences.getString(package_order1,"com.android.mms");
                pName3=sharedpreferences.getString(package_order2,"com.android.mms");
                pName4=sharedpreferences.getString(package_order3,"com.android.mms");
     //           Toast.makeText(ConfigureActivity.this,pName1,Toast.LENGTH_LONG).show();
                RunActivity.editor1.putInt(RunActivity.icon_orderr0,sharedpreferences.getInt(icon_order0,0));
                RunActivity.editor1.putString(RunActivity.package_orderr0,pName1);
                RunActivity.editor1.putInt(RunActivity.icon_orderr1,sharedpreferences.getInt(icon_order1,0));
                RunActivity.editor1.putString(RunActivity.package_orderr1,pName2);
                RunActivity.editor1.putInt(RunActivity.icon_orderr2,sharedpreferences.getInt(icon_order2,0));
                RunActivity.editor1.putString(RunActivity.package_orderr2,pName3);
                RunActivity.editor1.putInt(RunActivity.icon_orderr3, sharedpreferences.getInt(icon_order3, 0));
                RunActivity.editor1.putString(RunActivity.package_orderr3, pName4);

               RunActivity.editor1.putInt(RunActivity.flag1,0);
                RunActivity.button1.setBackground(icon[sharedpreferences.getInt(icon_order0,0)]);
                RunActivity.button2.setBackground(icon[sharedpreferences.getInt(icon_order1,0)]);
                RunActivity.button3.setBackground(icon[sharedpreferences.getInt(icon_order2,0)]);
                RunActivity.button4.setBackground(icon[sharedpreferences.getInt(icon_order3,0)]);

                RunActivity.editor1.commit();
                Intent intent1=getPackageManager().getLaunchIntentForPackage(ConfigureActivity.pName1);
                startActivity(intent1);
                RunActivity.flag=0;

            }});

        btn0.setOnLongClickListener(new Button.OnLongClickListener(){
            public boolean onLongClick(View v){
                LayoutInflater layoutInflater
                        = (LayoutInflater)getBaseContext()
                        .getSystemService(LAYOUT_INFLATER_SERVICE);
                final View popupView = layoutInflater.inflate(R.layout.activity_apps_grid, null);
                final PopupWindow popupWindow = new PopupWindow(
                        popupView,
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT,true);
                popupWindow.showAtLocation(popupView, Gravity.CENTER, 0, 0);

                PackageManager manager0;
                final List<AppDetail> apps0;

                manager0=getPackageManager();
                apps0=new ArrayList<AppDetail>();
                Intent i0=new Intent(Intent.ACTION_MAIN,null);
                i0.addCategory(Intent.CATEGORY_LAUNCHER);

                List<ResolveInfo> availableActivities0=manager.queryIntentActivities(i0,0);

                Collections.sort(availableActivities0, new ResolveInfo.DisplayNameComparator(manager));
                for (ResolveInfo ri:availableActivities0){
                    AppDetail app=new AppDetail();
                    app.label=ri.loadLabel(manager);
                    app.name=ri.activityInfo.packageName;
                    app.icon=ri.activityInfo.loadIcon(manager);
                    apps0.add(app);
                }



                GridView grid;

                grid=(GridView)popupView.findViewById(R.id.apps_grid);

                ArrayAdapter<AppDetail> adapter=new ArrayAdapter<AppDetail>(ConfigureActivity.this,R.layout.activity_apps_grid ,apps0){
                    public View getView(int position,View convertView, ViewGroup parent){
                        if(convertView==null){
                            convertView=getLayoutInflater().inflate(R.layout.grid_item,null);
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
                        icon[0]=apps0.get(position).icon;
                        packageName[0]=apps0.get(position).name.toString();
                        SharedPreferences.Editor editor=sharedpreferences.edit();
                        editor.putString(package_order0,packageName[0]);


                        editor.putInt(icon_order0,position);

                        editor.commit();
                      /*  if (RunActivity.flag1==0){
                            RunActivity.editor1.putInt(RunActivity.icon_orderr0,sharedpreferences.getInt(icon_order0,0));
                            RunActivity.editor1.putString(RunActivity.package_orderr0,packageName[0]);

                            RunActivity.button1.setBackground(icon[sharedpreferences.getInt(icon_order0,0)]);

                            RunActivity.editor1.commit();
                        }*/
                        btn0.setBackground(icon[0]);
                        name0.setText(apps0.get(position).label);
                        popupWindow.dismiss();
                    }
                });


                return true;


            }
        });

        btn1.setOnLongClickListener(new Button.OnLongClickListener(){
            public boolean onLongClick(View v){
                LayoutInflater layoutInflater
                        = (LayoutInflater)getBaseContext()
                        .getSystemService(LAYOUT_INFLATER_SERVICE);
                final View popupView = layoutInflater.inflate(R.layout.activity_apps_grid, null);
                final PopupWindow popupWindow = new PopupWindow(
                        popupView,
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT,true);
                popupWindow.showAtLocation(popupView, Gravity.CENTER, 0, 0);

                PackageManager manager0;
                final List<AppDetail> apps0;

                manager0=getPackageManager();
                apps0=new ArrayList<AppDetail>();
                Intent i0=new Intent(Intent.ACTION_MAIN,null);
                i0.addCategory(Intent.CATEGORY_LAUNCHER);

                List<ResolveInfo> availableActivities0=manager.queryIntentActivities(i0,0);
                Collections.sort(availableActivities0, new ResolveInfo.DisplayNameComparator(manager));
                for (ResolveInfo ri:availableActivities0){
                    AppDetail app=new AppDetail();
                    app.label=ri.loadLabel(manager);
                    app.name=ri.activityInfo.packageName;
                    app.icon=ri.activityInfo.loadIcon(manager);
                    apps0.add(app);
                }

                GridView grid;

                grid=(GridView)popupView.findViewById(R.id.apps_grid);

                ArrayAdapter<AppDetail> adapter=new ArrayAdapter<AppDetail>(ConfigureActivity.this,R.layout.activity_apps_grid ,apps0){
                    public View getView(int position,View convertView, ViewGroup parent){
                        if(convertView==null){
                            convertView=getLayoutInflater().inflate(R.layout.grid_item,null);
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
                        icon[1]=apps0.get(position).icon;
                        packageName[1]=apps0.get(position).name.toString();
                        SharedPreferences.Editor editor=sharedpreferences.edit();
                        editor.putString(package_order1,packageName[1]);


                        editor.putInt(icon_order1,position);
                   //    Toast.makeText(ConfigureActivity.this,String.valueOf(position),Toast.LENGTH_LONG).show();
                        editor.commit();
                //
                //        Toast.makeText(ConfigureActivity.this,sharedpreferences.getString(package_order1,""),Toast.LENGTH_LONG).show();
                 /*       if (RunActivity.flag1==0){

                            RunActivity.editor1.putInt(RunActivity.icon_orderr1,sharedpreferences.getInt(icon_order1,0));
                            RunActivity.editor1.putString(RunActivity.package_orderr1,packageName[1]);


                            RunActivity.button2.setBackground(icon[sharedpreferences.getInt(icon_order1,0)]);

                            RunActivity.editor1.commit();
                        }*/
                        btn1.setBackground(icon[1]);
                        name1.setText(apps0.get(position).label);
                        popupWindow.dismiss();
                    }
                });


                return true;


            }
        });

        btn2.setOnLongClickListener(new Button.OnLongClickListener(){
            public boolean onLongClick(View v){
                LayoutInflater layoutInflater
                        = (LayoutInflater)getBaseContext()
                        .getSystemService(LAYOUT_INFLATER_SERVICE);
                final View popupView = layoutInflater.inflate(R.layout.activity_apps_grid, null);
                final PopupWindow popupWindow = new PopupWindow(
                        popupView,
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT,true);
                popupWindow.showAtLocation(popupView, Gravity.CENTER, 0, 0);

                PackageManager manager0;
                final List<AppDetail> apps0;

                manager0=getPackageManager();
                apps0=new ArrayList<AppDetail>();
                Intent i0=new Intent(Intent.ACTION_MAIN,null);
                i0.addCategory(Intent.CATEGORY_LAUNCHER);

                List<ResolveInfo> availableActivities0=manager.queryIntentActivities(i0,0);
                Collections.sort(availableActivities0, new ResolveInfo.DisplayNameComparator(manager));
                for (ResolveInfo ri:availableActivities0){
                    AppDetail app=new AppDetail();
                    app.label=ri.loadLabel(manager);
                    app.name=ri.activityInfo.packageName;
                    app.icon=ri.activityInfo.loadIcon(manager);
                    apps0.add(app);
                }

                GridView grid;

                grid=(GridView)popupView.findViewById(R.id.apps_grid);

                ArrayAdapter<AppDetail> adapter=new ArrayAdapter<AppDetail>(ConfigureActivity.this,R.layout.activity_apps_grid ,apps0){
                    public View getView(int position,View convertView, ViewGroup parent){
                        if(convertView==null){
                            convertView=getLayoutInflater().inflate(R.layout.grid_item,null);
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
                        icon[2]=apps0.get(position).icon;
                        packageName[2]=apps0.get(position).name.toString();
                        SharedPreferences.Editor editor=sharedpreferences.edit();
                        editor.putString(package_order2,packageName[2]);


                        editor.putInt(icon_order2,position);

                        editor.commit();
                 /*       if (RunActivity.flag1==0){

                            RunActivity.editor1.putInt(RunActivity.icon_orderr2,sharedpreferences.getInt(icon_order2,0));
                            RunActivity.editor1.putString(RunActivity.package_orderr2,packageName[2]);

                            RunActivity.button3.setBackground(icon[sharedpreferences.getInt(icon_order2,0)]);

                            RunActivity.editor1.commit();
                        }*/
                        btn2.setBackground(icon[2]);
                        name2.setText(apps0.get(position).label);
                        popupWindow.dismiss();
                    }
                });


                return true;


            }
        });

        btn3.setOnLongClickListener(new Button.OnLongClickListener(){
            public boolean onLongClick(View v){
                LayoutInflater layoutInflater
                        = (LayoutInflater)getBaseContext()
                        .getSystemService(LAYOUT_INFLATER_SERVICE);
                final View popupView = layoutInflater.inflate(R.layout.activity_apps_grid, null);
                final PopupWindow popupWindow = new PopupWindow(
                        popupView,
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT,true);
                popupWindow.showAtLocation(popupView, Gravity.CENTER, 0, 0);

                PackageManager manager0;
                final List<AppDetail> apps0;

                manager0=getPackageManager();
                apps0=new ArrayList<AppDetail>();
                Intent i0=new Intent(Intent.ACTION_MAIN,null);
                i0.addCategory(Intent.CATEGORY_LAUNCHER);

                List<ResolveInfo> availableActivities0=manager.queryIntentActivities(i0,0);
                Collections.sort(availableActivities0, new ResolveInfo.DisplayNameComparator(manager));
                for (ResolveInfo ri:availableActivities0){
                    AppDetail app=new AppDetail();
                    app.label=ri.loadLabel(manager);
                    app.name=ri.activityInfo.packageName;
                    app.icon=ri.activityInfo.loadIcon(manager);
                    apps0.add(app);
                }

                GridView grid;

                grid=(GridView)popupView.findViewById(R.id.apps_grid);

                ArrayAdapter<AppDetail> adapter=new ArrayAdapter<AppDetail>(ConfigureActivity.this,R.layout.activity_apps_grid ,apps0){
                    public View getView(int position,View convertView, ViewGroup parent){
                        if(convertView==null){
                            convertView=getLayoutInflater().inflate(R.layout.grid_item,null);
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
                        icon[3]=apps0.get(position).icon;
                        packageName[3]=apps0.get(position).name.toString();
                        SharedPreferences.Editor editor=sharedpreferences.edit();
                        editor.putString(package_order3,packageName[3]);


                        editor.putInt(icon_order3,position);

                        editor.commit();
                   /*     if (RunActivity.flag1==0){

                            RunActivity.editor1.putInt(RunActivity.icon_orderr3,sharedpreferences.getInt(icon_order3,0));
                            RunActivity.editor1.putString(RunActivity.package_orderr3,packageName[3]);

                            RunActivity.button4.setBackground(icon[sharedpreferences.getInt(icon_order3,0)]);
                            RunActivity.editor1.commit();
                        }*/
                        btn3.setBackground(icon[3]);
                        name3.setText(apps0.get(position).label);
                        popupWindow.dismiss();
                    }
                });


                return true;


            }
        });

        btn4.setOnLongClickListener(new Button.OnLongClickListener(){
            public boolean onLongClick(View v){
                LayoutInflater layoutInflater
                        = (LayoutInflater)getBaseContext()
                        .getSystemService(LAYOUT_INFLATER_SERVICE);
                final View popupView = layoutInflater.inflate(R.layout.activity_apps_grid, null);
                final PopupWindow popupWindow = new PopupWindow(
                        popupView,
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT,true);
                popupWindow.showAtLocation(popupView, Gravity.CENTER, 0, 0);

                PackageManager manager0;
                final List<AppDetail> apps0;

                manager0=getPackageManager();
                apps0=new ArrayList<AppDetail>();
                Intent i0=new Intent(Intent.ACTION_MAIN,null);
                i0.addCategory(Intent.CATEGORY_LAUNCHER);

                List<ResolveInfo> availableActivities0=manager.queryIntentActivities(i0,0);
                Collections.sort(availableActivities0, new ResolveInfo.DisplayNameComparator(manager));
                for (ResolveInfo ri:availableActivities0){
                    AppDetail app=new AppDetail();
                    app.label=ri.loadLabel(manager);
                    app.name=ri.activityInfo.packageName;
                    app.icon=ri.activityInfo.loadIcon(manager);
                    apps0.add(app);
                }

                GridView grid;

                grid=(GridView)popupView.findViewById(R.id.apps_grid);

                ArrayAdapter<AppDetail> adapter=new ArrayAdapter<AppDetail>(ConfigureActivity.this,R.layout.activity_apps_grid ,apps0){
                    public View getView(int position,View convertView, ViewGroup parent){
                        if(convertView==null){
                            convertView=getLayoutInflater().inflate(R.layout.grid_item,null);
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
                        icon[4]=apps0.get(position).icon;
                        packageName[4]=apps0.get(position).name.toString();
                        SharedPreferences.Editor editor=sharedpreferences.edit();
                        editor.putString(package_order4,packageName[4]);


                        editor.putInt(icon_order4,position);

                        editor.commit();
                /*        if (RunActivity.flag1==1){
                            RunActivity.editor1.putInt(RunActivity.icon_orderr0,sharedpreferences.getInt(icon_order4,0));
                            RunActivity.editor1.putString(RunActivity.package_orderr0,packageName[4]);

                            RunActivity.button1.setBackground(icon[sharedpreferences.getInt(icon_order4,0)]);

                            RunActivity.editor1.commit();
                        }*/
                        btn4.setBackground(icon[4]);
                        name4.setText(apps0.get(position).label);
                        popupWindow.dismiss();
                    }
                });


                return true;


            }
        });

        btn5.setOnLongClickListener(new Button.OnLongClickListener(){
            public boolean onLongClick(View v){
                LayoutInflater layoutInflater
                        = (LayoutInflater)getBaseContext()
                        .getSystemService(LAYOUT_INFLATER_SERVICE);
                final View popupView = layoutInflater.inflate(R.layout.activity_apps_grid, null);
                final PopupWindow popupWindow = new PopupWindow(
                        popupView,
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT,true);
                popupWindow.showAtLocation(popupView, Gravity.CENTER, 0, 0);

                PackageManager manager0;
                final List<AppDetail> apps0;

                manager0=getPackageManager();
                apps0=new ArrayList<AppDetail>();
                Intent i0=new Intent(Intent.ACTION_MAIN,null);
                i0.addCategory(Intent.CATEGORY_LAUNCHER);

                List<ResolveInfo> availableActivities0=manager.queryIntentActivities(i0,0);

                Collections.sort(availableActivities0, new ResolveInfo.DisplayNameComparator(manager));

                for (ResolveInfo ri:availableActivities0){
                    AppDetail app=new AppDetail();
                    app.label=ri.loadLabel(manager);
                    app.name=ri.activityInfo.packageName;
                    app.icon=ri.activityInfo.loadIcon(manager);
                    apps0.add(app);
                }

                GridView grid;

                grid=(GridView)popupView.findViewById(R.id.apps_grid);

                ArrayAdapter<AppDetail> adapter=new ArrayAdapter<AppDetail>(ConfigureActivity.this,R.layout.activity_apps_grid ,apps0){
                    public View getView(int position,View convertView, ViewGroup parent){
                        if(convertView==null){
                            convertView=getLayoutInflater().inflate(R.layout.grid_item,null);
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
                        icon[5]=apps0.get(position).icon;
                        packageName[5]=apps0.get(position).name.toString();
                        SharedPreferences.Editor editor=sharedpreferences.edit();
                        editor.putString(package_order5,packageName[5]);


                        editor.putInt(icon_order5,position);

                        editor.commit();
                     /*   if (RunActivity.flag1==1){

                            RunActivity.editor1.putInt(RunActivity.icon_orderr1,sharedpreferences.getInt(icon_order5,0));
                            RunActivity.editor1.putString(RunActivity.package_orderr1,packageName[5]);


                            RunActivity.button2.setBackground(icon[sharedpreferences.getInt(icon_order5,0)]);

                            RunActivity.editor1.commit();
                        }*/
                        btn5.setBackground(icon[5]);
                        name5.setText(apps0.get(position).label);
                        popupWindow.dismiss();
                    }
                });


                return true;


            }
        });

        btn6.setOnLongClickListener(new Button.OnLongClickListener(){
            public boolean onLongClick(View v){
                LayoutInflater layoutInflater
                        = (LayoutInflater)getBaseContext()
                        .getSystemService(LAYOUT_INFLATER_SERVICE);
                final View popupView = layoutInflater.inflate(R.layout.activity_apps_grid, null);
                final PopupWindow popupWindow = new PopupWindow(
                        popupView,
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT,true);
                popupWindow.showAtLocation(popupView, Gravity.CENTER, 0, 0);

                PackageManager manager0;
                final List<AppDetail> apps0;

                manager0=getPackageManager();
                apps0=new ArrayList<AppDetail>();
                Intent i0=new Intent(Intent.ACTION_MAIN,null);
                i0.addCategory(Intent.CATEGORY_LAUNCHER);

                List<ResolveInfo> availableActivities0=manager.queryIntentActivities(i0,0);
                Collections.sort(availableActivities0, new ResolveInfo.DisplayNameComparator(manager));

                for (ResolveInfo ri:availableActivities0){
                    AppDetail app=new AppDetail();
                    app.label=ri.loadLabel(manager);
                    app.name=ri.activityInfo.packageName;
                    app.icon=ri.activityInfo.loadIcon(manager);
                    apps0.add(app);
                }

                GridView grid;

                grid=(GridView)popupView.findViewById(R.id.apps_grid);

                ArrayAdapter<AppDetail> adapter=new ArrayAdapter<AppDetail>(ConfigureActivity.this,R.layout.activity_apps_grid ,apps0){
                    public View getView(int position,View convertView, ViewGroup parent){
                        if(convertView==null){
                            convertView=getLayoutInflater().inflate(R.layout.grid_item,null);
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
                        icon[6]=apps0.get(position).icon;
                        packageName[6]=apps0.get(position).name.toString();
                        SharedPreferences.Editor editor=sharedpreferences.edit();
                        editor.putString(package_order6,packageName[6]);


                        editor.putInt(icon_order6,position);

                        editor.commit();
                   /*     if (RunActivity.flag1==1){

                            RunActivity.editor1.putInt(RunActivity.icon_orderr2,sharedpreferences.getInt(icon_order6,0));
                            RunActivity.editor1.putString(RunActivity.package_orderr2,packageName[6]);

                            RunActivity.button3.setBackground(icon[sharedpreferences.getInt(icon_order6,0)]);

                            RunActivity.editor1.commit();
                        }*/
                        btn6.setBackground(icon[6]);
                        name6.setText(apps0.get(position).label);
                        popupWindow.dismiss();
                    }
                });


                return true;


            }
        });

        btn7.setOnLongClickListener(new Button.OnLongClickListener(){
            public boolean onLongClick(View v){
                LayoutInflater layoutInflater
                        = (LayoutInflater)getBaseContext()
                        .getSystemService(LAYOUT_INFLATER_SERVICE);
                final View popupView = layoutInflater.inflate(R.layout.activity_apps_grid, null);
                final PopupWindow popupWindow = new PopupWindow(
                        popupView,
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT,true);
                popupWindow.showAtLocation(popupView, Gravity.CENTER, 0, 0);

                PackageManager manager0;
                final List<AppDetail> apps0;

                manager0=getPackageManager();
                apps0=new ArrayList<AppDetail>();
                Intent i0=new Intent(Intent.ACTION_MAIN,null);
                i0.addCategory(Intent.CATEGORY_LAUNCHER);

                List<ResolveInfo> availableActivities0=manager.queryIntentActivities(i0,0);
                Collections.sort(availableActivities0, new ResolveInfo.DisplayNameComparator(manager));

                for (ResolveInfo ri:availableActivities0){
                    AppDetail app=new AppDetail();
                    app.label=ri.loadLabel(manager);
                    app.name=ri.activityInfo.packageName;
                    app.icon=ri.activityInfo.loadIcon(manager);
                    apps0.add(app);
                }

                GridView grid;

                grid=(GridView)popupView.findViewById(R.id.apps_grid);

                ArrayAdapter<AppDetail> adapter=new ArrayAdapter<AppDetail>(ConfigureActivity.this,R.layout.activity_apps_grid ,apps0){
                    public View getView(int position,View convertView, ViewGroup parent){
                        if(convertView==null){
                            convertView=getLayoutInflater().inflate(R.layout.grid_item,null);
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
                        icon[7]=apps0.get(position).icon;
                        packageName[7]=apps0.get(position).name.toString();
                        SharedPreferences.Editor editor=sharedpreferences.edit();
                        editor.putString(package_order7,packageName[7]);


                        editor.putInt(icon_order7,position);

                        editor.commit();
                   /*     if (RunActivity.flag1==1){

                            RunActivity.editor1.putInt(RunActivity.icon_orderr3,sharedpreferences.getInt(icon_order7,0));
                            RunActivity.editor1.putString(RunActivity.package_orderr3,packageName[7]);

                            RunActivity.button4.setBackground(icon[sharedpreferences.getInt(icon_order7,0)]);
                            RunActivity.editor1.commit();
                        }*/
                        btn7.setBackground(icon[7]);
                        name7.setText(apps0.get(position).label);
                        popupWindow.dismiss();
                    }
                });


                return true;


            }
        });

        btn8.setOnLongClickListener(new Button.OnLongClickListener(){
            public boolean onLongClick(View v){
                LayoutInflater layoutInflater
                        = (LayoutInflater)getBaseContext()
                        .getSystemService(LAYOUT_INFLATER_SERVICE);
                final View popupView = layoutInflater.inflate(R.layout.activity_apps_grid, null);
                final PopupWindow popupWindow = new PopupWindow(
                        popupView,
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT,true);
                popupWindow.showAtLocation(popupView, Gravity.CENTER, 0, 0);

                PackageManager manager0;
                final List<AppDetail> apps0;

                manager0=getPackageManager();
                apps0=new ArrayList<AppDetail>();
                Intent i0=new Intent(Intent.ACTION_MAIN,null);
                i0.addCategory(Intent.CATEGORY_LAUNCHER);

                List<ResolveInfo> availableActivities0=manager.queryIntentActivities(i0,0);
                Collections.sort(availableActivities0, new ResolveInfo.DisplayNameComparator(manager));

                for (ResolveInfo ri:availableActivities0){
                    AppDetail app=new AppDetail();
                    app.label=ri.loadLabel(manager);
                    app.name=ri.activityInfo.packageName;
                    app.icon=ri.activityInfo.loadIcon(manager);
                    apps0.add(app);
                }

                GridView grid;

                grid=(GridView)popupView.findViewById(R.id.apps_grid);

                ArrayAdapter<AppDetail> adapter=new ArrayAdapter<AppDetail>(ConfigureActivity.this,R.layout.activity_apps_grid ,apps0){
                    public View getView(int position,View convertView, ViewGroup parent){
                        if(convertView==null){
                            convertView=getLayoutInflater().inflate(R.layout.grid_item,null);
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
                        icon[8]=apps0.get(position).icon;
                        packageName[8]=apps0.get(position).name.toString();
                        SharedPreferences.Editor editor=sharedpreferences.edit();
                        editor.putString(package_order8,packageName[8]);


                        editor.putInt(icon_order8,position);

                        editor.commit();
                       /* if (RunActivity.flag1==2){
                            RunActivity.editor1.putInt(RunActivity.icon_orderr0,sharedpreferences.getInt(icon_order8,0));
                            RunActivity.editor1.putString(RunActivity.package_orderr0,packageName[8]);

                            RunActivity.button1.setBackground(icon[sharedpreferences.getInt(icon_order8,0)]);

                            RunActivity.editor1.commit();
                        }*/
                        btn8.setBackground(icon[8]);
                        name8.setText(apps0.get(position).label);
                        popupWindow.dismiss();
                    }
                });


                return true;


            }
        });

        btn9.setOnLongClickListener(new Button.OnLongClickListener(){
            public boolean onLongClick(View v){
                LayoutInflater layoutInflater
                        = (LayoutInflater)getBaseContext()
                        .getSystemService(LAYOUT_INFLATER_SERVICE);
                final View popupView = layoutInflater.inflate(R.layout.activity_apps_grid, null);
                final PopupWindow popupWindow = new PopupWindow(
                        popupView,
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT,true);
                popupWindow.showAtLocation(popupView, Gravity.CENTER, 0, 0);

                PackageManager manager0;
                final List<AppDetail> apps0;

                manager0=getPackageManager();
                apps0=new ArrayList<AppDetail>();
                Intent i0=new Intent(Intent.ACTION_MAIN,null);
                i0.addCategory(Intent.CATEGORY_LAUNCHER);

                List<ResolveInfo> availableActivities0=manager.queryIntentActivities(i0,0);
                Collections.sort(availableActivities0, new ResolveInfo.DisplayNameComparator(manager));

                for (ResolveInfo ri:availableActivities0){
                    AppDetail app=new AppDetail();
                    app.label=ri.loadLabel(manager);
                    app.name=ri.activityInfo.packageName;
                    app.icon=ri.activityInfo.loadIcon(manager);
                    apps0.add(app);
                }

                GridView grid;

                grid=(GridView)popupView.findViewById(R.id.apps_grid);

                ArrayAdapter<AppDetail> adapter=new ArrayAdapter<AppDetail>(ConfigureActivity.this,R.layout.activity_apps_grid ,apps0){
                    public View getView(int position,View convertView, ViewGroup parent){
                        if(convertView==null){
                            convertView=getLayoutInflater().inflate(R.layout.grid_item,null);
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
                        icon[9]=apps0.get(position).icon;
                        packageName[9]=apps0.get(position).name.toString();
                        SharedPreferences.Editor editor=sharedpreferences.edit();
                        editor.putString(package_order9,packageName[9]);


                        editor.putInt(icon_order9,position);

                        editor.commit();
                    /*    if (RunActivity.flag1==2){

                            RunActivity.editor1.putInt(RunActivity.icon_orderr1,sharedpreferences.getInt(icon_order9,0));
                            RunActivity.editor1.putString(RunActivity.package_orderr1,packageName[9]);

                            RunActivity.button2.setBackground(icon[sharedpreferences.getInt(icon_order9,0)]);

                            RunActivity.editor1.commit();
                        }*/
                        btn9.setBackground(icon[9]);
                        name9.setText(apps0.get(position).label);
                        popupWindow.dismiss();
                    }
                });


                return true;


            }
        });

        btn10.setOnLongClickListener(new Button.OnLongClickListener(){
            public boolean onLongClick(View v){
                LayoutInflater layoutInflater
                        = (LayoutInflater)getBaseContext()
                        .getSystemService(LAYOUT_INFLATER_SERVICE);
                final View popupView = layoutInflater.inflate(R.layout.activity_apps_grid, null);
                final PopupWindow popupWindow = new PopupWindow(
                        popupView,
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT,true);
                popupWindow.showAtLocation(popupView, Gravity.CENTER, 0, 0);

                PackageManager manager0;
                final List<AppDetail> apps0;

                manager0=getPackageManager();
                apps0=new ArrayList<AppDetail>();
                Intent i0=new Intent(Intent.ACTION_MAIN,null);
                i0.addCategory(Intent.CATEGORY_LAUNCHER);

                List<ResolveInfo> availableActivities0=manager.queryIntentActivities(i0,0);

                Collections.sort(availableActivities0, new ResolveInfo.DisplayNameComparator(manager));

                for (ResolveInfo ri:availableActivities0){
                    AppDetail app=new AppDetail();
                    app.label=ri.loadLabel(manager);
                    app.name=ri.activityInfo.packageName;
                    app.icon=ri.activityInfo.loadIcon(manager);
                    apps0.add(app);
                }

                GridView grid;

                grid=(GridView)popupView.findViewById(R.id.apps_grid);

                ArrayAdapter<AppDetail> adapter=new ArrayAdapter<AppDetail>(ConfigureActivity.this,R.layout.activity_apps_grid ,apps0){
                    public View getView(int position,View convertView, ViewGroup parent){
                        if(convertView==null){
                            convertView=getLayoutInflater().inflate(R.layout.grid_item,null);
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
                        icon[10]=apps0.get(position).icon;
                        packageName[10]=apps0.get(position).name.toString();
                        SharedPreferences.Editor editor=sharedpreferences.edit();
                        editor.putString(package_order10,packageName[10]);


                        editor.putInt(icon_order10,position);

                        editor.commit();
                     /*   if (RunActivity.flag1==2){

                            RunActivity.editor1.putInt(RunActivity.icon_orderr2,sharedpreferences.getInt(icon_order10,0));
                            RunActivity.editor1.putString(RunActivity.package_orderr2,packageName[10]);

                            RunActivity.button3.setBackground(icon[sharedpreferences.getInt(icon_order10,0)]);

                            RunActivity.editor1.commit();
                        }*/
                        btn10.setBackground(icon[10]);
                        name10.setText(apps0.get(position).label);
                        popupWindow.dismiss();
                    }
                });


                return true;


            }
        });

        btn11.setOnLongClickListener(new Button.OnLongClickListener(){
            public boolean onLongClick(View v){
                LayoutInflater layoutInflater
                        = (LayoutInflater)getBaseContext()
                        .getSystemService(LAYOUT_INFLATER_SERVICE);
                final View popupView = layoutInflater.inflate(R.layout.activity_apps_grid, null);
                final PopupWindow popupWindow = new PopupWindow(
                        popupView,
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT,true);
                popupWindow.showAtLocation(popupView, Gravity.CENTER, 0, 0);

                PackageManager manager0;
                final List<AppDetail> apps0;

                manager0=getPackageManager();
                apps0=new ArrayList<AppDetail>();
                Intent i0=new Intent(Intent.ACTION_MAIN,null);
                i0.addCategory(Intent.CATEGORY_LAUNCHER);

                List<ResolveInfo> availableActivities0=manager.queryIntentActivities(i0,0);
                Collections.sort(availableActivities0, new ResolveInfo.DisplayNameComparator(manager));

                for (ResolveInfo ri:availableActivities0){
                    AppDetail app=new AppDetail();
                    app.label=ri.loadLabel(manager);
                    app.name=ri.activityInfo.packageName;
                    app.icon=ri.activityInfo.loadIcon(manager);
                    apps0.add(app);
                }

                GridView grid;

                grid=(GridView)popupView.findViewById(R.id.apps_grid);

                ArrayAdapter<AppDetail> adapter=new ArrayAdapter<AppDetail>(ConfigureActivity.this,R.layout.activity_apps_grid ,apps0){
                    public View getView(int position,View convertView, ViewGroup parent){
                        if(convertView==null){
                            convertView=getLayoutInflater().inflate(R.layout.grid_item,null);
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
                        icon[11]=apps0.get(position).icon;
                        packageName[11]=apps0.get(position).name.toString();
                        SharedPreferences.Editor editor=sharedpreferences.edit();
                        editor.putString(package_order11,packageName[11]);


                        editor.putInt(icon_order11,position);

                        editor.commit();
                   /*     if (RunActivity.flag1==2){

                            RunActivity.editor1.putInt(RunActivity.icon_orderr3,sharedpreferences.getInt(icon_order11,0));
                            RunActivity.editor1.putString(RunActivity.package_orderr3,packageName[11]);

                            RunActivity.button4.setBackground(icon[sharedpreferences.getInt(icon_order11,0)]);
                            RunActivity.editor1.commit();
                        }*/
                        btn11.setBackground(icon[11]);
                        name11.setText(apps0.get(position).label);
                        popupWindow.dismiss();
                    }
                });


                return true;


            }
        });

        btn12.setOnLongClickListener(new Button.OnLongClickListener(){
            public boolean onLongClick(View v){
                LayoutInflater layoutInflater
                        = (LayoutInflater)getBaseContext()
                        .getSystemService(LAYOUT_INFLATER_SERVICE);
                final View popupView = layoutInflater.inflate(R.layout.activity_apps_grid, null);
                final PopupWindow popupWindow = new PopupWindow(
                        popupView,
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT,true);
                popupWindow.showAtLocation(popupView, Gravity.CENTER, 0, 0);

                PackageManager manager0;
                final List<AppDetail> apps0;

                manager0=getPackageManager();
                apps0=new ArrayList<AppDetail>();
                Intent i0=new Intent(Intent.ACTION_MAIN,null);
                i0.addCategory(Intent.CATEGORY_LAUNCHER);

                List<ResolveInfo> availableActivities0=manager.queryIntentActivities(i0,0);
                Collections.sort(availableActivities0, new ResolveInfo.DisplayNameComparator(manager));

                for (ResolveInfo ri:availableActivities0){
                    AppDetail app=new AppDetail();
                    app.label=ri.loadLabel(manager);
                    app.name=ri.activityInfo.packageName;
                    app.icon=ri.activityInfo.loadIcon(manager);
                    apps0.add(app);
                }

                GridView grid;

                grid=(GridView)popupView.findViewById(R.id.apps_grid);

                ArrayAdapter<AppDetail> adapter=new ArrayAdapter<AppDetail>(ConfigureActivity.this,R.layout.activity_apps_grid ,apps0){
                    public View getView(int position,View convertView, ViewGroup parent){
                        if(convertView==null){
                            convertView=getLayoutInflater().inflate(R.layout.grid_item,null);
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
                        icon[12]=apps0.get(position).icon;
                        packageName[12]=apps0.get(position).name.toString();
                        SharedPreferences.Editor editor=sharedpreferences.edit();
                        editor.putString(package_order12,packageName[12]);


                        editor.putInt(icon_order12,position);

                        editor.commit();
                   /*     if (RunActivity.flag1==3){
                            RunActivity.editor1.putInt(RunActivity.icon_orderr0,sharedpreferences.getInt(icon_order12,0));
                            RunActivity.editor1.putString(RunActivity.package_orderr0,packageName[12]);

                            RunActivity.button1.setBackground(icon[sharedpreferences.getInt(icon_order12,0)]);

                            RunActivity.editor1.commit();
                        }*/
                        btn12.setBackground(icon[12]);
                        name12.setText(apps0.get(position).label);
                        popupWindow.dismiss();
                    }
                });


                return true;


            }
        });

        btn13.setOnLongClickListener(new Button.OnLongClickListener(){
            public boolean onLongClick(View v){
                LayoutInflater layoutInflater
                        = (LayoutInflater)getBaseContext()
                        .getSystemService(LAYOUT_INFLATER_SERVICE);
                final View popupView = layoutInflater.inflate(R.layout.activity_apps_grid, null);
                final PopupWindow popupWindow = new PopupWindow(
                        popupView,
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT,true);
                popupWindow.showAtLocation(popupView, Gravity.CENTER, 0, 0);

                PackageManager manager0;
                final List<AppDetail> apps0;

                manager0=getPackageManager();
                apps0=new ArrayList<AppDetail>();
                Intent i0=new Intent(Intent.ACTION_MAIN,null);
                i0.addCategory(Intent.CATEGORY_LAUNCHER);

                List<ResolveInfo> availableActivities0=manager.queryIntentActivities(i0,0);
                Collections.sort(availableActivities0, new ResolveInfo.DisplayNameComparator(manager));

                for (ResolveInfo ri:availableActivities0){
                    AppDetail app=new AppDetail();
                    app.label=ri.loadLabel(manager);
                    app.name=ri.activityInfo.packageName;
                    app.icon=ri.activityInfo.loadIcon(manager);
                    apps0.add(app);
                }

                GridView grid;

                grid=(GridView)popupView.findViewById(R.id.apps_grid);

                ArrayAdapter<AppDetail> adapter=new ArrayAdapter<AppDetail>(ConfigureActivity.this,R.layout.activity_apps_grid ,apps0){
                    public View getView(int position,View convertView, ViewGroup parent){
                        if(convertView==null){
                            convertView=getLayoutInflater().inflate(R.layout.grid_item,null);
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
                        icon[13]=apps0.get(position).icon;
                        packageName[13]=apps0.get(position).name.toString();
                        SharedPreferences.Editor editor=sharedpreferences.edit();
                        editor.putString(package_order13,packageName[13]);


                        editor.putInt(icon_order13,position);

                        editor.commit();
                   /*     if (RunActivity.flag1==3){

                            RunActivity.editor1.putInt(RunActivity.icon_orderr1,sharedpreferences.getInt(icon_order13,0));
                            RunActivity.editor1.putString(RunActivity.package_orderr1,packageName[13]);

                            RunActivity.button2.setBackground(icon[sharedpreferences.getInt(icon_order13,0)]);

                            RunActivity.editor1.commit();
                        }*/
                        btn13.setBackground(icon[13]);
                        name13.setText(apps0.get(position).label);
                        popupWindow.dismiss();
                    }
                });


                return true;


            }
        });

        btn14.setOnLongClickListener(new Button.OnLongClickListener(){
            public boolean onLongClick(View v){
                LayoutInflater layoutInflater
                        = (LayoutInflater)getBaseContext()
                        .getSystemService(LAYOUT_INFLATER_SERVICE);
                final View popupView = layoutInflater.inflate(R.layout.activity_apps_grid, null);
                final PopupWindow popupWindow = new PopupWindow(
                        popupView,
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT,true);
                popupWindow.showAtLocation(popupView, Gravity.CENTER, 0, 0);

                PackageManager manager0;
                final List<AppDetail> apps0;

                manager0=getPackageManager();
                apps0=new ArrayList<AppDetail>();
                Intent i0=new Intent(Intent.ACTION_MAIN,null);
                i0.addCategory(Intent.CATEGORY_LAUNCHER);

                List<ResolveInfo> availableActivities0=manager.queryIntentActivities(i0,0);
                Collections.sort(availableActivities0, new ResolveInfo.DisplayNameComparator(manager));

                for (ResolveInfo ri:availableActivities0){
                    AppDetail app=new AppDetail();
                    app.label=ri.loadLabel(manager);
                    app.name=ri.activityInfo.packageName;
                    app.icon=ri.activityInfo.loadIcon(manager);
                    apps0.add(app);
                }

                GridView grid;

                grid=(GridView)popupView.findViewById(R.id.apps_grid);

                ArrayAdapter<AppDetail> adapter=new ArrayAdapter<AppDetail>(ConfigureActivity.this,R.layout.activity_apps_grid ,apps0){
                    public View getView(int position,View convertView, ViewGroup parent){
                        if(convertView==null){
                            convertView=getLayoutInflater().inflate(R.layout.grid_item,null);
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
                        icon[14]=apps0.get(position).icon;
                        packageName[14]=apps0.get(position).name.toString();
                        SharedPreferences.Editor editor=sharedpreferences.edit();
                        editor.putString(package_order14,packageName[14]);


                        editor.putInt(icon_order14,position);

                        editor.commit();
                    /*    if (RunActivity.flag1==3){

                            RunActivity.editor1.putInt(RunActivity.icon_orderr2,sharedpreferences.getInt(icon_order14,0));
                            RunActivity.editor1.putString(RunActivity.package_orderr2,packageName[14]);

                            RunActivity.button3.setBackground(icon[sharedpreferences.getInt(icon_order14,0)]);

                            RunActivity.editor1.commit();
                        }*/
                        btn14.setBackground(icon[14]);
                        name14.setText(apps0.get(position).label);
                        popupWindow.dismiss();
                    }
                });


                return true;


            }
        });

        btn15.setOnLongClickListener(new Button.OnLongClickListener(){
            public boolean onLongClick(View v){
                LayoutInflater layoutInflater
                        = (LayoutInflater)getBaseContext()
                        .getSystemService(LAYOUT_INFLATER_SERVICE);
                final View popupView = layoutInflater.inflate(R.layout.activity_apps_grid, null);
                final PopupWindow popupWindow = new PopupWindow(
                        popupView,
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT,true);
                popupWindow.showAtLocation(popupView, Gravity.CENTER, 0, 0);

                PackageManager manager0;
                final List<AppDetail> apps0;

                manager0=getPackageManager();
                apps0=new ArrayList<AppDetail>();
                Intent i0=new Intent(Intent.ACTION_MAIN,null);
                i0.addCategory(Intent.CATEGORY_LAUNCHER);

                List<ResolveInfo> availableActivities0=manager.queryIntentActivities(i0,0);
                Collections.sort(availableActivities0, new ResolveInfo.DisplayNameComparator(manager));

                for (ResolveInfo ri:availableActivities0){
                    AppDetail app=new AppDetail();
                    app.label=ri.loadLabel(manager);
                    app.name=ri.activityInfo.packageName;
                    app.icon=ri.activityInfo.loadIcon(manager);
                    apps0.add(app);
                }

                GridView grid;

                grid=(GridView)popupView.findViewById(R.id.apps_grid);

                ArrayAdapter<AppDetail> adapter=new ArrayAdapter<AppDetail>(ConfigureActivity.this,R.layout.activity_apps_grid ,apps0){
                    public View getView(int position,View convertView, ViewGroup parent){
                        if(convertView==null){
                            convertView=getLayoutInflater().inflate(R.layout.grid_item,null);
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
                        icon[15]=apps0.get(position).icon;
                        packageName[15]=apps0.get(position).name.toString();
                        SharedPreferences.Editor editor=sharedpreferences.edit();
                        editor.putString(package_order15,packageName[15]);


                        editor.putInt(icon_order15,position);

                        editor.commit();
                  /*      if (RunActivity.flag1==3){

                            RunActivity.editor1.putInt(RunActivity.icon_orderr3,sharedpreferences.getInt(icon_order15,0));
                            RunActivity.editor1.putString(RunActivity.package_orderr3,packageName[15]);

                            RunActivity.button4.setBackground(icon[sharedpreferences.getInt(icon_order15,0)]);
                            RunActivity.editor1.commit();
                        }*/

                        btn15.setBackground(icon[15]);
                        name15.setText(apps0.get(position).label);
                        popupWindow.dismiss();
                    }
                });


                return true;


            }
        });

        tab1.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                pName1=sharedpreferences.getString(package_order0,"com.android.mms");
                pName2=sharedpreferences.getString(package_order1,"com.android.mms");
                pName3=sharedpreferences.getString(package_order2,"com.android.mms");
                pName4=sharedpreferences.getString(package_order3,"com.android.mms");

                RunActivity.editor1.putInt(RunActivity.icon_orderr0,sharedpreferences.getInt(icon_order0,0));
                RunActivity.editor1.putString(RunActivity.package_orderr0,pName1);
                RunActivity.editor1.putInt(RunActivity.icon_orderr1,sharedpreferences.getInt(icon_order1,0));
                RunActivity.editor1.putString(RunActivity.package_orderr1,pName2);
                RunActivity.editor1.putInt(RunActivity.icon_orderr2,sharedpreferences.getInt(icon_order2,0));
                RunActivity.editor1.putString(RunActivity.package_orderr2,pName3);
                RunActivity.editor1.putInt(RunActivity.icon_orderr3,sharedpreferences.getInt(icon_order3,0));
                RunActivity.editor1.putString(RunActivity.package_orderr3,pName4);
                RunActivity.button1.setBackground(icon[sharedpreferences.getInt(icon_order0,0)]);
                RunActivity.button2.setBackground(icon[sharedpreferences.getInt(icon_order1,0)]);
                RunActivity.button3.setBackground(icon[sharedpreferences.getInt(icon_order2,0)]);
                RunActivity.button4.setBackground(icon[sharedpreferences.getInt(icon_order3,0)]);
                RunActivity.editor1.putInt(RunActivity.flag1,0);
                RunActivity.editor1.commit();

                RunActivity.flag=0;
                Intent startMain=new Intent(Intent.ACTION_MAIN);
                startMain.addCategory(Intent.CATEGORY_HOME);
                startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(startMain);
               // RunActivity.flag1=0;
            }});

        btn1.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                pName1=sharedpreferences.getString(package_order0,"com.android.mms");
                pName2=sharedpreferences.getString(package_order1,"com.android.mms");
                pName3=sharedpreferences.getString(package_order2,"com.android.mms");
                pName4=sharedpreferences.getString(package_order3,"com.android.mms");

                RunActivity.editor1.putInt(RunActivity.icon_orderr0,sharedpreferences.getInt(icon_order0,0));
                RunActivity.editor1.putString(RunActivity.package_orderr0,pName1);
                RunActivity.editor1.putInt(RunActivity.icon_orderr1,sharedpreferences.getInt(icon_order1,0));
                RunActivity.editor1.putString(RunActivity.package_orderr1,pName2);
                RunActivity.editor1.putInt(RunActivity.icon_orderr2,sharedpreferences.getInt(icon_order2,0));
                RunActivity.editor1.putString(RunActivity.package_orderr2,pName3);
                RunActivity.editor1.putInt(RunActivity.icon_orderr3,sharedpreferences.getInt(icon_order3,0));
                RunActivity.editor1.putString(RunActivity.package_orderr3,pName4);
                RunActivity.button1.setBackground(icon[sharedpreferences.getInt(icon_order0,0)]);
                RunActivity.button2.setBackground(icon[sharedpreferences.getInt(icon_order1,0)]);
                RunActivity.button3.setBackground(icon[sharedpreferences.getInt(icon_order2,0)]);
                RunActivity.button4.setBackground(icon[sharedpreferences.getInt(icon_order3,0)]);
                RunActivity.editor1.putInt(RunActivity.flag1,0);
                RunActivity.editor1.commit();

                Intent intent1=getPackageManager().getLaunchIntentForPackage(ConfigureActivity.pName2);
                startActivity(intent1);
                RunActivity.flag=1;
              //  RunActivity.flag1=0;
            }});
        btn2.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                pName1=sharedpreferences.getString(package_order0,"com.android.mms");
                pName2=sharedpreferences.getString(package_order1,"com.android.mms");
                pName3=sharedpreferences.getString(package_order2,"com.android.mms");
                pName4=sharedpreferences.getString(package_order3,"com.android.mms");

                RunActivity.editor1.putInt(RunActivity.icon_orderr0,sharedpreferences.getInt(icon_order0,0));
                RunActivity.editor1.putString(RunActivity.package_orderr0,pName1);
                RunActivity.editor1.putInt(RunActivity.icon_orderr1,sharedpreferences.getInt(icon_order1,0));
                RunActivity.editor1.putString(RunActivity.package_orderr1,pName2);
                RunActivity.editor1.putInt(RunActivity.icon_orderr2,sharedpreferences.getInt(icon_order2,0));
                RunActivity.editor1.putString(RunActivity.package_orderr2,pName3);
                RunActivity.editor1.putInt(RunActivity.icon_orderr3,sharedpreferences.getInt(icon_order3,0));
                RunActivity.editor1.putString(RunActivity.package_orderr3,pName4);
                RunActivity.button1.setBackground(icon[sharedpreferences.getInt(icon_order0,0)]);
                RunActivity.button2.setBackground(icon[sharedpreferences.getInt(icon_order1,0)]);
                RunActivity.button3.setBackground(icon[sharedpreferences.getInt(icon_order2,0)]);
                RunActivity.button4.setBackground(icon[sharedpreferences.getInt(icon_order3,0)]);
                RunActivity.editor1.putInt(RunActivity.flag1,0);
                RunActivity.editor1.commit();

                Intent intent1=getPackageManager().getLaunchIntentForPackage(ConfigureActivity.pName3);
                startActivity(intent1);
                RunActivity.flag=2;
               // RunActivity.flag1=0;
            }});
        btn3.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                pName1=sharedpreferences.getString(package_order0,"com.android.mms");
                pName2=sharedpreferences.getString(package_order1,"com.android.mms");
                pName3=sharedpreferences.getString(package_order2,"com.android.mms");
                pName4=sharedpreferences.getString(package_order3,"com.android.mms");

                RunActivity.editor1.putInt(RunActivity.icon_orderr0,sharedpreferences.getInt(icon_order0,0));
                RunActivity.editor1.putString(RunActivity.package_orderr0,pName1);
                RunActivity.editor1.putInt(RunActivity.icon_orderr1,sharedpreferences.getInt(icon_order1,0));
                RunActivity.editor1.putString(RunActivity.package_orderr1,pName2);
                RunActivity.editor1.putInt(RunActivity.icon_orderr2,sharedpreferences.getInt(icon_order2,0));
                RunActivity.editor1.putString(RunActivity.package_orderr2,pName3);
                RunActivity.editor1.putInt(RunActivity.icon_orderr3,sharedpreferences.getInt(icon_order3,0));
                RunActivity.editor1.putString(RunActivity.package_orderr3,pName4);
                RunActivity.button1.setBackground(icon[sharedpreferences.getInt(icon_order0,0)]);
                RunActivity.button2.setBackground(icon[sharedpreferences.getInt(icon_order1,0)]);
                RunActivity.button3.setBackground(icon[sharedpreferences.getInt(icon_order2,0)]);
                RunActivity.button4.setBackground(icon[sharedpreferences.getInt(icon_order3,0)]);
                RunActivity.editor1.putInt(RunActivity.flag1,0);
                RunActivity.editor1.commit();

                Intent intent1=getPackageManager().getLaunchIntentForPackage(ConfigureActivity.pName4);
                startActivity(intent1);
                RunActivity.flag=3;
             //   RunActivity.flag1=0;
            }});
        btn4.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                pName1=sharedpreferences.getString(package_order4,"com.android.mms");
                pName2=sharedpreferences.getString(package_order5,"com.android.mms");
                pName3=sharedpreferences.getString(package_order6,"com.android.mms");
                pName4=sharedpreferences.getString(package_order7,"com.android.mms");

                RunActivity.editor1.putInt(RunActivity.icon_orderr0,sharedpreferences.getInt(icon_order4,0));
                RunActivity.editor1.putString(RunActivity.package_orderr0,pName1);
                RunActivity.editor1.putInt(RunActivity.icon_orderr1,sharedpreferences.getInt(icon_order5,0));
                RunActivity.editor1.putString(RunActivity.package_orderr1,pName2);
                RunActivity.editor1.putInt(RunActivity.icon_orderr2,sharedpreferences.getInt(icon_order6,0));
                RunActivity.editor1.putString(RunActivity.package_orderr2,pName3);
                RunActivity.editor1.putInt(RunActivity.icon_orderr3,sharedpreferences.getInt(icon_order7,0));
                RunActivity.editor1.putString(RunActivity.package_orderr3,pName4);
                RunActivity.button1.setBackground(icon[sharedpreferences.getInt(icon_order4,0)]);
                RunActivity.button2.setBackground(icon[sharedpreferences.getInt(icon_order5,0)]);
                RunActivity.button3.setBackground(icon[sharedpreferences.getInt(icon_order6,0)]);
                RunActivity.button4.setBackground(icon[sharedpreferences.getInt(icon_order7,0)]);
                RunActivity.editor1.putInt(RunActivity.flag1,1);

                RunActivity.editor1.commit();
                Intent intent1=getPackageManager().getLaunchIntentForPackage(ConfigureActivity.pName1);
                startActivity(intent1);
                RunActivity.flag=4;
              //  RunActivity.flag1=1;
            }});

        tab2.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                pName1=sharedpreferences.getString(package_order4,"com.android.mms");
                pName2=sharedpreferences.getString(package_order5,"com.android.mms");
                pName3=sharedpreferences.getString(package_order6,"com.android.mms");
                pName4=sharedpreferences.getString(package_order7,"com.android.mms");

                RunActivity.editor1.putInt(RunActivity.icon_orderr0,sharedpreferences.getInt(icon_order4,0));
                RunActivity.editor1.putString(RunActivity.package_orderr0,pName1);
                RunActivity.editor1.putInt(RunActivity.icon_orderr1,sharedpreferences.getInt(icon_order5,0));
                RunActivity.editor1.putString(RunActivity.package_orderr1,pName2);
                RunActivity.editor1.putInt(RunActivity.icon_orderr2,sharedpreferences.getInt(icon_order6,0));
                RunActivity.editor1.putString(RunActivity.package_orderr2,pName3);
                RunActivity.editor1.putInt(RunActivity.icon_orderr3,sharedpreferences.getInt(icon_order7,0));
                RunActivity.editor1.putString(RunActivity.package_orderr3,pName4);
                RunActivity.button1.setBackground(icon[sharedpreferences.getInt(icon_order4,0)]);
                RunActivity.button2.setBackground(icon[sharedpreferences.getInt(icon_order5,0)]);
                RunActivity.button3.setBackground(icon[sharedpreferences.getInt(icon_order6,0)]);
                RunActivity.button4.setBackground(icon[sharedpreferences.getInt(icon_order7,0)]);
                RunActivity.editor1.putInt(RunActivity.flag1,1);

                RunActivity.editor1.commit();

                RunActivity.flag=4;
                Intent startMain=new Intent(Intent.ACTION_MAIN);
                startMain.addCategory(Intent.CATEGORY_HOME);
                startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(startMain);
          //      RunActivity.flag1=1;
            }});

        btn5.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                pName1=sharedpreferences.getString(package_order4,"com.android.mms");
                pName2=sharedpreferences.getString(package_order5,"com.android.mms");
                pName3=sharedpreferences.getString(package_order6,"com.android.mms");
                pName4=sharedpreferences.getString(package_order7,"com.android.mms");

                RunActivity.editor1.putInt(RunActivity.icon_orderr0,sharedpreferences.getInt(icon_order4,0));
                RunActivity.editor1.putString(RunActivity.package_orderr0,pName1);
                RunActivity.editor1.putInt(RunActivity.icon_orderr1,sharedpreferences.getInt(icon_order5,0));
                RunActivity.editor1.putString(RunActivity.package_orderr1,pName2);
                RunActivity.editor1.putInt(RunActivity.icon_orderr2,sharedpreferences.getInt(icon_order6,0));
                RunActivity.editor1.putString(RunActivity.package_orderr2,pName3);
                RunActivity.editor1.putInt(RunActivity.icon_orderr3,sharedpreferences.getInt(icon_order7,0));
                RunActivity.editor1.putString(RunActivity.package_orderr3,pName4);
                RunActivity.button1.setBackground(icon[sharedpreferences.getInt(icon_order4,0)]);
                RunActivity.button2.setBackground(icon[sharedpreferences.getInt(icon_order5,0)]);
                RunActivity.button3.setBackground(icon[sharedpreferences.getInt(icon_order6,0)]);
                RunActivity.button4.setBackground(icon[sharedpreferences.getInt(icon_order7,0)]);
                RunActivity.editor1.putInt(RunActivity.flag1,1);

                RunActivity.editor1.commit();
                Intent intent1=getPackageManager().getLaunchIntentForPackage(ConfigureActivity.pName2);
                startActivity(intent1);
                RunActivity.flag=5;
              // RunActivity.flag1=1;
            }});
        btn6.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                pName1=sharedpreferences.getString(package_order4,"com.android.mms");
                pName2=sharedpreferences.getString(package_order5,"com.android.mms");
                pName3=sharedpreferences.getString(package_order6,"com.android.mms");
                pName4=sharedpreferences.getString(package_order7,"com.android.mms");

                RunActivity.editor1.putInt(RunActivity.icon_orderr0,sharedpreferences.getInt(icon_order4,0));
                RunActivity.editor1.putString(RunActivity.package_orderr0,pName1);
                RunActivity.editor1.putInt(RunActivity.icon_orderr1,sharedpreferences.getInt(icon_order5,0));
                RunActivity.editor1.putString(RunActivity.package_orderr1,pName2);
                RunActivity.editor1.putInt(RunActivity.icon_orderr2,sharedpreferences.getInt(icon_order6,0));
                RunActivity.editor1.putString(RunActivity.package_orderr2,pName3);
                RunActivity.editor1.putInt(RunActivity.icon_orderr3,sharedpreferences.getInt(icon_order7,0));
                RunActivity.editor1.putString(RunActivity.package_orderr3,pName4);
                RunActivity.button1.setBackground(icon[sharedpreferences.getInt(icon_order4,0)]);
                RunActivity.button2.setBackground(icon[sharedpreferences.getInt(icon_order5,0)]);
                RunActivity.button3.setBackground(icon[sharedpreferences.getInt(icon_order6,0)]);
                RunActivity.button4.setBackground(icon[sharedpreferences.getInt(icon_order7,0)]);
                RunActivity.editor1.putInt(RunActivity.flag1,1);

                RunActivity.editor1.commit();
                Intent intent1=getPackageManager().getLaunchIntentForPackage(ConfigureActivity.pName3);
                startActivity(intent1);
                RunActivity.flag=6;
              //  RunActivity.flag1=1;
            }});
        btn7.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                pName1=sharedpreferences.getString(package_order4,"com.android.mms");
                pName2=sharedpreferences.getString(package_order5,"com.android.mms");
                pName3=sharedpreferences.getString(package_order6,"com.android.mms");
                pName4=sharedpreferences.getString(package_order7,"com.android.mms");

                RunActivity.editor1.putInt(RunActivity.icon_orderr0,sharedpreferences.getInt(icon_order4,0));
                RunActivity.editor1.putString(RunActivity.package_orderr0,pName1);
                RunActivity.editor1.putInt(RunActivity.icon_orderr1,sharedpreferences.getInt(icon_order5,0));
                RunActivity.editor1.putString(RunActivity.package_orderr1,pName2);
                RunActivity.editor1.putInt(RunActivity.icon_orderr2,sharedpreferences.getInt(icon_order6,0));
                RunActivity.editor1.putString(RunActivity.package_orderr2,pName3);
                RunActivity.editor1.putInt(RunActivity.icon_orderr3,sharedpreferences.getInt(icon_order7,0));
                RunActivity.editor1.putString(RunActivity.package_orderr3,pName4);
                RunActivity.button1.setBackground(icon[sharedpreferences.getInt(icon_order4,0)]);
                RunActivity.button2.setBackground(icon[sharedpreferences.getInt(icon_order5,0)]);
                RunActivity.button3.setBackground(icon[sharedpreferences.getInt(icon_order6,0)]);
                RunActivity.button4.setBackground(icon[sharedpreferences.getInt(icon_order7,0)]);
                RunActivity.editor1.putInt(RunActivity.flag1,1);

                RunActivity.editor1.commit();
                Intent intent1=getPackageManager().getLaunchIntentForPackage(ConfigureActivity.pName4);
                startActivity(intent1);
                RunActivity.flag=7;
              //  RunActivity.flag1=1;
            }});
        btn8.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                pName1=sharedpreferences.getString(package_order8,"com.android.mms");
                pName2=sharedpreferences.getString(package_order9,"com.android.mms");
                pName3=sharedpreferences.getString(package_order10,"com.android.mms");
                pName4=sharedpreferences.getString(package_order11,"com.android.mms");

                RunActivity.editor1.putInt(RunActivity.icon_orderr0,sharedpreferences.getInt(icon_order8,0));
                RunActivity.editor1.putString(RunActivity.package_orderr0,pName1);
                RunActivity.editor1.putInt(RunActivity.icon_orderr1,sharedpreferences.getInt(icon_order9,0));
                RunActivity.editor1.putString(RunActivity.package_orderr1,pName2);
                RunActivity.editor1.putInt(RunActivity.icon_orderr2,sharedpreferences.getInt(icon_order10,0));
                RunActivity.editor1.putString(RunActivity.package_orderr2,pName3);
                RunActivity.editor1.putInt(RunActivity.icon_orderr3,sharedpreferences.getInt(icon_order11,0));
                RunActivity.editor1.putString(RunActivity.package_orderr3,pName4);
                RunActivity.button1.setBackground(icon[sharedpreferences.getInt(icon_order8,0)]);
                RunActivity.button2.setBackground(icon[sharedpreferences.getInt(icon_order9,0)]);
                RunActivity.button3.setBackground(icon[sharedpreferences.getInt(icon_order10,0)]);
                RunActivity.button4.setBackground(icon[sharedpreferences.getInt(icon_order11,0)]);
                RunActivity.editor1.putInt(RunActivity.flag1,2);

                RunActivity.editor1.commit();
                Intent intent1=getPackageManager().getLaunchIntentForPackage(ConfigureActivity.pName1);
                startActivity(intent1);
                RunActivity.flag=8;
                //RunActivity.flag1=2;
            }});

        tab3.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                pName1=sharedpreferences.getString(package_order8,"com.android.mms");
                pName2=sharedpreferences.getString(package_order9,"com.android.mms");
                pName3=sharedpreferences.getString(package_order10,"com.android.mms");
                pName4=sharedpreferences.getString(package_order11,"com.android.mms");

                RunActivity.editor1.putInt(RunActivity.icon_orderr0,sharedpreferences.getInt(icon_order8,0));
                RunActivity.editor1.putString(RunActivity.package_orderr0,pName1);
                RunActivity.editor1.putInt(RunActivity.icon_orderr1,sharedpreferences.getInt(icon_order9,0));
                RunActivity.editor1.putString(RunActivity.package_orderr1,pName2);
                RunActivity.editor1.putInt(RunActivity.icon_orderr2,sharedpreferences.getInt(icon_order10,0));
                RunActivity.editor1.putString(RunActivity.package_orderr2,pName3);
                RunActivity.editor1.putInt(RunActivity.icon_orderr3,sharedpreferences.getInt(icon_order11,0));
                RunActivity.editor1.putString(RunActivity.package_orderr3,pName4);
                RunActivity.button1.setBackground(icon[sharedpreferences.getInt(icon_order8,0)]);
                RunActivity.button2.setBackground(icon[sharedpreferences.getInt(icon_order9,0)]);
                RunActivity.button3.setBackground(icon[sharedpreferences.getInt(icon_order10,0)]);
                RunActivity.button4.setBackground(icon[sharedpreferences.getInt(icon_order11,0)]);
                RunActivity.editor1.putInt(RunActivity.flag1,2);

                RunActivity.editor1.commit();

                RunActivity.flag=8;
                Intent startMain=new Intent(Intent.ACTION_MAIN);
                startMain.addCategory(Intent.CATEGORY_HOME);
                startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(startMain);
            //    RunActivity.flag1=2;
            }});
        btn9.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                pName1=sharedpreferences.getString(package_order8,"com.android.mms");
                pName2=sharedpreferences.getString(package_order9,"com.android.mms");
                pName3=sharedpreferences.getString(package_order10,"com.android.mms");
                pName4=sharedpreferences.getString(package_order11,"com.android.mms");

                RunActivity.editor1.putInt(RunActivity.icon_orderr0,sharedpreferences.getInt(icon_order8,0));
                RunActivity.editor1.putString(RunActivity.package_orderr0,pName1);
                RunActivity.editor1.putInt(RunActivity.icon_orderr1,sharedpreferences.getInt(icon_order9,0));
                RunActivity.editor1.putString(RunActivity.package_orderr1,pName2);
                RunActivity.editor1.putInt(RunActivity.icon_orderr2,sharedpreferences.getInt(icon_order10,0));
                RunActivity.editor1.putString(RunActivity.package_orderr2,pName3);
                RunActivity.editor1.putInt(RunActivity.icon_orderr3,sharedpreferences.getInt(icon_order11,0));
                RunActivity.editor1.putString(RunActivity.package_orderr3,pName4);
                RunActivity.button1.setBackground(icon[sharedpreferences.getInt(icon_order8,0)]);
                RunActivity.button2.setBackground(icon[sharedpreferences.getInt(icon_order9,0)]);
                RunActivity.button3.setBackground(icon[sharedpreferences.getInt(icon_order10,0)]);
                RunActivity.button4.setBackground(icon[sharedpreferences.getInt(icon_order11,0)]);
                RunActivity.editor1.putInt(RunActivity.flag1,2);

                RunActivity.editor1.commit();
                Intent intent1=getPackageManager().getLaunchIntentForPackage(ConfigureActivity.pName2);
                startActivity(intent1);
                RunActivity.flag=9;
             //   RunActivity.flag1=2;
            }});
        btn10.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                pName1=sharedpreferences.getString(package_order8,"com.android.mms");
                pName2=sharedpreferences.getString(package_order9,"com.android.mms");
                pName3=sharedpreferences.getString(package_order10,"com.android.mms");
                pName4=sharedpreferences.getString(package_order11,"com.android.mms");

                RunActivity.editor1.putInt(RunActivity.icon_orderr0,sharedpreferences.getInt(icon_order8,0));
                RunActivity.editor1.putString(RunActivity.package_orderr0,pName1);
                RunActivity.editor1.putInt(RunActivity.icon_orderr1,sharedpreferences.getInt(icon_order9,0));
                RunActivity.editor1.putString(RunActivity.package_orderr1,pName2);
                RunActivity.editor1.putInt(RunActivity.icon_orderr2,sharedpreferences.getInt(icon_order10,0));
                RunActivity.editor1.putString(RunActivity.package_orderr2,pName3);
                RunActivity.editor1.putInt(RunActivity.icon_orderr3,sharedpreferences.getInt(icon_order11,0));
                RunActivity.editor1.putString(RunActivity.package_orderr3,pName4);
                RunActivity.button1.setBackground(icon[sharedpreferences.getInt(icon_order8,0)]);
                RunActivity.button2.setBackground(icon[sharedpreferences.getInt(icon_order9,0)]);
                RunActivity.button3.setBackground(icon[sharedpreferences.getInt(icon_order10,0)]);
                RunActivity.button4.setBackground(icon[sharedpreferences.getInt(icon_order11,0)]);
                RunActivity.editor1.putInt(RunActivity.flag1,2);

                RunActivity.editor1.commit();
                Intent intent1=getPackageManager().getLaunchIntentForPackage(ConfigureActivity.pName3);
                startActivity(intent1);
                RunActivity.flag=10;
             //   RunActivity.flag1=2;
            }});
        btn11.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                pName1=sharedpreferences.getString(package_order8,"com.android.mms");
                pName2=sharedpreferences.getString(package_order9,"com.android.mms");
                pName3=sharedpreferences.getString(package_order10,"com.android.mms");
                pName4=sharedpreferences.getString(package_order11,"com.android.mms");

                RunActivity.editor1.putInt(RunActivity.icon_orderr0,sharedpreferences.getInt(icon_order8,0));
                RunActivity.editor1.putString(RunActivity.package_orderr0,pName1);
                RunActivity.editor1.putInt(RunActivity.icon_orderr1,sharedpreferences.getInt(icon_order9,0));
                RunActivity.editor1.putString(RunActivity.package_orderr1,pName2);
                RunActivity.editor1.putInt(RunActivity.icon_orderr2,sharedpreferences.getInt(icon_order10,0));
                RunActivity.editor1.putString(RunActivity.package_orderr2,pName3);
                RunActivity.editor1.putInt(RunActivity.icon_orderr3,sharedpreferences.getInt(icon_order11,0));
                RunActivity.editor1.putString(RunActivity.package_orderr3,pName4);
                RunActivity.button1.setBackground(icon[sharedpreferences.getInt(icon_order8,0)]);
                RunActivity.button2.setBackground(icon[sharedpreferences.getInt(icon_order9,0)]);
                RunActivity.button3.setBackground(icon[sharedpreferences.getInt(icon_order10,0)]);
                RunActivity.button4.setBackground(icon[sharedpreferences.getInt(icon_order11,0)]);
                RunActivity.editor1.putInt(RunActivity.flag1,2);

                RunActivity.editor1.commit();
                Intent intent1=getPackageManager().getLaunchIntentForPackage(ConfigureActivity.pName4);
                startActivity(intent1);
                RunActivity.flag=11;
            //    RunActivity.flag1=2;
            }});
        btn12.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                pName1=sharedpreferences.getString(package_order12,"com.android.mms");
                pName2=sharedpreferences.getString(package_order13,"com.android.mms");
                pName3=sharedpreferences.getString(package_order14,"com.android.mms");
                pName4=sharedpreferences.getString(package_order15,"com.android.mms");

                RunActivity.editor1.putInt(RunActivity.icon_orderr0,sharedpreferences.getInt(icon_order12,0));
                RunActivity.editor1.putString(RunActivity.package_orderr0,pName1);
                RunActivity.editor1.putInt(RunActivity.icon_orderr1,sharedpreferences.getInt(icon_order13,0));
                RunActivity.editor1.putString(RunActivity.package_orderr1,pName2);
                RunActivity.editor1.putInt(RunActivity.icon_orderr2,sharedpreferences.getInt(icon_order14,0));
                RunActivity.editor1.putString(RunActivity.package_orderr2,pName3);
                RunActivity.editor1.putInt(RunActivity.icon_orderr3,sharedpreferences.getInt(icon_order15,0));
                RunActivity.editor1.putString(RunActivity.package_orderr3,pName4);
                RunActivity.button1.setBackground(icon[sharedpreferences.getInt(icon_order12,0)]);
                RunActivity.button2.setBackground(icon[sharedpreferences.getInt(icon_order13,0)]);
                RunActivity.button3.setBackground(icon[sharedpreferences.getInt(icon_order14,0)]);
                RunActivity.button4.setBackground(icon[sharedpreferences.getInt(icon_order15,0)]);
                RunActivity.editor1.putInt(RunActivity.flag1,3);

                RunActivity.editor1.commit();
                Intent intent1=getPackageManager().getLaunchIntentForPackage(ConfigureActivity.pName1);
                startActivity(intent1);
                RunActivity.flag=12;
              //  RunActivity.flag1=3;
            }});

        tab4.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                pName1=sharedpreferences.getString(package_order12,"com.android.mms");
                pName2=sharedpreferences.getString(package_order13,"com.android.mms");
                pName3=sharedpreferences.getString(package_order14,"com.android.mms");
                pName4=sharedpreferences.getString(package_order15,"com.android.mms");

                RunActivity.editor1.putInt(RunActivity.icon_orderr0,sharedpreferences.getInt(icon_order12,0));
                RunActivity.editor1.putString(RunActivity.package_orderr0,pName1);
                RunActivity.editor1.putInt(RunActivity.icon_orderr1,sharedpreferences.getInt(icon_order13,0));
                RunActivity.editor1.putString(RunActivity.package_orderr1,pName2);
                RunActivity.editor1.putInt(RunActivity.icon_orderr2,sharedpreferences.getInt(icon_order14,0));
                RunActivity.editor1.putString(RunActivity.package_orderr2,pName3);
                RunActivity.editor1.putInt(RunActivity.icon_orderr3,sharedpreferences.getInt(icon_order15,0));
                RunActivity.editor1.putString(RunActivity.package_orderr3,pName4);
                RunActivity.button1.setBackground(icon[sharedpreferences.getInt(icon_order12,0)]);
                RunActivity.button2.setBackground(icon[sharedpreferences.getInt(icon_order13,0)]);
                RunActivity.button3.setBackground(icon[sharedpreferences.getInt(icon_order14,0)]);
                RunActivity.button4.setBackground(icon[sharedpreferences.getInt(icon_order15,0)]);
                RunActivity.editor1.putInt(RunActivity.flag1,3);

                RunActivity.editor1.commit();

                RunActivity.flag=12;

                Intent startMain=new Intent(Intent.ACTION_MAIN);
                startMain.addCategory(Intent.CATEGORY_HOME);
                startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(startMain);

               // RunActivity.flag1=3;
            }});

        btn13.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                pName1=sharedpreferences.getString(package_order12,"com.android.mms");
                pName2=sharedpreferences.getString(package_order13,"com.android.mms");
                pName3=sharedpreferences.getString(package_order14,"com.android.mms");
                pName4=sharedpreferences.getString(package_order15,"com.android.mms");

                RunActivity.editor1.putInt(RunActivity.icon_orderr0,sharedpreferences.getInt(icon_order12,0));
                RunActivity.editor1.putString(RunActivity.package_orderr0,pName1);
                RunActivity.editor1.putInt(RunActivity.icon_orderr1,sharedpreferences.getInt(icon_order13,0));
                RunActivity.editor1.putString(RunActivity.package_orderr1,pName2);
                RunActivity.editor1.putInt(RunActivity.icon_orderr2,sharedpreferences.getInt(icon_order14,0));
                RunActivity.editor1.putString(RunActivity.package_orderr2,pName3);
                RunActivity.editor1.putInt(RunActivity.icon_orderr3,sharedpreferences.getInt(icon_order15,0));
                RunActivity.editor1.putString(RunActivity.package_orderr3,pName4);
                RunActivity.button1.setBackground(icon[sharedpreferences.getInt(icon_order12,0)]);
                RunActivity.button2.setBackground(icon[sharedpreferences.getInt(icon_order13,0)]);
                RunActivity.button3.setBackground(icon[sharedpreferences.getInt(icon_order14,0)]);
                RunActivity.button4.setBackground(icon[sharedpreferences.getInt(icon_order15,0)]);
                RunActivity.editor1.putInt(RunActivity.flag1,3);

                RunActivity.editor1.commit();
                Intent intent1=getPackageManager().getLaunchIntentForPackage(ConfigureActivity.pName2);
                startActivity(intent1);
                RunActivity.flag=13;
              //  RunActivity.flag1=3;
            }});
        btn14.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                pName1=sharedpreferences.getString(package_order12,"com.android.mms");
                pName2=sharedpreferences.getString(package_order13,"com.android.mms");
                pName3=sharedpreferences.getString(package_order14,"com.android.mms");
                pName4=sharedpreferences.getString(package_order15,"com.android.mms");

                RunActivity.editor1.putInt(RunActivity.icon_orderr0,sharedpreferences.getInt(icon_order12,0));
                RunActivity.editor1.putString(RunActivity.package_orderr0,pName1);
                RunActivity.editor1.putInt(RunActivity.icon_orderr1,sharedpreferences.getInt(icon_order13,0));
                RunActivity.editor1.putString(RunActivity.package_orderr1,pName2);
                RunActivity.editor1.putInt(RunActivity.icon_orderr2,sharedpreferences.getInt(icon_order14,0));
                RunActivity.editor1.putString(RunActivity.package_orderr2,pName3);
                RunActivity.editor1.putInt(RunActivity.icon_orderr3,sharedpreferences.getInt(icon_order15,0));
                RunActivity.editor1.putString(RunActivity.package_orderr3,pName4);
                RunActivity.button1.setBackground(icon[sharedpreferences.getInt(icon_order12,0)]);
                RunActivity.button2.setBackground(icon[sharedpreferences.getInt(icon_order13,0)]);
                RunActivity.button3.setBackground(icon[sharedpreferences.getInt(icon_order14,0)]);
                RunActivity.button4.setBackground(icon[sharedpreferences.getInt(icon_order15,0)]);
                RunActivity.editor1.putInt(RunActivity.flag1,3);

                RunActivity.editor1.commit();
                Intent intent1=getPackageManager().getLaunchIntentForPackage(ConfigureActivity.pName3);
                startActivity(intent1);
                RunActivity.flag=14;
           //     RunActivity.flag1=3;
            }});
        btn15.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                pName1=sharedpreferences.getString(package_order12,"com.android.mms");
                pName2=sharedpreferences.getString(package_order13,"com.android.mms");
                pName3=sharedpreferences.getString(package_order14,"com.android.mms");
                pName4=sharedpreferences.getString(package_order15,"com.android.mms");

                RunActivity.editor1.putInt(RunActivity.icon_orderr0,sharedpreferences.getInt(icon_order12,0));
                RunActivity.editor1.putString(RunActivity.package_orderr0,pName1);
                RunActivity.editor1.putInt(RunActivity.icon_orderr1,sharedpreferences.getInt(icon_order13,0));
                RunActivity.editor1.putString(RunActivity.package_orderr1,pName2);
                RunActivity.editor1.putInt(RunActivity.icon_orderr2,sharedpreferences.getInt(icon_order14,0));
                RunActivity.editor1.putString(RunActivity.package_orderr2,pName3);
                RunActivity.editor1.putInt(RunActivity.icon_orderr3,sharedpreferences.getInt(icon_order15,0));
                RunActivity.editor1.putString(RunActivity.package_orderr3,pName4);
                RunActivity.button1.setBackground(icon[sharedpreferences.getInt(icon_order12,0)]);
                RunActivity.button2.setBackground(icon[sharedpreferences.getInt(icon_order13,0)]);
                RunActivity.button3.setBackground(icon[sharedpreferences.getInt(icon_order14,0)]);
                RunActivity.button4.setBackground(icon[sharedpreferences.getInt(icon_order15,0)]);
                RunActivity.editor1.putInt(RunActivity.flag1,3);

                RunActivity.editor1.commit();
                Intent intent1=getPackageManager().getLaunchIntentForPackage(ConfigureActivity.pName4);
                startActivity(intent1);
                RunActivity.flag=15;
               // RunActivity.flag1=3;
            }});
        btnSetting.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

               if (RunActivity.sharedpreferencess.getInt(RunActivity.flag1,10)==0){
                   pName1=sharedpreferences.getString(package_order0,"com.android.mms");
                   pName2=sharedpreferences.getString(package_order1,"com.android.mms");
                   pName3=sharedpreferences.getString(package_order2,"com.android.mms");
                   pName4=sharedpreferences.getString(package_order3,"com.android.mms");

                   RunActivity.editor1.putInt(RunActivity.icon_orderr0,sharedpreferences.getInt(icon_order0,0));
                   RunActivity.editor1.putString(RunActivity.package_orderr0,pName1);
                   RunActivity.editor1.putInt(RunActivity.icon_orderr1,sharedpreferences.getInt(icon_order1,0));
                   RunActivity.editor1.putString(RunActivity.package_orderr1,pName2);
                   RunActivity.editor1.putInt(RunActivity.icon_orderr2,sharedpreferences.getInt(icon_order2,0));
                   RunActivity.editor1.putString(RunActivity.package_orderr2,pName3);
                   RunActivity.editor1.putInt(RunActivity.icon_orderr3,sharedpreferences.getInt(icon_order3,0));
                   RunActivity.editor1.putString(RunActivity.package_orderr3,pName4);
                   RunActivity.button1.setBackground(icon[sharedpreferences.getInt(icon_order0,0)]);
                   RunActivity.button2.setBackground(icon[sharedpreferences.getInt(icon_order1,0)]);
                   RunActivity.button3.setBackground(icon[sharedpreferences.getInt(icon_order2,0)]);
                   RunActivity.button4.setBackground(icon[sharedpreferences.getInt(icon_order3,0)]);
                   RunActivity.editor1.commit();

                   Intent startMain=new Intent(Intent.ACTION_MAIN);
                   startMain.addCategory(Intent.CATEGORY_HOME);
                   startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                   startActivity(startMain);

                  // RunActivity.flag1=0;
               }

                if (RunActivity.sharedpreferencess.getInt(RunActivity.flag1,10)==1){
                    pName1=sharedpreferences.getString(package_order4,"com.android.mms");
                    pName2=sharedpreferences.getString(package_order5,"com.android.mms");
                    pName3=sharedpreferences.getString(package_order6,"com.android.mms");
                    pName4=sharedpreferences.getString(package_order7,"com.android.mms");

                    RunActivity.editor1.putInt(RunActivity.icon_orderr0,sharedpreferences.getInt(icon_order4,0));
                    RunActivity.editor1.putString(RunActivity.package_orderr0,pName1);
                    RunActivity.editor1.putInt(RunActivity.icon_orderr1,sharedpreferences.getInt(icon_order5,0));
                    RunActivity.editor1.putString(RunActivity.package_orderr1,pName2);
                    RunActivity.editor1.putInt(RunActivity.icon_orderr2,sharedpreferences.getInt(icon_order6,0));
                    RunActivity.editor1.putString(RunActivity.package_orderr2,pName3);
                    RunActivity.editor1.putInt(RunActivity.icon_orderr3,sharedpreferences.getInt(icon_order7,0));
                    RunActivity.editor1.putString(RunActivity.package_orderr3,pName4);
                    RunActivity.button1.setBackground(icon[sharedpreferences.getInt(icon_order4,0)]);
                    RunActivity.button2.setBackground(icon[sharedpreferences.getInt(icon_order5,0)]);
                    RunActivity.button3.setBackground(icon[sharedpreferences.getInt(icon_order6,0)]);
                    RunActivity.button4.setBackground(icon[sharedpreferences.getInt(icon_order7,0)]);
                    RunActivity.editor1.commit();
                    Intent startMain=new Intent(Intent.ACTION_MAIN);
                    startMain.addCategory(Intent.CATEGORY_HOME);
                    startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(startMain);

                  //  RunActivity.flag1=1;
                }

                if (RunActivity.sharedpreferencess.getInt(RunActivity.flag1,10)==2){
                    pName1=sharedpreferences.getString(package_order8,"com.android.mms");
                    pName2=sharedpreferences.getString(package_order9,"com.android.mms");
                    pName3=sharedpreferences.getString(package_order10,"com.android.mms");
                    pName4=sharedpreferences.getString(package_order11,"com.android.mms");

                    RunActivity.editor1.putInt(RunActivity.icon_orderr0,sharedpreferences.getInt(icon_order8,0));
                    RunActivity.editor1.putString(RunActivity.package_orderr0,pName1);
                    RunActivity.editor1.putInt(RunActivity.icon_orderr1,sharedpreferences.getInt(icon_order9,0));
                    RunActivity.editor1.putString(RunActivity.package_orderr1,pName2);
                    RunActivity.editor1.putInt(RunActivity.icon_orderr2,sharedpreferences.getInt(icon_order10,0));
                    RunActivity.editor1.putString(RunActivity.package_orderr2,pName3);
                    RunActivity.editor1.putInt(RunActivity.icon_orderr3,sharedpreferences.getInt(icon_order11,0));
                    RunActivity.editor1.putString(RunActivity.package_orderr3,pName4);
                    RunActivity.button1.setBackground(icon[sharedpreferences.getInt(icon_order8,0)]);
                    RunActivity.button2.setBackground(icon[sharedpreferences.getInt(icon_order9,0)]);
                    RunActivity.button3.setBackground(icon[sharedpreferences.getInt(icon_order10,0)]);
                    RunActivity.button4.setBackground(icon[sharedpreferences.getInt(icon_order11,0)]);
                    RunActivity.editor1.commit();
                    Intent startMain=new Intent(Intent.ACTION_MAIN);
                    startMain.addCategory(Intent.CATEGORY_HOME);
                    startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(startMain);

                  //  RunActivity.flag1=2;
                }

                if (RunActivity.sharedpreferencess.getInt(RunActivity.flag1,10)==3){
                    pName1=sharedpreferences.getString(package_order12,"com.android.mms");
                    pName2=sharedpreferences.getString(package_order13,"com.android.mms");
                    pName3=sharedpreferences.getString(package_order14,"com.android.mms");
                    pName4=sharedpreferences.getString(package_order15,"com.android.mms");

                    RunActivity.editor1.putInt(RunActivity.icon_orderr0,sharedpreferences.getInt(icon_order12,0));
                    RunActivity.editor1.putString(RunActivity.package_orderr0,pName1);
                    RunActivity.editor1.putInt(RunActivity.icon_orderr1,sharedpreferences.getInt(icon_order13,0));
                    RunActivity.editor1.putString(RunActivity.package_orderr1,pName2);
                    RunActivity.editor1.putInt(RunActivity.icon_orderr2,sharedpreferences.getInt(icon_order14,0));
                    RunActivity.editor1.putString(RunActivity.package_orderr2,pName3);
                    RunActivity.editor1.putInt(RunActivity.icon_orderr3,sharedpreferences.getInt(icon_order15,0));
                    RunActivity.editor1.putString(RunActivity.package_orderr3,pName4);
                    RunActivity.button1.setBackground(icon[sharedpreferences.getInt(icon_order12,0)]);
                    RunActivity.button2.setBackground(icon[sharedpreferences.getInt(icon_order13,0)]);
                    RunActivity.button3.setBackground(icon[sharedpreferences.getInt(icon_order14,0)]);
                    RunActivity.button4.setBackground(icon[sharedpreferences.getInt(icon_order15,0)]);
                    RunActivity.editor1.commit();
                    Intent startMain=new Intent(Intent.ACTION_MAIN);
                    startMain.addCategory(Intent.CATEGORY_HOME);
                    startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(startMain);

                 //   RunActivity.flag1=3;
                }
            }});

    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_configure, menu);
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
