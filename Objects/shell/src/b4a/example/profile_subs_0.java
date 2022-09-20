package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class profile_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (profile) ","profile",1,profile.mostCurrent.activityBA,profile.mostCurrent,20);
if (RapidSub.canDelegate("activity_create")) { return b4a.example.profile.remoteMe.runUserSub(false, "profile","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 20;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(524288);
 BA.debugLineNum = 22;BA.debugLine="Activity.LoadLayout(\"Profile\")";
Debug.ShouldStop(2097152);
profile.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("Profile")),profile.mostCurrent.activityBA);
 BA.debugLineNum = 24;BA.debugLine="listProfile";
Debug.ShouldStop(8388608);
_listprofile();
 BA.debugLineNum = 27;BA.debugLine="user.Text = Main.username";
Debug.ShouldStop(67108864);
profile.mostCurrent._user.runMethod(true,"setText",BA.ObjectToCharSequence(profile.mostCurrent._main._username /*RemoteObject*/ ));
 BA.debugLineNum = 28;BA.debugLine="End Sub";
Debug.ShouldStop(134217728);
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
		Debug.PushSubsStack("Activity_Pause (profile) ","profile",1,profile.mostCurrent.activityBA,profile.mostCurrent,34);
if (RapidSub.canDelegate("activity_pause")) { return b4a.example.profile.remoteMe.runUserSub(false, "profile","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 34;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(2);
 BA.debugLineNum = 36;BA.debugLine="End Sub";
Debug.ShouldStop(8);
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
		Debug.PushSubsStack("Activity_Resume (profile) ","profile",1,profile.mostCurrent.activityBA,profile.mostCurrent,30);
if (RapidSub.canDelegate("activity_resume")) { return b4a.example.profile.remoteMe.runUserSub(false, "profile","activity_resume");}
 BA.debugLineNum = 30;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(536870912);
 BA.debugLineNum = 32;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
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
 //BA.debugLineNum = 16;BA.debugLine="Private lv As ListView";
profile.mostCurrent._lv = RemoteObject.createNew ("anywheresoftware.b4a.objects.ListViewWrapper");
 //BA.debugLineNum = 17;BA.debugLine="Private user As Label";
profile.mostCurrent._user = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 18;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _listprofile() throws Exception{
try {
		Debug.PushSubsStack("listProfile (profile) ","profile",1,profile.mostCurrent.activityBA,profile.mostCurrent,38);
if (RapidSub.canDelegate("listprofile")) { return b4a.example.profile.remoteMe.runUserSub(false, "profile","listprofile");}
int _i = 0;
 BA.debugLineNum = 38;BA.debugLine="Sub listProfile";
Debug.ShouldStop(32);
 BA.debugLineNum = 39;BA.debugLine="lv.SingleLineLayout.Label.TextColor = Colors.Blac";
Debug.ShouldStop(64);
profile.mostCurrent._lv.runMethod(false,"getSingleLineLayout").getField(false,"Label").runMethod(true,"setTextColor",profile.mostCurrent.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 40;BA.debugLine="lv.SingleLineLayout.Label.TextSize = 15";
Debug.ShouldStop(128);
profile.mostCurrent._lv.runMethod(false,"getSingleLineLayout").getField(false,"Label").runMethod(true,"setTextSize",BA.numberCast(float.class, 15));
 BA.debugLineNum = 42;BA.debugLine="ModulKoneksi.Koneksi";
Debug.ShouldStop(512);
profile.mostCurrent._modulkoneksi.runVoidMethod ("_koneksi" /*RemoteObject*/ ,profile.mostCurrent.activityBA);
 BA.debugLineNum = 44;BA.debugLine="lv.Clear";
Debug.ShouldStop(2048);
profile.mostCurrent._lv.runVoidMethod ("Clear");
 BA.debugLineNum = 46;BA.debugLine="ModulKoneksi.ResultS = ModulKoneksi.MHandler.Quer";
Debug.ShouldStop(8192);
profile.mostCurrent._modulkoneksi._results /*RemoteObject*/  = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("mysql.mysqlhandler.ResultSetWrapper"), profile.mostCurrent._modulkoneksi._mhandler /*RemoteObject*/ .runMethod(false,"Query",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM `tb_akunwarga` INNER JOIN tb_penduduk ON tb_akunwarga.id_penduduk = tb_penduduk.id_penduduk WHERE username = '"),profile.mostCurrent._main._username /*RemoteObject*/ ,RemoteObject.createImmutable("'")))));
 BA.debugLineNum = 48;BA.debugLine="For i = 0 To ModulKoneksi.ResultS.RowCount - 1";
Debug.ShouldStop(32768);
{
final int step6 = 1;
final int limit6 = RemoteObject.solve(new RemoteObject[] {profile.mostCurrent._modulkoneksi._results /*RemoteObject*/ .runMethod(true,"RowCount"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step6 > 0 && _i <= limit6) || (step6 < 0 && _i >= limit6) ;_i = ((int)(0 + _i + step6))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 49;BA.debugLine="ModulKoneksi.ResultS.Position = i";
Debug.ShouldStop(65536);
profile.mostCurrent._modulkoneksi._results /*RemoteObject*/ .runMethod(true,"setPosition",BA.numberCast(int.class, _i));
 BA.debugLineNum = 50;BA.debugLine="lv.AddSingleLine(\"Nama : \" & ModulKoneksi.Result";
Debug.ShouldStop(131072);
profile.mostCurrent._lv.runVoidMethod ("AddSingleLine",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Nama : "),profile.mostCurrent._modulkoneksi._results /*RemoteObject*/ .runMethod(true,"GetString2",(Object)(RemoteObject.createImmutable("nama")))))));
 BA.debugLineNum = 51;BA.debugLine="lv.AddSingleLine(\"NIK : \" & ModulKoneksi.ResultS";
Debug.ShouldStop(262144);
profile.mostCurrent._lv.runVoidMethod ("AddSingleLine",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("NIK : "),profile.mostCurrent._modulkoneksi._results /*RemoteObject*/ .runMethod(true,"GetString2",(Object)(RemoteObject.createImmutable("nik")))))));
 BA.debugLineNum = 52;BA.debugLine="lv.AddSingleLine(\"Jenis Kelamin : \" & ModulKonek";
Debug.ShouldStop(524288);
profile.mostCurrent._lv.runVoidMethod ("AddSingleLine",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Jenis Kelamin : "),profile.mostCurrent._modulkoneksi._results /*RemoteObject*/ .runMethod(true,"GetString2",(Object)(RemoteObject.createImmutable("jenis_kelamin")))))));
 BA.debugLineNum = 53;BA.debugLine="lv.AddSingleLine(\"Tempat Lahir : \" & ModulKoneks";
Debug.ShouldStop(1048576);
profile.mostCurrent._lv.runVoidMethod ("AddSingleLine",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Tempat Lahir : "),profile.mostCurrent._modulkoneksi._results /*RemoteObject*/ .runMethod(true,"GetString2",(Object)(RemoteObject.createImmutable("tempat_lahir")))))));
 BA.debugLineNum = 54;BA.debugLine="lv.AddSingleLine(\"Tanggal Lahir : \" & ModulKonek";
Debug.ShouldStop(2097152);
profile.mostCurrent._lv.runVoidMethod ("AddSingleLine",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Tanggal Lahir : "),profile.mostCurrent._modulkoneksi._results /*RemoteObject*/ .runMethod(true,"GetString2",(Object)(RemoteObject.createImmutable("tanggal_lahir")))))));
 BA.debugLineNum = 55;BA.debugLine="lv.AddSingleLine(\"Agama : \" & ModulKoneksi.Resul";
Debug.ShouldStop(4194304);
profile.mostCurrent._lv.runVoidMethod ("AddSingleLine",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Agama : "),profile.mostCurrent._modulkoneksi._results /*RemoteObject*/ .runMethod(true,"GetString2",(Object)(RemoteObject.createImmutable("agama")))))));
 BA.debugLineNum = 56;BA.debugLine="lv.AddSingleLine(\"Pendidikan : \" & ModulKoneksi.";
Debug.ShouldStop(8388608);
profile.mostCurrent._lv.runVoidMethod ("AddSingleLine",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Pendidikan : "),profile.mostCurrent._modulkoneksi._results /*RemoteObject*/ .runMethod(true,"GetString2",(Object)(RemoteObject.createImmutable("pendidikan")))))));
 BA.debugLineNum = 57;BA.debugLine="lv.AddSingleLine(\"Jenis Pekerjaan : \" & ModulKon";
Debug.ShouldStop(16777216);
profile.mostCurrent._lv.runVoidMethod ("AddSingleLine",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Jenis Pekerjaan : "),profile.mostCurrent._modulkoneksi._results /*RemoteObject*/ .runMethod(true,"GetString2",(Object)(RemoteObject.createImmutable("jenis_pekerjaan")))))));
 BA.debugLineNum = 58;BA.debugLine="lv.AddSingleLine(\"Golongan Darah : \" & ModulKone";
Debug.ShouldStop(33554432);
profile.mostCurrent._lv.runVoidMethod ("AddSingleLine",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Golongan Darah : "),profile.mostCurrent._modulkoneksi._results /*RemoteObject*/ .runMethod(true,"GetString2",(Object)(RemoteObject.createImmutable("golongan_darah")))))));
 BA.debugLineNum = 59;BA.debugLine="lv.AddSingleLine(\"Status Perkawinan : \" & ModulK";
Debug.ShouldStop(67108864);
profile.mostCurrent._lv.runVoidMethod ("AddSingleLine",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Status Perkawinan : "),profile.mostCurrent._modulkoneksi._results /*RemoteObject*/ .runMethod(true,"GetString2",(Object)(RemoteObject.createImmutable("status_perkawinan")))))));
 BA.debugLineNum = 60;BA.debugLine="lv.AddSingleLine(\"Tanggal Perkawinan : \" & Modul";
Debug.ShouldStop(134217728);
profile.mostCurrent._lv.runVoidMethod ("AddSingleLine",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Tanggal Perkawinan : "),profile.mostCurrent._modulkoneksi._results /*RemoteObject*/ .runMethod(true,"GetInt2",(Object)(RemoteObject.createImmutable("tanggal_perkawinan")))))));
 BA.debugLineNum = 61;BA.debugLine="lv.AddSingleLine(\"Status Hubungan dalam Keluarga";
Debug.ShouldStop(268435456);
profile.mostCurrent._lv.runVoidMethod ("AddSingleLine",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Status Hubungan dalam Keluarga : "),profile.mostCurrent._modulkoneksi._results /*RemoteObject*/ .runMethod(true,"GetString2",(Object)(RemoteObject.createImmutable("status_hubungan_dalam_keluarga")))))));
 BA.debugLineNum = 62;BA.debugLine="lv.AddSingleLine(\"Kewarganegaraan : \" & ModulKon";
Debug.ShouldStop(536870912);
profile.mostCurrent._lv.runVoidMethod ("AddSingleLine",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Kewarganegaraan : "),profile.mostCurrent._modulkoneksi._results /*RemoteObject*/ .runMethod(true,"GetString2",(Object)(RemoteObject.createImmutable("kewarganegaraan")))))));
 BA.debugLineNum = 63;BA.debugLine="lv.AddSingleLine(\"No. PASPOR / KITAP : \" & Modul";
Debug.ShouldStop(1073741824);
profile.mostCurrent._lv.runVoidMethod ("AddSingleLine",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("No. PASPOR / KITAP : "),profile.mostCurrent._modulkoneksi._results /*RemoteObject*/ .runMethod(true,"GetString2",(Object)(RemoteObject.createImmutable("no_paspor"))),RemoteObject.createImmutable(" / "),profile.mostCurrent._modulkoneksi._results /*RemoteObject*/ .runMethod(true,"GetString2",(Object)(RemoteObject.createImmutable("no_kitap")))))));
 BA.debugLineNum = 64;BA.debugLine="lv.AddSingleLine(\"Nama Ayah / Ibu Kandung : \" &";
Debug.ShouldStop(-2147483648);
profile.mostCurrent._lv.runVoidMethod ("AddSingleLine",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Nama Ayah / Ibu Kandung : "),profile.mostCurrent._modulkoneksi._results /*RemoteObject*/ .runMethod(true,"GetString2",(Object)(RemoteObject.createImmutable("ayah"))),RemoteObject.createImmutable(" / "),profile.mostCurrent._modulkoneksi._results /*RemoteObject*/ .runMethod(true,"GetString2",(Object)(RemoteObject.createImmutable("ibu")))))));
 BA.debugLineNum = 65;BA.debugLine="lv.AddSingleLine(\"Alamat Lengkap : \" & ModulKone";
Debug.ShouldStop(1);
profile.mostCurrent._lv.runVoidMethod ("AddSingleLine",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Alamat Lengkap : "),profile.mostCurrent._modulkoneksi._results /*RemoteObject*/ .runMethod(true,"GetString2",(Object)(RemoteObject.createImmutable("alamat"))),profile.mostCurrent._modulkoneksi._results /*RemoteObject*/ .runMethod(true,"GetString2",(Object)(RemoteObject.createImmutable("rukun_tetangga"))),RemoteObject.createImmutable(" "),profile.mostCurrent._modulkoneksi._results /*RemoteObject*/ .runMethod(true,"GetString2",(Object)(RemoteObject.createImmutable("rukun_warga"))),RemoteObject.createImmutable(" "),profile.mostCurrent._modulkoneksi._results /*RemoteObject*/ .runMethod(true,"GetString2",(Object)(RemoteObject.createImmutable("kecamatan")))))));
 BA.debugLineNum = 66;BA.debugLine="lv.AddSingleLine(\"Kontak : \" & ModulKoneksi.Resu";
Debug.ShouldStop(2);
profile.mostCurrent._lv.runVoidMethod ("AddSingleLine",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Kontak : "),profile.mostCurrent._modulkoneksi._results /*RemoteObject*/ .runMethod(true,"GetString2",(Object)(RemoteObject.createImmutable("no_handphone_aktif")))))));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 69;BA.debugLine="ModulKoneksi.MHandler.Close";
Debug.ShouldStop(16);
profile.mostCurrent._modulkoneksi._mhandler /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 70;BA.debugLine="End Sub";
Debug.ShouldStop(32);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _persyaratan_click() throws Exception{
try {
		Debug.PushSubsStack("Persyaratan_Click (profile) ","profile",1,profile.mostCurrent.activityBA,profile.mostCurrent,72);
if (RapidSub.canDelegate("persyaratan_click")) { return b4a.example.profile.remoteMe.runUserSub(false, "profile","persyaratan_click");}
 BA.debugLineNum = 72;BA.debugLine="Private Sub Persyaratan_Click";
Debug.ShouldStop(128);
 BA.debugLineNum = 73;BA.debugLine="Activity.Finish";
Debug.ShouldStop(256);
profile.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 74;BA.debugLine="StartActivity(TambahData)";
Debug.ShouldStop(512);
profile.mostCurrent.__c.runVoidMethod ("StartActivity",profile.processBA,(Object)((profile.mostCurrent._tambahdata.getObject())));
 BA.debugLineNum = 75;BA.debugLine="End Sub";
Debug.ShouldStop(1024);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 10;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
}