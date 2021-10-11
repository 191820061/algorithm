<h1 align='center'>项目0总结</h1>

```
   花了一天的时间终于完成了Proj0，总体来说并没有什么难度，代码量也并不是很多，NBody.java与Planet.java的代码量总共加起来也就150行左右。不过毕竟是项目0,该项目的实现过程中并没有用到任何复杂的数据结构和算法，只是用来加深java的一些基本操作的理解。
   该项目的第一部分是创建一个Planet类,并且根据引力公式实现calcDistance，calcForceExertedBy，calcForceExertedByX and calcForceExertedByY，calcNetForceExertedByX and calcNetForceExertedByY，和update等方法。基本上只要根据它提供的引力公式就可以很快的写出，这一部分并不难。
   该项目的第一部分是创建一个NBody类，这个类是实现球体运行模拟器的主要部分。这一部分主要是要熟悉In类的一些方法的使用，比如readInt(),readDouble,readString(),以及使用stdDraw绘制背景和多个Planet对象。接下来是使用Planet的update函数来不断修改Planet的位置与加速度，并且不断刷新画布上的图片，也就是Creating an Animation。最后的收尾工作是打印出球体完成最后一次update后的数据。这一部分应该是最简单的了因为在指导书上就提供了如何打印的方法，当然你可以选择不用。
   最后，在下面的这张图片是我的proj0的autograde Score。完成就当六
```



![image-20211011120324024](C:\Users\13047\AppData\Roaming\Typora\typora-user-images\image-20211011120324024.png)



