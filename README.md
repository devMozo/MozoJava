# MozoJava

## Questions in english: 

### Maven

#### Explanation of the Maven's Goals:
  -   "mvn clean": cleans up artifacts created by prior builds.
  -   "mvn compile": compile the source code of the project.
  -   "mvn package": take the compiled code and package it in its distributable format, such as a JAR.
  -   "mvn install": install the package into the local repository, for use as a dependency in other projects locally.

#### Explanation of the Maven's Scopes:
  -   "compile": This is the default scope, used if none is specified. Compile dependencies are available in all classpaths of a project. Furthermore, those dependencies are propagated to dependent projects.
  -   "provided": This is much like compile, but indicates you expect the JDK or a container to provide the dependency at runtime. For example, when building a web application for the Java Enterprise Edition, you would set the dependency on the Servlet API and related Java EE APIs to scope provided because the web container provides those classes. This scope is only available on the compilation and test classpath, and is not transitive.
  -   "runtime": This scope indicates that the dependency is not required for compilation, but is for execution. It is in the runtime and test classpaths, but not the compile classpath.
  -   "test": This scope indicates that the dependency is not required for normal use of the application, and is only available for the test compilation and execution phases. This scope is not transitive.
  -   "system": This scope is similar to provided except that you have to provide the JAR which contains it explicitly. The artifact is always available and is not looked up in a repository.
  -   "import (only available in Maven 2.0.9 or later)": This scope is only supported on a dependency of type pom in the <dependencyManagement> section. It indicates the dependency to be replaced with the effective list of dependencies in the specified POM's <dependencyManagement> section. Since they are replaced, dependencies with a scope of import do not actually participate in limiting the transitivity of a dependency.

#### Archetype:
In short, Archetype is a Maven project templating toolkit. An archetype is defined as an original pattern or model from which all other things of the same kind are made. The name fits as we are trying to provide a system that provides a consistent means of generating Maven projects. Archetype will help authors create Maven project templates for users, and provides users with the means to generate parameterized versions of those project templates.

####  Maven's Structure

- src
  - main
    - java
    - resources
  - test
    - java
    - resources
- pom.xml

#### Differences between Archetype and Artifact
Artifact is the output of the build. It's the thing that the build creates. Simply put, if you are building a jar, it's the jar. If it's a war, it's the war.

Artifacts are also inputs to the build. Many times, software modules depend on other. So, if module A depends on module B, module A needs module B's artifacts.

### Spring

#### @Component

This is a general-purpose stereotype annotation indicating that the class is a spring component.

**What’s special about @Component**

<context:component-scan> only scans @Component and does not look for @Controller, @Service and @Repository in general. They are scanned because they themselves are annotated with @Component.

#### @Repository

This is to indicate that the class defines a data repository.

**What’s special about @Repository?**

In addition to pointing out that this is an Annotation based Configuration, @Repository’s job is to catch Platform specific exceptions and re-throw them as one of Spring’s unified unchecked exception. And for this, we’re provided with PersistenceExceptionTranslationPostProcessor, that we are required to add in our Spring’s application context.

#### @Service

@Services hold business logic and call method in repository layer.

**What’s special about @Service?**

Apart from the fact that it is used to indicate that it's holding the business logic, there’s no noticeable speciality that this annotation provides, but who knows, spring may add some additional exceptional in future.

#### @Controller

The @Controller annotation indicates that a particular class serves the role of a controller. The @Controller annotation acts as a stereotype for the annotated class, indicating its role.

**What’s special about @Controller?**

We cannot switch this annotation with any other like @Service or @Repository, even though they look same. The dispatcher scans the classes annotated with @Controller and detects @RequestMapping annotations within them. We can only use @RequestMapping on @Controller annotated classes.

### REST

#### Verbs

**GET:** Use GET requests to retrieve resource representation/information only – and not to modify it in any way. As GET requests do not change the state of resource, these are said to be safe methods. Additionally, GET APIs should be idempotent, which means that making multiple identical requests must produce same result everytime until another API (POST or PUT) has changed the state of resource on server.

**POST:** Use POST APIs to create new subordinate resources, e.g. a file is subordinate to a directory containing it or a row is subordinate to a database table. Talking strictly in terms of REST, POST methods are used to create a new resource into the collection of resources.

**PUT:** Use PUT APIs primarily to update existing resource (if resource does not exist then API may decide to create a new resource or not). If a new resource has been created by the PUT API, the origin server MUST inform the user agent via the HTTP response code 201 (Created) response and if an existing resource is modified, either the 200 (OK) or 204 (No Content) response codes SHOULD be sent to indicate successful completion of the request.

**DELETE:** As the name applies, DELETE APIs are used to delete resources (identified by the Request-URI).
A successful response of DELETE requests SHOULD be HTTP response code 200 (OK) if the response includes an entity describing the status, 202 (Accepted) if the action has been queued, or 204 (No Content) if the action has been performed but the response does not include an entity.

