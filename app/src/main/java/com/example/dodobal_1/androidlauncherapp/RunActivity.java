package com.example.dodobal_1.androidlauncherapp;

import android.app.Activity;
import android.appwidget.AppWidgetHost;
import android.appwidget.AppWidgetHostView;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProviderInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.preference.Preference;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class RunActivity extends Activity {
    public static final String mypreference="mypref";

    static final String TAG = "WidgetHostExampleActivity";

    AppWidgetManager mAppWidgetManager;
    AppWidgetHost mAppWidgetHost;

    ViewGroup mainlayout;

    public static SharedPreferences.Editor editor1;
    private PackageManager managerr;
    public static int flag=0;
    public static final String flag1="flag1";
    public static ImageButton button1,button2, button3,button4;
    private List<AppDetail> apps;
    final static Drawable iconn[]=new Drawable[200];
    final static String packageNamee[]=new String[200];
    public static SharedPreferences sharedpreferencess;
    public static final String icon_orderr0="orderr0";
    public static final String icon_orderr1="orderr1";
    public static final String icon_orderr2="orderr2";
    public static final String icon_orderr3="orderr3";

    public static final String package_orderr0="p_orderr0";
    public static final String package_orderr1="p_orderr1";
    public static final String package_orderr2="p_orderr2";
    public static final String package_orderr3="p_orderr3";

    public static final String mypreferencee="mypreff";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_run);

        mainlayout = (ViewGroup) findViewById(R.id.ll);

        mAppWidgetManager = AppWidgetManager.getInstance(this);
        mAppWidgetHost = new AppWidgetHost(this, R.id.APPWIDGET_HOST_ID);


       /* AppWidgetManager appWidgetManager=AppWidgetManager.getInstance(this);
        AppWidgetHost appWidgetHost=new AppWidgetHost(this,199286);
        AppWidgetProviderInfo newAppWidgetProviderInfo=new AppWidgetProviderInfo();
        int appWidgetId=appWidgetHost.allocateAppWidgetId();

        List<AppWidgetProviderInfo>appWidgetInfos=new ArrayList<AppWidgetProviderInfo>();
        appWidgetInfos=appWidgetManager.getInstalledProviders();

        for (int j=0;j<appWidgetInfos.size();j++)
        {
            if (appWidgetInfos.get(j).provider.getPackageName().equals("com.android.quicksearchbox") && appWidgetInfos.get(j).provider.getClassName().equals("com.android.quicksearchbox.SearchWidgetProvider"))
            {
                newAppWidgetProviderInfo=appWidgetInfos.get(j);
                break;
            }

        }
        AppWidgetHostView hostView=appWidgetHost.createView(this,appWidgetId, newAppWidgetProviderInfo);
        hostView.setAppWidget(appWidgetId,newAppWidgetProviderInfo);

        LinearLayout ll=(LinearLayout) findViewById(R.id.ll);
        ll.addView(hostView);

        appWidgetHost.startListening();*/
        managerr=getPackageManager();

        Intent i=new Intent(Intent.ACTION_MAIN,null);
        i.addCategory(Intent.CATEGORY_LAUNCHER);

        List<ResolveInfo> availableActivities=managerr.queryIntentActivities(i,0);
        Collections.sort(availableActivities, new ResolveInfo.DisplayNameComparator(managerr));
        Resources res = getResources();
        String s;
        int j=0;
        for (ResolveInfo ri:availableActivities){
            AppDetail app=new AppDetail();

            iconn[j]=ri.activityInfo.loadIcon(managerr);
            packageNamee[j]=ri.activityInfo.packageName;
            j++;
        }
        sharedpreferencess=getSharedPreferences(mypreferencee, Context.MODE_PRIVATE);
        editor1=sharedpreferencess.edit();

        if (sharedpreferencess.getInt(flag1,10)==10)
            editor1.putInt(flag1,0);
        if (sharedpreferencess.getInt(icon_orderr0,10)==10)
            editor1.putInt(icon_orderr0,0);
        if (sharedpreferencess.getInt(icon_orderr1,10)==10)
            editor1.putInt(icon_orderr1,1);
        if (sharedpreferencess.getInt(icon_orderr2,10)==10)
            editor1.putInt(icon_orderr2,2);
        if (sharedpreferencess.getInt(icon_orderr3,10)==10)
            editor1.putInt(icon_orderr3,3);


        if (sharedpreferencess.getString(package_orderr0,"")=="" )
            editor1.putString(package_orderr0,packageNamee[sharedpreferencess.getInt(icon_orderr0,0)]);
        if (sharedpreferencess.getString(package_orderr1,"")=="" )
            editor1.putString(package_orderr1,packageNamee[1]);
        if (sharedpreferencess.getString(package_orderr2,"")=="")
            editor1.putString(package_orderr2,packageNamee[2]);
        if (sharedpreferencess.getString(package_orderr3,"")=="" )
            editor1.putString(package_orderr3,packageNamee[3]);
        editor1.commit();

        ImageButton btnSetting = (ImageButton) findViewById(R.id.setting_button);
        button1=(ImageButton) findViewById(R.id.fb_button);
        button2=(ImageButton) findViewById(R.id.instagram_button);
        button3=(ImageButton) findViewById(R.id.twitter_button);
        button4=(ImageButton) findViewById(R.id.pinterest_button);

        button1.setBackground(iconn[sharedpreferencess.getInt(icon_orderr0,0)]);
        button2.setBackground(iconn[sharedpreferencess.getInt(icon_orderr1,0)]);
        button3.setBackground(iconn[sharedpreferencess.getInt(icon_orderr2,0)]);
        button4.setBackground(iconn[sharedpreferencess.getInt(icon_orderr3,0)]);

     /*   ll.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(RunActivity.this,"Long CLick",Toast.LENGTH_SHORT).show();
                LayoutInflater layoutInflater
                        = (LayoutInflater)getBaseContext()
                        .getSystemService(LAYOUT_INFLATER_SERVICE);
                final View popupView = layoutInflater.inflate(R.layout.activity_apps_grid2, null);
                final PopupWindow popupWindow = new PopupWindow(
                        popupView,
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT,true);
                popupWindow.showAtLocation(popupView, Gravity.CENTER, 0, 0);


                final AppWidgetManager appWidgetManager=AppWidgetManager.getInstance(RunActivity.this);
                final AppWidgetHost appWidgetHost=new AppWidgetHost(RunActivity.this,199286);
                AppWidgetProviderInfo newAppWidgetProviderInfo=new AppWidgetProviderInfo();
                final int appWidgetId=appWidgetHost.allocateAppWidgetId();

                 List<AppWidgetProviderInfo>appWidgetInfos=new ArrayList<AppWidgetProviderInfo>();
                 appWidgetInfos=appWidgetManager.getInstalledProviders();

                final List<AppWidgetProviderInfo> appWidgetInfoss=appWidgetInfos;

                GridView grid;

                grid=(GridView)popupView.findViewById(R.id.apps_grid);

                ArrayAdapter<AppWidgetProviderInfo> adapter=new ArrayAdapter<AppWidgetProviderInfo>(RunActivity.this, R.layout.activity_apps_grid2 ,appWidgetInfoss){
                    public View getView(int position,View convertView, ViewGroup parent){
                        if(convertView==null){
                            convertView=getLayoutInflater().inflate(R.layout.grid_item,null);
                        }
                        //ImageView appIcon=(ImageView)convertView.findViewById(R.id.item_app_icon);
                        //appIcon.setImageDrawable(appWidgetInfoss.get(position).loadIcon(RunActivity.this,1));

                        TextView appLabel=(TextView)convertView.findViewById(R.id.item_app_label);
                        appLabel.setText(appWidgetInfoss.get(position).label);




                        return convertView;
                    }
                };
                grid.setAdapter(adapter);
                grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        AppWidgetHostView hostView=appWidgetHost.createView(RunActivity.this,appWidgetId, appWidgetInfoss.get(position));
                        hostView.setAppWidget(appWidgetId,appWidgetInfoss.get(position));

                        LinearLayout ll=(LinearLayout) findViewById(R.id.ll);
                        ll.addView(hostView);
                            popupWindow.dismiss();
                        }
                    });
                return true;
            }
        });*/

    }

    void selectWidget() {

        int appWidgetId = this.mAppWidgetHost.allocateAppWidgetId();
        Intent pickIntent = new Intent(AppWidgetManager.ACTION_APPWIDGET_PICK);
        pickIntent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, appWidgetId);
        addEmptyData(pickIntent);

        startActivityForResult(pickIntent, R.id.REQUEST_PICK_APPWIDGET);
    }

    void addEmptyData(Intent pickIntent) {
        ArrayList<AppWidgetProviderInfo> customInfo = new ArrayList<AppWidgetProviderInfo>();
        pickIntent.putParcelableArrayListExtra(AppWidgetManager.EXTRA_CUSTOM_INFO, customInfo);
        ArrayList<Bundle> customExtras = new ArrayList<Bundle>();
        pickIntent.putParcelableArrayListExtra(AppWidgetManager.EXTRA_CUSTOM_EXTRAS, customExtras);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            if (requestCode == R.id.REQUEST_PICK_APPWIDGET) {
                configureWidget(data);
            } else if (requestCode == R.id.REQUEST_CREATE_APPWIDGET) {
                createWidget(data);

            }
        } else if (resultCode == RESULT_CANCELED && data != null) {
            int appWidgetId = data.getIntExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, -1);
            if (appWidgetId != -1) {
                mAppWidgetHost.deleteAppWidgetId(appWidgetId);
            }
        }
    }

    private void configureWidget(Intent data) {
        Bundle extras = data.getExtras();
        int appWidgetId = extras.getInt(AppWidgetManager.EXTRA_APPWIDGET_ID, -1);
        AppWidgetProviderInfo appWidgetInfo = mAppWidgetManager.getAppWidgetInfo(appWidgetId);
        if (appWidgetInfo.configure != null) {
            Intent intent = new Intent(AppWidgetManager.ACTION_APPWIDGET_CONFIGURE);
            intent.setComponent(appWidgetInfo.configure);
            intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, appWidgetId);
            startActivityForResult(intent, R.id.REQUEST_CREATE_APPWIDGET);
        } else {
            createWidget(data);


        }
    }

    public void createWidget(Intent data) {
        Bundle extras = data.getExtras();
        int appWidgetId = extras.getInt(AppWidgetManager.EXTRA_APPWIDGET_ID, -1);
        AppWidgetProviderInfo appWidgetInfo = mAppWidgetManager.getAppWidgetInfo(appWidgetId);

        AppWidgetHostView hostView = mAppWidgetHost.createView(this, appWidgetId, appWidgetInfo);
        hostView.setAppWidget(appWidgetId, appWidgetInfo);
        mainlayout.addView(hostView);

        Log.i(TAG, "The widget size is: " + appWidgetInfo.minWidth + "*" + appWidgetInfo.minHeight);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mAppWidgetHost.startListening();
    }

    /**
     * Stop listen for updates for our widgets (saving battery).
     */
    @Override
    protected void onStop() {
        super.onStop();
        mAppWidgetHost.stopListening();
    }

    public void removeWidget(AppWidgetHostView hostView) {
        mAppWidgetHost.deleteAppWidgetId(hostView.getAppWidgetId());
        mainlayout.removeView(hostView);
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event){
        if (keyCode==KeyEvent.KEYCODE_BACK){
            Intent startMain=new Intent(Intent.ACTION_MAIN);
            startMain.addCategory(Intent.CATEGORY_HOME);
            startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(startMain);
            return true;
          /*  final PackageManager pmlauncher=getPackageManager();
            Intent mainIntent=new Intent(Intent.ACTION_MAIN,null);
            mainIntent.addCategory(Intent.CATEGORY_LAUNCHER);
            List<ResolveInfo> appList=pmlauncher.queryIntentActivities(mainIntent,0);
            Collections.sort(appList, new ResolveInfo.DisplayNameComparator(pmlauncher));

            for (ResolveInfo temp:appList){
                String a=temp.activityInfo.packageName;
                Toast.makeText(this,a,Toast.LENGTH_SHORT).show();
            }*/

           /* ArrayList<Intent> intentList = new ArrayList<Intent>();
            Intent intent=null;
            final PackageManager packageManager=getPackageManager();
            for(final ResolveInfo resolveInfo:packageManager.queryIntentActivities(new
                            Intent(Intent.ACTION_MAIN).addCategory(Intent.CATEGORY_HOME),
                    PackageManager.MATCH_DEFAULT_ONLY)) {

                intent=packageManager
                        .getLaunchIntentForPackage(resolveInfo.activityInfo.packageName);
                intentList.add(intent);
                Toast.makeText(this,resolveInfo.activityInfo.packageName,Toast.LENGTH_LONG).show();
            }

            Intent intent1=getPackageManager().getLaunchIntentForPackage("com.sec.android.app.launcher");
            startActivity(intent1);
            return true;*/
        }
        return super.onKeyDown(keyCode,event);
    }

  /*  public static void resetPreferredLauncherAndOpenChooser(Context context) {
        PackageManager packageManager = context.getPackageManager();
        ComponentName componentName = new ComponentName(context, RunActivity.class);
        packageManager.setComponentEnabledSetting(componentName, PackageManager.COMPONENT_ENABLED_STATE_ENABLED, PackageManager.DONT_KILL_APP);

        Intent selector = new Intent(Intent.ACTION_MAIN);
        selector.addCategory(Intent.CATEGORY_HOME);
        selector.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(selector);

        packageManager.setComponentEnabledSetting(componentName, PackageManager.COMPONENT_ENABLED_STATE_DEFAULT, PackageManager.DONT_KILL_APP);
    }*/
    public void showSetting(View v){
        Intent intent;
        Intent i=new Intent(this, ConfigureActivity.class);
        startActivity(i);
    }

    public void showFacebook(View v){
        String pName;
        pName=packageNamee[sharedpreferencess.getInt(icon_orderr0,0)];
        Intent intent1=getPackageManager().getLaunchIntentForPackage(pName);
        startActivity(intent1);
    }

    public void addWidget(View v){
        selectWidget();
    }

    public void removeWidget(View v){
        removeWidgetMenuSelected();
    }

    public void showInstagram(View v){
        String pName;
        pName=packageNamee[sharedpreferencess.getInt(icon_orderr1,0)];
        Intent intent1=getPackageManager().getLaunchIntentForPackage(pName);
        startActivity(intent1);
    }

    public void showTwitter(View v){
        String pName;
        pName=packageNamee[sharedpreferencess.getInt(icon_orderr2,0)];
        Intent intent1=getPackageManager().getLaunchIntentForPackage(pName);
        startActivity(intent1);
    }

    public void showpInterest(View v){
        String pName;
        pName=packageNamee[sharedpreferencess.getInt(icon_orderr3,0)];
        Intent intent1=getPackageManager().getLaunchIntentForPackage(pName);
        startActivity(intent1);
    }

    public void showApps(View v){
        Intent i=new Intent(this, MainActivity.class);
        startActivity(i);
        //startActivity(new Intent(Intent.ACTION_MAIN).addCategory(Intent.CATEGORY_LAUNCHER));
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_run, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Log.i(TAG, "Menu selected: " + item.getTitle() + " / " + item.getItemId() + " / " + R.id.addWidget);
        switch (item.getItemId()) {
            case R.id.addWidget:
                selectWidget();
                return true;
            case R.id.removeWidget:
                removeWidgetMenuSelected();
                return false;
        }
        return super.onOptionsItemSelected(item);
    }

    public void removeWidgetMenuSelected() {
        int childCount = mainlayout.getChildCount();
        if (childCount > 0) {
            View view = mainlayout.getChildAt(childCount - 1);
            if (view instanceof AppWidgetHostView) {
                removeWidget((AppWidgetHostView) view);
                Toast.makeText(this, R.string.widget_removed_popup, Toast.LENGTH_SHORT).show();
                return;
            }
        }
        Toast.makeText(this, R.string.no_widgets_popup, Toast.LENGTH_SHORT).show();
    }
}
