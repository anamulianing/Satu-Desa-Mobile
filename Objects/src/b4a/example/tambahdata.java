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

public class tambahdata extends Activity implements B4AActivity{
	public static tambahdata mostCurrent;
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
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "b4a.example", "b4a.example.tambahdata");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (tambahdata).");
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
		activityBA = new BA(this, layout, processBA, "b4a.example", "b4a.example.tambahdata");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "b4a.example.tambahdata", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (tambahdata) Create, isFirst = " + isFirst + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (tambahdata) Resume **");
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
		return tambahdata.class;
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
            BA.LogInfo("** Activity (tambahdata) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        else
            BA.LogInfo("** Activity (tambahdata) Pause event (activity is not paused). **");
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
            tambahdata mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (tambahdata) Resume **");
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
public static anywheresoftware.b4a.objects.B4XViewWrapper.XUI _xui = null;
public static anywheresoftware.b4a.phone.Phone.ContentChooser _cc = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnltambahpersyaratan = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnlpersyaratan = null;
public b4a.example3.customlistview _xclv = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _lblpersyaratan = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _lblfile = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _button1 = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _panel1 = null;
public anywheresoftware.b4a.objects.EditTextWrapper _search = null;
public anywheresoftware.b4a.objects.EditTextWrapper _txtpersyaratan = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblpilihfile = null;
public anywheresoftware.b4a.agraham.dialogs.InputDialog.FileDialog _fd = null;
public static String _imgstr = "";
public anywheresoftware.b4a.objects.ButtonWrapper _btnsave = null;
public b4a.example.main _main = null;
public b4a.example.profile _profile = null;
public b4a.example.modulkoneksi _modulkoneksi = null;
public b4a.example.starter _starter = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="tambahdata";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
RDebugUtils.currentLine=1048576;
 //BA.debugLineNum = 1048576;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=1048578;
 //BA.debugLineNum = 1048578;BA.debugLine="Activity.LoadLayout(\"TambahPersyaratan\")";
mostCurrent._activity.LoadLayout("TambahPersyaratan",mostCurrent.activityBA);
RDebugUtils.currentLine=1048580;
 //BA.debugLineNum = 1048580;BA.debugLine="pnlPersyaratan.Visible = True";
mostCurrent._pnlpersyaratan.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=1048581;
 //BA.debugLineNum = 1048581;BA.debugLine="pnlTambahPersyaratan.Visible = False";
mostCurrent._pnltambahpersyaratan.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=1048583;
 //BA.debugLineNum = 1048583;BA.debugLine="showItem";
_showitem();
RDebugUtils.currentLine=1048585;
 //BA.debugLineNum = 1048585;BA.debugLine="xclv.DefaultTextColor = Colors.Black";
mostCurrent._xclv._defaulttextcolor = anywheresoftware.b4a.keywords.Common.Colors.Black;
RDebugUtils.currentLine=1048587;
 //BA.debugLineNum = 1048587;BA.debugLine="fd.TextColor = Colors.Black";
mostCurrent._fd.TextColor = anywheresoftware.b4a.keywords.Common.Colors.Black;
RDebugUtils.currentLine=1048588;
 //BA.debugLineNum = 1048588;BA.debugLine="End Sub";
return "";
}
public static String  _showitem() throws Exception{
RDebugUtils.currentModule="tambahdata";
if (Debug.shouldDelegate(mostCurrent.activityBA, "showitem", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "showitem", null));}
int _i = 0;
anywheresoftware.b4a.objects.PanelWrapper _p = null;
RDebugUtils.currentLine=1245184;
 //BA.debugLineNum = 1245184;BA.debugLine="Sub showItem";
RDebugUtils.currentLine=1245185;
 //BA.debugLineNum = 1245185;BA.debugLine="ModulKoneksi.koneksi";
