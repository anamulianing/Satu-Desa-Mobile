package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class tambahdata_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (tambahdata) ","tambahdata",2,tambahdata.mostCurrent.activityBA,tambahdata.mostCurrent,40);
if (RapidSub.canDelegate("activity_create")) { return b4a.example.tambahdata.remoteMe.runUserSub(false, "tambahdata","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 40;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(128);
 BA.debugLineNum = 42;BA.debugLine="Activity.LoadLayout(\"TambahPersyaratan\")";
Debug.ShouldStop(512);
tambahdata.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("TambahPersyaratan")),tambahdata.mostCurrent.activityBA);
 BA.debugLineNum = 44;BA.debugLine="pnlPersyaratan.Visible = True";
Debug.ShouldStop(2048);
tambahdata.mostCurrent._pnlpersyaratan.runMethod(true,"setVisible",tambahdata.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 45;BA.debugLine="pnlTambahPersyaratan.Visible = False";
Debug.ShouldStop(4096);
tambahdata.mostCurrent._pnltambahpersyaratan.runMethod(true,"setVisible",tambahdata.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 47;BA.debugLine="showItem";
Debug.ShouldStop(16384);
_showitem();
 BA.debugLineNum = 49;BA.debugLine="xclv.DefaultTextColor = Colors.Black";
Debug.ShouldStop(65536);
tambahdata.mostCurrent._xclv.setField ("_defaulttextcolor",tambahdata.mostCurrent.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 51;BA.debugLine="fd.TextColor = Colors.Black";
Debug.ShouldStop(262144);
tambahdata.mostCurrent._fd.setField ("TextColor",tambahdata.mostCurrent.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 52;BA.debugLine="End Sub";
Debug.ShouldStop(524288);
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
		Debug.PushSubsStack("Activity_Pause (tambahdata) ","tambahdata",2,tambahdata.mostCurrent.activityBA,tambahdata.mostCurrent,58);
if (RapidSub.canDelegate("activity_pause")) { return b4a.example.tambahdata.remoteMe.runUserSub(false, "tambahdata","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 58;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 60;BA.debugLine="End Sub";
Debug.ShouldStop(134217728);
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
		Debug.PushSubsStack("Activity_Resume (tambahdata) ","tambahdata",2,tambahdata.mostCurrent.activityBA,tambahdata.mostCurrent,54);
if (RapidSub.canDelegate("activity_resume")) { return b4a.example.tambahdata.remoteMe.runUserSub(false, "tambahdata","activity_resume");}
 BA.debugLineNum = 54;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(2097152);
 BA.debugLineNum = 56;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
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
		Debug.PushSubsStack("btnBack_Click (tambahdata) ","tambahdata",2,tambahdata.mostCurrent.activityBA,tambahdata.mostCurrent,117);
if (RapidSub.canDelegate("btnback_click")) { return b4a.example.tambahdata.remoteMe.runUserSub(false, "tambahdata","btnback_click");}
 BA.debugLineNum = 117;BA.debugLine="Private Sub btnBack_Click";
Debug.ShouldStop(1048576);
 BA.debugLineNum = 118;BA.debugLine="pnlPersyaratan.Visible = True";
Debug.ShouldStop(2097152);
tambahdata.mostCurrent._pnlpersyaratan.runMethod(true,"setVisible",tambahdata.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 119;BA.debugLine="pnlTambahPersyaratan.Visible = False";
Debug.ShouldStop(4194304);
tambahdata.mostCurrent._pnltambahpersyaratan.runMethod(true,"setVisible",tambahdata.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 120;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btnpict_click() throws Exception{
try {
		Debug.PushSubsStack("btnPict_Click (tambahdata) ","tambahdata",2,tambahdata.mostCurrent.activityBA,tambahdata.mostCurrent,127);
if (RapidSub.canDelegate("btnpict_click")) { return b4a.example.tambahdata.remoteMe.runUserSub(false, "tambahdata","btnpict_click");}
RemoteObject _i = RemoteObject.createImmutable(0);
 BA.debugLineNum = 127;BA.debugLine="Private Sub btnPict_Click";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 140;BA.debugLine="Dim i As Int";
Debug.ShouldStop(2048);
_i = RemoteObject.createImmutable(0);Debug.locals.put("i", _i);
 BA.debugLineNum = 142;BA.debugLine="fd.FilePath = File.DirRootExternal";
Debug.ShouldStop(8192);
tambahdata.mostCurrent._fd.runMethod(true,"setFilePath",tambahdata.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirRootExternal"));
 BA.debugLineNum = 143;BA.debugLine="i = fd.Show(\"Pilih File\", \"Yes\", \"\", \"Cancel\", Nu";
Debug.ShouldStop(16384);
_i = tambahdata.mostCurrent._fd.runMethod(true,"Show",(Object)(BA.ObjectToCharSequence("Pilih File")),(Object)(BA.ObjectToString("Yes")),(Object)(BA.ObjectToString("")),(Object)(BA.ObjectToString("Cancel")),tambahdata.mostCurrent.activityBA,(Object)((tambahdata.mostCurrent.__c.getField(false,"Null"))));Debug.locals.put("i", _i);
 BA.debugLineNum = 144;BA.debugLine="If i = DialogResponse.POSITIVE Then";
Debug.ShouldStop(32768);
if (RemoteObject.solveBoolean("=",_i,BA.numberCast(double.class, tambahdata.mostCurrent.__c.getField(false,"DialogResponse").getField(true,"POSITIVE")))) { 
 BA.debugLineNum = 145;BA.debugLine="lblPilihFile.Text = fd.ChosenName";
Debug.ShouldStop(65536);
tambahdata.mostCurrent._lblpilihfile.runMethod(true,"setText",BA.ObjectToCharSequence(tambahdata.mostCurrent._fd.runMethod(true,"getChosenName")));
 };
 BA.debugLineNum = 148;BA.debugLine="End Sub";
Debug.ShouldStop(524288);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btnsave_click() throws Exception{
try {
		Debug.PushSubsStack("btnSave_Click (tambahdata) ","tambahdata",2,tambahdata.mostCurrent.activityBA,tambahdata.mostCurrent,153);
if (RapidSub.canDelegate("btnsave_click")) { return b4a.example.tambahdata.remoteMe.runUserSub(false, "tambahdata","btnsave_click");}
 BA.debugLineNum = 153;BA.debugLine="Private Sub btnSave_Click";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 154;BA.debugLine="If txtPersyaratan.Text = \"\" Then";
Debug.ShouldStop(33554432);
if (RemoteObject.solveBoolean("=",tambahdata.mostCurrent._txtpersyaratan.runMethod(true,"getText"),BA.ObjectToString(""))) { 
 BA.debugLineNum = 155;BA.debugLine="MsgboxAsync(\"Masukkan Persyaratan\", \"Info\")";
Debug.ShouldStop(67108864);
tambahdata.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("Masukkan Persyaratan")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Info"))),tambahdata.processBA);
 BA.debugLineNum = 156;BA.debugLine="Return";
Debug.ShouldStop(134217728);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 159;BA.debugLine="If btnSave.Text = \"Simpan\" Then";
Debug.ShouldStop(1073741824);
if (RemoteObject.solveBoolean("=",tambahdata.mostCurrent._btnsave.runMethod(true,"getText"),BA.ObjectToString("Simpan"))) { 
 BA.debugLineNum = 161;BA.debugLine="ModulKoneksi.koneksi";
Debug.ShouldStop(1);
tambahdata.mostCurrent._modulkoneksi.runVoidMethod ("_koneksi" /*RemoteObject*/ ,tambahdata.mostCurrent.activityBA);
 BA.debugLineNum = 163;BA.debugLine="ModulKoneksi.ResultS = ModulKoneksi.MHandler.Que";
Debug.ShouldStop(4);
tambahdata.mostCurrent._modulkoneksi._results /*RemoteObject*/  = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("mysql.mysqlhandler.ResultSetWrapper"), tambahdata.mostCurrent._modulkoneksi._mhandler /*RemoteObject*/ .runMethod(false,"Query",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM tb_persyaratan WHERE nama_persyaratan='"),tambahdata.mostCurrent._txtpersyaratan.runMethod(true,"getText"),RemoteObject.createImmutable("'")))));
 BA.debugLineNum = 164;BA.debugLine="If ModulKoneksi.ResultS.RowCount > 0 Then";
Debug.ShouldStop(8);
if (RemoteObject.solveBoolean(">",tambahdata.mostCurrent._modulkoneksi._results /*RemoteObject*/ .runMethod(true,"RowCount"),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 165;BA.debugLine="MsgboxAsync(\"Persyaratan sudah tersedia\", \"Info";
Debug.ShouldStop(16);
tambahdata.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("Persyaratan sudah tersedia")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Info"))),tambahdata.processBA);
 BA.debugLineNum = 166;BA.debugLine="txtPersyaratan.Text = \"\"";
Debug.ShouldStop(32);
tambahdata.mostCurrent._txtpersyaratan.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 167;BA.debugLine="ModulKoneksi.MHandler.Close";
Debug.ShouldStop(64);
tambahdata.mostCurrent._modulkoneksi._mhandler /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 168;BA.debugLine="Return";
Debug.ShouldStop(128);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 171;BA.debugLine="ModulKoneksi.MHandler.Exec(\"INSERT INTO tb_persy";
Debug.ShouldStop(1024);
tambahdata.mostCurrent._modulkoneksi._mhandler /*RemoteObject*/ .runVoidMethod ("Exec",(Object)(RemoteObject.concat(RemoteObject.createImmutable("INSERT INTO tb_persyaratan VALUE('"),tambahdata.mostCurrent._txtpersyaratan.runMethod(true,"getText"),RemoteObject.createImmutable("', '"),tambahdata.mostCurrent._imgstr,RemoteObject.createImmutable("')"))));
 BA.debugLineNum = 173;BA.debugLine="tampilanAwal";
Debug.ShouldStop(4096);
_tampilanawal();
 BA.debugLineNum = 175;BA.debugLine="ModulKoneksi.MHandler.Close";
Debug.ShouldStop(16384);
tambahdata.mostCurrent._modulkoneksi._mhandler /*RemoteObject*/ .runVoidMethod ("Close");
 };
 BA.debugLineNum = 178;BA.debugLine="End Sub";
Debug.ShouldStop(131072);
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
		Debug.PushSubsStack("btnTambahData_Click (tambahdata) ","tambahdata",2,tambahdata.mostCurrent.activityBA,tambahdata.mostCurrent,112);
if (RapidSub.canDelegate("btntambahdata_click")) { return b4a.example.tambahdata.remoteMe.runUserSub(false, "tambahdata","btntambahdata_click");}
 BA.debugLineNum = 112;BA.debugLine="Private Sub btnTambahData_Click";
Debug.ShouldStop(32768);
 BA.debugLineNum = 113;BA.debugLine="pnlPersyaratan.Visible = False";
Debug.ShouldStop(65536);
tambahdata.mostCurrent._pnlpersyaratan.runMethod(true,"setVisible",tambahdata.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 114;BA.debugLine="pnlTambahPersyaratan.Visible = True";
Debug.ShouldStop(131072);
tambahdata.mostCurrent._pnltambahpersyaratan.runMethod(true,"setVisible",tambahdata.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 115;BA.debugLine="End Sub";
Debug.ShouldStop(262144);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _filterlist() throws Exception{
try {
		Debug.PushSubsStack("FilterList (tambahdata) ","tambahdata",2,tambahdata.mostCurrent.activityBA,tambahdata.mostCurrent,88);
if (RapidSub.canDelegate("filterlist")) { return b4a.example.tambahdata.remoteMe.runUserSub(false, "tambahdata","filterlist");}
int _i = 0;
RemoteObject _p = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
 BA.debugLineNum = 88;BA.debugLine="Sub FilterList";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 89;BA.debugLine="ModulKoneksi.koneksi";
Debug.ShouldStop(16777216);
tambahdata.mostCurrent._modulkoneksi.runVoidMethod ("_koneksi" /*RemoteObject*/ ,tambahdata.mostCurrent.activityBA);
 BA.debugLineNum = 91;BA.debugLine="xclv.Clear";
Debug.ShouldStop(67108864);
tambahdata.mostCurrent._xclv.runVoidMethod ("_clear");
 BA.debugLineNum = 92;BA.debugLine="ModulKoneksi.ResultS = ModulKoneksi.MHandler.Quer";
Debug.ShouldStop(134217728);
tambahdata.mostCurrent._modulkoneksi._results /*RemoteObject*/  = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("mysql.mysqlhandler.ResultSetWrapper"), tambahdata.mostCurrent._modulkoneksi._mhandler /*RemoteObject*/ .runMethod(false,"Query",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM tb_persyaratan WHERE nama_persyaratan LIKE '%"),tambahdata.mostCurrent._search.runMethod(true,"getText"),RemoteObject.createImmutable("%' ORDER BY id_persyaratan ASC")))));
 BA.debugLineNum = 94;BA.debugLine="For i = 0 To ModulKoneksi.ResultS.RowCount - 1";
Debug.ShouldStop(536870912);
{
final int step4 = 1;
final int limit4 = RemoteObject.solve(new RemoteObject[] {tambahdata.mostCurrent._modulkoneksi._results /*RemoteObject*/ .runMethod(true,"RowCount"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step4 > 0 && _i <= limit4) || (step4 < 0 && _i >= limit4) ;_i = ((int)(0 + _i + step4))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 95;BA.debugLine="Dim p As Panel";
Debug.ShouldStop(1073741824);
_p = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");Debug.locals.put("p", _p);
 BA.debugLineNum = 96;BA.debugLine="p = xui.CreatePanel(\"\")";
Debug.ShouldStop(-2147483648);
_p = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.PanelWrapper"), tambahdata._xui.runMethod(false,"CreatePanel",tambahdata.processBA,(Object)(RemoteObject.createImmutable(""))).getObject());Debug.locals.put("p", _p);
 BA.debugLineNum = 97;BA.debugLine="p.Color = Colors.Transparent";
Debug.ShouldStop(1);
_p.runVoidMethod ("setColor",tambahdata.mostCurrent.__c.getField(false,"Colors").getField(true,"Transparent"));
 BA.debugLineNum = 98;BA.debugLine="p.LoadLayout(\"Item\")";
Debug.ShouldStop(2);
_p.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("Item")),tambahdata.mostCurrent.activityBA);
 BA.debugLineNum = 99;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, xclv.AsView.Width,";
Debug.ShouldStop(4);
_p.runVoidMethod ("SetLayoutAnimated",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(tambahdata.mostCurrent._xclv.runMethod(false,"_asview").runMethod(true,"getWidth")),(Object)(tambahdata.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 50)))));
 BA.debugLineNum = 100;BA.debugLine="lblpersyaratan.Text = (\"Nama Persyaratan : \" & M";
Debug.ShouldStop(8);
tambahdata.mostCurrent._lblpersyaratan.runMethod(true,"setText",BA.ObjectToCharSequence((RemoteObject.concat(RemoteObject.createImmutable("Nama Persyaratan : "),tambahdata.mostCurrent._modulkoneksi._results /*RemoteObject*/ .runMethod(true,"GetString2",(Object)(RemoteObject.createImmutable("nama_persyaratan")))))));
 BA.debugLineNum = 101;BA.debugLine="lblfile.Text = (\"File : \" & ModulKoneksi.ResultS";
Debug.ShouldStop(16);
tambahdata.mostCurrent._lblfile.runMethod(true,"setText",BA.ObjectToCharSequence((RemoteObject.concat(RemoteObject.createImmutable("File : "),tambahdata.mostCurrent._modulkoneksi._results /*RemoteObject*/ .runMethod(true,"GetString2",(Object)(RemoteObject.createImmutable("file_persyaratan")))))));
 BA.debugLineNum = 102;BA.debugLine="Button1.Text  = (ModulKoneksi.ResultS.GetString2";
Debug.ShouldStop(32);
tambahdata.mostCurrent._button1.runMethod(true,"setText",BA.ObjectToCharSequence((tambahdata.mostCurrent._modulkoneksi._results /*RemoteObject*/ .runMethod(true,"GetString2",(Object)(RemoteObject.createImmutable("id_persyaratan"))))));
 BA.debugLineNum = 103;BA.debugLine="xclv.Add(p, \"\")";
Debug.ShouldStop(64);
tambahdata.mostCurrent._xclv.runVoidMethod ("_add",RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper"), _p.getObject()),(Object)((RemoteObject.createImmutable(""))));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 106;BA.debugLine="ModulKoneksi.MHandler.Close";
Debug.ShouldStop(512);
tambahdata.mostCurrent._modulkoneksi._mhandler /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 107;BA.debugLine="End Sub";
Debug.ShouldStop(1024);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 15;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 19;BA.debugLine="Private pnlTambahPersyaratan As Panel";
tambahdata.mostCurrent._pnltambahpersyaratan = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 20;BA.debugLine="Private pnlPersyaratan As Panel";
tambahdata.mostCurrent._pnlpersyaratan = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 21;BA.debugLine="Private xclv As CustomListView";
tambahdata.mostCurrent._xclv = RemoteObject.createNew ("b4a.example3.customlistview");
 //BA.debugLineNum = 22;BA.debugLine="Private lblpersyaratan As B4XView";
tambahdata.mostCurrent._lblpersyaratan = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper");
 //BA.debugLineNum = 23;BA.debugLine="Private lblfile As B4XView";
tambahdata.mostCurrent._lblfile = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper");
 //BA.debugLineNum = 24;BA.debugLine="Private Button1 As B4XView";
tambahdata.mostCurrent._button1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper");
 //BA.debugLineNum = 25;BA.debugLine="Private Panel1 As B4XView";
tambahdata.mostCurrent._panel1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper");
 //BA.debugLineNum = 26;BA.debugLine="Private search As EditText";
tambahdata.mostCurrent._search = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 27;BA.debugLine="Private txtPersyaratan As EditText";
tambahdata.mostCurrent._txtpersyaratan = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 28;BA.debugLine="Private lblPilihFile As Label";
tambahdata.mostCurrent._lblpilihfile = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 30;BA.debugLine="Dim fd As FileDialog";
tambahdata.mostCurrent._fd = RemoteObject.createNew ("anywheresoftware.b4a.agraham.dialogs.InputDialog.FileDialog");
 //BA.debugLineNum = 33;BA.debugLine="Dim imgstr As String";
tambahdata.mostCurrent._imgstr = RemoteObject.createImmutable("");
 //BA.debugLineNum = 37;BA.debugLine="Private btnSave As Button";
tambahdata.mostCurrent._btnsave = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 38;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 9;BA.debugLine="Dim xui As XUI";
tambahdata._xui = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper.XUI");
 //BA.debugLineNum = 11;BA.debugLine="Dim CC As ContentChooser";
tambahdata._cc = RemoteObject.createNew ("anywheresoftware.b4a.phone.Phone.ContentChooser");
 //BA.debugLineNum = 13;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _profil_click() throws Exception{
try {
		Debug.PushSubsStack("Profil_Click (tambahdata) ","tambahdata",2,tambahdata.mostCurrent.activityBA,tambahdata.mostCurrent,122);
if (RapidSub.canDelegate("profil_click")) { return b4a.example.tambahdata.remoteMe.runUserSub(false, "tambahdata","profil_click");}
 BA.debugLineNum = 122;BA.debugLine="Private Sub Profil_Click";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 123;BA.debugLine="Activity.Finish";
Debug.ShouldStop(67108864);
tambahdata.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 124;BA.debugLine="StartActivity(Profile)";
Debug.ShouldStop(134217728);
tambahdata.mostCurrent.__c.runVoidMethod ("StartActivity",tambahdata.processBA,(Object)((tambahdata.mostCurrent._profile.getObject())));
 BA.debugLineNum = 125;BA.debugLine="End Sub";
Debug.ShouldStop(268435456);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _search_enterpressed() throws Exception{
try {
		Debug.PushSubsStack("search_EnterPressed (tambahdata) ","tambahdata",2,tambahdata.mostCurrent.activityBA,tambahdata.mostCurrent,108);
if (RapidSub.canDelegate("search_enterpressed")) { return b4a.example.tambahdata.remoteMe.runUserSub(false, "tambahdata","search_enterpressed");}
 BA.debugLineNum = 108;BA.debugLine="Private Sub search_EnterPressed";
Debug.ShouldStop(2048);
 BA.debugLineNum = 109;BA.debugLine="FilterList";
Debug.ShouldStop(4096);
_filterlist();
 BA.debugLineNum = 110;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _showitem() throws Exception{
try {
		Debug.PushSubsStack("showItem (tambahdata) ","tambahdata",2,tambahdata.mostCurrent.activityBA,tambahdata.mostCurrent,63);
if (RapidSub.canDelegate("showitem")) { return b4a.example.tambahdata.remoteMe.runUserSub(false, "tambahdata","showitem");}
int _i = 0;
RemoteObject _p = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
 BA.debugLineNum = 63;BA.debugLine="Sub showItem";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 64;BA.debugLine="ModulKoneksi.koneksi";
Debug.ShouldStop(-2147483648);
tambahdata.mostCurrent._modulkoneksi.runVoidMethod ("_koneksi" /*RemoteObject*/ ,tambahdata.mostCurrent.activityBA);
 BA.debugLineNum = 66;BA.debugLine="xclv.Clear";
Debug.ShouldStop(2);
tambahdata.mostCurrent._xclv.runVoidMethod ("_clear");
 BA.debugLineNum = 68;BA.debugLine="ModulKoneksi.ResultS = ModulKoneksi.MHandler.Quer";
Debug.ShouldStop(8);
tambahdata.mostCurrent._modulkoneksi._results /*RemoteObject*/  = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("mysql.mysqlhandler.ResultSetWrapper"), tambahdata.mostCurrent._modulkoneksi._mhandler /*RemoteObject*/ .runMethod(false,"Query",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM `tb_akunwarga` INNER JOIN tb_persyaratan ON tb_akunwarga.id_penduduk = tb_persyaratan.id_penduduk WHERE username = '"),tambahdata.mostCurrent._main._username /*RemoteObject*/ ,RemoteObject.createImmutable("'")))));
 BA.debugLineNum = 70;BA.debugLine="For i = 0 To ModulKoneksi.ResultS.RowCount - 1";
Debug.ShouldStop(32);
{
final int step4 = 1;
final int limit4 = RemoteObject.solve(new RemoteObject[] {tambahdata.mostCurrent._modulkoneksi._results /*RemoteObject*/ .runMethod(true,"RowCount"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step4 > 0 && _i <= limit4) || (step4 < 0 && _i >= limit4) ;_i = ((int)(0 + _i + step4))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 71;BA.debugLine="ModulKoneksi.ResultS.Position  = i";
Debug.ShouldStop(64);
tambahdata.mostCurrent._modulkoneksi._results /*RemoteObject*/ .runMethod(true,"setPosition",BA.numberCast(int.class, _i));
 BA.debugLineNum = 72;BA.debugLine="Dim p As Panel";
Debug.ShouldStop(128);
_p = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");Debug.locals.put("p", _p);
 BA.debugLineNum = 73;BA.debugLine="p = xui.CreatePanel(\"\")";
Debug.ShouldStop(256);
_p = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.PanelWrapper"), tambahdata._xui.runMethod(false,"CreatePanel",tambahdata.processBA,(Object)(RemoteObject.createImmutable(""))).getObject());Debug.locals.put("p", _p);
 BA.debugLineNum = 74;BA.debugLine="p.Color = Colors.Transparent";
Debug.ShouldStop(512);
_p.runVoidMethod ("setColor",tambahdata.mostCurrent.__c.getField(false,"Colors").getField(true,"Transparent"));
 BA.debugLineNum = 75;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, xclv.AsView.Width,";
Debug.ShouldStop(1024);
_p.runVoidMethod ("SetLayoutAnimated",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(tambahdata.mostCurrent._xclv.runMethod(false,"_asview").runMethod(true,"getWidth")),(Object)(tambahdata.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 50)))));
 BA.debugLineNum = 76;BA.debugLine="p.LoadLayout(\"Item\")";
Debug.ShouldStop(2048);
_p.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("Item")),tambahdata.mostCurrent.activityBA);
 BA.debugLineNum = 78;BA.debugLine="lblpersyaratan.Text = (\"Nama Persyaratan : \" & M";
Debug.ShouldStop(8192);
tambahdata.mostCurrent._lblpersyaratan.runMethod(true,"setText",BA.ObjectToCharSequence((RemoteObject.concat(RemoteObject.createImmutable("Nama Persyaratan : "),tambahdata.mostCurrent._modulkoneksi._results /*RemoteObject*/ .runMethod(true,"GetString2",(Object)(RemoteObject.createImmutable("nama_persyaratan")))))));
 BA.debugLineNum = 79;BA.debugLine="lblfile.Text = (\"File : \" & ModulKoneksi.ResultS";
Debug.ShouldStop(16384);
tambahdata.mostCurrent._lblfile.runMethod(true,"setText",BA.ObjectToCharSequence((RemoteObject.concat(RemoteObject.createImmutable("File : "),tambahdata.mostCurrent._modulkoneksi._results /*RemoteObject*/ .runMethod(true,"GetString2",(Object)(RemoteObject.createImmutable("file_persyaratan")))))));
 BA.debugLineNum = 80;BA.debugLine="Button1.Text = (ModulKoneksi.ResultS.GetString2(";
Debug.ShouldStop(32768);
tambahdata.mostCurrent._button1.runMethod(true,"setText",BA.ObjectToCharSequence((tambahdata.mostCurrent._modulkoneksi._results /*RemoteObject*/ .runMethod(true,"GetString2",(Object)(RemoteObject.createImmutable("id_persyaratan"))))));
 BA.debugLineNum = 81;BA.debugLine="xclv.Add(p, \"\")";
Debug.ShouldStop(65536);
tambahdata.mostCurrent._xclv.runVoidMethod ("_add",RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper"), _p.getObject()),(Object)((RemoteObject.createImmutable(""))));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 84;BA.debugLine="ModulKoneksi.MHandler.Close";
Debug.ShouldStop(524288);
tambahdata.mostCurrent._modulkoneksi._mhandler /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 85;BA.debugLine="End Sub";
Debug.ShouldStop(1048576);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _tampilanawal() throws Exception{
try {
		Debug.PushSubsStack("tampilanAwal (tambahdata) ","tambahdata",2,tambahdata.mostCurrent.activityBA,tambahdata.mostCurrent,180);
if (RapidSub.canDelegate("tampilanawal")) { return b4a.example.tambahdata.remoteMe.runUserSub(false, "tambahdata","tampilanawal");}
 BA.debugLineNum = 180;BA.debugLine="Sub tampilanAwal";
Debug.ShouldStop(524288);
 BA.debugLineNum = 181;BA.debugLine="txtPersyaratan.Text = \"\"";
Debug.ShouldStop(1048576);
tambahdata.mostCurrent._txtpersyaratan.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 182;BA.debugLine="lblPilihFile.Text = \"\"";
Debug.ShouldStop(2097152);
tambahdata.mostCurrent._lblpilihfile.runMethod(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 184;BA.debugLine="showItem";
Debug.ShouldStop(8388608);
_showitem();
 BA.debugLineNum = 186;BA.debugLine="pnlPersyaratan.Visible = True";
Debug.ShouldStop(33554432);
tambahdata.mostCurrent._pnlpersyaratan.runMethod(true,"setVisible",tambahdata.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 187;BA.debugLine="pnlTambahPersyaratan.Visible = False";
Debug.ShouldStop(67108864);
tambahdata.mostCurrent._pnltambahpersyaratan.runMethod(true,"setVisible",tambahdata.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 188;BA.debugLine="End Sub";
Debug.ShouldStop(134217728);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}