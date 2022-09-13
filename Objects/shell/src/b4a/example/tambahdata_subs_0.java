package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class tambahdata_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (tambahdata) ","tambahdata",3,tambahdata.mostCurrent.activityBA,tambahdata.mostCurrent,26);
if (RapidSub.canDelegate("activity_create")) { return b4a.example.tambahdata.remoteMe.runUserSub(false, "tambahdata","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 26;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 28;BA.debugLine="Activity.LoadLayout(\"TambahPersyaratan\")";
Debug.ShouldStop(134217728);
tambahdata.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("TambahPersyaratan")),tambahdata.mostCurrent.activityBA);
 BA.debugLineNum = 30;BA.debugLine="pnlPersyaratan.Visible = True";
Debug.ShouldStop(536870912);
tambahdata.mostCurrent._pnlpersyaratan.runMethod(true,"setVisible",tambahdata.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 31;BA.debugLine="pnlTambahPersyaratan.Visible = False";
Debug.ShouldStop(1073741824);
tambahdata.mostCurrent._pnltambahpersyaratan.runMethod(true,"setVisible",tambahdata.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 33;BA.debugLine="showItem";
Debug.ShouldStop(1);
_showitem();
 BA.debugLineNum = 35;BA.debugLine="xclv.DefaultTextColor = Colors.Black";
Debug.ShouldStop(4);
tambahdata.mostCurrent._xclv.setField ("_defaulttextcolor",tambahdata.mostCurrent.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 37;BA.debugLine="End Sub";
Debug.ShouldStop(16);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _activity_pause(RemoteObject _userclosed) throws Exception{
try {
		Debug.PushSubsStack("Activity_Pause (tambahdata) ","tambahdata",3,tambahdata.mostCurrent.activityBA,tambahdata.mostCurrent,43);
if (RapidSub.canDelegate("activity_pause")) { return b4a.example.tambahdata.remoteMe.runUserSub(false, "tambahdata","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 43;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(1024);
 BA.debugLineNum = 45;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _activity_resume() throws Exception{
try {
		Debug.PushSubsStack("Activity_Resume (tambahdata) ","tambahdata",3,tambahdata.mostCurrent.activityBA,tambahdata.mostCurrent,39);
if (RapidSub.canDelegate("activity_resume")) { return b4a.example.tambahdata.remoteMe.runUserSub(false, "tambahdata","activity_resume");}
 BA.debugLineNum = 39;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(64);
 BA.debugLineNum = 41;BA.debugLine="End Sub";
Debug.ShouldStop(256);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btnback_click() throws Exception{
try {
		Debug.PushSubsStack("btnBack_Click (tambahdata) ","tambahdata",3,tambahdata.mostCurrent.activityBA,tambahdata.mostCurrent,78);
if (RapidSub.canDelegate("btnback_click")) { return b4a.example.tambahdata.remoteMe.runUserSub(false, "tambahdata","btnback_click");}
 BA.debugLineNum = 78;BA.debugLine="Private Sub btnBack_Click";
Debug.ShouldStop(8192);
 BA.debugLineNum = 79;BA.debugLine="pnlPersyaratan.Visible = True";
Debug.ShouldStop(16384);
tambahdata.mostCurrent._pnlpersyaratan.runMethod(true,"setVisible",tambahdata.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 80;BA.debugLine="pnlTambahPersyaratan.Visible = False";
Debug.ShouldStop(32768);
tambahdata.mostCurrent._pnltambahpersyaratan.runMethod(true,"setVisible",tambahdata.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 81;BA.debugLine="End Sub";
Debug.ShouldStop(65536);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btntambahdata_click() throws Exception{
try {
		Debug.PushSubsStack("btnTambahData_Click (tambahdata) ","tambahdata",3,tambahdata.mostCurrent.activityBA,tambahdata.mostCurrent,73);
if (RapidSub.canDelegate("btntambahdata_click")) { return b4a.example.tambahdata.remoteMe.runUserSub(false, "tambahdata","btntambahdata_click");}
 BA.debugLineNum = 73;BA.debugLine="Private Sub btnTambahData_Click";
Debug.ShouldStop(256);
 BA.debugLineNum = 74;BA.debugLine="pnlPersyaratan.Visible = False";
Debug.ShouldStop(512);
tambahdata.mostCurrent._pnlpersyaratan.runMethod(true,"setVisible",tambahdata.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 75;BA.debugLine="pnlTambahPersyaratan.Visible = True";
Debug.ShouldStop(1024);
tambahdata.mostCurrent._pnltambahpersyaratan.runMethod(true,"setVisible",tambahdata.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 76;BA.debugLine="End Sub";
Debug.ShouldStop(2048);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 12;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 16;BA.debugLine="Dim xui As XUI";
tambahdata.mostCurrent._xui = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper.XUI");
 //BA.debugLineNum = 17;BA.debugLine="Private pnlTambahPersyaratan As Panel";
tambahdata.mostCurrent._pnltambahpersyaratan = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 18;BA.debugLine="Private pnlPersyaratan As Panel";
tambahdata.mostCurrent._pnlpersyaratan = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 19;BA.debugLine="Private xclv As CustomListView";
tambahdata.mostCurrent._xclv = RemoteObject.createNew ("b4a.example3.customlistview");
 //BA.debugLineNum = 20;BA.debugLine="Private lblpersyaratan As B4XView";
tambahdata.mostCurrent._lblpersyaratan = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper");
 //BA.debugLineNum = 21;BA.debugLine="Private lblfile As B4XView";
tambahdata.mostCurrent._lblfile = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper");
 //BA.debugLineNum = 22;BA.debugLine="Private Button1 As B4XView";
tambahdata.mostCurrent._button1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper");
 //BA.debugLineNum = 23;BA.debugLine="Private Panel1 As B4XView";
tambahdata.mostCurrent._panel1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper");
 //BA.debugLineNum = 24;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 10;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _showitem() throws Exception{
try {
		Debug.PushSubsStack("showItem (tambahdata) ","tambahdata",3,tambahdata.mostCurrent.activityBA,tambahdata.mostCurrent,47);
if (RapidSub.canDelegate("showitem")) { return b4a.example.tambahdata.remoteMe.runUserSub(false, "tambahdata","showitem");}
int _i = 0;
RemoteObject _p = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
 BA.debugLineNum = 47;BA.debugLine="Sub showItem";
Debug.ShouldStop(16384);
 BA.debugLineNum = 48;BA.debugLine="ModulKoneksi.koneksi";
Debug.ShouldStop(32768);
tambahdata.mostCurrent._modulkoneksi.runVoidMethod ("_koneksi" /*RemoteObject*/ ,tambahdata.mostCurrent.activityBA);
 BA.debugLineNum = 50;BA.debugLine="xclv.Clear";
Debug.ShouldStop(131072);
tambahdata.mostCurrent._xclv.runVoidMethod ("_clear");
 BA.debugLineNum = 52;BA.debugLine="ModulKoneksi.ResultS = ModulKoneksi.MHandler.Quer";
Debug.ShouldStop(524288);
tambahdata.mostCurrent._modulkoneksi._results /*RemoteObject*/  = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("mysql.mysqlhandler.ResultSetWrapper"), tambahdata.mostCurrent._modulkoneksi._mhandler /*RemoteObject*/ .runMethod(false,"Query",(Object)(RemoteObject.createImmutable("SELECT * FROM tb_persyaratan ORDER BY id_persyaratan ASC"))));
 BA.debugLineNum = 54;BA.debugLine="For i = 0 To ModulKoneksi.ResultS.RowCount - 1";
Debug.ShouldStop(2097152);
{
final int step4 = 1;
final int limit4 = RemoteObject.solve(new RemoteObject[] {tambahdata.mostCurrent._modulkoneksi._results /*RemoteObject*/ .runMethod(true,"RowCount"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step4 > 0 && _i <= limit4) || (step4 < 0 && _i >= limit4) ;_i = ((int)(0 + _i + step4))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 55;BA.debugLine="ModulKoneksi.ResultS.Position  = i";
Debug.ShouldStop(4194304);
tambahdata.mostCurrent._modulkoneksi._results /*RemoteObject*/ .runMethod(true,"setPosition",BA.numberCast(int.class, _i));
 BA.debugLineNum = 56;BA.debugLine="Dim p As Panel";
Debug.ShouldStop(8388608);
_p = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");Debug.locals.put("p", _p);
 BA.debugLineNum = 57;BA.debugLine="p = xui.CreatePanel(\"\")";
Debug.ShouldStop(16777216);
_p = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.PanelWrapper"), tambahdata.mostCurrent._xui.runMethod(false,"CreatePanel",tambahdata.processBA,(Object)(RemoteObject.createImmutable(""))).getObject());Debug.locals.put("p", _p);
 BA.debugLineNum = 58;BA.debugLine="p.Color = Colors.Transparent";
Debug.ShouldStop(33554432);
_p.runVoidMethod ("setColor",tambahdata.mostCurrent.__c.getField(false,"Colors").getField(true,"Transparent"));
 BA.debugLineNum = 59;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, xclv.AsView.Width,";
Debug.ShouldStop(67108864);
_p.runVoidMethod ("SetLayoutAnimated",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(tambahdata.mostCurrent._xclv.runMethod(false,"_asview").runMethod(true,"getWidth")),(Object)(tambahdata.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 50)))));
 BA.debugLineNum = 60;BA.debugLine="p.LoadLayout(\"Item\")";
Debug.ShouldStop(134217728);
_p.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("Item")),tambahdata.mostCurrent.activityBA);
 BA.debugLineNum = 64;BA.debugLine="lblpersyaratan.Text = (ModulKoneksi.ResultS.GetS";
Debug.ShouldStop(-2147483648);
tambahdata.mostCurrent._lblpersyaratan.runMethod(true,"setText",BA.ObjectToCharSequence((tambahdata.mostCurrent._modulkoneksi._results /*RemoteObject*/ .runMethod(true,"GetString2",(Object)(RemoteObject.createImmutable("nama_persyaratan"))))));
 BA.debugLineNum = 65;BA.debugLine="lblfile.Text = (ModulKoneksi.ResultS.GetString2(";
Debug.ShouldStop(1);
tambahdata.mostCurrent._lblfile.runMethod(true,"setText",BA.ObjectToCharSequence((tambahdata.mostCurrent._modulkoneksi._results /*RemoteObject*/ .runMethod(true,"GetString2",(Object)(RemoteObject.createImmutable("file_persyaratan"))))));
 BA.debugLineNum = 66;BA.debugLine="Button1.Text = (ModulKoneksi.ResultS.GetString2(";
Debug.ShouldStop(2);
tambahdata.mostCurrent._button1.runMethod(true,"setText",BA.ObjectToCharSequence((tambahdata.mostCurrent._modulkoneksi._results /*RemoteObject*/ .runMethod(true,"GetString2",(Object)(RemoteObject.createImmutable("id_persyaratan"))))));
 BA.debugLineNum = 67;BA.debugLine="xclv.Add(p, \"\")";
Debug.ShouldStop(4);
tambahdata.mostCurrent._xclv.runVoidMethod ("_add",RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper"), _p.getObject()),(Object)((RemoteObject.createImmutable(""))));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 70;BA.debugLine="ModulKoneksi.MHandler.Close";
Debug.ShouldStop(32);
tambahdata.mostCurrent._modulkoneksi._mhandler /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 71;BA.debugLine="End Sub";
Debug.ShouldStop(64);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}