**PATCH:** HTTP PATCH requests are to make partial update on a resource. If you see PUT requests also modify a resource entity so to make more clear – PATCH method is the correct choice for partially updating an existing resource and PUT should only be used if you’re replacing a resource in it’s entirety.  

## Preguntas en Español:

### Maven

#### Explicación de los objetivos de Maven:
  - "mvn clean": limpia los artefactos creados por versiones anteriores.
  - "mvn compile": compila el código fuente del proyecto.
  - "paquete mvn": tome el código compilado y empaquételo en su formato distribuible, como un JAR.
  - "mvn install": instala el paquete en el repositorio local, para usarlo como dependencia en otros proyectos localmente.

#### Explicación de los alcances de Maven:
  - "compilar": este es el alcance predeterminado, utilizado si no se especifica ninguno. Las dependencias de compilación están disponibles en todos los classpaths de un proyecto. Además, esas dependencias se propagan a proyectos dependientes.
  - "proporcionado": Esto es muy similar a la compilación, pero indica que espera que el JDK o un contenedor proporcione la dependencia en tiempo de ejecución. Por ejemplo, al crear una aplicación web para Java Enterprise Edition, debe establecer la dependencia de la API de Servlet y las API de Java EE relacionadas en el alcance proporcionado porque el contenedor web proporciona esas clases. Este alcance solo está disponible en el classpath de compilación y prueba, y no es transitivo.
  - "runtime": este ámbito indica que la dependencia no es necesaria para la compilación, sino que es para su ejecución. Está en los classpaths de tiempo de ejecución y de prueba, pero no en el classpath de compilación.
  - "prueba": este ámbito indica que la dependencia no es necesaria para el uso normal de la aplicación, y solo está disponible para las fases de compilación y ejecución de prueba. Este alcance no es transitivo.
  - "sistema": este alcance es similar al proporcionado, excepto que debe proporcionar el JAR que lo contiene explícitamente. El artefacto siempre está disponible y no se busca en un repositorio.
  - "importar (solo disponible en Maven 2.0.9 o posterior)": este alcance solo se admite en una dependencia de tipo pom en la sección <dependencyManagement>. Indica la dependencia que se reemplazará con la lista efectiva de dependencias en la sección <dependencyManagement> del POM especificado. Dado que son reemplazados, las dependencias con un alcance de importación en realidad no participan en la limitación de la transitividad de una dependencia.

#### Archetype:
En resumen, Archetype es un kit de herramientas de plantillas del proyecto Maven. Un arquetipo se define como un patrón o modelo original a partir del cual se hacen todas las demás cosas del mismo tipo. El nombre se adapta a medida que tratamos de proporcionar un sistema que proporcione medios consistentes para generar proyectos Maven. Archetype ayudará a los autores a crear plantillas de proyectos de Maven para los usuarios, y brinda a los usuarios los medios para generar versiones parametrizadas de esas plantillas de proyectos.

#### Estructura de Maven

- src
  - principal
    - java
    - recursos
  - prueba
    - java
    - recursos
- pom.xml

#### Diferencias entre Archetype y Artifact
Artefacto es el resultado de la compilación. Es lo que crea la construcción. En pocas palabras, si estás construyendo un frasco, es el frasco. Si es una guerra, es la guerra.

Los artefactos también son entradas para la construcción. Muchas veces, los módulos de software dependen de otros. Entonces, si el módulo A depende del módulo B, el módulo A necesita los artefactos del módulo B.

### Spring

#### @Component

Esta es una anotación de estereotipo de propósito general que indica que la clase es un componente de primavera.

** Lo especial de @ Component **

<context: component-scan> solo escanea @Component y no busca @Controller, @Service y @Repository en general. Se escanean porque están anotados con @Component.

#### @Repository

Esto es para indicar que la clase define un depósito de datos.

** ¿Qué hay de especial en @Repository? **

Además de señalar que se trata de una configuración basada en anotaciones, el trabajo de @ Repository es atrapar excepciones específicas de la plataforma y volver a lanzarlas como una de las excepciones sin marcar unificadas de Spring. Y para esto, se nos proporciona PersistenceExceptionTranslationPostProcessor, que debemos agregar en el contexto de aplicación de Spring.

#### @Service

@Services mantiene la lógica comercial y el método de llamada en la capa de repositorio.

** ¿Qué tiene de especial @Service? **

Además del hecho de que se usa para indicar que mantiene la lógica comercial, no hay una especialidad notable que proporcione esta anotación, pero quién sabe si la primavera puede agregar alguna excepción adicional en el futuro.

#### @Controller

