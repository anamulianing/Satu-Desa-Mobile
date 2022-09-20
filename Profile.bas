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

End Sub

Sub Globals
	'These global variables will be redeclared each time the activity is created.
	'These variables can only be accessed from this module.

	Private lv As ListView
	Private user As Label
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("Profile")
	
	listProfile
'	MsgboxAsync("Username : " & Main.username, "Info")

	user.Text = Main.username
End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)
 
End Sub

Sub listProfile
	lv.SingleLineLayout.Label.TextColor = Colors.Black
	lv.SingleLineLayout.Label.TextSize = 15
	
	ModulKoneksi.Koneksi
	
	lv.Clear
	
	ModulKoneksi.ResultS = ModulKoneksi.MHandler.Query("SELECT * FROM `tb_akunwarga` INNER JOIN tb_penduduk ON tb_akunwarga.id_penduduk = tb_penduduk.id_penduduk WHERE username = '" & Main.username & "'")
	
	For i = 0 To ModulKoneksi.ResultS.RowCount - 1
		ModulKoneksi.ResultS.Position = i
		lv.AddSingleLine("Nama : " & ModulKoneksi.ResultS.GetString2("nama"))
		lv.AddSingleLine("NIK : " & ModulKoneksi.ResultS.GetString2("nik"))
		lv.AddSingleLine("Jenis Kelamin : " & ModulKoneksi.ResultS.GetString2("jenis_kelamin"))
		lv.AddSingleLine("Tempat Lahir : " & ModulKoneksi.ResultS.GetString2("tempat_lahir"))
		lv.AddSingleLine("Tanggal Lahir : " & ModulKoneksi.ResultS.GetString2("tanggal_lahir"))
		lv.AddSingleLine("Agama : " & ModulKoneksi.ResultS.GetString2("agama"))
		lv.AddSingleLine("Pendidikan : " & ModulKoneksi.ResultS.GetString2("pendidikan"))
		lv.AddSingleLine("Jenis Pekerjaan : " & ModulKoneksi.ResultS.GetString2("jenis_pekerjaan"))
		lv.AddSingleLine("Golongan Darah : " & ModulKoneksi.ResultS.GetString2("golongan_darah"))
		lv.AddSingleLine("Status Perkawinan : " & ModulKoneksi.ResultS.GetString2("status_perkawinan"))
		lv.AddSingleLine("Tanggal Perkawinan : " & ModulKoneksi.ResultS.GetInt2("tanggal_perkawinan"))
		lv.AddSingleLine("Status Hubungan dalam Keluarga : " & ModulKoneksi.ResultS.GetString2("status_hubungan_dalam_keluarga"))
		lv.AddSingleLine("Kewarganegaraan : " & ModulKoneksi.ResultS.GetString2("kewarganegaraan"))
		lv.AddSingleLine("No. PASPOR / KITAP : " & ModulKoneksi.ResultS.GetString2("no_paspor") & " / " & ModulKoneksi.ResultS.GetString2("no_kitap"))
		lv.AddSingleLine("Nama Ayah / Ibu Kandung : " & ModulKoneksi.ResultS.GetString2("ayah") & " / " & ModulKoneksi.ResultS.GetString2("ibu"))
		lv.AddSingleLine("Alamat Lengkap : " & ModulKoneksi.ResultS.GetString2("alamat") & ModulKoneksi.ResultS.GetString2("rukun_tetangga") & " " & ModulKoneksi.ResultS.GetString2("rukun_warga") & " " & ModulKoneksi.ResultS.GetString2("kecamatan"))
		lv.AddSingleLine("Kontak : " & ModulKoneksi.ResultS.GetString2("no_handphone_aktif"))
	Next
	
	ModulKoneksi.MHandler.Close
End Sub

Private Sub Persyaratan_Click
	Activity.Finish
	StartActivity(TambahData)
End Sub