mostCurrent._modulkoneksi._koneksi /*String*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=1245187;
 //BA.debugLineNum = 1245187;BA.debugLine="xclv.Clear";
mostCurrent._xclv._clear();
RDebugUtils.currentLine=1245189;
 //BA.debugLineNum = 1245189;BA.debugLine="ModulKoneksi.ResultS = ModulKoneksi.MHandler.Quer";
mostCurrent._modulkoneksi._results /*mysql.mysqlhandler.ResultSetWrapper*/  = (mysql.mysqlhandler.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new mysql.mysqlhandler.ResultSetWrapper(), (java.sql.ResultSet)(mostCurrent._modulkoneksi._mhandler /*mysql.mysqlhandler*/ .Query("SELECT * FROM `tb_akunwarga` INNER JOIN tb_persyaratan ON tb_akunwarga.id_penduduk = tb_persyaratan.id_penduduk WHERE username = '"+mostCurrent._main._username /*String*/ +"'")));
RDebugUtils.currentLine=1245191;
 //BA.debugLineNum = 1245191;BA.debugLine="For i = 0 To ModulKoneksi.ResultS.RowCount - 1";
{
final int step4 = 1;
final int limit4 = (int) (mostCurrent._modulkoneksi._results /*mysql.mysqlhandler.ResultSetWrapper*/ .RowCount()-1);
_i = (int) (0) ;
for (;_i <= limit4 ;_i = _i + step4 ) {
RDebugUtils.currentLine=1245192;
 //BA.debugLineNum = 1245192;BA.debugLine="ModulKoneksi.ResultS.Position  = i";
mostCurrent._modulkoneksi._results /*mysql.mysqlhandler.ResultSetWrapper*/ .setPosition(_i);
RDebugUtils.currentLine=1245193;
 //BA.debugLineNum = 1245193;BA.debugLine="Dim p As Panel";
_p = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=1245194;
 //BA.debugLineNum = 1245194;BA.debugLine="p = xui.CreatePanel(\"\")";
_p = (anywheresoftware.b4a.objects.PanelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.PanelWrapper(), (android.view.ViewGroup)(_xui.CreatePanel(processBA,"").getObject()));
RDebugUtils.currentLine=1245195;
 //BA.debugLineNum = 1245195;BA.debugLine="p.Color = Colors.Transparent";
_p.setColor(anywheresoftware.b4a.keywords.Common.Colors.Transparent);
RDebugUtils.currentLine=1245196;
 //BA.debugLineNum = 1245196;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, xclv.AsView.Width,";
_p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),mostCurrent._xclv._asview().getWidth(),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (50)));
RDebugUtils.currentLine=1245197;
 //BA.debugLineNum = 1245197;BA.debugLine="p.LoadLayout(\"Item\")";
_p.LoadLayout("Item",mostCurrent.activityBA);
RDebugUtils.currentLine=1245199;
 //BA.debugLineNum = 1245199;BA.debugLine="lblpersyaratan.Text = (\"Nama Persyaratan : \" & M";
mostCurrent._lblpersyaratan.setText(BA.ObjectToCharSequence(("Nama Persyaratan : "+mostCurrent._modulkoneksi._results /*mysql.mysqlhandler.ResultSetWrapper*/ .GetString2("nama_persyaratan"))));
RDebugUtils.currentLine=1245200;
 //BA.debugLineNum = 1245200;BA.debugLine="lblfile.Text = (\"File : \" & ModulKoneksi.ResultS";
mostCurrent._lblfile.setText(BA.ObjectToCharSequence(("File : "+mostCurrent._modulkoneksi._results /*mysql.mysqlhandler.ResultSetWrapper*/ .GetString2("file_persyaratan"))));
RDebugUtils.currentLine=1245201;
 //BA.debugLineNum = 1245201;BA.debugLine="Button1.Text = (ModulKoneksi.ResultS.GetString2(";
mostCurrent._button1.setText(BA.ObjectToCharSequence((mostCurrent._modulkoneksi._results /*mysql.mysqlhandler.ResultSetWrapper*/ .GetString2("id_persyaratan"))));
RDebugUtils.currentLine=1245202;
 //BA.debugLineNum = 1245202;BA.debugLine="xclv.Add(p, \"\")";
