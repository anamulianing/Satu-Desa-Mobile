package b4a.example;


import anywheresoftware.b4a.B4AMenuItem;
import android.app.Activity;
import android.os.Bundle;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.B4AActivity;
import anywheresoftware.b4a.ObjectWrapper;
import anywheresoftware.b4a.objects.ActivityWrapper;
import java.lang.reflect.InvocationTargetException;
import anywheresoftware.b4a.B4AUncaughtException;
import anywheresoftware.b4a.debug.*;
import java.lang.ref.WeakReference;

public class profile extends Activity implements B4AActivity{
	public static profile mostCurrent;
	static boolean afterFirstLayout;
	static boolean isFirst = true;
    private static boolean processGlobalsRun = false;
	BALayout layout;
	public static BA processBA;
	BA activityBA;
    ActivityWrapper _activity;
    java.util.ArrayList<B4AMenuItem> menuItems;
	public static final boolean fullScreen = false;
	public static final boolean includeTitle = true;
    public static WeakReference<Activity> previousOne;
    public static boolean dontPause;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        mostCurrent = this;
		if (processBA == null) {
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "b4a.example", "b4a.example.profile");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (profile).");
				p.finish();
			}
		}
        processBA.setActivityPaused(true);
        processBA.runHook("oncreate", this, null);
		if (!includeTitle) {
        	this.getWindow().requestFeature(android.view.Window.FEATURE_NO_TITLE);
        }
        if (fullScreen) {
        	getWindow().setFlags(android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN,   
        			android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
		
        processBA.sharedProcessBA.activityBA = null;
		layout = new BALayout(this);
		setContentView(layout);
		afterFirstLayout = false;
        WaitForLayout wl = new WaitForLayout();
        if (anywheresoftware.b4a.objects.ServiceHelper.StarterHelper.startFromActivity(this, processBA, wl, false))
		    BA.handler.postDelayed(wl, 5);

	}
	static class WaitForLayout implements Runnable {
		public void run() {
			if (afterFirstLayout)
				return;
			if (mostCurrent == null)
				return;
            
			if (mostCurrent.layout.getWidth() == 0) {
				BA.handler.postDelayed(this, 5);
				return;
			}
			mostCurrent.layout.getLayoutParams().height = mostCurrent.layout.getHeight();
			mostCurrent.layout.getLayoutParams().width = mostCurrent.layout.getWidth();
			afterFirstLayout = true;
			mostCurrent.afterFirstLayout();
		}
	}
	private void afterFirstLayout() {
        if (this != mostCurrent)
			return;
		activityBA = new BA(this, layout, processBA, "b4a.example", "b4a.example.profile");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "b4a.example.profile", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (profile) Create, isFirst = " + isFirst + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (profile) Resume **");
        processBA.raiseEvent(null, "activity_resume");
        if (android.os.Build.VERSION.SDK_INT >= 11) {
			try {
				android.app.Activity.class.getMethod("invalidateOptionsMenu").invoke(this,(Object[]) null);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
	public void addMenuItem(B4AMenuItem item) {
		if (menuItems == null)
			menuItems = new java.util.ArrayList<B4AMenuItem>();
		menuItems.add(item);
	}
	@Override
	public boolean onCreateOptionsMenu(android.view.Menu menu) {
		super.onCreateOptionsMenu(menu);
        try {
            if (processBA.subExists("activity_actionbarhomeclick")) {
                Class.forName("android.app.ActionBar").getMethod("setHomeButtonEnabled", boolean.class).invoke(
                    getClass().getMethod("getActionBar").invoke(this), true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (processBA.runHook("oncreateoptionsmenu", this, new Object[] {menu}))
            return true;
		if (menuItems == null)
			return false;
		for (B4AMenuItem bmi : menuItems) {
			android.view.MenuItem mi = menu.add(bmi.title);
			if (bmi.drawable != null)
				mi.setIcon(bmi.drawable);
            if (android.os.Build.VERSION.SDK_INT >= 11) {
				try {
                    if (bmi.addToBar) {
				        android.view.MenuItem.class.getMethod("setShowAsAction", int.class).invoke(mi, 1);
                    }
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			mi.setOnMenuItemClickListener(new B4AMenuItemsClickListener(bmi.eventName.toLowerCase(BA.cul)));
		}
        
		return true;
	}   
 @Override
 public boolean onOptionsItemSelected(android.view.MenuItem item) {
    if (item.getItemId() == 16908332) {
        processBA.raiseEvent(null, "activity_actionbarhomeclick");
        return true;
    }
    else
        return super.onOptionsItemSelected(item); 
}
@Override
 public boolean onPrepareOptionsMenu(android.view.Menu menu) {
    super.onPrepareOptionsMenu(menu);
    processBA.runHook("onprepareoptionsmenu", this, new Object[] {menu});
    return true;
    
 }
 protected void onStart() {
    super.onStart();
    processBA.runHook("onstart", this, null);
}
 protected void onStop() {
    super.onStop();
    processBA.runHook("onstop", this, null);
}
    public void onWindowFocusChanged(boolean hasFocus) {
       super.onWindowFocusChanged(hasFocus);
       if (processBA.subExists("activity_windowfocuschanged"))
           processBA.raiseEvent2(null, true, "activity_windowfocuschanged", false, hasFocus);
    }
	private class B4AMenuItemsClickListener implements android.view.MenuItem.OnMenuItemClickListener {
		private final String eventName;
		public B4AMenuItemsClickListener(String eventName) {
			this.eventName = eventName;
		}
		public boolean onMenuItemClick(android.view.MenuItem item) {
			processBA.raiseEventFromUI(item.getTitle(), eventName + "_click");
			return true;
		}
	}
    public static Class<?> getObject() {
		return profile.class;
	}
    private Boolean onKeySubExist = null;
    private Boolean onKeyUpSubExist = null;
	@Override
	public boolean onKeyDown(int keyCode, android.view.KeyEvent event) {
        if (processBA.runHook("onkeydown", this, new Object[] {keyCode, event}))
            return true;
		if (onKeySubExist == null)
			onKeySubExist = processBA.subExists("activity_keypress");
		if (onKeySubExist) {
			if (keyCode == anywheresoftware.b4a.keywords.constants.KeyCodes.KEYCODE_BACK &&
					android.os.Build.VERSION.SDK_INT >= 18) {
				HandleKeyDelayed hk = new HandleKeyDelayed();
				hk.kc = keyCode;
				BA.handler.post(hk);
				return true;
			}
			else {
				boolean res = new HandleKeyDelayed().runDirectly(keyCode);
				if (res)
					return true;
			}
		}
		return super.onKeyDown(keyCode, event);
	}
	private class HandleKeyDelayed implements Runnable {
		int kc;
		public void run() {
			runDirectly(kc);
		}
		public boolean runDirectly(int keyCode) {
			Boolean res =  (Boolean)processBA.raiseEvent2(_activity, false, "activity_keypress", false, keyCode);
			if (res == null || res == true) {
                return true;
            }
            else if (keyCode == anywheresoftware.b4a.keywords.constants.KeyCodes.KEYCODE_BACK) {
				finish();
				return true;
			}
            return false;
		}
		
	}
    @Override
	public boolean onKeyUp(int keyCode, android.view.KeyEvent event) {
        if (processBA.runHook("onkeyup", this, new Object[] {keyCode, event}))
            return true;
		if (onKeyUpSubExist == null)
			onKeyUpSubExist = processBA.subExists("activity_keyup");
		if (onKeyUpSubExist) {
			Boolean res =  (Boolean)processBA.raiseEvent2(_activity, false, "activity_keyup", false, keyCode);
			if (res == null || res == true)
				return true;
		}
		return super.onKeyUp(keyCode, event);
	}
	@Override
	public void onNewIntent(android.content.Intent intent) {
        super.onNewIntent(intent);
		this.setIntent(intent);
        processBA.runHook("onnewintent", this, new Object[] {intent});
	}
    @Override 
	public void onPause() {
		super.onPause();
        if (_activity == null)
            return;
        if (this != mostCurrent)
			return;
		anywheresoftware.b4a.Msgbox.dismiss(true);
        if (!dontPause)
            BA.LogInfo("** Activity (profile) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        else
            BA.LogInfo("** Activity (profile) Pause event (activity is not paused). **");
        if (mostCurrent != null)
            processBA.raiseEvent2(_activity, true, "activity_pause", false, activityBA.activity.isFinishing());		
        if (!dontPause) {
            processBA.setActivityPaused(true);
            mostCurrent = null;
        }

        if (!activityBA.activity.isFinishing())
			previousOne = new WeakReference<Activity>(this);
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        processBA.runHook("onpause", this, null);
	}

	@Override
	public void onDestroy() {
        super.onDestroy();
		previousOne = null;
        processBA.runHook("ondestroy", this, null);
	}
    @Override 
	public void onResume() {
		super.onResume();
        mostCurrent = this;
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (activityBA != null) { //will be null during activity create (which waits for AfterLayout).
        	ResumeMessage rm = new ResumeMessage(mostCurrent);
        	BA.handler.post(rm);
        }
        processBA.runHook("onresume", this, null);
	}
    private static class ResumeMessage implements Runnable {
    	private final WeakReference<Activity> activity;
    	public ResumeMessage(Activity activity) {
    		this.activity = new WeakReference<Activity>(activity);
    	}
		public void run() {
            profile mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (profile) Resume **");
            if (mc != mostCurrent)
                return;
		    processBA.raiseEvent(mc._activity, "activity_resume", (Object[])null);
		}
    }
	@Override
	protected void onActivityResult(int requestCode, int resultCode,
	      android.content.Intent data) {
		processBA.onActivityResult(requestCode, resultCode, data);
        processBA.runHook("onactivityresult", this, new Object[] {requestCode, resultCode});
	}
	private static void initializeGlobals() {
		processBA.raiseEvent2(null, true, "globals", false, (Object[])null);
	}
    public void onRequestPermissionsResult(int requestCode,
        String permissions[], int[] grantResults) {
        for (int i = 0;i < permissions.length;i++) {
            Object[] o = new Object[] {permissions[i], grantResults[i] == 0};
            processBA.raiseEventFromDifferentThread(null,null, 0, "activity_permissionresult", true, o);
        }
            
    }



public static void initializeProcessGlobals() {
             try {
                Class.forName(BA.applicationContext.getPackageName() + ".main").getMethod("initializeProcessGlobals").invoke(null, null);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
}
public anywheresoftware.b4a.keywords.Common __c = null;
public anywheresoftware.b4a.objects.ListViewWrapper _lv = null;
public anywheresoftware.b4a.objects.LabelWrapper _user = null;
public b4a.example.main _main = null;
public b4a.example.tambahdata _tambahdata = null;
public b4a.example.modulkoneksi _modulkoneksi = null;
public b4a.example.starter _starter = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="profile";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
RDebugUtils.currentLine=589824;
 //BA.debugLineNum = 589824;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=589826;
 //BA.debugLineNum = 589826;BA.debugLine="Activity.LoadLayout(\"Profile\")";
mostCurrent._activity.LoadLayout("Profile",mostCurrent.activityBA);
RDebugUtils.currentLine=589828;
 //BA.debugLineNum = 589828;BA.debugLine="listProfile";
_listprofile();
RDebugUtils.currentLine=589831;
 //BA.debugLineNum = 589831;BA.debugLine="user.Text = Main.username";
mostCurrent._user.setText(BA.ObjectToCharSequence(mostCurrent._main._username /*String*/ ));
RDebugUtils.currentLine=589832;
 //BA.debugLineNum = 589832;BA.debugLine="End Sub";
return "";
}
public static String  _listprofile() throws Exception{
RDebugUtils.currentModule="profile";
if (Debug.shouldDelegate(mostCurrent.activityBA, "listprofile", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "listprofile", null));}
int _i = 0;
RDebugUtils.currentLine=786432;
 //BA.debugLineNum = 786432;BA.debugLine="Sub listProfile";
RDebugUtils.currentLine=786433;
 //BA.debugLineNum = 786433;BA.debugLine="lv.SingleLineLayout.Label.TextColor = Colors.Blac";
mostCurrent._lv.getSingleLineLayout().Label.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=786434;
 //BA.debugLineNum = 786434;BA.debugLine="lv.SingleLineLayout.Label.TextSize = 15";
mostCurrent._lv.getSingleLineLayout().Label.setTextSize((float) (15));
RDebugUtils.currentLine=786436;
 //BA.debugLineNum = 786436;BA.debugLine="ModulKoneksi.Koneksi";
mostCurrent._modulkoneksi._koneksi /*String*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=786438;
 //BA.debugLineNum = 786438;BA.debugLine="lv.Clear";
mostCurrent._lv.Clear();
RDebugUtils.currentLine=786440;
 //BA.debugLineNum = 786440;BA.debugLine="ModulKoneksi.ResultS = ModulKoneksi.MHandler.Quer";
mostCurrent._modulkoneksi._results /*mysql.mysqlhandler.ResultSetWrapper*/  = (mysql.mysqlhandler.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new mysql.mysqlhandler.ResultSetWrapper(), (java.sql.ResultSet)(mostCurrent._modulkoneksi._mhandler /*mysql.mysqlhandler*/ .Query("SELECT * FROM `tb_akunwarga` INNER JOIN tb_penduduk ON tb_akunwarga.id_penduduk = tb_penduduk.id_penduduk WHERE username = '"+mostCurrent._main._username /*String*/ +"'")));
RDebugUtils.currentLine=786442;
 //BA.debugLineNum = 786442;BA.debugLine="For i = 0 To ModulKoneksi.ResultS.RowCount - 1";
{
final int step6 = 1;
final int limit6 = (int) (mostCurrent._modulkoneksi._results /*mysql.mysqlhandler.ResultSetWrapper*/ .RowCount()-1);
_i = (int) (0) ;
for (;_i <= limit6 ;_i = _i + step6 ) {
RDebugUtils.currentLine=786443;
 //BA.debugLineNum = 786443;BA.debugLine="ModulKoneksi.ResultS.Position = i";
mostCurrent._modulkoneksi._results /*mysql.mysqlhandler.ResultSetWrapper*/ .setPosition(_i);
RDebugUtils.currentLine=786444;
 //BA.debugLineNum = 786444;BA.debugLine="lv.AddSingleLine(\"Nama : \" & ModulKoneksi.Result";
mostCurrent._lv.AddSingleLine(BA.ObjectToCharSequence("Nama : "+mostCurrent._modulkoneksi._results /*mysql.mysqlhandler.ResultSetWrapper*/ .GetString2("nama")));
RDebugUtils.currentLine=786445;
 //BA.debugLineNum = 786445;BA.debugLine="lv.AddSingleLine(\"NIK : \" & ModulKoneksi.ResultS";
mostCurrent._lv.AddSingleLine(BA.ObjectToCharSequence("NIK : "+mostCurrent._modulkoneksi._results /*mysql.mysqlhandler.ResultSetWrapper*/ .GetString2("nik")));
RDebugUtils.currentLine=786446;
 //BA.debugLineNum = 786446;BA.debugLine="lv.AddSingleLine(\"Jenis Kelamin : \" & ModulKonek";
mostCurrent._lv.AddSingleLine(BA.ObjectToCharSequence("Jenis Kelamin : "+mostCurrent._modulkoneksi._results /*mysql.mysqlhandler.ResultSetWrapper*/ .GetString2("jenis_kelamin")));
RDebugUtils.currentLine=786447;
 //BA.debugLineNum = 786447;BA.debugLine="lv.AddSingleLine(\"Tempat Lahir : \" & ModulKoneks";
mostCurrent._lv.AddSingleLine(BA.ObjectToCharSequence("Tempat Lahir : "+mostCurrent._modulkoneksi._results /*mysql.mysqlhandler.ResultSetWrapper*/ .GetString2("tempat_lahir")));
RDebugUtils.currentLine=786448;
 //BA.debugLineNum = 786448;BA.debugLine="lv.AddSingleLine(\"Tanggal Lahir : \" & ModulKonek";
mostCurrent._lv.AddSingleLine(BA.ObjectToCharSequence("Tanggal Lahir : "+mostCurrent._modulkoneksi._results /*mysql.mysqlhandler.ResultSetWrapper*/ .GetString2("tanggal_lahir")));
RDebugUtils.currentLine=786449;
 //BA.debugLineNum = 786449;BA.debugLine="lv.AddSingleLine(\"Agama : \" & ModulKoneksi.Resul";
mostCurrent._lv.AddSingleLine(BA.ObjectToCharSequence("Agama : "+mostCurrent._modulkoneksi._results /*mysql.mysqlhandler.ResultSetWrapper*/ .GetString2("agama")));
RDebugUtils.currentLine=786450;
 //BA.debugLineNum = 786450;BA.debugLine="lv.AddSingleLine(\"Pendidikan : \" & ModulKoneksi.";
mostCurrent._lv.AddSingleLine(BA.ObjectToCharSequence("Pendidikan : "+mostCurrent._modulkoneksi._results /*mysql.mysqlhandler.ResultSetWrapper*/ .GetString2("pendidikan")));
RDebugUtils.currentLine=786451;
 //BA.debugLineNum = 786451;BA.debugLine="lv.AddSingleLine(\"Jenis Pekerjaan : \" & ModulKon";
mostCurrent._lv.AddSingleLine(BA.ObjectToCharSequence("Jenis Pekerjaan : "+mostCurrent._modulkoneksi._results /*mysql.mysqlhandler.ResultSetWrapper*/ .GetString2("jenis_pekerjaan")));
RDebugUtils.currentLine=786452;
 //BA.debugLineNum = 786452;BA.debugLine="lv.AddSingleLine(\"Golongan Darah : \" & ModulKone";
mostCurrent._lv.AddSingleLine(BA.ObjectToCharSequence("Golongan Darah : "+mostCurrent._modulkoneksi._results /*mysql.mysqlhandler.ResultSetWrapper*/ .GetString2("golongan_darah")));
RDebugUtils.currentLine=786453;
 //BA.debugLineNum = 786453;BA.debugLine="lv.AddSingleLine(\"Status Perkawinan : \" & ModulK";
mostCurrent._lv.AddSingleLine(BA.ObjectToCharSequence("Status Perkawinan : "+mostCurrent._modulkoneksi._results /*mysql.mysqlhandler.ResultSetWrapper*/ .GetString2("status_perkawinan")));
RDebugUtils.currentLine=786454;
 //BA.debugLineNum = 786454;BA.debugLine="lv.AddSingleLine(\"Tanggal Perkawinan : \" & Modul";
mostCurrent._lv.AddSingleLine(BA.ObjectToCharSequence("Tanggal Perkawinan : "+BA.NumberToString(mostCurrent._modulkoneksi._results /*mysql.mysqlhandler.ResultSetWrapper*/ .GetInt2("tanggal_perkawinan"))));
RDebugUtils.currentLine=786455;
 //BA.debugLineNum = 786455;BA.debugLine="lv.AddSingleLine(\"Status Hubungan dalam Keluarga";
mostCurrent._lv.AddSingleLine(BA.ObjectToCharSequence("Status Hubungan dalam Keluarga : "+mostCurrent._modulkoneksi._results /*mysql.mysqlhandler.ResultSetWrapper*/ .GetString2("status_hubungan_dalam_keluarga")));
RDebugUtils.currentLine=786456;
 //BA.debugLineNum = 786456;BA.debugLine="lv.AddSingleLine(\"Kewarganegaraan : \" & ModulKon";
mostCurrent._lv.AddSingleLine(BA.ObjectToCharSequence("Kewarganegaraan : "+mostCurrent._modulkoneksi._results /*mysql.mysqlhandler.ResultSetWrapper*/ .GetString2("kewarganegaraan")));
RDebugUtils.currentLine=786457;
 //BA.debugLineNum = 786457;BA.debugLine="lv.AddSingleLine(\"No. PASPOR / KITAP : \" & Modul";
mostCurrent._lv.AddSingleLine(BA.ObjectToCharSequence("No. PASPOR / KITAP : "+mostCurrent._modulkoneksi._results /*mysql.mysqlhandler.ResultSetWrapper*/ .GetString2("no_paspor")+" / "+mostCurrent._modulkoneksi._results /*mysql.mysqlhandler.ResultSetWrapper*/ .GetString2("no_kitap")));
RDebugUtils.currentLine=786458;
 //BA.debugLineNum = 786458;BA.debugLine="lv.AddSingleLine(\"Nama Ayah / Ibu Kandung : \" &";
mostCurrent._lv.AddSingleLine(BA.ObjectToCharSequence("Nama Ayah / Ibu Kandung : "+mostCurrent._modulkoneksi._results /*mysql.mysqlhandler.ResultSetWrapper*/ .GetString2("ayah")+" / "+mostCurrent._modulkoneksi._results /*mysql.mysqlhandler.ResultSetWrapper*/ .GetString2("ibu")));
RDebugUtils.currentLine=786459;
 //BA.debugLineNum = 786459;BA.debugLine="lv.AddSingleLine(\"Alamat Lengkap : \" & ModulKone";
mostCurrent._lv.AddSingleLine(BA.ObjectToCharSequence("Alamat Lengkap : "+mostCurrent._modulkoneksi._results /*mysql.mysqlhandler.ResultSetWrapper*/ .GetString2("alamat")+mostCurrent._modulkoneksi._results /*mysql.mysqlhandler.ResultSetWrapper*/ .GetString2("rukun_tetangga")+" "+mostCurrent._modulkoneksi._results /*mysql.mysqlhandler.ResultSetWrapper*/ .GetString2("rukun_warga")+" "+mostCurrent._modulkoneksi._results /*mysql.mysqlhandler.ResultSetWrapper*/ .GetString2("kecamatan")));
RDebugUtils.currentLine=786460;
 //BA.debugLineNum = 786460;BA.debugLine="lv.AddSingleLine(\"Kontak : \" & ModulKoneksi.Resu";
mostCurrent._lv.AddSingleLine(BA.ObjectToCharSequence("Kontak : "+mostCurrent._modulkoneksi._results /*mysql.mysqlhandler.ResultSetWrapper*/ .GetString2("no_handphone_aktif")));
 }
};
RDebugUtils.currentLine=786463;
 //BA.debugLineNum = 786463;BA.debugLine="ModulKoneksi.MHandler.Close";
mostCurrent._modulkoneksi._mhandler /*mysql.mysqlhandler*/ .Close();
RDebugUtils.currentLine=786464;
 //BA.debugLineNum = 786464;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="profile";
RDebugUtils.currentLine=720896;
 //BA.debugLineNum = 720896;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=720898;
 //BA.debugLineNum = 720898;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="profile";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=655360;
 //BA.debugLineNum = 655360;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=655362;
 //BA.debugLineNum = 655362;BA.debugLine="End Sub";
return "";
}
public static String  _persyaratan_click() throws Exception{
RDebugUtils.currentModule="profile";
if (Debug.shouldDelegate(mostCurrent.activityBA, "persyaratan_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "persyaratan_click", null));}
RDebugUtils.currentLine=851968;
 //BA.debugLineNum = 851968;BA.debugLine="Private Sub Persyaratan_Click";
RDebugUtils.currentLine=851969;
 //BA.debugLineNum = 851969;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=851970;
 //BA.debugLineNum = 851970;BA.debugLine="StartActivity(TambahData)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._tambahdata.getObject()));
RDebugUtils.currentLine=851971;
 //BA.debugLineNum = 851971;BA.debugLine="End Sub";
return "";
}
}