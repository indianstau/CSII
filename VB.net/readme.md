###  23/09 現場  
VB.net  筆記  
  
沒有{}    
```vb.net
Private length As Double
Public Sub XXX()
'我是註解  
Console.WriteLine("A rea = " & vbCrLf & "1" & Str(area))
'Str() 轉型, vbCrLf 換行符, 參數沒有+,是 &  
End Sub
  
Public Function GetArea() As Double  
End Function

Enum Colors
    red = 1
    green = 4
    blue = 6
    violet = 7
End Enum

Shared Sub Main()
  'Dim 命名
  Dim StudentID As Integer = 100
  Dim r As New test()
  Console.WriteLine("the color red is :" & Colors.red)
End Sub
```