mostCurrent._xclv._add((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_p.getObject())),(Object)(""));
 }
};
RDebugUtils.currentLine=1245205;
 //BA.debugLineNum = 1245205;BA.debugLine="ModulKoneksi.MHandler.Close";
mostCurrent._modulkoneksi._mhandler /*mysql.mysqlhandler*/ .Close();
RDebugUtils.currentLine=1245206;
 //BA.debugLineNum = 1245206;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="tambahdata";
RDebugUtils.currentLine=1179648;
 //BA.debugLineNum = 1179648;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=1179650;
 //BA.debugLineNum = 1179650;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="tambahdata";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=1114112;
 //BA.debugLineNum = 1114112;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=1114114;
 //BA.debugLineNum = 1114114;BA.debugLine="End Sub";
return "";
}
public static String  _btnback_click() throws Exception{
RDebugUtils.currentModule="tambahdata";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btnback_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btnback_click", null));}
RDebugUtils.currentLine=1507328;
 //BA.debugLineNum = 1507328;BA.debugLine="Private Sub btnBack_Click";
RDebugUtils.currentLine=1507329;
 //BA.debugLineNum = 1507329;BA.debugLine="pnlPersyaratan.Visible = True";
mostCurrent._pnlpersyaratan.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=1507330;
 //BA.debugLineNum = 1507330;BA.debugLine="pnlTambahPersyaratan.Visible = False";
mostCurrent._pnltambahpersyaratan.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=1507331;
 //BA.debugLineNum = 1507331;BA.debugLine="End Sub";
return "";
}
public static String  _btnpict_click() throws Exception{
RDebugUtils.currentModule="tambahdata";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btnpict_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btnpict_click", null));}
int _i = 0;
RDebugUtils.currentLine=1638400;
 //BA.debugLineNum = 1638400;BA.debugLine="Private Sub btnPict_Click";
RDebugUtils.currentLine=1638413;
 //BA.debugLineNum = 1638413;BA.debugLine="Dim i As Int";
_i = 0;
RDebugUtils.currentLine=1638415;
 //BA.debugLineNum = 1638415;BA.debugLine="fd.FilePath = File.DirRootExternal";
mostCurrent._fd.setFilePath(anywheresoftware.b4a.keywords.Common.File.getDirRootExternal());
RDebugUtils.currentLine=1638416;
 //BA.debugLineNum = 1638416;BA.debugLine="i = fd.Show(\"Pilih File\", \"Yes\", \"\", \"Cancel\", Nu";
_i = mostCurrent._fd.Show(BA.ObjectToCharSequence("Pilih File"),"Yes","","Cancel",mostCurrent.activityBA,(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null));
RDebugUtils.currentLine=1638417;
 //BA.debugLineNum = 1638417;BA.debugLine="If i = DialogResponse.POSITIVE Then";
if (_i==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
RDebugUtils.currentLine=1638418;
 //BA.debugLineNum = 1638418;BA.debugLine="lblPilihFile.Text = fd.ChosenName";
mostCurrent._lblpilihfile.setText(BA.ObjectToCharSequence(mostCurrent._fd.getChosenName()));
 };
RDebugUtils.currentLine=1638421;
 //BA.debugLineNum = 1638421;BA.debugLine="End Sub";
return "";
}
public static String  _btnsave_click() throws Exception{
RDebugUtils.currentModule="tambahdata";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btnsave_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btnsave_click", null));}
RDebugUtils.currentLine=1703936;
 //BA.debugLineNum = 1703936;BA.debugLine="Private Sub btnSave_Click";
RDebugUtils.currentLine=1703937;
 //BA.debugLineNum = 1703937;BA.debugLine="If txtPersyaratan.Text = \"\" Then";
if ((mostCurrent._txtpersyaratan.getText()).equals("")) { 
RDebugUtils.currentLine=1703938;
 //BA.debugLineNum = 1703938;BA.debugLine="MsgboxAsync(\"Masukkan Persyaratan\", \"Info\")";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("Masukkan Persyaratan"),BA.ObjectToCharSequence("Info"),processBA);
RDebugUtils.currentLine=1703939;
 //BA.debugLineNum = 1703939;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=1703942;
 //BA.debugLineNum = 1703942;BA.debugLine="If btnSave.Text = \"Simpan\" Then";
if ((mostCurrent._btnsave.getText()).equals("Simpan")) { 
RDebugUtils.currentLine=1703944;
 //BA.debugLineNum = 1703944;BA.debugLine="ModulKoneksi.koneksi";
mostCurrent._modulkoneksi._koneksi /*String*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=1703946;
 //BA.debugLineNum = 1703946;BA.debugLine="ModulKoneksi.ResultS = ModulKoneksi.MHandler.Que";
mostCurrent._modulkoneksi._results /*mysql.mysqlhandler.ResultSetWrapper*/  = (mysql.mysqlhandler.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new mysql.mysqlhandler.ResultSetWrapper(), (java.sql.ResultSet)(mostCurrent._modulkoneksi._mhandler /*mysql.mysqlhandler*/ .Query("SELECT * FROM tb_persyaratan WHERE nama_persyaratan='"+mostCurrent._txtpersyaratan.getText()+"'")));
RDebugUtils.currentLine=1703947;
 //BA.debugLineNum = 1703947;BA.debugLine="If ModulKoneksi.ResultS.RowCount > 0 Then";
if (mostCurrent._modulkoneksi._results /*mysql.mysqlhandler.ResultSetWrapper*/ .RowCount()>0) { 
RDebugUtils.currentLine=1703948;
 //BA.debugLineNum = 1703948;BA.debugLine="MsgboxAsync(\"Persyaratan sudah tersedia\", \"Info";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("Persyaratan sudah tersedia"),BA.ObjectToCharSequence("Info"),processBA);
RDebugUtils.currentLine=1703949;
 //BA.debugLineNum = 1703949;BA.debugLine="txtPersyaratan.Text = \"\"";
mostCurrent._txtpersyaratan.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=1703950;
 //BA.debugLineNum = 1703950;BA.debugLine="ModulKoneksi.MHandler.Close";
mostCurrent._modulkoneksi._mhandler /*mysql.mysqlhandler*/ .Close();
RDebugUtils.currentLine=1703951;
 //BA.debugLineNum = 1703951;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=1703954;
 //BA.debugLineNum = 1703954;BA.debugLine="ModulKoneksi.MHandler.Exec(\"INSERT INTO tb_persy";
mostCurrent._modulkoneksi._mhandler /*mysql.mysqlhandler*/ .Exec("INSERT INTO tb_persyaratan VALUE('"+mostCurrent._txtpersyaratan.getText()+"', '"+mostCurrent._imgstr+"')");
RDebugUtils.currentLine=1703956;
 //BA.debugLineNum = 1703956;BA.debugLine="tampilanAwal";
_tampilanawal();
RDebugUtils.currentLine=1703958;
 //BA.debugLineNum = 1703958;BA.debugLine="ModulKoneksi.MHandler.Close";
mostCurrent._modulkoneksi._mhandler /*mysql.mysqlhandler*/ .Close();
 };
RDebugUtils.currentLine=1703961;
 //BA.debugLineNum = 1703961;BA.debugLine="End Sub";
return "";
}
public static String  _tampilanawal() throws Exception{
RDebugUtils.currentModule="tambahdata";
if (Debug.shouldDelegate(mostCurrent.activityBA, "tampilanawal", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "tampilanawal", null));}
RDebugUtils.currentLine=1769472;
 //BA.debugLineNum = 1769472;BA.debugLine="Sub tampilanAwal";
RDebugUtils.currentLine=1769473;
 //BA.debugLineNum = 1769473;BA.debugLine="txtPersyaratan.Text = \"\"";
mostCurrent._txtpersyaratan.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=1769474;
 //BA.debugLineNum = 1769474;BA.debugLine="lblPilihFile.Text = \"\"";
mostCurrent._lblpilihfile.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=1769476;
 //BA.debugLineNum = 1769476;BA.debugLine="showItem";
_showitem();
RDebugUtils.currentLine=1769478;
 //BA.debugLineNum = 1769478;BA.debugLine="pnlPersyaratan.Visible = True";
mostCurrent._pnlpersyaratan.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=1769479;
 //BA.debugLineNum = 1769479;BA.debugLine="pnlTambahPersyaratan.Visible = False";
mostCurrent._pnltambahpersyaratan.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=1769480;
 //BA.debugLineNum = 1769480;BA.debugLine="End Sub";
return "";
}
public static String  _btntambahdata_click() throws Exception{
RDebugUtils.currentModule="tambahdata";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btntambahdata_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btntambahdata_click", null));}
RDebugUtils.currentLine=1441792;
 //BA.debugLineNum = 1441792;BA.debugLine="Private Sub btnTambahData_Click";
RDebugUtils.currentLine=1441793;
 //BA.debugLineNum = 1441793;BA.debugLine="pnlPersyaratan.Visible = False";
mostCurrent._pnlpersyaratan.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=1441794;
 //BA.debugLineNum = 1441794;BA.debugLine="pnlTambahPersyaratan.Visible = True";
mostCurrent._pnltambahpersyaratan.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=1441795;
 //BA.debugLineNum = 1441795;BA.debugLine="End Sub";
return "";
}
public static String  _filterlist() throws Exception{
RDebugUtils.currentModule="tambahdata";
if (Debug.shouldDelegate(mostCurrent.activityBA, "filterlist", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "filterlist", null));}
int _i = 0;
anywheresoftware.b4a.objects.PanelWrapper _p = null;
RDebugUtils.currentLine=1310720;
 //BA.debugLineNum = 1310720;BA.debugLine="Sub FilterList";
RDebugUtils.currentLine=1310721;
 //BA.debugLineNum = 1310721;BA.debugLine="ModulKoneksi.koneksi";
mostCurrent._modulkoneksi._koneksi /*String*/ (mostCurrent.activityBA);
RDebugUtils.currentLine=1310723;
 //BA.debugLineNum = 1310723;BA.debugLine="xclv.Clear";
mostCurrent._xclv._clear();
RDebugUtils.currentLine=1310724;
 //BA.debugLineNum = 1310724;BA.debugLine="ModulKoneksi.ResultS = ModulKoneksi.MHandler.Quer";
mostCurrent._modulkoneksi._results /*mysql.mysqlhandler.ResultSetWrapper*/  = (mysql.mysqlhandler.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new mysql.mysqlhandler.ResultSetWrapper(), (java.sql.ResultSet)(mostCurrent._modulkoneksi._mhandler /*mysql.mysqlhandler*/ .Query("SELECT * FROM tb_persyaratan WHERE nama_persyaratan LIKE '%"+mostCurrent._search.getText()+"%' ORDER BY id_persyaratan ASC")));
RDebugUtils.currentLine=1310726;
 //BA.debugLineNum = 1310726;BA.debugLine="For i = 0 To ModulKoneksi.ResultS.RowCount - 1";
{
final int step4 = 1;
final int limit4 = (int) (mostCurrent._modulkoneksi._results /*mysql.mysqlhandler.ResultSetWrapper*/ .RowCount()-1);
_i = (int) (0) ;
for (;_i <= limit4 ;_i = _i + step4 ) {
RDebugUtils.currentLine=1310727;
 //BA.debugLineNum = 1310727;BA.debugLine="Dim p As Panel";
_p = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=1310728;
 //BA.debugLineNum = 1310728;BA.debugLine="p = xui.CreatePanel(\"\")";
_p = (anywheresoftware.b4a.objects.PanelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.PanelWrapper(), (android.view.ViewGroup)(_xui.CreatePanel(processBA,"").getObject()));
RDebugUtils.currentLine=1310729;
 //BA.debugLineNum = 1310729;BA.debugLine="p.Color = Colors.Transparent";
_p.setColor(anywheresoftware.b4a.keywords.Common.Colors.Transparent);
RDebugUtils.currentLine=1310730;
 //BA.debugLineNum = 1310730;BA.debugLine="p.LoadLayout(\"Item\")";
_p.LoadLayout("Item",mostCurrent.activityBA);
RDebugUtils.currentLine=1310731;
 //BA.debugLineNum = 1310731;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, xclv.AsView.Width,";
_p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),mostCurrent._xclv._asview().getWidth(),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (50)));
RDebugUtils.currentLine=1310732;
 //BA.debugLineNum = 1310732;BA.debugLine="lblpersyaratan.Text = (\"Nama Persyaratan : \" & M";
