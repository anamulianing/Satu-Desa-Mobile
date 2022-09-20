package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class main_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,37);
if (RapidSub.canDelegate("activity_create")) { return b4a.example.main.remoteMe.runUserSub(false, "main","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 37;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(16);
 BA.debugLineNum = 38;BA.debugLine="Activity.LoadLayout(\"LoginPage\")";
Debug.ShouldStop(32);
main.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("LoginPage")),main.mostCurrent.activityBA);
 BA.debugLineNum = 40;BA.debugLine="End Sub";
Debug.ShouldStop(128);
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
		Debug.PushSubsStack("Activity_Pause (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,48);
if (RapidSub.canDelegate("activity_pause")) { return b4a.example.main.remoteMe.runUserSub(false, "main","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 48;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(32768);
 BA.debugLineNum = 50;BA.debugLine="End Sub";
Debug.ShouldStop(131072);
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
		Debug.PushSubsStack("Activity_Resume (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,43);
if (RapidSub.canDelegate("activity_resume")) { return b4a.example.main.remoteMe.runUserSub(false, "main","activity_resume");}
 BA.debugLineNum = 43;BA.debugLine="Sub Activity_Resume";
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
public static RemoteObject  _enkripsi() throws Exception{
try {
		Debug.PushSubsStack("enkripsi (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,99);
if (RapidSub.canDelegate("enkripsi")) { return b4a.example.main.remoteMe.runUserSub(false, "main","enkripsi");}
 BA.debugLineNum = 99;BA.debugLine="Sub enkripsi";
Debug.ShouldStop(4);
 BA.debugLineNum = 100;BA.debugLine="passwordhash = md.GetMessageDigest(p.GetBytes(\"UT";
Debug.ShouldStop(8);
main._passwordhash = main.mostCurrent._md.runMethod(false,"GetMessageDigest",(Object)(main.mostCurrent._p.runMethod(false,"getBytes",(Object)(RemoteObject.createImmutable("UTF8")))),(Object)(RemoteObject.createImmutable("MD5")));
 BA.debugLineNum = 101;BA.debugLine="epass = ByteCon.HexFromBytes(passwordhash)";
Debug.ShouldStop(16);
main.mostCurrent._epass = main.mostCurrent._bytecon.runMethod(true,"HexFromBytes",(Object)(main._passwordhash));
 BA.debugLineNum = 102;BA.debugLine="End Sub";
Debug.ShouldStop(32);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 25;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 27;BA.debugLine="Dim md As MessageDigest";
main.mostCurrent._md = RemoteObject.createNew ("anywheresoftware.b4a.agraham.encryption.CipherWrapper.MessageDigestWrapper");
 //BA.debugLineNum = 28;BA.debugLine="Dim ByteCon As ByteConverter";
main.mostCurrent._bytecon = RemoteObject.createNew ("anywheresoftware.b4a.agraham.byteconverter.ByteConverter");
 //BA.debugLineNum = 29;BA.debugLine="Dim passwordhash() As Byte";
main._passwordhash = RemoteObject.createNewArray ("byte", new int[] {0}, new Object[]{});
 //BA.debugLineNum = 30;BA.debugLine="Dim epass As String";
main.mostCurrent._epass = RemoteObject.createImmutable("");
 //BA.debugLineNum = 31;BA.debugLine="Dim p As String";
main.mostCurrent._p = RemoteObject.createImmutable("");
 //BA.debugLineNum = 32;BA.debugLine="Private NamaPengguna As EditText";
main.mostCurrent._namapengguna = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 33;BA.debugLine="Private Password As EditText";
main.mostCurrent._password = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 34;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _masuk_click() throws Exception{
try {
		Debug.PushSubsStack("Masuk_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,53);
if (RapidSub.canDelegate("masuk_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","masuk_click");}
 BA.debugLineNum = 53;BA.debugLine="Private Sub Masuk_Click";
Debug.ShouldStop(1048576);
 BA.debugLineNum = 55;BA.debugLine="If NamaPengguna.Text =  \"\" Then";
Debug.ShouldStop(4194304);
if (RemoteObject.solveBoolean("=",main.mostCurrent._namapengguna.runMethod(true,"getText"),BA.ObjectToString(""))) { 
 BA.debugLineNum = 56;BA.debugLine="MsgboxAsync(\"Masukan Nama Pengguna\", \"Info\")";
Debug.ShouldStop(8388608);
main.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("Masukan Nama Pengguna")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Info"))),main.processBA);
 BA.debugLineNum = 57;BA.debugLine="Return";
Debug.ShouldStop(16777216);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 60;BA.debugLine="If Password.Text =  \"\" Then";
Debug.ShouldStop(134217728);
if (RemoteObject.solveBoolean("=",main.mostCurrent._password.runMethod(true,"getText"),BA.ObjectToString(""))) { 
 BA.debugLineNum = 61;BA.debugLine="MsgboxAsync(\"Masukan Password\", \"Info\")";
Debug.ShouldStop(268435456);
main.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("Masukan Password")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Info"))),main.processBA);
 BA.debugLineNum = 62;BA.debugLine="Return";
Debug.ShouldStop(536870912);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 65;BA.debugLine="ModulKoneksi.Koneksi";
Debug.ShouldStop(1);
main.mostCurrent._modulkoneksi.runVoidMethod ("_koneksi" /*RemoteObject*/ ,main.mostCurrent.activityBA);
 BA.debugLineNum = 67;BA.debugLine="p = Password.Text";
Debug.ShouldStop(4);
main.mostCurrent._p = main.mostCurrent._password.runMethod(true,"getText");
 BA.debugLineNum = 69;BA.debugLine="enkripsi";
Debug.ShouldStop(16);
_enkripsi();
 BA.debugLineNum = 71;BA.debugLine="ModulKoneksi.ResultS = ModulKoneksi.MHandler.Quer";
Debug.ShouldStop(64);
main.mostCurrent._modulkoneksi._results /*RemoteObject*/  = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("mysql.mysqlhandler.ResultSetWrapper"), main.mostCurrent._modulkoneksi._mhandler /*RemoteObject*/ .runMethod(false,"Query",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM tb_akunwarga WHERE username='"),main.mostCurrent._namapengguna.runMethod(true,"getText"),RemoteObject.createImmutable("'")))));
 BA.debugLineNum = 72;BA.debugLine="If ModulKoneksi.ResultS.RowCount > 0 Then";
Debug.ShouldStop(128);
if (RemoteObject.solveBoolean(">",main.mostCurrent._modulkoneksi._results /*RemoteObject*/ .runMethod(true,"RowCount"),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 74;BA.debugLine="ModulKoneksi.ResultS = ModulKoneksi.MHandler.Que";
Debug.ShouldStop(512);
main.mostCurrent._modulkoneksi._results /*RemoteObject*/  = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("mysql.mysqlhandler.ResultSetWrapper"), main.mostCurrent._modulkoneksi._mhandler /*RemoteObject*/ .runMethod(false,"Query",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM tb_akunwarga WHERE username='"),main.mostCurrent._namapengguna.runMethod(true,"getText"),RemoteObject.createImmutable("' and password ='"),main.mostCurrent._epass,RemoteObject.createImmutable("'")))));
 BA.debugLineNum = 75;BA.debugLine="If ModulKoneksi.ResultS.RowCount > 0 Then";
Debug.ShouldStop(1024);
if (RemoteObject.solveBoolean(">",main.mostCurrent._modulkoneksi._results /*RemoteObject*/ .runMethod(true,"RowCount"),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 77;BA.debugLine="username = ModulKoneksi.ResultS.GetString2(\"use";
Debug.ShouldStop(4096);
main._username = main.mostCurrent._modulkoneksi._results /*RemoteObject*/ .runMethod(true,"GetString2",(Object)(RemoteObject.createImmutable("username")));
 BA.debugLineNum = 79;BA.debugLine="ModulKoneksi.MHandler.Close";
Debug.ShouldStop(16384);
main.mostCurrent._modulkoneksi._mhandler /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 81;BA.debugLine="Activity.Finish";
Debug.ShouldStop(65536);
main.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 82;BA.debugLine="StartActivity(Profile)";
Debug.ShouldStop(131072);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((main.mostCurrent._profile.getObject())));
 }else {
 BA.debugLineNum = 85;BA.debugLine="MsgboxAsync(\"Password Tidak Ditemukan\", \"Info\")";
Debug.ShouldStop(1048576);
main.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("Password Tidak Ditemukan")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Info"))),main.processBA);
 BA.debugLineNum = 86;BA.debugLine="Password.Text = \"\"";
Debug.ShouldStop(2097152);
main.mostCurrent._password.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 87;BA.debugLine="Return";
Debug.ShouldStop(4194304);
if (true) return RemoteObject.createImmutable("");
 };
 }else {
 BA.debugLineNum = 91;BA.debugLine="MsgboxAsync(\"Nama Pengguna Tidak Ditemukan\",\"Inf";
Debug.ShouldStop(67108864);
main.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("Nama Pengguna Tidak Ditemukan")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Info"))),main.processBA);
 BA.debugLineNum = 92;BA.debugLine="NamaPengguna.Text = \"\"";
Debug.ShouldStop(134217728);
main.mostCurrent._namapengguna.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 93;BA.debugLine="Return";
Debug.ShouldStop(268435456);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 96;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}

public static void initializeProcessGlobals() {
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        main_subs_0._process_globals();
profile_subs_0._process_globals();
tambahdata_subs_0._process_globals();
modulkoneksi_subs_0._process_globals();
starter_subs_0._process_globals();
main.myClass = BA.getDeviceClass ("b4a.example.main");
profile.myClass = BA.getDeviceClass ("b4a.example.profile");
tambahdata.myClass = BA.getDeviceClass ("b4a.example.tambahdata");
modulkoneksi.myClass = BA.getDeviceClass ("b4a.example.modulkoneksi");
starter.myClass = BA.getDeviceClass ("b4a.example.starter");
		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 16;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 19;BA.debugLine="Private xui As XUI";
main._xui = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper.XUI");
 //BA.debugLineNum = 21;BA.debugLine="Dim username As String";
main._username = RemoteObject.createImmutable("");
 //BA.debugLineNum = 22;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
}