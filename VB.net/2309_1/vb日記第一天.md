###  Jp 第一個現場  
VB.net  筆記  （冗言語言）
  
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

For 迴圈  
```vb.net
For i As Integer = 1 To 5 Step 1
    Console.WriteLine("for count " & i)
Next
```
For Each  
```vb.net
Dim numbers() As Integer = {3, 5, 6, 7, 2}
For Each num As Integer In numbers
    Console.WriteLine(num)
Next
```

找出最大值  
```vb.net
Dim array() As Integer = {5, 49, 83, 14, 28, 1}

Function FindMaxNumber(array() As Integer) As Integer
    '第一位是5 固定的
    Dim max As Integer = array(0)
    For Each num As Integer In array
        If num > max Then
        '比5大時就存進去,往下一個比
            max = num
        End If
    Next
    Return max
End Function

Sub Main()
    Dim r As New test()
    Dim maxM As Integer = r.FindMaxNumber(array)
End Sub
```


### 快捷鍵  
ctrl + k + c  
ctrl + k + U  

大家好  
我叫冗言 VB.net  
今年有點大,快被淘汰了  

先來介紹命名方式需要Dim as的關鍵字  
Dim StudentID As Integer = 100  
然後沒有{} ,只有頭尾一對    
public sub  
end sub  
謝謝  

明天再來介紹Main 要帶參數出門  