mostCurrent._lblpersyaratan.setText(BA.ObjectToCharSequence(("Nama Persyaratan : "+mostCurrent._modulkoneksi._results /*mysql.mysqlhandler.ResultSetWrapper*/ .GetString2("nama_persyaratan"))));
RDebugUtils.currentLine=1310733;
 //BA.debugLineNum = 1310733;BA.debugLine="lblfile.Text = (\"File : \" & ModulKoneksi.ResultS";
mostCurrent._lblfile.setText(BA.ObjectToCharSequence(("File : "+mostCurrent._modulkoneksi._results /*mysql.mysqlhandler.ResultSetWrapper*/ .GetString2("file_persyaratan"))));
RDebugUtils.currentLine=1310734;
 //BA.debugLineNum = 1310734;BA.debugLine="Button1.Text  = (ModulKoneksi.ResultS.GetString2";
mostCurrent._button1.setText(BA.ObjectToCharSequence((mostCurrent._modulkoneksi._results /*mysql.mysqlhandler.ResultSetWrapper*/ .GetString2("id_persyaratan"))));
RDebugUtils.currentLine=1310735;
 //BA.debugLineNum = 1310735;BA.debugLine="xclv.Add(p, \"\")";
mostCurrent._xclv._add((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_p.getObject())),(Object)(""));
 }
};
RDebugUtils.currentLine=1310738;
 //BA.debugLineNum = 1310738;BA.debugLine="ModulKoneksi.MHandler.Close";
