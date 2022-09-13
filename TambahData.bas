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

	Dim xui As XUI
	Private pnlTambahPersyaratan As Panel
	Private pnlPersyaratan As Panel
	Private xclv As CustomListView
	Private lblpersyaratan As B4XView
	Private lblfile As B4XView
	Private Button1 As B4XView
	Private Panel1 As B4XView
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("TambahPersyaratan")
	
	pnlPersyaratan.Visible = True
	pnlTambahPersyaratan.Visible = False

	showItem
	
	xclv.DefaultTextColor = Colors.Black
	
End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub

Sub showItem
	ModulKoneksi.koneksi
	
	xclv.Clear
	
	ModulKoneksi.ResultS = ModulKoneksi.MHandler.Query("SELECT * FROM tb_persyaratan ORDER BY id_persyaratan ASC")
	
	For i = 0 To ModulKoneksi.ResultS.RowCount - 1
		ModulKoneksi.ResultS.Position  = i
		Dim p As Panel
		p = xui.CreatePanel("")
		p.Color = Colors.Transparent
		p.SetLayoutAnimated(0, 0, 0, xclv.AsView.Width, 50dip)
		p.LoadLayout("Item")
'		Dim btn As Button = p.GetView(0)
'		btn.Tag = i

		lblpersyaratan.Text = (ModulKoneksi.ResultS.GetString2("nama_persyaratan"))
		lblfile.Text = (ModulKoneksi.ResultS.GetString2("file_persyaratan"))
		Button1.Text = (ModulKoneksi.ResultS.GetString2("id_persyaratan"))
		xclv.Add(p, "")
	Next
	
	ModulKoneksi.MHandler.Close
End Sub

Private Sub btnTambahData_Click
	pnlPersyaratan.Visible = False
	pnlTambahPersyaratan.Visible = True
End Sub

Private Sub btnBack_Click
	pnlPersyaratan.Visible = True
	pnlTambahPersyaratan.Visible = False
End Sub