La anotación @Controller indica que una clase en particular cumple la función de un controlador. La anotación @Controller actúa como un estereotipo para la clase anotada, lo que indica su función.

** ¿Qué tiene de especial @Controller? **

No podemos cambiar esta anotación por ninguna otra como @Service o @Repository, aunque tengan el mismo aspecto. El despachador escanea las clases anotadas con @Controller y detecta las anotaciones @RequestMapping dentro de ellas. Solo podemos usar @RequestMapping en @Controller clases anotadas.

### REST

#### Verbos

** GET: ** Utilice las solicitudes GET para recuperar la representación / información de recursos únicamente, y no para modificarla de ninguna manera. Como las solicitudes GET no cambian el estado del recurso, se dice que son métodos seguros. Además, las API GET deben ser idempotentes, lo que significa que al hacer varias solicitudes idénticas debe producir el mismo resultado cada vez hasta que otra API (POST o PUT) haya cambiado el estado del recurso en el servidor.

** POST: ** Use API POST para crear nuevos recursos subordinados, p. un archivo está subordinado a un directorio que lo contiene o una fila está subordinada a una tabla de base de datos. Hablando estrictamente en términos de REST, los métodos POST se usan para crear un nuevo recurso en la colección de recursos.

** PUT: ** Use las API de PUT principalmente para actualizar el recurso existente (si el recurso no existe, la API puede decidir crear un nuevo recurso o no). Si la API PUT ha creado un nuevo recurso, el servidor de origen DEBE informar al agente de usuario mediante la respuesta del código de respuesta HTTP 201 (Creado) y si se modifica un recurso existente, el 200 (OK) o el 204 (Sin contenido) los códigos de respuesta DEBEN enviarse para indicar la finalización exitosa de la solicitud.

** DELETE: ** A medida que se aplica el nombre, las API DELETE se utilizan para eliminar recursos (identificados por Request-URI).
Una respuesta exitosa de las solicitudes DELETE DEBERÍA ser el código de respuesta HTTP 200 (OK) si la respuesta incluye una entidad que describe el estado, 202 (Aceptado) si la acción se ha puesto en cola, o 204 (Sin contenido) si la acción se ha realizado pero el la respuesta no incluye una entidad.

** PATCH: ** Las solicitudes HTTP PATCH consisten en realizar una actualización parcial de un recurso. Si ve solicitudes PUT, también modifique una entidad de recursos para que quede más claro: el método PATCH es la opción correcta para actualizar parcialmente un recurso existente y PUT solo debe usarse si está reemplazando un recurso en su totalidad.

## 日本語の質問：

### Maven

#### Mavenの目標の説明：
   -  "mvn clean"：以前のビルドで作成されたアーティファクトをクリーンアップします。
   -  "mvn compile"：プロジェクトのソースコードをコンパイルします。
   -  "mvn package"：コンパイルされたコードを取り出し、JARなどの配布可能な形式でパッケージ化します。
   -  "mvn install"：パッケージをローカルリポジトリにインストールし、他のプロジェクトの依存関係としてローカルで使用します。

#### Mavenのスコープの説明：
   -  "compile"：これはデフォルトのスコープで、指定されていない場合に使用されます。コンパイルの依存関係は、プロジェクトのすべてのクラスパスで使用できます。さらに、これらの依存関係は依存するプロジェクトに伝播されます。
   -  "提供されました"：これはコンパイルとよく似ていますが、JDKまたはコンテナが実行時に依存関係を提供することを期待していることを示します。たとえば、Java Enterprise Edition用のWebアプリケーションを構築する場合、Webコンテナがこれらのクラスを提供するため、サーブレットAPIおよび関連するJava EE APIへの依存関係をスコープに設定します。このスコープは、コンパイルおよびテストのクラスパスでのみ使用でき、推移的ではありません。
   -  "runtime"：このスコープは、依存関係がコンパイルに必要ではなく、実行のためのものであることを示します。ランタイムとテストのクラスパスにありますが、コンパイルクラスパスにはありません。
   -  "test"：このスコープは、依存関係がアプリケーションの通常の使用に必要ではなく、テストのコンパイルおよび実行フェーズでのみ使用可能であることを示します。この範囲は推移的ではありません。
   -  "system"：このスコープは、明示的にそれを含むJARを提供しなければならない点を除けば、提供されるスコープと似ています。成果物は常に利用可能であり、リポジトリ内で検索されません。
   -  "import（Maven 2.0.9以降でのみ利用可能）"：このスコープは、<dependencyManagement>セクションのpomタイプの依存関係でのみサポートされています。これは、指定されたPOMの<dependencyManagement>セクションの依存関係の有効なリストで置き換えられる依存関係を示します。それらが置き換えられるため、インポートのスコープに依存することは、依存関係の推移性を制限することに実際には関与しません。
