'For excel VB 巨集
'フォルダ内のファイルを処理する
Sub ProcessFiles()

    Dim FolderPath As String
    Dim FileName As String
    Dim wb As Workbook
    Dim FileCount As Integer
    Dim strPath As String
    Dim lastModified As Date
    
    FileCount = 0
    FolderPath = Range("C3").Value
    FileName = Dir(FolderPath & "*.xlsm")
    
    If ThisWorkbook.Sheets.Count >= 2 Then
        DeleteResultSheet
    End If
    
    Do While FileName <> ""
        FileCount = FileCount + 1
        lastModified = FileDateTime(FolderPath & FileName)
        
        Set wb = GetObject(FolderPath & FileName)
        CheckAndWriteResult wb, FileCount, FolderPath, lastModified
        
        wb.Close SaveChanges:=False
        FileName = Dir
    Loop
    
    MsgBox ("終わりました。")
End Sub


'結果シートがある時、古い結果シートを削除します
Sub DeleteResultSheet()

    Dim ws As Worksheet
    Dim resultSheetExists As Boolean
    
    resultSheetExists = False
    
    For Each ws In ThisWorkbook.Sheets
        If ws.Name = "result" Then
            resultSheetExists = True
            Exit For
        End If
    Next ws
    
    Application.DisplayAlerts = False
    ThisWorkbook.Sheets("result").Delete
    Application.DisplayAlerts = True

End Sub


'結果をチェックして書き込み
Sub CheckAndWriteResult(wb As Workbook, ByVal FileCount As Integer, ByVal FolderPath As String, ByVal lastModified As Date)

    Dim wsSource As Worksheet
    Dim wsResult As Worksheet
    Dim hasValues As Boolean
    Dim hasGokaku As Boolean
    Dim cellResult As Range
    Dim strIndex As Integer

    Set wsSource = wb.Sheets("単体テスト仕様書兼報告書")
    
    '最初にシートを追加する
    Set wsResult = AddResultSheet
    SettingResultSheet wsResult, FolderPath

    'セルのインデックスをするカウント
    strIndex = 3 + (FileCount - 1)
    wsResult.Cells(strIndex, "A").Value = wb.Name

    ReadWrite strIndex, wsSource, wsResult, lastModified
    
    hasValues = CheckValues(wsSource)
    hasGokaku = CheckGokaku(wsSource)
    
    Set cellResult = wsResult.Cells(strIndex, "C")
    WriteResult cellResult, hasValues, hasGokaku
    
    NgColor wsResult, strIndex
    
End Sub


' シートを追加する関数、シートを返す
Function AddResultSheet() As Worksheet
    
    If ThisWorkbook.Sheets.Count = 1 And ThisWorkbook.Sheets(1).Name <> "result" Then
        Set AddResultSheet = ThisWorkbook.Sheets.Add
        AddResultSheet.Name = "Result"
    Else
        Set AddResultSheet = ThisWorkbook.Sheets("Result")
    End If
    
End Function


' シートの書式を設定する
Sub SettingResultSheet(ByVal wsResult As Worksheet, ByVal FolderPath As String)

    Dim currentTime As Date
    currentTime = Now
    
    With wsResult
        .Columns("A").ColumnWidth = 40
        .Columns("B").ColumnWidth = 15
        .Columns("C").ColumnWidth = 12
        .Columns("D").ColumnWidth = 11
        .Columns("E").ColumnWidth = 11
        
        .Range("A1").Value = "ファイルパス： " & FolderPath
        .Range("B1").Value = "実施日： " & Format(currentTime, "yyyy/mm/dd hh:mm")
        .Range("B1:D1").Merge
        
        .Range("A2").Value = "ファイル名"
        .Range("B2").Value = "ファイル更新日時"
        .Range("C2").Value = "チェック結果"
        
        .Range("D2").Value = "システム名"
        .Range("E2").Value = "モジュール名"
        .Range("F2").Value = "作成日"
        .Range("G2").Value = "作成者"
        .Range("H2").Value = "確認日"
        
        .Range("I2").Value = "確認者"
        .Range("J2").Value = "実施者"
        .Range("K2").Value = "開始日"
        .Range("L2").Value = "終了日"
        .Range("M2").Value = "状況"
        
        .Range("B:M").HorizontalAlignment = xlCenter
        .Range("B1").HorizontalAlignment = xlLeft
        .Range("A2:M2").Interior.Color = RGB(102, 204, 255)
    End With
End Sub


'読み込みと書き込み
Sub ReadWrite(strIndex As Integer, wsSource As Worksheet, wsResult As Worksheet, ByVal lastModified As Date)

    Dim systemsName As Range
    Dim moduleName As Range
    Dim cellGoukaku As Range
    
    Set systemsName = wsResult.Cells(strIndex, "D")
    Set moduleName = wsResult.Cells(strIndex, "E")
    Set cellGoukaku = wsResult.Cells(strIndex, "M")
    
    systemsName.Value = wsSource.Range("A3").Value
    moduleName.Value = wsSource.Range("E3").Value
    cellGoukaku.Value = wsSource.Range("J11").Value
    wsResult.Cells(strIndex, "B").Value = lastModified
    
    wsSource.Range("A6:G6").Copy Destination:=wsResult.Cells(strIndex, "F")
    
    With wsResult.Range("F" & strIndex & ":L" & strIndex)
        .Borders.LineStyle = xlNone
        .Interior.Pattern = xlNone
    End With
    
End Sub


'作成日から終了日まてに値があるかチェックする
Function CheckValues(ws As Worksheet) As Boolean
    Dim i As Integer
    
    For i = 1 To 7
        If ws.Cells(6, i).Value = "" Then
            CheckValues = False
            Exit Function
        End If
    Next i
    
    CheckValues = True
End Function


' 状況セルの合格をチェックする
Function CheckGokaku(ws As Worksheet) As Boolean

    Dim goukakuValue As String
    goukakuValue = ws.Range("J11").Value

    If goukakuValue = "合格" Then
        CheckGokaku = True
    Else
        CheckGokaku = False
    End If

End Function


'書き込みの結果を判断して
Sub WriteResult(ByVal cellResult As Range, ByVal hasValues As Boolean, ByVal hasGokaku As Boolean)
    
    If hasValues And hasGokaku Then
        cellResult.Value = "OK"
    Else
        cellResult.Value = "NG"
        cellResult.Font.Color = RGB(255, 0, 0)
    End If
    
End Sub


'値がないか未達の場合は黄色にする
Sub NgColor(ws As Worksheet, ByVal strIndex As Integer)

    Dim rng As Range
    Dim cell As Range
    Dim goukaku As String
    
    Set rng = ws.Range("F" & strIndex & ":M" & strIndex)
    
    For Each cell In rng
        If IsEmpty(cell.Value) Then
            cell.Interior.Color = RGB(255, 255, 0)
        End If
    Next cell
    
    goukaku = ws.Range("M" & strIndex).Value
    
    If goukaku = "未達" Or goukaku = "" Then
        ws.Range("M" & strIndex).Interior.Color = RGB(255, 255, 0)
    End If

End Sub
