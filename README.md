# pdfbox_YuLiLoo 
****
可以直接通过一个static变量制定dll文件路径 满足gscript的dll文件
不在src下的情况，可以指定dll文件到任意位置，自动读取32 64 so根
据平台的不同自动读取相关的dll，只需要通过制定dll文件路径即可。
下面是示例：
    `GhostscriptLibraryLoader.java`

32行修改了一点代码，用JNI增加了一个工程下dll的搜索路径。

  `  String arch = System.getProperty("sun.arch.data.model");`

	    libName = "gsdll" + arch;
        String pathDll = Ghostscript.class.getResource("/").getPath()+"../dll/";
        NativeLibrary.addSearchPath(libName, pathDll);