#### アーキタイプ：
要するに、ArchetypeはMavenプロジェクトのテンプレートツールキットです。アーキタイプは、同じ種類の他のすべてのものが作成される元のパターンまたはモデルとして定義されます。この名前は、Mavenプロジェクトを生成するための一貫した手段を提供するシステムを提供しようとしているときに適しています。 Archetypeは、作成者がMavenプロジェクトテンプレートをユーザ用に作成するのに役立ち、ユーザには、これらのプロジェクトテンプレートのパラメータ化されたバージョンを生成する手段を提供します。

#### Mavenの構造

 -  src
     - メイン
         -  java
         - リソース
     - テスト
         -  java
         - リソース
 -  pom.xml

####アーキタイプとアーティファクトの違い
アーティファクトはビルドの出力です。それはビルドが作成するものです。簡単に言えば、瓶を作る場合、それは瓶です。それが戦争であれば、それは戦争です。

成果物は、ビルドへのインプットです。多くの場合、ソフトウェアモジュールは他のモジュールに依存します。したがって、モジュールAがモジュールBに依存する場合、モジュールAはモジュールBの成果物を必要とします。

＃＃＃ 春

#### @Component

これは、そのクラスがスプリングコンポーネントであることを示す汎用ステレオタイプの注釈です。

** @コンポーネントの特別な点**

<context：component-scan>は@Componentをスキャンするだけで、一般的には@Controller、@Service、@Repositoryは検索しません。それらは@Componentで注釈が付けられているため、スキャンされます。

#### @リポジトリ

これは、クラスがデータリポジトリを定義していることを示します。

** @リポジトリの特色は何ですか？**

これがアノテーションベースのコンフィグレーションであることに加えて、@ Repositoryの仕事は、プラットフォーム固有の例外をキャッチして、それらをSpringの統一されたチェックされていない例外の1つとして再スローすることです。このために、Springのアプリケーションコンテキストで追加する必要があるPersistenceExceptionTranslationPostProcessorが提供されています。

#### @Service

@Servicesは、ビジネスロジックを保持し、リポジトリレイヤでメソッドを呼び出します。

** @Serviceの特色は何ですか？**

それがビジネスロジックを保持していることを示すために使用されていることは別として、このアノテーションが提供する顕著な専門はありませんが、誰が知っていれば、将来的には春がさらに優れたものになる可能性があります。

#### @Controller

@Controllerアノテーションは、特定のクラスがコントローラの役割を果たすことを示します。 @Controller注釈は注釈付きクラスのステレオタイプとして機能し、その役割を示します。

** @Controllerについて特別なものは何ですか？**

この注釈は、@Serviceや@Repositoryのように他のものと切り替えることはできません。ディスパッチャは、@Controllerで注釈が付けられたクラスをスキャンし、その中の@RequestMappingアノテーションを検出します。 @Controllerアノテートされたクラスでのみ@RequestMappingを使用できます。
＃＃＃ 残り

#### 動詞

** GET：** GETリクエストを使用して、リソース表現/情報のみを取得します。何も変更しません。 GETリクエストはリソースの状態を変更しないので、これは安全な方法と言われています。さらに、GET APIは冪等でなければなりません。つまり、複数の同一のリクエストを作成すると、別のAPI（POSTまたはPUT）がサーバー上のリソースの状態を変更するまで毎回同じ結果を生成する必要があります。

** POST：** POST APIを使用して、新しい従属リソースを作成します。ファイルはそれを含むディレクトリに従属するか、または行はデータベーステーブルの従属です。厳密にはRESTの観点から言えば、POSTメソッドはリソースのコレクションに新しいリソースを作成するために使用されます。

** PUT：** PUT APIを主に使用して既存のリソースを更新します（リソースが存在しない場合、APIは新しいリソースを作成するかどうかを決定する可能性があります）。新しいリソースがPUT APIによって作成された場合、元のサーバーはHTTP応答コード201（作成済み）応答を介してユーザーエージェントに通知しなければならず、既存のリソースが変更された場合、200（OK）または204応答コードは要求の正常終了を示すために送信されるべきです（SHOULD）。

** DELETE：**名前が適用されると、DELETE APIはリソース（Request-URIによって識別される）を削除するために使用されます。
DELETE要求の成功応答は、レスポンスにステータスを記述するエンティティが含まれる場合はHTTP応答コード200（OK）、アクションがキューに入れられている場合は202（Accepted）、アクションが実行された場合は204（No Content）応答にはエンティティは含まれません。

** PATCH：** HTTP PATCHリクエストは、リソースに対して部分的な更新を行うことです。 PUTリクエストが表示されている場合は、リソースエンティティを変更してより明確にしてください。PATCHメソッドは既存のリソースを部分的に更新するための正しい選択です。PUTはリソースを完全に置き換える場合にのみ使用してください。
