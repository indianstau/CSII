###  23/09 現場  
VB.net  筆記  
  
沒有{}    
```vb.net
Public Function GetArea() As Double  
End Function

Module Program
  'Main 今天要帶參數出門
  Sub Main(args As String())
  End Sub
End Module
```

命名方式/註解   
```vb.net
Private length As Double
    'Dim As
    Dim StudentID As Integer = 100
    Dim r As New test()
```

Str() 轉型, vbCrLf 換行符, 參數沒有+,是 &   
```vb.net
Public Sub XXX()
  Console.WriteLine("A rea = " & vbCrLf & "1" & Str(area))
End Sub
```

枚舉 很好用  
```vb.net    
Enum Colors
    red = 1
    green = 4
    blue = 6
    violet = 7
End Enum

Shared Sub Main()
    Console.WriteLine("the color red is :" & Colors.red)
End Sub
```

If else  
```vb.net
    If length = 4 Then
        Console.WriteLine("I am ture!")
    Else
        Console.WriteLine("false")
    End If
```  