mostCurrent._modulkoneksi._mhandler /*mysql.mysqlhandler*/ .Close();
RDebugUtils.currentLine=1310739;
 //BA.debugLineNum = 1310739;BA.debugLine="End Sub";
return "";
}
public static String  _profil_click() throws Exception{
RDebugUtils.currentModule="tambahdata";
if (Debug.shouldDelegate(mostCurrent.activityBA, "profil_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "profil_click", null));}
RDebugUtils.currentLine=1572864;
 //BA.debugLineNum = 1572864;BA.debugLine="Private Sub Profil_Click";
RDebugUtils.currentLine=1572865;
 //BA.debugLineNum = 1572865;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=1572866;
 //BA.debugLineNum = 1572866;BA.debugLine="StartActivity(Profile)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._profile.getObject()));
RDebugUtils.currentLine=1572867;
 //BA.debugLineNum = 1572867;BA.debugLine="End Sub";
return "";
}
public static String  _search_enterpressed() throws Exception{
RDebugUtils.currentModule="tambahdata";
if (Debug.shouldDelegate(mostCurrent.activityBA, "search_enterpressed", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "search_enterpressed", null));}
RDebugUtils.currentLine=1376256;
 //BA.debugLineNum = 1376256;BA.debugLine="Private Sub search_EnterPressed";
RDebugUtils.currentLine=1376257;
 //BA.debugLineNum = 1376257;BA.debugLine="FilterList";
_filterlist();
RDebugUtils.currentLine=1376258;
 //BA.debugLineNum = 1376258;BA.debugLine="End Sub";
return "";
}
}