# MozoJava

## Questions in english: 

1) You can take 0 if there are **more consumers than producters**, however, also you can make this with same quantity of consumers and producter but **with a different wainting time.**

2) They must be "sinchronyzed" because they only can be accessed **by one thread at the time.**

3) The shared resources are pieces of code that can be accessed by **more than one thread at the time.**

4) I'm going to explain you all ways that you have to instantiate a Thread:

+ With the Thread's Contructor:
	
		var tThread = new Thread();

+ With the Thread's Constructor passing to it an object that implements Runnable's Interface:
	
		var tThread = new Thread(new ObjectWithRunnable());

	**Remember that the object that implements the Runnable's interface, needs to overload the run() function.**

+ And the last ways, is by passing to the Thread's Constructor an object that implements Runnable's interface and also an String specifying the name of the Thread

	var tThread = new Thread(new ObjectWithRunnable(), "AltoThread");

## Preguntas en Español:

1) Puede tomar 0 si hay ** más consumidores que productores **, sin embargo, también puede hacerlo con la misma cantidad de consumidores y productores, pero ** con un tiempo de espera diferente. **

2) Deben ser "sinchronyzed" porque se puede acceder unicamente ** por un hilo a la vez. **

3) Los recursos compartidos son fragmentos de código a los que pueden acceder ** más de un hilo a la vez. **

4) Voy a explicarte todas las formas en que tienes que crear una instancia de un hilo:

+ Con el constructor del Thread:

var tThread = new Thread ();

+ Con el Constructor de Thread pasando a él un objeto que implementa la interfaz de Runnable:

var tThread = new Thread (new ObjectWithRunnable ());

** Recuerde que el objeto que implementa la interfaz de Runnable necesita sobrecargar la función run (). **

+ Y las últimas formas, es pasando al Constructor de Thread un objeto que implementa la interfaz de Runnable y también una cadena que especifica el nombre del subproceso

var tThread = new Thread (new ObjectWithRunnable (), "AltoThread");

## 日本語の質問：

1）**生産者よりも多くの消費者**がある場合は0を取ることができますが、消費者と生産者は同じ数量で**異なる作業時間で**これを行うことができます。**

2）それらは時には1つのスレッドで**アクセスできるので、 "シンクロニス化"しなければなりません**

3）共有リソースは、**複数のスレッドが同時にアクセスできるコードの一部です**

4）スレッドをインスタンス化する必要があるすべての方法を説明します。

+スレッドのコンストラクタで：

var tThread =新しいスレッド（）;

+スレッドのコンストラクタで、Runnableのインタフェースを実装するオブジェクトを渡します。

var tThread =新しいスレッド（新しいObjectWithRunnable（））;

** Runnableのインタフェースを実装するオブジェクトは、run（）関数をオーバーロードする必要があることに注意してください。**

+そして最後の方法は、Threadのコンストラクタに、Runnableのインタフェースを実装するオブジェクトとスレッドの名前を指定する文字列を渡すことです

var tThread =新しいスレッド（新しいObjectWithRunnable（）、 "AltoThread"）;
