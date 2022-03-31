书籍《Java设计模式》-刘伟
## 简单工厂模式

>简单工厂模式（Simple Factory Pattern）：定义一个工厂类，它可以根据参数的不同返回不同类的实例，被创建的实例通常都具有共同的父类。  

由于 简单工厂模式中用于创建实例的方法通常都是静态方法，因此简单工厂模式又被称为静态工厂(Static Factory Method)模式，它是一种创建型模式。

### 简单工厂模式结构

1. Factory（工厂角色）：又叫做工厂类，它是简单工厂模式的核心，负责实现创建所有产品实例的内部逻辑。对外提供静态的工厂方法，返回值类型为抽象类类型。
2. Product（抽象产品角色）：工厂类创建的所有对象的父类，封装了各种产品对象的公有方法。
3. ConcreteProduct（具体产品角色）：简单工厂模式的创建目标，所有被创建的对象都充当这个角色的某个具体的实例。它需要实现抽象产品角色的抽象方法。

![image-20220329222845689](https://gitee.com/snailjw/article-images/raw/master/typora/202203311134887.png)

### 创建对象与使用对象

Java中通常有以下几种创建对象的方式：

* 使用new关键字直接创建对象
* 通过反射机制创建对象
* 通过克隆方法创建对象
* 通过工厂类创建对象

工厂是强调：两个类A和B之间的关系应该仅仅是A创建B或者A使用B，而不能两种关系都有。

创建和使用分离可以防止用来实例化一个类的数据和代码在多个类中到处都是，可以将有关创建的知识搬移到一个工厂类中。但并不是需要为系统中的每个类都配置一个工厂类，如果一个类很简单，而且不存在太多变化，其构造过程也很简单，此时就无需为其提供工厂类，直接在使用之前实例化即可。

### 简单工厂模式优/缺点与适用环境

#### 简单工厂模式优点：

优点主要有如下：

1. 工厂类包含必要的判断逻辑，可以决定在什么时候创建哪一个产品类的实例，客户端可以免除直接创建产品对象的职责，而仅仅“消费”产品，简单工厂模式实现了对象创建和使用的分离。
2. 客户端无须知道所创建的具体产品类的类名，只需要知道具体产品类所对应的参数即可，对于一些复杂的类名，通过简单工厂模式可以在一定程度上减少使用者的记忆量。
3. 通过引入配置文件，可以在不修改任何客户端代码的情况下更换和增加新的具体产品类，在一定程度上提高了系统的灵活性。

#### 简单工厂模式缺点

缺点主要有如下：

1. 由于工厂类集中了所有产品的创建逻辑，职责过重，一旦不能正常工作，整个系统都要受到影响。
2. 使用简单工厂模式势必会增加系统中类的个数（引入了新的工厂类），增加了系统的复杂度和理解难度。
3. 系统扩展困难，一旦添加新产品就不得不修改工厂逻辑，在产品类型较多时有可能造成工厂逻辑过于复杂，不利于系统的扩展和维护。
4. 简单工厂模式由于使用了静态工厂方法，造成工厂角色无法形成基于继承的等级结构。

#### 简单工厂模式适用环境

在以下情况下可以考虑使用简单工厂模式：

* 工厂类负责创建的对象比较少，由于创建的对象较少，不会造成工厂方法中的业务逻辑太过复杂。
* 客户端只知道传人工厂类的参数，对于如何创建对象并不关心。

## 工厂方法模式

工厂方法模式是简单工厂模式的延伸，它继承了简单工厂模式的优点，同时还弥补了简单工厂模式的缺陷，更好的符合开闭原则的要求，在增加新的具体产品对象时不需要对已有的系统做任何修改。

### 工厂方法模式概述

简单工厂模式如果要新增一个具体的产品需要修改工厂类的代码，这在一定程度上违反了开闭原则。在工厂方法模式中不再提供一个统一的工厂类来创建所有的产品对象，而是针对不同的产品提供不同的工厂，系统提供一个与产品等级结构对应的工厂等级结构。

工厂方法模式的定义：

> 定义一个用于创建对象的接口，但是让子类决定将哪个类实例化。工厂方法模式让一个类的实例化延迟到其子类。

关于定义有如下说明：

* 简称为**工厂模式(Factory Pattern)**

* 又可称作**虚拟构造器模式(Virtual Constructor Pattern)**或**多态工厂模式(Polymorphic Factory Pattern)**

* **工厂父类负责定义创建产品对象的公共接口，而工厂子类则负责生成具体的产品对象。**

* 目的是**将产品类的实例化操作延迟到工厂子类中完成**，即**通过工厂子类来确定究竟应该实例化哪一个具体产品类。**

### 工厂方法模式结构与实现

#### 工厂方法模式结构

工厂方法模式的结构如图：

![image-20220330124911882](https://gitee.com/snailjw/article-images/raw/master/typora/202203311134376.png)

工厂方法模式包含4个角色：

1. **Product（抽象产品）：**它是定义产品的接口，是工厂方法模式所创建对象的超类型，也就是产品对象的公共父类。
2. **ConcreteProduct（具体产品）：**它实现了抽象产品接口，某种类型的具体产品由专门的具体工厂创建，具体工厂和具体产品直接一一对应。
3. **Factory（抽象工厂）：**在抽象工厂类中声明了工厂方法（Factory Method），用于返回一个产品。抽象工厂是工厂方法模式的核心，所有创建对象的工厂类都必须实现该接口。
4. **ConcreteFactory(具体工厂)：**它是抽象工厂类的子类，它实现了在抽象工厂中申明的工厂方法，并可由客户端调用，返回一个具体产品类的实例。

#### 工厂方法模式实现

与简单工厂模式相比，工厂方法模式最重要的特点是引入了抽象工厂角色，抽象工厂可以是接口，也可以是抽象类或者具体类。

典型代码如下：

```java
public interface Factory{
    public Product factoryMethod();
}
```

具体对象的创建由工厂子类负责，客户端针对抽象工厂编程，可在运行时指定具体工厂类，具体工厂类实现了工厂方法，不同的具体工厂可以创建不同的具体产品。

```java
public class ConcreteFactory implement Factory{
    @Override
    public Product factoryMethod(){
        return new ConcreteProduct();
    }
}
```

典型的客户端代码如：

```java
		……
		Factory factory = new ConcreteFactory(); 
		// 通过配置文件与反射机制实现
		// Factory factory = (Factory) XMLUtil.getBean("concreteProduct");
        Product product = factory.factoryMethod();
        product.someMethod();
		……
```

### 工厂方法模式应用实例

**实例说明：**

某系统运行日志记录器(Logger)可以通过多种途径保存系统的运行日志，例如通过文件记录或数据库记录，用户可以通过修改配置文件灵活地更换日志记录方式。在设计各类日志记录器时，开发人员发现需要对日志记录器进行一些初始化工作，初始化参数的设置过程较为复杂，而且某些参数的设置有严格的先后次序，否则可能会发生记录失败。

为了更好地封装记录器的初始化过程并保证多种记录器切换的灵活性，现使用工厂方法模式设计该系统。

**实例类图：**

![image-20220330220150017](https://gitee.com/snailjw/article-images/raw/master/typora/202203311135205.png)



具体代码实现参考项目代码：`factory-method-pattern`

### 工厂方法模式的重载

在某些情况下，可以提供一组重载的工厂方法，以不同的方式对产品对象进行创建。但是对于同一个具体工厂而言，无论使用哪个工厂方法，所创建的产品类型均要相同。重载的工厂方法结构图如下：

![image-20220330140550674](.\images\image-20220330140550674.png)

在抽象工厂中声明了多个重载的工厂方法，在具体工厂中实现这些工厂方法，这些方法可以包含不同的业务逻辑，以满足产品对象的多样化创建需求。

### 工厂方法的隐藏

**目的：**为了进一步简化客户端的使用

**实现：**在工厂类中直接调用产品类的业务方法，客户端无须调用工厂方法创建产品对象，**直接使用工厂对象即可调用所创建的产品对象中的业务方法。**

![image-20220330220412834](https://gitee.com/snailjw/article-images/raw/master/typora/202203311135388.png)

`LoggerFactory`代码修改如下：

```java
public interface LoggerFactory {
    /**
     * 创建日志
     * @return 日志抽象类
     */
    public Logger createLogger();

    /**
     * 在工厂中实现写日志的逻辑
     */
    public default void writeLog(){
        Logger logger = this.createLogger();
        logger.writeLog();
    }
}
```

客户端代码：

```java
public class Client {
    public static void main(String[] args) {
        // 此处注意bean.xml配置文件中的class中配置的具体类以免出错。
        LoggerFactory factory = (LoggerFactory) XMLUtil.getBean("fileLogger");
        //此处直接用过工厂调用，而不是具体的客户端
        factory.writeLog();
    }
}
```

### 工厂方法模式优/缺点与使用环境

#### 工厂方法模式优点：

1. 工厂方法用来创建客户所需要的产品，同时还**向客户隐藏了哪种具体产品类将被实例化这一细节**。
2. 能够**让工厂自主确定创建何种产品对象**，而如何创建这个对象的细节则完全封装在具体工厂内部。
3. 在系统中加入新产品时，**完全符合开闭原则**。

#### 工厂方法模式缺点

1. 系统中**类的个数将成对增加**，在一定程度上增加了系统的复杂度，会给系统带来一些额外的开销。
2. **增加了系统的抽象性和理解难度。**

#### 工厂方法模式适用环境

在以下情况可以考虑使用工厂方法模式：

1. **客户端不知道它所需要的对象的类**（客户端不需要知道具体产品类的类名，只需要知道所对应的工厂即可，具体产品对象由具体工厂类创建）。
2. **抽象工厂类通过其子类来指定创建哪个对象。**

## 抽象工厂模式

### 产品等级结构与产品族

1. **产品等级结构：** **产品等级结构即产品的继承结构**，如：一个抽象类是电视机，其子类包括海尔电视，海信电视，TCL电视，则抽象电视机与具体品牌的电视机之间构成了一个产品等级结构，抽象电视机是父类，而具体品牌的电视机试其子类。
2. **产品族：**在抽象工厂模式中，**产品族是指由同一个工厂生产的位于不同产品等级结构中的一组产品。**如下图示：

![image-20220330203354559](https://gitee.com/snailjw/article-images/raw/master/typora/202203311135957.png)

### 抽象工厂模式概述

**模式动机：**

* 当系统所提供的工厂生产的具体产品并不是一个简单的对象，而是多个位于不同产品等级结构、属于不同类型的具体产品时就可以使用抽象工厂模式。
* 抽象工厂模式是所有形式的工厂模式中最为抽象和最具一般性的一种形式。

**抽象工厂模式的定义：**

> **抽象工厂模式：**提供一个创建一系列相关或相互依赖对象的接口，而无需指定他们具体的类。

关于定义的说明：

* 抽象工厂模式属于**对象创建型模式**。
* 又称为工具（kit）模式
* 抽象工厂模式中的具体工厂不只是创建一种产品，它负责创建一族产品。
* 当一个工厂等级结构可以创建出分属于不同产品等级结构的一个产品族中的所有对象时，抽象工厂模式比工厂方法模式更为简单、更有效率。

### 抽象工厂模式结构与实现

#### 抽象工厂模式结构

抽象工厂模式结构如图示：

![image-20220330213008648](https://gitee.com/snailjw/article-images/raw/master/typora/202203311135682.png)

**抽象工厂模式的结构：**

抽象工厂模式包含以下4个角色：

* **AbstractFactory（抽象工厂）：**它声明了一组用户创建一族产品的方法，每一个方法对应一种产品。
* **ConcreteFactory（具体工厂）：**它实现了在抽象工厂中声明的创建产品的方法，生成一组具体产品，这些产品构成了一个产品族，每一个产品都位于某个产品等级结构中。
* **AbstractProduct（抽象产品）：**它为每种产品声明接口，在抽象产品中声明了产品所具有的业务方法。
* **ConcreteProduct（具体产品）：**它定义具体工厂生产的具体产品对象，实现抽象产品接口中声明的业务方法。

#### 抽象工厂模式实现

典型的抽象工厂类代码：

```java
public interface AbstractFactory {
    public AbstractProductA createProductA(); //工厂方法一
    public AbstractProductB createProductB(); //工厂方法二
    ……
}
```

典型的具体工厂类代码：

```java
public class ConcreteFactory1 implements AbstractFactory {
    //工厂方法一
    public AbstractProductA createProductA() {
        return new ConcreteProductA1();
    }
    //工厂方法二
    public AbstractProductB createProductB() {
        return new ConcreteProductB1();
    }
    ……
}
```

### 抽象工厂模式应用实例：

某软件公司要开发一套界面皮肤库，可以对基于Java的桌面软件进行界面美化。用户在使用时可以通过菜单来选择皮肤，不同的皮肤将提供视觉效果不同的按钮、文本框、组合框等界面元素，例如春天(Spring)风格的皮肤将提供浅绿色的按钮、绿色边框的文本框和绿色边框的组合框，而夏天(Summer)风格的皮肤则提供浅蓝色的按钮、蓝色边框的文本框和蓝色边框的组合框，其结构示意图如下图所示：

![image-20220330213743595](https://gitee.com/snailjw/article-images/raw/master/typora/202203311135711.png)

根据如上描述，结构图如下：

![image-20220330213846205](https://gitee.com/snailjw/article-images/raw/master/typora/202203311135014.png)

具体代码实现参看项目模块：`abstract-factory-pattern`

### 开闭性原则的倾斜性

在抽象工厂模式中**增加**新的**产品族**很**方便**，但是**增加**新的**产品等级结构**很**麻烦**，抽象工厂模式的这种性质称为**开闭原则的倾斜性**。

* **增加产品族：**

  **对于增加新的产品族**，抽象工厂模式很好地**支持**了**开闭原则**，只需要增加具体产品并对应增加一个新的具体工厂，对已有代码无需做任何修改。

* **增加新的产品等级结构：**

  **对于增加新的产品等级结构**，需要修改所有的工厂角色，包括抽象工厂类，在所有的工厂类中都需要增加生产新产品的方法，**违背了开闭原则**。

正因为以上原则，因此要求设计人员在设计之初就能够考虑全面，不会在设计完成之后再向系统中增加新的产品等级结构，也不会删除已有的产品等级结构。

### 抽象工厂模式的优缺点与适用环境

#### 模式优点

1. **隔离了具体类的生成**，使得客户端并不需要知道什么被创建。
2. 当一个产品族中的多个对象被设计成一起工作时，它**能够保证客户端始终只使用同一个产品族中的对象。**
3. **增加新的产品族很方便**，无须修改已有系统，**符合开闭原则**。

#### 模式缺点

1. **增加新的产品等级结构麻烦**，需要对原有系统进行较大的修改，甚至需要修改抽象层代码，这显然会带来较大的不便，**违背了开闭原则**。

#### 模式适用环境

1. 一个系统**不应当依赖于产品类实例如何被创建、组合和表达的细节**。
2. 系统中有多于一个的产品族，但**每次只使用其中某一产品族**。
3. **属于同一个产品族的产品将在一起使用**，这一约束必须在系统的设计中体现出来。
4. **产品等级结构稳定**，在设计完成之后不会向系统中增加新的产品等级结构或者删除已有的产品等级结构。

### 本章小结

1. 在抽象工厂模式中，产品等级结构即产品的继承结构，产品族是指由同一个工厂生产的位于不同产品等级结构中的一组产品。
2. 抽象工厂模式提供一个创建一系列相关或相互依赖对象的接口，而无须指定它们具体的类。抽象工厂模式是一种对象创建型模式。
3. 抽象工厂模式包含抽象工厂、具体工厂、抽象产品和具体产品4个角色。其中，抽象工厂声明了一组用于创建一族产品的方法，每一个方法对应一种产品；具体工厂实现了在抽象工厂中声明的创建产品的方法，生成一组具体产品，这些产品构成了一个产品族，每一个产品都位于某个产品等级结构中；抽象产品为每种产品声明接口，在抽象产品中声明了产品所具有的业务方法；具体产品定义具体工厂生产的具体产品对象，实现抽象产品接口中声明的业务方法。
4. 抽象工厂模式的优点主要是隔离了具体类的生成，使得客户端并不需要知道什么被创建；当一个产品族中的多个对象被设计成一起工作时，它能够保证客户端始终只使用同一个产品族中的对象；增加新的产品族很方便，无须修改已有系统，符合开闭原则。其缺点主要是增加新的产品等级结构麻烦，需要对原有系统进行较大的修改，甚至需要修改抽象层代码，违背了开闭原则
5. 抽象工厂模式适用于以下环境：一个系统不应当依赖于产品类实例如何被创建、组合和表达的细节；系统中有多于一个的产品族，而每次只使用其中某一产品族；属于同一个产品族的产品将在一起使用，这一约束必须在系统的设计中体现出来；产品等级结构稳定，在设计完成之后不会向系统中增加新的产品等级结构或者删除已有的产品等级结构。
6. 抽象工厂模式以一种倾斜的方式来满足开闭原则。对于增加新的产品族，抽象工厂模式很好地支持了开闭原则；对于增加新的产品等级结构，需要修改所有的工厂角色，违背了开闭原则。







## 附录：

百度云盘下载

链接：https://pan.baidu.com/s/1or3BVso4Cu638ZMRu-A75g 密码：d8e6

![image-20220330202635590](https://gitee.com/snailjw/article-images/raw/master/typora/202203311135346.png)

