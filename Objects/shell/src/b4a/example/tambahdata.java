
package b4a.example;

import java.io.IOException;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.PCBA;
import anywheresoftware.b4a.pc.RDebug;
import anywheresoftware.b4a.pc.RemoteObject;
import anywheresoftware.b4a.pc.RDebug.IRemote;
import anywheresoftware.b4a.pc.Debug;
import anywheresoftware.b4a.pc.B4XTypes.B4XClass;
import anywheresoftware.b4a.pc.B4XTypes.DeviceClass;

public class tambahdata implements IRemote{
	public static tambahdata mostCurrent;
	public static RemoteObject processBA;
    public static boolean processGlobalsRun;
    public static RemoteObject myClass;
    public static RemoteObject remoteMe;
	public tambahdata() {
		mostCurrent = this;
	}
    public RemoteObject getRemoteMe() {
        return remoteMe;    
    }
    
	public static void main (String[] args) throws Exception {
		new RDebug(args[0], Integer.parseInt(args[1]), Integer.parseInt(args[2]), args[3]);
		RDebug.INSTANCE.waitForTask();

	}
    static {
        anywheresoftware.b4a.pc.RapidSub.moduleToObject.put(new B4XClass("tambahdata"), "b4a.example.tambahdata");
	}

public boolean isSingleton() {
		return true;
	}
     public static RemoteObject getObject() {
		return myClass;
	 }

	public RemoteObject activityBA;
	public RemoteObject _activity;
    private PCBA pcBA;

	public PCBA create(Object[] args) throws ClassNotFoundException{
		processBA = (RemoteObject) args[1];
		activityBA = (RemoteObject) args[2];
		_activity = (RemoteObject) args[3];
        anywheresoftware.b4a.keywords.Common.Density = (Float)args[4];
        remoteMe = (RemoteObject) args[5];
		pcBA = new PCBA(this, tambahdata.class);
        main_subs_0.initializeProcessGlobals();
		return pcBA;
	}
public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _xui = RemoteObject.declareNull("anywheresoftware.b4a.objects.B4XViewWrapper.XUI");
public static RemoteObject _cc = RemoteObject.declareNull("anywheresoftware.b4a.phone.Phone.ContentChooser");
public static RemoteObject _pnltambahpersyaratan = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _pnlpersyaratan = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _xclv = RemoteObject.declareNull("b4a.example3.customlistview");
public static RemoteObject _lblpersyaratan = RemoteObject.declareNull("anywheresoftware.b4a.objects.B4XViewWrapper");
public static RemoteObject _lblfile = RemoteObject.declareNull("anywheresoftware.b4a.objects.B4XViewWrapper");
public static RemoteObject _button1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.B4XViewWrapper");
public static RemoteObject _panel1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.B4XViewWrapper");
public static RemoteObject _search = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _txtpersyaratan = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _lblpilihfile = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _fd = RemoteObject.declareNull("anywheresoftware.b4a.agraham.dialogs.InputDialog.FileDialog");
public static RemoteObject _imgstr = RemoteObject.createImmutable("");
public static RemoteObject _btnsave = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static b4a.example.main _main = null;
public static b4a.example.profile _profile = null;
public static b4a.example.modulkoneksi _modulkoneksi = null;
public static b4a.example.starter _starter = null;
  public Object[] GetGlobals() {
		return new Object[] {"Activity",tambahdata.mostCurrent._activity,"btnSave",tambahdata.mostCurrent._btnsave,"Button1",tambahdata.mostCurrent._button1,"CC",tambahdata._cc,"fd",tambahdata.mostCurrent._fd,"imgstr",tambahdata.mostCurrent._imgstr,"lblfile",tambahdata.mostCurrent._lblfile,"lblpersyaratan",tambahdata.mostCurrent._lblpersyaratan,"lblPilihFile",tambahdata.mostCurrent._lblpilihfile,"Main",Debug.moduleToString(b4a.example.main.class),"ModulKoneksi",Debug.moduleToString(b4a.example.modulkoneksi.class),"Panel1",tambahdata.mostCurrent._panel1,"pnlPersyaratan",tambahdata.mostCurrent._pnlpersyaratan,"pnlTambahPersyaratan",tambahdata.mostCurrent._pnltambahpersyaratan,"Profile",Debug.moduleToString(b4a.example.profile.class),"search",tambahdata.mostCurrent._search,"Starter",Debug.moduleToString(b4a.example.starter.class),"txtPersyaratan",tambahdata.mostCurrent._txtpersyaratan,"xclv",tambahdata.mostCurrent._xclv,"xui",tambahdata._xui};
}
}