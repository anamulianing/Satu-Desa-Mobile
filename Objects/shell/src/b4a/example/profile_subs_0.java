package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class profile_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (profile) ","profile",2,profile.mostCurrent.activityBA,profile.mostCurrent,18);
if (RapidSub.canDelegate("activity_create")) { return b4a.example.profile.remoteMe.runUserSub(false, "profile","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 18;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(131072);
 BA.debugLineNum = 20;BA.debugLine="Activity.LoadLayout(\"Profile\")";
Debug.ShouldStop(524288);
profile.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("Profile")),profile.mostCurrent.activityBA);
 BA.debugLineNum = 22;BA.debugLine="End Sub";
Debug.ShouldStop(2097152);
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
		Debug.PushSubsStack("Activity_Pause (profile) ","profile",2,profile.mostCurrent.activityBA,profile.mostCurrent,28);
if (RapidSub.canDelegate("activity_pause")) { return b4a.example.profile.remoteMe.runUserSub(false, "profile","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 28;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 30;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
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
		Debug.PushSubsStack("Activity_Resume (profile) ","profile",2,profile.mostCurrent.activityBA,profile.mostCurrent,24);
if (RapidSub.canDelegate("activity_resume")) { return b4a.example.profile.remoteMe.runUserSub(false, "profile","activity_resume");}
 BA.debugLineNum = 24;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 26;BA.debugLine="End Sub";
Debug.ShouldStop(33554432);
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
 //BA.debugLineNum = 16;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _persyaratan_click() throws Exception{
try {
		Debug.PushSubsStack("Persyaratan_Click (profile) ","profile",2,profile.mostCurrent.activityBA,profile.mostCurrent,32);
if (RapidSub.canDelegate("persyaratan_click")) { return b4a.example.profile.remoteMe.runUserSub(false, "profile","persyaratan_click");}
 BA.debugLineNum = 32;BA.debugLine="Private Sub Persyaratan_Click";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 33;BA.debugLine="Activity.Finish";
Debug.ShouldStop(1);
profile.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 34;BA.debugLine="StartActivity(TambahData)";
Debug.ShouldStop(2);
profile.mostCurrent.__c.runVoidMethod ("StartActivity",profile.processBA,(Object)((profile.mostCurrent._tambahdata.getObject())));
 BA.debugLineNum = 35;BA.debugLine="End Sub";
Debug.ShouldStop(4);
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