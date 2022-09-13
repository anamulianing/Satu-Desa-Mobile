B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Activity
Version=11.8
@EndOfDesignText@
#Region  Activity Attributes 
	#FullScreen: False
	#IncludeTitle: True
#End Region

Sub Process_Globals
	'These global variables will be declared once when the application starts.
	'These variables can be accessed from all modules.

End Sub

Sub Globals
	'These global variables will be redeclared each time the activity is created.
	'These variables can only be accessed from this module.

	Private search As EditText
	
	Private xclv As CustomListView
	Private pnlPersyaratan As Panel
	Private pnlAdd As Panel
	
	Dim xui As XUI
	Private Button1 As B4XView
	Private lblPersyaratan As B4XView
	Private lblfile As B4XView
	
	Private Panel1 As B4XView
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("Persyaratan")

	pnlPersyaratan.Visible = True
	pnlAdd.Visible = False
	
	xclv.DefaultTextColor = Colors.Black
	
	showItem
End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub

'Menampilkan Data
Sub showItem
	ModulKoneksi.koneksi
	
	ModulKoneksi.ResultS = ModulKoneksi.MHandler.Query("SELECT * FROM tb_persyaratan ORDER BY id_persyaratan ASC")
	
	For i = 0 To ModulKoneksi.ResultS.RowCount - 1
		ModulKoneksi.ResultS.Position  = i
		Dim p As Panel
		p = xui.CreatePanel("")
		p.Color = Colors.Transparent
		p.SetLayoutAnimated(0, 0, 0, xclv.AsView.Width, 50dip)
		p.LoadLayout("item")

		lblPersyaratan.Text = (ModulKoneksi.ResultS.GetString2("nama_persyaratan"))
		lblfile.Text = (ModulKoneksi.ResultS.GetString2("file_persyaratan"))
		Button1.Text = (ModulKoneksi.ResultS.GetString2("id_persyaratan"))
		xclv.Add(p, "")
	Next
	
	ModulKoneksi.MHandler.Close
End Sub

Private Sub btnAdd_Click
	pnlPersyaratan.Visible = False
	pnlAdd.Visible = True
End Sub

Private Sub search_EnterPressed
	
End Sub

Private Sub btnBack_Click
	pnlPersyaratan.Visible = True
	pnlAdd.Visible = False
End Sub