B4A=true
Group=Apps Group
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
	Dim xui As XUI

	Dim CC As ContentChooser
	
End Sub

Sub Globals
	'These global variables will be redeclared each time the activity is created.
	'These variables can only be accessed from this module.

	Private pnlTambahPersyaratan As Panel
	Private pnlPersyaratan As Panel
	Private xclv As CustomListView
	Private lblpersyaratan As B4XView
	Private lblfile As B4XView
	Private Button1 As B4XView
	Private Panel1 As B4XView
	Private search As EditText
	Private txtPersyaratan As EditText
	Private lblPilihFile As Label
	
	Dim fd As FileDialog
	
'	Dim su As StringUtils
	Dim imgstr As String
'	Dim InputStream1 As InputStream
'	Dim OutputStream1 As OutputStream
'	Dim Buffer() As Byte
	Private btnSave As Button
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("TambahPersyaratan")
	
	pnlPersyaratan.Visible = True
	pnlTambahPersyaratan.Visible = False

	showItem
	
	xclv.DefaultTextColor = Colors.Black
	
	fd.TextColor = Colors.Black
End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub

'==================== Read
Sub showItem
	ModulKoneksi.koneksi
	
	xclv.Clear
	
	ModulKoneksi.ResultS = ModulKoneksi.MHandler.Query("SELECT * FROM `tb_akunwarga` INNER JOIN tb_persyaratan ON tb_akunwarga.id_penduduk = tb_persyaratan.id_penduduk WHERE username = '" & Main.username & "'")

	For i = 0 To ModulKoneksi.ResultS.RowCount - 1
		ModulKoneksi.ResultS.Position  = i
		Dim p As Panel
		p = xui.CreatePanel("")
		p.Color = Colors.Transparent
		p.SetLayoutAnimated(0, 0, 0, xclv.AsView.Width, 50dip)
		p.LoadLayout("Item")

		lblpersyaratan.Text = ("Nama Persyaratan : " & ModulKoneksi.ResultS.GetString2("nama_persyaratan"))
		lblfile.Text = ("File : " & ModulKoneksi.ResultS.GetString2("file_persyaratan"))
		Button1.Text = (ModulKoneksi.ResultS.GetString2("id_persyaratan"))
		xclv.Add(p, "")
	Next
	
	ModulKoneksi.MHandler.Close
End Sub

'==================== Search
Sub FilterList
	ModulKoneksi.koneksi
	
	xclv.Clear
	ModulKoneksi.ResultS = ModulKoneksi.MHandler.Query("SELECT * FROM tb_persyaratan WHERE nama_persyaratan LIKE '%" & search.Text & "%' ORDER BY id_persyaratan ASC")
	
	For i = 0 To ModulKoneksi.ResultS.RowCount - 1
		Dim p As Panel
		p = xui.CreatePanel("")
		p.Color = Colors.Transparent
		p.LoadLayout("Item")
		p.SetLayoutAnimated(0, 0, 0, xclv.AsView.Width, 50dip)
		lblpersyaratan.Text = ("Nama Persyaratan : " & ModulKoneksi.ResultS.GetString2("nama_persyaratan"))
		lblfile.Text = ("File : " & ModulKoneksi.ResultS.GetString2("file_persyaratan"))
		Button1.Text  = (ModulKoneksi.ResultS.GetString2("id_persyaratan"))
		xclv.Add(p, "")
	Next
	
	ModulKoneksi.MHandler.Close
End Sub
Private Sub search_EnterPressed
	FilterList
End Sub

Private Sub btnTambahData_Click
	pnlPersyaratan.Visible = False
	pnlTambahPersyaratan.Visible = True
End Sub

Private Sub btnBack_Click
	pnlPersyaratan.Visible = True
	pnlTambahPersyaratan.Visible = False
End Sub 

Private Sub Profil_Click
	Activity.Finish
	StartActivity(Profile)
End Sub

Private Sub btnPict_Click
'	CC.Initialize("imgChooser")
'	CC.Show("image/*","Choose File")

'	Wait For CC_Result (Success As Boolean, Dir As String, FileName As String)
'	If Success Then
'		zimvImage.SetBitmap(LoadBitmap(Dir,FileName))
'		TabHost1.CurrentTab=2
'	Else
'		xui.Msgbox2Async(LastException,"501: Programmfehler!", _
'            "OK","","",Main.imgError)
'	End If

	Dim i As Int
	
	fd.FilePath = File.DirRootExternal
	i = fd.Show("Pilih File", "Yes", "", "Cancel", Null)
	If i = DialogResponse.POSITIVE Then
		lblPilihFile.Text = fd.ChosenName
	End If

End Sub

'==================== Pilih File


Private Sub btnSave_Click
	If txtPersyaratan.Text = "" Then
		MsgboxAsync("Masukkan Persyaratan", "Info")
		Return
	End If
	
	If btnSave.Text = "Simpan" Then
		
		ModulKoneksi.koneksi
	
		ModulKoneksi.ResultS = ModulKoneksi.MHandler.Query("SELECT * FROM tb_persyaratan WHERE nama_persyaratan='" & txtPersyaratan.Text & "'")
		If ModulKoneksi.ResultS.RowCount > 0 Then
			MsgboxAsync("Persyaratan sudah tersedia", "Info")
			txtPersyaratan.Text = ""
			ModulKoneksi.MHandler.Close
			Return
		End If
		
		ModulKoneksi.MHandler.Exec("INSERT INTO tb_persyaratan VALUE('" & txtPersyaratan.Text &"', '" & imgstr & "')")
	
		tampilanAwal
		
		ModulKoneksi.MHandler.Close
	
	End If
End Sub

Sub tampilanAwal
	txtPersyaratan.Text = ""
	lblPilihFile.Text = ""
	
	showItem
	
	pnlPersyaratan.Visible = True
	pnlTambahPersyaratan.Visible = False
End Sub